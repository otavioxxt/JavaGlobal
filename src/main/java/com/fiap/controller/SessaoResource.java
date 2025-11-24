package com.fiap.controller;

import com.fiap.model.Sessao;
import com.fiap.BO.SessaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/sessao")
public class SessaoResource {

    private SessaoBO sessaoBO = new SessaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sessao> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Sessao>) sessaoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Sessao sessao, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        sessaoBO.inserirBo(sessao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Sessao sessao) throws ClassNotFoundException, SQLException {
        sessaoBO.atualizarBo(sessao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        sessaoBO.deletarBo(id);
        return Response.ok().build();
    }
}
