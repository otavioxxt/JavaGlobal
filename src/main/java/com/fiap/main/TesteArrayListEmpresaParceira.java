package com.fiap.main;

import com.fiap.model.EmpresaParceira;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListEmpresaParceira {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<EmpresaParceira> listaEmpresaParceira = new ArrayList<EmpresaParceira>();

        EmpresaParceira objEmpresaParceira = null;

        do {

            objEmpresaParceira = new EmpresaParceira();
            objEmpresaParceira.setId(texto("ID da Empresa Parceira"));
            objEmpresaParceira.setNome(texto("Nome da Empresa"));
            objEmpresaParceira.setNumFuncionarios(texto("Numero de funcionarios da Empresa"));

            listaEmpresaParceira.add(objEmpresaParceira);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar nova Empresa Parceira?",
                "Cadastro de Empresa Parceira",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saídas com foreach
        for(EmpresaParceira a : listaEmpresaParceira)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nNome: " + a.getNome() +
                            "\nNumero de Funcionarios cadastrados: " + a.getNumFuncionarios()
            );
        }

    }

}
