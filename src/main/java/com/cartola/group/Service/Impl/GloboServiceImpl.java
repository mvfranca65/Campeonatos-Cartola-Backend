package com.cartola.group.Service.Impl;

import com.cartola.group.DTO.Request.Login.LoginRequestBody;
import com.cartola.group.Service.GloboService;
import com.cartola.group.Service.feign.GloboFeign;
import com.cartola.group.Service.feign.LoginGloboFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GloboServiceImpl implements GloboService {

    @Autowired
    LoginGloboFeign loginGloboFeign;

    @Autowired
    GloboFeign globoFeign;

    @Override
    public ResponseEntity authentication(LoginRequestBody body) {

        try {
            Object request = loginGloboFeign.authentication(body);
            return ResponseEntity.status(HttpStatus.OK).body(request);
        } catch (FeignException error) {
            HttpStatus status = HttpStatus.resolve(error.status());
            return ResponseEntity.status(status.value()).body(error);
        }

    }

    @Override
    public ResponseEntity getLeagues(String token) {

        try {
            Object request = globoFeign.getLeagues();
            return ResponseEntity.status(HttpStatus.OK).body(request);
        } catch (FeignException error) {
            HttpStatus status = HttpStatus.resolve(error.status());
            return ResponseEntity.status(status.value()).body(error);
        }

    }


}
