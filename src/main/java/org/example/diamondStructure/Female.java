package org.example.diamondStructure;

public interface Female extends Human{
    public static String SEX = "female";

    @Override
    default String getSex(){
        return Female.SEX;
    };
}
