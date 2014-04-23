/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import Clients.ClientThread;
import com.mycompany.restaurant.MainFrame;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import manager.thread.ManagerClientThread;
import server.Server;

/**
 *
 * @author Vita
 */
public class Manager {
    private static ManagerClientThread ct;
    public static final int maxTables = 111;
    
    private Manager() throws UnknownHostException{
        InetAddress addr;
        addr = InetAddress.getByName(null);
        ct = new ManagerClientThread(addr);					
    }  
    
    public static ManagerClientThread getThread() throws UnknownHostException{
        if(ct==null)
            new Manager();
        return ct; 
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
                ManagerClientThread c;
                //Client c2;
                try {
                     //створюємо потік для менеджера
                    c = Manager.getThread();
                    //пішли фрейми
                    new PasswordFrame().setVisible(true);
                  
                } catch (UnknownHostException ex) {
                    Logger.getLogger(ManagerClientThread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (java.lang.NullPointerException e){
                    JOptionPane.showMessageDialog(new JFrame(), "Please, start the server");
                    System.exit(0);
                }
            }
        });
    }
}

