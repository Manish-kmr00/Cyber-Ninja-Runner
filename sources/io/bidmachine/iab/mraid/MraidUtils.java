package io.bidmachine.iab.mraid;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.json.b9;
import com.json.sdk.controller.f;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class MraidUtils {
    public static final String ARG_OPEN_PRIVACY_SHEET_DATA = "data";
    public static final String COMMAND_URL_PREFIX = "mraid://";
    public static final int DEFAULT_CLOSE_TIME_SEC = 3;
    private static String d;
    public static final long MAX_ON_SCREEN_TIME_MS = TimeUnit.SECONDS.toMillis(30);
    public static final String COMMAND_OPEN_PRIVACY_SHEET = "openPrivacySheet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f12207a = Arrays.asList("close", "expand", "open", MraidJsMethods.PLAY_VIDEO, "resize", "setOrientationProperties", "setResizeProperties", MraidJsMethods.USE_CUSTOM_CLOSE, "noFill", b9.h.r, "AdStarted", "AdStopped", "AdSkipped", "AdSkippableStateChange", "AdVideoStart", "AdVideoFirstQuartile", "AdVideoMidpoint", "AdVideoThirdQuartile", "AdVideoComplete", "AdUserClose", "AdPaused", "AdPlaying", "AdClickThru", "AdLog", "AdError", "createCalendarEvent", "storePicture", COMMAND_OPEN_PRIVACY_SHEET);
    private static final char[] b = {'\"', '\''};
    private static final MraidJsValidator c = new b();

    private static class b implements MraidJsValidator {
        private b() {
        }

        @Override // io.bidmachine.iab.mraid.MraidJsValidator
        public boolean checkParamsForCommand(String str, Map map) {
            return MraidUtils.b(str, map);
        }

        @Override // io.bidmachine.iab.mraid.MraidJsValidator
        public boolean isValidCommand(String str) {
            return MraidUtils.b(str);
        }

        @Override // io.bidmachine.iab.mraid.MraidJsValidator
        public String removePrefix(String str) {
            return str.substring(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, Map map) {
        String str2;
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "playVideo":
            case "open":
            case "storePicture":
                str2 = "url";
                break;
            case "openPrivacySheet":
                str2 = "data";
                break;
            case "createCalendarEvent":
                str2 = "eventJSON";
                break;
            case "setOrientationProperties":
                return map.containsKey("allowOrientationChange") && map.containsKey("forceOrientation");
            case "setResizeProperties":
                return map.containsKey("width") && map.containsKey("height") && map.containsKey("offsetX") && map.containsKey("offsetY") && map.containsKey("customClosePosition") && map.containsKey("allowOffscreen");
            case "useCustomClose":
                return map.containsKey(MraidJsMethods.USE_CUSTOM_CLOSE);
            default:
                return true;
        }
        return map.containsKey(str2);
    }

    public static View getRootViewFromActivity(final Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static View getRootViewFromView(final View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById != null ? viewFindViewById : rootView;
    }

    public static View getTopmostView(final Context context, final View view) {
        View rootViewFromActivity = getRootViewFromActivity(context);
        return rootViewFromActivity != null ? rootViewFromActivity : getRootViewFromView(view);
    }

    public static View obtainRootView(Context context, View view) {
        View topmostView = getTopmostView(context, view);
        return topmostView instanceof ViewGroup ? (ViewGroup) topmostView : view;
    }

    public static Map<String, String> parseCommandUrl(String commandUrl) {
        return parseCommandUrl(commandUrl, c);
    }

    public static String processRawHtml(String rawHtml) {
        StringBuffer stringBuffer = new StringBuffer(rawHtml);
        List listA = a(rawHtml, b);
        boolean zB = b(rawHtml, "html", listA);
        boolean zB2 = b(rawHtml, "head", listA);
        boolean zB3 = b(rawHtml, "body", listA);
        if ((!zB && (zB2 || zB3)) || (zB && !zB3)) {
            return rawHtml;
        }
        if (!zB) {
            stringBuffer.insert(0, "<html><head></head><body><div align=\"center\">");
            stringBuffer.append("</div></body></html>");
        } else if (!zB2) {
            Matcher matcher = Pattern.compile("<html[^>]*>", 2).matcher(stringBuffer);
            for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
                stringBuffer.insert(matcher.end(), "<head></head>");
            }
        }
        a(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean b(String str, String str2, List list) {
        return a(str, str2, list) > -1;
    }

    public static Map<String, String> parseCommandUrl(String commandUrl, MraidJsValidator validator) {
        MraidLog.d("parseCommandUrl", commandUrl, new Object[0]);
        String strRemovePrefix = validator.removePrefix(commandUrl);
        HashMap map = new HashMap();
        int iIndexOf = strRemovePrefix.indexOf(63);
        if (iIndexOf != -1) {
            String strSubstring = strRemovePrefix.substring(0, iIndexOf);
            for (String str : strRemovePrefix.substring(iIndexOf + 1).split(b9.i.c)) {
                int iIndexOf2 = str.indexOf(61);
                map.put(str.substring(0, iIndexOf2), str.substring(iIndexOf2 + 1));
            }
            strRemovePrefix = strSubstring;
        }
        if (!validator.isValidCommand(strRemovePrefix)) {
            MraidLog.w(f.b.g, "%s is unknown", strRemovePrefix);
            return null;
        }
        if (!validator.checkParamsForCommand(strRemovePrefix, map)) {
            MraidLog.w(f.b.g, "URL %s is missing parameters", commandUrl);
            return null;
        }
        HashMap map2 = new HashMap();
        map2.put(f.b.g, strRemovePrefix);
        map2.putAll(map);
        return map2;
    }

    static String a() {
        return "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\" /><style>body { margin:0; padding:0;}*:not(input) { -webkit-touch-callout:none; -webkit-user-select:none; -webkit-text-size-adjust:none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); }</style>";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        return f12207a.contains(str);
    }

    static List a(String str, char... cArr) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && cArr != null) {
            try {
                int[] iArr = new int[cArr.length];
                Arrays.fill(iArr, -1);
                for (int i = 0; i < str.length(); i++) {
                    char cCharAt = str.charAt(i);
                    for (int i2 = 0; i2 < cArr.length; i2++) {
                        if (cCharAt == cArr[i2]) {
                            int i3 = iArr[i2];
                            if (i3 <= -1) {
                                iArr[i2] = i;
                                break;
                            }
                            arrayList.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i)));
                            iArr[i2] = -1;
                            break;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    static String b() {
        if (d == null) {
            d = new String(Base64.decode(MraidJs.JS, 0)).replace("%%VERSION%%", "");
        }
        return d;
    }

    static int a(String str, String str2, List list) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (list == null) {
                list = a(str, b);
            }
            Matcher matcher = Pattern.compile(String.format("<%s[^>]*>", str2), 2).matcher(str);
            while (matcher.find()) {
                int iEnd = matcher.end();
                if (a(iEnd, list)) {
                    return iEnd;
                }
            }
        }
        return -1;
    }

    static void a(StringBuffer stringBuffer) {
        int iA;
        if (!TextUtils.isEmpty(stringBuffer) && (iA = a(stringBuffer.toString(), "head", null)) > -1) {
            stringBuffer.insert(iA, a());
        }
    }

    private static boolean a(int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (i >= ((Integer) pair.first).intValue() && i <= ((Integer) pair.second).intValue()) {
                return false;
            }
        }
        return true;
    }
}
