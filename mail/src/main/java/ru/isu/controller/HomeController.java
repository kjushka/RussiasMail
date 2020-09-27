package ru.isu.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isu.model.auxiliary.FormData;
import ru.isu.model.basic.Geozone;
import ru.isu.model.basic.Service;
import ru.isu.model.custom.*;
import ru.isu.repository.GeozoneRepository;
import ru.isu.repository.ServiceRepository;
import ru.isu.service.DecisionService;
import ru.isu.service.UploadService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private GeozoneRepository geozoneRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UploadService service;
    @Autowired
    private DecisionService decisionService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/form")
    public String createForm(Model model) {
        List<Geozone> geozones = geozoneRepository.findAll();
        model.addAttribute("geozones", geozones);
        List<Service> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        model.addAttribute("formData", new FormData());
        return "form";
    }

    @RequestMapping(value = "/makeorder", method = RequestMethod.POST)
    public String makeOrder(@RequestParam("service-name") String service, @RequestParam("from") String from,
                            @RequestParam("to") String to, @RequestParam("weight") int weight,
                            @RequestParam("priority") byte priority, @RequestParam("max-price") int maxPrice) {
        FormData formData = new FormData();
        formData.setService(serviceRepository.findServiceByName(service));
        formData.setFrom(geozoneRepository.findGeozoneByName(from));
        formData.setTo(geozoneRepository.findGeozoneByName(to));
        formData.setWeight(weight);
        formData.setPriority(priority);
        formData.setMaxCustomerPrice(maxPrice);
        List<Pair<Executor, Geozone>> bestChain = decisionService.getExecutorChain(formData);
        System.out.println(bestChain);
        if (bestChain == null) {
            System.out.println("No one can take order");
        } else {
            for (Pair<Executor, Geozone> pair :
                    bestChain) {
                System.out.println(pair.getFirst().getName() + " from " + pair.getSecond().getName());
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/upload")
    public String uploadData() throws IOException {
        Gson gson = new Gson();
        String filePath = "C:\\Users\\donto\\IdeaProjects\\springmvc-test\\films\\RussiasMail\\data.json";
        String json = Files.readString(Paths.get("C:\\Users\\donto\\IdeaProjects\\springmvc-test\\films\\RussiasMail\\data.json"),
                Charset.forName("utf-8"));// readUsingBufferedReader(filePath);
        CustomData data = gson.fromJson(json, CustomData.class);
        System.out.println(data);
        Runnable uploadToDB = () -> service.uploadToDB(data.getData());
        Thread thread = new Thread(uploadToDB);
        thread.start();
        return "redirect:/";
    }

    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
