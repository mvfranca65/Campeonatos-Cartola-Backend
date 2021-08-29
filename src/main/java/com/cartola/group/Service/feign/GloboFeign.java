package com.cartola.group.Service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "login", url = "https://login.globo.com/api")
public interface GloboFeign {

//    @PostMapping("/authentication")
//    Object authentication(@RequestBody LoginRequestBody body);

}
