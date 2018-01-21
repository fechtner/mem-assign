package com.memsource.assignment.model.memsource;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Response class for memsource api login.
 */
@Data
public class LoginResponse {
    /**
     * User information.
     */
    private User user;
    /**
     * Oauth token.
     */
    private String token;
    /**
     * Token expiration time.
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssZ", timezone="GMT")
    private ZonedDateTime expires;

    /**
     * Response class for memsource user object.
     */
    @Data
    public static class User {
        /**
         * User identification.
         */
        private Integer id;
        /**
         * User first name.
         */
        private String firstName;
        /**
         * User last name.
         */
        private String lastName;
        /**
         * User login name.
         */
        private String userName;
        /**
         * User role.
         */
        private String role;
    }
}
