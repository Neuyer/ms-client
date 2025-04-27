package com.fiap.client.core.entity;

import java.time.LocalDate;
import java.util.List;

public class Client {
    private String _id;
    private String name;
    private LocalDate birthDate;
    private CpfDocument document;
    private List<Address> addresses;

    public Client(String name, LocalDate birthDate, String document, List<Address> addresses) {
        setName(name);
        setBirthDate(birthDate);
        setDocument(document);
        setAddresses(addresses);
    }

    public Client(String _id, String name, LocalDate birthDate, String document, List<Address> addresses) {
        set_id(_id);
        setName(name);
        setBirthDate(birthDate);
        setDocument(document);
        setAddresses(addresses);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public CpfDocument getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = new CpfDocument(document);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
