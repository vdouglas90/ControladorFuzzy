/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

/**
 *
 * @author Luiz Bezerra
 */
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class GraficoSistema extends ApplicationFrame implements ActionListener {

    public TimeSeriesCollection collection1;
    private TimeSeriesCollection collection2;
    public TimeSeries series1, series2, series3, series4, series5, series6;
    private int largura;
    private int altura;
    private Timer t;
    private double TENSAO, SP, ERRO, NIVELT1, NIVELT2, DE;
    private static GraficoSistema instance;
    private Color corFundo = new Color(241, 246, 250);

    public static GraficoSistema getInstance(int largura, int altura) {
        if (instance == null) {
            instance = new GraficoSistema("", largura, altura);
        }
        return instance;
    }

    /**
     * Constructs a new demonstration application.
     *
     * @param title the frame title.
     */
    private GraficoSistema(String title, int Largura, int Altura) {

        super(title);
        largura = Largura;
        altura = Altura;
        CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis("Tempo (hh:mm:ss)"));

        series1 = new TimeSeries("Nível T1 (cm)", Millisecond.class);
        series2 = new TimeSeries("Nível T2 (cm)", Millisecond.class);
        series3 = new TimeSeries("Tensão (V)", Millisecond.class);
        series4 = new TimeSeries("Erro", Millisecond.class);
        series5 = new TimeSeries("SP", Millisecond.class);
        series6 = new TimeSeries("Deriv. Erro", Millisecond.class);

        collection1 = new TimeSeriesCollection();
        collection2 = new TimeSeriesCollection();

        collection1.addSeries(series1);
        collection1.addSeries(series2);
        collection1.addSeries(series5);

        collection2.addSeries(series3);
        collection2.addSeries(series4);
        collection2.addSeries(series6);


        NumberAxis rangeAxis1 = new NumberAxis("Nível (cm)");
        NumberAxis rangeAxis2 = new NumberAxis("Ações");

        rangeAxis1.setAutoRangeIncludesZero(true);
        rangeAxis1.setRange(0, 30);

        rangeAxis2.setAutoRangeIncludesZero(true);

        XYPlot subplot = new XYPlot(
                this.collection1, null, rangeAxis1, new StandardXYItemRenderer());

        XYPlot subplot2 = new XYPlot(
                this.collection2, null, rangeAxis2, new StandardXYItemRenderer());

        subplot.setBackgroundPaint(Color.lightGray);
        subplot.setDomainGridlinePaint(Color.white);
        subplot.setRangeGridlinePaint(Color.white);

        subplot2.setBackgroundPaint(Color.lightGray);
        subplot2.setDomainGridlinePaint(Color.white);
        subplot2.setRangeGridlinePaint(Color.white);
        setRenderer(subplot);
        setRenderer(subplot2);

        plot.add(subplot);
        plot.add(subplot2);

        JFreeChart chart = new JFreeChart("", plot);

        chart.setBorderPaint(Color.black);
        chart.setBorderVisible(true);
        chart.setBackgroundPaint(corFundo);

        chart.getLegend().setBackgroundPaint(corFundo);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.BLUE);
        plot.setRangeGridlinePaint(Color.GREEN);

        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 120s o range no eixo X

        JPanel panel = new JPanel(new BorderLayout());


        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

        chartPanel.setPreferredSize(new java.awt.Dimension(largura, altura));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(panel);

    }


    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    public void actionPerformed(ActionEvent e) {

        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addValores(NIVELT1, NIVELT2, TENSAO, SP, SP, DE);
            }
        };
        t = new Timer(500, action);
        t.start();

    }

    public void addValores(double nivelT1, double nivelT2, double tensao, 
            double erro, double sp, double de) {
        this.TENSAO = tensao;
        this.SP = sp;
        this.ERRO = erro;
        this.NIVELT1 = nivelT1;
        this.NIVELT2 = nivelT2;
        this.DE = de;


        series1.add(new Millisecond(), nivelT1);
        series2.add(new Millisecond(), nivelT2);
        series3.add(new Millisecond(), tensao);
        series4.add(new Millisecond(), erro);
        series5.add(new Millisecond(), sp);
        series6.add(new Millisecond(), de);
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {

        GraficoSistema demo = new GraficoSistema("Dynamic Data Demo 3", 1024, 550);

        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);



    }

    private void setRenderer(XYPlot plot) {
        final XYItemRenderer renderer = plot.getRenderer();

        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer itemRenderer = (StandardXYItemRenderer) renderer;
            itemRenderer.setSeriesStroke(0, new BasicStroke(2.0f));
            itemRenderer.setSeriesStroke(1, new BasicStroke(2.0f));
            itemRenderer.setSeriesStroke(2, new BasicStroke(2.0f));
            itemRenderer.setSeriesStroke(3, new BasicStroke(2.0f));
            itemRenderer.setSeriesStroke(4, new BasicStroke(2.0f));
        }
    }
}
