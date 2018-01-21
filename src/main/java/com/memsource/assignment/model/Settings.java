package com.memsource.assignment.model;

import lombok.Data;

/**
 * DTO for storing connections settings.
 */
@Data
public class Settings {
    /**
     * Surrogate key.
     */
    private int id;
    /**
     * User name.
     */
    private String user;
    /**
     * User password.
     */
    private String password;
}
