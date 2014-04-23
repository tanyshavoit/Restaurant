/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBofrestaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @angelika
 */
public class CreationofDB {
       private static Object con; 
       public int k = 0;
    //створюємо нашу базу даних
       
       public CreationofDB(){
           initialization("");
       }
    private void initialization(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
           // PreparedStatement work11 = con.prepareStatement("drop table 'WORKERS';");
            //int result11 = work11.executeUpdate();
            PreparedStatement work = con.prepareStatement("create table if not exists 'WORKERS' ('Id' INTEGER PRIMARY KEY UNIQUE, 'NAME' text UNIQUE, 'SURNAME' text UNIQUE, 'EXPERIENSE' INTEGER, 'POST' text, 'SALARY' REAL);");
            int result = work.executeUpdate();
               work.close();
            PreparedStatement manag = con.prepareStatement("create table if not exists 'MANAGER' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'NAME' text UNIQUE, 'SURNAME' text UNIQUE , 'EXPERIENSE' INTEGER, 'SALARY' REAL);");
            
            int result2 = manag.executeUpdate();
                //manag.close();
            //PreparedStatement men3 = con.prepareStatement("drop table 'MENU';");
            //int result33 = men3.executeUpdate();
            
            PreparedStatement men = con.prepareStatement("create table if not exists 'MENU' ('Id' INTEGER PRIMARY KEY UNIQUE, 'CATEGORY' text, 'NAME' text UNIQUE, 'COMPOUND' text, 'PRICE' REAL);");
            int result3 = men.executeUpdate();
                //men.close();
            //PreparedStatement order7 = con.prepareStatement("drop table 'ORDERS';");
           
            //int result90 = order7.executeUpdate();
            PreparedStatement order = con.prepareStatement("create table if not exists 'ORDERS' ('ID_FOODS' INTEGER, 'AMOUNT' INTEGER, 'ROOM_TABLE' INTEGER);");
           
            int result4 = order.executeUpdate();
              
         work.close();
           
        } catch (ClassNotFoundException e) {
            System.out.println("Не знайшли драйвер JDBC");
            e.printStackTrace();
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }

       public void insertOrder (int id, int amount, int table){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO ORDERS(ID_FOODS,AMOUNT,ROOM_TABLE) VALUES (?,?,?);");
            statement.setInt(1,id);
            statement.setInt(2,amount);
            statement.setInt(3,table);
            int result7 = statement.executeUpdate();
            k=result7;
            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }

      public void DeleteOrder(int table){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM ORDERS WHERE ROOM_TABLE=?");
            statement1.setInt(1, table);
            int result = statement1.executeUpdate();
            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }

    //додаю працівників
     public void insertWorks(int id,String name,String surname, int experiense, String post, double salary){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO WORKERS(ID,NAME,SURNAME,EXPERIENSE,POST,SALARY) VALUES (?,?,?,?,?,?)");
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,surname);
            statement.setInt(4,experiense);
            statement.setString(5,post);
            statement.setDouble(6,salary);
            int result = statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
     //додаю менеджера
     public void insertManager(String name,String surname, int experiense, double salary){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT  INTO MANAGER(NAME,SURNAME,EXPERIENSE,SALARY) VALUES (?,?,?,?)");
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setInt(3,experiense);
            statement.setDouble(4,salary);
            int result5 = statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
     //додаю меню
      public void insertMenu (int id,String category, String name, String compound, double price){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO MENU(ID,CATEGORY,NAME,COMPOUND,PRICE) VALUES (?,?,?,?,?)");
            statement.setInt(1,id);
            statement.setString(2,category);
            statement.setString(3,name);
            statement.setString(4,compound);
            statement.setDouble(5,price);
            int result7 = statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      public void DeleteManagers(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MANAGER WHERE Id=?");
            statement1.setInt(1, id);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      //видалення працівника за айді
        public void DeleteWORKERS(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM WORKERS WHERE Id=?");
            statement1.setInt(1, id);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
        // видалення за ім'ям
        public void DeleteWORKERSofNAME( String name){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM WORKERS WHERE NAME=?");
            statement1.setString(1,name);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      public void DeleteMenu(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MENU WHERE Id=?");
            statement1.setInt(1, id);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      //видалення страви за ім'ям
      public void DeleteMenuOFNAME(String name){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MENU WHERE NAME=?");
            statement1.setString(1,name);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
   
    
public static void main(String[] args) throws SQLException {
    CreationofDB object1 = new CreationofDB();
        //object1.insertWorks(11, "Віта", "Крайнік", 3, "Офіціант", 2200);
        //object1.insertWorks(22, "Таня","Войтович",5,"Офіціант", 5000);
        //object1.insertWorks(33, "Анжела","Семенюк",4,"Офіціант", 4300);
       // object1.insertWorks(564, "Віта","Матвійчук",5,"Офіціант", 4500);
        //object1.DeleteWORKERSofNAME("Тарас");
        
        //object1.insertManager("Віктор", "Тихонов",4,5000);
        //object1.insertManager("Вікторія", "Орлюк",6,7000);
        object1.insertMenu(11,"піца","Гавайська","курка,моцарела", 30);        
        object1.insertMenu(12,"піца","Два сири","пармезан, швейцарський", 20);
        object1.insertMenu(13,"піца","Мрія лижника","помідори, соус барбекю", 30);
        object1.insertMenu(14,"піца","Холодний путін","оливки, перець", 10);
        object1.insertMenu(15,"піца","Веселий математик","горішки, кукуруза, курочка", 30);
        object1.insertMenu(16,"піца","Жизнь-боль","перець чилі, гарячий соус, свинина", 40);
        object1.insertMenu(17,"піца","Біг бен","курка,моцарела", 30);
        object1.insertMenu(18,"піца","Росомаха","оливки, соус А1, м'ясо буйвола", 50);
        object1.insertMenu(19,"напої","Coke","0.5", 10);
        object1.insertMenu(20,"напої","Fanta","0.5", 10);
        object1.insertMenu(21,"напої","Sprite","0.5", 10);
        object1.insertMenu(22,"напої","чай зелений","з жасмином", 20);
        object1.insertMenu(23,"напої","чай чорний","з бергамотом", 20);
        object1.insertMenu(24,"напої","чай фрукт","вишневий", 20);
        object1.insertMenu(25,"напої","Bonaqua","0.5", 10);
        object1.insertMenu(26,"напої","Сік Апельсин","0.5", 30);
        object1.insertMenu(27,"десерти","чізкейк","візьми в холодильнику", 20);
        object1.insertMenu(28,"десерти","пиріг вишн","візьми в холодильнику", 20);
        object1.insertMenu(29,"десерти","торт київ","візьми в холодильнику", 25);
        object1.insertMenu(30,"десерти","шоко фантазія","візьми в холодильнику", 15);
        System.out.print(object1.k);
        }
  }

