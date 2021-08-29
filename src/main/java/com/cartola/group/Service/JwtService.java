package com.cartola.group.Service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.ResponseEntity;

public interface JwtService {

    ResponseEntity getJwtInformations(String token) throws UnirestException;

}
