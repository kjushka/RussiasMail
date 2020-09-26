package ru.isu.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.isu.model.basic.Geozone;
import ru.isu.model.custom.CustomData;
import ru.isu.repository.GeozoneRepository;
import ru.isu.service.UploadService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private GeozoneRepository geozoneRepository;
    @Autowired
    private UploadService service;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/form")
    public String createForm(Model model) {
        List<Geozone> geozones = geozoneRepository.findAll();
        model.addAttribute("geozones", geozones);
        return "form";
    }

    @RequestMapping(value = "/makeorder", method = RequestMethod.POST)
    public String makeOrder() {
        return "redirect: ./form";
    }

    @RequestMapping(value = "/upload")
    public String uploadData() throws IOException {
        Gson gson = new Gson();
        String filePath = "D:\\Проекты\\git\\RussiasMail\\data.json";
        String json = readUsingBufferedReader(filePath);
        CustomData data = gson.fromJson(json, CustomData.class);
        System.out.println(data.getData().getContractors().get(0));
        Runnable uploadToDB = () -> service.uploadToDB(data.getData());
        Thread thread = new Thread(uploadToDB);
        thread.start();
        return "redirect:/";
    }

    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
