package com.example;

import io.mobime.foundation.logs.filters.LogContext;
import io.mobime.foundation.logs.messages.Message.Severity;
import io.mobime.foundation.logs.utils.LoggingUtils;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ApplicationLifecycle {

    @ConfigProperty(name = "auth.realm.clients.path")
    String realmConfigsPath;

    void onStart(@Observes StartupEvent ev) {
        LogContext.setModule("MCP-SERVER");

        LoggingUtils.writeControlLog(getClass(), "Starting MCP-SERVER module.", Severity.INFO);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LoggingUtils.writeControlLog(getClass(), "Shutting down MCP-SERVER module.",
                Severity.INFO);
    }
}
