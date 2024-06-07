package com.desenvolvimento.validacao;

import com.desenvolvimento.manipulacao.ManipulacaoArray;

public class Validacao {
    ManipulacaoArray manArray = new ManipulacaoArray();
    public void ValidacaoMenu(String login, String pass){
        if (login.equals("ADMIN") && pass.equals("ADMIN")){
            System.out.println("Bem vindo ao sistema ADMINISTRADOR: ");
            System.out.println("----------");
            manArray.MenuAdmin();
            System.out.println("LIsta de todos os funcionarios cadastrados: \n");
            manArray.ListarFuncionarios();
            System.out.println("Lista de todos os produtos cadastrados: \n");
            manArray.ListarProduto();
        } else {
            System.out.println("LOGIN MUITO ERRADO, sai daí filhao");
        }
    }
}
