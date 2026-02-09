package com.nelio.workshopmongo.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING, // 1. Transforma a data em texto (String)
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", // 2. Define o padrão ISO 8601 (padrão mundial)
            timezone = "GMT" // 3. Garante que o horário seja o de Londres (UTC/Zero)
    )
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;




}
