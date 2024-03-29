/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkingmeterdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author derrick
 */
public class JDisplay extends javax.swing.JDialog implements ActionListener
{
    private int counter = 1800; // the duration
    private int secCounter = 10; // the duration
    private int delay = 1000; // every 1 second
    Timer timer;
    /**
     * Creates new form NewJDisplay
     */
    public JDisplay(java.awt.Frame parent, boolean modal, int meterNumber) 
    {
        super(parent, modal);
        initComponents();
        
        jMeterNumber.setText(String.valueOf(meterNumber));
        timer = new Timer(delay, this);
        timer.setInitialDelay(0);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLCDDisplay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCurrentState = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMeterNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);

        jLCDDisplay.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLCDDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCDDisplay.setText("00:00:00");

        jLabel1.setText("State:");

        jCurrentState.setText("ON");

        jButton1.setText("Insert $0.25 ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("$0.25 per 30 minutes");

        jLabel3.setText("Meter #:");

        jMeterNumber.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLCDDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCurrentState))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jMeterNumber))))
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLCDDisplay)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jMeterNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCurrentState)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (counter != 1800)
        {
            timer.restart();
            counter += 1800;
        }
        timer.start();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void actionPerformed(ActionEvent evt)
    {
        if(counter == 0)
        {
            timer.stop();
            jLCDDisplay.setText("EXPIRED");
            jCurrentState.setText("EXPIRED");
            
        }
        else
        {
            int minutes = 0;
            int secs = 0;
            int hours = 0;
            
            hours = (counter / 3600);
            minutes = ((counter / 60) % 60);
            secs = (counter % 60);
            System.out.println(counter);
            System.out.println(secs);
            jLCDDisplay.setText( String. valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(secs));
            jCurrentState.setText("OCCUPIED");
            counter--;
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCurrentState;
    private javax.swing.JLabel jLCDDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jMeterNumber;
    // End of variables declaration//GEN-END:variables

}
