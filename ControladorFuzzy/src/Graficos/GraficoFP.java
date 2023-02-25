package Graficos;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

public class GraficoFP extends ApplicationFrame {

    private XYSeriesCollection dataset;
    public int tipo;
    public double a, b, c, d;
    
    private JFreeChart chart;
    private ChartPanel chartPanel;
    
    public GraficoFP(String title, int tipo, double a, double b, double c, double d, XYSeries series) {
        super(title);

        this.tipo = tipo;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        //this.series = new XYSeries(title);
        
        this.dataset = new XYSeriesCollection();
        chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
    }
    
    public XYSeriesCollection createDataset(XYSeries series) {
        //if (tipo == 0) {
        //    funcTriangular(series, a, b, c);
        //} else if (tipo == 1) {
        //    funcTrapezoidal(series, a, b, c, d);
        //}

        //funcTrapezoidal(series, -1, 2, 3, 4);
        //funcTriangular(series2, 3, 5, 7);
        //funcTriangular(series3, 5, 7, 8);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    public JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", // chart title
                "X", // x axis label
                "Y", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
                );

        chart.setBackgroundPaint(Color.white);

        NumberAxis rangeAxis1 = new NumberAxis("");
        rangeAxis1.setRange(0, 1.05);

        XYPlot plot = (XYPlot) chart.getPlot();

        plot.setBackgroundPaint(Color.lightGray);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setRangeAxis(rangeAxis1);

        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setShapesFilled(true);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }


    public void funcTriangular(XYSeries series, double a, double b, double c) {
        series.add(a, 0);
        series.add(b, 1);
        series.add(c, 0);
        try {
            dataset.getSeries(series.getKey());
        } catch (Exception e) {
            dataset.addSeries(series);
        }
    }

    public void funcTrapezoidal(XYSeries series, double a, double b, double c, double d) {
        series.add(a, 0);
        series.add(b, 1);
        series.add(c, 1);
        series.add(d, 0);
        try {
            dataset.getSeries(series.getKey());
        } catch (Exception e) {
            dataset.addSeries(series);
        }
    }

    public JFreeChart getChart() {
        return chart;
    }
    
    public ChartPanel getChartPanel() {
        return chartPanel;
    }
}
