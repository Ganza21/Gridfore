package model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Андрей on 15.10.2017.
 */
@Getter
@Builder
public class CallDetail {

    private final Integer number;
    private final Date date;
    private final Integer tranz;
    private final Integer volume;
    private final String calledNum;
    private final BigDecimal charge;

    public CallDetail(Integer number, Date date, Integer tranz, Integer volume, String calledNum, BigDecimal charge) {
        this.number = number;
        this.date = date;
        this.tranz = tranz;
        this.volume = volume;
        this.calledNum = calledNum;
        this.charge = charge;
    }

}
