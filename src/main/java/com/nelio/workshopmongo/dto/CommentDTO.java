package com.nelio.workshopmongo.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private LocalDate date;
    private AuthorDTO author;


}
