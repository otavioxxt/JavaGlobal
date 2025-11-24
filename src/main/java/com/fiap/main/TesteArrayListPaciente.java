package com.fiap.main;

import com.fiap.model.Paciente;


import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListPaciente {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();

        Paciente objPaciente = null;

        do {

            objPaciente = new Paciente();
            objPaciente.setId(texto("ID do Paciente"));
            objPaciente.setNome(texto("Nome do Paciente"));
            objPaciente.setEmail(texto("Email do Paciente"));



            listaPaciente.add(objPaciente);

        }while( JOptionPane.showConfirmDialog(null,
                "Cadastrar mais aluno?",
                "CADASTRO DE ALUNOS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE )  == 0);

        // Saidas utilizando o foreach
        for(Paciente a : listaPaciente)
        {
            System.out.println(
                            "\nID: " + a.getId() +
                            "\nNome: " + a.getNome() +
                            "\nEmail: " + a.getEmail()
            );
        }

    }



}
