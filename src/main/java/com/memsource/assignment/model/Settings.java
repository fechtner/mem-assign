package com.memsource.assignment.model;

/**
 * DTO for storing connections settings.
 */
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

    /**
     * @return Surrogate key
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Surrogate key
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return User name
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user User name
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return User password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password User password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
