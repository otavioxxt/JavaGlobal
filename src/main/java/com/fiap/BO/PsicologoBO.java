package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Psicologo;
import com.fiap.DAO.PsicologoDAO;

public class PsicologoBO {

    PsicologoDAO psicologoDAO;


    public ArrayList<Psicologo> selecionarBo() throws ClassNotFoundException, SQLException {
        psicologoDAO = new PsicologoDAO();


        return (ArrayList<Psicologo>) psicologoDAO.selecionar();
    }


    public void inserirBo(Psicologo psicologo) throws ClassNotFoundException, SQLException {
        PsicologoDAO psicologoDAO = new PsicologoDAO();

        psicologoDAO.inserir(psicologo);
    }


    public void atualizarBo(Psicologo psicologo) throws ClassNotFoundException, SQLException {
        PsicologoDAO psicologoDAO = new PsicologoDAO();

        psicologoDAO.atualizar(psicologo);
    }


    public void deletarBo(String id) throws ClassNotFoundException, SQLException {
        PsicologoDAO psicologoDAO = new PsicologoDAO();

        psicologoDAO.deletar(id);
    }

}

