package com.memsource.assignment.service;

import com.memsource.assignment.model.Project;
import com.memsource.assignment.model.memsource.LoginResponse;
import com.memsource.assignment.model.memsource.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for communication with memsource api.
 */
@Service
public class MemsourceService {
    /**
     * Login uri, has username and password query variable.
     */
    private static final String LOGIN_URI =
            "https://cloud.memsource.com/web/api/v3/auth/login?userName={USERNAME}&password={PASSWORD}";
    /**
     * Fetch projects uri, has token query variable.
     */
    private static final String PROJECTS_URI =
            "https://cloud.memsource.com/web/api/v3/project/list?token={TOKEN}";

    /**
     * Rest template for communication.
     */
    private final RestTemplate restTemplate;

    /**
     * @param restTemplateBuilder spring builder for creating rest template
     */
    public MemsourceService(@Autowired final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setErrorHandler(new MemsourceResponseErrorHandler());
    }

    /**
     * Get authentication token.
     *
     * @param user     user name
     * @param password user password
     * @return authorization token
     */
    public String getToken(String user, String password) {
        LoginResponse loginResponse = restTemplate.getForObject(LOGIN_URI, LoginResponse.class, user, password);
        return loginResponse.getToken();
    }

    /**
     * Get project list.
     *
     * @param token user token whose projects are fetched
     * @return project list
     */
    public List<Project> getProjects(String token) {
        ProjectResponse[] projectResponse = restTemplate.getForObject(PROJECTS_URI, ProjectResponse[].class, token);
        return Arrays.stream(projectResponse).map(mem ->
                Project.builder()
                        .name(mem.getName())
                        .status(mem.getStatus())
                        .source(mem.getSourceLang())
                        .targets(Arrays.asList(mem.getTargetLangs()))
                        .build()
        ).collect(Collectors.toList());

    }
}
