package com.fiap.controller;

import com.fiap.model.PlanoDeTratamento;
import com.fiap.BO.PlanoDeTratamentoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/planodetratamento")
public class PlanoDeTratamentoResource {

    private PlanoDeTratamentoBO planoDeTratamentoBO = new PlanoDeTratamentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PlanoDeTratamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<PlanoDeTratamento>) planoDeTratamentoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(PlanoDeTratamento plano, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        planoDeTratamentoBO.inserirBo(plano);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(PlanoDeTratamento plano) throws ClassNotFoundException, SQLException {
        planoDeTratamentoBO.atualizarBo(plano);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        planoDeTratamentoBO.deletarBo(id);
        return Response.ok().build();
    }
}
