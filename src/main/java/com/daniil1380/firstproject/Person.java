package com.daniil1380.firstproject;

import java.util.UUID;
//POJO-КЛАСС, НЕ УПРАВЛЯЕТСЯ сПРИНГОМ
public class Person {
    private UUID uuid;
    private String name;

    public Person(UUID uuid, String name) {
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
