package com.example;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MCPWorkflow {

    @Inject
    @RestClient
    ServicePointNetworkService servicePointNetworkService;

    @Tool(description = "Fetch GeoJson data.")
    public String getGeoJson(@ToolArg(description = "Request payload containing location and radius.") String request) {
        try (Response response = servicePointNetworkService.retrieveServicePointNetworkService(request, "GALP_PORTUGAL", "Bearer someToken")) {
            return response.readEntity(String.class);
        } catch (Exception e) {
            return null;
        }
    }
}