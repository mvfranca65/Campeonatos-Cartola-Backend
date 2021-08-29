package com.cartola.group.DTO.Response;

import java.math.BigInteger;

public class JwtResponseDTO {

    private String name;
    private String globo_id;
    private String time_id;
    private String user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGlobo_id() {
        return globo_id;
    }

    public void setGlobo_id(String globo_id) {
        this.globo_id = globo_id;
    }

    public String getTime_id() {
        return time_id;
    }

    public void setTime_id(String time_id) {
        this.time_id = time_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public JwtResponseDTO(String name, String globo_id, String time_id, String user) {
        this.name = name;
        this.globo_id = globo_id;
        this.time_id = time_id;
        this.user = user;
    }
}
