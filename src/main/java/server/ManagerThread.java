/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * не використовується
 * але шкода було видаляти(((((
 * а так гарно було написано
 * @author Vita
 */
public class ManagerThread extends Thread{
    
    private Socket socket;
    private int serverNumber = 11; //change to database
    
    public ManagerThread(Socket s) throws IOException {
		socket = s;
                start();
    }
    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while(true){
                String str = in.readLine();
                if(str == null)
                    continue;
                Gson gson = new Gson();
                Request jsonRequest = gson.fromJson(str, Request.class);                
                String method = jsonRequest.getMethod();
                
                if(method.equals("addEmployee")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    String name = jsonRequest.getParam(1);
                    String surname = jsonRequest.getParam(2);
                    double salary = Double.parseDouble(jsonRequest.getParam(3));
                    //insert to database
                    out.println("true");
                }    
                else if(method.equals("addCategory")){
                    String name = jsonRequest.getParam(0);
                    //insert to database
                    out.println("true");
                }
                else if(method.equals("changePass")){
                    //SessionInfo.password = jsonRequest.getParam(0);
                    File f = new File("Pass.txt");
                    if (!f.exists()){
                        f.createNewFile();
                    }
                    PrintWriter out2 = new PrintWriter(f);
                    out2.println(jsonRequest.getParam(0));
                    out2.close();
                } 
                else if(method.equals("checkPass")){
                    File f = new File("Pass.txt");
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String pass = br.readLine();
                    System.out.println(pass);
                    fr.close();
                    if(pass.equals(jsonRequest.getParam(0)))
                        out.println("true");
                    else out.println("false");
                } 
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ManagerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
