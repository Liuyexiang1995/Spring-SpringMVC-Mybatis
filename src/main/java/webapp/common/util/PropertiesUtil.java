package webapp.common.util;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 这个东西就比较不人性化了,为了防止有错位的产生, 切记数据里面不能存在 & 和 = ....
 *
 * @author ConDey
 * @version $$package: com.eazytec.eworkcore.common.util, v 0.1 2017/12/10 下午10:56 ConDey Exp $$
 */
public class PropertiesUtil {

    public static Map<String, String> convertToMap(String properties) {

        if (StringUtils.isBlank(properties)) {
            return new HashMap<String, String>();
        }

        Map<String, String> promap = new HashMap<String, String>();
        String[] strings = properties.split("&");

        for (int index = 0; index < strings.length; index++) {
            String[] pp = strings[index].split("=");
            if (pp.length < 2) {
                continue;
            } else {
                promap.put(pp[0], pp[1]);
            }
        }
        return promap;
    }

    public static String convertToString(Map<String, String> properties) {
        if (properties != null && properties.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Set<String> keys = properties.keySet();
            for (String key : keys) {
                stringBuffer.append(key + "=" + properties.get(key) + "&");
            }
            if (stringBuffer.length() > 0) {
                return stringBuffer.substring(0, stringBuffer.length() - 1);
            }
        }
        return "";
    }
}
