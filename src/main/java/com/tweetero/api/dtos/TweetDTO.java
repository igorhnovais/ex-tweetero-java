package com.tweetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {

    @NotBlank(message = "Field not is empty")
    @Size(max= 280, message = "maximum size is 280 caracters")
    private String text;

    @NotNull(message = "Field not is empty")
    private String username;
    
}
