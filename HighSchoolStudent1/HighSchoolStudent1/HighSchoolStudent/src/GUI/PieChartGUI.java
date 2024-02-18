package GUI;

import BUS.ClassBUS;
import BUS.MarkBUS;
import BUS.StudentBUS;
import BUS.StudentDisBUS;
import BUS.SubjectBUS;
import BUS.TeacherBUS;
import BUS.TeachingAssignmentBUS;
import DTO.Mark;
import DTO.Student;
import DTO.StudentDis;
import DTO.Subject;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import raven.chart.data.pie.DefaultPieDataset;
import raven.chart.pie.PieChart;

public class PieChartGUI extends javax.swing.JPanel {

    /**
     * Creates new form PieChartGUI
     */
    StudentBUS studentBUS = new StudentBUS();
    ClassBUS classBUS = new ClassBUS();
    MarkBUS markBUS = new MarkBUS();
    TeacherBUS teacherBUS = new TeacherBUS();
    StudentDisBUS studentDisBUS = new StudentDisBUS();
    SubjectBUS subjectBUS = new SubjectBUS();
    PieChart pieChart3 = new PieChart();
    PieChart pieChart2 = new PieChart();
    PieChart pieChart1 = new PieChart();

    public PieChartGUI() {
        initComponents();
        LoadComboboxClass();
        LoadComboboxSubject();
        createDisChart();
        createGenderChart();
    }

    public void LoadComboboxClass() {
        DefaultComboBoxModel comboClass = new DefaultComboBoxModel();
        comboClass.addElement("");
        for (DTO.Class cl : classBUS.getAllClass()) {
            comboClass.addElement(cl.getClassID());
        }
        comboboxClass.setModel(comboClass);
    }

    public void LoadComboboxSubject() {
        DefaultComboBoxModel comboSubject = new DefaultComboBoxModel();
        comboSubject.addElement("");
        for (Subject subject : subjectBUS.getAllSubjects()) {
            comboSubject.addElement(subject.getSubjectName());
        }
        comboboxSubject.setModel(comboSubject);
        comboSubject.setSelectedItem("Toán");
    }

    private void createDisChart() {
        this.pieChart3 = new PieChart();
        JLabel header3 = new JLabel("Hạnh Kiểm");
        header3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1");
        pieChart3.setHeader(header3);
        pieChart3.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart3.setChartType(PieChart.ChartType.DONUT_CHART);
        pieChart3.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart3.setDataset(disData());
        pieChart3.setPreferredSize(new Dimension(300, 250));

        statisticPanel.add(pieChart3);
    }

    // tạo biểu đồ tròn hạnh kiểm các lớp
    private void createDisChart(String classID) {
        this.pieChart3 = new PieChart();
        JLabel header3 = new JLabel("Hạnh Kiểm");
        header3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1");
        pieChart3.setHeader(header3);
        pieChart3.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart3.setChartType(PieChart.ChartType.DONUT_CHART);
        pieChart3.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart3.setDataset(disData(classID));
        pieChart3.setPreferredSize(new Dimension(300, 250));

        statisticPanel.add(pieChart3);
    }

    public void createGenderChart() {
        pieChart1 = new PieChart();
        JLabel header1 = new JLabel("Giới Tính");
        header1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1");
        pieChart1.setHeader(header1);
        pieChart1.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart1.setDataset(genderData());
        pieChart1.setPreferredSize(new Dimension(300, 250));
        statisticPanel.add(pieChart1);
    }

    public void createGenderChart(String classID) {
        pieChart1 = new PieChart();
        JLabel header1 = new JLabel("Giới Tính");
        header1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1");
        pieChart1.setHeader(header1);
        pieChart1.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart1.setDataset(genderData(classID));
        pieChart1.setPreferredSize(new Dimension(300, 250));
        statisticPanel.add(pieChart1);
    }

    private void createMarkChart() {

        pieChart2 = new PieChart();
        JLabel header2 = new JLabel("Điểm trung binh môn " + comboboxSubject.getSelectedItem().toString() + "");
        header2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1");
        pieChart2.setHeader(header2);
        pieChart2.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart2.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart2.setDataset(markData());
        pieChart2.setPreferredSize(new Dimension(300, 250));

        statisticPanel.add(pieChart2);

    }

    private void createMarkChart(String classID) {

        pieChart2 = new PieChart();
        JLabel header2 = new JLabel("Điểm trung binh môn toán");
        header2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1");
        pieChart2.setHeader(header2);
        pieChart2.getChartColor().addColor(Color.decode("#f87171"), Color.decode("#fb923c"), Color.decode("#fbbf24"), Color.decode("#a3e635"), Color.decode("#34d399"), Color.decode("#22d3ee"), Color.decode("#818cf8"), Color.decode("#c084fc"));
        pieChart2.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        pieChart2.setDataset(markData(classID));
        pieChart2.setPreferredSize(new Dimension(300, 250));

        statisticPanel.add(pieChart2);

    }

    private DefaultPieDataset createPieData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        Random random = new Random();
        dataset.addValue("Bags", random.nextInt(100) + 50);
        dataset.addValue("Hats", random.nextInt(100) + 50);
        dataset.addValue("Glasses", random.nextInt(100) + 50);
        dataset.addValue("Watches", random.nextInt(100) + 50);
        dataset.addValue("Jewelry", random.nextInt(100) + 50);
        return dataset;
    }

    private DefaultPieDataset genderData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        int male = 0;
        int female = 0;
        for (Student student : studentBUS.getAllStudent()) {
            if (student.getGender().equals("Nam")) {
                male++;
            } else {
                female++;
            }
        }
        dataset.addValue("Nam", male);
        dataset.addValue("Nữ", female);
        return dataset;
    }

    private DefaultPieDataset genderData(String classID) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        int male = 0;
        int female = 0;
        for (Student student : studentBUS.getAllStudent()) {
            if (student.getClassID().equals(classID)) {
                if (student.getGender().equals("Nam")) {
                    male++;
                } else {
                    female++;
                }
            }
        }
        dataset.addValue("Nam", male);
        dataset.addValue("Nữ", female);
        return dataset;
    }

    private DefaultPieDataset markData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        String subjectID = subjectBUS.getSubjectByName(comboboxSubject.getSelectedItem().toString()).getSubjectID();
        int above = 0;
        int under = 0;
        for (Mark mark : markBUS.getAllMark()) {
            if (teacherBUS.getTeacherByID(mark.getTeacherId()).getSubjectID().equals(subjectID)) {
                if (mark.getMark_avg() > 5) {
                    above++;
                } else {
                    under++;
                }
            }

        }
        dataset.addValue("Trên trung bình", above);
        dataset.addValue("Dưới trung bình", under);
        return dataset;
    }

    private DefaultPieDataset markData(String classID) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        String subjectID = subjectBUS.getSubjectByName(comboboxSubject.getSelectedItem().toString()).getSubjectID();
        int above = 0;
        int under = 0;
        for (Mark mark : markBUS.getAllMark()) {
            Student student = studentBUS.getStudentByID(mark.getStudentID());
            if (student.getClassID().equals(classID)) {
                if (teacherBUS.getTeacherByID(mark.getTeacherId()).getSubjectID().equals(subjectID)) {
                    if (mark.getMark_avg() > 5) {
                        above++;
                    } else {
                        under++;
                    }
                }
            }
        }
        dataset.addValue("Trên trung bình", above);
        dataset.addValue("Dưới trung bình", under);
        return dataset;
    }

//    private DefaultPieDataset markData(String)
    private DefaultPieDataset disData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;
        for (StudentDis studentDis : studentDisBUS.getAllStudentDis()) {
            if (studentDis.getResult().equals("Yếu")) {
                F++;
            } else if (studentDis.getResult().equals("Trung bình")) {
                D++;
            } else if (studentDis.getResult().equals("Khá")) {
                C++;
            } else if (studentDis.getResult().equals("Tốt")) {
                B++;
            } else if (studentDis.getResult().equals("Xuất sắc")) {
                A++;
            }
        }
        dataset.addValue("Xuất Sắc", A);
        dataset.addValue("Tốt", B);
        dataset.addValue("Khá", C);
        dataset.addValue("Trung Bình", D);
        dataset.addValue("Yếu", F);

        return dataset;
    }

    private DefaultPieDataset disData(String classID) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;

        for (StudentDis studentDis : studentDisBUS.getAllStudentDis()) {
            Student student = studentBUS.getStudentByID(studentDis.getStudentID());
            if (student.getClassID().equals(classID)) {
                if (studentDis.getResult().equals("Yếu")) {
                    F++;
                } else if (studentDis.getResult().equals("Trung bình")) {
                    D++;
                } else if (studentDis.getResult().equals("Khá")) {
                    C++;
                } else if (studentDis.getResult().equals("Tốt")) {
                    B++;
                } else if (studentDis.getResult().equals("Xuất sắc")) {
                    A++;

                }
            }

        }
        dataset.addValue("Xuất sắc", A);
        dataset.addValue("Tốt", B);
        dataset.addValue("Khá", C);
        dataset.addValue("Trung bình", D);
        dataset.addValue("Yếu", F);

        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboboxClass = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        statisticPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        comboboxSubject = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1050, 600));
        setPreferredSize(new java.awt.Dimension(1050, 600));

        comboboxClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxClassActionPerformed(evt);
            }
        });

        jLabel1.setText("Lớp");

        statisticPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê"));

        jButton1.setText("Xem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboboxSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Môn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statisticPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxClass, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(comboboxSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statisticPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxClassActionPerformed
        // TODO add your handling code here:
        if (comboboxClass.getSelectedItem().toString().equals("")) {
            statisticPanel.repaint();
            statisticPanel.revalidate();
            statisticPanel.remove(this.pieChart3);
            statisticPanel.revalidate();
            statisticPanel.repaint();

            statisticPanel.revalidate();
            statisticPanel.repaint();
            statisticPanel.remove(this.pieChart1);
            statisticPanel.revalidate();
            statisticPanel.repaint();

            createDisChart();
            createGenderChart();
        } else {
            this.statisticPanel.remove(this.pieChart3);
            createDisChart(comboboxClass.getSelectedItem().toString());
            this.statisticPanel.remove(this.pieChart1);
            createGenderChart(comboboxClass.getSelectedItem().toString());
        }
    }//GEN-LAST:event_comboboxClassActionPerformed

    public void resetPanel(JPanel panel) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        panel.repaint();
        panel.revalidate();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resetPanel(statisticPanel);
        String classID = comboboxClass.getSelectedItem().toString();
        if (classID.equals("")) {
            createGenderChart();
            createDisChart();
            createMarkChart();
        } else {
            createGenderChart(classID);
            createDisChart(classID);
            createMarkChart(classID);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboboxClass;
    private javax.swing.JComboBox<String> comboboxSubject;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel statisticPanel;
    // End of variables declaration//GEN-END:variables
}
