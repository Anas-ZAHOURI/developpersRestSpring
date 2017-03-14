package com.anas.zahouri.controller;

/**
 * Created by azahouri on 13/03/2017.
 */

import com.anas.zahouri.model.Developper;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/developpers")
@Service
@Produces(MediaType.APPLICATION_JSON)
public interface DeveloppersRESTResource {
    @GET
    @Path("/developper/")
    List<Developper> listAllDeveloppers();

    @GET
    @Path("/developper/{id}")
    Developper getDevelopper(@PathParam("id") long id);

    @POST
    @Path("/developper/")
    Developper createDevelopper(Developper developper);

    @PUT
    @Path("/developper/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Developper updateDevelopper(Developper developper);

    @DELETE
    @Path("/developper/{id}")
    void deleteDevelopper(@PathParam("id") long id);


    @DELETE
    @Path("/developper/")
    void deleteAllDeveloppers();

    @GET
    @Path("/version/")
    String getVersion();
}
