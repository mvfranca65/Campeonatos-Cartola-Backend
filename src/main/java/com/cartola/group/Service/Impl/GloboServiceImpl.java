package com.cartola.group.Service.Impl;

import com.cartola.group.DTO.Request.Login.LoginRequestBody;
import com.cartola.group.Service.GloboService;
import com.cartola.group.Service.feign.GloboFeign;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GloboServiceImpl implements GloboService {

    @Autowired
    GloboFeign globoFeign;

//    @Override
//    public ResponseEntity authentication(LoginRequestBody body) {
//
//        try {
//            Object request = globoFeign.authentication(body);
//            return ResponseEntity.status(HttpStatus.OK).body(request);
//        } catch (FeignException error) {
//            HttpStatus status = HttpStatus.resolve(error.status());
//            return ResponseEntity.status(status.value()).body(error);
//        }
//
//    }

    @Override
    public ResponseEntity getLeagues(String token) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.cartolafc.globo.com/auth/ligas")
                .header("X-GLB-Token", token)
                .asString();

        return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }


}
