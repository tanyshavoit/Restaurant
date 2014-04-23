/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kitchen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Vita
 */
public class KitchenThread extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public KitchenThread(InetAddress addr) {
        try {
            socket = new Socket(InetAddress.getByName(null), 8093);

        } catch (IOException e) {
            System.err.println("IOException |?|?|?|?|?|??|");
        }
        try {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream())), true);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            
            start();

        } catch (IOException e) {

        }
    }

    public void sendToKitchen() throws IOException {
        out.println("{\"method\":" + "\"kitchen\"" + ",\"params\":[]}");
        boolean flag = false;
       /*String str = in.readLine();
        if (!str.equals("null")) {
            KitchenPrinter1.printer(this).print(str+"\n______________________________");
        }*/
        String str = in.readLine();
        if (!str.equals("null")) {
            flag = true;
            //KitchenPrinter1.printer(this).print(str+"\n______________________________");
        }
        while (!str.equals("null")) {
            KitchenPrinter1.printer(this).print(str);
            out.println("{\"method\":" + "\"kitchen\"" + ",\"params\":[]}");
            str = in.readLine();
        }
        if (flag)
             KitchenPrinter1.printer(this).print("\n______________________________");
       // else KitchenPrinter1.printer(this).print(str);
    }
}
