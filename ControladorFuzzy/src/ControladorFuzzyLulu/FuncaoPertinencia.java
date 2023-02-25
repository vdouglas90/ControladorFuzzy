/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorFuzzyLulu;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Luiz Bezerra
 */
public class FuncaoPertinencia {

    double param1, param2, param3, param4;
    double rangeMax, rangeMin;
    private String tipo;
    private String nome;
    private ChartPanel chartPanel;
    private XYSeriesCollection dataSet;
    private XYSeries series;
    private double amplitude = 0;
    private int id;
    private int idEntrada;
    private Entrada ent;
    private Saida sai;
    
    public FuncaoPertinencia(double param1, double param2, double param3, double param4, double rangeMin, double rangeMax, String tipo, String nome) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.rangeMax = rangeMax;
        this.rangeMin = rangeMin;
        this.tipo = tipo;
        this.nome = nome;
        this.series = new XYSeries(nome);
    }

    public FuncaoPertinencia(String nome) {
        this.nome = nome;
    }

    public FuncaoPertinencia() {
        this.nome = nome;
    }

    public double getRangeMin() {
        return rangeMin;
    }

    public double getRangeMax() {
        return rangeMax;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getParam1() {
        return param1;
    }

    public double getParam2() {
        return param2;
    }

    public double getParam3() {
        return param3;
    }

    public double getParam4() {
        return param4;
    }

    public void addFP() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeFP() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String toString() {
        return getNome();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FuncaoPertinencia other = (FuncaoPertinencia) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    public XYSeries getSeries() {
        return series;
    }

    public void setSeries(XYSeries series) {
        this.series = series;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setParam1(double param1) {
        this.param1 = param1;
    }

    public void setParam2(double param2) {
        this.param2 = param2;
    }

    public void setParam3(double param3) {
        this.param3 = param3;
    }

    public void setParam4(double param4) {
        this.param4 = param4;
    }

    public void setRangeMax(double rangeMax) {
        this.rangeMax = rangeMax;
    }

    public void setRangeMin(double rangeMin) {
        this.rangeMin = rangeMin;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean inRange(Double value) {
        if (value <= param3 && value >= param1) {
            return true;
        } else {
            return false;
        }
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public Entrada getEnt() {
        return ent;
    }

    public void setEnt(Entrada ent) {
        this.ent = ent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Saida getSai() {
        return sai;
    }

    public void setSai(Saida sai) {
        this.sai = sai;
    }
    
     public ChartPanel gerarGrafico() {
        if (chartPanel == null) {
            dataSet = new XYSeriesCollection();
            series = new XYSeries(nome);

            series.add(getParam1(), 0);
            series.add(getParam2(), 1);
            series.add(getParam3(), 0);

            dataSet.addSeries(series);
            JFreeChart chart = ChartFactory.createXYLineChart(
                    nome, // The chart title
                    "", // x axis label
                    "", // y axis label
                    dataSet, // The dataset for the chart
                    PlotOrientation.VERTICAL,
                    false, // Is a legend required?
                    false, // Use tooltips
                    false // Configure chart to generate URLs?
                    );

            chartPanel = new ChartPanel(chart);
            chartPanel.repaint();
        }
        
        return chartPanel;
    }
    
}
