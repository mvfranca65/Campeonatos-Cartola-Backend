package com.cartola.group.Controller;

import com.cartola.group.Service.GloboService;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/globo", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Globo")
@CrossOrigin(origins = "*")
public class GloboController {

    @Autowired
    GloboService service;

    @GetMapping({"/leagues"})
    @ApiOperation(value = "Retorna as ligas que o usuário participa")
    public ResponseEntity getLeagues(@RequestHeader("X-GLB-Token") String token) throws UnirestException {
        return service.getLeagues(token);
    }

}
