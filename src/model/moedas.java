/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Naja Info
 */
public class moedas  {
    private double cotacao,taxadecompra,taxadevenda;

    public moedas() {
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public moedas(double cotacao){
        this.cotacao = cotacao;
    }

    public moedas(double cotacao,double taxadecompra, double taxadevenda) {
        this.cotacao = cotacao;
        this.taxadecompra = taxadecompra;
        this.taxadevenda = taxadevenda;
    }
}
