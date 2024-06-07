package com.desenvolvimento;

import java.util.ArrayList;
import java.util.Random;

public class Produto {
    private double valor;
    private String nome;
    private String dataValidade;
    private int qtdEstoque;
    private double valorDespesa;
    private double valorFinal;

    static ArrayList<Produto> produtos = new ArrayList<>();

    public static Random r = new Random();

    public Produto(double valor, String nome, String dataValidade, int qtdEstoque) {
        this.valor = valor;
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.qtdEstoque = qtdEstoque;
        produtos.add(this);
    }

    public Produto() {
        produtos.add(this);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public double getValorFinal() {
        return valorFinal;
    }
    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double AleatorioImposto(){
        return r.nextDouble();
    }

    public double ValorEstoque(){
        return valor * qtdEstoque;
    }

    public double ValorUnitarioImposto(double valor){
        return valor / qtdEstoque + AleatorioImposto();
    }
    public double ValorUnitario() {
        //Custo Unitário = Custos Fixos / Total de Unidades Produzidas
        return valor / qtdEstoque;
    }

    public static void addProd(Produto produto){
        produtos.add(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public static void ListarProdutosClientes(){
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Valor Unitário R$: " + String.format("%.2f", p.ValorUnitario()));
            System.out.println("Data de validade: " + p.getDataValidade());
            System.out.println("Quantidade no estoque: " + p.getQtdEstoque());
            System.out.println("------------\n");
        }
    }
}
