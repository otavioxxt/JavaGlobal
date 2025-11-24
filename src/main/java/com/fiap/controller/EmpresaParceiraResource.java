package com.fiap.controller;

import com.fiap.model.EmpresaParceira;
import com.fiap.BO.EmpresaParceiraBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/empresaparceira")
public class EmpresaParceiraResource {

    private EmpresaParceiraBO empresaParceiraBO = new EmpresaParceiraBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<EmpresaParceira> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<EmpresaParceira>) empresaParceiraBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(EmpresaParceira empresa, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        empresaParceiraBO.inserirBo(empresa);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(EmpresaParceira empresa) throws ClassNotFoundException, SQLException {
        empresaParceiraBO.atualizarBo(empresa);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        empresaParceiraBO.deletarBo(id);
        return Response.ok().build();
    }
}
