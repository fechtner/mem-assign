package com.memsource.assignment.service;

import com.memsource.assignment.dao.SettingsMapper;
import com.memsource.assignment.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for settings.
 */
@Service
public class SettingsService {
    /**
     * ID for main settings.
     */
    private static int SETTINGS_ID = 1;

    /**
     * Settings DAO.
     */
    private SettingsMapper settingsMapper;

    /**
     * @param settingsMapper Settings DAO.
     */
    public SettingsService(@Autowired SettingsMapper settingsMapper) {
        this.settingsMapper = settingsMapper;
    }

    /**
     * Get settings.
     * @return main settings, never null
     */
    public Settings getSettings() {
        return getOrInitSettings();
    }

    /**
     * Load existed main settings from database or initialize it.
     * @return main settings, never null
     */
    private synchronized Settings getOrInitSettings() {
        Settings settings = settingsMapper.fetch(SETTINGS_ID);

        if (settings == null) {
            settings = createEmptySettings();
            settingsMapper.insert(settings);
        }
        return settings;
    }

    /**
     * Create empty settings object.
     * @return new empty settings
     */
    private Settings createEmptySettings() {
        Settings newSettings = new Settings();
        newSettings.setId(SETTINGS_ID);
        newSettings.setUser("");
        newSettings.setPassword("");
        return newSettings;
    }

    /**
     * Persist settings via dao.
     * @param user enw user
     * @param password new password
     * @return persisted object
     */
    public Settings updateSettings(String user, String password) {
        Settings settings = getOrInitSettings();
        settings.setUser(user);
        settings.setPassword(password);
        settingsMapper.update(settings);

        return settings;
    }
}
