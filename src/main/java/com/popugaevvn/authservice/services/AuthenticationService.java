package com.popugaevvn.authservice.services;

import com.popugaevvn.authservice.api.requests.auth.AuthenticationRequest;
import com.popugaevvn.authservice.api.requests.register.RegisterRequest;
import com.popugaevvn.authservice.api.responses.auth.AuthenticationResponse;
import com.popugaevvn.authservice.models.Role;
import com.popugaevvn.authservice.models.User;
import com.popugaevvn.authservice.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .login(request.getLogin())
                .hashPassword(passwordEncoder.encode(request.getHashPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken tokenWithCredentials = new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getHashPassword()
        );
        authenticationManager.authenticate(tokenWithCredentials);

        User user = userRepository.findByLogin(request.getLogin()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
