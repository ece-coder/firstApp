package com.example.jibong.myapplication;

import com.google.auto.value.AutoValue;

/**
 * Created by jibong on 12/12/2017.
 */

@AutoValue
public abstract class Profile {

    public static Profile create(String _id, String firstName, String lastName, String gender, String birthDate, String description, String fullName) {
        return new AutoValue_Profile(_id, firstName, lastName, gender, birthDate, description,fullName);
    }

    public abstract String _id();
    public abstract String firstName();
    public abstract String lastName();
    public abstract String gender();
    public abstract String birthDate();
    public abstract String description();
    public abstract String fullName();
}