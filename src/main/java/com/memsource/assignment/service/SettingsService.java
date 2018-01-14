package com.memsource.assignment.service;

import com.memsource.assignment.dao.SettingsMapper;
import com.memsource.assignment.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SettingsService {
    private static int SETTINGS_ID = 1;

    private SettingsMapper settingsMapper;

    public SettingsService(@Autowired SettingsMapper settingsMapper) {
        this.settingsMapper = settingsMapper;
    }

    public Settings getSettings() {
        return getOrInitSettings();
    }

    private synchronized Settings getOrInitSettings() {
        Settings settings = settingsMapper.fetch(SETTINGS_ID);

        if (settings == null) {
            settings = createEmptySettings();
            settingsMapper.insert(settings);
        }
        return settings;
    }

    private Settings createEmptySettings() {
        Settings newSettings = new Settings();
        newSettings.setId(SETTINGS_ID);
        newSettings.setUser("");
        newSettings.setPassword("");
        return newSettings;
    }

    public Settings updateSettings(String user, String password) {
        Settings settings = getOrInitSettings();
        settings.setUser(user);
        settings.setPassword(password);
        settingsMapper.update(settings);

        return settings;
    }
}
