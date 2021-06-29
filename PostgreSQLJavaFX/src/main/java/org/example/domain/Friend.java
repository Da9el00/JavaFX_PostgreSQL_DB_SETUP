package org.example.domain;

public class Friend {
    private Integer id;
    private String name;
    private int phone;

    public Friend(Integer id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name + " with ID: " + id + " got phone number: " + phone;
    }
}
