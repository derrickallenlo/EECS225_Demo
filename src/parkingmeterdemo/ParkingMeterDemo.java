/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parkingmeterdemo;

/**
 *
 * @author derrick
 */
public class ParkingMeterDemo {

    public enum states 
    {
        OFF,
        ON,
        OCCUPIED,
        EXPIRED,
        ERROR;
    }
    
    public enum status
    {
        GOOD,
        ERROR,
        READY;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        mainThread meter1 = new mainThread(1);
        mainThread meter2 = new mainThread(2);
        meter1.start();
        meter2.start();
    }
}


