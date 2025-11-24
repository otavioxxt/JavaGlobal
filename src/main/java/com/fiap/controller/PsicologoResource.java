package com.fiap.controller;

import com.fiap.model.Psicologo;
import com.fiap.BO.PsicologoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/psicologo")
public class PsicologoResource {

    private PsicologoBO psicologoBO = new PsicologoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Psicologo> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Psicologo>) psicologoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Psicologo psicologo, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        psicologoBO.inserirBo(psicologo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Psicologo psicologo) throws ClassNotFoundException, SQLException {
        psicologoBO.atualizarBo(psicologo);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        psicologoBO.deletarBo(id);
        return Response.ok().build();
    }
}
