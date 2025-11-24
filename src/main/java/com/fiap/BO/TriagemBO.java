package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Triagem;
import com.fiap.DAO.TriagemDAO;

public class TriagemBO {

    TriagemDAO triagemDAO;

    // Selecionar
    public ArrayList<Triagem> selecionarBo() throws ClassNotFoundException, SQLException {
        triagemDAO = new TriagemDAO();
        // Regras de negócio

        return (ArrayList<Triagem>) triagemDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Triagem triagem) throws ClassNotFoundException, SQLException {
        TriagemDAO triagemDAO = new TriagemDAO();
        // Regras de negócio
        triagemDAO.inserir(triagem);
    }

    // Atualizar
    public void atualizarBo(Triagem triagem) throws ClassNotFoundException, SQLException {
        TriagemDAO triagemDAO = new TriagemDAO();
        // Regras de negócio
        triagemDAO.atualizar(triagem);
    }

    // Deletar
    public void deletarBo(String id) throws ClassNotFoundException, SQLException {
        TriagemDAO triagemDAO = new TriagemDAO();
        // Regras de negócio
        triagemDAO.deletar(id);
    }

}
