package com.sandycode;

public class SoftwareEngineerNotFoundException extends RuntimeException
{
    public SoftwareEngineerNotFoundException(Integer id)
    {
        super("Software engineer with ID " + id + " not found");
    }
}
