/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metergas.modelo;

/**
 *
 * @author eteodoro
 */
public enum TipoClienteEnum {

    RESIDENCIAL(1), INDUSTRIAL(2);

    public static TipoClienteEnum getEnum(int _valor) {
        switch (_valor) {
            case 1:
                return RESIDENCIAL;
            case 2:
                return INDUSTRIAL;

        }
        return null;

    }
    private int valor;

    TipoClienteEnum(int valor) {
        this.valor = valor;
    }

    public int valor() {
        return this.valor;
    }
}
