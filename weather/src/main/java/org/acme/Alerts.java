
package org.acme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alerts {
    
    @JsonProperty("@context")
    private List<Object> context;
    
    private String type;
    private List<Feature> features;
    private String title;
    private Instant updated;
    
    // Getters and setters
    public List<Object> getContext() { return context; }
    public void setContext(List<Object> context) { this.context = context; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public List<Feature> getFeatures() { return features; }
    public void setFeatures(List<Feature> features) { this.features = features; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public Instant getUpdated() { return updated; }
    public void setUpdated(Instant updated) { this.updated = updated; }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Feature {
        private String id;
        private String type;
        private Geometry geometry;
        private Properties properties;
        
        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        
        public Geometry getGeometry() { return geometry; }
        public void setGeometry(Geometry geometry) { this.geometry = geometry; }
        
        public Properties getProperties() { return properties; }
        public void setProperties(Properties properties) { this.properties = properties; }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {
        private String type;
        private List<List<List<List<Double>>>> coordinates;
        
        // Getters and setters
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        
        public List<List<List<List<Double>>>> getCoordinates() { return coordinates; }
        public void setCoordinates(List<List<List<List<Double>>>> coordinates) { this.coordinates = coordinates; }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Properties {
        private String id;
        private String areaDesc;
        private String geocode;
        private List<String> affectedZones;
        private List<String> references;
        private Instant sent;
        private Instant effective;
        private Instant onset;
        private Instant expires;
        private Instant ends;
        private String status;
        private String messageType;
        private String category;
        private String severity;
        private String certainty;
        private String urgency;
        private String event;
        private String sender;
        private String senderName;
        private String headline;
        private String description;
        private String instruction;
        private String response;
        
        // Getters and setters for all fields...
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getAreaDesc() { return areaDesc; }
        public void setAreaDesc(String areaDesc) { this.areaDesc = areaDesc; }
        
        public String getEvent() { return event; }
        public void setEvent(String event) { this.event = event; }
        
        public String getSeverity() { return severity; }
        public void setSeverity(String severity) { this.severity = severity; }
        
        public String getHeadline() { return headline; }
        public void setHeadline(String headline) { this.headline = headline; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        
        // ... additional getters/setters for remaining fields
    }
}