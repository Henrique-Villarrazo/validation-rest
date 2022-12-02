package com.studio.sol.validation.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.studio.sol.validation.rest.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupResponse {

    private String message;
    private Instant timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;

}
