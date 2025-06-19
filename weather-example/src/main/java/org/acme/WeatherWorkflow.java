package org.acme;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import io.quarkus.qute.Qute;
import jakarta.inject.Inject;

import java.util.Map;
import java.util.stream.Collectors;

public class WeatherWorkflow {

    @Inject
    WeatherClient weatherClient;

    private String formatForecast(Forecast forecast) {
        return forecast.properties().periods().stream().map(period -> {
            // Template for each forecast period
            return Qute.fmt(
                    """
                            Temperature: {p.temperature}°{p.temperatureUnit}
                            Wind: {p.windSpeed} {p.windDirection}
                            Forecast: {p.detailedForecast}
                            """,
                    Map.of("p", period)).toString();
        }).collect(Collectors.joining("\n---\n"));
    }

    @Tool(description = "Get weather alerts for a US state.")
    String getAlerts(@ToolArg(description = "Two-letter US state code (e.g. CA, NY)") String state) {
        return formatAlerts(weatherClient.getAlerts(state));
    }

    private String formatAlerts(Alerts alerts) {
        // TODO
        return null;
    }

    @Tool(description = "Get weather forecast for a location.")
    String getForecast(
            @ToolArg(description = "Latitude of the location") double latitude,
            @ToolArg(description = "Longitude of the location") double longitude) {

        // First get the point metadata which contains the forecast URL
        var points = weatherClient.getPoints(latitude, longitude);
        // Extract the forecast URL using Qute template
        var url = Qute.fmt("{p.properties.forecast}", Map.of("p", points));
        // Get and format the forecast
        return formatForecast(weatherClient.getForecast(url));
    }
}
