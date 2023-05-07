package web.repository;

import org.springframework.stereotype.Controller;
import web.model.Contact;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ContactRepo {

    private HashMap<Integer, Contact> repo;
    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    public ContactRepo(){
        HashMap<Integer, Contact> contactMap = new HashMap<>();
        contactMap.put(AUTO_ID.getAndIncrement(), Contact.builder()
                .id(1L)
                .name("Yana")
                .surname("Zelen")
                .email("yana@mail")
                .phone("909609")
                .build());
        contactMap.put(AUTO_ID.getAndIncrement(), Contact.builder()
                .id(2L)
                .name("Artem")
                .surname("Hud")
                .email("artem@mail")
                .phone("609906")
                .build());
        this.repo= contactMap;
    }
    public Contact getContactById(Integer id) {
        return repo.get(id);
    }

    public Collection<Contact> getAllContacts() {
        return repo.values();
    }

}
