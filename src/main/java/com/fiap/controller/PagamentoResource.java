package com.fiap.controller;

import com.fiap.model.Pagamento;
import com.fiap.BO.PagamentoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/pagamento")
public class PagamentoResource {

    private PagamentoBO pagamentoBO = new PagamentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pagamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Pagamento>) pagamentoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Pagamento pagamento, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        pagamentoBO.inserirBo(pagamento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Pagamento pagamento) throws ClassNotFoundException, SQLException {
        pagamentoBO.atualizarBo(pagamento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        pagamentoBO.deletarBo(id);
        return Response.ok().build();
    }
}
