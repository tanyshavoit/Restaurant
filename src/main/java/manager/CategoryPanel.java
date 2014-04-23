/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import com.mycompany.restaurant.UserMainFrame;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author tanysha
 */
public class CategoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form CategoryPanel
     */
    
    boolean edit = false;
    int lenth;
    String[] items;
    String path=System.getProperty("user.dir");
    private static CategoryPanel reference;
    //private static final Object[][] rowData = {{1, "pizza", "chese", 100}};
    private static final Object[] columnNames = { "Id","Name", "Discription", "Price"};
    Object[][] dishes ;
    Vector<Object> dish = new Vector<Object>();
    private DefaultTableModel model;
    int itt=0;
    ArrayList<Integer> massOfChangesRow = new ArrayList<Integer>();
    
   private CategoryPanel() {
       model = new DefaultTableModel(){  
        Class[] types = new Class [] {  
            //COL. TYPES ARE HERE!!!  
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class  
        };  
          
        @Override  
        public Class getColumnClass(int columnIndex) {  
            return types [columnIndex];  
        }  
    };  
       model.setColumnIdentifiers(columnNames);
       model.setDataVector(null, columnNames);
         try {
         items = Manager.getThread().getAllCategories(); 
        
         
         }
          catch (IOException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setBackground(Color.getHSBColor(276,9,95));
        addCategory.setText("  Add category");
        deleteCategory.setText("  Delete category");
        int l =0;
        nameOfcategory.setText(category.getSelectedItem().toString());
        model.setDataVector(null, columnNames);
      try {
          
          int i=0; int j=0;
          l=Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length;
          
          dishes=new Object[Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length][4];
          while(i<Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length){
               
               //dish.removeAllElements();
              
               dishes[i][0]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getId();
               dishes[i][1]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getName();
               dishes[i][2]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getCompound();
               dishes[i][3]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getPrice(); 
               
              
               i++;
               
          }
          
          
         }
          catch (IOException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.getTableHeader().setReorderingAllowed(false); 
        model.setDataVector(dishes, columnNames);
       // menu.setEnabled(false);
       
       
        
    }
   	

     public static CategoryPanel getReference(){
         if (reference==null){
             reference = new CategoryPanel();
         }
         return reference;
     }
     
     public JComboBox getCategory(){
         return category;
     }
     public void setTextOfLable(String newText ){
     nameOfcategory.setText( newText);
     }
     
     public void addNewRow(Vector<Object> newDish){
         model.addRow(newDish);
     }
     public String getSelectCategory(){
          return category.getSelectedItem().toString();
     }
     public void addCategoryItem(String name){
         category.addItem(name);
     }
     public void deleteCategoryItem(String name){
         category.removeItem(name);
     }
     public String[] getItemsOfCategory(){
         return items;
     }
     public void nameOfCategory(){
         nameOfcategory.setText(category.getSelectedItem().toString());
     }
     public boolean isCategory(String name){
       int i=0;
       while(i<category.getItemCount()){
           if(category.getItemAt(i) == null ? name == null : category.getItemAt(i).equals(name)) {
               return true;
           } 
           i++;
       }
       return false;
    }
     public void setModelData( Object[][] selectDishes){
          model.setDataVector(selectDishes, columnNames);
     }
     public void doLastItem(){
         category.setSelectedIndex(category.getItemCount()-1);
     }
     public void writingData(){
        
         
        model.setDataVector(null, columnNames);
      try {
          int i=0; 
          dishes=new Object[Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length][4];
          while(i<Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length){
               
               //dish.removeAllElements();
              
               dishes[i][0]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getId();
               dishes[i][1]=Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getName();
               dishes[i][2]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getCompound();
               dishes[i][3]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getPrice(); 
               
              
               i++;
               
          }
          
          
         }
          catch (IOException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.setDataVector(dishes, columnNames);
        edit=false;
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        category = new javax.swing.JComboBox(items);
        addCategory = new javax.swing.JButton();
        nameOfcategory = new javax.swing.JLabel();
        search_dish = new javax.swing.JButton();
        add_dish = new javax.swing.JButton();
        delete_dish = new javax.swing.JButton();
        deleteCategory = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu = menu = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if((colIndex== 0)||(colIndex== 1))
                {
                    return false;
                }
                return true;
            }
        };
        saveChanges = new javax.swing.JButton();

        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        addCategory.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\add.png"));
        addCategory.setText("Add category");
        addCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });

        nameOfcategory.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        nameOfcategory.setForeground(new java.awt.Color(0, 0, 51));
        nameOfcategory.setText("Name of category");

        search_dish.setBackground(new java.awt.Color(204, 255, 204));
        search_dish.setText("search");
        search_dish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_dishActionPerformed(evt);
            }
        });

        add_dish.setBackground(new java.awt.Color(204, 204, 255));
        add_dish.setText("add");
        add_dish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_dishActionPerformed(evt);
            }
        });

        delete_dish.setBackground(new java.awt.Color(255, 204, 204));
        delete_dish.setText("delete");
        delete_dish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_dishActionPerformed(evt);
            }
        });

        deleteCategory.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\delete16.png"));
        deleteCategory.setText("Delete category");
        deleteCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryActionPerformed(evt);
            }
        });

        menu.setModel(model);
        menu.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                menuInputMethodTextChanged(evt);
            }
        });
        menu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                menuPropertyChange(evt);
            }
        });
        menu.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                menuVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(menu);

        saveChanges.setBackground(new java.awt.Color(255, 255, 204));
        saveChanges.setText("save");
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nameOfcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(deleteCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(category, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_dish, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(search_dish, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(delete_dish, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(nameOfcategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(addCategory)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCategory)
                        .addGap(54, 54, 54)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_dish)
                    .addComponent(search_dish)
                    .addComponent(delete_dish)
                    .addComponent(saveChanges))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryActionPerformed
        // TODO add your handling code here:
         CommandHelper.getReference().getCommandandDo(new CShowAddCateF());
    }//GEN-LAST:event_addCategoryActionPerformed

    private void add_dishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_dishActionPerformed
        // TODO add your handling code here:
        new AddDishFrame().setVisible(true);
    }//GEN-LAST:event_add_dishActionPerformed

    private void deleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryActionPerformed
        // TODO add your handling code here:
        CommandHelper.getReference().getCommandandDo(new CShowDeleteCateF());
    }//GEN-LAST:event_deleteCategoryActionPerformed

    private void delete_dishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_dishActionPerformed
        // TODO add your handling code here:
        new DeleteDishFrame().setVisible(true);
    }//GEN-LAST:event_delete_dishActionPerformed

    private void search_dishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_dishActionPerformed
        // TODO add your handling code here:
        new SearchDishFrame().setVisible(true);
    }//GEN-LAST:event_search_dishActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
       int l =0;
        nameOfcategory.setText(category.getSelectedItem().toString());
        model.setDataVector(null, columnNames);
      try {
          int i=0; int j=0;
          l=Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length;
          dishes=new Object[Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length][4];
          while(i<Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length){
               
               //dish.removeAllElements();
              
               dishes[i][0]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getId();
               dishes[i][1]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getName();
               dishes[i][2]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getCompound();
               dishes[i][3]= Manager.getThread().getFood(category.getSelectedItem().toString()).get(i).getPrice(); 
               
              
               i++;
               
          }
          
          
         }
          catch (IOException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.setDataVector(dishes, columnNames);
        for (int i=0; i<l; i++){
            for (int j=0; j<4; j++)         // зверніть увагу на відсутність фігурної дужки
                 System.out.print (dishes[i][j]+"    ");//даний рядок відноситься до масиву по j
            System.out.println ();          //виводимо символи переводу каретки і нового рядка
                                            //після кожного проходження стовпцевих елементів рядка
        }
    }//GEN-LAST:event_categoryActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        // TODO add your handling code here:
     Object[][] obj ;
     Object[] options = {"Yes",
                    "No "};
   int n = JOptionPane.showOptionDialog(null,
    "Do you want to save changes?",
    "saving...",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.WARNING_MESSAGE,
    null,     //do not use a custom Icon
    options,  //the titles of buttons
    options[0]); //default button title
   if(n==0){
       System.out.println("edit = "+edit);
       if(edit==true){//тупий метод але що поробиш:(
            try {
               int j=0; int i=0; int l=Manager.getThread().getFood(category.getSelectedItem().toString()).toArray().length;
                   Object [][] b = new Object[4][l];
                   while(j<l){
                       b[0][j]=menu.getValueAt(j, 0);
                       b[1][j]=menu.getValueAt(j, 1);
                       b[2][j]=menu.getValueAt(j, 2);
                       b[3][j]=menu.getValueAt(j, 3);
                       j++;
                   }
           while(i<l){
         Manager.getThread().deleteDish(Integer.parseInt(menu.getValueAt(i, 0).toString())); 
      
       //  Manager.getThread().addDish(Integer.parseInt(b[0][i].toString()),category.getSelectedItem().toString(), b[1][i].toString(), b[2][i].toString(),Double.parseDouble(b[3][i].toString()));// і цу якийсь бред лалдіводал
         i++;
           }
           int k=0;
           while(k<l){
               Manager.getThread().addDish(Integer.parseInt(b[0][k].toString()),category.getSelectedItem().toString(), b[1][k].toString(), b[2][k].toString(),Double.parseDouble(b[3][k].toString()));
               k++;
           }
         }
          catch (IOException ex) {
            Logger.getLogger(CategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
            writingData();
       }
   }
   else {writingData();}
              
    }//GEN-LAST:event_saveChangesActionPerformed

    private void menuVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_menuVetoableChange
        // TODO add your handling code here:
       /// System.out.println(" Щось змінюється  =)");
    }//GEN-LAST:event_menuVetoableChange

    private void menuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_menuPropertyChange
        // TODO add your handling code here:
        
       if(menu.isEditing()){edit=true;}
      System.out.println(edit);
    }//GEN-LAST:event_menuPropertyChange

    private void menuInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_menuInputMethodTextChanged
        // TODO add your handling code here:
      
      
    }//GEN-LAST:event_menuInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCategory;
    private javax.swing.JButton add_dish;
    private javax.swing.JComboBox category;
    private javax.swing.JButton deleteCategory;
    private javax.swing.JButton delete_dish;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable menu;
    private javax.swing.JLabel nameOfcategory;
    private javax.swing.JButton saveChanges;
    private javax.swing.JButton search_dish;
    // End of variables declaration//GEN-END:variables
}
