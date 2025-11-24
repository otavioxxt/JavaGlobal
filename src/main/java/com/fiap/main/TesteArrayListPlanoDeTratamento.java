package com.fiap.main;

import com.fiap.model.PlanoDeTratamento;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListPlanoDeTratamento {

    // String
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<PlanoDeTratamento> listaPlanoDeTratamento = new ArrayList<PlanoDeTratamento>();

        PlanoDeTratamento objPlanoDeTratamento = null;

        do {

            objPlanoDeTratamento = new PlanoDeTratamento();
            objPlanoDeTratamento.setId(texto("ID do Plano de Tratamento"));
            objPlanoDeTratamento.setObjetivo(texto("Objetivo do Plano"));
            objPlanoDeTratamento.setDuracao(texto("Duração do Plano"));

            listaPlanoDeTratamento.add(objPlanoDeTratamento);

        } while (JOptionPane.showConfirmDialog(
                null,
                "Cadastrar novo Plano de Tratamento?",
                "Cadastro de PlanoDeTratamento",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saída com foreach
        for (PlanoDeTratamento a : listaPlanoDeTratamento) {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nObjetivo: " + a.getObjetivo() +
                            "\nDuração: " + a.getDuracao()
            );
        }

    }
}
