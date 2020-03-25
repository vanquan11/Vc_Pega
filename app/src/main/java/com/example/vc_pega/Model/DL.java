package com.example.vc_pega.Model;

import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DL {
    public static String pastDate(long datetime){
        long millis = System.currentTimeMillis();
        String pastDate = String.valueOf(DateUtils.getRelativeTimeSpanString(datetime*1000, millis, 0L, DateUtils.FORMAT_ABBREV_ALL));
        return " " + pastDate ;
    }

    public static String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyy");
        String date = dateFormat.format(new Date());
        return date;
    }
}
