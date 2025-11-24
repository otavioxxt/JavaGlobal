package com.fiap.main;

import com.fiap.model.Triagem;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListTriagem {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Triagem> listaTriagem = new ArrayList<Triagem>();

        Triagem objTriagem = null;

        do {

            objTriagem = new Triagem();
            objTriagem.setId(texto("ID da Triagem"));
            objTriagem.setTipo(texto("Tipo da Triagem"));
            objTriagem.setNvUrgencia(texto("Nivel de urgencia da Triagem"));

            listaTriagem.add(objTriagem);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar nova Triagem?",
                "Cadastro de Triagem",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saída com foreach
        for(Triagem a : listaTriagem)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nTipo: " + a.getTipo() +
                            "\nNivel de Urgencia : " + a.getNvUrgencia()
            );
        }

    }

}