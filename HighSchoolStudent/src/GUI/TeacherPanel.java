/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.ClassBUS;
import BUS.SchoolYearBUS;
import BUS.SubjectBUS;
import BUS.TeacherBUS;
import BUS.TeachingAssignmentBUS;
import DTO.SchoolYear;
import DTO.Student;
import DTO.Subject;
import DTO.Teacher;
import DTO.TeachingAssignment;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M S I
 */
public class TeacherPanel extends javax.swing.JPanel {

    /**
     * Creates new form TeacherPanel
     */
    TeacherBUS teacherBUS = new TeacherBUS();
    ClassBUS classBUS = new ClassBUS();
    SubjectBUS subjectBUS = new SubjectBUS();
    SchoolYearBUS schoolYearBUS = new SchoolYearBUS();
    TeachingAssignmentBUS tcBUS = new TeachingAssignmentBUS();
    String strImage = null;

    public TeacherPanel() {
        initComponents();
        loadDataTableTeacher();
        loadComboboxClass();
        loadComboboxTeacher();
        loadComboSubject();
        loadComboSchoolYear();
        loadDataTableAssignment();
    }

    public void loadDataTableTeacher() {

        DefaultTableModel model = (DefaultTableModel) teacherList.getModel();
        model.setRowCount(0); // xóa table 
        for (Teacher teacher : teacherBUS.getAllTeachers()) {
            Object dataRow[] = new Object[9];
            dataRow[0] = teacher.getTeacherID();
            dataRow[1] = teacher.getTeacherName();
            dataRow[2] = teacher.getDateOfBirth();
            dataRow[3] = teacher.getGender();
            dataRow[4] = teacher.getPhone();
            dataRow[5] = teacher.getEmail();
            dataRow[6] = teacher.getAddress();
            dataRow[7] = teacher.getStatus();
            dataRow[8] = (subjectBUS.getSubjectByID(teacher.getSubjectID())).getSubjectName();
            model.addRow(dataRow);
            System.out.println(teacher.toString());
        }

    }

    public void loadDataTableAssignment() {
        DefaultTableModel model = (DefaultTableModel) teachingAssignmentList.getModel();
        model.setRowCount(0); // xóa table 
        try {
            for (TeachingAssignment teachingAssignment : tcBUS.getAllTeachingAssignments()) {
                Object dataRow[] = new Object[5];
                dataRow[0] = teachingAssignment.getId();
                Teacher teacher = teacherBUS.getTeacherByID(teachingAssignment.getTeacherID());
                dataRow[1] = teacher.getTeacherName();
                DTO.Class classAssign = classBUS.getClassByID(teachingAssignment.getClassID());
                dataRow[2] = classAssign.getClassName();
                SchoolYear schoolYear = schoolYearBUS.getSchoolYearByID(classAssign.getShoolyear());
                dataRow[3] = schoolYear.getSchoolYearName();
                Subject subject = subjectBUS.getSubjectByID(teacher.getSubjectID());
                dataRow[4] = subject.getSubjectName();
                model.addRow(dataRow);

                System.out.println(teachingAssignment.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadComboboxClass() {
        DefaultComboBoxModel comboClass = new DefaultComboBoxModel();
        for (DTO.Class c1 : classBUS.getAllClass()) {
            comboClass.addElement(c1.getClassID());
        }
        comboboxClass.setModel(comboClass);
    }

    public void loadComboboxTeacher() {
        DefaultComboBoxModel comboTeacher = new DefaultComboBoxModel();
        for (Teacher teacher : teacherBUS.getAllTeachers()) {
            comboTeacher.addElement(teacher.getTeacherName());
        }
        comboboxTeacher.setModel(comboTeacher);
    }

    public void loadComboSubject() {
        DefaultComboBoxModel comboSubject = new DefaultComboBoxModel();
        for (Subject subject : subjectBUS.getAllSubjects()) {
            comboSubject.addElement(subject.getSubjectName());
        }
        subjectCombobox.setModel(comboSubject);
    }

    public void loadComboSchoolYear() {
        DefaultComboBoxModel comboSchoolYear = new DefaultComboBoxModel();
        for (SchoolYear schoolYear : schoolYearBUS.getAllSchoolYear()) {
            comboSchoolYear.addElement(schoolYear.getSchoolYearName());
        }
        comboboxSchoolYear.setModel(comboSchoolYear);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TeacherDialog = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTeacherID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTeacherName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnAddTeacher = new javax.swing.JButton();
        btnEditTeacher = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        csBirthDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        subjectCombobox = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        AssignmentDialog = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtAssignmentID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        addAssignmentBtn = new javax.swing.JButton();
        editAssignmentBtn = new javax.swing.JButton();
        btnEsc1 = new javax.swing.JButton();
        comboboxTeacher = new javax.swing.JComboBox<>();
        comboboxClass = new javax.swing.JComboBox<>();
        comboboxSchoolYear = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnShowTeacherDialog = new javax.swing.JButton();
        btnShowEditTeacherDialog = new javax.swing.JButton();
        btnDeleteTeacher = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        showAssignmentDialog = new javax.swing.JButton();
        showEditAssignmentDialog = new javax.swing.JButton();
        deleteAssignement = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teachingAssignmentList = new javax.swing.JTable();

        TeacherDialog.setMinimumSize(new java.awt.Dimension(462, 455));
        TeacherDialog.setModal(true);
        TeacherDialog.setUndecorated(true);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin giáo viên"));

        jLabel1.setText("ID");

        jLabel2.setText("Tên");

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Giới tính");

        buttonGroup1.add(rdMale);
        rdMale.setText("Nam");

        buttonGroup1.add(rdFemale);
        rdFemale.setText("Nữ");

        jLabel5.setText("Số điện thoại");

        jLabel6.setText("Email");

        jLabel7.setText("Địa chỉ");

        jLabel8.setText("Hình ảnh");

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setText("Chọn Ảnh");
        lbImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });

        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        btnAddTeacher.setBackground(new java.awt.Color(204, 0, 204));
        btnAddTeacher.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTeacher.setText("Thêm");
        btnAddTeacher.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAddTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTeacherActionPerformed(evt);
            }
        });
        jPanel11.add(btnAddTeacher);

        btnEditTeacher.setBackground(new java.awt.Color(255, 153, 51));
        btnEditTeacher.setForeground(new java.awt.Color(255, 255, 255));
        btnEditTeacher.setText("Sửa");
        btnEditTeacher.setPreferredSize(new java.awt.Dimension(100, 35));
        btnEditTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTeacherActionPerformed(evt);
            }
        });
        jPanel11.add(btnEditTeacher);

        btnEsc.setBackground(new java.awt.Color(255, 0, 0));
        btnEsc.setForeground(new java.awt.Color(255, 255, 255));
        btnEsc.setText("Thoát");
        btnEsc.setPreferredSize(new java.awt.Dimension(100, 35));
        btnEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscActionPerformed(evt);
            }
        });
        jPanel11.add(btnEsc);

        jLabel14.setText("Môn học");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(txtTeacherName)
                            .addComponent(jLabel1)
                            .addComponent(txtTeacherID)
                            .addComponent(jLabel4)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdMale)
                                .addGap(18, 18, 18)
                                .addComponent(rdFemale))
                            .addComponent(csBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(subjectCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(csBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdMale)
                            .addComponent(rdFemale))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TeacherDialogLayout = new javax.swing.GroupLayout(TeacherDialog.getContentPane());
        TeacherDialog.getContentPane().setLayout(TeacherDialogLayout);
        TeacherDialogLayout.setHorizontalGroup(
            TeacherDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TeacherDialogLayout.setVerticalGroup(
            TeacherDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AssignmentDialog.setMinimumSize(new java.awt.Dimension(270, 400));
        AssignmentDialog.setModal(true);
        AssignmentDialog.setUndecorated(true);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin giảng dạy"));

        jLabel9.setText("Mã phân công");

        jLabel10.setText("Giảng viên");

        jLabel11.setText("Lớp");

        jLabel13.setText("Năm học");

        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        addAssignmentBtn.setBackground(new java.awt.Color(204, 0, 204));
        addAssignmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        addAssignmentBtn.setText("Thêm");
        addAssignmentBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        addAssignmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAssignmentBtnActionPerformed(evt);
            }
        });
        jPanel12.add(addAssignmentBtn);

        editAssignmentBtn.setBackground(new java.awt.Color(255, 153, 51));
        editAssignmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        editAssignmentBtn.setText("Sửa");
        editAssignmentBtn.setPreferredSize(new java.awt.Dimension(100, 35));
        editAssignmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAssignmentBtnActionPerformed(evt);
            }
        });
        jPanel12.add(editAssignmentBtn);

        btnEsc1.setBackground(new java.awt.Color(255, 0, 0));
        btnEsc1.setForeground(new java.awt.Color(255, 255, 255));
        btnEsc1.setText("Thoát");
        btnEsc1.setPreferredSize(new java.awt.Dimension(100, 35));
        btnEsc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsc1ActionPerformed(evt);
            }
        });
        jPanel12.add(btnEsc1);

        comboboxTeacher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboboxClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboboxSchoolYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(txtAssignmentID)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(comboboxTeacher, 0, 221, Short.MAX_VALUE)
                    .addComponent(comboboxClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboboxSchoolYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAssignmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout AssignmentDialogLayout = new javax.swing.GroupLayout(AssignmentDialog.getContentPane());
        AssignmentDialog.getContentPane().setLayout(AssignmentDialogLayout);
        AssignmentDialogLayout.setHorizontalGroup(
            AssignmentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignmentDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AssignmentDialogLayout.setVerticalGroup(
            AssignmentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignmentDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(1050, 600));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnShowTeacherDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Add.png"))); // NOI18N
        btnShowTeacherDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTeacherDialogActionPerformed(evt);
            }
        });

        btnShowEditTeacherDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N
        btnShowEditTeacherDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEditTeacherDialogActionPerformed(evt);
            }
        });

        btnDeleteTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Remove.png"))); // NOI18N
        btnDeleteTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTeacherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowTeacherDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowEditTeacherDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowTeacherDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowEditTeacherDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách giáo viên"));

        teacherList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "Email", "Địa Chỉ", "Trạng Thái", "Môn học"
            }
        ));
        teacherList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teacherList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Giáo viên", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao Tác"));

        showAssignmentDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Add.png"))); // NOI18N
        showAssignmentDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAssignmentDialogActionPerformed(evt);
            }
        });

        showEditAssignmentDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N

        deleteAssignement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Remove.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showAssignmentDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showEditAssignmentDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteAssignement, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteAssignement, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showEditAssignmentDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showAssignmentDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách giảng dạy"));

        teachingAssignmentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phân công", "Giáo viên", "Lớp", "Dạy môn", "Năm học"
            }
        ));
        jScrollPane2.setViewportView(teachingAssignmentList);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phân công", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean validateTeacherForm() {
        if (txtTeacherID.getText().isEmpty()
                || txtTeacherName.getText().isEmpty()
                || txtPhone.getText().isEmpty()
                || txtEmail.getText().isEmpty()
                || txtAddress.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    private void btnAddTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTeacherActionPerformed
        if (validateTeacherForm()) {
            Teacher teacher = getTeacherModel();
            if (teacherBUS.addTeacher(teacher)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loadDataTableTeacher();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }

    }//GEN-LAST:event_btnAddTeacherActionPerformed

    private void btnEditTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTeacherActionPerformed
        if (validateTeacherForm()) {
            Teacher teacher = getTeacherModel();
            if (teacherBUS.editTeacher(teacher)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loadDataTableTeacher();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }
    }//GEN-LAST:event_btnEditTeacherActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        // TODO add your handling code here:
        TeacherDialog.setVisible(false);
    }//GEN-LAST:event_btnEscActionPerformed

    public void resetTeacherForm() {
        txtTeacherID.setText("");
        txtTeacherName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        lbImage.setIcon(null);
        lbImage.setText("Chọn Ảnh");
    }

    public Teacher getTeacherModel() {
        Teacher teacher = new Teacher();
        teacher.setTeacherID(txtTeacherID.getText());
        teacher.setTeacherName(txtTeacherName.getText());
        teacher.setEmail(txtEmail.getText());
        teacher.setPhone(txtPhone.getText());
        teacher.setAddress(txtAddress.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = sdf.format(csBirthDate.getDate());
        teacher.setDateOfBirth(birthDate);
        if (rdMale.isSelected()) {
            teacher.setGender("Nam");
        } else {
            teacher.setGender("Nữ");
        }
        if (strImage == null) {
            teacher.setImage("NO AVATAR");
        } else {
            teacher.setImage(strImage);
        }
        teacher.setSubjectID(subjectBUS.getSubjectByName(subjectCombobox.getSelectedItem().toString()).getSubjectID());
        return teacher;
    }

    public void setTeacherModel(Teacher teacher) {
        txtTeacherID.setText(teacher.getTeacherID());
        txtTeacherName.setText(teacher.getTeacherName());
        txtEmail.setText(teacher.getEmail());
        txtPhone.setText(teacher.getPhone());
        txtAddress.setText(teacher.getAddress());

        try {
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(teacher.getDateOfBirth());
            csBirthDate.setDate(birthDate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị ngày");
        }
        if (teacher.getGender().equals("Nam")) {
            rdMale.setSelected(true);
        } else if (teacher.getGender().equals("Nữ")) {
            rdFemale.setSelected(true);
        }

        if (teacher.getImage().equals("") || teacher.getImage().equals("NO AVATAR")) {
            lbImage.setText("NO AVATAR");
            lbImage.setIcon(null);
        } else {
            lbImage.setText("");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/media/" + teacher.getImage()));
            Image img = imgIcon.getImage();
            lbImage.setIcon(imgIcon);
        }
    }
    private void btnShowTeacherDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTeacherDialogActionPerformed
        // TODO add your handling code here:
        TeacherDialog.setLocationRelativeTo(null);
        btnAddTeacher.setVisible(true);
        btnEditTeacher.setVisible(false);
        resetTeacherForm();
        TeacherDialog.setVisible(true);
    }//GEN-LAST:event_btnShowTeacherDialogActionPerformed

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("D:\\JAVA\\Java_Workspace\\HighSchoolStudent\\src\\media");
            jfc.showOpenDialog(jPanel1);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            strImage = file.getName();
            lbImage.setText("");
            int width = lbImage.getWidth();
            int height = lbImage.getHeight();
            lbImage.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        }
    }//GEN-LAST:event_lbImageMouseClicked

    private void teacherListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherListMouseClicked
        // TODO add your handling code here:
        int row = teacherList.rowAtPoint(evt.getPoint());
        String teacherID = teacherList.getValueAt(row, 0).toString();
        Teacher teacher = teacherBUS.getTeacherByID(teacherID);
        setTeacherModel(teacher);
    }//GEN-LAST:event_teacherListMouseClicked

    private void btnShowEditTeacherDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEditTeacherDialogActionPerformed
        // TODO add your handling code here:
        if (validateTeacherForm()) {
            TeacherDialog.setLocationRelativeTo(null);
            btnAddTeacher.setVisible(false);
            btnEditTeacher.setVisible(true);
            TeacherDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giáo viên cần sửa");

        }
    }//GEN-LAST:event_btnShowEditTeacherDialogActionPerformed

    private void btnDeleteTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTeacherActionPerformed
        // TODO add your handling code here:
        if (validateTeacherForm()) {
            Teacher teacher = getTeacherModel();
            if (teacherBUS.deleteTeacher(teacher.getTeacherID())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadDataTableTeacher();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giáo viên cần xóa");
        }
    }//GEN-LAST:event_btnDeleteTeacherActionPerformed

    private void showAssignmentDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAssignmentDialogActionPerformed
        // TODO add your handling code here:
        AssignmentDialog.setLocationRelativeTo(null);
        addAssignmentBtn.setVisible(true);
        editAssignmentBtn.setVisible(false);
        AssignmentDialog.setVisible(true);
    }//GEN-LAST:event_showAssignmentDialogActionPerformed

    private void btnEsc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsc1ActionPerformed
        // TODO add your handling code here:
        AssignmentDialog.setVisible(false);
    }//GEN-LAST:event_btnEsc1ActionPerformed

    public TeachingAssignment getAssignmentModel() {
        TeachingAssignment teachingAssignment = new TeachingAssignment();
        teachingAssignment.setId(txtAssignmentID.getText());
        String teacherID = teacherBUS.getTeacherByName(comboboxTeacher.getSelectedItem().toString()).getTeacherID();
        teachingAssignment.setTeacherID(teacherID);
        teachingAssignment.setClassID(comboboxClass.getSelectedItem().toString());
        String schoolYearID = schoolYearBUS.getSchoolYearByName(comboboxSchoolYear.getSelectedItem().toString()).getSchoolYearID();
        teachingAssignment.setSchoolYearID(schoolYearID);
        Teacher teacher = teacherBUS.getTeacherByName(comboboxTeacher.getSelectedItem().toString());
        Subject subject = subjectBUS.getSubjectByID(teacher.getSubjectID());
        teachingAssignment.setSubjectID(subject.getSubjectID());

        return teachingAssignment;
    }

    private void addAssignmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAssignmentBtnActionPerformed
        // TODO add your handling code here:
        if (txtAssignmentID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

        } else {
            TeachingAssignment teachingAssignment = getAssignmentModel();
            try {
                if (tcBUS.addTeachingAssignment(teachingAssignment)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadDataTableAssignment();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addAssignmentBtnActionPerformed

    private void editAssignmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAssignmentBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editAssignmentBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AssignmentDialog;
    private javax.swing.JDialog TeacherDialog;
    private javax.swing.JButton addAssignmentBtn;
    private javax.swing.JButton btnAddTeacher;
    private javax.swing.JButton btnDeleteTeacher;
    private javax.swing.JButton btnEditTeacher;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnEsc1;
    private javax.swing.JButton btnShowEditTeacherDialog;
    private javax.swing.JButton btnShowTeacherDialog;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboboxClass;
    private javax.swing.JComboBox<String> comboboxSchoolYear;
    private javax.swing.JComboBox<String> comboboxTeacher;
    private com.toedter.calendar.JDateChooser csBirthDate;
    private javax.swing.JButton deleteAssignement;
    private javax.swing.JButton editAssignmentBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JButton showAssignmentDialog;
    private javax.swing.JButton showEditAssignmentDialog;
    private javax.swing.JComboBox<String> subjectCombobox;
    private javax.swing.JTable teacherList;
    private javax.swing.JTable teachingAssignmentList;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAssignmentID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTeacherID;
    private javax.swing.JTextField txtTeacherName;
    // End of variables declaration//GEN-END:variables
}
