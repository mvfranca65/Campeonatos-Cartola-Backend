package com.cartola.group.Service.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "leagues", url = "https://api.cartolafc.globo.com/auth")
public interface GloboFeign {

    @Headers({
            "User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"})
    @GetMapping("/ligas")
    Object getLeagues();

}
