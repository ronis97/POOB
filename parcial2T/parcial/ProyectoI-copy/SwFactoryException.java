
/**
 * Write a description of class WhatxException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwFactoryException extends Exception
{
    public static final String PROJECT_NOT_FOUND = "El proyecto no fue encontrado";
    public static final String PROJECT_HAS_WINNER = "El proyecto ya tiene ganador";
    public SwFactoryException(String message){
        super(message);
    }
}
