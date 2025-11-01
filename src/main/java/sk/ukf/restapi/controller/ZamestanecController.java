package sk.ukf.restapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.ukf.restapi.entity.zamestanci;
import sk.ukf.restapi.service.zamestanciService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class ZamestanecController {

    private final zamestanciService zamestanciService;

    @Value("#{'${app.employee.job-titles}'.split(',')}")
    private List<String> jobTitles;

    public ZamestanecController(zamestanciService zamestanciService) {
        this.zamestanciService = zamestanciService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        List<zamestanci> employees = zamestanciService.findAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable int id, Model model) {
        zamestanci employee = zamestanciService.findById(id);
        model.addAttribute("employee", employee);
        return "view";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new zamestanci());
        model.addAttribute("jobTitles", jobTitles);
        return "form";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employee") zamestanci employee) {
        zamestanciService.save(employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        zamestanciService.deleteById(id);
        return "redirect:/employees";
    }
}

