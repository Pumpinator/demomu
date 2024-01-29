/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.dsm.cualesmicurp;

import org.utl.dsm.cualesmicurp.modelo.CURP;

/**
 *
 * @author alejandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CURP curpAlex = new CURP("Alejandro", "Delgado", "Cardona", 23, 4, 2003, "H", "guanajuato");
        CURP curpPau = new CURP("Ana Paulina", "Durán", "Martínez", 15, 11, 2004, "mujer", "GT");
        CURP curpMely = new CURP("Melissa", "Delgado", "Cardona", 9, 1, 1997, "femenino", "gt");
        curpAlex.generar();
        curpPau.generar();
        curpMely.generar();
        System.out.println("ALEX -> " + curpAlex);
        System.out.println("PAU -> " + curpPau);
        System.out.println("MELY -> " + curpMely);
    }
    
}
