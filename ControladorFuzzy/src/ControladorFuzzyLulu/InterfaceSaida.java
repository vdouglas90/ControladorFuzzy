/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorFuzzyLulu;

import java.util.List;

/**
 *
 * @author Luiz Bezerra
 */
interface InterfaceSaida {

    public int getTipo();

    public int getQtdSaidas();

    public String getNome();

    public void addSaidas(String nome);

    public List<String> getListaSaidas();

    public void removeSaidas(String nome);

    public List<FuncaoPertinencia> getListaFP();
}
