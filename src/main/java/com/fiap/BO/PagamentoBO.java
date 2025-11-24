package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Pagamento;
import com.fiap.DAO.PagamentoDAO;

public class PagamentoBO {

    PagamentoDAO pagamentoDAO;


    public ArrayList<Pagamento> selecionarBo() throws ClassNotFoundException, SQLException {
        pagamentoDAO = new PagamentoDAO();


        return (ArrayList<Pagamento>) pagamentoDAO.selecionar();
    }


    public void inserirBo(Pagamento pagamento) throws ClassNotFoundException, SQLException {
        PagamentoDAO pagamentoDao = new PagamentoDAO();

        pagamentoDao.inserir(pagamento);
    }


    public void atualizarBo (Pagamento pagamento) throws ClassNotFoundException, SQLException {
        PagamentoDAO pagamentoDao = new PagamentoDAO();
        // Regra de negócios
        pagamentoDao.atualizar(pagamento);
    }


    public void deletarBo (String id) throws ClassNotFoundException, SQLException {
        PagamentoDAO pagamentoDao = new PagamentoDAO();

        pagamentoDao.deletar(id);
    }

}
