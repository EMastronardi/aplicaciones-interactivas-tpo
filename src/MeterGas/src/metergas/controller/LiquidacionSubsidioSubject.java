/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.controller;

/**
 *
 * @author Checho
 */
public class LiquidacionSubsidioSubject {
    
    private static LiquidacionSubsidioSubject instance = new LiquidacionSubsidioSubject();
    private float totalSubsidio;

    static LiquidacionSubsidioSubject getInstance(){
        return instance;
    }
    
    public void notifySubsidiosAplicados(float total){
        totalSubsidio += total;
    }
}
