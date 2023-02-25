/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import Interfaces.AbstractConexaoQuanser;
import Quanser.QuanserClientException;
import java.awt.event.ActionListener;

/**
 *
 * @author Victor
 */
public class AGexec extends AbstractConexaoQuanser {

    public AGexec(int delay, ActionListener listener) {
        super(delay, listener);
    }

    public static void runFuzzy() throws QuanserClientException {
        
    }
}
