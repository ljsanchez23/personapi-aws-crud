package com.personapi.personapi.domain.model;

public class Person {
    private String name;
    private Integer idDocument;
    private String email;

    public Person(String name, Integer idDocument, String email) {
        this.name = name;
        this.idDocument = idDocument;
        this.email = email;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
