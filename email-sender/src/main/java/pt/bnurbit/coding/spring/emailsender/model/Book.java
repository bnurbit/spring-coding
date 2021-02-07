package pt.bnurbit.coding.spring.emailsender.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private Integer id;
    private String name;
    private String author;
}
