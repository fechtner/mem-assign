package com.memsource.assignment.controller;

import com.memsource.assignment.model.Project;
import com.memsource.assignment.model.Settings;
import com.memsource.assignment.service.MemsourceService;
import com.memsource.assignment.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final SettingsService settingsService;

    private final MemsourceService memsourceService;

    public ApiController(@Autowired final SettingsService settingsService,
                         @Autowired final MemsourceService memsourceService) {
        this.settingsService = settingsService;
        this.memsourceService = memsourceService;
    }

    @RequestMapping(path = "/projects/data", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> fetchProjects() {
        Settings settings = settingsService.getSettings();
        String token = memsourceService.getToken(settings.getUser(), settings.getPassword());
        return memsourceService.getProjects(token);
    }
}
