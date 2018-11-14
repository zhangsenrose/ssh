package com.zhang.test;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.junit.jupiter.api.Test;

import javax.ejb.Local;
import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Create By ZhangSenWei on 2018/8/29
 **/
public class TestDate {

    @Test
    public void testDate01() throws ParseException {
        LocalDate start = new LocalDate("2018-01-31");
        System.out.println("===" + start.plusMonths(1));
        DateTime dateTime = new DateTime("2018-01-31");
        System.out.println("datetime===" + dateTime.plusMonths(1));
        double a = 3.0;
        double b = 10.0;
        double x = a/b;
        System.out.println(x);
    }





    @Test
    public void findCalcDateMethod() throws ParseException {
        String startDateStr = "2018-01-15 00:00:00";
        String endDateStr = "2018-04-02 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(startDateStr);
        Date endDate = sdf.parse(endDateStr);
        Calendar before = Calendar.getInstance();
        Calendar after = Calendar.getInstance();
        before.setTime(startDate);
        after.setTime(endDate);
        int result = after.get(Calendar.MONTH)  - before.get(Calendar.MONTH);
        System.out.println(result);
        int month = (after.get(Calendar.YEAR) - before.get(Calendar.YEAR))*12;
        System.out.println(Math.abs(month + result));

    }

    @Test
    public void dayCompare() throws ParseException {
        LocalDate startDate = new LocalDate("2018-10-08");
        LocalDate endDate = new LocalDate("2019-10-09");
        int years = 0;
        while (startDate.compareTo(endDate) < 0){
            int y = startDate.getYear();
            int m = startDate.getMonthOfYear();
            int n = startDate.getDayOfMonth();
            y++;
            startDate = new LocalDate(y,m,n);
            years++;
            if (startDate.compareTo(endDate) == 0){
                System.out.println(years);
            }else if (startDate.compareTo(endDate) >0){
                System.out.println(0);
            }
        }

    }


    @Test
    public void jodTimeAgain() throws ParseException {
        LocalDate start = new LocalDate("2018-05-31");
        LocalDate end = new LocalDate("2018-06-29");
        //start：2018-05-01  end：2018-05-01
        int months = 0;
        while (end.compareTo(start) > 0){
            LocalDate ls = start.plusMonths(1);

            LocalDate le = null;
            if (ls.getDayOfMonth() == start.getDayOfMonth()){
                le = ls.minusDays(1);
            }else {
                //小于
                le = ls;
            }
            //如果下月当前日期大于结束日期，则跳出循环
            if (le.compareTo(end) >0){
                break;
            }

            start = le.plusDays(1);
            System.out.println("SSSS" + start);
            months++;
        }
        System.out.println("整月" + months);
        int exteDays = 0;
        if (end.compareTo(start) >= 0){
            //如果start合end在同一个月
            if (end.getMonthOfYear() == start.getMonthOfYear()){
                int days = end.getDayOfMonth()  - start.getDayOfMonth() +1;
                int baseDays = Days.daysBetween(start, start.plusMonths(1)).getDays();
                System.out.println("baaeDays =" + baseDays);
                exteDays = days;
                //int dayOfMonth = start.dayOfMonth().withMaximumValue().getDayOfMonth();
                System.out.println("同月["+days+"]/["+baseDays+"]");
            }else {

                //分子
                int days = Days.daysBetween(start, end.plusDays(1)).getDays();

                //分母
                LocalDate le = start.plusMonths(1);
                if (le.getDayOfMonth() == start.getDayOfMonth()){
                    le = le.minusDays(1);
                }

                int baseDays = Days.daysBetween(start, le.plusDays(1)).getDays();

                System.out.println("分子：" + days);
                System.out.println("分母：" + baseDays);

                /*//不在同于一个月
                int sDayOfMonth = start.dayOfMonth().withMaximumValue().getDayOfMonth();
                int sDyas = sDayOfMonth - start.getDayOfMonth() + 1;
                System.out.println("同月["+ sDyas + "]/["+ sDayOfMonth+"]");
                int eDayOfMonth = end.dayOfMonth().withMaximumValue().getDayOfMonth();
                int eDays = end.getDayOfMonth();
                System.out.println("不同月start:["+eDays+"]/["+eDayOfMonth+"]");
                exteDays = eDays + sDyas;
                System.out.println(exteDays);
                int baseDays = Days.daysBetween(start, start.plusMonths(1)).getDays();
                System.out.println(baseDays);*/
            }

        }
        System.out.println("总共的月数==" + months);
        System.out.println("多于的天数==" + exteDays);



        BigDecimal bigDecimal = new BigDecimal(String.valueOf(BigDecimal.ZERO));
        if (bigDecimal.compareTo(new BigDecimal(String.valueOf(BigDecimal.ZERO))) ==0){
            System.out.println("111111");
        }else{
            System.out.println("22222");
        }

    }








    @Test
    public void testThread() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2018-09-30");
        Date date2 = sdf.parse("2018-10-01");
        Date date3 = sdf.parse("2018-09-12");
        Date date4 = sdf.parse("2018-10-11");
        List<Date> list = Lists.newArrayList();
        list.add(date1);
        list.add(date2);
        list.add(date3);
        list.add(date4);

        Date maxDate = list.get(0);
        for (int i=0; i< list.size(); i++){
            if (list.get(i).compareTo(maxDate) == 1){
                maxDate = list.get(i);
            }
        }
        System.out.println(sdf.format(maxDate));
    }


    @Test
    public void testIdleDate(){
        LocalDate idleDateStart = new LocalDate("2018-10-01");
        LocalDate idleDateEnd = new LocalDate("2018-10-10");

        LocalDate startDate1 = new LocalDate("2018-09-20");
        LocalDate startDate2 = new LocalDate("2018-09-25");
        //看是否一个时间段包含与另一个时间段






    }





}
