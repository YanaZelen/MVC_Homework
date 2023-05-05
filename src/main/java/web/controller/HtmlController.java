package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Contact;
import web.repository.ContactRepo;

import java.util.HashMap;

/*
Задание на разработку приложения:
 Ваша задача - разработать приложение для управления списком контактов.
 Приложение должно представлять собой web-приложение на базе Spring MVC, состоящее из нескольких страниц.

Главная страница (index.jsp):
На главной странице должна быть форма для ввода новых контактов (имя, фамилия, email, телефон).
Приложение должно сохранять данные контактов в ArrayList (это сделано, чтоб не использовать базу данных в этом задании.
Просто создаём private ArrayList<Contact>) и выводить их в виде списка на странице.
Страница должна быть доступна по адресу "/".

Страница просмотра списка контактов (contacts.jsp):
На этой странице должен выводиться список всех добавленных контактов.
Каждый контакт должен содержать имя, фамилию, email и телефон. Страница должна содержать ссылки для редактирования и удаления контактов.
Страница должна быть доступна по адресу "/contacts".

Страница редактирования контакта (edit.jsp):
На этой странице должна быть форма для редактирования контакта (имя, фамилия, email, телефон).
Страница должна предоставлять возможность сохранить изменения или отменить их.
Страница должна быть доступна по адресу "/edit/{id}", где id - идентификатор редактируемого контакта.

Каждая страница должна использовать JSTL для вывода переменных и списков.
 */

@Controller
public class HtmlController {

  private final ContactRepo contactRepo;

  public HtmlController(ContactRepo carRepo) {
    this.contactRepo = carRepo;
  }

  @RequestMapping(value = "/")
  public String handler(Model model) {
    return "/WEB-INF/index.jsp";
  }

  @RequestMapping("/contacts")
  public String contactService(Model model) {
    model.addAttribute(contactRepo.getAllContact());
    return "contacts";
  }
/*

  @RequestMapping(value = "/contact", method = RequestMethod.POST)
  public String saveCar(Contact contact, Model model) {
    HashMap<Long, Contact> repo;
    System.out.println(contact);
    contactRepo.saveContact(contact);
    model.addAttribute("newContact", contact);
    model.addAttribute("contactList", contactRepo.getAllContact());
    return "edit";
  }

  @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
  public String deleteContact(@PathVariable("id") Long id, Model model) {
    contactRepo.deleteContact(id);
    model.addAttribute(contactRepo.getAllContact());
    return "/WEB-INF/index.jsp";
  }
*/
}