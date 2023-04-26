package com.popugaevvn.authservice.api.requests.register;

import com.popugaevvn.authservice.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String login;
    private String hashPassword;
    private Role role;

}
