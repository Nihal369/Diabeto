package com.amaro.diabeto;

import android.net.Uri;

public class LocalDB {


    //Local Database of the application

    private static String fullName,phoneNumber,email;
    static Uri profilePicUri;
    private static int age=0,pregnancies=0,glucoseLevel=0,insulinLevel=0,bloodPressure=0;
    private static float skinThickness=0,diabeticPedigree=0;
    private static String gender;


    public static void setFullName(String value)
    {
        fullName=value;
    }

    public static void setPhoneNumber(String value)
    {
        phoneNumber=value;
    }

    public static void setEmail(String value)
    {
        email=value;
    }

    public static void setProfilePicUri(Uri value)
    {
        profilePicUri=value;
    }

    public  static void setGender(String value)
    {
        gender=value;
    }

    public static void setAge(int value)
    {
        age=value;
    }

    public static void setPregnancies(int value)
    {
        pregnancies=value;
    }

    public static void setGlucoseLevel(int value)
    {
        glucoseLevel=value;
    }

    public static void setInsulinLevel(int value)
    {
        insulinLevel=value;
    }

    public static void setBloodPressure(int value)
    {
        bloodPressure=value;
    }

    public static void setSkinThickness(float value)
    {
        skinThickness=value;
    }

    public static void setDiabeticPedigree(float value)
    {
        diabeticPedigree=value;
    }



    public static int getAge()
    {
        return age;
    }

    public static int getPregnancies()
    {
        return pregnancies;
    }


    public static int getGlucoseLevel()
    {
        return glucoseLevel;
    }

    public static int getInsulinLevel()
    {
        return insulinLevel;
    }


    public static int getBloodPressure()
    {
        return bloodPressure;
    }


    public static float getSkinThickness()
    {
        return skinThickness;
    }


    public static float getDiabeticPedigree()
    {
        return diabeticPedigree;
    }


    public static String getGender()
    {
        return gender;
    }


    public static String getFullName()
    {
        return fullName;
    }

    public static String getPhoneNumber()
    {
        return "+91"+phoneNumber;
    }

    public static String getEmail()
    {
        return email;
    }

    public static Uri getProfilePicUri()
    {
        return  profilePicUri;
    }



}
