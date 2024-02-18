/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.SubjectBUS;
import DTO.Subject;
import BUS.StudentBUS;
import DTO.Student;
import BUS.StudentDisBUS;
import DTO.StudentDis;
import BUS.ClassBUS;
import DTO.Class;
import DTO.Teacher;
import BUS.TeacherBUS;
import DTO.TeachingAssignment;
import BUS.TeachingAssignmentBUS;
import DTO.Discipline;
import BUS.DisciplineBUS;
import DTO.Mark;
import BUS.MarkBUS;
import DAO.TeachingAssignmentDAO;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class StudentResultPanel extends javax.swing.JPanel {

    ClassBUS classBUS = new ClassBUS();
    SubjectBUS sjBUS = new SubjectBUS();
    StudentBUS studentBUS = new StudentBUS();
    StudentDisBUS studentdisBUS = new StudentDisBUS();
    DisciplineBUS disBUS = new DisciplineBUS();
    TeacherBUS teacherBUS = new TeacherBUS();
    TeachingAssignmentBUS teachBUS = new TeachingAssignmentBUS();
    MarkBUS markBUS = new MarkBUS();
    String uID;
    float result =0;
    public StudentResultPanel() {
        initComponents();
    }

    public StudentResultPanel(String userID) {
        initComponents();
        uID = userID;
        loadDataStudentTable(uID);
        loadDataStudentDisTable(uID);
        loadDataresultTable();
    }

    public void loadDataStudentTable(String uID) {
        DefaultTableModel model = (DefaultTableModel) studentList.getModel();
        model.setRowCount(0); // xóa table 
        DefaultComboBoxModel comboCurrentClass = new DefaultComboBoxModel();
        for (TeachingAssignment teach : teachBUS.getTeachingAssignmentByTeacherID(uID)) {
            for (Student student : studentBUS.getStudentByClass(teach.getClassID())) {
                Object dataRow[] = new Object[8];
                dataRow[0] = student.getStudentID();
                dataRow[1] = student.getStudentName();

                Mark mark = markBUS.getmarkbystdandteacher(student.getStudentID(), uID);
                if (mark == null) {

                    dataRow[2] = "";
                    dataRow[3] = "";
                    dataRow[4] = "";
                    dataRow[5] = "";
                    dataRow[6] = "";
                    dataRow[7] = "";
                } else {

                    dataRow[2] = mark.getMark_1();
                    dataRow[3] = mark.getMark_2();
                    dataRow[4] = mark.getMark_15();
                    dataRow[5] = mark.getMark_45();
                    dataRow[6] = mark.getMark_end();
                    dataRow[7] = mark.getMark_avg();
                }
                model.addRow(dataRow);
            }
        }
    }

    public void loadDataStudentDisTable(String userID) {
        DefaultTableModel model = (DefaultTableModel) studentdisList.getModel();
        model.setRowCount(0); // xóa table 
        Class class1 = classBUS.getClassByTeacherID(userID);
        for (Student student : studentBUS.getStudentByClass(class1.getClassID())) {
            Object dataRow[] = new Object[4];
            dataRow[0] = student.getStudentID();
            dataRow[1] = student.getStudentName();
            StudentDis studentdis = studentdisBUS.getStudentDisByID(student.getStudentID());
            if (studentdis == null) {
                dataRow[2] = "";
                dataRow[3] = "";
            } else {
                dataRow[2] = studentdis.getScore();
                dataRow[3] = studentdis.getResult();
            }
            model.addRow(dataRow);
            System.out.println(student.toString());
        }
    }

    public void loadDataresultTable() {
        DefaultTableModel model = (DefaultTableModel) resultList.getModel();
        model.setRowCount(0); // xóa table 
        DefaultComboBoxModel comboCurrentClass = new DefaultComboBoxModel();
        for (Student student : studentBUS.getAllStudent()) {
            Object dataRow[] = new Object[16];
            dataRow[0] = student.getStudentID();
            dataRow[1] = student.getStudentName();
            ArrayList<Mark> markList = markBUS.getmarkbystudentID(student.getStudentID());
            if (markList == null) {
                dataRow[2] = "";
                dataRow[3] = "";
                dataRow[4] = "";
                dataRow[5] = "";
                dataRow[6] = "";
                dataRow[7] = "";
                dataRow[8] = "";
                dataRow[9] = "";
                dataRow[10] = "";
                dataRow[11] = "";
                dataRow[12] = "";
                dataRow[13] = "";
                dataRow[15] = "";

            } else {
                result=0;
                int cout=0;
                for(Mark mark:markList)
                {
                    Teacher teacher = teacherBUS.getTeacherByID(mark.getTeacherId());
                    Subject sj = sjBUS.getSubjectByID(teacher.getSubjectID());
                    if(sj.getSubjectName().equals("Toán"))
                    {
                        dataRow[4]=mark.getMark_avg();
                        result+=mark.getMark_avg()*2;
                        cout+=2;
                    }
                    if(sj.getSubjectName().equals("Văn"))
                    {
                        dataRow[5]=mark.getMark_avg();
                        result+=mark.getMark_avg()*2;
                        cout+=2;
                    }
                    if(sj.getSubjectName().equals("Anh"))
                    {
                        dataRow[6]=mark.getMark_avg();
                        result+=mark.getMark_avg()*2;
                        cout+=2;
                    }
                    if(sj.getSubjectName().equals("Vật Lý"))
                    {
                        dataRow[7]=mark.getMark_avg();
                        result+=mark.getMark_avg();
                        cout++;
                    }
                    if(sj.getSubjectName().equals("Hóa Học"))
                    {
                        dataRow[8]=mark.getMark_avg();
                        result+=mark.getMark_avg();
                        cout++;
                    }
                    if(sj.getSubjectName().equals("Sinh Học"))
                    {
                        dataRow[9]=mark.getMark_avg();
                        result+=mark.getMark_avg();
                        cout++;
                    }
                    if(sj.getSubjectName().equals("Lịch Sử"))                    {
                        dataRow[10]=mark.getMark_avg();
                        result+=mark.getMark_avg();
                        cout++;
                    }
                    if(sj.getSubjectName().equals("Địa Lý"))
                    {
                        dataRow[11]=mark.getMark_avg();
                        result+=mark.getMark_avg();
                        cout++;
                    }
                    if(sj.getSubjectName().equals("Giáo Dục Công Dân"))
                    {
                        dataRow[12]=mark.getMark_avg();
                        result+=mark.getMark_avg();
                        cout++;
                    }
                }
                dataRow[13]=result/cout; 
            }
            StudentDis studentdis = studentdisBUS.getStudentDisByID(student.getStudentID());
            if (studentdis == null) {
                dataRow[14] = "";
                dataRow[15] = "";
            } else {
                dataRow[14] = studentdis.getResult();
            }
            if(dataRow[13]!=""&&dataRow[14]!="")
                dataRow[15]=Xeploai(result,studentdis.getScore());
            model.addRow(dataRow);
        }
    }
    public String Xeploai(float result,float score)
    {
         if (result >= 9 && score >= 90) {
            return "Xuất sắc";
        } else if (result >= 8 && score >= 80) {
            return "Giỏi";
        } else if (result >= 6.5 && score >= 65) {
            return "Tiên tiến";
        } else if (result >= 5 && score >= 50) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
    public StudentDis getStudentDisModel(float Score, String result) {
        StudentDis studentdis = new StudentDis();
        studentdis.setStudentID(txtStudentDisID.getText());
        studentdis.setStudentName(txtStudentDisName.getText());
        studentdis.setScore(Score);
        studentdis.setResult(result);
        return studentdis;
    }

    public Mark getStudentModel(String uiD) {
        Mark mark = new Mark();
        mark.setStudentID(txtstdID.getText());
        mark.setStudentName(txtstdName.getText());
        mark.setTeacherId(uiD);
        mark.setMark_1(Float.parseFloat(txtmark1.getText()));
        mark.setMark_2(Float.parseFloat(txtmark2.getText()));
        mark.setMark_15(Float.parseFloat(txtmark15.getText()));
        mark.setMark_45(Float.parseFloat(txtmark45.getText()));
        mark.setMark_end(Float.parseFloat(txtmarkend.getText()));
        Float mark_avg_1 = mark.getMark_1() + mark.getMark_2() + mark.getMark_15();
        Float mark_avg_2 = mark.getMark_45();
        Float mark_avg_3 = mark.getMark_end();
        Double mark_avg_4 = (mark_avg_1 / 3) * 0.2 + mark_avg_2 * 0.3 + mark_avg_3 * 0.5;
        String s = String.valueOf(mark_avg_4);
        mark.setMark_avg(Float.parseFloat(s));
        return mark;
    }

    public void setStudentDisModel(Student student) {
        txtStudentDisID.setText(student.getStudentID());
        txtStudentDisName.setText(student.getStudentName());
    }

    public void setStudentModel(Mark mark) {
        txtstdID.setText(mark.getStudentID());
        txtstdName.setText(mark.getStudentName());
        txtmark1.setText(mark.getMark_1() + "");
        txtmark2.setText(mark.getMark_1() + "");
        txtmark15.setText(mark.getMark_1() + "");
        txtmark45.setText(mark.getMark_1() + "");
        txtmarkend.setText(mark.getMark_1() + "");
        txtmarkavg.setText(mark.getMark_1() + "");
    }

    public boolean validateStudentDisForm() {
        if (txtStudentDisID.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validateStudentForm() {
        if (txtstdID.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentDisDialog = new javax.swing.JDialog();
        studentdisFormPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtStudentDisID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStudentDisName = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnAddStudentDis = new javax.swing.JButton();
        btnEsc1 = new javax.swing.JButton();
        DisResultScroll = new javax.swing.JScrollPane();
        FormDisPanel = new javax.swing.JPanel();
        txtRole = new javax.swing.JTextField();
        txtContent = new javax.swing.JTextField();
        txtScore = new javax.swing.JTextField();
        cbox = new javax.swing.JCheckBox();
        txtRole1 = new javax.swing.JTextField();
        txtContent1 = new javax.swing.JTextField();
        txtScore1 = new javax.swing.JTextField();
        cbox1 = new javax.swing.JCheckBox();
        ArrayList<Discipline> disList = disBUS.getAllDiscipline();
        txtRole2 = new javax.swing.JTextField();
        txtScore2 = new javax.swing.JTextField();
        txtContent2 = new javax.swing.JTextField();
        cbox2 = new javax.swing.JCheckBox();
        txtContent3 = new javax.swing.JTextField();
        cbox3 = new javax.swing.JCheckBox();
        txtScore3 = new javax.swing.JTextField();
        txtRole3 = new javax.swing.JTextField();
        txtRole4 = new javax.swing.JTextField();
        txtContent4 = new javax.swing.JTextField();
        cbox4 = new javax.swing.JCheckBox();
        txtRole5 = new javax.swing.JTextField();
        txtScore4 = new javax.swing.JTextField();
        txtScore5 = new javax.swing.JTextField();
        txtContent5 = new javax.swing.JTextField();
        cbox5 = new javax.swing.JCheckBox();
        cbox6 = new javax.swing.JCheckBox();
        txtContent6 = new javax.swing.JTextField();
        cbox7 = new javax.swing.JCheckBox();
        txtScore6 = new javax.swing.JTextField();
        txtRole6 = new javax.swing.JTextField();
        txtRole7 = new javax.swing.JTextField();
        txtContent7 = new javax.swing.JTextField();
        txtScore7 = new javax.swing.JTextField();
        txtRole8 = new javax.swing.JTextField();
        txtContent8 = new javax.swing.JTextField();
        txtContent9 = new javax.swing.JTextField();
        cbox8 = new javax.swing.JCheckBox();
        txtScore8 = new javax.swing.JTextField();
        txtRole9 = new javax.swing.JTextField();
        txtRole10 = new javax.swing.JTextField();
        txtContent10 = new javax.swing.JTextField();
        txtScore9 = new javax.swing.JTextField();
        txtRole11 = new javax.swing.JTextField();
        txtContent11 = new javax.swing.JTextField();
        cbox9 = new javax.swing.JCheckBox();
        txtRole12 = new javax.swing.JTextField();
        txtScore10 = new javax.swing.JTextField();
        txtScore11 = new javax.swing.JTextField();
        txtContent12 = new javax.swing.JTextField();
        cbox10 = new javax.swing.JCheckBox();
        cbox11 = new javax.swing.JCheckBox();
        txtRole13 = new javax.swing.JTextField();
        txtContent13 = new javax.swing.JTextField();
        txtRole14 = new javax.swing.JTextField();
        txtContent14 = new javax.swing.JTextField();
        txtScore12 = new javax.swing.JTextField();
        cbox12 = new javax.swing.JCheckBox();
        txtRole15 = new javax.swing.JTextField();
        txtContent15 = new javax.swing.JTextField();
        txtScore13 = new javax.swing.JTextField();
        cbox13 = new javax.swing.JCheckBox();
        txtRole16 = new javax.swing.JTextField();
        txtScore14 = new javax.swing.JTextField();
        txtContent16 = new javax.swing.JTextField();
        cbox14 = new javax.swing.JCheckBox();
        txtContent17 = new javax.swing.JTextField();
        cbox15 = new javax.swing.JCheckBox();
        txtScore15 = new javax.swing.JTextField();
        txtRole17 = new javax.swing.JTextField();
        txtRole18 = new javax.swing.JTextField();
        txtContent18 = new javax.swing.JTextField();
        txtRole19 = new javax.swing.JTextField();
        txtContent19 = new javax.swing.JTextField();
        txtScore16 = new javax.swing.JTextField();
        txtRole20 = new javax.swing.JTextField();
        txtContent20 = new javax.swing.JTextField();
        txtRole21 = new javax.swing.JTextField();
        txtContent21 = new javax.swing.JTextField();
        txtScore17 = new javax.swing.JTextField();
        cbox16 = new javax.swing.JCheckBox();
        txtRole22 = new javax.swing.JTextField();
        txtContent22 = new javax.swing.JTextField();
        txtScore18 = new javax.swing.JTextField();
        cbox17 = new javax.swing.JCheckBox();
        txtRole23 = new javax.swing.JTextField();
        txtScore19 = new javax.swing.JTextField();
        txtContent23 = new javax.swing.JTextField();
        cbox18 = new javax.swing.JCheckBox();
        txtContent24 = new javax.swing.JTextField();
        cbox19 = new javax.swing.JCheckBox();
        cbox20 = new javax.swing.JCheckBox();
        txtScore20 = new javax.swing.JTextField();
        txtRole24 = new javax.swing.JTextField();
        txtScore21 = new javax.swing.JTextField();
        cbox21 = new javax.swing.JCheckBox();
        txtRole25 = new javax.swing.JTextField();
        txtContent25 = new javax.swing.JTextField();
        txtContent26 = new javax.swing.JTextField();
        cbox22 = new javax.swing.JCheckBox();
        txtScore22 = new javax.swing.JTextField();
        txtRole26 = new javax.swing.JTextField();
        txtRole27 = new javax.swing.JTextField();
        txtContent27 = new javax.swing.JTextField();
        txtScore23 = new javax.swing.JTextField();
        txtRole28 = new javax.swing.JTextField();
        txtContent28 = new javax.swing.JTextField();
        txtRole29 = new javax.swing.JTextField();
        txtContent29 = new javax.swing.JTextField();
        txtScore24 = new javax.swing.JTextField();
        cbox23 = new javax.swing.JCheckBox();
        txtRole30 = new javax.swing.JTextField();
        txtContent30 = new javax.swing.JTextField();
        txtScore25 = new javax.swing.JTextField();
        cbox24 = new javax.swing.JCheckBox();
        txtRole31 = new javax.swing.JTextField();
        txtScore26 = new javax.swing.JTextField();
        txtContent31 = new javax.swing.JTextField();
        cbox25 = new javax.swing.JCheckBox();
        txtContent32 = new javax.swing.JTextField();
        cbox26 = new javax.swing.JCheckBox();
        cbox27 = new javax.swing.JCheckBox();
        txtScore27 = new javax.swing.JTextField();
        txtRole32 = new javax.swing.JTextField();
        txtRole33 = new javax.swing.JTextField();
        txtScore28 = new javax.swing.JTextField();
        txtScore29 = new javax.swing.JTextField();
        txtContent33 = new javax.swing.JTextField();
        cbox28 = new javax.swing.JCheckBox();
        cbox29 = new javax.swing.JCheckBox();
        txtContent34 = new javax.swing.JTextField();
        txtRole34 = new javax.swing.JTextField();
        txtRole35 = new javax.swing.JTextField();
        txtContent35 = new javax.swing.JTextField();
        txtScore30 = new javax.swing.JTextField();
        txtRole36 = new javax.swing.JTextField();
        txtContent36 = new javax.swing.JTextField();
        txtRole37 = new javax.swing.JTextField();
        txtContent37 = new javax.swing.JTextField();
        txtScore31 = new javax.swing.JTextField();
        cbox30 = new javax.swing.JCheckBox();
        txtRole38 = new javax.swing.JTextField();
        txtContent38 = new javax.swing.JTextField();
        txtScore32 = new javax.swing.JTextField();
        cbox31 = new javax.swing.JCheckBox();
        txtRole39 = new javax.swing.JTextField();
        txtScore33 = new javax.swing.JTextField();
        txtContent39 = new javax.swing.JTextField();
        cbox32 = new javax.swing.JCheckBox();
        txtContent40 = new javax.swing.JTextField();
        cbox33 = new javax.swing.JCheckBox();
        cbox34 = new javax.swing.JCheckBox();
        txtScore34 = new javax.swing.JTextField();
        txtRole40 = new javax.swing.JTextField();
        txtRole41 = new javax.swing.JTextField();
        txtScore35 = new javax.swing.JTextField();
        txtScore36 = new javax.swing.JTextField();
        txtContent41 = new javax.swing.JTextField();
        cbox35 = new javax.swing.JCheckBox();
        cbox36 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        StudentDialog = new javax.swing.JDialog();
        studentFormPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtstdID = new javax.swing.JTextField();
        txtmark1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtmark15 = new javax.swing.JTextField();
        txtmark45 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtmark2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtmarkend = new javax.swing.JTextField();
        txtmarkavg = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtstdName = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnAddMark = new javax.swing.JButton();
        btnEsc2 = new javax.swing.JButton();
        studentTabbedPane = new javax.swing.JTabbedPane();
        studentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        studentList = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnShowEditDialog = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboxStudent = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        studentPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentdisList = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnShowEditDisDialog = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        studentPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnShowEditDisDialog1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        StudentDisDialog.setMinimumSize(new java.awt.Dimension(556, 561));
        StudentDisDialog.setModal(true);
        StudentDisDialog.setUndecorated(true);

        studentdisFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin học sinh"));

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel5.setText("Mã học sinh");

        txtStudentDisID.setEnabled(false);
        txtStudentDisID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentDisIDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel6.setText("Tên học sinh");

        txtStudentDisName.setEnabled(false);
        txtStudentDisName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentDisNameActionPerformed(evt);
            }
        });

        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        btnAddStudentDis.setBackground(new java.awt.Color(209, 15, 209));
        btnAddStudentDis.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStudentDis.setText("Cập nhật");
        btnAddStudentDis.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAddStudentDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentDisActionPerformed(evt);
            }
        });
        jPanel12.add(btnAddStudentDis);

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

        txtRole.setEditable(false);
        txtRole.setText("I.1");
        txtRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoleActionPerformed(evt);
            }
        });

        txtContent.setEditable(false);
        txtContent.setText("Điểm trung bình chung trên 9 điểm");
        txtContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContentActionPerformed(evt);
            }
        });

        txtScore.setEditable(false);
        txtScore.setText("14");
        txtScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScoreActionPerformed(evt);
            }
        });

        txtRole1.setEditable(false);
        txtRole1.setText("I.2");
        txtRole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole1ActionPerformed(evt);
            }
        });

        txtContent1.setEditable(false);
        txtContent1.setText("ĐIểm trung bình chung trên 8 điểm");
        txtContent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent1ActionPerformed(evt);
            }
        });

        txtScore1.setEditable(false);
        txtScore1.setText("12");
        txtScore1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore1ActionPerformed(evt);
            }
        });

        txtRole2.setEditable(false);
        txtRole2.setText("I.3");
        txtRole2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole2ActionPerformed(evt);
            }
        });

        txtScore2.setEditable(false);
        txtScore2.setText("10");
        txtScore2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore2ActionPerformed(evt);
            }
        });

        txtContent2.setEditable(false);
        txtContent2.setText("Điểm trung bình chung trên 6.5 điểm");
        txtContent2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent2ActionPerformed(evt);
            }
        });

        txtContent3.setEditable(false);
        txtContent3.setText("Điểm trung bình chung trên 5 điểm");
        txtContent3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent3ActionPerformed(evt);
            }
        });

        txtScore3.setEditable(false);
        txtScore3.setText("5");
        txtScore3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore3ActionPerformed(evt);
            }
        });

        txtRole3.setEditable(false);
        txtRole3.setText("I.4");
        txtRole3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole3ActionPerformed(evt);
            }
        });

        txtRole4.setEditable(false);
        txtRole4.setText("I");
        txtRole4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole4ActionPerformed(evt);
            }
        });

        txtContent4.setEditable(false);
        txtContent4.setText("Đánh giá về ý thức và kết quả học tập");
        txtContent4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent4ActionPerformed(evt);
            }
        });

        txtRole5.setEditable(false);
        txtRole5.setText("I.7");
        txtRole5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole5ActionPerformed(evt);
            }
        });

        txtScore4.setEditable(false);
        txtScore4.setText("6");
        txtScore4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore4ActionPerformed(evt);
            }
        });

        txtScore5.setEditable(false);
        txtScore5.setText("0");
        txtScore5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore5ActionPerformed(evt);
            }
        });

        txtContent5.setEditable(false);
        txtContent5.setText("Kết quả học tập tăng 2 bậc so với kỳ trước");
        txtContent5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent5ActionPerformed(evt);
            }
        });

        txtContent6.setEditable(false);
        txtContent6.setText("Ban chủ nhiệm câu lạc bộ");
        txtContent6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent6ActionPerformed(evt);
            }
        });

        txtScore6.setEditable(false);
        txtScore6.setText("5");
        txtScore6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore6ActionPerformed(evt);
            }
        });

        txtRole6.setEditable(false);
        txtRole6.setText("I.6");
        txtRole6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole6ActionPerformed(evt);
            }
        });

        txtRole7.setEditable(false);
        txtRole7.setText("I.8");
        txtRole7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole7ActionPerformed(evt);
            }
        });

        txtContent7.setEditable(false);
        txtContent7.setText("Kết quả học tập tăng 1 bậc so với kỳ trước");
        txtContent7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent7ActionPerformed(evt);
            }
        });

        txtScore7.setEditable(false);
        txtScore7.setText("3");
        txtScore7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore7ActionPerformed(evt);
            }
        });

        txtRole8.setEditable(false);
        txtRole8.setText("I.5");
        txtRole8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole8ActionPerformed(evt);
            }
        });

        txtContent8.setEditable(false);
        txtContent8.setText("Điểm trung bình chung dưới 5 điểm");
        txtContent8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent8ActionPerformed(evt);
            }
        });

        txtContent9.setEditable(false);
        txtContent9.setText("Thành viên đội tuyển thi thành phố");
        txtContent9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent9ActionPerformed(evt);
            }
        });

        txtScore8.setEditable(false);
        txtScore8.setText("2");
        txtScore8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore8ActionPerformed(evt);
            }
        });

        txtRole9.setEditable(false);
        txtRole9.setText("I.10");
        txtRole9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole9ActionPerformed(evt);
            }
        });

        txtRole10.setEditable(false);
        txtRole10.setText("I.12");
        txtRole10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole10ActionPerformed(evt);
            }
        });

        txtContent10.setEditable(false);
        txtContent10.setText("Thành viên đội tuyển thi quốc gia");
        txtContent10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent10ActionPerformed(evt);
            }
        });

        txtScore9.setEditable(false);
        txtScore9.setText("6");
        txtScore9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore9ActionPerformed(evt);
            }
        });

        txtRole11.setEditable(false);
        txtRole11.setText("I.9");
        txtRole11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole11ActionPerformed(evt);
            }
        });

        txtContent11.setEditable(false);
        txtContent11.setText("Thành viên câu lạc bộ");
        txtContent11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent11ActionPerformed(evt);
            }
        });

        txtRole12.setEditable(false);
        txtRole12.setText("I.11");
        txtRole12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole12ActionPerformed(evt);
            }
        });

        txtScore10.setEditable(false);
        txtScore10.setText("3");
        txtScore10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore10ActionPerformed(evt);
            }
        });

        txtScore11.setEditable(false);
        txtScore11.setText("2");
        txtScore11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore11ActionPerformed(evt);
            }
        });

        txtContent12.setEditable(false);
        txtContent12.setText("Thành viên đội tuyển thi tỉnh");
        txtContent12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent12ActionPerformed(evt);
            }
        });

        txtRole13.setEditable(false);
        txtRole13.setText("II");
        txtRole13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole13ActionPerformed(evt);
            }
        });

        txtContent13.setEditable(false);
        txtContent13.setText("Đánh giá về ý thức và kết quả chấp hành quy chế, nội quy, ...");
        txtContent13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent13ActionPerformed(evt);
            }
        });

        txtRole14.setEditable(false);
        txtRole14.setText("II.1");
        txtRole14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole14ActionPerformed(evt);
            }
        });

        txtContent14.setEditable(false);
        txtContent14.setText("Chấp hành tốt nội quy, quy chế của nhà trường");
        txtContent14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent14ActionPerformed(evt);
            }
        });

        txtScore12.setEditable(false);
        txtScore12.setText("15");
        txtScore12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore12ActionPerformed(evt);
            }
        });

        txtRole15.setEditable(false);
        txtRole15.setText("II.2");
        txtRole15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole15ActionPerformed(evt);
            }
        });

        txtContent15.setEditable(false);
        txtContent15.setText("Tham gia đầy đủ các buổi sự kiện do lớp, ....");
        txtContent15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent15ActionPerformed(evt);
            }
        });

        txtScore13.setEditable(false);
        txtScore13.setText("10");
        txtScore13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore13ActionPerformed(evt);
            }
        });

        txtRole16.setEditable(false);
        txtRole16.setText("II.3");
        txtRole16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole16ActionPerformed(evt);
            }
        });

        txtScore14.setEditable(false);
        txtScore14.setText("-10");
        txtScore14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore14ActionPerformed(evt);
            }
        });

        txtContent16.setEditable(false);
        txtContent16.setText("Vi phạm quy chế, quy định của nhà trường(...");
        txtContent16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent16ActionPerformed(evt);
            }
        });

        txtContent17.setEditable(false);
        txtContent17.setText("Vắng 1 buổi do lớp, trường tổ chức không ...");
        txtContent17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent17ActionPerformed(evt);
            }
        });

        txtScore15.setEditable(false);
        txtScore15.setText("-5");
        txtScore15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore15ActionPerformed(evt);
            }
        });

        txtRole17.setEditable(false);
        txtRole17.setText("II.4");
        txtRole17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole17ActionPerformed(evt);
            }
        });

        txtRole18.setEditable(false);
        txtRole18.setText("III");
        txtRole18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole18ActionPerformed(evt);
            }
        });

        txtContent18.setEditable(false);
        txtContent18.setText("Đáng giá về ý thức và kết quả tham gia các hoạt động văn hóa,...");
        txtContent18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent18ActionPerformed(evt);
            }
        });

        txtRole19.setEditable(false);
        txtRole19.setText("III.6");
        txtRole19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole19ActionPerformed(evt);
            }
        });

        txtContent19.setEditable(false);
        txtContent19.setText("Tham gia được khen thưởng cấp toàn quốc");
        txtContent19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent19ActionPerformed(evt);
            }
        });

        txtScore16.setEditable(false);
        txtScore16.setText("15");
        txtScore16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore16ActionPerformed(evt);
            }
        });

        txtRole20.setEditable(false);
        txtRole20.setText("III.5");
        txtRole20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole20ActionPerformed(evt);
            }
        });

        txtContent20.setEditable(false);
        txtContent20.setText("Tham gia văn nghệ, TDTT cấp tường");
        txtContent20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent20ActionPerformed(evt);
            }
        });

        txtRole21.setEditable(false);
        txtRole21.setText("III.1");
        txtRole21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole21ActionPerformed(evt);
            }
        });

        txtContent21.setEditable(false);
        txtContent21.setText("Tham gia các buổi sinh hoạt theo đúng quy ...");
        txtContent21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent21ActionPerformed(evt);
            }
        });

        txtScore17.setEditable(false);
        txtScore17.setText("10");
        txtScore17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore17ActionPerformed(evt);
            }
        });

        txtRole22.setEditable(false);
        txtRole22.setText("III.2");
        txtRole22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole22ActionPerformed(evt);
            }
        });

        txtContent22.setEditable(false);
        txtContent22.setText("Vắng mặt 1 buổi không có lý do");
        txtContent22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent22ActionPerformed(evt);
            }
        });

        txtScore18.setEditable(false);
        txtScore18.setText("-5");
        txtScore18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore18ActionPerformed(evt);
            }
        });

        txtRole23.setEditable(false);
        txtRole23.setText("III.3");
        txtRole23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole23ActionPerformed(evt);
            }
        });

        txtScore19.setEditable(false);
        txtScore19.setText("5");
        txtScore19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore19ActionPerformed(evt);
            }
        });

        txtContent23.setEditable(false);
        txtContent23.setText("Tham gia các hoạt động văn hóa, văn nghệ, ...");
        txtContent23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent23ActionPerformed(evt);
            }
        });

        txtContent24.setEditable(false);
        txtContent24.setText("Tham gia văn nghệ, TDTT trong lớp");
        txtContent24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent24ActionPerformed(evt);
            }
        });

        txtScore20.setEditable(false);
        txtScore20.setText("5");
        txtScore20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore20ActionPerformed(evt);
            }
        });

        txtRole24.setEditable(false);
        txtRole24.setText("III.4");
        txtRole24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole24ActionPerformed(evt);
            }
        });

        txtScore21.setEditable(false);
        txtScore21.setText("10");
        txtScore21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore21ActionPerformed(evt);
            }
        });

        txtRole25.setEditable(false);
        txtRole25.setText("IV");
        txtRole25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole25ActionPerformed(evt);
            }
        });

        txtContent25.setEditable(false);
        txtContent25.setText("Đánh giá về ý thức công dân trong quan hệ cộng đồng");
        txtContent25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent25ActionPerformed(evt);
            }
        });

        txtContent26.setEditable(false);
        txtContent26.setText("Vi phạm ATGT, trật tự công cộng");
        txtContent26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent26ActionPerformed(evt);
            }
        });

        txtScore22.setEditable(false);
        txtScore22.setText("-20");
        txtScore22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore22ActionPerformed(evt);
            }
        });

        txtRole26.setEditable(false);
        txtRole26.setText("IV.6");
        txtRole26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole26ActionPerformed(evt);
            }
        });

        txtRole27.setEditable(false);
        txtRole27.setText("IV.8");
        txtRole27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole27ActionPerformed(evt);
            }
        });

        txtContent27.setEditable(false);
        txtContent27.setText("Tham gia hiến máu tình nguyện");
        txtContent27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent27ActionPerformed(evt);
            }
        });

        txtScore23.setEditable(false);
        txtScore23.setText("5");
        txtScore23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore23ActionPerformed(evt);
            }
        });

        txtRole28.setEditable(false);
        txtRole28.setText("IV.5");
        txtRole28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole28ActionPerformed(evt);
            }
        });

        txtContent28.setEditable(false);
        txtContent28.setText("Có tinh thần chia sẻ, giúp đỡ người khó khăn,...");
        txtContent28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent28ActionPerformed(evt);
            }
        });

        txtRole29.setEditable(false);
        txtRole29.setText("IV.1");
        txtRole29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole29ActionPerformed(evt);
            }
        });

        txtContent29.setEditable(false);
        txtContent29.setText("Chấp hành tốt các chủ trương, chính sách, ...");
        txtContent29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent29ActionPerformed(evt);
            }
        });

        txtScore24.setEditable(false);
        txtScore24.setText("10");
        txtScore24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore24ActionPerformed(evt);
            }
        });

        txtRole30.setEditable(false);
        txtRole30.setText("IV.2");
        txtRole30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole30ActionPerformed(evt);
            }
        });

        txtContent30.setEditable(false);
        txtContent30.setText("Được biểu dương người tốt, việc tốt ở nhà trư...");
        txtContent30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent30ActionPerformed(evt);
            }
        });

        txtScore25.setEditable(false);
        txtScore25.setText("10");
        txtScore25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore25ActionPerformed(evt);
            }
        });

        txtRole31.setEditable(false);
        txtRole31.setText("IV.3");
        txtRole31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole31ActionPerformed(evt);
            }
        });

        txtScore26.setEditable(false);
        txtScore26.setText("10");
        txtScore26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore26ActionPerformed(evt);
            }
        });

        txtContent31.setEditable(false);
        txtContent31.setText("Tham gia các hoạt động tình nguyện trung hạn");
        txtContent31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent31ActionPerformed(evt);
            }
        });

        txtContent32.setEditable(false);
        txtContent32.setText("Tham gia các hoạt động xã hội và các ...");
        txtContent32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent32ActionPerformed(evt);
            }
        });

        txtScore27.setEditable(false);
        txtScore27.setText("10");
        txtScore27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore27ActionPerformed(evt);
            }
        });

        txtRole32.setEditable(false);
        txtRole32.setText("IV.7");
        txtRole32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole32ActionPerformed(evt);
            }
        });

        txtRole33.setEditable(false);
        txtRole33.setText("IV.4");
        txtRole33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole33ActionPerformed(evt);
            }
        });

        txtScore28.setEditable(false);
        txtScore28.setText("5");
        txtScore28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore28ActionPerformed(evt);
            }
        });

        txtScore29.setEditable(false);
        txtScore29.setText("5");
        txtScore29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore29ActionPerformed(evt);
            }
        });

        txtContent33.setEditable(false);
        txtContent33.setText("Tham gia hội tham GDQP-AN cấp Thành p...");
        txtContent33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent33ActionPerformed(evt);
            }
        });

        txtContent34.setEditable(false);
        txtContent34.setText("Đánh giá về ý thức và kết quả tham gia phụ trách lớp, các ...");
        txtContent34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent34ActionPerformed(evt);
            }
        });

        txtRole34.setEditable(false);
        txtRole34.setText("V");
        txtRole34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole34ActionPerformed(evt);
            }
        });

        txtRole35.setEditable(false);
        txtRole35.setText("V.6");
        txtRole35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole35ActionPerformed(evt);
            }
        });

        txtContent35.setEditable(false);
        txtContent35.setText("Đoàn viên TNCS Hồ Chí Minh");
        txtContent35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent35ActionPerformed(evt);
            }
        });

        txtScore30.setEditable(false);
        txtScore30.setText("3");
        txtScore30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore30ActionPerformed(evt);
            }
        });

        txtRole36.setEditable(false);
        txtRole36.setText("V.5");
        txtRole36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole36ActionPerformed(evt);
            }
        });

        txtContent36.setEditable(false);
        txtContent36.setText("Đối tượng Đảng");
        txtContent36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent36ActionPerformed(evt);
            }
        });

        txtRole37.setEditable(false);
        txtRole37.setText("V.1");
        txtRole37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole37ActionPerformed(evt);
            }
        });

        txtContent37.setEditable(false);
        txtContent37.setText("Lớp trưởng, BCH đoàn trường");
        txtContent37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent37ActionPerformed(evt);
            }
        });

        txtScore31.setEditable(false);
        txtScore31.setText("10");
        txtScore31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore31ActionPerformed(evt);
            }
        });

        txtRole38.setEditable(false);
        txtRole38.setText("V.2");
        txtRole38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole38ActionPerformed(evt);
            }
        });

        txtContent38.setEditable(false);
        txtContent38.setText("Lớp phó, Bí thư");
        txtContent38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent38ActionPerformed(evt);
            }
        });

        txtScore32.setEditable(false);
        txtScore32.setText("8");
        txtScore32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore32ActionPerformed(evt);
            }
        });

        txtRole39.setEditable(false);
        txtRole39.setText("V.3");
        txtRole39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole39ActionPerformed(evt);
            }
        });

        txtScore33.setEditable(false);
        txtScore33.setText("5");
        txtScore33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore33ActionPerformed(evt);
            }
        });

        txtContent39.setEditable(false);
        txtContent39.setText("Phó bí thư, Tổ trưởng");
        txtContent39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent39ActionPerformed(evt);
            }
        });

        txtContent40.setEditable(false);
        txtContent40.setText("Ủy viên, Tổ phó");
        txtContent40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent40ActionPerformed(evt);
            }
        });

        txtScore34.setEditable(false);
        txtScore34.setText("3");
        txtScore34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore34ActionPerformed(evt);
            }
        });

        txtRole40.setEditable(false);
        txtRole40.setText("V.7");
        txtRole40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole40ActionPerformed(evt);
            }
        });

        txtRole41.setEditable(false);
        txtRole41.setText("V.4");
        txtRole41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRole41ActionPerformed(evt);
            }
        });

        txtScore35.setEditable(false);
        txtScore35.setText("10");
        txtScore35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore35ActionPerformed(evt);
            }
        });

        txtScore36.setEditable(false);
        txtScore36.setText("5");
        txtScore36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScore36ActionPerformed(evt);
            }
        });

        txtContent41.setEditable(false);
        txtContent41.setText("Thành viên đội tuyển thi thành phố abc");
        txtContent41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContent41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormDisPanelLayout = new javax.swing.GroupLayout(FormDisPanel);
        FormDisPanel.setLayout(FormDisPanelLayout);
        FormDisPanelLayout.setHorizontalGroup(
            FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormDisPanelLayout.createSequentialGroup()
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(FormDisPanelLayout.createSequentialGroup()
                            .addComponent(txtRole17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtContent17, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtScore15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbox15))
                        .addGroup(FormDisPanelLayout.createSequentialGroup()
                            .addComponent(txtRole16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtContent16, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtScore14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbox14))
                        .addGroup(FormDisPanelLayout.createSequentialGroup()
                            .addComponent(txtRole15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtContent15, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtScore13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbox13))
                        .addGroup(FormDisPanelLayout.createSequentialGroup()
                            .addComponent(txtRole14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtContent14, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtScore12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbox12))
                        .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent13))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent9, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox8))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent12, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox11))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent10, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox9))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent11, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox10))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox7))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox6))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox4))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent8, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox3))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox2))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox1))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent4))))
                    .addGroup(FormDisPanelLayout.createSequentialGroup()
                        .addComponent(txtRole18, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContent18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(FormDisPanelLayout.createSequentialGroup()
                            .addComponent(txtRole25, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtContent25))
                        .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent19, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox20))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole20, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent20, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole24, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent24, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox19))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole23, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent23, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox18))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent22, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox17))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent21, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox16)))))
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole40, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent41, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore35, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox36))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole35, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent35, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore30, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox34))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole36, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent36, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore36, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox35))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole41, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent40, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore34, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox33))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole39, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent39, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore33, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox32))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole38, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent38, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore32, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox31))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole37, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent37, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore31, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox30))))
                        .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole27, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent26, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox22))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent33, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore28, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox29))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole26, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent27, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox27))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole28, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent28, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScore29, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbox28))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole33, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent32, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox26))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent31, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox25))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent30, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore25, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox24))
                                .addGroup(FormDisPanelLayout.createSequentialGroup()
                                    .addComponent(txtRole29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtContent29, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScore24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbox23)))
                            .addGroup(FormDisPanelLayout.createSequentialGroup()
                                .addComponent(txtRole34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContent34)))))
                .addGap(0, 213, Short.MAX_VALUE))
        );
        FormDisPanelLayout.setVerticalGroup(
            FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormDisPanelLayout.createSequentialGroup()
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox1)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox2)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox3)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox5)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox4)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox6)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox7)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox10)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox9)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox11)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox8)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContent13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox12)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox13)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox14)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox15)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContent18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox16)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox17)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox18)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox19)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox21)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox20)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContent25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox23)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox24)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox25)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox26)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox28)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox27)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox29)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox22)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContent34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox30)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox31)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox32)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox33)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox35)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox34)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbox36)
                    .addGroup(FormDisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRole40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContent41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScore35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DisResultScroll.setViewportView(FormDisPanel);

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel7.setText("Mục");

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel8.setText("Nội dung");

        jLabel9.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel10.setText("Điểm");

        javax.swing.GroupLayout studentdisFormPanelLayout = new javax.swing.GroupLayout(studentdisFormPanel);
        studentdisFormPanel.setLayout(studentdisFormPanelLayout);
        studentdisFormPanelLayout.setHorizontalGroup(
            studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentdisFormPanelLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentdisFormPanelLayout.createSequentialGroup()
                        .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(studentdisFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(studentdisFormPanelLayout.createSequentialGroup()
                                .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStudentDisID, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtStudentDisName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(DisResultScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentdisFormPanelLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        studentdisFormPanelLayout.setVerticalGroup(
            studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentdisFormPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentDisID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentDisName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(studentdisFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisResultScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout StudentDisDialogLayout = new javax.swing.GroupLayout(StudentDisDialog.getContentPane());
        StudentDisDialog.getContentPane().setLayout(StudentDisDialogLayout);
        StudentDisDialogLayout.setHorizontalGroup(
            StudentDisDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentDisDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentdisFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        StudentDisDialogLayout.setVerticalGroup(
            StudentDisDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentDisDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(studentdisFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        StudentDialog.setMinimumSize(new java.awt.Dimension(680, 373));
        StudentDialog.setModal(true);
        StudentDialog.setUndecorated(true);

        studentFormPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin học sinh"));

        jLabel25.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel25.setText("Mã Học Sinh");
        jLabel25.setEnabled(false);

        txtstdID.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel26.setText("Điểm miệng 1");

        jLabel27.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel27.setText("ĐIểm 1 tiết");

        jLabel28.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel28.setText("Điểm miệng 2");

        jLabel29.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel29.setText("Điểm 15p");

        txtmarkavg.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel30.setText("Điểm trung bình");

        jLabel31.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel31.setText("Điểm cuối kỳ");

        txtstdName.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabel32.setText("Tên Học Sinh");
        jLabel32.setEnabled(false);

        btnAddMark.setBackground(new java.awt.Color(209, 15, 209));
        btnAddMark.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMark.setText("Cập nhật");
        btnAddMark.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAddMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMarkActionPerformed(evt);
            }
        });

        btnEsc2.setBackground(new java.awt.Color(255, 0, 0));
        btnEsc2.setForeground(new java.awt.Color(255, 255, 255));
        btnEsc2.setText("Thoát");
        btnEsc2.setPreferredSize(new java.awt.Dimension(100, 35));
        btnEsc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsc2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentFormPanel1Layout = new javax.swing.GroupLayout(studentFormPanel1);
        studentFormPanel1.setLayout(studentFormPanel1Layout);
        studentFormPanel1Layout.setHorizontalGroup(
            studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentFormPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(studentFormPanel1Layout.createSequentialGroup()
                        .addGroup(studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(studentFormPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(txtstdID, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29)
                            .addComponent(txtmark15, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtmark2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(txtmark1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(studentFormPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(txtstdName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(txtmarkend, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(txtmark45, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmarkavg, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentFormPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEsc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        studentFormPanel1Layout.setVerticalGroup(
            studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentFormPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtstdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtstdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentFormPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmark1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmark2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmark15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentFormPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmark45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmarkend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmarkavg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(studentFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEsc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout StudentDialogLayout = new javax.swing.GroupLayout(StudentDialog.getContentPane());
        StudentDialog.getContentPane().setLayout(StudentDialogLayout);
        StudentDialogLayout.setHorizontalGroup(
            StudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        StudentDialogLayout.setVerticalGroup(
            StudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(1050, 600));

        studentTabbedPane.setPreferredSize(new java.awt.Dimension(1050, 600));

        studentPanel.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách học sinh"));

        studentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã học sinh", "Tên học sinh", "Điểm miệng 1", "Điểm miệng 2", "Điểm 15 phút", "Điểm 1 tiết", "Điểm cuối kì", "Điểm trung bình"
            }
        ));
        studentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(studentList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnShowEditDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N
        btnShowEditDialog.setPreferredSize(new java.awt.Dimension(70, 40));
        btnShowEditDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEditDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnShowEditDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnShowEditDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel3.setText("Lớp");

        jButton1.setText("Tìm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(178, 178, 178))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTabbedPane.addTab("Điểm", studentPanel);

        studentPanel1.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách học sinh"));

        studentdisList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã học sinh", "Tên học sinh", "Điểm", "Hành kiểm"
            }
        ));
        studentdisList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentdisListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentdisList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnShowEditDisDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N
        btnShowEditDisDialog.setPreferredSize(new java.awt.Dimension(70, 40));
        btnShowEditDisDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEditDisDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowEditDisDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnShowEditDisDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel13.setText("Họ tên");

        jLabel14.setText("Giới tính");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel15.setText("Lớp");

        jLabel16.setText("Khối");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khối 10", "Khối 11", "Khối 12" }));

        jButton2.setText("Tìm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel15)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel16))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout studentPanel1Layout = new javax.swing.GroupLayout(studentPanel1);
        studentPanel1.setLayout(studentPanel1Layout);
        studentPanel1Layout.setHorizontalGroup(
            studentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(studentPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        studentPanel1Layout.setVerticalGroup(
            studentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTabbedPane.addTab("Hành kiểm", studentPanel1);

        studentPanel2.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách học sinh"));

        resultList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã học sinh", "Tên học sinh", "Lớp", "Học kỳ", "Toán", "Văn", "Anh", "Vật Lý", "Hóa học", "Sinh học", "Lịch sử", "Địa lý", "GDCD", "Tổng kết", "Hành kiểm", "Xếp loại"
            }
        ));
        jScrollPane1.setViewportView(resultList);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnShowEditDisDialog1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N
        btnShowEditDisDialog1.setPreferredSize(new java.awt.Dimension(70, 40));
        btnShowEditDisDialog1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEditDisDialog1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowEditDisDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btnShowEditDisDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(78, 78, 78))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout studentPanel2Layout = new javax.swing.GroupLayout(studentPanel2);
        studentPanel2.setLayout(studentPanel2Layout);
        studentPanel2Layout.setHorizontalGroup(
            studentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(studentPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        studentPanel2Layout.setVerticalGroup(
            studentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTabbedPane.addTab("Học bạ", studentPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowEditDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEditDialogActionPerformed
        if (validateStudentForm()) {
            StudentDialog.setLocationRelativeTo(null);
            StudentDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học sinh cần sửa");
        }
    }//GEN-LAST:event_btnShowEditDialogActionPerformed

    private void btnShowEditDisDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEditDisDialogActionPerformed
        if (validateStudentDisForm()) {
            StudentDisDialog.setLocationRelativeTo(null);
            StudentDisDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học sinh cần sửa");
        }       // TODO add your handling code here:
    }//GEN-LAST:event_btnShowEditDisDialogActionPerformed

    private void btnEsc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsc1ActionPerformed
        // TODO add your handling code here:
        StudentDisDialog.setVisible(false);
    }//GEN-LAST:event_btnEsc1ActionPerformed

    private void btnAddStudentDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentDisActionPerformed
        float result = 0;
        if (cbox.isSelected()) {
            result += Float.parseFloat(txtScore.getText());
        }
        if (cbox1.isSelected()) {
            result += Float.parseFloat(txtScore1.getText());
        }
        if (cbox2.isSelected()) {
            result += Float.parseFloat(txtScore2.getText());
        }
        if (cbox3.isSelected()) {
            result += Float.parseFloat(txtScore3.getText());
        }
        if (cbox5.isSelected()) {
            result += Float.parseFloat(txtScore5.getText());
        }
        if (cbox4.isSelected()) {
            result += Float.parseFloat(txtScore7.getText());
        }
        if (cbox6.isSelected()) {
            result += Float.parseFloat(txtScore4.getText());
        }
        if (cbox10.isSelected()) {
            result += Float.parseFloat(txtScore11.getText());
        }
        if (cbox9.isSelected()) {
            result += Float.parseFloat(txtScore9.getText());
        }
        if (cbox11.isSelected()) {
            result += Float.parseFloat(txtScore10.getText());
        }
        if (cbox8.isSelected()) {
            result += Float.parseFloat(txtScore8.getText());
        }
        if (cbox12.isSelected()) {
            result += Float.parseFloat(txtScore12.getText());
        }
        if (cbox13.isSelected()) {
            result += Float.parseFloat(txtScore13.getText());
        }
        if (cbox14.isSelected()) {
            result += Float.parseFloat(txtScore14.getText());
        }
        if (cbox15.isSelected()) {
            result += Float.parseFloat(txtScore15.getText());
        }
        if (cbox16.isSelected()) {
            result += Float.parseFloat(txtScore17.getText());
        }
        if (cbox17.isSelected()) {
            result += Float.parseFloat(txtScore18.getText());
        }
        if (cbox18.isSelected()) {
            result += Float.parseFloat(txtScore19.getText());
        }
        if (cbox19.isSelected()) {
            result += Float.parseFloat(txtScore20.getText());
        }
        if (cbox21.isSelected()) {
            result += Float.parseFloat(txtScore21.getText());
        }
        if (cbox20.isSelected()) {
            result += Float.parseFloat(txtScore16.getText());
        }
        if (cbox23.isSelected()) {
            result += Float.parseFloat(txtScore24.getText());
        }
        if (cbox24.isSelected()) {
            result += Float.parseFloat(txtScore25.getText());
        }
        if (cbox25.isSelected()) {
            result += Float.parseFloat(txtScore26.getText());
        }
        if (cbox26.isSelected()) {
            result += Float.parseFloat(txtScore27.getText());
        }
        if (cbox28.isSelected()) {
            result += Float.parseFloat(txtScore29.getText());
        }
        if (cbox27.isSelected()) {
            result += Float.parseFloat(txtScore23.getText());
        }
        if (cbox29.isSelected()) {
            result += Float.parseFloat(txtScore28.getText());
        }
        if (cbox22.isSelected()) {
            result += Float.parseFloat(txtScore22.getText());
        }
        if (cbox30.isSelected()) {
            result += Float.parseFloat(txtScore31.getText());
        }
        if (cbox31.isSelected()) {
            result += Float.parseFloat(txtScore32.getText());
        }
        if (cbox32.isSelected()) {
            result += Float.parseFloat(txtScore33.getText());
        }
        if (cbox33.isSelected()) {
            result += Float.parseFloat(txtScore34.getText());
        }
        if (cbox35.isSelected()) {
            result += Float.parseFloat(txtScore36.getText());
        }
        if (cbox34.isSelected()) {
            result += Float.parseFloat(txtScore30.getText());
        }
        if (cbox36.isSelected()) {
            result += Float.parseFloat(txtScore35.getText());
        }
        if (result > 100) {
            result = 100;
        }
        String result2 = null;
        if (result < 50) {
            result2 = "Yếu";
        }
        if (result < 65 && result > 49) {
            result2 = "Trung bình";
        }
        if (result < 80 && result > 64) {
            result2 = "Khá";
        }
        if (result < 90 && result > 79) {
            result2 = "Tốt";
        }
        if (result > 89) {
            result2 = "Xuất sắc";
        }
        StudentDis studentdis = getStudentDisModel(result, result2);
        if (studentdisBUS.getStudentDisByID(studentdis.getStudentID()) == null) {
            if (studentdisBUS.addStudentDis(studentdis)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                loadDataStudentDisTable(uID);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        } else {
            if (studentdisBUS.editStudentDis(studentdis)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                loadDataStudentDisTable(uID);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
        loadDataStudentDisTable(uID);
        StudentDisDialog.setVisible(false);
    }//GEN-LAST:event_btnAddStudentDisActionPerformed

    private void txtStudentDisIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentDisIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentDisIDActionPerformed

    private void txtStudentDisNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentDisNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentDisNameActionPerformed

    private void txtRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoleActionPerformed

    private void txtContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContentActionPerformed

    private void txtScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScoreActionPerformed

    private void txtRole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole1ActionPerformed

    private void txtContent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent1ActionPerformed

    private void txtScore1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore1ActionPerformed

    private void txtRole2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole2ActionPerformed

    private void txtScore2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore2ActionPerformed

    private void txtContent2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent2ActionPerformed

    private void txtContent3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent3ActionPerformed

    private void txtScore3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore3ActionPerformed

    private void txtRole3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole3ActionPerformed

    private void txtRole4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole4ActionPerformed

    private void txtContent4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent4ActionPerformed

    private void txtRole5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole5ActionPerformed

    private void txtScore4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore4ActionPerformed

    private void txtScore5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore5ActionPerformed

    private void txtContent5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent5ActionPerformed

    private void txtContent6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent6ActionPerformed

    private void txtScore6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore6ActionPerformed

    private void txtRole6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole6ActionPerformed

    private void txtRole7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole7ActionPerformed

    private void txtContent7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent7ActionPerformed

    private void txtScore7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore7ActionPerformed

    private void txtRole8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole8ActionPerformed

    private void txtContent8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent8ActionPerformed

    private void txtContent9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent9ActionPerformed

    private void txtScore8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore8ActionPerformed

    private void txtRole9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole9ActionPerformed

    private void txtRole10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole10ActionPerformed

    private void txtContent10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent10ActionPerformed

    private void txtScore9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore9ActionPerformed

    private void txtRole11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole11ActionPerformed

    private void txtContent11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent11ActionPerformed

    private void txtRole12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole12ActionPerformed

    private void txtScore10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore10ActionPerformed

    private void txtScore11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore11ActionPerformed

    private void txtContent12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent12ActionPerformed

    private void txtRole13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole13ActionPerformed

    private void txtContent13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent13ActionPerformed

    private void txtRole14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole14ActionPerformed

    private void txtContent14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent14ActionPerformed

    private void txtScore12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore12ActionPerformed

    private void txtRole15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole15ActionPerformed

    private void txtContent15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent15ActionPerformed

    private void txtScore13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore13ActionPerformed

    private void txtRole16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole16ActionPerformed

    private void txtScore14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore14ActionPerformed

    private void txtContent16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent16ActionPerformed

    private void txtContent17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent17ActionPerformed

    private void txtScore15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore15ActionPerformed

    private void txtRole17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole17ActionPerformed

    private void txtRole18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole18ActionPerformed

    private void txtContent18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent18ActionPerformed

    private void txtRole19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole19ActionPerformed

    private void txtContent19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent19ActionPerformed

    private void txtScore16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore16ActionPerformed

    private void txtRole20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole20ActionPerformed

    private void txtContent20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent20ActionPerformed

    private void txtRole21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole21ActionPerformed

    private void txtContent21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent21ActionPerformed

    private void txtScore17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore17ActionPerformed

    private void txtRole22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole22ActionPerformed

    private void txtContent22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent22ActionPerformed

    private void txtScore18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore18ActionPerformed

    private void txtRole23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole23ActionPerformed

    private void txtScore19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore19ActionPerformed

    private void txtContent23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent23ActionPerformed

    private void txtContent24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent24ActionPerformed

    private void txtScore20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore20ActionPerformed

    private void txtRole24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole24ActionPerformed

    private void txtScore21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore21ActionPerformed

    private void txtRole25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole25ActionPerformed

    private void txtContent25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent25ActionPerformed

    private void txtContent26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent26ActionPerformed

    private void txtScore22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore22ActionPerformed

    private void txtRole26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole26ActionPerformed

    private void txtRole27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole27ActionPerformed

    private void txtContent27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent27ActionPerformed

    private void txtScore23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore23ActionPerformed

    private void txtRole28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole28ActionPerformed

    private void txtContent28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent28ActionPerformed

    private void txtRole29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole29ActionPerformed

    private void txtContent29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent29ActionPerformed

    private void txtScore24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore24ActionPerformed

    private void txtRole30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole30ActionPerformed

    private void txtContent30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent30ActionPerformed

    private void txtScore25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore25ActionPerformed

    private void txtRole31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole31ActionPerformed

    private void txtScore26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore26ActionPerformed

    private void txtContent31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent31ActionPerformed

    private void txtContent32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent32ActionPerformed

    private void txtScore27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore27ActionPerformed

    private void txtRole32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole32ActionPerformed

    private void txtRole33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole33ActionPerformed

    private void txtScore28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore28ActionPerformed

    private void txtScore29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore29ActionPerformed

    private void txtContent33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent33ActionPerformed

    private void txtContent34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent34ActionPerformed

    private void txtRole34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole34ActionPerformed

    private void txtRole35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole35ActionPerformed

    private void txtContent35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent35ActionPerformed

    private void txtScore30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore30ActionPerformed

    private void txtRole36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole36ActionPerformed

    private void txtContent36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent36ActionPerformed

    private void txtRole37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole37ActionPerformed

    private void txtContent37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent37ActionPerformed

    private void txtScore31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore31ActionPerformed

    private void txtRole38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole38ActionPerformed

    private void txtContent38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent38ActionPerformed

    private void txtScore32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore32ActionPerformed

    private void txtRole39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole39ActionPerformed

    private void txtScore33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore33ActionPerformed

    private void txtContent39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent39ActionPerformed

    private void txtContent40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent40ActionPerformed

    private void txtScore34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore34ActionPerformed

    private void txtRole40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole40ActionPerformed

    private void txtRole41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRole41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRole41ActionPerformed

    private void txtScore35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore35ActionPerformed

    private void txtScore36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScore36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtScore36ActionPerformed

    private void txtContent41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContent41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContent41ActionPerformed

    private void studentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentListMouseClicked
        int row = studentList.rowAtPoint(evt.getPoint());
        String studentID = studentList.getValueAt(row, 0).toString();
        Student student = studentBUS.getStudentByID(studentID);
        txtstdID.setText(student.getStudentID());
        txtstdName.setText(student.getStudentName());
    }//GEN-LAST:event_studentListMouseClicked

    private void btnAddMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMarkActionPerformed
        Mark mark = getStudentModel(uID);
        if (markBUS.getmarkbystdandteacher(mark.getStudentID(), uID) == null) {
            if (markBUS.addMark(mark)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            } else {
                System.out.println(" Hayở đây");
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        } else {
            if (markBUS.editmark(mark)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            } else {
                System.out.println("ở đây");
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
        loadDataStudentTable(uID);
        StudentDisDialog.setVisible(false);
    }//GEN-LAST:event_btnAddMarkActionPerformed

    private void btnEsc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsc2ActionPerformed
        StudentDialog.setVisible(false);
    }//GEN-LAST:event_btnEsc2ActionPerformed

    private void studentdisListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentdisListMouseClicked
        int row = studentdisList.rowAtPoint(evt.getPoint());
        String studentID = studentdisList.getValueAt(row, 0).toString();
        Student student = studentBUS.getStudentByID(studentID);
        txtStudentDisID.setText(student.getStudentID());
        txtStudentDisName.setText(student.getStudentName());
    }//GEN-LAST:event_studentdisListMouseClicked

    private void btnShowEditDisDialog1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEditDisDialog1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowEditDisDialog1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane DisResultScroll;
    private javax.swing.JPanel FormDisPanel;
    private javax.swing.JDialog StudentDialog;
    private javax.swing.JDialog StudentDisDialog;
    private javax.swing.JButton btnAddMark;
    private javax.swing.JButton btnAddStudentDis;
    private javax.swing.JButton btnEsc1;
    private javax.swing.JButton btnEsc2;
    private javax.swing.JButton btnShowEditDialog;
    private javax.swing.JButton btnShowEditDisDialog;
    private javax.swing.JButton btnShowEditDisDialog1;
    private javax.swing.JCheckBox cbox;
    private javax.swing.JCheckBox cbox1;
    private javax.swing.JCheckBox cbox10;
    private javax.swing.JCheckBox cbox11;
    private javax.swing.JCheckBox cbox12;
    private javax.swing.JCheckBox cbox13;
    private javax.swing.JCheckBox cbox14;
    private javax.swing.JCheckBox cbox15;
    private javax.swing.JCheckBox cbox16;
    private javax.swing.JCheckBox cbox17;
    private javax.swing.JCheckBox cbox18;
    private javax.swing.JCheckBox cbox19;
    private javax.swing.JCheckBox cbox2;
    private javax.swing.JCheckBox cbox20;
    private javax.swing.JCheckBox cbox21;
    private javax.swing.JCheckBox cbox22;
    private javax.swing.JCheckBox cbox23;
    private javax.swing.JCheckBox cbox24;
    private javax.swing.JCheckBox cbox25;
    private javax.swing.JCheckBox cbox26;
    private javax.swing.JCheckBox cbox27;
    private javax.swing.JCheckBox cbox28;
    private javax.swing.JCheckBox cbox29;
    private javax.swing.JCheckBox cbox3;
    private javax.swing.JCheckBox cbox30;
    private javax.swing.JCheckBox cbox31;
    private javax.swing.JCheckBox cbox32;
    private javax.swing.JCheckBox cbox33;
    private javax.swing.JCheckBox cbox34;
    private javax.swing.JCheckBox cbox35;
    private javax.swing.JCheckBox cbox36;
    private javax.swing.JCheckBox cbox4;
    private javax.swing.JCheckBox cbox5;
    private javax.swing.JCheckBox cbox6;
    private javax.swing.JCheckBox cbox7;
    private javax.swing.JCheckBox cbox8;
    private javax.swing.JCheckBox cbox9;
    private javax.swing.JComboBox<String> cboxStudent;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable resultList;
    private javax.swing.JPanel studentFormPanel1;
    private javax.swing.JTable studentList;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JPanel studentPanel1;
    private javax.swing.JPanel studentPanel2;
    private javax.swing.JTabbedPane studentTabbedPane;
    private javax.swing.JPanel studentdisFormPanel;
    private javax.swing.JTable studentdisList;
    private javax.swing.JTextField txtContent;
    private javax.swing.JTextField txtContent1;
    private javax.swing.JTextField txtContent10;
    private javax.swing.JTextField txtContent11;
    private javax.swing.JTextField txtContent12;
    private javax.swing.JTextField txtContent13;
    private javax.swing.JTextField txtContent14;
    private javax.swing.JTextField txtContent15;
    private javax.swing.JTextField txtContent16;
    private javax.swing.JTextField txtContent17;
    private javax.swing.JTextField txtContent18;
    private javax.swing.JTextField txtContent19;
    private javax.swing.JTextField txtContent2;
    private javax.swing.JTextField txtContent20;
    private javax.swing.JTextField txtContent21;
    private javax.swing.JTextField txtContent22;
    private javax.swing.JTextField txtContent23;
    private javax.swing.JTextField txtContent24;
    private javax.swing.JTextField txtContent25;
    private javax.swing.JTextField txtContent26;
    private javax.swing.JTextField txtContent27;
    private javax.swing.JTextField txtContent28;
    private javax.swing.JTextField txtContent29;
    private javax.swing.JTextField txtContent3;
    private javax.swing.JTextField txtContent30;
    private javax.swing.JTextField txtContent31;
    private javax.swing.JTextField txtContent32;
    private javax.swing.JTextField txtContent33;
    private javax.swing.JTextField txtContent34;
    private javax.swing.JTextField txtContent35;
    private javax.swing.JTextField txtContent36;
    private javax.swing.JTextField txtContent37;
    private javax.swing.JTextField txtContent38;
    private javax.swing.JTextField txtContent39;
    private javax.swing.JTextField txtContent4;
    private javax.swing.JTextField txtContent40;
    private javax.swing.JTextField txtContent41;
    private javax.swing.JTextField txtContent5;
    private javax.swing.JTextField txtContent6;
    private javax.swing.JTextField txtContent7;
    private javax.swing.JTextField txtContent8;
    private javax.swing.JTextField txtContent9;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtRole1;
    private javax.swing.JTextField txtRole10;
    private javax.swing.JTextField txtRole11;
    private javax.swing.JTextField txtRole12;
    private javax.swing.JTextField txtRole13;
    private javax.swing.JTextField txtRole14;
    private javax.swing.JTextField txtRole15;
    private javax.swing.JTextField txtRole16;
    private javax.swing.JTextField txtRole17;
    private javax.swing.JTextField txtRole18;
    private javax.swing.JTextField txtRole19;
    private javax.swing.JTextField txtRole2;
    private javax.swing.JTextField txtRole20;
    private javax.swing.JTextField txtRole21;
    private javax.swing.JTextField txtRole22;
    private javax.swing.JTextField txtRole23;
    private javax.swing.JTextField txtRole24;
    private javax.swing.JTextField txtRole25;
    private javax.swing.JTextField txtRole26;
    private javax.swing.JTextField txtRole27;
    private javax.swing.JTextField txtRole28;
    private javax.swing.JTextField txtRole29;
    private javax.swing.JTextField txtRole3;
    private javax.swing.JTextField txtRole30;
    private javax.swing.JTextField txtRole31;
    private javax.swing.JTextField txtRole32;
    private javax.swing.JTextField txtRole33;
    private javax.swing.JTextField txtRole34;
    private javax.swing.JTextField txtRole35;
    private javax.swing.JTextField txtRole36;
    private javax.swing.JTextField txtRole37;
    private javax.swing.JTextField txtRole38;
    private javax.swing.JTextField txtRole39;
    private javax.swing.JTextField txtRole4;
    private javax.swing.JTextField txtRole40;
    private javax.swing.JTextField txtRole41;
    private javax.swing.JTextField txtRole5;
    private javax.swing.JTextField txtRole6;
    private javax.swing.JTextField txtRole7;
    private javax.swing.JTextField txtRole8;
    private javax.swing.JTextField txtRole9;
    private javax.swing.JTextField txtScore;
    private javax.swing.JTextField txtScore1;
    private javax.swing.JTextField txtScore10;
    private javax.swing.JTextField txtScore11;
    private javax.swing.JTextField txtScore12;
    private javax.swing.JTextField txtScore13;
    private javax.swing.JTextField txtScore14;
    private javax.swing.JTextField txtScore15;
    private javax.swing.JTextField txtScore16;
    private javax.swing.JTextField txtScore17;
    private javax.swing.JTextField txtScore18;
    private javax.swing.JTextField txtScore19;
    private javax.swing.JTextField txtScore2;
    private javax.swing.JTextField txtScore20;
    private javax.swing.JTextField txtScore21;
    private javax.swing.JTextField txtScore22;
    private javax.swing.JTextField txtScore23;
    private javax.swing.JTextField txtScore24;
    private javax.swing.JTextField txtScore25;
    private javax.swing.JTextField txtScore26;
    private javax.swing.JTextField txtScore27;
    private javax.swing.JTextField txtScore28;
    private javax.swing.JTextField txtScore29;
    private javax.swing.JTextField txtScore3;
    private javax.swing.JTextField txtScore30;
    private javax.swing.JTextField txtScore31;
    private javax.swing.JTextField txtScore32;
    private javax.swing.JTextField txtScore33;
    private javax.swing.JTextField txtScore34;
    private javax.swing.JTextField txtScore35;
    private javax.swing.JTextField txtScore36;
    private javax.swing.JTextField txtScore4;
    private javax.swing.JTextField txtScore5;
    private javax.swing.JTextField txtScore6;
    private javax.swing.JTextField txtScore7;
    private javax.swing.JTextField txtScore8;
    private javax.swing.JTextField txtScore9;
    private javax.swing.JTextField txtStudentDisID;
    private javax.swing.JTextField txtStudentDisName;
    private javax.swing.JTextField txtmark1;
    private javax.swing.JTextField txtmark15;
    private javax.swing.JTextField txtmark2;
    private javax.swing.JTextField txtmark45;
    private javax.swing.JTextField txtmarkavg;
    private javax.swing.JTextField txtmarkend;
    private javax.swing.JTextField txtstdID;
    private javax.swing.JTextField txtstdName;
    // End of variables declaration//GEN-END:variables

}
