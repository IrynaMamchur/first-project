package com.daniil1380.firstproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    private final List<Person> people;

    public PersonController() {
        people = new ArrayList<>();
        people.add(new Person(UUID.randomUUID(), "Даниил"));
        people.add(new Person(UUID.randomUUID(), "Андрей"));
        people.add(new Person(UUID.randomUUID(), "Ирина"));
        people.add(new Person(UUID.randomUUID(), "Лариса"));
        people.add(new Person(UUID.randomUUID(), "Виктория"));
        people.add(new Person(UUID.randomUUID(), "Александр"));
        people.add(new Person(UUID.randomUUID(), "Олександр"));
        people.add(new Person(UUID.randomUUID(), "Андрей"));
    }

    @GetMapping(value = "/person")
    public List<Person> getPerson() {
        return people;
    }

    @GetMapping(value = "/person/{id}")
    public Person getPersonFromId(@PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        return people.get(idNumber);
    }

    @PostMapping(value = "/person")
    public Person addPerson(@RequestBody Person person) {
        people.add(person);
        return person;
    }

//Post на путь - "/allPerson"
    //Принимает в теле запроса одного Person
    //он создает не 1, а 10 таких человек и добавляет их всех в список
    //*Метод возвращает всех этих 10ых людей (список из них)

    @PostMapping(value = "/allPerson")
    public List <Person> addAllPerson(@RequestBody Person person) {
        List<Person> list= new ArrayList<>();
        for(int i=1; i<=10; i++){
        list.add(person);
        }
        people.addAll(list);
        return list;
    }

    @PutMapping(value = "/person/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable String id){
        int idNumber = Integer.parseInt(id);
        people.set(idNumber, person);
    }

    //@RequestBody (чаще всего в post запросах, когда передаем большой тяжелый объект)
    //@PathVariable (переменная пути, если видим {}
    //@RequestPalarm (параметр запроса, чаще всего очень простое значение, выбираем, если не 1 и не 2


    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable String id){
        int idNumber = Integer.parseInt(id);
        people.remove(idNumber);

    }

//    @GetMapping(value = "/hello")
//    public String hello() {
//        return "Привет мир";
//    }
//
//    @GetMapping(value = "/hello/{a}")
//    public String helloWorld(@PathVariable String a) {
//        return "Привет мир " + a;
//    }
//
//    @GetMapping(value = "/sum")
//    public String sum(@RequestParam String first, @RequestParam String second) {
//        return first + second;
//    }




//    private final List<Person> people;
////            new Person(UUID.randomUUID(),"Даниил"),
////            new Person(UUID.randomUUID(),"Андрей"),
////            new Person(UUID.randomUUID(),"Ирина"),
////            new Person(UUID.randomUUID(),"Лариса"),
////            new Person(UUID.randomUUID(),"Виктория"),
////            new Person(UUID.randomUUID(),"Александр"),
////            new Person(UUID.randomUUID(),"Олександр"),
////            new Person(UUID.randomUUID(),"Андрей")
////            );
//
//    public PersonController() {
//     people = new ArrayList<>();
//     people.add(new Person(UUID.randomUUID(),"Даниил"))
//
//
//    }
//
////    @GetMapping(value= "/person")
////    //@RequestMapping(value= "/person", method = RequestMethod.GET)
//////    public  Person getPerson(){
//////        return new Person(UUID.randomUUID(), "Daniil");
////    public List<Person> getPerson(){
////        List<Person> list = new ArrayList<>();
////        list.add(new Person(UUID.randomUUID(), "Даниил"));
////        list.add(new Person(UUID.randomUUID(), "Андрей"));
////        list.add(new Person(UUID.randomUUID(), "Ирина"));
////        list.add(new Person(UUID.randomUUID(), "Лариса"));
////        list.add(new Person(UUID.randomUUID(), "Виктория"));
////        list.add(new Person(UUID.randomUUID(), "Александр"));
////        list.add(new Person(UUID.randomUUID(), "Олександр"));
////        list.add(new Person(UUID.randomUUID(), "Андрей"));
////        return list;
////    }
//
//    @GetMapping(value = "/person")
//        public List<Person> getPerson(){
//            return people;
//        }
//
//
//
//
//    @GetMapping(value = "/person/{id}")
//    public Person getPersonFromID(@PathVariable String id){
//i      int idNumber
////            List<Person> list = new ArrayList<>();
////            list.add(new Person(UUID.randomUUID(), "Даниил"));
////            list.add(new Person(UUID.randomUUID(), "Андрей"));
////            list.add(new Person(UUID.randomUUID(), "Ирина"));
////            list.add(new Person(UUID.randomUUID(), "Лариса"));
////            list.add(new Person(UUID.randomUUID(), "Виктория"));
////            list.add(new Person(UUID.randomUUID(), "Александр"));
////            list.add(new Person(UUID.randomUUID(), "Олександр"));
////            list.add(new Person(UUID.randomUUID(), "Андрей"));
////
////            int idNumber = Integer.parseInt(id);
////            return list.get(idNumber);
//
//    }
//
//    @GetMapping(value = "/hello")
//    public String hello(){
//        return "Привет, мир!";
//    }
//
//
//    @GetMapping(value = "/hello/{a}")
//    public String helloWorld(@PathVariable String a){
//        return "Привет, мир!" +a;
//    }
//
//    @GetMapping(value = "/sum")
//    public String sum(@PathVariable String first, @RequestParam String second){
//        return first+second;
//    }
//
//
//    @PostMapping
//    public Person addPerson(@RequestBody Person person){
//        people.add(person);
//        return person:
//    }




}
