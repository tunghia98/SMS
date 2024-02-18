package GUI;

import BUS.SchoolYearBUS;
import BUS.SemesterBUS;
import DTO.SchoolYear;
import DTO.Semester;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SchoolYearPanel extends javax.swing.JPanel {

    SchoolYearBUS schoolYearBUS = new SchoolYearBUS();
    SemesterBUS semesterBUS = new SemesterBUS();

    public SchoolYearPanel() {
        initComponents();
        LoadDataTableSchoolYear();
        LoadDataTableSemester();
        LoadComboboxSchoolYear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputSchoolYearDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSchoolYearID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        csStartDate = new com.toedter.calendar.JDateChooser();
        txtSchoolYearName = new javax.swing.JTextField();
        csEndDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnAddSchoolYear = new javax.swing.JButton();
        btnEditSchoolYear = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        InputSemesterDialog = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSemesterID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSemesterName = new javax.swing.JTextField();
        csStartDate_Semester = new com.toedter.calendar.JDateChooser();
        csEndDate_Semester = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboboxSchoolYear = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        btnAddSemester = new javax.swing.JButton();
        btnEditSemester = new javax.swing.JButton();
        btnEsc1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnShowEditSemesterDialog = new javax.swing.JButton();
        btnDeleteSemester = new javax.swing.JButton();
        btnShowSemesterDialog = new javax.swing.JButton();
        btnExportExcelSemester = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        semesterList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        schoolYearList = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnShowSchoolYearDialog = new javax.swing.JButton();
        btnShowEditSchoolYearDialog = new javax.swing.JButton();
        btnDeleteSchoolYear = new javax.swing.JButton();
        btnExportExcelSchoolYear = new javax.swing.JButton();

        InputSchoolYearDialog.setMinimumSize(new java.awt.Dimension(315, 378));
        InputSchoolYearDialog.setModal(true);
        InputSchoolYearDialog.setUndecorated(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin năm học"));

        jLabel2.setText("Mã năm học");

        jLabel3.setText("Tên năm học");

        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setText("Ngày kết thúc");

        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        btnAddSchoolYear.setBackground(new java.awt.Color(209, 15, 209));
        btnAddSchoolYear.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSchoolYear.setText("Thêm");
        btnAddSchoolYear.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAddSchoolYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSchoolYearActionPerformed(evt);
            }
        });
        jPanel11.add(btnAddSchoolYear);

        btnEditSchoolYear.setBackground(new java.awt.Color(255, 153, 51));
        btnEditSchoolYear.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSchoolYear.setText("Sửa");
        btnEditSchoolYear.setPreferredSize(new java.awt.Dimension(100, 35));
        btnEditSchoolYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSchoolYearActionPerformed(evt);
            }
        });
        jPanel11.add(btnEditSchoolYear);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(csEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(csStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtSchoolYearName, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtSchoolYearID)
                            .addComponent(jLabel2))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {csEndDate, csStartDate, txtSchoolYearID, txtSchoolYearName});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSchoolYearID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSchoolYearName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {csEndDate, csStartDate, txtSchoolYearID, txtSchoolYearName});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        javax.swing.GroupLayout InputSchoolYearDialogLayout = new javax.swing.GroupLayout(InputSchoolYearDialog.getContentPane());
        InputSchoolYearDialog.getContentPane().setLayout(InputSchoolYearDialogLayout);
        InputSchoolYearDialogLayout.setHorizontalGroup(
            InputSchoolYearDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InputSchoolYearDialogLayout.setVerticalGroup(
            InputSchoolYearDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputSchoolYearDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        InputSemesterDialog.setMinimumSize(new java.awt.Dimension(303, 463));
        InputSemesterDialog.setModal(true);
        InputSemesterDialog.setUndecorated(true);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin học kỳ"));

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel6.setText("Mã học kỳ");

        txtSemesterID.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel7.setText("Tên học kỳ");

        txtSemesterName.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel8.setText("Ngày bắt đầu");

        jLabel9.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel9.setText("Ngày kết thúc");

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel10.setText("Năm học");

        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        btnAddSemester.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSemester.setText("Thêm");
        btnAddSemester.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAddSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSemesterActionPerformed(evt);
            }
        });
        jPanel12.add(btnAddSemester);

        btnEditSemester.setBackground(new java.awt.Color(255, 153, 51));
        btnEditSemester.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSemester.setText("Sửa");
        btnEditSemester.setPreferredSize(new java.awt.Dimension(100, 35));
        btnEditSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSemesterActionPerformed(evt);
            }
        });
        jPanel12.add(btnEditSemester);

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboboxSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(csEndDate_Semester, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(csStartDate_Semester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSemesterName)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(txtSemesterID, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(37, 37, 37))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSemesterID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSemesterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csStartDate_Semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csEndDate_Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboboxSchoolYear, csEndDate_Semester, csStartDate_Semester});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel6, jLabel8, jLabel9});

        javax.swing.GroupLayout InputSemesterDialogLayout = new javax.swing.GroupLayout(InputSemesterDialog.getContentPane());
        InputSemesterDialog.getContentPane().setLayout(InputSemesterDialogLayout);
        InputSemesterDialogLayout.setHorizontalGroup(
            InputSemesterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InputSemesterDialogLayout.setVerticalGroup(
            InputSemesterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputSemesterDialogLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setPreferredSize(new java.awt.Dimension(1050, 600));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel3.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));
        jPanel8.setPreferredSize(new java.awt.Dimension(394, 89));

        btnShowEditSemesterDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N
        btnShowEditSemesterDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEditSemesterDialogActionPerformed(evt);
            }
        });

        btnDeleteSemester.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Remove.png"))); // NOI18N
        btnDeleteSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSemesterActionPerformed(evt);
            }
        });

        btnShowSemesterDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Add.png"))); // NOI18N
        btnShowSemesterDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSemesterDialogActionPerformed(evt);
            }
        });

        btnExportExcelSemester.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/XLS.png"))); // NOI18N
        btnExportExcelSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelSemesterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowSemesterDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowEditSemesterDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportExcelSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExportExcelSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnShowEditSemesterDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnDeleteSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShowSemesterDialog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách học kỳ"));

        semesterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã học kỳ", "Tên học kỳ", "Ngày bắt đầu", "Ngày kết thúc", "Năm học"
            }
        ));
        semesterList.setRowHeight(30);
        semesterList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                semesterListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(semesterList);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Học kỳ", jPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 600));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách năm học"));

        schoolYearList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã năm học", "Tên năm học", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        schoolYearList.setRowHeight(30);
        schoolYearList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schoolYearListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(schoolYearList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnShowSchoolYearDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Add.png"))); // NOI18N
        btnShowSchoolYearDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSchoolYearDialogActionPerformed(evt);
            }
        });

        btnShowEditSchoolYearDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit.png"))); // NOI18N
        btnShowEditSchoolYearDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEditSchoolYearDialogActionPerformed(evt);
            }
        });

        btnDeleteSchoolYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Remove.png"))); // NOI18N
        btnDeleteSchoolYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSchoolYearActionPerformed(evt);
            }
        });

        btnExportExcelSchoolYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/XLS.png"))); // NOI18N
        btnExportExcelSchoolYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelSchoolYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShowSchoolYearDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowEditSchoolYearDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportExcelSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowEditSchoolYearDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowSchoolYearDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportExcelSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Năm học", jPanel1);

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

    public void LoadDataTableSchoolYear() {
        DefaultTableModel model = (DefaultTableModel) schoolYearList.getModel();
        model.setRowCount(0); // xóa table 
        for (SchoolYear schoolYear : schoolYearBUS.getAllSchoolYear()) {

            Object dataRow[] = new Object[4];
            dataRow[0] = schoolYear.getSchoolYearID();
            dataRow[1] = schoolYear.getSchoolYearName();
            dataRow[2] = schoolYear.getStartDate();
            dataRow[3] = schoolYear.getEndDate();
            model.addRow(dataRow);
        }
    }

    public void LoadDataTableSemester() {
        DefaultTableModel model = (DefaultTableModel) semesterList.getModel();
        model.setRowCount(0);
        for (Semester semester : semesterBUS.getAllSemester()) {
            Object dataRow[] = new Object[5];
            dataRow[0] = semester.getSemesterID();
            dataRow[1] = semester.getSemesterName();
            dataRow[2] = semester.getStartDate();
            dataRow[3] = semester.getEndDate();
            String schoolYearName = schoolYearBUS.getSchoolYearByID(semester.getSchoolYearID()).getSchoolYearName();
            dataRow[4] = schoolYearName;
            model.addRow(dataRow);
        }
    }

    public void LoadComboboxSchoolYear() {
        DefaultComboBoxModel comboSchoolYear = new DefaultComboBoxModel();
        comboSchoolYear.addElement("");
        for (SchoolYear schoolYear : schoolYearBUS.getAllSchoolYear()) {
            comboSchoolYear.addElement(schoolYear.getSchoolYearName());
        }
        comboboxSchoolYear.setModel(comboSchoolYear);
    }

    public SchoolYear getSchoolYearModel() {
        SchoolYear schoolYear = new SchoolYear();
        if (txtSchoolYearID.getText().startsWith("NH")) {
            schoolYear.setSchoolYearID(txtSchoolYearID.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Mã năm học phải bắt đầu bằng NH - Ví dụ NH1920 - tương đương năm học 2019 - 2020");
        }        
        schoolYear.setSchoolYearName(txtSchoolYearName.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = sdf.format(csStartDate.getDate());
        schoolYear.setStartDate(startDate);
        String endDate = sdf.format(csEndDate.getDate());
        schoolYear.setEndDate(endDate);
        return schoolYear;
    }

    public void setSchoolYearModel(SchoolYear schoolYear) {
        txtSchoolYearID.setText(schoolYear.getSchoolYearID());
        txtSchoolYearName.setText(schoolYear.getSchoolYearName());
        java.util.Date startDate;
        java.util.Date endDate;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(schoolYear.getStartDate());
            csStartDate.setDate(startDate);
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(schoolYear.getEndDate());
            csEndDate.setDate(endDate);

        } catch (ParseException ex) {
            Logger.getLogger(SchoolYearPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resetFormSchoolYear() {
        txtSchoolYearID.setText("");
        txtSchoolYearName.setText("");
    }

    // hiển thị form nhập năm học
    private void btnShowSchoolYearDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSchoolYearDialogActionPerformed

        resetFormSchoolYear();
        txtSchoolYearID.enable(true);
        InputSchoolYearDialog.setLocationRelativeTo(null);
        btnAddSchoolYear.setVisible(true);
        btnEditSchoolYear.setVisible(false);
        InputSchoolYearDialog.setVisible(true);

    }//GEN-LAST:event_btnShowSchoolYearDialogActionPerformed

    // xử lý khi ấn vào danh sách năm học
    private void schoolYearListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schoolYearListMouseClicked
        // TODO add your handling code here:
        int row = schoolYearList.rowAtPoint(evt.getPoint());
        String schoolYearID = schoolYearList.getValueAt(row, 0).toString();
        SchoolYear schoolYear = schoolYearBUS.getSchoolYearByID(schoolYearID);
        setSchoolYearModel(schoolYear);
    }//GEN-LAST:event_schoolYearListMouseClicked

    // Hiển thị form sửa năm học
    private void btnShowEditSchoolYearDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEditSchoolYearDialogActionPerformed
        if (validateFormSchoolYear()) {
            InputSchoolYearDialog.setLocationRelativeTo(null);
            btnAddSchoolYear.setVisible(false);
            btnEditSchoolYear.setVisible(true);
            txtSchoolYearID.enable(false);
            InputSchoolYearDialog.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn năm học cần sửa");

        }
    }//GEN-LAST:event_btnShowEditSchoolYearDialogActionPerformed

    // xóa năm học
    private void btnDeleteSchoolYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSchoolYearActionPerformed
        // TODO add your handling code here:
        if (validateFormSchoolYear()) {
            SchoolYear schoolYear = getSchoolYearModel();
            try {
                if (schoolYearBUS.deleteSchoolYear(schoolYear)) {
                    JOptionPane.showMessageDialog(this, "Xóa năm học thành công");
                    LoadDataTableSchoolYear();
                    LoadComboboxSchoolYear();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa năm học thất bại");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn năm học muốn xóa");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn năm học cần xóa");
        }


    }//GEN-LAST:event_btnDeleteSchoolYearActionPerformed

    public boolean validateFormSemester() {
        if (txtSemesterID.getText().isEmpty() || txtSemesterName.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public Semester getSemesterModel() {
        Semester semester = new Semester();
        semester.setSemesterID(txtSemesterID.getText());
        semester.setSemesterName(txtSemesterName.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = sdf.format(csStartDate_Semester.getDate());
        semester.setStartDate(startDate);
        String endDate = sdf.format(csEndDate_Semester.getDate());
        semester.setEndDate(endDate);
        String schoolYearName = comboboxSchoolYear.getSelectedItem().toString();
        semester.setSchoolYearID(schoolYearBUS.getSchoolYearByName(schoolYearName).getSchoolYearID());
        return semester;
    }

    public void setSemesterModel(Semester semester) {
        txtSemesterID.setText(semester.getSemesterID());
        txtSemesterName.setText(semester.getSemesterName());
        java.util.Date startDate;
        java.util.Date endDate;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(semester.getStartDate());
            csStartDate_Semester.setDate(startDate);
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(semester.getEndDate());
            csEndDate_Semester.setDate(endDate);
            comboboxSchoolYear.setSelectedItem(schoolYearBUS.getSchoolYearByID(semester.getSchoolYearID()).getSchoolYearName());
        } catch (ParseException ex) {
            Logger.getLogger(SchoolYearPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // hiển thị form sửa học kỳ
    private void btnShowEditSemesterDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEditSemesterDialogActionPerformed
        if (validateFormSemester()) {
            InputSemesterDialog.setLocationRelativeTo(null);
            btnAddSemester.setVisible(false);
            btnEditSemester.setVisible(true);
            InputSemesterDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học kỳ cần sửa");
        }

    }//GEN-LAST:event_btnShowEditSemesterDialogActionPerformed

    // Xóa học kỳ
    private void btnDeleteSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSemesterActionPerformed
        // TODO add your handling code here:
        if (validateFormSemester()) {
            Semester semester = getSemesterModel();
            if (semesterBUS.deleteSemester(semester)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                LoadDataTableSemester();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học kỳ cần xóa");
        }
    }//GEN-LAST:event_btnDeleteSemesterActionPerformed

    public void resetFormSemester() {
        txtSemesterID.setText("");
        txtSemesterName.setText("");
    }

    // hiển thị form nhập học kỳ
    private void btnShowSemesterDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSemesterDialogActionPerformed

        resetFormSemester();
        InputSemesterDialog.setLocationRelativeTo(null);
        btnAddSemester.setVisible(true);
        btnEditSemester.setVisible(false);
        InputSemesterDialog.setVisible(true);
    }//GEN-LAST:event_btnShowSemesterDialogActionPerformed

    // xử lý khi ấn chọn danh sách học kỳ 
    private void semesterListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semesterListMouseClicked

        int row = semesterList.rowAtPoint(evt.getPoint());
        String semesterID = semesterList.getValueAt(row, 0).toString();
        Semester semester = semesterBUS.getSemesterByID(semesterID);
        setSemesterModel(semester);
    }//GEN-LAST:event_semesterListMouseClicked

    public boolean validateFormSchoolYear() {
        if (txtSchoolYearID.getText().isEmpty() || txtSchoolYearName.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    // thêm năm học
    private void btnAddSchoolYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSchoolYearActionPerformed
        if (validateFormSchoolYear()) {
            SchoolYear schoolYear = getSchoolYearModel();
            if (schoolYearBUS.addSchoolYear(schoolYear)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                LoadDataTableSchoolYear();
                LoadComboboxSchoolYear();
                resetFormSchoolYear();
                InputSchoolYearDialog.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        }

    }//GEN-LAST:event_btnAddSchoolYearActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        // TODO add your handling code here:
        InputSchoolYearDialog.dispose();
    }//GEN-LAST:event_btnEscActionPerformed

    // Thêm học kỳ
    private void btnAddSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSemesterActionPerformed

        Semester semester = getSemesterModel();
        if (semesterBUS.addSemester(semester)) {
            JOptionPane.showMessageDialog(this, "Thêm học kỳ thành công");
            LoadDataTableSemester();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm học kỳ thất bại");
        }
    }//GEN-LAST:event_btnAddSemesterActionPerformed

    private void btnEsc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsc1ActionPerformed
        // TODO add your handling code here:
        InputSemesterDialog.dispose();
    }//GEN-LAST:event_btnEsc1ActionPerformed

    private void btnEditSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSemesterActionPerformed
        Semester semester = getSemesterModel();
        if (semesterBUS.editSemester(semester)) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            LoadDataTableSemester();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa học kỳ thất bại");
        }

    }//GEN-LAST:event_btnEditSemesterActionPerformed

    private void btnEditSchoolYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSchoolYearActionPerformed
        // TODO add your handling code here:
        SchoolYear schoolYear = getSchoolYearModel();
        if (schoolYearBUS.editSchoolYear(schoolYear)) {
            JOptionPane.showMessageDialog(this, "Sửa năm học thành công");
            LoadDataTableSchoolYear();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnEditSchoolYearActionPerformed

    // Hàm mở file
    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Xuất file excel danh sách năm học
    private void btnExportExcelSchoolYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelSchoolYearActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(JOptionPane.getRootFrame());
            File save = choose.getSelectedFile();
            if (save != null) {
                save = new File(save.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = (Sheet) wb.createSheet("Học Sinh");
                Row rowcol = sheet.createRow(0);
                for (int i = 0; i < schoolYearList.getColumnCount(); i++) {
                    Cell cell = rowcol.createCell(i);
                    cell.setCellValue(schoolYearList.getColumnName(i));
                }
                for (int i = 0; i < schoolYearList.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < schoolYearList.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (schoolYearList.getValueAt(i, j) != null) {
                            cell.setCellValue(schoolYearList.getValueAt(i, j).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(save.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(save.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error al genera");
            }
        } catch (Exception u) {
            u.printStackTrace();
        }
    }//GEN-LAST:event_btnExportExcelSchoolYearActionPerformed

    private void btnExportExcelSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelSemesterActionPerformed
        try {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(JOptionPane.getRootFrame());
            File save = choose.getSelectedFile();
            if (save != null) {
                save = new File(save.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = (Sheet) wb.createSheet("Học Sinh");
                Row rowcol = sheet.createRow(0);
                for (int i = 0; i < semesterList.getColumnCount(); i++) {
                    Cell cell = rowcol.createCell(i);
                    cell.setCellValue(semesterList.getColumnName(i));
                }
                for (int i = 0; i < semesterList.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < semesterList.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (semesterList.getValueAt(i, j) != null) {
                            cell.setCellValue(semesterList.getValueAt(i, j).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(save.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(save.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error al genera");
            }
        } catch (Exception u) {
            u.printStackTrace();
        }
    }//GEN-LAST:event_btnExportExcelSemesterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog InputSchoolYearDialog;
    private javax.swing.JDialog InputSemesterDialog;
    private javax.swing.JButton btnAddSchoolYear;
    private javax.swing.JButton btnAddSemester;
    private javax.swing.JButton btnDeleteSchoolYear;
    private javax.swing.JButton btnDeleteSemester;
    private javax.swing.JButton btnEditSchoolYear;
    private javax.swing.JButton btnEditSemester;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnEsc1;
    private javax.swing.JButton btnExportExcelSchoolYear;
    private javax.swing.JButton btnExportExcelSemester;
    private javax.swing.JButton btnShowEditSchoolYearDialog;
    private javax.swing.JButton btnShowEditSemesterDialog;
    private javax.swing.JButton btnShowSchoolYearDialog;
    private javax.swing.JButton btnShowSemesterDialog;
    private javax.swing.JComboBox<String> comboboxSchoolYear;
    private com.toedter.calendar.JDateChooser csEndDate;
    private com.toedter.calendar.JDateChooser csEndDate_Semester;
    private com.toedter.calendar.JDateChooser csStartDate;
    private com.toedter.calendar.JDateChooser csStartDate_Semester;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable schoolYearList;
    private javax.swing.JTable semesterList;
    private javax.swing.JTextField txtSchoolYearID;
    private javax.swing.JTextField txtSchoolYearName;
    private javax.swing.JTextField txtSemesterID;
    private javax.swing.JTextField txtSemesterName;
    // End of variables declaration//GEN-END:variables
}
