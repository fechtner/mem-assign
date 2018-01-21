package com.memsource.assignment.model.memsource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Project class returned by memsource API.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProjectResponse {
    /**
     * Project name.
     */
    private String name;
    /**
     * Current status.
     */
    private String status;
    /**
     * Source language.
     */
    private String sourceLang;
    /**
     * Target languages.
     */
    private String[] targetLangs;
}
