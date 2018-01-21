package com.memsource.assignment.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Model DTO for representing project.
 */
@Getter
@Builder
public class Project {
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
    private String source;
    /**
     * Target languages.
     */
    private List<String> targets;
}
