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

    private static LiquidacionSubsidioSubject instance;
    private float totalSubsidio;

    static LiquidacionSubsidioSubject getInstance() {
        if (instance == null) {
            instance = new LiquidacionSubsidioSubject();
        }
        return instance;
    }

    public void notifySubsidiosAplicados(float total) {
        totalSubsidio += total;
    }
}
