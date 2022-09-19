
package bug_tracing_system.Admin;

import bug_tracing_system.DataBase;
import bug_tracing_system.GeneralView;
import bug_tracing_system.Data;
import bug_tracing_system.Name;
import bug_tracing_system.Users;
import bug_tracing_system.bugData;
import bug_tracing_system.Login.Login;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author haidy
 */
public class Admin extends javax.swing.JFrame implements Data, Name{
    static Users myUser;
    GeneralView generalView = new GeneralView();
    UserAdder userAdder;
    UserUpdater userUpdater;
    UserDeleter userDeleter;
    ArrayList<bugData> arrLst = new ArrayList<>();
    static int xPress = 0;
    static int yPress = 0;
    private String projectName;
    private int bugId;
    private String bugName ;
    private String bugType ;
    private String priorty;
    private String statue;
    private String developerName;
    private String testerName;
    private String bugDes;
    private ImageIcon imageIcon;
    
   public Admin(Users user) {
        initComponents();
        myUser = user;
        userName.setText(myUser.getName());
        DefaultTableModel model;
        model = (DefaultTableModel) bugsTable.getModel();
        Timer t = new Timer(1000, (ActionEvent ae) -> {
            try {
                model.setRowCount(0);
                getData();
                for (int i = 0; i < arrLst.size(); i++) {
                    bugData bug = arrLst.get(i);
                    String Data[] = {bug.getProjectName(), Integer.toString(bug.getBugId()), bug.getBugName(), bug.getBugType(), bug.getPriorty(), bug.getStatue(), getName(bug.getTesterId()) ,getName(bug.getDeveloperId())}; //data added in table
                    model.addRow(Data);
                }
                arrLst = new ArrayList<>();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.start();
    }
   
    @Override
    public String getName(int userId) throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase();           
            String sql = "SELECT FName, LName FROM accounts WHERE UserId="+ userId;
            ResultSet rs = db.selectQuery(sql);
            while(rs.next())
               return rs.getString("FName") + " " + rs.getString("LName");    
        return "NOT FOUND";  
    }

    @Override
    public void getData() throws SQLException, ClassNotFoundException {  
        DataBase db = new DataBase();           
            String sql = "SELECT b.*, p.* FROM bugs as b, projects as p WHERE p.ProjectId=b.ProjectId";
            ResultSet rs = db.selectQuery(sql);
            while(rs.next())
            {
               bugData bug = new bugData(rs.getString(12),rs.getInt(8),rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(2), rs.getString(7), rs.getInt(9), rs.getString(6));
               arrLst.add(bug);
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

        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        addUserBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        minimizeBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bugsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(33, 63, 86));

        jLabel4.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome");

        userName.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("jLabel2");

        addUserBtn.setBackground(new java.awt.Color(204, 204, 204));
        addUserBtn.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(33, 63, 86));
        addUserBtn.setText("ADD User");
        addUserBtn.setToolTipText("");
        addUserBtn.setBorderPainted(false);
        addUserBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUserBtn.setFocusPainted(false);
        addUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUserBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addUserBtnMouseExited(evt);
            }
        });
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(204, 204, 204));
        updateBtn.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(33, 63, 86));
        updateBtn.setText("UPDATE");
        updateBtn.setToolTipText("");
        updateBtn.setBorderPainted(false);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.setFocusPainted(false);
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtnMouseExited(evt);
            }
        });
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteBtn.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(33, 63, 86));
        deleteBtn.setText("DELETE");
        deleteBtn.setToolTipText("");
        deleteBtn.setBorderPainted(false);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setFocusPainted(false);
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(33, 63, 86));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-logout-50_2.png"))); // NOI18N
        logoutBtn.setToolTipText("Logout");
        logoutBtn.setBorder(null);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(logoutBtn)
                .addGap(48, 48, 48))
        );

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Admin Dashboard");

        minimizeBtn.setBackground(new java.awt.Color(0, 153, 153));
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-minimize-window-40.png"))); // NOI18N
        minimizeBtn.setToolTipText("Logout");
        minimizeBtn.setBorder(null);
        minimizeBtn.setBorderPainted(false);
        minimizeBtn.setFocusPainted(false);
        minimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtnActionPerformed(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(0, 153, 153));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_close_window_40px.png"))); // NOI18N
        closeBtn.setToolTipText("Logout");
        closeBtn.setBorder(null);
        closeBtn.setBorderPainted(false);
        closeBtn.setFocusPainted(false);
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(minimizeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeBtn))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeBtn)
                    .addComponent(minimizeBtn)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bugsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjectName", "BugId", "BugName", "BugType", "Priority", "Status", "TesterName", "DevName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bugsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bugsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bugsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        deleteBtn.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_deleteBtnMouseExited

    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        deleteBtn.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_deleteBtnMouseEntered

    private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseExited
        updateBtn.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_updateBtnMouseExited

    private void updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseEntered
        updateBtn.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_updateBtnMouseEntered

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        userAdder = new UserAdder(myUser);
        openView(userAdder);
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void addUserBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnMouseExited
        addUserBtn.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_addUserBtnMouseExited

    private void addUserBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnMouseEntered
        addUserBtn.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_addUserBtnMouseEntered

    private void bugsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugsTableMouseClicked
                try {
            readData();
            openView(generalView);
            setBugDetails();
        } catch (IOException | NumberFormatException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_bugsTableMouseClicked
 private void openView(JFrame view) throws NumberFormatException {     
        view.setVisible(true);
        view.pack();
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }

    private void setBugDetails() {
        generalView.testerText.setText(developerName);
        generalView.developerText.setText(testerName);
        generalView.projectNameText.setText(projectName);
        generalView.BugName.setText(bugName);
        generalView.bugTypeText.setText(bugType);
        generalView.priortyText.setText(priorty);
        generalView.statueText.setText(statue);
        generalView.bugDesText.setText(bugDes);
        generalView.pic.setIcon(imageIcon);
    }

    private void readData() throws NumberFormatException, IOException, SQLException, ClassNotFoundException {
        DefaultTableModel model;
        model = (DefaultTableModel) bugsTable.getModel();
        int index = bugsTable.getSelectedRow();
        projectName = model.getValueAt(index, 0).toString();
        bugId = Integer.parseInt(model.getValueAt(index, 1).toString());
        bugName = model.getValueAt(index, 2).toString();
        bugType = model.getValueAt(index, 3).toString();
        priorty = model.getValueAt(index, 4).toString();
        statue = model.getValueAt(index, 5).toString();
        developerName = model.getValueAt(index, 6).toString();
        testerName = model.getValueAt(index, 7).toString();
        
        BufferedImage img = null;
        img = ImageIO.read(new File("imgs\\" + bugId + ".png"));
        Image dimg = img.getScaledInstance(832, 355, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(dimg);
        
        DataBase db = new DataBase();
        String sql = "SELECT BugDetails FROM bugs WHERE BugId = " +  bugId;
        ResultSet rs = db.selectQuery(sql);
        while(rs.next())
            bugDes = rs.getString("BugDetails");
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
         userUpdater=new UserUpdater(myUser);   
         openView(userUpdater);
        
        //this.dispose();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        userDeleter=new UserDeleter(myUser);     
        openView(userDeleter);
        
        //this.dispose();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close the program?", "EXIT?",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to logout", "LOGOUT ?",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
        this.dispose();
        new Login().setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(evt.getXOnScreen()-xPress,evt.getYOnScreen()-yPress);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
         xPress = evt.getX();
        yPress = evt.getY();
    }//GEN-LAST:event_formMousePressed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin(myUser).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserBtn;
    private javax.swing.JTable bugsTable;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JButton updateBtn;
    public javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
