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
public class MeterState 
{
    public enum states 
    {
        OFF,
        ON,
        OCCUPIED,
        EXPIRED,
        ERROR;
    }
}
