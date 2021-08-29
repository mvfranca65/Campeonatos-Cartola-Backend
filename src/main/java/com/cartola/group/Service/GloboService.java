package com.cartola.group.Service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.ResponseEntity;

public interface GloboService {

//    ResponseEntity authentication(LoginRequestBody body);

    ResponseEntity getLeagues(String token) throws UnirestException;

}