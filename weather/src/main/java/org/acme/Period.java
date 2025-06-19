
package org.acme;

import java.util.List;

record Period(
    String name,
    int temperature,
    String temperatureUnit,
    String windSpeed,
    String windDirection,
    String detailedForecast) {
}

record ForecastProperties(
        List<Period> periods) {
}

record Forecast(
        ForecastProperties properties) {
}