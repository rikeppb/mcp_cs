package org.acme;

import io.mobime.foundation.logs.filters.LogContext;
import io.mobime.foundation.logs.messages.Message.Severity;
import io.mobime.foundation.logs.utils.LoggingUtils;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationLifecycle {

	void onStart(@Observes StartupEvent ev) {
		LogContext.setModule("smart-adapter-galp-frota-cards");

		LoggingUtils.writeControlLog(getClass(), "Starting smart-adapter-galp-frota-cards modules", Severity.INFO);
	}

	void onStop(@Observes ShutdownEvent ev) {
		LoggingUtils.writeControlLog(getClass(), "Shutting down smart-adapter-galp-frota-cards module", Severity.INFO);
	}
}
