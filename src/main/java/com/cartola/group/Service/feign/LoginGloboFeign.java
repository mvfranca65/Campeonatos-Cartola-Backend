package com.cartola.group.Service.feign;

import com.cartola.group.DTO.Request.Login.LoginRequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login", url = "https://login.globo.com/api")
public interface LoginGloboFeign {

    @PostMapping("/authentication")
    Object authentication(@RequestBody LoginRequestBody body);

}
