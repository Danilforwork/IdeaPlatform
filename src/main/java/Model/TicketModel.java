package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TicketModel {
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("origin_name")
    private String origin_name;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("destination_name")
    private String destination_name;
    @JsonProperty("departure_date")
    private String departure_date;
    @JsonProperty("departure_time")
    private String departure_time;
    @JsonProperty("arrival_date")
    private String arrival_date;
    @JsonProperty("arrival_time")
    private String arrival_time;
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("stops")
    private int stops;
    @JsonProperty("price")
    private int price;
}
