package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.EmpresaParceira;
import com.fiap.DAO.EmpresaParceiraDAO;

public class EmpresaParceiraBO {

    EmpresaParceiraDAO empresaParceiraDAO;


    public ArrayList<EmpresaParceira> selecionarBo() throws ClassNotFoundException, SQLException {
        empresaParceiraDAO = new EmpresaParceiraDAO();


        return (ArrayList<EmpresaParceira>) empresaParceiraDAO.selecionar();
    }


    public void inserirBo(EmpresaParceira empresaParceira) throws ClassNotFoundException, SQLException {
        EmpresaParceiraDAO empresaParceiraDao = new EmpresaParceiraDAO();

        empresaParceiraDao.inserir(empresaParceira);
    }


    public void atualizarBo (EmpresaParceira empresaParceira) throws ClassNotFoundException, SQLException {
        EmpresaParceiraDAO empresaParceiraDao = new EmpresaParceiraDAO();

        empresaParceiraDao.atualizar(empresaParceira);
    }


    public void deletarBo (String id) throws ClassNotFoundException, SQLException {
        EmpresaParceiraDAO empresaParceiraDao = new EmpresaParceiraDAO();

        empresaParceiraDao.deletar(id);
    }

}

