package com.tweetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank(message = "Field not is empty")
    private String avatar;
    
    @NotBlank(message = "Field not is empty")
    @Size(max= 100, message = "maximum size is 100 caracters")
    private String username;
    
}
