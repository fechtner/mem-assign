package com.memsource.assignment.controller;

import com.memsource.assignment.model.Settings;
import com.memsource.assignment.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController {

    private SettingsService settingsService;

    public TemplateController(@Autowired SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(path = "/settings", method = RequestMethod.GET)
    public String getSettingsPage(Model model) {
        model.addAttribute("settings", settingsService.getSettings());
        return "settings";
    }

    @RequestMapping(path = "/settings", method = RequestMethod.POST)
    public String saveSettings(Model model, @RequestParam String user, @RequestParam String password) {
        Settings settings = settingsService.updateSettings(user, password);
        model.addAttribute("settings", settings);
        return "settings";
    }
}
