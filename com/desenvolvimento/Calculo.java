package com.desenvolvimento;

import java.util.Random;

public class Calculo{
    private String nomeProd;
    private double valorProd;
    private double lucro;
    private double gastos;
    private int qtdProd;
    private double receitaTotal;
    public static Random random = new Random();
    //private Produto p;

    public double getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(double receitaTotal) {
        this.receitaTotal = receitaTotal;
    }

    public Calculo(String nomeProd, double valorProd, double lucro, double gastos, int qtdProd) {
        this.nomeProd = nomeProd;
        this.valorProd = valorProd;
        this.lucro = lucro;
        this.gastos = gastos;
        this.qtdProd = qtdProd;
    }

    public Calculo(double lucro, double gastos, double receitaTotal) {
        this.lucro = Lucro();
        this.gastos = gastos;
        this.receitaTotal = receitaTotal;
    }

    public Calculo(String nomeProd, double valorProd, int qtdProd) {
        this.nomeProd = nomeProd;
        this.valorProd = valorProd;
        this.qtdProd = qtdProd;
    }

    public Calculo(double valorProd) {
        this.valorProd = valorProd;
    }

    public Calculo() {

    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public double getValorProd() {
        return valorProd;
    }

    public void setValorProd(double valorProd) {
        this.valorProd = valorProd;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public double AleatorioImposto(){
        return random.nextDouble();
    }

    public double ValorProduto() {
        return valorProd * ValorImpostos() + gastos;
    }

    public double ValorImpostos() {
        return AleatorioImposto() * valorProd;
    }
    public double ValorGastos() {
        return gastos;
    }

    public double Lucro(){
        return receitaTotal - gastos;
    }

    public double ValorFinalSugerido(double valor) {
        return valor + AleatorioImposto();
    }

}
