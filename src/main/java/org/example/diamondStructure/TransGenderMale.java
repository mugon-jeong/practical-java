package org.example.diamondStructure;

public abstract class TransGenderMale implements Human {
    public static String SEX = "female";

    @Override
    public String getSex() {
        return TransGenderMale.SEX;
    }
}
