package com.example.mystore.user;

import android.view.View;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.example.mystore.BaseActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class UserLogin extends BaseActivity{
    private static TextInputLayout tfLogin;
    private static TextInputLayout tfPassword;
    private final String TAG="UserLogin";
    private static final long EXPIRATION_TIME = 864_000_000;
    public static String generateJwtToken() {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(tfLogin.getEditText().getText().toString().trim())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, tfPassword.getEditText().getText().toString().trim())
                .compact();
    }

    public void login(View view) {
    }
}
