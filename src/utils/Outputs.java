package utils;

import entities.AttrItems;
import org.apache.http.util.TextUtils;

public class Outputs {

    /**
     * 获取输出数据
     *
     * @param items 数据集
     */
    public static String getOutPutString(AttrItems[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if (!TextUtils.isEmpty(items[i].value)) {
                sb.append("\n\t\t").append(items[i].name).append("=").append("\"").append(items[i].value).append("\"");
            }
        }
        return sb.toString();
    }
}
