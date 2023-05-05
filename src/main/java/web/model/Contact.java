package web.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contact {
  Long id;
  String name;
  String surname;
  String email;
  String phone;
}