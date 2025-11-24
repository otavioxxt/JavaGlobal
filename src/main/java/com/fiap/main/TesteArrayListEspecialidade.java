package com.fiap.main;

import com.fiap.model.Especialidade;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListEspecialidade {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Especialidade> listaEspecialidade = new ArrayList<Especialidade>();

        Especialidade objEspecialidade = null;

        do {

            objEspecialidade = new Especialidade();
            objEspecialidade.setId(texto("ID da Especialidade"));
            objEspecialidade.setNome(texto("Nome da Especialidade"));
            objEspecialidade.setDescricao(texto("Descrição da Especialidade"));

            listaEspecialidade.add(objEspecialidade);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar nova Especialidade?",
                "Cadastro de Especialidade",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saídas com foreach
        for(Especialidade a : listaEspecialidade)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nNome: " + a.getNome() +
                            "\nDescrição: " + a.getDescricao()
            );
        }

    }

}