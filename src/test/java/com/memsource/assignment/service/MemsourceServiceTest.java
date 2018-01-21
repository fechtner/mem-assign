package com.memsource.assignment.service;


import com.memsource.assignment.TestConfig;
import com.memsource.assignment.model.memsource.AuthenticationException;
import com.memsource.assignment.model.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class MemsourceServiceTest {

    @Autowired
    private MemsourceService memsourceService;

    @Test
    public void testLogin() {
        String token = memsourceService.getToken("fechtnertomas@gmail.com", "43EzffVFqR9VjOBN5H1n");
        Assert.assertNotNull(token);
    }

    @Test(expected = AuthenticationException.class)
    public void testFailedLogin() {
        memsourceService.getToken("fechtnertomas@gmail.com", "wrong password");
    }

    @Test
    public void testProjects() {
        String token = memsourceService.getToken("fechtnertomas@gmail.com", "43EzffVFqR9VjOBN5H1n");
        List<Project> projectList = memsourceService.getProjects(token);
        Assert.assertNotNull(projectList);
    }

    @Test(expected = AuthenticationException.class)
    public void testProjectsWrongToken() {
        List<Project> projectList = memsourceService.getProjects("wrong token");
        Assert.assertNotNull(projectList);
    }
}
