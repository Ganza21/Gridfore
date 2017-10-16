package parser;

import model.CallDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public interface ParserData {

    /**
     * Method of converting extracted data to an object
     * @param dataList
     * @return List<CallDetail> callList
     */
    static List<CallDetail> splitDataToObject(List<String> dataList){

        List<CallDetail> callList = new ArrayList<>();

            for (String line : dataList) {

                callList.add(new CallDetail(line));
            }

            return callList;
    }
}
