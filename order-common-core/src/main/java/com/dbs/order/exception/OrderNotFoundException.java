package com.dbs.order.exception;

public class OrderNotFoundException extends RuntimeException{
    /**
     * 
     */
    private static final long serialVersionUID = 1762079797603836066L;
    private String msg;

    public OrderNotFoundException(){
        super();
    }

    public OrderNotFoundException(String message, Throwable cause){
        super(message, cause);
        this.msg = message;
    }

    public OrderNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
