package com.fiap.main;

import com.fiap.model.Psicologo;


import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListPsicologo {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Psicologo> listaPsicologo = new ArrayList<Psicologo>();

        Psicologo objPsicologo = null;

        do {

            objPsicologo = new Psicologo();
            objPsicologo.setId(texto("ID do Psicologo"));
            objPsicologo.setName(texto("Nome do Psicologo"));
            objPsicologo.setRegistro(texto("Registro do Psicologo"));



            listaPsicologo.add(objPsicologo);

        }while( JOptionPane.showConfirmDialog(null,
                "Cadastrar  Psicologo?",
                "Cadasrtro de Psicologo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE )  == 0);

        // Saidas utilizando o foreach
        for(Psicologo a : listaPsicologo)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nNome: " + a.getName() +
                            "\nRegistro: " + a.getRegistro()
            );
        }

    }



}