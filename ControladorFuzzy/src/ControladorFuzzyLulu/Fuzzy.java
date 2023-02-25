/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorFuzzyLulu;

import Interfaces.ConfigFuzzy;
import Interfaces.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MacBook
 */
public class Fuzzy {

    private List<Regras> regras;
    private double acumulador;
    private ConfigFuzzy configFuzzy = new ConfigFuzzy();
    private Principal p;

    public Fuzzy(List<Regras> regras) {
        this.regras = regras;
        this.acumulador = 0;
    }

    public double validarRegras(double erro, double derivada) {
        if (configFuzzy.radio_mamdani.isSelected() || p.getMandani()) {
            return mamdani(erro, derivada);
        } else {
            return sugeno(erro, derivada);
        }
    }

    //Verificar quais regras sao validas para as entradas
    public double mamdani(double erro, double derivada) {
        double maiorAmplitude = 0;
        double menorAmplitude = 0;
        List<Regras> listaRegras = new ArrayList<Regras>();
        List<Double> amplitudesMinimas = new ArrayList<Double>();
        List<Double> pontosMedios = new ArrayList<Double>();

        /*
        if(derivada > 5){
        derivada = 5;
        }*/

        double amplitude1 = 0.1;
        double amplitude2 = 0.1;
        //Iterar lista de regras
        for (int i = 0; i < regras.size(); i++) {
            //Testar input 1
            if (regras.get(i).getFpEntradas1().inRange(erro)) {
                double superior;
                double inferior;

                //Definir de qual lado da funcao de pertinencia esta o erro
                if (erro < regras.get(i).getFpEntradas1().getParam2()) {
                    superior = regras.get(i).getFpEntradas1().getParam2();
                    inferior = regras.get(i).getFpEntradas1().getParam1();
                } else {
                    superior = regras.get(i).getFpEntradas1().getParam3();
                    inferior = regras.get(i).getFpEntradas1().getParam2();
                }
                //Calculo da amplitude
                amplitude1 = (erro - inferior) / (superior - inferior);
                System.out.println("Amplitude 1: " + amplitude1);
            } else if (regras.get(i).getConexao().equals("AND")) {
                continue;
            }


            //Testar input 2
            System.out.println("Derivada: " + derivada);

            if (derivada == 0) {//&& regras.get(i).getConexao().equals("AND")
                derivada = 1;
            }

            if (regras.get(i).getFpEntradas2().inRange(derivada)) {
                double superior;
                double inferior;

                //Definir de qual lado da funcao de pertinencia esta o erro
                if (derivada < regras.get(i).getFpEntradas2().getParam2()) {
                    superior = regras.get(i).getFpEntradas2().getParam2();
                    inferior = regras.get(i).getFpEntradas2().getParam1();
                } else {
                    superior = regras.get(i).getFpEntradas2().getParam3();
                    inferior = regras.get(i).getFpEntradas2().getParam2();
                }
                //Calculo da amplitude
                amplitude2 = (derivada - inferior) / (superior - inferior);
                System.out.println("Amplitude 2: " + amplitude2);
            } else {
                continue;
            }
            System.out.println("Regra: " + regras.get(i).toString());

            //Salvar menor amplitude para esta regra
            //AND
            if (regras.get(i).getConexao().equals("AND")) {
                menorAmplitude = Math.min(amplitude1, amplitude2);
            } //OR
            else {
                menorAmplitude = Math.max(amplitude1, amplitude2);
            }
            listaRegras.add(regras.get(i));

            //Agregacao
            amplitudesMinimas.add(menorAmplitude);
            pontosMedios.add(regras.get(i).getFpSaidas().getParam2());


        }//Fim for

        //Desfuzzyficar
        double numerador = 0.0;
        double denominador = 0.0;
        double saida = 0.0;
        for (int i = 0; i < amplitudesMinimas.size(); i++) {
            double amp1 = amplitudesMinimas.get(i);
            double ponto = pontosMedios.get(i);
            numerador = numerador + (amp1 * ponto);
            denominador = denominador + amplitudesMinimas.get(i);
        }
        if (denominador == 0) {
            saida = 0;
        } else {
            saida = numerador / denominador;
        }

        //this.acumulador = this.acumulador + saida;
        System.out.println("Sinal de saida: " + saida);
        //System.out.println("Acumulador: "+acumulador);
        return saida;
    }
    //Fim funcao

    public double sugeno(double erro, double derivada) {

        double menorAmplitude = 0;
        double A = 0.01;
        double B = 0.02;
        double C = 0.03;
        double somatorioNumerador = 0;
        double somatorioDenominador = 0;
        double amplitude1 = 0.1;
        double amplitude2 = 0.1;
        double saida = 0;
        //Iterar lista de regras
        for (int i = 0; i < regras.size(); i++) {
            //Testar input 1
            if (regras.get(i).getFpEntradas1().inRange(erro)) {
                double superior;
                double inferior;

                //Definir de qual lado da funcao de pertinencia esta o erro
                if (erro < regras.get(i).getFpEntradas1().getParam2()) {
                    superior = regras.get(i).getFpEntradas1().getParam2();
                    inferior = regras.get(i).getFpEntradas1().getParam1();
                } else {
                    superior = regras.get(i).getFpEntradas1().getParam3();
                    inferior = regras.get(i).getFpEntradas1().getParam2();
                }
                //Calculo da amplitude
                amplitude1 = (erro - inferior) / (superior - inferior);
                //System.out.println("Amplitude 1: "+amplitude1);
            } else if (regras.get(i).getConexao().equals("AND")) {
                continue;
            }


            //Testar input 2
            //System.out.println("Derivada: "+derivada);

            if (derivada == 0) {//&& regras.get(i).getConexao().equals("AND")
                derivada = 0.1;
            }

            if (regras.get(i).getFpEntradas2().inRange(derivada)) {
                double superior;
                double inferior;

                //Definir de qual lado da funcao de pertinencia esta o erro
                if (derivada < regras.get(i).getFpEntradas2().getParam2()) {
                    superior = regras.get(i).getFpEntradas2().getParam2();
                    inferior = regras.get(i).getFpEntradas2().getParam1();
                } else {
                    superior = regras.get(i).getFpEntradas2().getParam3();
                    inferior = regras.get(i).getFpEntradas2().getParam2();
                }
                //Calculo da amplitude
                amplitude2 = (derivada - inferior) / (superior - inferior);
                //System.out.println("Amplitude 2: "+amplitude2);
            } else {
                continue;
            }
            System.out.println("Regra: " + regras.get(i).toString());

            //Salvar menor amplitude para esta regra
            //AND
            if (regras.get(i).getConexao().equals("AND")) {
                menorAmplitude = Math.max(amplitude1, amplitude2);
            } //OR
            else {
                menorAmplitude = Math.max(amplitude1, amplitude2);
            }

            /*
            somatorioNumerador += (A*amplitude1 + B*amplitude2 + C);
            System.out.println("Somatorio Numerador: "+somatorioNumerador);
            somatorioDenominador += menorAmplitude;
            System.out.println("Somatorio Denominador: "+somatorioDenominador);
            result += somatorioNumerador*(menorAmplitude/somatorioDenominador);
             */

            somatorioDenominador += menorAmplitude;
            double numerador;
            if (somatorioDenominador != 0) {
                numerador = menorAmplitude / somatorioDenominador;
            } else {
                numerador = 0;
            }

            double auxSaida = (regras.get(i).getFpSaidas().getParam2() * amplitude1 + regras.get(i).getFpSaidas().getParam2() * amplitude2 + regras.get(i).getFpSaidas().getParam2()) * numerador;
            somatorioNumerador += (regras.get(i).getFpSaidas().getParam2() * amplitude1 + regras.get(i).getFpSaidas().getParam2() * amplitude2 + regras.get(i).getFpEntradas2().getParam2()) * numerador;
        }//Fim for

        saida = somatorioNumerador;
        //System.out.println("Sinal de saida: "+saida);
        return saida;

    }
}
