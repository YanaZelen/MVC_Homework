package ru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.web.model.Contact;
import ru.web.repository.ContactRepo;

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
    public HtmlController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }


    @RequestMapping(value = "/contacts")
    public String carService(Model model) {
        model.addAttribute("contactList", contactRepo.getAllContacts());
        return "contacts";
    }

    @RequestMapping(value = "/contacts/save", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        System.out.println(contact);
        contactRepo.saveContact(contact);
        model.addAttribute("contactList", contactRepo.getAllContacts());
        return "contacts";
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") Integer id, Model model) {
        contactRepo.deleteContact(id);
        model.addAttribute(contactRepo.getAllContacts());
        return "contacts";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        Contact contact = contactRepo.getContactById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("editContact", contact);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editContact(@ModelAttribute("editContact") Contact contact) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/contacts");
        contactRepo.edit(contact);
        return modelAndView;
    }

}