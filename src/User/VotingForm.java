/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User;

import Connections.Database;
import Election1.Reset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author INTEL
 */

public class VotingForm extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
ArrayList<String> senList = new ArrayList<String>();
int updateSenList[] = new int[5];
int index;
String itemSelected;
String selected;
DefaultListModel dlm = new DefaultListModel();
int  presidentVote , vPresidentVote, secretaryVote, asecretaryVote, treasurerVote, auditorVote;
int vote_count;
  int votercount;

   
    public VotingForm() {
        initComponents();
         conn = Database.ConnectDatabase();
         populatePresident();
          populatevicePresident();
        populateSecretary();
        populateAssistantSecretary();
        populateTreasurer();
        populateAuditor();
           
      
          
    }
    
    public void populatePresident(){
        try{
            String sql = "SELECT lastname,firstname,middlename FROM candidates_info WHERE position='PRESIDENT' ORDER BY lastname ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                presidentCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middlename"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populatevicePresident(){
        try{
            String sql = "SELECT lastname,firstname,middlename FROM candidates_info WHERE position='VICE-PRESIDENT' ORDER BY lastname ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                vicePresidentCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middlename"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
       public void populateSecretary(){
        try{
            String sql = "SELECT lastname,firstname,middlename FROM candidates_info WHERE position='SECRETARY' ORDER BY lastname ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                secCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middlename"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        public void populateAssistantSecretary(){
        try{
            String sql = "SELECT lastname,firstname,middlename FROM candidates_info WHERE position='ASSISTANT SECRETARY' ORDER BY lastname ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                asecCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middlename"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
          public void populateTreasurer(){
        try{
            String sql = "SELECT lastname,firstname,middlename FROM candidates_info WHERE position='TREASURER' ORDER BY lastname ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                tresCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middlename"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
              public void populateAuditor(){
        try{
            String sql = "SELECT lastname,firstname,middlename FROM candidates_info WHERE position='AUDITOR' ORDER BY lastname ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                auCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middlename"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
   
   
    public void selectVoteCountForPresident(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+presidentCombo.getSelectedItem()+"' AND position='PRESIDENT'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               presidentVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
      public void selectVoteCountForVicePresident(){
     try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+vicePresidentCombo.getSelectedItem()+"' AND position='VICE-PRESIDENT'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               vPresidentVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
       public void selectVoteCountForSecretary(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+secCombo.getSelectedItem()+"' AND position='SECRETARY'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               secretaryVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }    
        public void selectVoteCountForASecretary(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+asecCombo.getSelectedItem()+"' AND position='ASSISTANT SECRETARY'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               asecretaryVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }  
               public void selectVoteCountForTreasurer(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+ tresCombo.getSelectedItem()+"' AND position='TREASURER'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               treasurerVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        public void selectVoteCountForAuditor(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+ auCombo.getSelectedItem()+"' AND position='AUDITOR'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               auditorVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

      
      
         public void updateForPresident(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ presidentVote +"' WHERE fullname='"+presidentCombo.getSelectedItem()+"' AND position='PRESIDENT'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
            public void updateForVPresident(){
          try{
            String sql = "UPDATE candidates_info SET vote_count='"+ vPresidentVote +"' WHERE fullname='"+vicePresidentCombo.getSelectedItem()+"' AND position='VICE-PRESIDENT'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
   public void updateForSecretary(){
          try{
            String sql = "UPDATE candidates_info SET vote_count='"+ secretaryVote +"' WHERE fullname='"+secCombo.getSelectedItem()+"' AND position='SECRETARY'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }  
    public void updateForAssistantSecretary(){
          try{
            String sql = "UPDATE candidates_info SET vote_count='"+ asecretaryVote +"' WHERE fullname='"+asecCombo.getSelectedItem()+"' AND position='ASSISTANT SECRETARY'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        public void updateForTreasurer(){
          try{
            String sql = "UPDATE candidates_info SET vote_count='"+ treasurerVote +"' WHERE fullname='"+tresCombo.getSelectedItem()+"' AND position='TREASURER'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
                public void updateForAuditor(){
          try{
            String sql = "UPDATE candidates_info SET vote_count='"+ auditorVote +"' WHERE fullname='"+auCombo.getSelectedItem()+"' AND position='AUDITOR'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateVotecountUser(){
              try{
            String sql = "UPDATE user SET vote_count='"+ votercount+"' WHERE studentid="+ idk.getText();
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void setVotercount(){
         try{
            String sql = "SELECT vote_count FROM user WHERE studentid="+idk.getText();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
               votercount =Integer.parseInt(rs.getString("vote_count"))+1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void readVotecount(){
          try{
            String sql = "SELECT vote_count FROM user WHERE studentid="+idk.getText();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
               votercount =Integer.parseInt(rs.getString("vote_count"))+0;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
          
            

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        UserLevel7 = new javax.swing.JLabel();
        UserLevel8 = new javax.swing.JLabel();
        UserLevel9 = new javax.swing.JLabel();
        UserLevel10 = new javax.swing.JLabel();
        UserLevel11 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        idk = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        UserLevel3 = new javax.swing.JLabel();
        UserLevel4 = new javax.swing.JLabel();
        UserLevel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        presidentCombo = new javax.swing.JComboBox();
        vicePresidentCombo = new javax.swing.JComboBox();
        secCombo = new javax.swing.JComboBox();
        asecCombo = new javax.swing.JComboBox();
        UserLevel12 = new javax.swing.JLabel();
        tresCombo = new javax.swing.JComboBox();
        UserLevel13 = new javax.swing.JLabel();
        UserLevel14 = new javax.swing.JLabel();
        auCombo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(236, 245, 255));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(236, 245, 255));

        jPanel4.setBackground(new java.awt.Color(236, 245, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(15, 30, 84));
        jPanel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Voting System");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 50));

        jPanel8.setBackground(new java.awt.Color(18, 39, 114));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Home");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 50));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Members");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 160, 50));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cuarez");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 160, 50));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Metrillo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 160, 50));

        jPanel9.setBackground(new java.awt.Color(11, 24, 69));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Coming Soon....");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel18)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 160, 60));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 760));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(15, 30, 84));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(15, 30, 84));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("VOTERS");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\INTEL\\Downloads\\1PICS\\resized.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\INTEL\\Downloads\\1PICS\\sasa.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(664, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 670, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(188, 255, 221));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 30, 84));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Voting Form");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(242, 242, 242));
        jPanel10.setForeground(new java.awt.Color(237, 237, 237));

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setBackground(new java.awt.Color(15, 30, 84));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(15, 30, 84));
        jLabel3.setText("User Information");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        UserLevel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel7.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel7.setText("Student's ID:");

        UserLevel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel8.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel8.setText("Name:");

        UserLevel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel9.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel9.setText("Age:");

        UserLevel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel10.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel10.setText("Gender:");

        UserLevel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel11.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel11.setText("Year & Section:");

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Name");

        status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status.setForeground(new java.awt.Color(0, 0, 0));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Name");

        gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 0));
        gender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gender.setText("Name");

        age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        age.setForeground(new java.awt.Color(0, 0, 0));
        age.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        age.setText("Name");

        idk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idk.setForeground(new java.awt.Color(0, 0, 0));
        idk.setText("Name");
        idk.setEditable(false);
        idk.setBackground(null);
        idk.setBorder(null);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(UserLevel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idk, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(UserLevel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name)))
                        .addContainerGap(256, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(UserLevel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(age)
                        .addGap(24, 24, 24)
                        .addComponent(UserLevel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UserLevel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status)
                        .addGap(71, 71, 71))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLevel7)
                    .addComponent(idk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLevel8)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLevel9)
                    .addComponent(age)
                    .addComponent(UserLevel11)
                    .addComponent(status)
                    .addComponent(UserLevel10)
                    .addComponent(gender))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(242, 242, 242));
        jPanel12.setForeground(new java.awt.Color(237, 237, 237));

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));

        jLabel11.setBackground(new java.awt.Color(15, 30, 84));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 30, 84));
        jLabel11.setText("Please select your candidates");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        UserLevel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel3.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel3.setText("President");

        UserLevel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel4.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel4.setText("Vice President");

        UserLevel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel5.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel5.setText("Secretary");

        jButton3.setText("Vote");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        presidentCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        presidentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        presidentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presidentComboActionPerformed(evt);
            }
        });

        vicePresidentCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vicePresidentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        vicePresidentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vicePresidentComboActionPerformed(evt);
            }
        });

        secCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        secCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        secCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secComboActionPerformed(evt);
            }
        });

        asecCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        asecCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        asecCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asecComboActionPerformed(evt);
            }
        });

        UserLevel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel12.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel12.setText("Assistant Secretary");

        tresCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tresCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        tresCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresComboActionPerformed(evt);
            }
        });

        UserLevel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel13.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel13.setText("Treasurer");

        UserLevel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLevel14.setForeground(new java.awt.Color(11, 24, 69));
        UserLevel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLevel14.setText("Auditor");

        auCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        auCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        auCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(395, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserLevel4)
                            .addComponent(UserLevel3)
                            .addComponent(UserLevel5)
                            .addComponent(UserLevel12)
                            .addComponent(UserLevel13)
                            .addComponent(UserLevel14))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(presidentCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vicePresidentCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(secCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(asecCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tresCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(auCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserLevel3)
                    .addComponent(presidentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLevel4)
                    .addComponent(vicePresidentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLevel5)
                    .addComponent(secCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asecCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserLevel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tresCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserLevel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserLevel14)
                    .addComponent(auCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 590, 630));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Members");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 160, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void presidentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presidentComboActionPerformed
       
    }//GEN-LAST:event_presidentComboActionPerformed

    private void vicePresidentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vicePresidentComboActionPerformed
     
    }//GEN-LAST:event_vicePresidentComboActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                readVotecount();
                if (votercount ==1){
                     JOptionPane.showMessageDialog(null, "You can only vote once!", "Invalid",JOptionPane.ERROR_MESSAGE); 
                } else {
                if(presidentCombo.getSelectedIndex()==0 || vicePresidentCombo.getSelectedIndex()==0 ){
               JOptionPane.showMessageDialog(null, "Please fill up all the required fields");            
           }else {
                int des = JOptionPane.showConfirmDialog(null, "Finish Voting?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(des==0){
                    selectVoteCountForPresident();
               selectVoteCountForVicePresident();
                selectVoteCountForSecretary();
                  selectVoteCountForASecretary();
                    selectVoteCountForTreasurer();
                      selectVoteCountForAuditor();
               setVotercount();
             
               
        
                updateForPresident();
                updateForVPresident();
                updateForSecretary();
                updateForAssistantSecretary();
                  updateForTreasurer();
                    updateForAuditor();
                updateVotecountUser();
               
                JOptionPane.showMessageDialog(null, "Voted Successfully!");
                }
                     }
                }
                 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (des ==0){
            dispose();
            new Login.LoginFinal().setVisible(true);

        } else {
            dispose();
            new VotingForm().setVisible(true);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void secComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secComboActionPerformed
      
    }//GEN-LAST:event_secComboActionPerformed

    private void asecComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asecComboActionPerformed
       
    }//GEN-LAST:event_asecComboActionPerformed

    private void tresComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresComboActionPerformed
       
    }//GEN-LAST:event_tresComboActionPerformed

    private void auComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auComboActionPerformed
       
    }//GEN-LAST:event_auComboActionPerformed


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
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotingForm().setVisible(true);
            }
        });
    }
     public boolean checkVote(String k){
        PreparedStatement cc;
        ResultSet user;
        boolean checkVote = false;
        String no ="SELECT voter_count FROM user WHERE studentid ="+k;
       
        try{
            cc = Database.ConnectDatabase().prepareStatement(no);
            cc.setString(1, k);
            user = cc.executeQuery();
            
            
            if (user.next())
            {
                votercount =Integer.parseInt(user.getString("vote_count"));
                if (votercount ==1){
                   
                    checkVote =true;
                }
            }
         
        }catch(SQLException ex){
          java.util.logging.Logger.getLogger(VotingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        return checkVote;
    } 
     


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLevel10;
    private javax.swing.JLabel UserLevel11;
    private javax.swing.JLabel UserLevel12;
    private javax.swing.JLabel UserLevel13;
    private javax.swing.JLabel UserLevel14;
    private javax.swing.JLabel UserLevel3;
    private javax.swing.JLabel UserLevel4;
    private javax.swing.JLabel UserLevel5;
    private javax.swing.JLabel UserLevel7;
    private javax.swing.JLabel UserLevel8;
    private javax.swing.JLabel UserLevel9;
    public javax.swing.JLabel age;
    private javax.swing.JComboBox asecCombo;
    private javax.swing.JComboBox auCombo;
    public javax.swing.JLabel gender;
    public javax.swing.JTextField idk;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel name;
    private javax.swing.JComboBox presidentCombo;
    private javax.swing.JComboBox secCombo;
    public javax.swing.JLabel status;
    private javax.swing.JComboBox tresCombo;
    private javax.swing.JComboBox vicePresidentCombo;
    // End of variables declaration//GEN-END:variables
}
