package ru.web.repository;

import org.springframework.stereotype.Controller;
import ru.web.model.Contact;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ContactRepo {

    private HashMap<Integer, Contact> repo;
    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    public ContactRepo(){
        HashMap<Integer, Contact> contactList = new HashMap<>();
        contactList.put(AUTO_ID.getAndIncrement(), Contact.builder()
                .id(1)
                .name("Yana")
                .surname("Zelen")
                .email("yana@mail")
                .phone("909609")
                .build());
        contactList.put(AUTO_ID.getAndIncrement(), Contact.builder()
                .id(2)
                .name("Artem")
                .surname("Hud")
                .email("artem@mail")
                .phone("609906")
                .build());
        this.repo= contactList;
    }
    public Contact getContactById(Integer id) {
        return repo.get(id);
    }

    public Collection<Contact> getAllContacts() {
        return repo.values();
    }

    public void saveContact(Contact contact) {
        contact.setId(AUTO_ID.getAndIncrement());
        repo.put((contact.getId()), contact);
    }

    public void edit(Contact contact) {
        repo.put(contact.getId(), contact);
    }

    public void deleteContact(Integer id) {
        repo.remove(id);
    }

}
