/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import model.moedas;
/**
 *
 * @author Naja Info
 */
public class Carteira{
    ArrayList<moedas> moedas = new ArrayList<>();

    public ArrayList<moedas> getMoeda() {
        return moedas;
    }

    public void setMoeda(ArrayList<moedas> moedas) {
        this.moedas = moedas;
    }

    public Carteira(ArrayList<moedas> moedas){
        this.moedas = moedas;
    }

    

   

    
    
    
}
