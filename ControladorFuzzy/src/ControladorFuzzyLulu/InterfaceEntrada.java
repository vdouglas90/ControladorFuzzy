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
interface InterfaceEntrada {

    public int getTipo();

    public int getQtdEntradas();

    public String getNome();

    public List<FuncaoPertinencia> getListaFP();
}
