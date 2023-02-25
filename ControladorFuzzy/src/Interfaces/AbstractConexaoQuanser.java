package Interfaces;

import Quanser.ConexaoQuanser;
import br.ufrn.dca.controle.QuanserClientException;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Luiz Bezerra
 */
public abstract class AbstractConexaoQuanser extends Timer {

    public AbstractConexaoQuanser(int delay, ActionListener listener) {
        super(delay, listener);
        
    }

    protected void conectarQuanser() throws QuanserClientException {
        ConexaoQuanser.getInstance().conectarQuanser();
    }

    protected static void escreverQuanser(int canal, double valor) {
        try {
            ConexaoQuanser.getInstance().getQuanserClient().write(canal, valor);
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
    }

    protected static double lerQuanser(int canal) {
        double valor = -1;
        try {
            valor = ConexaoQuanser.getInstance().getQuanserClient().read(canal);
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
        return valor;
    }

    /**
     * M�todo de truncamento de decimais
     *
     * @param d
     * @param places
     * @return
     */
    public static final double truncateDouble(double d, int places) {
        return Math.round(d * Math.pow(10, places)) / Math.pow(10, places);
    }

    /**
     * M�todo de truncamento de decimais
     *
     * @param d
     * @param places
     * @return
     */
    public static final double truncateFloat(float d, int places) {
        return Math.round(d * Math.pow(10, places)) / Math.pow(10, places);
    }

    public static final double truncateLong(float d, int places) {
        return Math.round(d * Math.pow(10, places)) / Math.pow(10, places);
    }
}