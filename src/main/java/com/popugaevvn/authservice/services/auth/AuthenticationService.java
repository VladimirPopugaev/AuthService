package com.popugaevvn.authservice.services.auth;

import com.popugaevvn.authservice.api.requests.auth.AuthenticationRequest;
import com.popugaevvn.authservice.api.requests.register.RegisterRequest;
import com.popugaevvn.authservice.api.responses.auth.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
