package com.znagui.ProgressSoftApi.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String entity,String id) {
        super(String.format("%s avec ID : %s existe deja. Merci!",entity,id));
    }
}
