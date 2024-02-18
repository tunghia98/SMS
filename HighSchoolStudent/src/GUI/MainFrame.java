/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.FunctionBUS;
import BUS.PermissionDetailBUS;
import BUS.TeacherBUS;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author M S I
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener {

    ContentPanel contentPanel = new ContentPanel();
    PermissionDetailBUS perMissionDetailBUS = new PermissionDetailBUS();
    FunctionBUS functionBUS = new FunctionBUS();
    TeacherBUS teacherBUS = new TeacherBUS();

    public String roleID;
    public String userID;

    public MainFrame() {

        initComponents();
        currentPanel.add(contentPanel);

    }

    public MainFrame(String rID, String uID, ArrayList<String> functionList) {
        initComponents();
        labelUsername.setText(teacherBUS.getTeacherByID(uID).getTeacherName());
        for (String x : functionList) {
            String functionName = functionBUS.getFunctionByID(x).getFunctionName();
            JButton button = new JButton(functionName);
            button.setPreferredSize(new Dimension(168, 55));
            button.addActionListener(this);
            try {

                if (button.getText().equals("Học Sinh")) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/Student Male.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals("Năm Học")) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/2006.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals("Giáo Viên")) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/Teacher_Icon.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals(("Điểm Số"))) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/Report Card.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals(("Phân Quyền"))) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/User Shield.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals(("Người Dùng"))) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/User Default.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals(("Môn Học"))) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/LogBook.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals(("Khối Lớp"))) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/Classroom.png"));
                    button.setIcon(icon);
                } else if (button.getText().equals(("Hoạt Động"))) {
                    ImageIcon icon = new ImageIcon(getClass().getResource("/media/Activity.png"));
                    button.setIcon(icon);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            sidebar.add(button);
        }
        roleID = rID;
        userID = uID;
        JButton button = new JButton("Đăng Xuất");
        button.setPreferredSize(new Dimension(168, 55));

        sidebar.add(button);
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/media/Logout.png"));
            button.setIcon(icon);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        JOptionPane.showMessageDialog(this, src);
        if (src.equals("Học Sinh")) {
            ImageIcon icon = new ImageIcon("D:/JAVA/Java_Workspace/HighSchoolStudent/media/ICON/Student Male.png");
            StudentPanel studentPanel = new StudentPanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(studentPanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Năm Học")) {
            SchoolYearPanel schoolYearPanel = new SchoolYearPanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(schoolYearPanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Người Dùng")) {
            UserPanel userPanel = new UserPanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(userPanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Điểm Số")) {
            StudentResultPanel SRP = new StudentResultPanel(userID);
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(SRP);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Phân Quyền")) {
            PermissionPanel permissionPanel = new PermissionPanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(permissionPanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Môn Học")) {
            SubjectPanel subjectPanel = new SubjectPanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(subjectPanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Khối Lớp")) {
            ClassGradePanel classGradePanel = new ClassGradePanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(classGradePanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Giáo Viên")) {
            TeacherPanel teacherPanel = new TeacherPanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(teacherPanel);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Hoạt Động")) {
            DisciplinePanel frame = new DisciplinePanel();
            currentPanel.removeAll();
            currentPanel.repaint();
            currentPanel.revalidate();
            currentPanel.add(frame);
            currentPanel.repaint();
            currentPanel.revalidate();
        } else if (src.equals("Đăng Xuất")) {
            this.dispose();
            new LoginGUI().setVisible(true);
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

        sidebar = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        labelUsername = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        currentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));

        sidebar.setAutoscrolls(true);
        sidebar.setPreferredSize(new java.awt.Dimension(200, 600));
        sidebar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        header.setBackground(new java.awt.Color(204, 0, 204));
        header.setPreferredSize(new java.awt.Dimension(52, 50));

        labelUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 255, 255));
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Remembear.png"))); // NOI18N
        labelUsername.setText("Username: ");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/TwitterX.png"))); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        currentPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(currentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JPanel currentPanel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
