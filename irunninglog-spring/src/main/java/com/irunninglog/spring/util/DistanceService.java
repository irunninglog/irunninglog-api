package com.irunninglog.spring.util;

import com.irunninglog.api.Progress;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public final class DistanceService {

    public int getDistanceFloored(float distance) {
        return new BigDecimal(mileage(distance, Boolean.FALSE)).intValue();
    }

    public Progress progressWhereLowIsBad(int percentage) {
        if (percentage < 20) {
            return Progress.BAD;
        } else if (percentage < 80) {
            return Progress.OK;
        } else {
            return Progress.GOOD;
        }
    }

    public Progress progressWhereLowIsGood(int percentage) {
        if (percentage < 20) {
            return Progress.GOOD;
        } else if (percentage < 80) {
            return Progress.OK;
        } else {
            return Progress.BAD;
        }
    }

    public int percentage(float total, float done) {
        double result = done * 100.0 / total;
        return Math.min(100, BigDecimal.valueOf(result).setScale(1, BigDecimal.ROUND_HALF_UP).intValue());
    }

    public String mileage(float distance) {
        return mileage(distance, Boolean.TRUE);
    }

    public String mileage(float distance, boolean appendMileage) {
        String string = DecimalFormat.getInstance()
                .format(BigDecimal.valueOf(distance)
                        .multiply(BigDecimal.valueOf(0.000621371)).setScale(1, RoundingMode.HALF_UP));

        if (appendMileage) {
            string += " mi";
        } else {
            string = string.replace(",", "");
        }

        return string;
    }

}
