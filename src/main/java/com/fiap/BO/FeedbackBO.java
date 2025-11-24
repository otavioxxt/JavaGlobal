package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Feedback;
import com.fiap.DAO.FeedbackDAO;

public class FeedbackBO {

    FeedbackDAO feedbackDAO;


    public ArrayList<Feedback> selecionarBo() throws ClassNotFoundException, SQLException {
        feedbackDAO = new FeedbackDAO();


        return (ArrayList<Feedback>) feedbackDAO.selecionar();
    }


    public void inserirBo(Feedback feedback) throws ClassNotFoundException, SQLException {
        FeedbackDAO feedbackDao = new FeedbackDAO();

        feedbackDao.inserir(feedback);
    }


    public void atualizarBo (Feedback feedback) throws ClassNotFoundException, SQLException {
        FeedbackDAO feedbackDao = new FeedbackDAO();

        feedbackDao.atualizar(feedback);
    }


    public void deletarBo (String id) throws ClassNotFoundException, SQLException {
        FeedbackDAO feedbackDao = new FeedbackDAO();

        feedbackDao.deletar(id);
    }

}
