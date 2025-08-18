package com.shaik.acknowledge.docker.DTO;

public record CustomerDetailsDTO(Integer id, String name, String phoneNumber, String email) {

    public CustomerDetailsDTO(Integer id, String name){
        this(id, name, null, null);
    }

    public CustomerDetailsDTO(Integer id, String name, String email){
        this(id, name, null, email);
    }

    public CustomerDetailsDTO(){
        this(null, null, null, null);
    }
}
