package com.dbs.order.exception;

public class ItemNotFoundException extends RuntimeException{
    /**
     * 
     */
    private static final long serialVersionUID = 1762079797603836066L;
    private String msg;

    public ItemNotFoundException(){
        super();
    }

    public ItemNotFoundException(String message, Throwable cause){
        super(message, cause);
        this.msg = message;
    }

    public ItemNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
