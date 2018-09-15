package info.lazycompiler.standaloneactivemqsimple.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Serializable {

    private String name;
    private int age;
    private String address;

}
