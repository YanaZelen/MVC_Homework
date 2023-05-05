package web.repository;

import org.springframework.stereotype.Component;
import web.model.Contact;

import java.util.Collection;
import java.util.HashMap;

@Component
public class ContactRepo {
  private final HashMap<Long, Contact> repo;

  public ContactRepo() {
    HashMap<Long, Contact> map = new HashMap<>();
    map.put(1L, Contact.builder()
            .id(1L)
            .name("Yana")
            .surname("Zelen")
            .email("yana@mail")
            .phone("909609")
            .build());
    map.put(2L, Contact.builder()
            .id(2L)
            .name("Artem")
            .surname("Hud")
            .email("artem@mail")
            .phone("609906")
            .build());
    this.repo = map;
  }

  public Contact getContactById(Long id) {
    return repo.get(id);
  }

  public Collection<Contact> getAllContact() {
    return repo.values();
  }

  public void saveContact(Contact contact) {
    repo.put(contact.getId(), contact);
  }

  public void deleteContact(Long id) {
    repo.remove(id);
  }
}
