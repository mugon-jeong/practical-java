package org.example.functional;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NewSearchingTravel travelSearch = new NewSearchingTravel();

        List<TravelInfo> searchTravel = travelSearch.searchTravelInfo(new TravelInfoFilter() {
            @Override
            public boolean isMatched(TravelInfo travelInfo) {
                if (travelInfo.getCountry().equals("vietnam")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        for(TravelInfo travelInfo: searchTravel){
            System.out.println(travelInfo);
        }

        // 람다 표현식으로 변환
        List<TravelInfo> searchTravelWithCity = travelSearch.searchTravelInfo(travelInfo -> travelInfo.getCountry().equals("hanoi"));

        for(TravelInfo travelInfo: searchTravelWithCity){
            System.out.println(travelInfo);
        }

        // 조건식을 메서드 참조 형태로 변경
        List<TravelInfo> travelInfos = travelSearch.searchTravelInfo(FunctionSearchingTravel::isVietname);
        for(TravelInfo travelInfo: travelInfos){
            System.out.println(travelInfo);
        }
    }

}
