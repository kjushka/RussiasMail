package ru.isu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.isu.model.Geozone;
import ru.isu.repository.GeozoneRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private GeozoneRepository geozoneRepository;

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
        System.out.println("Sosi");
        return "redirect: home";
    }
}
