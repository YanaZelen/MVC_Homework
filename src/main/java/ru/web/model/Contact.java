package ru.web.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contact {
  Integer id;
  String name;
  String surname;
  String email;
  String phone;
}