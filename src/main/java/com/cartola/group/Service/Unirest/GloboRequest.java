package com.cartola.group.Service.Unirest;

import com.cartola.group.DTO.Response.JwtResponseDTO;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GloboRequest {

    //É chamado em qualquer requisição feita, pois é ele que faz as validações (Token) da Globo
    public int validationGlobo(String token) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.cartolafc.globo.com/logged/time/validar-pro")
                .header("X-GLB-Token", token)
                .asString();

        return response.getStatus();
    }

    //Traz as informações do JWT
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

    //Busca todas as ligas que o usuário participa
    public ResponseEntity getLeagues(String token) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.cartolafc.globo.com/auth/ligas")
                .header("X-GLB-Token", token)
                .asString();

        return ResponseEntity.status(response.getStatus()).body(response.getBody());
    }



}
