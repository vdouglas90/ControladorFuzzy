/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorFuzzyLulu;

import Graficos.GraficoSistema;
import Interfaces.AbstractConexaoQuanser;
import Interfaces.Principal;
import Quanser.QuanserClientException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MacBook
 */
public class ControladorFuzzy extends AbstractConexaoQuanser {

    static ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                runFuzzy();

            } catch (QuanserClientException ex) {
                Logger.getLogger(ControladorFuzzy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    private static Fuzzy fuzzy;
    private static double setPoint;
    private static double dt = 0.1;
    private static double erroanterior;
    private static double memoria;
    private static double tensao;
    private static double erro, de;
    private static double nivelT1;
    private static double nivelT2;
    private static GraficoSistema plot;
    private static Principal p;
    private static double erroMedio = 0;
    private static double derivErroMedio = 0;
    private static double temporizador = 0;
    private static boolean flag = false;

    @SuppressWarnings("static-access")
    public ControladorFuzzy(Fuzzy fuzzy, double setPoint, int delay, GraficoSistema plot, Principal p) {
        super(delay, actionListener);

        this.fuzzy = fuzzy;
        this.setPoint = setPoint;
        this.memoria = 0;
        erroanterior = 0;
        memoria = 0;
        this.plot = plot;
        this.p = p;
    }

    public static void runFuzzy() throws QuanserClientException {
        setPoint = 10;
        if (temporizador == 1000) {
            setPoint = setPoint + 5;
        }

        if (temporizador == 3000) {
            Thread.interrupted();
            temporizador = 0;
            Salvar();
        }

        nivelT1 = lerQuanser(0) * 6.25;
        nivelT2 = lerQuanser(1) * 6.25;
        erro = setPoint - nivelT1;
        de = (erro - erroanterior) / dt;
        erroanterior = erro;

        memoria += fuzzy.validarRegras(erro, de);
        tensao = memoria;

        if ((tensao <= 0) && nivelT1 <= 3) {
            tensao = 0;
        }
        if ((tensao > 0) && nivelT1 >= 27.5) {
            tensao = -1;
        }

        escreverQuanser(0, tensao);
        System.out.println("Tensao: " + tensao);

        plot.addValores(nivelT1, nivelT2, tensao, erro, setPoint, de);
        atualizarLog();

        erroMedio = erroMedio + erro;
        derivErroMedio = derivErroMedio + de;

        temporizador = temporizador + 0.1;

    }

    public static double getDe() {
        return de;
    }

    public static void setDe(double de) {
        ControladorFuzzy.de = de;
    }

    public static double getErro() {
        return erro;
    }

    public static void setErro(double erro) {
        ControladorFuzzy.erro = erro;
    }

    public static double getNivelT1() {
        return nivelT1;
    }

    public static void setNivelT1(double nivelT1) {
        ControladorFuzzy.nivelT1 = nivelT1;
    }

    public static double getNivelT2() {
        return nivelT2;
    }

    public static void setNivelT2(double nivelT2) {
        ControladorFuzzy.nivelT2 = nivelT2;
    }

    public static double getSetPoint() {
        return setPoint;
    }

    public static void setSetPoint(double setPoint) {
        ControladorFuzzy.setPoint = setPoint;
    }

    public static double getTensao() {
        return tensao;
    }

    public static void setTensao(double tensao) {
        ControladorFuzzy.tensao = tensao;
    }

    public static void atualizarLog() {
        p.erro_label.setText(String.valueOf(erro));
        p.de_label.setText(String.valueOf(de));
        p.nivelt1_label.setText(String.valueOf(nivelT1));
        p.nivelt2_label.setText(String.valueOf(nivelT2));
        p.sp_label.setText(String.valueOf(setPoint));
        p.tensao_label.setText(String.valueOf(tensao));
    }

    public static double getDt() {
        return dt;
    }

    public static double getDerivErroMedio() {
        return derivErroMedio;
    }

    public static double getErroMedio() {
        return erroMedio;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void Salvar() {
        Object nomeE = "ERRO";
        Object nomeDE = "DERRO";
        Object nomeTENSAO = "TENSAO";
        Entrada entrada1 = (Entrada) nomeE;
        Entrada entrada2 = (Entrada) nomeDE;
        Saida saida = (Saida) nomeTENSAO;
        File input1 = new File("Input1Otimizado.txt");
        File input2 = new File("Input2Otimizado.txt");

        PrintWriter pw;

        try {
            pw = new PrintWriter(new FileWriter(input1));
            for (int i = 0; i < entrada1.getListaFP().size(); i++) {
                pw.print(entrada1.getListaFP().toArray()[i] + " - ");
                pw.println();
            }

            new PrintWriter(new FileWriter(input2));
            for (int i = 0; i < entrada2.getListaFP().size(); i++) {
                pw.print(entrada2.getListaFP().toArray()[i] + " - ");
                pw.println();
            }

            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
