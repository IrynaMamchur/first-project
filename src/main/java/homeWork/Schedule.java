package homeWork;

import java.util.UUID;

public class Schedule {
    //Создать для него 4 endpoint:
    //get /schedule - получить расписание
    //post / schedule - добавить в расписание занятие
    //delete /schedule/{id} - удалить урок с номером id
    //put /schedule/{id} - обновить урок

    private UUID uuid;
    private String name;

    public Schedule(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
