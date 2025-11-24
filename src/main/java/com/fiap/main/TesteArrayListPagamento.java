package com.fiap.main;

import com.fiap.model.Pagamento;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListPagamento {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<Pagamento> listaPagamento = new ArrayList<Pagamento>();

        Pagamento objPagamento = null;

        do {

            objPagamento = new Pagamento();
            objPagamento.setId(texto("ID do Pagamento"));
            objPagamento.setForma(texto("Forma do Pagamento"));
            objPagamento.setValor(texto("Valor do Pagamento"));

            listaPagamento.add(objPagamento);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar Pagamento?",
                "Cadastro de Pagamento",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saídas utilizando o foreach
        for(Pagamento a : listaPagamento)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nForma: " + a.getForma() +
                            "\nValor: " + a.getValor()
            );
        }

    }

}