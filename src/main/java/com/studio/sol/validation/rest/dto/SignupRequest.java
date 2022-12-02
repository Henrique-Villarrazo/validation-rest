package com.studio.sol.validation.rest.dto;

import com.studio.sol.validation.rest.config.Password;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

        @Email
        private String email;

        @Password
        private String password;

}
