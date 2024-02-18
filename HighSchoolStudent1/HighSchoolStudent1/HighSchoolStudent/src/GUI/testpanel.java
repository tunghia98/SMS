/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import DTO.Discipline;
import BUS.DisciplineBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
/**
/**
 *
 * @author Leo Kun
 */
public class testpanel {
        public static void main(String[] args) {
         DisciplineBUS disBUS = new DisciplineBUS();
    /**
     * Creates new form StudentDisFormJPanel
     */ JPanel mainPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        for(Discipline dis : disBUS.getAllDiscipline())
        {
            JPanel panel = createPanel(dis);
            mainPanel.add(panel);
        }
    }
        private static JPanel createPanel(Discipline dis) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Để thấy rõ biên của mỗi panel
        JLabel roleLabel = new JLabel(dis.getDis_ID());
        JLabel contentLabel = new JLabel(dis.getDis_Content());
        JLabel scoreLabel = new JLabel(String. valueOf(dis.getDis_Score()));
        JCheckBox checkBox = new JCheckBox();
        panel.add(roleLabel, BorderLayout.NORTH);
        panel.add(contentLabel, BorderLayout.CENTER);
        panel.add(scoreLabel, BorderLayout.SOUTH);
        panel.add(checkBox, BorderLayout.EAST);
        return panel;
        }
}
