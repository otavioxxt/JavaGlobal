package com.fiap.main;

import com.fiap.model.Feedback;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListFeedback {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Feedback> listaFeedback = new ArrayList<Feedback>();

        Feedback objFeedback = null;

        do {

            objFeedback = new Feedback();
            objFeedback.setId(texto("ID do Feedback"));
            objFeedback.setNota(texto("Nome do Feedback"));
            objFeedback.setComentario(texto("Registro do Feedback"));

            listaFeedback.add(objFeedback);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar Feedback?",
                "Cadastro de Feedback",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saídas utilizando o foreach
        for(Feedback a : listaFeedback)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nNota: " + a.getNota() +
                            "\nComentario: " + a.getComentario()
            );
        }

    }

}
