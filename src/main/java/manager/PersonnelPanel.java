/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tanysha
 */
public class PersonnelPanel extends javax.swing.JPanel {

    /**
     * Creates new form PersonnelPanel
     */
    boolean isInPricePoint = false;
    private static final Object[] columnNames = { "Id","Name", "Surname", "Salary"};
    private DefaultTableModel model;
    Object[][] personal ;
    private static PersonnelPanel reference;
    boolean edit;
    private PersonnelPanel() {
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
       model.setDataVector(personal, columnNames);
        
        initComponents();
        setBackground(Color.getHSBColor(276,9,95));
        writingData();
        personnel.getTableHeader().setReorderingAllowed(false); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        personnel = personnel = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if((colIndex== 0)||(colIndex== 1)||(colIndex== 2))
                {
                    return false;
                }
                return true;
            }
        };
        add_person = new javax.swing.JButton();
        search_person = new javax.swing.JButton();
        delete_person = new javax.swing.JButton();
        actoinWithP = new javax.swing.JLabel();
        all = new javax.swing.JButton();
        save = new javax.swing.JButton();

        personnel.setModel(  model 

        );
        personnel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                personnelPropertyChange(evt);
            }
        });
        personnel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personnelKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(personnel);

        add_person.setBackground(new java.awt.Color(204, 204, 255));
        add_person.setText("add");
        add_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_personActionPerformed(evt);
            }
        });

        search_person.setBackground(new java.awt.Color(204, 255, 204));
        search_person.setText("search");
        search_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_personActionPerformed(evt);
            }
        });

        delete_person.setBackground(new java.awt.Color(255, 204, 204));
        delete_person.setText("delete");
        delete_person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_personActionPerformed(evt);
            }
        });

        actoinWithP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        actoinWithP.setText("Personnel");

        all.setBackground(new java.awt.Color(255, 255, 153));
        all.setText("all");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(184, 254, 254));
        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actoinWithP)
                .addGap(332, 332, 332))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_person, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(search_person, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(delete_person, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(all, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(actoinWithP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_person)
                    .addComponent(search_person)
                    .addComponent(delete_person)
                    .addComponent(all)
                    .addComponent(save))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents
   public static PersonnelPanel getReference(){
         if (reference==null){
             reference = new PersonnelPanel();
         }
         return reference;
     }
   public void setTextOfLable(String newText){
       actoinWithP.setText(newText);
   }
   public void setModelData(Object[][] newData){
       model.setDataVector(newData, columnNames);
   }
   public void writingData (){
       model.setDataVector(null, columnNames);
       try {
          int i=0; 
          //Manager.getThread().addEmployee(999678687, "terte","sfsdf", 55);
          System.out.print(Manager.getThread().getEmployees().toArray().length);
          personal=new Object[Manager.getThread().getEmployees().toArray().length][4];
          while(i<Manager.getThread().getEmployees().toArray().length){
               
               //dish.removeAllElements();
              
               personal[i][0]= Manager.getThread().getEmployees().get(i).getId();
               personal[i][1]=Manager.getThread().getEmployees().get(i).getName();
               personal[i][2]= Manager.getThread().getEmployees().get(i).getSurname();
               personal[i][3]= Manager.getThread().getEmployees().get(i).getSalary(); 
               
              
               i++;
               
          }
           
         
         }
          catch (IOException ex) {
            Logger.getLogger(PersonnelPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.setDataVector(personal, columnNames);
        edit=false;  
   }
    public void addNewRow(Vector<Object> newPersonnel){
         model.addRow(newPersonnel);
     }
    private void delete_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_personActionPerformed
        // TODO add your handling code here:
        new DeletePersFrame().setVisible(true);
    }//GEN-LAST:event_delete_personActionPerformed

    private void add_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_personActionPerformed
        // TODO add your handling code here:
        new AddPersonnelFrame().setVisible(true);
    }//GEN-LAST:event_add_personActionPerformed

    private void search_personActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_personActionPerformed
        // TODO add your handling code here:
        
        new SearchPersFrame().setVisible(true);
    }//GEN-LAST:event_search_personActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
        // TODO add your handling code here:
        actoinWithP.setText("Personnel");
        writingData ();
    }//GEN-LAST:event_allActionPerformed

    private void personnelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_personnelPropertyChange
        // TODO add your handling code here:
         if( personnel.getEditingRow()>=0){edit=true;}
      System.out.println(edit);
      
       
        
           
    }//GEN-LAST:event_personnelPropertyChange

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
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
               int j=0; int i=0; int l=Manager.getThread().getEmployees().toArray().length;
                   Object [][] b = new Object[4][l];
                   while(j<l){
                       b[0][j]=personnel.getValueAt(j, 0);
                       b[1][j]=personnel.getValueAt(j, 1);
                       b[2][j]=personnel.getValueAt(j, 2);
                       b[3][j]=personnel.getValueAt(j, 3);
                       j++;
                   }
           while(i<l){
         Manager.getThread().deleteEmployee(Integer.parseInt(personnel.getValueAt(i, 0).toString()));
      
       //  Manager.getThread().addDish(Integer.parseInt(b[0][i].toString()),category.getSelectedItem().toString(), b[1][i].toString(), b[2][i].toString(),Double.parseDouble(b[3][i].toString()));// і цу якийсь бред лалдіводал
         i++;
           }
           int k=0;
           while(k<l){
               Manager.getThread().addEmployee(Integer.parseInt(b[0][k].toString()), b[1][k].toString(), b[2][k].toString(), Double.parseDouble(b[3][k].toString()));
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
    }//GEN-LAST:event_saveActionPerformed

    private void personnelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personnelKeyTyped
        // TODO add your handling code here:
        
       char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) &(c != KeyEvent.VK_BACK_SPACE)&(c != KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_personnelKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actoinWithP;
    private javax.swing.JButton add_person;
    private javax.swing.JButton all;
    private javax.swing.JButton delete_person;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable personnel;
    private javax.swing.JButton save;
    private javax.swing.JButton search_person;
    // End of variables declaration//GEN-END:variables
}
