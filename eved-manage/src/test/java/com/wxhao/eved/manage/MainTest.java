package com.wxhao.eved.manage;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wxhao
 * @date 2018/12/30
 */
public class MainTest {

    private final static String YYYY_MM_DD = "yyyy-MM-dd";

    public static void main(String[] args) throws ParseException {
        String s = "yyyy-MM-dd";
        Date updateToday = new DateTime(FastDateFormat.getInstance(YYYY_MM_DD).format(new SimpleDateFormat(s).parse("2018-12-31"))).toDate();

        DateTime today = new DateTime(FastDateFormat.getInstance(YYYY_MM_DD).format(updateToday));

        Date refundDate = new DateTime(FastDateFormat.getInstance(YYYY_MM_DD).format(new SimpleDateFormat(s).parse("2018-12-24"))).toDate();
        DateTime refundDateTime = new DateTime(refundDate);
        int days = Days.daysBetween(refundDateTime, today).getDays();
        System.out.println(days);
    }


}
