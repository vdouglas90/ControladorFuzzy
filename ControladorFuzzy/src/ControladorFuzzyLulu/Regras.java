/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorFuzzyLulu;

/**
 *
 * @author Luiz Bezerra
 */
public class Regras {

    int tipoRegras;
    FuncaoPertinencia fpEntradas1;
    FuncaoPertinencia fpEntradas2;
    FuncaoPertinencia fpSaidas;
    public static final int OR = 2;
    public static final int AND = 1;
    private String conexao;
    private int id;

    public Regras(int tipoRegras, FuncaoPertinencia fpEntradas1, FuncaoPertinencia fpEntradas2, FuncaoPertinencia fpSaidas) {
        this.tipoRegras = tipoRegras;
        this.fpEntradas1 = fpEntradas1;
        this.fpEntradas2 = fpEntradas2;
        this.fpSaidas = fpSaidas;
    }

    public Regras() {
    }

    @Override
    public String toString() {
        return "Se " + fpEntradas1.getNome() + getTipo() + fpEntradas2.getNome() + " Então " + fpSaidas.getNome();
    }

    public String getTipo() {
        if (tipoRegras == OR) {
            return " OU ";
        } else {
            return " E ";
        }

    }

    public FuncaoPertinencia getFpEntradas1() {
        return fpEntradas1;
    }

    public void setFpEntradas1(FuncaoPertinencia fpEntradas1) {
        this.fpEntradas1 = fpEntradas1;
    }

    public FuncaoPertinencia getFpEntradas2() {
        return fpEntradas2;
    }

    public void setFpEntradas2(FuncaoPertinencia fpEntradas2) {
        this.fpEntradas2 = fpEntradas2;
    }

    public FuncaoPertinencia getFpSaidas() {
        return fpSaidas;
    }

    public void setFpSaidas(FuncaoPertinencia fpSaidas) {
        this.fpSaidas = fpSaidas;
    }

    public int getTipoRegras() {
        return tipoRegras;
    }

    public void setTipoRegras(int tipoRegras) {
        this.tipoRegras = tipoRegras;

        if (tipoRegras == 1) {
            conexao = "AND";
        } else if (tipoRegras == 2) {
            conexao = "OR";
        }

    }

    public String getConexao() {
        return conexao;
    }

    public void setConexao(String conexao) {
        this.conexao = conexao;
        if (conexao == "AND") {
            tipoRegras = 1;
        } else if (conexao == "OR") {
            tipoRegras = 2;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
