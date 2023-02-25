/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quanser;

import br.ufrn.dca.controle.QuanserClient;
import br.ufrn.dca.controle.QuanserClientException;

/**
 *
 * @author Rafael
 */
public class ControleLRL {

    private static ControleLRL controleLRL;
    private static QuanserClient quanserClient;
    private String endereco = "localhost";
    private int porta = 20081;

    public QuanserClient getQuanserClient() {
        if (quanserClient == null) {
            quanserClient = conectarQuanser();
        }

        return quanserClient;
    }

    public QuanserClient conectarQuanser() {
        try {
            quanserClient = new QuanserClient(getEndereco(), getPorta());
            return quanserClient;
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ControleLRL() {
    }

    public static ControleLRL getInstance() {
        if (controleLRL == null) {
            controleLRL = new ControleLRL();
        }

        return controleLRL;
    }

    public void configurar(String endereco, int porta) {
        setEndereco(endereco);
        setPorta(porta);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
}
