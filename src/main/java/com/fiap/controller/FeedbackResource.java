package com.fiap.controller;

import com.fiap.model.Feedback;
import com.fiap.BO.FeedbackBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/feedback")
public class FeedbackResource {

    private FeedbackBO feedbackBO = new FeedbackBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Feedback> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Feedback>) feedbackBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Feedback feedback, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        feedbackBO.inserirBo(feedback);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Feedback feedback) throws ClassNotFoundException, SQLException {
        feedbackBO.atualizarBo(feedback);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        feedbackBO.deletarBo(id);
        return Response.ok().build();
    }
}
