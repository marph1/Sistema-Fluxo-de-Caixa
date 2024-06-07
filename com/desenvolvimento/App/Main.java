package com.desenvolvimento.App;

import com.desenvolvimento.Produto;
import com.desenvolvimento.manipulacao.ManipulacaoArray;
import com.desenvolvimento.validacao.Validacao;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ManipulacaoArray manArray = new ManipulacaoArray();
        Validacao vali = new Validacao();
        new Produto();
        int escolha;

        do {
            System.out.print("\n[ 1 ] Produtos no sistema\n" +
                    "[ 7 ] Menu Admin\n" +
                    "[ 0 ] Sair\n" +
                    "Sua escolha: ");
            escolha = sc.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                    Produto.ListarProdutosClientes();
                    break;
                case 7:
                    System.out.println("------ MENU ADMIN -------");
                    sc.nextLine();
                    System.out.print("LOGIN: ");
                    String login = sc.nextLine();
                    System.out.print("SENHA: ");
                    String senha = sc.nextLine();
                    sc.nextLine();
                    vali.ValidacaoMenu(login, senha);
                    break;
                case 0:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Valor impossivel de achar nesse menu, arruma aí cara!");
                    break;
            }
        } while (escolha != 0);
    }
}
