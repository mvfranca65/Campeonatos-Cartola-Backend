package com.cartola.group.DTO.Request.Login;

public class LoginRequestBody {

    private LoginPayload payload;
    private String captcha;
    private String captchaProvider;

    public LoginPayload getPayload() {
        return payload;
    }

    public void setPayload(LoginPayload payload) {
        this.payload = payload;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCaptchaProvider() {
        return captchaProvider;
    }

    public void setCaptchaProvider(String captchaProvider) {
        this.captchaProvider = captchaProvider;
    }
}
