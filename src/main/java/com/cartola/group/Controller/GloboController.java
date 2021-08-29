package com.cartola.group.Controller;

import com.cartola.group.Service.GloboService;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/globo"})
@Api(value = "Globo")
@CrossOrigin(origins = "*")
public class GloboController {

    @Autowired
    GloboService service;

//    @PostMapping({"/authentication"})
//    @ApiOperation(value = "Autenticação (Login)")
//    public ResponseEntity authentication(@RequestBody LoginRequestBody body) {
//        return service.authentication(body);
//    }

    @GetMapping({"/leagues"})
    @ApiOperation(value = "Retorna as ligas que o usuário participa")
    public ResponseEntity getLeagues(@RequestHeader("X-GLB-Token") String token) throws UnirestException {
        return service.getLeagues(token);
    }

}
