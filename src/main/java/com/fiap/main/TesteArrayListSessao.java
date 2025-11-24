package com.fiap.main;

import com.fiap.model.Sessao;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListSessao {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Sessao> listaSessao = new ArrayList<Sessao>();

        Sessao objSessao = null;

        do {

            objSessao = new Sessao();
            objSessao.setId(texto("ID da Sessão"));
            objSessao.setData(texto("Data da Sessão"));
            objSessao.setStatus(texto("Status da Sessão"));

            listaSessao.add(objSessao);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar nova Sessão?",
                "Cadastro de Sessao",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saída com foreach
        for(Sessao a : listaSessao)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nData: " + a.getData() +
                            "\nStatus: " + a.getStatus()
            );
        }

    }

}