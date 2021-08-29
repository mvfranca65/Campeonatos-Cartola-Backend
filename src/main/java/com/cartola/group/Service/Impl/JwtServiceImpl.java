package com.cartola.group.Service.Impl;

import com.cartola.group.DTO.Response.JwtResponseDTO;
import com.cartola.group.Service.JwtService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public ResponseEntity getJwtInformations(String token) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.cartolafc.globo.com/auth/time/info")
                .header("X-GLB-Token", token)
                .asString();

        JSONObject json = new JSONObject(response.getBody());
        JSONObject time =  json.getJSONObject("time");

        JwtResponseDTO jwtDTO = new JwtResponseDTO(
                time.getString("nome_cartola"),
                time.getString("globo_id"),
                time.getBigInteger("time_id").toString(),
                time.getString("nome")
        );

        return ResponseEntity.status(HttpStatus.OK).body(jwtDTO);
    }

}
