package com.pubmatic.sdk.common.utility;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBLocation;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class POBUtils {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat a(View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public static String buildUriWithQueryParams(Uri uri, Map<String, String> map) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    public static String buildUrlWithQueryParam(String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter(str2, str3);
        return builderBuildUpon.build().toString();
    }

    public static int convertDpToPixel(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float convertDpToPixelWithFloatPrecession(int i) {
        return i * Resources.getSystem().getDisplayMetrics().density;
    }

    public static int convertPixelToDp(int i) {
        return (int) (i / Resources.getSystem().getDisplayMetrics().density);
    }

    public static List<String> convertStringJsonArrayToList(JSONArray jSONArray) {
        if (isJsonArrayNullOrEmpty(jSONArray)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!jSONArray.isNull(i)) {
                arrayList.add(jSONArray.optString(i));
            }
        }
        return arrayList;
    }

    public static double convertToSeconds(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            if (!str2.contains("%")) {
                return getSeconds(str2);
            }
            try {
                return (getSeconds(str) * Double.parseDouble(str2.replace("%", ""))) / 100.0d;
            } catch (NumberFormatException unused) {
                POBLog.error("POBUtils", "Invalid time value", new Object[0]);
            }
        }
        return 0.0d;
    }

    public static String decodeUrl(String str) {
        try {
            POBLog.debug("POBUtils", "encoded URL: " + str, new Object[0]);
            String strDecode = URLDecoder.decode(str, StandardCharsets.UTF_8.name());
            POBLog.debug("POBUtils", "Decoded URL: " + strDecode, new Object[0]);
            return strDecode;
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            POBLog.debug("POBUtils", "Failed to decode url due to " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static List<String> filterListOfStrings(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (String str2 : list) {
                if (str2 != null && str2.contains(str)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static boolean getBooleanValue(String str) {
        if (str != null) {
            try {
                return Boolean.parseBoolean(str);
            } catch (Exception unused) {
                POBLog.error("POBUtils", "Cannot convert string %s to boolean", str);
            }
        }
        return false;
    }

    public static int getDeviceOrientation(Context context) {
        Configuration configuration;
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static int getIntegerValue(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                POBLog.error("POBUtils", "Cannot convert string %s to integer", str);
            }
        }
        return 0;
    }

    public static POBAdSize getInterstitialAdSize(Context context) {
        int deviceOrientation = getDeviceOrientation(context);
        if (isTablet(context)) {
            return deviceOrientation == 2 ? POBAdSize.INTERSTITIAL_1024x768 : POBAdSize.INTERSTITIAL_768x1024;
        }
        return deviceOrientation == 2 ? POBAdSize.INTERSTITIAL_480x320 : POBAdSize.INTERSTITIAL_320x480;
    }

    public static POBLocation getLocation(POBLocationDetector pOBLocationDetector) {
        Location location;
        POBLocation pOBLocation = (!POBInstanceProvider.getSdkConfig().isLocationAccessAllowed() || pOBLocationDetector == null || (location = pOBLocationDetector.getLocation()) == null) ? null : new POBLocation(location);
        return pOBLocation == null ? POBInstanceProvider.getSdkConfig().getLocation() : pOBLocation;
    }

    public static int getRandomNumber(int i, int i2) {
        return i + ((int) (Math.random() * ((double) ((i2 - i) + 1))));
    }

    public static int getScreenHeight() {
        return convertPixelToDp(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    public static int getScreenWidth() {
        return convertPixelToDp(Resources.getSystem().getDisplayMetrics().widthPixels);
    }

    public static double getSeconds(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0d;
        }
        String[] strArrSplit = str.split(":", -1);
        double d = 0.0d;
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            try {
                d += Double.parseDouble(strArrSplit[length]) * Math.pow(60.0d, (strArrSplit.length - 1) - length);
            } catch (NumberFormatException unused) {
                POBLog.error("POBUtils", "Invalid time value", new Object[0]);
                return 0.0d;
            }
        }
        return d;
    }

    public static int getTimeOffsetInMinutes() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        return (calendar.get(15) + calendar.get(16)) / 60000;
    }

    public static int getValidRefreshInterval(int i, int i2) {
        if (i <= 0) {
            return 0;
        }
        return i <= i2 ? i2 : i;
    }

    public static int getViewVisiblePixel(View view) {
        if (view == null) {
            return 0;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            return rect.height() * rect.width();
        }
        return 0;
    }

    public static int[] getViewXYPosition(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = convertPixelToDp(iArr[0]);
        iArr[1] = convertPixelToDp(iArr[1]);
        return iArr;
    }

    public static float getVisiblePercent(View view) {
        if (view == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            return ((rect.height() * rect.width()) * 100) / (view.getHeight() * view.getWidth());
        }
        return 0.0f;
    }

    public static boolean hasPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            POBLog.warn("POBUtils", "Error while checking permission %s", e.getMessage());
            return false;
        }
    }

    public static boolean isDebugBuild(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isJsonArrayNullOrEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() <= 0;
    }

    public static boolean isJsonObjectNullOrEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }

    public static boolean isListNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isNull(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj != null) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str != null) {
            return str.isEmpty();
        }
        return true;
    }

    public static boolean isStringValueNullOrEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("null");
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isValidPlayStoreUrl(String str) {
        if (str == null) {
            return false;
        }
        if (str.contains(POBCommonConstants.PLAY_STORE_DOMAIN) || str.contains(POBCommonConstants.MARKET_LAUNCH_URL) || str.contains(POBCommonConstants.MARKET_DETAILS_URL)) {
            return str.contains("id=");
        }
        return false;
    }

    public static boolean isViewVisible(View view, int i) {
        return getViewVisiblePixel(view) >= i;
    }

    public static void logBidWinningStatus(boolean z, String str) {
        if (z) {
            POBLog.debug("POBUtils", "Bid win for partner - %s", str);
        } else {
            POBLog.debug("POBUtils", "AdServerWin", new Object[0]);
        }
    }

    public static boolean openExternalBrowser(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
            return true;
        } catch (Exception unused) {
            POBLog.error("POBUtils", "Open external browser %s", "Not able to parse url");
            return false;
        }
    }

    public static String parseJsTracker(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (str.startsWith("http")) {
                sb.append(String.format("<script src=\"%s\"></script>", str));
            } else {
                sb.append(str);
            }
        }
        return String.format("<!DOCTYPE HTML><html><head>%s</head></html>", sb);
    }

    public static Set<String> parseJsonArrayToSet(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getString(i));
            }
        }
        return hashSet;
    }

    public static String readFromAssets(Context context, String str) {
        IOException e;
        String str2;
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            str2 = new String(bArr);
            try {
                POBLog.debug("POBUtils", POBLogConstants.READ_FROM_ASSET, str);
            } catch (IOException e2) {
                e = e2;
                POBLog.error("POBUtils", "Failed to read file %s from bundle with error: %s", str, e);
            }
        } catch (IOException e3) {
            e = e3;
            str2 = null;
        }
        return str2;
    }

    public static Context resolveWebViewContext(Context context) {
        return context;
    }

    public static void runOnBackgroundThread(Runnable runnable) {
        POBTaskHandler.getInstance().runOnBackgroundThread(runnable);
    }

    public static void runOnMainThread(Runnable runnable) {
        POBTaskHandler.getInstance().runOnMainThread(runnable);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        p0.startActivity(p1);
    }

    public static void setSystemFitWindowsForEdgeToEdge(final View view, Window window) {
        ViewCompat.setOnApplyWindowInsetsListener(window.getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.pubmatic.sdk.common.utility.POBUtils$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return POBUtils.a(view, view2, windowInsetsCompat);
            }
        });
    }

    public static void startActivity(Context context, Intent intent) throws Exception {
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context.getApplicationContext(), intent);
        } catch (Exception e) {
            POBLog.warn("POBUtils", "Error while starting activity %s", e.getMessage());
            throw new Exception(e);
        }
    }
}
