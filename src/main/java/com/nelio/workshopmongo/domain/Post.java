package com.nelio.workshopmongo.domain;

import com.nelio.workshopmongo.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Document
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;

}
