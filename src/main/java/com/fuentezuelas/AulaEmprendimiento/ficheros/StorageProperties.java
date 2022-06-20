package com.fuentezuelas.AulaEmprendimiento.ficheros;


import org.springframework.boot.context.properties.ConfigurationProperties;

public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}