package com.daniil1380.firstproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@RestController
public class ScheduleController {

    private final List<Schedule> lessons;
// //Создать для него 4 endpoint:
//    //get /schedule - получить расписание
//    //post / schedule - добавить в расписание занятие
//    //delete /schedule/{id} - удалить урок с номером id
//    //put /schedule/{id} - обновить урок

    //  1 уровень сложности: У вас есть приложение с прошлой домашки - необходимо добавить еще два метода:
    //
    //delete /schedule/all - удалить все расписание
    //get /schedule/count - вернуть количество уроков
    public ScheduleController() {
        lessons = new ArrayList<>();
        lessons.add(new Schedule(UUID.randomUUID(), "English"));
        lessons.add(new Schedule(UUID.randomUUID(), "German"));
        lessons.add(new Schedule(UUID.randomUUID(), "Technology"));
        lessons.add(new Schedule(UUID.randomUUID(), "BD"));
        lessons.add(new Schedule(UUID.randomUUID(), "Algorithm"));
        lessons.add(new Schedule(UUID.randomUUID(), "Management"));
    }

    @GetMapping(value = "/schedule")
    public List<Schedule> getSchedule() {
        return lessons;
    }

    @GetMapping(value = "/schedule/{id}")
    public Schedule getScheduleFromId(@PathVariable String id) {
        int idNumber = Integer.parseInt(id);
        return lessons.get(idNumber);
    }

    @PostMapping(value = "/schedule")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        lessons.add(schedule);
        return schedule;
    }

    @PutMapping(value = "/schedule/{id}")
    public void updateSchedule(@RequestBody Schedule schedule, @PathVariable String id){
        int idNumber = Integer.parseInt(id);
        lessons.set(idNumber, schedule);
    }

    @DeleteMapping(value = "/schedule/{id}")
    public void deleteSchedule(@PathVariable String id){
        int idNumber = Integer.parseInt(id);
        lessons.remove(idNumber);
    }

    @DeleteMapping(value = "/allSchedule")
    public void  deleteAllSchedule() {
            lessons.clear();
    }

        @GetMapping(value = "/scheduleCount")
        public int getScheduleCount() {
            return lessons.size();
        }

    }







