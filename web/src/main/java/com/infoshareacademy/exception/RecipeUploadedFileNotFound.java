package com.infoshareacademy.exception;

public class RecipeUploadedFileNotFound extends Exception {

    public RecipeUploadedFileNotFound() {
    }

    public RecipeUploadedFileNotFound(String message){
        super(message);
    }
}
