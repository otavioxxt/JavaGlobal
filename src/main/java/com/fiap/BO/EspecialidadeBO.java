package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Especialidade;
import com.fiap.DAO.EspecialidadeDAO;

public class EspecialidadeBO {

    EspecialidadeDAO especialidadeDAO;


    public ArrayList<Especialidade> selecionarBo() throws ClassNotFoundException, SQLException {
        especialidadeDAO = new EspecialidadeDAO();


        return (ArrayList<Especialidade>) especialidadeDAO.selecionar();
    }


    public void inserirBo(Especialidade especialidade) throws ClassNotFoundException, SQLException {
        EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();

        especialidadeDao.inserir(especialidade);
    }


    public void atualizarBo (Especialidade especialidade) throws ClassNotFoundException, SQLException {
        EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();

        especialidadeDao.atualizar(especialidade);
    }


    public void deletarBo (String id) throws ClassNotFoundException, SQLException {
        EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();

        especialidadeDao.deletar(id);
    }

}

