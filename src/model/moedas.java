/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo Atui
 */
public class moedas  {
    private double cotacao,taxadecompra,taxadevenda;

    public double getTaxadecompra() {
        return taxadecompra;
    }

    public double getTaxadevenda() {
        return taxadevenda;
    }

    public void setTaxadecompra(double taxadecompra) {
        this.taxadecompra = taxadecompra;
    }

    public void setTaxadevenda(double taxadevenda) {
        this.taxadevenda = taxadevenda;
    }
    
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
