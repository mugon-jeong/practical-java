package org.example.diamondStructure;

public interface Male extends Human{
    public static String SEX = "Male";

    @Override
    default String getSex(){
        return Male.SEX;
    };
}
