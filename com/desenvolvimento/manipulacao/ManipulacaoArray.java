package com.desenvolvimento.manipulacao;

import com.desenvolvimento.Calculo;
import com.desenvolvimento.Funcionario;
import com.desenvolvimento.Produto;


import java.util.ArrayList;
import java.util.Scanner;

public class ManipulacaoArray {
    Scanner sc = new Scanner(System.in);
    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public ArrayList<Produto> produtos = new ArrayList<>();
    ArrayList<Calculo> calculos = new ArrayList<>();
    private final Calculo calc;

    public void CadastroFuncionario() {
        sc.nextLine();
        System.out.println("Digite o nome do funcionário: ");
        String nome = sc.nextLine();
        System.out.println("Digite o cargo do funcionário: ");
        String cargo = sc.nextLine();
        System.out.println("Digite o salário do funcionário: ");
        double salario = sc.nextDouble();

        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public ManipulacaoArray() {
        calc = new Calculo();
    }

    public void ListarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getCargo());
            System.out.println("Salário: " + f.getSalario());
            System.out.println("------------\n");
        }
    }

    public void CadastroProduto() {
        sc.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Data de validade do produto: ");
        String data = sc.nextLine();
        System.out.println("Valor do produto: ");
        double valor = sc.nextDouble();
        System.out.println("Estoque do produto: ");
        int qtd = sc.nextInt();

        Produto produto = new Produto(valor, nome, data, qtd);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");

        System.out.println("Produtos na lista após cadastro: " + produtos.size());
        ListarProdutoCliente();
    }

    public void ListarProduto() {
        produtos = getProdutos();

        for (Produto p : produtos) {
            double valor = p.getValor();
            System.out.println("Nome: " + p.getNome());
            System.out.println("Valor do lote: " + valor);
            System.out.println("Data de validade: " + p.getDataValidade());
            System.out.println("Quantidade no estoque: " + p.getQtdEstoque());
            System.out.println("------------");
            System.out.println("Preço total acumulativo no estoque: " + p.ValorEstoque());
            System.out.println("------------");

            System.out.println("Imposto gerado sobre o produto: " + String.format("%.2f", calc.AleatorioImposto()));
            System.out.println("Preço unitario do produto: " + String.format("%.2f", p.ValorUnitario()));
            System.out.println("Preço final sugerido (lote): " + String.format("%.2f", calc.ValorFinalSugerido(valor)));
            System.out.println("Preço final sugerido (unidade): " + String.format("%.2f", p.ValorUnitarioImposto(valor)));
            System.out.println();

        }
    }

    public void ListarProdutoCliente() {
        produtos = getProdutos();
        System.out.println("Produtos Cadastrados para Clientes:\n");
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Valor Unitário R$: " + String.format("%.2f", p.ValorUnitario()));
            System.out.println("Data de validade: " + p.getDataValidade());
            System.out.println("Quantidade no estoque: " + p.getQtdEstoque());
            System.out.println("------------\n");
        }
    }

    public void MenuAdmin() {
        int escolha;

        do {
            System.out.print("[ 1 ] Cadastro de funcionarios\n" +
                    "[ 2 ] Listagem de funcionarios\n" +
                    "[ 3 ] Exclusao de funcionarios\n" +
                    "[ 4 ] Cadastro de produto\n" +
                    "[ 5 ] Listagem de produto\n" +
                    "[ 6 ] Exclusao de produto\n" +
                    "[ 0 ] Sair\n" +
                    "Sua escolha: ");
            escolha = sc.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                    System.out.println("Cadastro de funcionarios: ");
                    CadastroFuncionario();
                    break;
                case 2:
                    System.out.println("Lista de funcionarios: ");
                    ListarFuncionarios();
                    break;
                case 3:
                    System.out.println("Exclusao funcionarios");
                    break;
                case 4:
                    System.out.println("Cadastro produtos");
                    CadastroProduto();
                    break;
                case 5:
                    System.out.println("Listagem produtos");
                    ListarProduto();
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Exclusao produtos");
                    break;
            }
        } while (escolha != 0);

        sc.nextLine();
        System.out.println("Receita Total: ");
        double receita = sc.nextDouble();
        System.out.println("Gastos da Empresa: ");
        double gastos = sc.nextInt();

        Calculo calculo = new Calculo(calc.Lucro(), gastos, receita);
        calculos.add(calculo);
        System.out.println();

        for (Calculo c : calculos) {
            System.out.println("Receita Total Gerada: " + String.format("%.2f", c.getReceitaTotal()));
            System.out.println("Gastos Totais: " + String.format("%.2f", c.getGastos()));
            System.out.println("Lucro FINAL da Empresa: " + String.format("%.2f", c.Lucro()));
        }

    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
