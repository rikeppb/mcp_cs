package com.example;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/prompt")
public class PromptService {

    @Inject
    MCPWorkflow mcpWorkflow;

    @Tool(description = "Process natural language prompt to find charging stations on the map.")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public JsonObject handlePrompt(@ToolArg(description = "Natural language prompt") String prompt) {
        // Simulate processing the prompt to extract location and radius
        String location = "Sample City"; // Placeholder for actual location extraction
        String radius = "10km"; // Placeholder for actual radius extraction

        // Simulate creating a request for the GeoJson client
        String geoJsonRequest = "{\"location\": \"" + location + "\", \"radius\": \"" + radius + "\"}";

        // Call the GeoJson client
        String geoJsonResponse = mcpWorkflow.getGeoJson(geoJsonRequest);

        // Construct the response JSON object
        JsonObject response = Json.createObjectBuilder()
            .add("geojson", geoJsonResponse)
            .add("message", "Yes, we found some charging stations for you.")
            .build();

        return response;
    }
}