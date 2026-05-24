package com.mealrecipes.backend.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "api_config")
public class apiConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String api_url;

    public apiConfig() {
    }

    public apiConfig(Long id, String name, String api_url) {
        this.id = id;
        this.name = name;
        this.api_url = api_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }
}
