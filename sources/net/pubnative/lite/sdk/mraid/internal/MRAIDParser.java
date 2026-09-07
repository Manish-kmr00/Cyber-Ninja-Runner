package net.pubnative.lite.sdk.mraid.internal;

import com.json.b9;
import com.json.sdk.controller.f;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class MRAIDParser {
    private static final String TAG = "MRAIDParser";

    public Map<String, String> parseCommandUrl(String str) {
        MRAIDLog.d(TAG, "parseCommandUrl " + str);
        String strSubstring = str.substring(8);
        HashMap map = new HashMap();
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf != -1) {
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            for (String str2 : strSubstring.substring(iIndexOf + 1).split(b9.i.c)) {
                int iIndexOf2 = str2.indexOf(61);
                map.put(str2.substring(0, iIndexOf2), str2.substring(iIndexOf2 + 1));
            }
            strSubstring = strSubstring2;
        }
        if (!isValidCommand(strSubstring)) {
            MRAIDLog.w("command " + strSubstring + " is unknown");
            return null;
        }
        if (!checkParamsForCommand(strSubstring, map)) {
            MRAIDLog.w("command URL " + str + " is missing parameters");
            return null;
        }
        HashMap map2 = new HashMap();
        map2.put(f.b.g, strSubstring);
        map2.putAll(map);
        return map2;
    }

    private boolean isValidCommand(String str) {
        return Arrays.asList("close", "createCalendarEvent", "expand", "open", MraidJsMethods.PLAY_VIDEO, "resize", "setOrientationProperties", "setResizeProperties", "storePicture", MraidJsMethods.USE_CUSTOM_CLOSE).contains(str);
    }

    private boolean checkParamsForCommand(String str, Map<String, String> map) {
        str.hashCode();
        switch (str) {
            case "playVideo":
            case "open":
            case "storePicture":
                return map.containsKey("url");
            case "createCalendarEvent":
                return map.containsKey("eventJSON");
            case "setOrientationProperties":
                return map.containsKey("allowOrientationChange") && map.containsKey("forceOrientation");
            case "setResizeProperties":
                return map.containsKey("width") && map.containsKey("height") && map.containsKey("offsetX") && map.containsKey("offsetY") && map.containsKey("customClosePosition") && map.containsKey("allowOffscreen");
            case "useCustomClose":
                return map.containsKey(MraidJsMethods.USE_CUSTOM_CLOSE);
            default:
                return true;
        }
    }
}
