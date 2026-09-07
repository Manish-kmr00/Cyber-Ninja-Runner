package io.bidmachine.iab.bridge;

import android.text.TextUtils;
import com.json.sdk.controller.f;
import io.bidmachine.iab.mraid.MraidLog;
import io.bidmachine.iab.mraid.MraidUtils;
import io.bidmachine.iab.mraid.MraidWebView;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class JsBridgeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f12183a = new CopyOnWriteArrayList();

    private static JsBridge a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (JsBridge jsBridge : f12183a) {
            if (jsBridge.isHandled(str)) {
                return jsBridge;
            }
        }
        return null;
    }

    public static boolean addBridge(JsBridge bridge) {
        List list = f12183a;
        return !list.contains(bridge) && list.add(bridge);
    }

    public static void handleJsCommand(MraidWebView webView, String commandUrl) {
        Map<String, String> commandUrl2;
        MraidLog.d("JsBridgeHandler", "handleJsCommand - %s", commandUrl);
        try {
            JsBridge jsBridgeA = a(commandUrl);
            if (jsBridgeA == null || (commandUrl2 = MraidUtils.parseCommandUrl(commandUrl, jsBridgeA.getJsValidator())) == null) {
                return;
            }
            String str = commandUrl2.get(f.b.COMMAND);
            if (str == null) {
                MraidLog.w("JsBridgeHandler", "handleJsCommand not found", new Object[0]);
            } else {
                jsBridgeA.runJsCommand(webView, str, commandUrl2);
            }
        } catch (Throwable th) {
            MraidLog.e("JsBridgeHandler", th);
        }
    }

    public static boolean isHandled(String commandUrl) {
        return a(commandUrl) != null;
    }

    public static String obtainJs() {
        StringBuilder sb = new StringBuilder();
        for (JsBridge jsBridge : f12183a) {
            sb.append("<script type='application/javascript'>");
            sb.append(jsBridge.getJs());
            sb.append("</script>");
        }
        return sb.toString();
    }

    public static boolean removeBridge(JsBridge bridge) {
        List list = f12183a;
        return list.contains(bridge) && list.remove(bridge);
    }
}
