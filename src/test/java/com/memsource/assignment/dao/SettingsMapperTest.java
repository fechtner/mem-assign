package com.memsource.assignment.dao;

import com.memsource.assignment.TestConfig;
import com.memsource.assignment.model.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class SettingsMapperTest {

    public static final int ID = 999;

    @Autowired
    private SettingsMapper mapper;

    @Test
    public void testCRUD() {

        Settings fetchedSettings = mapper.fetch(ID);
        Assert.assertNull(fetchedSettings);

        // create
        Settings newSettings = new Settings();
        newSettings.setId(ID);
        newSettings.setUser("user name");
        newSettings.setPassword("user password");
        int insertObjects = mapper.insert(newSettings);
        Assert.assertEquals(1, insertObjects);

        // read
        fetchedSettings = mapper.fetch(ID);
        Assert.assertNotNull(fetchedSettings);

        Assert.assertEquals("user name", fetchedSettings.getUser());
        Assert.assertEquals("user password", fetchedSettings.getPassword());

        // update
        fetchedSettings.setUser("user name2");
        fetchedSettings.setPassword("user password2");

        int updatedRows = mapper.update(fetchedSettings);
        Assert.assertEquals(1, updatedRows);

        fetchedSettings = mapper.fetch(ID);
        Assert.assertEquals("user name2", fetchedSettings.getUser());
        Assert.assertEquals("user password2", fetchedSettings.getPassword());

        // delete
        int deletedObjects = mapper.delete(newSettings);
        Assert.assertEquals(1, deletedObjects);

        fetchedSettings = mapper.fetch(ID);
        Assert.assertNull(fetchedSettings);
    }
}
