package com.cartola.group.DTO.Request.Login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginPayload {

    @Email(message = "E-mail inválido.")
    private String email;

    @NotNull(message = "A senha não pode ser NULL")
    @NotEmpty(message = "A senha não pode estar vazia.")
    private String password;

    private Integer serviceId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
