/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.thread;

import MyClasses.FoodData;
import MyClasses.Worker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vita
 */
public class ManagerClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ManagerClientThread(InetAddress addr) throws java.lang.NullPointerException{
        try {
            socket = new Socket(addr, 8093);
        } catch (IOException e) {
            System.err.println("IOException |?|?|?|?|?|??|");
        }
        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
            start();
        } catch (IOException e) {
                System.err.println("IO EXCEPTION");
        }
    }
    
    public boolean addEmployee(int id, String name, String surname, double salary) throws IOException{
        out.println("{\"method\":"+"\"addEmployee\""+",\"params\":[\""+id+"\",\""+name+"\",\""+surname+"\",\""+salary+"\"]}");
        String str = in.readLine();
        return str.equals("true");
    }
    
    public boolean addCategory(String name) throws IOException{
        out.println("{\"method\":"+"\"addCategory\""+",\"params\":["+name+"]}");
        String str = in.readLine();
        return str.equals("true");
    }
    
    public boolean addDish(int id, String category, String name, String description, double price) throws IOException{
        out.println("{\"method\":"+"\"addDish\""+",\"params\":[\""+id+"\",\""+category+"\",\""+name+"\",\""+description+"\",\""+price+"\"]}");
        String str = in.readLine();
        return str.equals("true");
    }
    
    /*public void deleteCategory(String name){
        out.println("{\"method\":"+"\"deleteCategory\""+",\"params\":[\""+name+"\"]}");
    }*/
    public void deleteDish(String name){
        out.println("{\"method\":"+"\"deleteDish\""+",\"params\":[\""+name+"\"]}");
        
    }
    public void deleteDish(int id){
        out.println("{\"method\":"+"\"deleteDishId\""+",\"params\":[\""+id+"\"]}");
        
    }
    
    public void deleteEmployee(int id){
        out.println("{\"method\":"+"\"deleteEmployee\""+",\"params\":[\""+id+"\"]}");
    }
    
    public void changePass(char[] pass){
        String s = "";
        for(int i = 0; i<pass.length; i++){
            s+=pass[i];
        }
        out.println("{\"method\":"+"\"changePass\""+",\"params\":["+s+"]}");
    }
    public boolean checkPass(char[] pass) throws IOException{
        String s = "";
        for(int i = 0; i<pass.length; i++){
            s+=pass[i];
        }
        out.println("{\"method\":"+"\"checkPass\""+",\"params\":[\""+s+"\"]}");
        return in.readLine().equals("true");
    }
    
    public String[] getAllCategories() throws IOException{
        out.println("{\"method\":"+"\"getAllCategories\""+",\"params\":[]}");
        String response = in.readLine();
        Gson gson = new Gson();
        return gson.fromJson(response, String[].class);        
    }
    public List<Worker> getEmployees() throws IOException{
        out.println("{\"method\":"+"\"getEmployees\""+",\"params\":[]}");
        String response = in.readLine();
        Gson gson = new Gson();
        return gson.fromJson(response, new TypeToken<List<Worker>>(){}.getType());        
    }
    
    public List<FoodData> getFood(String category)throws IOException{
        out.println("{\"method\":"+"\"getFood\""+",\"params\":[\""+category+"\"]}");
        String response = in.readLine();
        Gson gson = new Gson();
        return gson.fromJson(response, new TypeToken<List<FoodData>>(){}.getType());        
    }
    public List<FoodData> getAllFood()throws IOException{
        out.println("{\"method\":"+"\"getAllFood\""+",\"params\":[]}");
        String response = in.readLine();
        //JOptionPane.showMessageDialog(null, response);
        Gson gson = new Gson();
        return gson.fromJson(response, new TypeToken<List<FoodData>>(){}.getType());        
    }
    
    public Map<Integer, Date> getHistory() throws IOException{
        out.println("{\"method\":"+"\"getHistory\""+",\"params\":[]}");
        String response = in.readLine();
        //JOptionPane.showMessageDialog(null, response);
        Gson gson = new Gson();
        return gson.fromJson(response, new TypeToken< Map<Integer, Date>>(){}.getType());        
    
    }
    
    public Map<Integer, Worker> getWorkers() throws IOException{
        out.println("{\"method\":"+"\"getWorkers\""+",\"params\":[]}");
        String response = in.readLine();
        //JOptionPane.showMessageDialog(null, response);
        Gson gson = new Gson();
        return gson.fromJson(response, new TypeToken< Map<Integer, Worker>>(){}.getType());        
    
    }
    public void closeThread(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Socket not closed");
        }
    }
    public void closeServer(){
        out.println("{\"method\":"+"\"closeServer\""+",\"params\":[]}");
    }
}
