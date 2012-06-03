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
    private static float totalSubsidio;

    static LiquidacionSubsidioSubject getInstance(){
        return instance;
    }
    
    public static void notifySubsidiosAplicados(float total){
        totalSubsidio += total;
    }
}
