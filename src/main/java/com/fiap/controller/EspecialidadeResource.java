package com.fiap.controller;

import com.fiap.model.Especialidade;
import com.fiap.BO.EspecialidadeBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/especialidade")
public class EspecialidadeResource {

    private EspecialidadeBO especialidadeBO = new EspecialidadeBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Especialidade> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Especialidade>) especialidadeBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Especialidade especialidade, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        especialidadeBO.inserirBo(especialidade);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Especialidade especialidade) throws ClassNotFoundException, SQLException {
        especialidadeBO.atualizarBo(especialidade);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        especialidadeBO.deletarBo(id);
        return Response.ok().build();
    }
}
