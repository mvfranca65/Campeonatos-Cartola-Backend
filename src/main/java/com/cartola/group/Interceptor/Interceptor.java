package com.cartola.group.Interceptor;

import com.cartola.group.Service.Unirest.GloboRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    GloboRequest globoRequest;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Requisição interceptada: " + request.getHeader("X-GLB-Token"));

        if(request.getHeader("X-GLB-Token") != null) {
            int code = globoRequest.validationGlobo(request.getHeader("X-GLB-Token"));
            return responseValidation(code);
        } else {
            return true;
        }

    }

    private boolean responseValidation(int code) {
        switch(code) {
            case 401:
                //Não autorizado
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Não autorizado");
            case 500:
                //Erro interno
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro Interno");
            case 503:
                //Mercado em manutenção
                throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Serviço indisponível");
            default:
                //Sucesso
                return true;
        }
    }

}