package org.example.diamondStructure;

public interface Human {
    public int getAge();
    public String getName();
    public String getSex();

    // default 메서드이며 Human을 리턴한다.
    default String getInfomation(){
        return "Human";
    };
}
