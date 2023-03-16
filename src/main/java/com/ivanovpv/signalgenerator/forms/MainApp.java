package com.ivanovpv.signalgenerator.forms;

import com.ivanovpv.signalgenerator.trends.DiscreteTrend;
import com.ivanovpv.signalgenerator.trends.StandardTrend;
import com.ivanovpv.signalgenerator.trends.TimeTrend;
import com.ivanovpv.signalgenerator.trends.Trend;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.text.DefaultCaret;

public class MainApp extends javax.swing.JFrame {
    private Thread csvWriterThread;
    private Runnable runnableImplementation;

    public MainApp() {
        initComponents();
        setIconImage( new ImageIcon(getClass().getResource("/icon.jpg").getPath()).getImage());
        ((DefaultCaret) logs.getCaret()).setUpdatePolicy(DefaultCaret.OUT_LEFT);
        ((DefaultCaret) logs.getCaret()).setUpdatePolicy(DefaultCaret.OUT_BOTTOM);

        runnableImplementation = () -> {
            setFrozen(true);
            if (!isCorrectData()) {
                setFrozen(false);
                return;
            }
            for (int i = 0; i < (Integer) fileCountSpinner.getValue(); i++) {
                if (Thread.currentThread().isInterrupted()) {
                    logs.append("Отмена!\n");
                    setFrozen(false);
                    return;
                }

                logs.append("Запись " + (i + 1) + "-ого файла...\n");
                progressBar.setValue((i + 1) * 100 / (Integer) fileCountSpinner.getValue());
                writeTrends(dirTextField.getText() + "\\" + fileNameTextField.getText() + i + ".txt", getTrends());
            }
            logs.append("Запись успешно завершена!\n");
            writeSplitLine();
            setFrozen(false);
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dirChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        dirTextField = new javax.swing.JTextField();
        dirPickBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fileCountSpinner = new javax.swing.JSpinner();
        fileNameTextField = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        generateTimeTrend = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        timeStep = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        generateDiscreteTrend = new javax.swing.JCheckBox();
        discreteTrendCount = new javax.swing.JSpinner();
        turningDiscTrendCount = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        generateStdTrend = new javax.swing.JCheckBox();
        stdTrendCount = new javax.swing.JSpinner();
        maxAmplStdTrend = new javax.swing.JTextField();
        minAmplStdTrend = new javax.swing.JTextField();
        maxChangeStdTrend = new javax.swing.JTextField();
        minChangeStdTrend = new javax.swing.JTextField();
        changed = new javax.swing.JCheckBox();
        noised = new javax.swing.JCheckBox();
        wideNoised = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        linesCount = new javax.swing.JSpinner();
        progressBar = new javax.swing.JProgressBar();
        jLabel15 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        generate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logs = new javax.swing.JTextArea();

        dirChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Signal Generator v0.1");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(730, 424));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dirTextField.setEditable(false);
        dirTextField.setText("C:\\Users\\Pavel\\Desktop\\trends");

        dirPickBtn.setText("...");
        dirPickBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirPickBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Директория:");

        jLabel2.setText("Файлов:");

        fileCountSpinner.setValue(1);

        fileNameTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fileNameTextField.setText("Trend_");

        jTextField1.setEditable(false);
        jTextField1.setText("№ .txt");

        jLabel3.setText("Имя файлов:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(dirTextField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dirPickBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(fileCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(fileNameTextField)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel3))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dirPickBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fileCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        generateTimeTrend.setText("Сгенерировать тренд \"Time\"");
        generateTimeTrend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateTimeTrendActionPerformed(evt);
            }
        });

        jLabel6.setText("сек.");

        jLabel5.setText("dT");

        timeStep.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        timeStep.setText("0,05");
        timeStep.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(70, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(timeStep, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel6))
                                        .addComponent(generateTimeTrend, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(generateTimeTrend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(timeStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        generateDiscreteTrend.setSelected(true);
        generateDiscreteTrend.setText("Сгенерировать тренды  \"Дискр. сигнал\"");
        generateDiscreteTrend.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        generateDiscreteTrend.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        generateDiscreteTrend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateDiscreteTrendActionPerformed(evt);
            }
        });

        discreteTrendCount.setValue(5);

        turningDiscTrendCount.setValue(15);

        jLabel7.setText("Кол-во");

        jLabel8.setText("шт.");

        jLabel9.setText("раз");

        jLabel10.setText("Переключений, не более");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(generateDiscreteTrend, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(discreteTrendCount, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(turningDiscTrendCount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(generateDiscreteTrend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(discreteTrendCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(turningDiscTrendCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        generateStdTrend.setSelected(true);
        generateStdTrend.setText("Сгенерировать стандартные тренды");
        generateStdTrend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateStdTrendActionPerformed(evt);
            }
        });

        stdTrendCount.setValue(5);

        maxAmplStdTrend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        maxAmplStdTrend.setText("3");

        minAmplStdTrend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        minAmplStdTrend.setText("-3");

        maxChangeStdTrend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        maxChangeStdTrend.setText("10");

        minChangeStdTrend.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        minChangeStdTrend.setText("5");

        changed.setSelected(true);
        changed.setText("Генерация нескольких участков");
        changed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changedActionPerformed(evt);
            }
        });

        noised.setSelected(true);
        noised.setText("Шум");

        wideNoised.setSelected(true);
        wideNoised.setText("\"Широкий шум\"");
        wideNoised.setToolTipText("Более заметные искажения по форме (чтоб примая в отдалении была не совсем прямой, а немного гуляла)");

        jLabel4.setText("Кол-во");

        jLabel11.setText("Макс. амплитуда");

        jLabel12.setText("Мин. амплитуда");

        jLabel13.setText("Макс. участков");

        jLabel14.setText("Мин. участков");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(noised)
                                        .addComponent(generateStdTrend)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(stdTrendCount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maxAmplStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(minAmplStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maxChangeStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(minChangeStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(changed)
                                        .addComponent(wideNoised))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generateStdTrend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stdTrendCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maxAmplStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAmplStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(changed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maxChangeStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minChangeStdTrend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noised)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wideNoised))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        linesCount.setValue(100000);

        jLabel15.setText("Количество строк");

        cancelBtn.setText("Отмена");
        cancelBtn.setEnabled(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        generate.setText("Сгенерировать");
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel15)
                                                .addGap(14, 14, 14)
                                                .addComponent(linesCount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(generate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(generate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(linesCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        logs.setEditable(false);
        logs.setBackground(new java.awt.Color(0, 0, 0));
        logs.setColumns(20);
        logs.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        logs.setForeground(new java.awt.Color(204, 204, 204));
        logs.setLineWrap(true);
        logs.setRows(5);
        logs.setWrapStyleWord(true);
        jScrollPane1.setViewportView(logs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(6, 6, 6)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateTimeTrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateTimeTrendActionPerformed
        timeStep.setEnabled(generateTimeTrend.isSelected());
    }//GEN-LAST:event_generateTimeTrendActionPerformed

    private void generateDiscreteTrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDiscreteTrendActionPerformed
        discreteTrendCount.setEnabled(generateDiscreteTrend.isSelected());
        turningDiscTrendCount.setEnabled(generateDiscreteTrend.isSelected());
    }//GEN-LAST:event_generateDiscreteTrendActionPerformed

    private void dirPickBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirPickBtnActionPerformed
        if (dirChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            dirTextField.setText(dirChooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_dirPickBtnActionPerformed

    private void changedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changedActionPerformed
        maxChangeStdTrend.setEnabled(changed.isSelected());
        minChangeStdTrend.setEnabled(changed.isSelected());
    }//GEN-LAST:event_changedActionPerformed

    private void generateStdTrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateStdTrendActionPerformed
        stdTrendCount.setEnabled(generateStdTrend.isSelected());
        maxAmplStdTrend.setEnabled(generateStdTrend.isSelected());
        minAmplStdTrend.setEnabled(generateStdTrend.isSelected());
        changed.setEnabled(generateStdTrend.isSelected());
        maxChangeStdTrend.setEnabled(generateStdTrend.isSelected());
        minChangeStdTrend.setEnabled(generateStdTrend.isSelected());
        noised.setEnabled(generateStdTrend.isSelected());
        wideNoised.setEnabled(generateStdTrend.isSelected());
    }//GEN-LAST:event_generateStdTrendActionPerformed

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
        logs.setText("");
        csvWriterThread = new Thread(runnableImplementation);
        csvWriterThread.start();
    }//GEN-LAST:event_generateActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        csvWriterThread.interrupt();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void setFrozen(boolean isFrozen) {
        isFrozen = !isFrozen;

        generateStdTrend.setEnabled(isFrozen);
        stdTrendCount.setEnabled(isFrozen);
        maxAmplStdTrend.setEnabled(isFrozen);
        minAmplStdTrend.setEnabled(isFrozen);
        changed.setEnabled(isFrozen);
        maxChangeStdTrend.setEnabled(isFrozen);
        minChangeStdTrend.setEnabled(isFrozen);
        noised.setEnabled(isFrozen);
        wideNoised.setEnabled(isFrozen);

        generateDiscreteTrend.setEnabled(isFrozen);
        discreteTrendCount.setEnabled(isFrozen);
        turningDiscTrendCount.setEnabled(isFrozen);

        generateTimeTrend.setEnabled(isFrozen);
        timeStep.setEnabled(isFrozen);
        cancelBtn.setEnabled(!isFrozen);

        generate.setEnabled(isFrozen);
        linesCount.setEnabled(isFrozen);
        fileCountSpinner.setEnabled(isFrozen);
        dirPickBtn.setEnabled(isFrozen);
        fileNameTextField.setEnabled(isFrozen);

        if (isFrozen) {
            generateDiscreteTrendActionPerformed(null);
            generateStdTrendActionPerformed(null);
            generateTimeTrendActionPerformed(null);
        }
    }

    private List<Trend> getTrends() {
        List<Trend> trends = new ArrayList<>();
        Trend.setCurrentLine(0);
        Trend.setLength((Integer) linesCount.getValue());
        if (generateTimeTrend.isSelected()) {
            trends.add(new TimeTrend(Double.valueOf(timeStep.getText())));
        }

        if (generateStdTrend.isSelected()) {
            for (int i = 0; i < (Integer) stdTrendCount.getValue(); i++) {
                trends.add(new StandardTrend(
                        noised.isSelected(),
                        wideNoised.isSelected(),
                        changed.isSelected(),
                        Byte.valueOf(maxChangeStdTrend.getText()),
                        Byte.valueOf(minChangeStdTrend.getText()),
                        Double.valueOf(maxAmplStdTrend.getText()),
                        Double.valueOf(minAmplStdTrend.getText())
                ));
            }
        }

        if (generateDiscreteTrend.isSelected()) {
            for (int i = 0; i < (Integer) discreteTrendCount.getValue(); i++) {
                trends.add(new DiscreteTrend(0, (Integer) turningDiscTrendCount.getValue()));
            }
        }
        return trends;
    }

    private boolean isCorrectData() {
        boolean isCorrect = true;
        logs.append("Проверка входных данных...\n");
        try {
            if (generateStdTrend.isSelected() && Double.valueOf(minAmplStdTrend.getText()) < Double.valueOf(minAmplStdTrend.getText())) {
                logs.append("Минимальная амплитуда не может быть больше максимальной\n");
                isCorrect = false;
            }
            if (generateStdTrend.isSelected() && changed.isSelected() && Double.valueOf(minChangeStdTrend.getText()) > Double.valueOf(maxChangeStdTrend.getText())) {
                logs.append("Минимальное количество изменений стандартного тренда не может быть больше максимального\n");
                isCorrect = false;
            }
            if (generateStdTrend.isSelected() && changed.isSelected() && Double.valueOf(minChangeStdTrend.getText()) < 0) {
                logs.append("Минимальное количество изменений стандартного тренда не может быть меньше нуля\n");
                isCorrect = false;
            }
            if (generateStdTrend.isSelected() && (Integer) stdTrendCount.getValue() < 1) {
                logs.append("Количество стандартных трендов не может быть меньше 1\n");
                isCorrect = false;
            }

            if (generateDiscreteTrend.isSelected() && (Integer) discreteTrendCount.getValue() < 1) {
                logs.append("Количество дискретных трендов не может быть меньше 1\n");
                isCorrect = false;
            }
            if (generateDiscreteTrend.isSelected() && (Integer) turningDiscTrendCount.getValue() < 0) {
                logs.append("Количество переключений дискретного тренда не может быть меньше 0");
                isCorrect = false;
            }

            if (generateTimeTrend.isSelected() && Double.valueOf(timeStep.getText()) <= 0) {
                logs.append("dT не может быть меньше или равно нулю");
                isCorrect = false;
            }
        } catch (Exception ex) {
            logs.append("Ошибка при проверке входных данных!\nПроверьте данные\n");
            writeSplitLine();
            return false;
        }
        if (isCorrect) logs.append("Данные корректны\n");
        writeSplitLine();
        return isCorrect;
    }

    public void writeTrends(String fileName, List<Trend> trends) {
        CSVWriter writer; //для записи файла       

        try { // указываем имя файла под запись и знаки разделителя, новой строки и т.д.
            writer = new CSVWriter(new FileWriter(fileName), '\t', '\0', '\0', "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] trendNames = new String[trends.size()]; // генерируем первые две строки файла
        String[] trendValueNames = new String[trends.size()];
        for (int i = 0; i < trends.size(); i++) { // инициализируем
            trendNames[i] = "P" + i;
            trendValueNames[i] = "у.е.";
        }

        writer.writeNext(trendNames); //записываем первые две строки в CSV
        writer.writeNext(trendValueNames);

        for (int i = 0; i < Trend.getLength(); i++) { //пишем n строк трендов
            writer.writeNext( // записываем построчно
                    trends.stream() //Stream of Trend
                            .map(trend -> String.valueOf(trend.getNextValue()).replace('.', ',')) //Stream of String
                            .toArray(count -> new String[count]) //собираем текущие значения в массив строк
            );
            Trend.nextLine(); // перевод всех Trend на следующую строку
        }

        try {
            writer.close(); //закрыли запись файла
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeSplitLine() {
        logs.append("--------------\n");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox changed;
    private javax.swing.JFileChooser dirChooser;
    private javax.swing.JButton dirPickBtn;
    private javax.swing.JTextField dirTextField;
    private javax.swing.JSpinner discreteTrendCount;
    private javax.swing.JSpinner fileCountSpinner;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton generate;
    private javax.swing.JCheckBox generateDiscreteTrend;
    private javax.swing.JCheckBox generateStdTrend;
    private javax.swing.JCheckBox generateTimeTrend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner linesCount;
    private javax.swing.JTextArea logs;
    private javax.swing.JTextField maxAmplStdTrend;
    private javax.swing.JTextField maxChangeStdTrend;
    private javax.swing.JTextField minAmplStdTrend;
    private javax.swing.JTextField minChangeStdTrend;
    private javax.swing.JCheckBox noised;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JSpinner stdTrendCount;
    private javax.swing.JTextField timeStep;
    private javax.swing.JSpinner turningDiscTrendCount;
    private javax.swing.JCheckBox wideNoised;
    // End of variables declaration//GEN-END:variables
}
