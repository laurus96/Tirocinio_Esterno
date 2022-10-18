package com.example.aircraft.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {
    @Id
    private Long id;
    private String callsign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;

    @JsonProperty("vert_rate")
    private int vertRate;

    @JsonProperty("selected_altiude")
    private int selectedAltiude;

    private double lat, lon, barometer;

    @JsonProperty("polar_distance")
    private double polarDistance;

    @JsonProperty("polar_bearing")
    private double polarBearing;

    @JsonProperty("is_adsb")
    private boolean isADSB;

    @JsonProperty("is_on_ground")
    private boolean isOnGround;

    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;

    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;

    @JsonProperty("bds40_seen_time")
    private Instant bds40SeenTime;

    public String getLastSeenTime(){
        return  this.lastSeenTime.toString();
    }

    public void setLastSeenTime(String lastSeenTime){
        if (lastSeenTime != null){
            this.lastSeenTime = Instant.parse(lastSeenTime);
        } else
            this.lastSeenTime = Instant.ofEpochSecond(0);
    }

    public String getPosUpdateTime(){
        return  this.posUpdateTime.toString();
    }

    public void setPosUpdateTime(String posUpdateTime){
        if (posUpdateTime != null){
            this.posUpdateTime = Instant.parse(posUpdateTime);
        } else
            this.posUpdateTime = Instant.ofEpochSecond(0);
    }

    public String getBds40SeenTime(){
        return  this.bds40SeenTime.toString();
    }

    public void setBds40SeenTimee(String bds40SeenTimee){
        if (lastSeenTime != null){
            this.bds40SeenTime = Instant.parse(bds40SeenTimee);
        } else
            this.bds40SeenTime = Instant.ofEpochSecond(0);
    }


}
