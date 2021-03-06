/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restaurant;

import Clients.ClientThread;
import DBofrestaurant.Food;
import MyClasses.FoodData;
import MyClasses.Order;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import server.SessionInfo;

/**
 *
 * @author Vita
 */

public class CustomerFrame extends javax.swing.JFrame {
    Color colorOrder = new Color(240,240,240);
    private final ClientThread ct;
    private final int tableId;
    private final int userId;
    private DefaultListModel listModel;
    private double totalSum = 0;//замінити на щось нормальне
    private List<FoodData> order;
    private List<Order> newOrder = new ArrayList<Order>();
    /**
     * Creates new form CustomerFrame
     */
    String path = System.getProperty("user.dir");

    public CustomerFrame(ClientThread ct, int tableId, int userId) {
        this.tableId = tableId;
        this.ct = ct;
        this.userId = userId;

        this.getContentPane().setBackground(Color.getHSBColor(276, 9, 95));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(path + "\\src\\main\\java\\manager\\image\\pizza.png"));
        initComponents();
        menu.setBackground(Color.getHSBColor(276, 9, 95));
        optionPanel.setBackground(Color.getHSBColor(276, 9, 95));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setLocation(screenWidth / 2 - this.getWidth() / 2, screenHeight / 2 - this.getHeight() / 2);
        try {
            loadMenu();
            order = (List<FoodData>) ct.getOrder(tableId);//(List<FoodData>) Food.convert(SessionInfo.dborder.getFoods(tableId));//server request
            for (int i = 0; i<order.size(); i++){
            if(order.get(i)==null)
            order.remove(i);
            }
            //JOptionPane.showMessageDialog(null, order.size());
            loadOrder();
            
            //allFood = this.ct.getAllFood();
        } catch (IOException ex) {
            Logger.getLogger(CustomerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listModel = new DefaultListModel();
        orderList = new javax.swing.JList(listModel);
        orderList = new javax.swing.JList();
        tableNumber = new javax.swing.JLabel();
        optionPanel = new javax.swing.JPanel();
        send = new javax.swing.JButton();
        print = new javax.swing.JButton();
        mainFrame = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        close = new javax.swing.JButton();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzeria");
        setResizable(false);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        orderList.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        orderList.setModel(listModel);
        orderList.setName(""); // NOI18N
        orderList.setSelectionBackground(new java.awt.Color(255, 255, 102));
        jScrollPane1.setViewportView(orderList);

        tableNumber.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        tableNumber.setText(" ");
        tableNumber.setText("Table "+ this.tableId);

        send.setBackground(new java.awt.Color(153, 255, 204));
        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(153, 255, 204));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        mainFrame.setBackground(new java.awt.Color(153, 255, 204));
        mainFrame.setText("Main Frame");
        mainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainFrameActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(153, 255, 204));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        close.setBackground(new java.awt.Color(153, 255, 204));
        close.setText("Close Table");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        total.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        total.setText("Total amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(143, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(tableNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainFrameActionPerformed
        // TODO add your handling code here:
        new MainFrame(ct).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_mainFrameActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedIndex = orderList.getSelectedIndex();
        if (selectedIndex != -1) {
            FoodData item = (FoodData) listModel.getElementAt(selectedIndex);
            if(orderList.getCellRenderer().getListCellRendererComponent(orderList, item, selectedIndex, true, false).getBackground().equals(this.colorOrder))
               return;        
            totalSum -= item.getPrice();
            total.setText("Total amount        " + totalSum);
            newOrder.remove(orderList.getSelectedIndex()-order.size());
        
            listModel.remove(orderList.getSelectedIndex());
            }
    }//GEN-LAST:event_deleteActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        new PaymentFrame(ct, this.tableId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        double s = 0;
        for(int i = 0; i<order.size(); i++){
            if (order.get(i)==null)
                continue;
            s+=order.get(i).getPrice();
        }
        double j = SessionInfo.totalMoney[this.userId];
        j+=this.totalSum;
        j-=s;
        SessionInfo.totalMoney[userId]=j;
        ct.addOrder(this.newOrder);
        //хулі не працюєш?
        //int idServer = SessionInfo.getReference().serverNumber(tableId);
        new MainFrame(ct).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sendActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        File f = new File("ServerCheck.txt");
        try {
            if(!f.exists())
            f.createNewFile();
            PrintWriter out2 = new PrintWriter(f);
            out2.println("Check");
            out2.println("Table "+ this.tableId);
            out2.println();
                    out2.println();
                            out2.println("Vitanyanzhela pizzeria");
              out2.println();
                    out2.println();
           List<FoodData> foodOrder = (List<FoodData>) ct.getOrder(tableId);
            double total = 0;
            for (int i = 0; i < foodOrder.size(); i++) {
                if (foodOrder.get(i) != null) {
                   String s = foodOrder.get(i).toString();
                    out2.println(s);
                    total += foodOrder.get(i).getPrice();
                }
            }
            out2.println();
            out2.println();
            out2.println();
            out2.println("____________");
            out2.println("total amount" + total);
            out2.println("please, pay your server");
            out2.println("7% - " + total * 0.07);
            out2.println("10% - " + total * 0.1);
            out2.println("Please, come again!");
             out2.println("---------Thank you!---------");
            
            out2.close();
        } catch (IOException ex) {
        }
            
            new MainFrame(ct).setVisible(true);
            this.dispose();
    }//GEN-LAST:event_printActionPerformed

    private void loadOrder() {
        if (order.isEmpty()) {
            return;
        }
        for (int i = 0; i < order.size(); i++) {
            if(order.get(i)==null){
                order.remove(i);
                continue;
            }
            this.listModel.addElement(order.get(i));
            this.orderList.setCellRenderer(new MyListCellThing());
            totalSum += order.get(i).getPrice();
            this.total.setText("Total amount        " + totalSum);
            
        }
    }

    private void loadMenu() throws IOException {
        Font font = new Font("Verdana", Font.PLAIN, 12);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
        menu.setLayout(new BorderLayout());
        String[] categories = ct.getAllCategories();
        for (int j = 0; j < categories.length; j++) {
            JPanel jp = new JPanel();
            jp.setLayout(new java.awt.GridLayout(4, 7));
            //jp.setPreferredSize(new Dimension(100,100
            List<FoodData> food = ct.getFood(categories[j]);
            for (int i = 0; i < food.size(); i++) {
                final JLabel jl = new JLabel();
                jl.setText(food.get(i).getName());
                JPanel jpItem = new JPanel();
                jpItem.add(jl);
                //final JLabel price = new JLabel();
                //price.setText(""+food.get(i).getPrice());
                //jpItem.add(price);
                final FoodData foodItem = food.get(i);
                //jpItem.setPreferredSize(new Dimension(10,10));
                jpItem.setBackground(new java.awt.Color(/*153, 255, 153*/255,255,153));
                jpItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                jpItem.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        addItem(foodItem);
                    }
                });
                jp.add(jpItem);
            }

            tabbedPane.addTab(categories[j], jp);
        }
        //JPanel jp2 = new JPanel();
        //tabbedPane.addTab("Beverages", jp2);
        menu.add(tabbedPane);
    }

    private void addItem(FoodData food) {
         //JPanel jp = (JPanel) evt.getComponent();
        //this.listModel.addElement(jl.getText().toString());
        this.listModel.addElement(food);
        totalSum += food.getPrice();
        this.total.setText("Total amount        " + totalSum);
        newOrder.add(new Order(food.getId(), 1, this.tableId));
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new CustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainFrame;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JList orderList;
    private javax.swing.JButton print;
    private javax.swing.JButton send;
    private javax.swing.JLabel tableNumber;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
private class MyListCellThing extends JLabel implements ListCellRenderer {

    public MyListCellThing() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Assumes the stuff in the list has a pretty toString
        setText(value.toString());
        if(index<order.size())
        setBackground(new Color(240,240,240));
        else if (isSelected)
            setBackground(new Color(0,230,230));
        else setBackground(new Color(255,255,255));
        setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        return this;
    }
}
}
