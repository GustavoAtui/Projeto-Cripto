/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo Atui
 * 
 */
public class Investidor extends Pessoa {
    private double saldobtc, saldoeth , saldoxrp, saldoreais;
    private Carteira carteira;
    
    public void setSaldoreais(double saldoreais) {
        this.saldoreais = saldoreais;
    }

    public double getSaldoreais() {
        return saldoreais;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setSaldobtc(double saldobtc) {
        this.saldobtc = saldobtc;
    }

    public void setSaldoeth(double saldoeth) {
        this.saldoeth = saldoeth;
    }

    public void setSaldoxrp(double saldoxrp) {
        this.saldoxrp = saldoxrp;
    }

    public double getSaldobtc() {
        return saldobtc;
    }

    public double getSaldoeth() {
        return saldoeth;
    }

    public double getSaldoxrp() {
        return saldoxrp;
    }
    public Investidor(double saldoreais,double saldobtc, double saldoeth, double saldoxrp,  String nome, String cpf, String senha) {
        super(nome,cpf,senha);
        this.saldoreais = saldoreais;
        this.saldobtc = saldobtc;
        this.saldoeth = saldoeth;
        this.saldoxrp = saldoxrp;
        this.carteira = carteira;
        
    }

    public Investidor(String nome, String cpf , String senha) {
        super(nome,cpf,senha);
    }
    
}
