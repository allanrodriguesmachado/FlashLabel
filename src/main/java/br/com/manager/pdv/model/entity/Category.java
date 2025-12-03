package br.com.manager.pdv.model.entity;

public record Category(Integer id, String name) {
    public Category (String name){
        this(null, name);
    }
}
