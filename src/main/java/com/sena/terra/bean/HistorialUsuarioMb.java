package com.sena.terra.bean;

import com.sena.terra.dto.HistorialUsuarioDto;
import com.sena.terra.interfaces.IHistorialUsuarioDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Usuario
 */
@Named(value = "historialUsuario")
@ViewScoped
public class HistorialUsuarioMb implements Serializable {

    @Inject
    private IHistorialUsuarioDao historialUsuario;

    private HistorialUsuarioDto historialUsuarioDto;
    
    private boolean isForm;
    private boolean skip;
    private List<HistorialUsuarioDto> listaHistorialUsuarioDtos;
    private List<HistorialUsuarioDto> filter;

    @PostConstruct
    public void init() {
        setListaHistorialUsuarioDtos(historialUsuario.listAll());
        historialUsuarioDto = new HistorialUsuarioDto();
        
        filter = this.listaHistorialUsuarioDtos;
        setIsForm((boolean) Boolean.FALSE);
    }

    public String onFlowProcess(final FlowEvent event) {
        if (isSkip()) {
            setSkip(false);   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }


    /**
     * Creates a new instance of CurriculumMb
     */
    public HistorialUsuarioMb() {
        super();
    }

    public IHistorialUsuarioDao getHistorialUsuario() {
        return historialUsuario;
    }

    public void setHistorialUsuario(IHistorialUsuarioDao historialUsuario) {
        this.historialUsuario = historialUsuario;
    }



    public HistorialUsuarioDto getHistorialUsuarioDto() {
        return historialUsuarioDto;
    }

    public void setHistorialUsuarioDto(HistorialUsuarioDto historialUsuarioDto) {
        this.historialUsuarioDto = historialUsuarioDto;
    }

    public boolean isIsForm() {
        return isForm;
    }

    public void setIsForm(boolean isForm) {
        this.isForm = isForm;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public List<HistorialUsuarioDto> getListaHistorialUsuarioDtos() {
        return listaHistorialUsuarioDtos;
    }

    public void setListaHistorialUsuarioDtos(List<HistorialUsuarioDto> listaHistorialUsuarioDtos) {
        this.listaHistorialUsuarioDtos = listaHistorialUsuarioDtos;
    }

    public List<HistorialUsuarioDto> getFilter() {
        return filter;
    }

    public void setFilter(List<HistorialUsuarioDto> filter) {
        this.filter = filter;
    }

}
