package com.fiap.controller;

import com.fiap.model.ChatMensagem;
import com.fiap.BO.ChatMensagemBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/chatmensagem")
public class ChatMensagemResource {

    private ChatMensagemBO chatMensagemBO = new ChatMensagemBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ChatMensagem> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<ChatMensagem>) chatMensagemBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(ChatMensagem chatMensagem, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        chatMensagemBO.inserirBo(chatMensagem);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(ChatMensagem chatMensagem) throws ClassNotFoundException, SQLException {
        chatMensagemBO.atualizarBo(chatMensagem);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        chatMensagemBO.deletarBo(id);
        return Response.ok().build();
    }
}
