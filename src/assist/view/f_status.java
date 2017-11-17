package assist.view;

import assist.controller.statusDAO;
import assist.model.status;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class f_status extends javax.swing.JInternalFrame {

    DefaultTableModel model,model1;
    /**
     * Creates new form status
     */
    public f_status() {
        initComponents();
        totalstatus();
        LoadData();
        
    }

    private void totalstatus(){
        model = new DefaultTableModel(null,new Object[]{"Id","Expenses","Type","Price(Rs)"}){

    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
};
        jTable_finance.setModel(model);
        //for the final table
        double dtotal=0,dgtotal=0,mtotal=0,utotal=0,gtotal=0;
        model1 = new DefaultTableModel(0,0);
        jTable_total.setModel(model1);
        
        statusDAO sDAO = new statusDAO();
        model1.addColumn("");
        model1.addColumn("Total");
        model1.addColumn("Monthly Total");
        ArrayList<status> list = sDAO.fetchData_dtotal();
        for (int i = 0; i<list.size(); i++) {
        dtotal+=list.get(i).getPrice();
        dgtotal=dtotal;
        }
        model1.addRow(new Object[]{"Daily Expenses",dtotal,dgtotal=dtotal*30});
        ArrayList<status> mlist = sDAO.fetchData_mtotal();
        for (int i = 0; i<mlist.size(); i++) {
        mtotal+=mlist.get(i).getPrice();
        }
        model1.addRow(new Object[]{"Monthly Expenses",mtotal,mtotal});
        
        ArrayList<status> ulist = sDAO.fetchData_utotal();
        for (int i = 0; i<ulist.size(); i++) {
        utotal+=ulist.get(i).getPrice();
        }
        model1.addRow(new Object[]{"Unexpexted Expenses",utotal,utotal});
        model1.addRow(new Object[]{"Grand Total","",gtotal=dgtotal+mtotal+utotal});
        Date today = new Date();
        jLabel_date.setText(today.toString());
        

        //jComboBox
        jComboBox_span.addItem("");
        jComboBox_span.addItem("Daily");
        jComboBox_span.addItem("Monthly");
        jComboBox_span.addItem("Unexpectedly");
    }
    private void clearfields(){
        jTextArea_expense.setText("");
        jComboBox_span.setSelectedItem("");
        jTextField_price.setText("00.00");
    }
    
    private void clearTable()
    {
        int count = jTable_finance.getRowCount();
        for(int i=0; i<count;i++)
        {
            model.removeRow(0);
        }
    }
    
    private void LoadData(){
        statusDAO sDAO = new statusDAO();
        ArrayList<status> list = sDAO.fetchData();
        clearTable();
        for (int i = 0; i<list.size(); i++)
        {
                model.addRow(new Object[]{
                list.get(i).getSid(),
                list.get(i).getExpenses(),
                list.get(i).getType(),
                list.get(i).getPrice()                    
            });
        }        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox_span = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_finance = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_price = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_expense = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton_add = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_load = new javax.swing.JButton();
        jButton_clear = new javax.swing.JButton();
        jLabel_id = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_total = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Financial Status");

        jLabel_date.setText("Date");

        jTable_finance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_finance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_financeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_finance);

        jLabel2.setText("Expenses");

        jLabel3.setText("Type");

        jLabel4.setText("Price");

        jTextField_price.setText("00.00");
        jTextField_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_priceKeyTyped(evt);
            }
        });

        jTextArea_expense.setColumns(20);
        jTextArea_expense.setRows(5);
        jScrollPane2.setViewportView(jTextArea_expense);

        jLabel5.setText("Rs");

        jButton_add.setText("Add");
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_cancel.setText("Cancel");
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jButton_load.setText("Load All");
        jButton_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadActionPerformed(evt);
            }
        });

        jButton_clear.setText("Clear All");
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });

        jLabel_id.setText(".");

        jTable_total.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable_total);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_id)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_date, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_load)
                                .addGap(45, 45, 45)
                                .addComponent(jButton_clear))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton_cancel)
                                        .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_update)
                                        .addComponent(jButton_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jComboBox_span, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel5))
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField_price, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(38, 38, 38)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel_date))
                    .addComponent(jLabel_id, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_span, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_add)
                            .addComponent(jButton_update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_cancel)
                            .addComponent(jButton_delete)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_clear)
                    .addComponent(jButton_load))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_financeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_financeMouseClicked
        // TODO add your handling code here:
        int row = jTable_finance.getSelectedRow();
        jLabel_id.setText(jTable_finance.getValueAt(row,0).toString());
        jTextArea_expense.setText(jTable_finance.getValueAt(row,1).toString());
        jComboBox_span.setSelectedItem(jTable_finance.getValueAt(row,2).toString());
        jTextField_price.setText(jTable_finance.getValueAt(row,3).toString());
    }//GEN-LAST:event_jTable_financeMouseClicked

    private void jButton_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadActionPerformed
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_jButton_loadActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        // TODO add your handling code here:
        clearfields();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        String expenses = jTextArea_expense.getText();
        String type =(String) jComboBox_span.getSelectedItem();
        double price = Double.parseDouble(jTextField_price.getText());
        
        status ob = new status();
        ob.setExpenses(expenses);
        ob.setType(type);
        ob.setPrice(price);
        statusDAO sDAO = new statusDAO();//hand over this model class to controller class
        sDAO.insertData(ob);
        JOptionPane.showMessageDialog(null,"An Activity Added.");
        //clear all the fields
        clearfields();
        totalstatus();
        LoadData();
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        // TODO add your handling code here:
        int id =Integer.parseInt(jLabel_id.getText());
        String expenses = jTextArea_expense.getText();
        String type =(String) jComboBox_span.getSelectedItem();
        double price = Double.parseDouble(jTextField_price.getText());  
        status ob = new status();
        ob.setSid(id);
        ob.setExpenses(expenses);
        ob.setType(type);
        ob.setPrice(price);
        statusDAO sDAO = new statusDAO();//hand over this model class to controller class
        sDAO.updateData(ob);
        //clear all the fields
        JOptionPane.showMessageDialog(null,"Selected Activity Edited");
        totalstatus();
        LoadData();
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        // TODO add your handling code here:
        int id =Integer.parseInt(jLabel_id.getText());
        status ab = new status();
        ab.setSid(id);
        statusDAO ob = new statusDAO();
        int deleteoption = JOptionPane.showConfirmDialog(null,"Do you want to delete?");
        if(deleteoption == JOptionPane.YES_OPTION) {
        ob.deleteData(ab);
        JOptionPane.showMessageDialog(null,"Record Deleted");
        totalstatus();
        LoadData();
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        // TODO add your handling code here:
        statusDAO ob = new statusDAO();
        ob.clearAll();
        JOptionPane.showMessageDialog(null,"Routine Deleted");
        LoadData();
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jTextField_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_priceKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_priceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_load;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox<String> jComboBox_span;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_finance;
    private javax.swing.JTable jTable_total;
    private javax.swing.JTextArea jTextArea_expense;
    private javax.swing.JTextField jTextField_price;
    // End of variables declaration//GEN-END:variables
}
