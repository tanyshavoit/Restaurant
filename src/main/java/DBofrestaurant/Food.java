

package DBofrestaurant;
import MyClasses.FoodData;
import MyClasses.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @angelika 
 */
public class Food {
        private static final String DB_NAME = "sqlite";
	private static final String DB_FILE_NAME = "restaurant.db";
	private static final String DB = "org.sqlite.JDBC";

	private static final String TABLE_NAME = "MENU";
        private static final String ID_COLUMN = "Id";
	private static final String NAME_COLUMN = "NAME";
	private static final String CATEGORY_COLUMN = "CATEGORY";
	private static final String PRICE_COLUMN = "PRICE";
	private static final String COMPOUND_COLUMN = "COMPOUND";
        
        public Food() {
            
		initialization();
	}

	/**
	 * 
	 * @param categorie
	 * @return
	 */
        public static Iterable<FoodData> convert(Iterable<Order> order){
        Food foodClass = new Food();
        List<FoodData> food = new ArrayList<FoodData>();
        Iterator<Order> iterator = order.iterator();
        while(iterator.hasNext()){
            Order item = iterator.next();
            if(item==null)
                continue;
            for(int i = 0; i<item.getAmount(); i++){
                food.add(foodClass.searchDish(item.getId()));
            }
        }
        return food;
    }
        public Iterable<FoodData> getAllFood(){
            Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM " + TABLE_NAME);

			List<FoodData> result = convertResultSetToFoodList(resultSet);

			connection.close();

			return result;
                            } catch (SQLException e1) {
                            e1.printStackTrace();
                            }

                    return Collections.emptyList();
        }
	public Iterable<FoodData> getFood(String categorie) {
		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT `" +ID_COLUMN+"`, `"+ CATEGORY_COLUMN +"`, `"+NAME_COLUMN+"`, `"+COMPOUND_COLUMN+"`, `"+PRICE_COLUMN+""
					+ "` FROM " + TABLE_NAME + " WHERE `" + CATEGORY_COLUMN
					+ "`='" + categorie + "'");

			List<FoodData> result = convertResultSetToFoodList(resultSet);

			connection.close();

			return result;
                            } catch (SQLException e1) {
                            e1.printStackTrace();
                            }

                    return Collections.emptyList();
                    }
        
                public String[] getAllCategories() {
		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT `"+CATEGORY_COLUMN+"` FROM "
					+ TABLE_NAME);

			String[] result = convertResultSetToCategoryArray(resultSet);

			connection.close();

			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return new String[0];
	}

                public Iterable<FoodData> searchDish(String name) {

		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM " + TABLE_NAME+" WHERE `"+CATEGORY_COLUMN+"`='"+name+"'");

			List<FoodData> result = convertResultSetToNameList(resultSet);

			connection.close();

			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return Collections.emptyList();
	}
                public FoodData searchDish(int id) {

		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM " + TABLE_NAME+" WHERE `"+ID_COLUMN+"`='"+id+"'");
                        FoodData result = new FoodData(id, resultSet.getString(CATEGORY_COLUMN),resultSet.getString(NAME_COLUMN),resultSet.getString(COMPOUND_COLUMN),resultSet.getDouble(PRICE_COLUMN));
			connection.close();

			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return null;
	}
        
         public static void main(String[] args) {
       Food f = new Food();
      
       for (FoodData worker : f.searchDish("Піца з куркою")) {//які категорії?
            System.out.println(worker);
            }
          }
            private List<FoodData> convertResultSetToNameList(ResultSet resultSet) {
		List<FoodData> list = new ArrayList<FoodData>();

		try {
			while (resultSet.next()) {
                                FoodData food = new FoodData(resultSet.getInt(ID_COLUMN),resultSet.getString(CATEGORY_COLUMN), resultSet.getString(NAME_COLUMN), resultSet.getString(COMPOUND_COLUMN), resultSet.getDouble(PRICE_COLUMN));
				list.add(food);
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
	private List<FoodData> convertResultSetToFoodList(ResultSet resultSet) {
		List<FoodData> list = new ArrayList<FoodData>();
		try {
			while (resultSet.next()) {
				FoodData food=new FoodData();
                                food.setId(resultSet.getInt(ID_COLUMN));
                                food.setCategory(resultSet.getString(CATEGORY_COLUMN));
				food.setName(resultSet.getString(NAME_COLUMN));
				food.setCompound(resultSet.getString(COMPOUND_COLUMN));
                                food.setPrice(Double.parseDouble(resultSet.getString(PRICE_COLUMN)));
				list.add(food);
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
					.prepareStatement("create table if not exists 'MENU' ('Id' INTEGER PRIMARY KEY UNIQUE, '"
							+ CATEGORY_COLUMN
							+ "' text, '"
							+ NAME_COLUMN
							+ "' text UNIQUE, '"
							+ COMPOUND_COLUMN
							+ "' text, '" + PRICE_COLUMN + "' REAL);");
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
		}catch(ClassNotFoundException e){
                    return null;
                }
	}
}