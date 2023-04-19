/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

import java.util.ArrayList;

public class Almacenar {

    private ArrayList<Tda> lista;

    public Almacenar() {
        lista = new <Tda>ArrayList();
    }

    public void añadir(Tda p) {
        lista.add(p);
    }
}