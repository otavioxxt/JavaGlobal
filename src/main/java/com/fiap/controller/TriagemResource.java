package com.fiap.controller;

import com.fiap.model.Triagem;
import com.fiap.BO.TriagemBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/triagem")
public class TriagemResource {

    private TriagemBO triagemBO = new TriagemBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Triagem> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Triagem>) triagemBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Triagem triagem, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        triagemBO.inserirBo(triagem);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Triagem triagem) throws ClassNotFoundException, SQLException {
        triagemBO.atualizarBo(triagem);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        triagemBO.deletarBo(id);
        return Response.ok().build();
    }
}
