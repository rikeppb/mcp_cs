package com.example;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/servicepoint.network.smart/api")
@RegisterRestClient(configKey = "smart-servicepoints")
public interface ServicePointNetworkService {

    @POST
    @Path("/network")
    Response retrieveServicePointNetworkService(String request,    //
            @HeaderParam(value = "BUSINESS_UNIT") String businessUnit, //
            @HeaderParam(value = "AUTHORIZATION") String bearer);
}
