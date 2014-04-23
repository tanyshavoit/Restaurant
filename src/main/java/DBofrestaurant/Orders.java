package DBofrestaurant;

import MyClasses.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @angelika
 */
public class Orders {

    private static final String DB_NAME = "sqlite";
    private static final String DB_FILE_NAME = "restaurant.db";
    private static final String DB = "org.sqlite.JDBC";

    private static final String TABLE_NAME = "ORDERS";

    private static final String ID_COLUMN = "ID_FOODS";
    private static final String AMOUNT_COLUMN = "AMOUNT";
    private static final String TABLE_COLUMN = "ROOM_TABLE";

    public Orders() {
        initialization();
        //Connection connection = this.getConnection();
    }

    /**
     *
     * @param room_table
     * @return
     */
    //виводить страви за столиком
    public Iterable<Order> getFoods(int room_table) {
        Connection connection = getConnection();
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT `" + ID_COLUMN + "`, `" + AMOUNT_COLUMN + "`, `" + TABLE_COLUMN + ""
                    + "` FROM " + TABLE_NAME + " WHERE `" + TABLE_COLUMN
                    + "`='" + room_table + "'");
            List<Order> result = convertResultSetToOrderList(resultSet);
            connection.close();
            return result;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Iterable<Order> searchFoods(int id_foods) {

        Connection connection = getConnection();
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE `" + ID_COLUMN + "`='" + id_foods + "'");

            List<Order> result = convertResultSetToNameList(resultSet);

            connection.close();

            return result;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return Collections.emptyList();
    }

    /*public static void main(String[] args) {
     Order or = new Order();
       
     for (Order worker : or) {
     System.out.println(worker); 
     }
            
     /*for (FoodData worker : f.searchDish("Hawaiian")) {
     System.out.println(worker);
     }*/
    private List<Order> convertResultSetToNameList(ResultSet resultSet) {
        List<Order> list = new ArrayList<Order>();

        try {
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt(ID_COLUMN), resultSet.getInt(AMOUNT_COLUMN), resultSet.getInt(TABLE_COLUMN));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param resultSet
     * @return
     */
    private String[] convertResultSetToCategoryArray(ResultSet resultSet) {
        Set<String> list = new TreeSet<String>();

        try {
            while (resultSet.next()) {
                list.add(resultSet.getObject(1) + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convertListToArray(list);
    }

    /**
     *
     * @param list
     * @return
     */
    private String[] convertListToArray(Set<String> list) {
        String[] array = new String[list.size()];
        int index = 0;
        for (String string : list) {
            array[index] = string;
            index++;
        }
        return array;
    }

    /**
     *
     * @param resultSet
     * @return
     */
    private List<Order> convertResultSetToOrderList(ResultSet resultSet) {
        List<Order> list = new ArrayList<Order>();
        try {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(ID_COLUMN));
                order.setAmount(resultSet.getInt(AMOUNT_COLUMN));
                order.setTable(resultSet.getInt(TABLE_COLUMN));

                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void initialization() {
        try {
            Connection con = getConnection();
            PreparedStatement work = con
                    .prepareStatement("create table if not exists 'ORDERS' ('ID_FOODS' INTEGER, '"
                            + AMOUNT_COLUMN
                            + "' INTEGER, '"
                            + TABLE_COLUMN
                            + "' INTEGER);");
            work.executeUpdate();

            work.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("�� ����� SQL �����");
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    private Connection getConnection() {
        try {
            Class.forName(DB);
            Connection connection = DriverManager.getConnection(String.format(
                    "jdbc:%s:%s", DB_NAME, DB_FILE_NAME));
            return connection;
        } catch (SQLException e) {
            System.err.println(DB);
            System.err.println(String.format("jdbc:%s:%s", DB_NAME,
                    DB_FILE_NAME));
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

}
