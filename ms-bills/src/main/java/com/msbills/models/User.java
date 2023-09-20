package com.msbills.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    //esta entidad la modelan ustedes de acuerdo a los atributos que vayan a necesitar
    String id;
    String userName;
    String email;
    String lastName;
    List<Bill> bills;


}
