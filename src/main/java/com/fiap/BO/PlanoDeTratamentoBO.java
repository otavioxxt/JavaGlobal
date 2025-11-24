package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.PlanoDeTratamento;
import com.fiap.DAO.PlanoDeTratamentoDAO;

public class PlanoDeTratamentoBO {

    PlanoDeTratamentoDAO planoDAO;


    public ArrayList<PlanoDeTratamento> selecionarBo() throws ClassNotFoundException, SQLException {
        planoDAO = new PlanoDeTratamentoDAO();


        return (ArrayList<PlanoDeTratamento>) planoDAO.selecionar();
    }


    public void inserirBo(PlanoDeTratamento plano) throws ClassNotFoundException, SQLException {
        PlanoDeTratamentoDAO planoDAO = new PlanoDeTratamentoDAO();

        planoDAO.inserir(plano);
    }


    public void atualizarBo(PlanoDeTratamento plano) throws ClassNotFoundException, SQLException {
        PlanoDeTratamentoDAO planoDAO = new PlanoDeTratamentoDAO();

        planoDAO.atualizar(plano);
    }


    public void deletarBo(String id) throws ClassNotFoundException, SQLException {
        PlanoDeTratamentoDAO planoDAO = new PlanoDeTratamentoDAO();

        planoDAO.deletar(id);
    }

}
