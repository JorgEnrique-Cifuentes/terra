/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.terra.bean;

import com.sena.terra.dto.CurriculumDto;
import com.sena.terra.interfaces.ICurriculumDao;
import com.sena.terra.utility.Validator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author USER
 */
@Named
@ViewScoped
public class ReporteMb implements Serializable {

    private BarChartModel barModel;

    @Inject
    private ICurriculumDao iCurriculumDao;

    /**
     * Creates a new instance of ReporteMb
     */
    public ReporteMb() {
        super();
    }

    @PostConstruct
    public void init() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Reporte hojas de vida");
        barModel.setLegendPosition("ne");

        final Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Hojas de vida");

        final Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("puntaje");
        yAxis.setMin(0);
        yAxis.setMax(1000);
    }

    private BarChartModel initBarModel() {
        final BarChartModel model = new BarChartModel(); 

        final ChartSeries boys = new ChartSeries();
        final List<CurriculumDto> lista = iCurriculumDao.listAll();

        lista.stream().forEach(action -> {
            boys.setLabel("Vacante ");
            final int puntaje = Validator.isNull(action.getPuntaje()) 
                    ? 0 : Integer.parseInt(action.getPuntaje());
            boys.set(action.getNumeroDocumento(), puntaje);
        });

        model.addSeries(boys);

        return model;
    }

    /**
     * @return the barModel
     */
    public BarChartModel getBarModel() {
        return barModel;
    }

    /**
     * @param barModel the barModel to set
     */
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

}
