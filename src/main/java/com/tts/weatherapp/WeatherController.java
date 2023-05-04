package com.tts.weatherapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.weatherapp.domain.ZipCode;
import com.tts.weatherapp.Repository.MyZipCodeRepository;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private MyZipCodeRepository zipRepository;

    private static List<ZipCode> zipCodes = new ArrayList<>();

    @GetMapping("/")
    public String getIndex(Model model)
    {
    /*  Response response = weatherService.getForecast("43210");
        model.addAttribute("data", response); */
        // zipCodes = zipRepository.findAllByID();

        zipCodes.removeAll(zipCodes);
        for (ZipCode code : zipRepository.findAll()) {
            if(code.getZipCode() !="")
                zipCodes.add(code);
            if(zipCodes.size() >= 10)
            {
                break;
            }
        }
       
        model.addAttribute("codes",zipCodes);
        model.addAttribute("request", new Request());  
        return "index";
    }   

    @PostMapping("/")
    public String postIndex(Request request, Model model) {
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);

        //zipCodes = zipRepository.findAllByID();
        zipCodes.removeAll(zipCodes);
        for (ZipCode code : zipRepository.findAll()) {
            if(code.getZipCode() !="")
                zipCodes.add(code);            

            if(zipCodes.size() >= 10)
            {
                break;
            }           
        }
       
        model.addAttribute("codes", zipCodes);
        return "index";
    }    
}
