package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.Paciente;
import com.fiap.DAO.PacienteDAO;

public class PacienteBO {

    PacienteDAO pacienteDAO;

    // Selecionar
    public ArrayList<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        // Regra de negócios

        return (ArrayList<Paciente>) pacienteDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        // Regra de negócios
        pacienteDao.inserir(paciente);
    }

    // Atualizar
    public void atualizarBo (Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        // Regra de negócios
        pacienteDao.atualizar(paciente);
    }

    // Deletar
    public void deletarBo (String id) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        // Regra de negócios
        pacienteDao.deletar(id);
    }

}


