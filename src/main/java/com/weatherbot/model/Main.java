package com.weatherbot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Main {
    private Integer temp;
    @JsonProperty("feels_like")
    private Integer feelsLike;
}
