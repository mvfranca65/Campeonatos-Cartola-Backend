package com.cartola.group.Controller;

import com.cartola.group.Service.JwtService;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/jwt"})
@Api(value = "Web Token")
@CrossOrigin(origins = "*")
public class JwtController {

    @Autowired
    JwtService service;

    @GetMapping({"/informations"})
    @ApiOperation(value = "Obter dados para criar JWT")
    public ResponseEntity getJwtInformations(@RequestHeader("X-GLB-Token") String token) throws UnirestException {
        return service.getJwtInformations(token);
    }

}
