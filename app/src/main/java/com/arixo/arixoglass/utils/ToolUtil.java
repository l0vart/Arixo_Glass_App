package com.arixo.arixoglass.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.text.format.Time;

import java.util.Date;

/**
 * Created by lovart on 2019/2/1
 */
public class ToolUtil {

    public static String getTime() {
        long current = System.currentTimeMillis();
        String time;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            time = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(current));
        } else {
            Time t = new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
            t.setToNow(); // 取得系统时间。
            int year = t.year;
            int month = t.month + 1;
            int day = t.monthDay;
            int hour = t.hour; // 0-23
            int minute = t.minute;
            int second = t.second;
            time = year + "-" + month + "-" + day + "-" + hour + ":" + minute + ":" + second;
        }
        return time;
    }

    /**
     * 获取版本号名称
     *
     * @param context 上下文
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

}
