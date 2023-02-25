/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmogenetico;

import java.util.Vector;

/**
 *
 * @author Victor
 */
public class Individuo implements Comparable<Individuo> {
private double avaliacao;
    private double adaptabilidade;
    private double adaptabilidadeRelativa;


public Vector genesErro;
public Vector genesDerivadaErro;
public Vector genesTensao;

   public Individuo(){
       
       genesErro = new Vector();
       genesDerivadaErro = new Vector();
       genesTensao = new Vector();
   } 


    /**
     * @return the avaliacao
     */
    public double getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * @return the adaptabilidade
     */
    public double getAdaptabilidade() {
        return adaptabilidade;
    }

    /**
     * @param adaptabilidade the adaptabilidade to set
     */
    public void setAdaptabilidade(double adaptabilidade) {
        this.adaptabilidade = adaptabilidade;
    }

    /**
     * @return the adaptabilidadeRelativa
     */
    public double getAdaptabilidadeRelativa() {
        return adaptabilidadeRelativa;
    }

    /**
     * @param adaptabilidadeRelativa the adaptabilidadeRelativa to set
     */
    public void setAdaptabilidadeRelativa(double adaptabilidadeRelativa) {
        this.adaptabilidadeRelativa = adaptabilidadeRelativa;
    }

    @Override
    public int compareTo(Individuo o) {
        if(this.adaptabilidadeRelativa == o.getAdaptabilidadeRelativa()){
            return 0;}

        if(o.getAdaptabilidade() > this.adaptabilidadeRelativa){
            return 1;}
        else{
            return -1;}
    }

    }



