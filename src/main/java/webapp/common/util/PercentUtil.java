package webapp.common.util;

import java.text.NumberFormat;

/**
 * @author ConDey
 * @version $$package: com.eazytec.eworkcore.common.util, v 0.1 2017/12/18 下午7:50 ConDey Exp $$
 */
public class PercentUtil {

    public static String getPercent(double y, double z) {
        String baifenbi = "";// 接受百分比的值
        double baiy = y * 1.0;
        double baiz = z * 1.0;
        double fen = baiy / baiz;
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        //DecimalFormat df1 = new DecimalFormat("##.0%"); // ##.0%
        baifenbi = nf.format(fen);
        //baifenbi = df1.format(fen);
        return baifenbi;
    }


    public static void main(String[] args) {

        System.out.println(getPercent(2, 4));

    }
}
