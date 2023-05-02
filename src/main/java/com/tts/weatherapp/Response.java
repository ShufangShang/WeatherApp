package com.tts.weatherapp;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Response {
    
    private Map<String, String> coord;
    private List<Map<String, String>> weather;
    private String base;
    private Map<String, String> main;
    private Map<String, String> wind;
    private Map<String, String> clouds;
    private String dt;
    private Map<String, String> sys;
    private String id;
    private String name;
    private String cod;
    
}


