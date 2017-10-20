package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"number", "date", "tranz", "volume", "calledNum", "charge"})
public class CallDetail implements Serializable {
    @QuerySqlField
    private String number;
    @QuerySqlField
    private LocalDate date;
    @QuerySqlField
    private Integer tranz;
    @QuerySqlField
    private Integer volume;
    @QuerySqlField
    private String calledNum;
    @QuerySqlField
    private BigDecimal charge;
    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public CallDetail() {
    }

    /**
     * Constructor to convert a List to an object
     *
     * @param data
     */
    public CallDetail(String data) {
        List<String> listData = Arrays.asList(data.split(","));
        if (listData.size() == 6) {
            number = listData.get(0);
            date = LocalDate.parse(listData.get(1), FORMAT);
            tranz = Integer.valueOf(listData.get(2));
            volume = Integer.valueOf(listData.get(3));
            calledNum = listData.get(4);
            charge = new BigDecimal(listData.get(5));
        } else {
            System.out.println("Запись кривая");
        }
    }
}
