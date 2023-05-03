package com.tts.weatherapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.weatherapp.Repository.MyZipCodeRepository;
//import com.tts.weatherapp.Repository.ZipCodeRepository;
import com.tts.weatherapp.domain.ZipCode;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;
    
    @Autowired
    private MyZipCodeRepository repository;

    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
            zipCode + "&units=imperial&appid=" + apiKey;
            RestTemplate restTemplate = new RestTemplate();
            try {
                ZipCode zipCodeEntry= new ZipCode(zipCode);
                repository.save(zipCodeEntry);
                return restTemplate.getForObject(url, Response.class);
            }
            catch (HttpClientErrorException ex) {
                Response response = new Response();
                response.setName("error");
                return response;
            }          
      /*   RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Response.class); */
    } 

    public List<ZipCode> GetSearchHistory()
    {
        return repository.findFirst10ByOrderByIdDesc();
    }
}
