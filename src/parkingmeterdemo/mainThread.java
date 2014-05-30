/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkingmeterdemo;

import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.SwingUtilities;

/**
 *
 * @author derrick
 */
public class mainThread extends Thread 
{
    private int meterNumber = 0;
    MeterState.states currentState;
    MeterStatus.status currentStatus;
    Timer currentTimer;
    Boolean isOccupied;
    
    mainThread(int meterNumber)
    {
       this.meterNumber = meterNumber;
       this.currentState = MeterState.states.OFF;
       this.currentStatus = MeterStatus.status.GOOD;
       this.isOccupied = false;
    }

    public void run()
    {
       System.out.println("Meter" + meterNumber + " Running...");
       System.out.println("Meter" + meterNumber + " State: " + currentState);
       currentState = MeterState.states.ON;
       
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDisplay dialog = new JDisplay(new javax.swing.JFrame(), false, meterNumber);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
            }
        });
        
           if (!isOccupied)
           {
               currentStatus = MeterStatus.status.READY;
           }
           else
           {
               currentStatus = MeterStatus.status.COUNTING;
           }
       
    }
    
    
}
