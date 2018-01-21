package com.memsource.assignment.controller;

import com.memsource.assignment.model.Project;
import com.memsource.assignment.model.Settings;
import com.memsource.assignment.model.memsource.AuthenticationException;
import com.memsource.assignment.service.MemsourceService;
import com.memsource.assignment.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for REST endpoints.
 */
@RestController
public class ApiController {

    private final SettingsService settingsService;

    private final MemsourceService memsourceService;

    public ApiController(@Autowired final SettingsService settingsService,
                         @Autowired final MemsourceService memsourceService) {
        this.settingsService = settingsService;
        this.memsourceService = memsourceService;
    }

    /**
     * Get project list.
     * @return projects
     */
    @RequestMapping(path = "/projects/data", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> fetchProjects() {
        Settings settings = settingsService.getSettings();
        String token = memsourceService.getToken(settings.getUser(), settings.getPassword());
        return memsourceService.getProjects(token);
    }

    /**
     * Handling authentication expception.
     * @return repsonse with error message
     */
    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<String> authenticationErrorHandler() {
        return new ResponseEntity<>("Memsource authentication error.", HttpStatus.UNAUTHORIZED);
    }
}
