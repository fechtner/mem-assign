package com.memsource.assignment.controller;

import com.memsource.assignment.model.Settings;
import com.memsource.assignment.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * controller for pages with templates.
 */
@Controller
public class TemplateController {

    private SettingsService settingsService;

    public TemplateController(@Autowired SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    /**
     * Main page.
     * @return template name
     */
    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    /**
     * Settings page.
     * @param model spring page model
     * @return template name
     */
    @RequestMapping(path = "/settings", method = RequestMethod.GET)
    public String getSettingsPage(Model model) {
        model.addAttribute("settings", settingsService.getSettings());
        return "settings";
    }

    /**
     * Save settings.
     * @param model spring page model
     * @param user new user name
     * @param password new password
     * @return template name
     */
    @RequestMapping(path = "/settings", method = RequestMethod.POST)
    public String saveSettings(Model model, @RequestParam String user, @RequestParam String password) {
        Settings settings = settingsService.updateSettings(user, password);
        model.addAttribute("settings", settings);
        return "settings";
    }

    /**
     * Projects page.
     * @return template name
     */
    @RequestMapping("/projects")
    public String getProjectsPage() {
        return "projects";
    }
}
