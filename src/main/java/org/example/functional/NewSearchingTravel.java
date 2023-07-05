package org.example.functional;

import java.util.ArrayList;
import java.util.List;

public class NewSearchingTravel {
    private List<TravelInfo> travelInfoList = new ArrayList<>();

    // 외부에서 전달된 조건으로 검색
    public List<TravelInfo> searchTravelInfo(TravelInfoFilter searchCondition) {
        List<TravelInfo> resultValue = new ArrayList<>();

        for(TravelInfo info : travelInfoList){
            if(searchCondition.isMatched(info)){
                resultValue.add(info);
            }
        }

        return resultValue;
    }

}
