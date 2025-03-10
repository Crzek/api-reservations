package com.cruzerick.api_reservations.exeptions;

public class MsgExeption extends RuntimeException{
    private String description;
    public MsgExeption(String message){super(message);}

    // Methods
    public String getDescription() {return  description;}
    public void setDescription(String description){
        this.description = description;
    }
}
