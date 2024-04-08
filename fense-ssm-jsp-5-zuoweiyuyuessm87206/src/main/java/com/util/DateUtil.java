package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 日期时间工具类
 */
public class DateUtil {
    /**
     * 计算结束时间和开始时间的小时差，有小数时向上取整,比如1.5、1.1、1.9向上取整都为2
     * @param endTime 结束时间
     * @param startTime 开始时间
     * @return
     */
    public static Integer getTimeDifferenceCeil(String endTime,String startTime){
        Double difference = Double.valueOf (getTimeDifference(endTime,startTime)/1000)%86400/3600;
        difference=Math.ceil(difference);
        return difference.intValue();

    }

    /**
     * 计算结束时间和开始时间的小时差，有小数时向下取整,比如1.5、1.1、1.9向下取整都为1
     * @param endTime 结束时间
     * @param startTime 开始时间
     * @return
     */
    public static Integer getTimeDifferenceFloor(String endTime,String startTime){
        Double difference = Double.valueOf (getTimeDifference(endTime,startTime)/1000)%86400/3600;
        difference=Math.floor(difference);
        return difference.intValue();

    }

    /**
     * 计算两个时间的时间差(毫秒)
     * @param endTime 结束时间
     * @param startTime 开始时间
     * @return
     */
    private static long getTimeDifference(String endTime,String startTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date end_Time;
        Date start_Time;
        try{
            //增加强判断条件
            sdf.setLenient(false);
            end_Time =sdf.parse(endTime);
            System.out.println(end_Time);
            start_Time =sdf.parse(startTime);
            System.out.println(start_Time);
        }catch(Exception e){
            return -1;
        }
        if(start_Time.getTime()>end_Time.getTime()){
            Date tempTime=end_Time;
            end_Time=start_Time;
            start_Time=tempTime;
        }
        return end_Time.getTime()-start_Time.getTime();
    }

    public static void main(String[] args){

        String endTime="2023-05-01 10:13:59";
        String startTime="2023-05-01 15:00:58";

        System.out.println(getTimeDifferenceCeil(endTime,startTime));

        System.out.println(getTimeDifferenceFloor(endTime,startTime));

    }
}
