package com.cartola.group.Service.Impl;

import com.cartola.group.Service.GloboService;
import com.cartola.group.Service.Unirest.GloboRequest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GloboServiceImpl implements GloboService {

    @Autowired
    GloboRequest globo;

    @Override
    public ResponseEntity getLeagues(String token) throws UnirestException {
        return globo.getLeagues(token);
    }

    @Override
    public ResponseEntity getJwtInformations(String token) throws UnirestException {
        return globo.getJwtInformations(token);
    }

}
