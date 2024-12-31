package com.eazybytes.account.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String Resource,String field, String FieldValue) {
        super(String.format("%s not found with %s : '%s'",Resource,field,FieldValue));
    }
}
