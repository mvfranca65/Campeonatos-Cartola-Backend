package com.cartola.group.Service;

import com.cartola.group.DTO.Request.Login.LoginRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface GloboService {

    ResponseEntity authentication(LoginRequestBody body);

    ResponseEntity getLeagues(String token);

}