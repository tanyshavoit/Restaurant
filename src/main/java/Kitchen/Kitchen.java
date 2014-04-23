/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kitchen;

import Clients.ClientThread;
import com.mycompany.restaurant.Client;
import com.mycompany.restaurant.MainFrame;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vita
 */
public class Kitchen {

    public final KitchenThread ct;

    public Kitchen() throws UnknownHostException {
        InetAddress addr;
        addr = InetAddress.getByName(null);
        ct = new KitchenThread(addr);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final Kitchen c;
                //Client c2;
                try {
                    c = new Kitchen();
                    KitchenPrinter1.printer(c.ct);
                    //c2 = new Client();
                    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
                    exec.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                c.ct.sendToKitchen();
                            } catch (IOException ex) {
                                Logger.getLogger(Kitchen.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }, 0, 1, TimeUnit.SECONDS);
                    //c.ct.sendToKitchen();
                    // new MainFrame(c2.ct).setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Kitchen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.lang.NullPointerException e) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please, start the server");
                    System.exit(0);
                } catch (IOException ex) {
                    Logger.getLogger(Kitchen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
