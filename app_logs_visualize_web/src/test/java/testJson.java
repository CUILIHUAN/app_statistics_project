import com.cuilihuan.applogs.visualize.domain.JsonBean;
import com.cuilihuan.applogs.visualize.util.DayFormat;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.List;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/21 10:36
 * @Description:
 */
public class testJson {
    public static void main(String[] args) {
        String a = "{\"appErrorLogs\":[{\"appChannel\":\"youmeng2\",\"appId\":\"sdk34734\",\"appPlatform\":\"ios\",\"appVersion\":\"3.2.1\",\"createdAtMs\":1555814053646,\"deviceId\":\"device2257\",\"deviceStyle\":\"红米手机1s\",\"errorBrief\":\"at cn.lift.appIn.control.CommandUtil.getInfo(CommandUtil.java:67)\",\"errorDetail\":\"java.lang.NullPointerException\\\\n    at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\\\\n at cn.lift.dfdf.web.AbstractBaseController.validInbound\",\"osType\":\"8.3\",\"tenantId\":\"cake\"}],\"appEventLogs\":[{\"appChannel\":\"youmeng2\",\"appId\":\"sdk34734\",\"appPlatform\":\"ios\",\"appVersion\":\"3.2.1\",\"createdAtMs\":1555814053645,\"deviceId\":\"device2285\",\"deviceStyle\":\"iPhone 6 Plus\",\"eventDurationSecs\":45,\"eventId\":\"popMenu\",\"osType\":\"8.3\",\"paramKeyValueMap\":{\"testparam3key\":\"testparam3value\",\"testparam4key\":\"testparam4value\"},\"tenantId\":\"cake\"}],\"appPageLogs\":[{\"appChannel\":\"youmeng1\",\"appId\":\"sdk34734\",\"appPlatform\":\"android\",\"appVersion\":\"3.2.2\",\"createdAtMs\":1555814053644,\"deviceId\":\"device2266\",\"deviceStyle\":\"红米手机1s\",\"nextPage\":\"list.html\",\"osType\":\"7.1.1\",\"pageId\":\"main.html\",\"stayDurationSecs\":78,\"tenantId\":\"cake\",\"visitIndex\":1}],\"appStartupLogs\":[{\"appChannel\":\"youmeng2\",\"appId\":\"sdk34734\",\"appPlatform\":\"android\",\"appVersion\":\"3.2.2\",\"brand\":\"华为\",\"carrier\":\"EE\",\"country\":\"America\",\"createdAtMs\":1555814053644,\"deviceId\":\"device2295\",\"deviceStyle\":\"iPhone 6\",\"network\":\"WiFi\",\"osType\":\"7.1.1\",\"province\":\"jiangxi\",\"screenSize\":\"1136*640\",\"tenantId\":\"cake\"}],\"appUsageLogs\":[{\"appChannel\":\"youmeng1\",\"appId\":\"sdk34734\",\"appPlatform\":\"android\",\"appVersion\":\"3.2.2\",\"createdAtMs\":1555814053645,\"deviceId\":\"device2222\",\"deviceStyle\":\"iPhone 6 Plus\",\"osType\":\"8.3\",\"singleUseDurationSecs\":72,\"tenantId\":\"cake\"}]}";
        Gson gs = new Gson();
        JsonBean testJson = gs.fromJson(a, JsonBean.class);
        System.out.println(testJson);
    }

    @Test
    public void testTime() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void analyTIme() {
        String time = "2019/04/24 - 2019/05/22".replaceAll("-","/");
        String startTime = time.split(" / ")[0];
        String endTime = time.split(" / ")[1];
        List<String> perDay = DayFormat.getPerDay(startTime, endTime);
        System.out.println(perDay);
    }
}

