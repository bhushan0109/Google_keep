package com.finovate.service;

import com.finovate.dto.LoginDto;
import com.finovate.dto.RegisterDto;
import com.finovate.model.Response;
import com.finovate.model.ResponseToken;

public interface UserService {
    ResponseToken login(LoginDto user);

    Response register(RegisterDto userRecord) throws Exception;

    Response forgotPassword(String email);

    Response userVerification(String token);

    Response resetPassword(String newPassword, String token);
}
