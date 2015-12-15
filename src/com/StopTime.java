package com;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by doctli on 2015/11/29.
 */
public class StopTime {
    private int h=0;
    private int m=0;
    private int s=0;
    private Date start=null;
    private Date end=null;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    public StopTime(){

    }
    public void setStart(Date start){
        this.start=start;
    }
    public void counttime(Date end){
        this.end=end;
        long howmuch=this.end.getTime()-start.getTime();
        h=(int)(howmuch/1000/60/60);
        howmuch=howmuch-h*60*60*1000;
        m=(int)(howmuch/1000/60);
        howmuch=howmuch-m*60*1000;
        s=(int)(howmuch/1000);
    }
    public String getTimes(){
        String times=this.h+"小时"+this.m+"分"+this.s+"秒";
        return times;
    }
    public String getStart(){
        return df.format(start);
    }
    public String getEnd(){
        return df.format(end);
    }
}
