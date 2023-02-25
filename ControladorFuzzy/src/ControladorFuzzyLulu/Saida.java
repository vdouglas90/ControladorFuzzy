/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorFuzzyLulu;

import Graficos.GraficoFP;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Luiz Bezerra
 */
public class Saida implements InterfaceEntSai {

    public List<FuncaoPertinencia> listaFP = new ArrayList<FuncaoPertinencia>();
    private List<String> listaSaidas = new ArrayList<String>();
    private String nome;
    private int id;
    private double rangeInf;
    private double rangeSup;

    public Saida(String nome) {
        this.nome = nome;
    }

    public Saida() {
    }

    @Override
    public int getTipo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getQtdSaidas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void addSaidas(String nome) {
        listaSaidas.add(nome);
    }

    @Override
    public List<String> getListaSaidas() {
        return listaSaidas;
    }

    @Override
    public void removeSaidas(String nome) {
        listaSaidas.remove(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Saida other = (Saida) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public List<FuncaoPertinencia> getListaFP() {
        return listaFP;
    }

    @Override
    public int getQtdEntradas() {
        return listaSaidas.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FuncaoPertinencia> getListaFuncoes() {
        return listaFP;
    }

    public void setListaFuncoes(List<FuncaoPertinencia> listaFuncoes) {
        this.listaFP = listaFuncoes;
    }

    public double getRangeInf() {
        return rangeInf;
    }

    public void setRangeInf(double rangeInf) {
        this.rangeInf = rangeInf;
    }

    public double getRangeSup() {
        return rangeSup;
    }

    public void setRangeSup(double rangeSup) {
        this.rangeSup = rangeSup;
    }

    public void addPertinencia(FuncaoPertinencia p) {
        listaFP.add(p);
    }
    
        public FuncaoPertinencia getPertinencia(String n) {
        for (int i = 0; i < listaFP.size(); i++) {
            if (listaFP.get(i).getNome().equals(n)) {
                return listaFP.get(i);
            }
        }
        return null;
    }

}
