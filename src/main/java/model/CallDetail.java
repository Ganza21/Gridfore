package model;

import lombok.Getter;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
@Getter
public class CallDetail implements Serializable{
    @QuerySqlField
    private String number;
    @QuerySqlField
    private String date;
    @QuerySqlField
    private Integer tranz;
    @QuerySqlField
    private Integer volume;
    @QuerySqlField
    private String calledNum;
    @QuerySqlField
    private BigDecimal charge;

    public CallDetail(String data) {
        List<String> listData = Arrays.asList(data.split(","));
        if (listData.size() == 6){
            number = listData.get(0);
            date = listData.get(1);
            tranz = Integer.valueOf(listData.get(2));
            volume = Integer.valueOf(listData.get(3));
            calledNum = listData.get(4);
            charge = new BigDecimal(listData.get(5));
        } else {
            System.out.println("Запись кривая");
        }
    }

}
