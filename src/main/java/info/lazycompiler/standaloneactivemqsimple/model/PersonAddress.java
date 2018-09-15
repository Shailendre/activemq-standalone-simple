package info.lazycompiler.standaloneactivemqsimple.model;


import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PersonAddress implements Serializable {

    private String address;

}
