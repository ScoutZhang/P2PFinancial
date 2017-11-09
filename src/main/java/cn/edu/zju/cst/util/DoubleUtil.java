package cn.edu.zju.cst.util;

import java.text.DecimalFormat;

/**
 * Created by DEAN on 2017/11/9.
 */
public class DoubleUtil {
    public static DecimalFormat df4 = new DecimalFormat("#.0000");
    public static DecimalFormat df2 = new DecimalFormat("#.00");

    //保留浮点数4位小数点
    public static double dealWithPoint4(double num){
        return Double.parseDouble(df4.format(num));
    }

    //保留浮点数2位小数点
    public static double dealWithPoint2(double num){
        return Double.parseDouble(df2.format(num));
    }
}
