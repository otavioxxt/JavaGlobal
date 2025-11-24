package com.fiap.controller;

import com.fiap.BO.PacienteBO;
import com.fiap.model.Paciente;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/paciente")
public class PacienteResource {


    private PacienteBO pacienteBO = new PacienteBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paciente> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Paciente>) pacienteBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        pacienteBO.inserirBo(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }


    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente) throws ClassNotFoundException, SQLException {
        pacienteBO.atualizarBo(paciente);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        pacienteBO.deletarBo(id);
        return Response.ok().build();
    }


}
