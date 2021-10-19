package com.cartola.group.Token;

import org.json.JSONObject;

import java.util.Base64;

public class DecodeToken {

    public JSONObject header(String token) {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();

        String header = new String(decoder.decode(chunks[0]));
        return new JSONObject(header);
    }

    public JSONObject payload(String token) {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();

        String payload = new String(decoder.decode(chunks[1]));
        return new JSONObject(payload);
    }

}
