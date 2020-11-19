/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.facade;

import com.sena.terra.dto.EmpleadoDto;
import com.sena.terra.dto.PqrDto;
import com.sena.terra.config.LoadTerraConfig;
import com.sena.terra.utility.Constant;
import com.sena.terra.utility.Validator;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;

/**
 *
 * @author gaes1
 */
@Stateless
public class SendMailService {

    @Asynchronous
    public void mailResetPassword(final EmpleadoDto empleadoDto, final String password) {
        final Properties props = obtenerPropiedades();
        final Session session = authenticationMail(props);
        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(empleadoDto.getCorreo()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(empleadoDto.getCorreo()));
            message.setSubject("Restablecimiento de contraseña Terra");

            //Envio de texto del correo
            final MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(pageResetPassword(empleadoDto, password), "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);
            //Envio de imagen embebida
            messageBodyPart = new MimeBodyPart();
            final DataSource dataSource = new FileDataSource(
                    LoadTerraConfig.getInstance()
                            .findProperty("path", "path.image").concat("logo_terra.jpeg"));
            messageBodyPart.setDataHandler(new DataHandler(dataSource));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Asynchronous
    public void mailPqr(final PqrDto pqrDto, final EmpleadoDto empleadoDto, final String observacion) {
        final Properties props = obtenerPropiedades();
        final Session session = authenticationMail(props);
        try {
            //Envio de texto del correo
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(empleadoDto.getCorreo()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(empleadoDto.getCorreo()));
            message.setSubject("Solicitud de Pqr #" + pqrDto.getNumeroRadicado());

            //Envio de pagina html 
            final MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(pagePqr(pqrDto, observacion), "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);

            //Envio de imagen embebida
            messageBodyPart = new MimeBodyPart();
            final DataSource dataSource = new FileDataSource(
                    LoadTerraConfig.getInstance()
                            .findProperty("path", "path.image").concat("logo_terra.jpeg"));
            messageBodyPart.setDataHandler(new DataHandler(dataSource));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String pageResetPassword(final EmpleadoDto empleadoDto,
            final String password) {
        final StringBuilder builder = new StringBuilder();
        builder.append(obtenerHtml("template_mail.html").replace(Constant.LOGO_TERRA, "cid:image")
                .replace(Constant.TITULO_CONTENIDO, "Restablecer contraseña")
                .replace(Constant.TEXTO_NOTIFICACION_SOLICITUD, "Hola "
                        .concat(empleadoDto.getPrimerNombre()
                                .concat(" ")
                                .concat(empleadoDto
                                        .getPrimerApellido()).concat(", recibiste "
                                        + "este correo electrónico "
                                        + "porque solicitaste un restablecimiento "
                                        + "de contraseña para tu cuenta de Terra.")))
                .replace(Constant.TEXTO_CAMBIO_INICIO_SESION,
                        "Esta es tu contraseña provisional, se te pedira "
                        + "cambiarla al iniciar sesión por primer vez.")
                .replace(Constant.PASSWORD, "Contraseña: ".concat(password)));
        return builder.toString();
    }

    private String pagePqr(final PqrDto pqrDto, final String observacion) {
        final StringBuilder builder = new StringBuilder();
        builder.append(obtenerHtml("template_generic.html").replace(Constant.LOGO_TERRA, "cid:image")
                .replace(Constant.TITULO_CONTENIDO,
                        "Solicitud Cerrada #".concat(pqrDto.getNumeroRadicado()))
                .replace(Constant.CONTENIDO_MAIL, Validator.isNull(observacion)
                        ? "No se tuvo ninguna observación" : observacion));

        return builder.toString();

    }

    private String obtenerHtml(final String nameHtml) {
        try {
            final File file = new File(LoadTerraConfig.getInstance()
                    .findProperty("path", "path.html").concat(nameHtml));
            return Jsoup.parse(file, "UTF-8").html();
        } catch (IOException e) {
            System.out.println("Error de html" + e);
        }
        return "Sin contenido";
    }

    private Properties obtenerPropiedades() {
        final Properties props = new Properties();
        props.put("mail.smtp.host", LoadTerraConfig.getInstance()
                .findProperty("mail", "mail.host"));
        props.put("mail.smtp.socketFactory.port", LoadTerraConfig.getInstance()
                .findProperty("mail", "mail.port"));
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", LoadTerraConfig.getInstance()
                .findProperty("mail", "mail.port"));
        return props;
    }

    private Session authenticationMail(final Properties properties) {
        return Session.getInstance(properties,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(LoadTerraConfig.getInstance()
                        .findProperty("mail", "mail.address"),
                        LoadTerraConfig.getInstance()
                                .findProperty("mail", "mail.password"));
            }
        });
    }
}
