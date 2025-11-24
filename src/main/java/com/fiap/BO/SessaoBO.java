package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Sessao;
import com.fiap.DAO.SessaoDAO;

public class SessaoBO {

    SessaoDAO sessaoDAO;


    public ArrayList<Sessao> selecionarBo() throws ClassNotFoundException, SQLException {
        sessaoDAO = new SessaoDAO();


        return (ArrayList<Sessao>) sessaoDAO.selecionar();
    }


    public void inserirBo(Sessao sessao) throws ClassNotFoundException, SQLException {
        SessaoDAO sessaoDAO = new SessaoDAO();

        sessaoDAO.inserir(sessao);
    }


    public void atualizarBo(Sessao sessao) throws ClassNotFoundException, SQLException {
        SessaoDAO sessaoDAO = new SessaoDAO();

        sessaoDAO.atualizar(sessao);
    }

    public void deletarBo(String id) throws ClassNotFoundException, SQLException {
        SessaoDAO sessaoDAO = new SessaoDAO();

        sessaoDAO.deletar(id);
    }

}
