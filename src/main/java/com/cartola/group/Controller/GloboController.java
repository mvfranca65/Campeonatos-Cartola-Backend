package com.cartola.group.Controller;

import com.cartola.group.DTO.Request.Login.LoginRequestBody;
import com.cartola.group.Service.GloboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/authentication"})
@Api(value = "Globo")
@CrossOrigin(origins = "*")
public class GloboController {

    @Autowired
    GloboService service;

    @PostMapping({"/login"})
    @ApiOperation(value = "Autenticação (Login)")
    public ResponseEntity authentication(@RequestBody LoginRequestBody body) {
        return service.authentication(body);
    }

    @GetMapping({"/ligas"})
    @ApiOperation(value = "Buscar as ligas que o usuário participa")
    public ResponseEntity getLeagues(@RequestHeader("X-GLB-Token") String token) {
        return service.getLeagues(token);
    }

}
