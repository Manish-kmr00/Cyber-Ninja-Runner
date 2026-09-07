package net.pubnative.lite.sdk.vpaid.helpers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.tracker.ReportingTracker;
import net.pubnative.lite.sdk.network.PNHttpClient;
import net.pubnative.lite.sdk.vpaid.macros.MacroHelper;
import net.pubnative.lite.sdk.vpaid.models.vast.Tracking;

/* JADX INFO: loaded from: classes5.dex */
public class EventTracker {
    private static final Set<String> sUsedEvents = new HashSet();

    private EventTracker() {
    }

    public static synchronized void postEventByType(Context context, List<Tracking> list, String str, MacroHelper macroHelper, boolean z) {
        if (list == null) {
            return;
        }
        for (Tracking tracking : list) {
            if (tracking.getEvent().equalsIgnoreCase(str)) {
                postEvent(context, tracking.getText(), tracking.getEvent(), macroHelper, z);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:13:0x0017 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x0019  */
    /* JADX WARN: Code duplicated, block: B:16:0x001d A[Catch: all -> 0x004e, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000f, B:16:0x001d, B:18:0x0024, B:20:0x0037, B:21:0x003c), top: B:27:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0023  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037 A[Catch: all -> 0x004e, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000f, B:16:0x001d, B:18:0x0024, B:20:0x0037, B:21:0x003c), top: B:27:0x0005 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x0015, please report this as an issue */
    public static synchronized void postEvent(Context context, String str, final String str2, MacroHelper macroHelper, boolean z) {
        String strProcessUrl;
        HashMap map;
        String userAgent;
        if (z) {
            if (sUsedEvents.contains(str)) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (macroHelper != null) {
                strProcessUrl = macroHelper.processUrl(str);
            } else {
                strProcessUrl = str;
            }
            map = new HashMap();
            userAgent = HyBid.getDeviceInfo().getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                map.put("User-Agent", userAgent);
            }
            PNHttpClient.makeRequest(context, strProcessUrl, map, null, false, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.vpaid.helpers.EventTracker.1
                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onSuccess(String str3, Map<String, List<String>> map2) {
                    Log.d("onSuccess", str3);
                }

                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onFailure(Throwable th) {
                    Log.d("onFailure", th.toString());
                }

                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onFinally(String str3, int i) {
                    if (HyBid.getReportingController() != null) {
                        HyBid.getReportingController().reportFiredTracker(new ReportingTracker(str2, str3, i));
                    }
                }
            });
            sUsedEvents.add(str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (macroHelper != null) {
            strProcessUrl = macroHelper.processUrl(str);
        } else {
            strProcessUrl = str;
        }
        map = new HashMap();
        userAgent = HyBid.getDeviceInfo().getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            map.put("User-Agent", userAgent);
        }
        PNHttpClient.makeRequest(context, strProcessUrl, map, null, false, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.vpaid.helpers.EventTracker.1
            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onSuccess(String str3, Map<String, List<String>> map2) {
                Log.d("onSuccess", str3);
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFailure(Throwable th) {
                Log.d("onFailure", th.toString());
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFinally(String str3, int i) {
                if (HyBid.getReportingController() != null) {
                    HyBid.getReportingController().reportFiredTracker(new ReportingTracker(str2, str3, i));
                }
            }
        });
        sUsedEvents.add(str);
        return;
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:13:0x0017 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x0019 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000f, B:14:0x0019, B:16:0x0020, B:18:0x0033, B:19:0x0038), top: B:25:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x001f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0033 A[Catch: all -> 0x004a, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000f, B:14:0x0019, B:16:0x0020, B:18:0x0033, B:19:0x0038), top: B:25:0x0005 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x0015, please report this as an issue */
    public static synchronized void post(Context context, String str, MacroHelper macroHelper, boolean z) {
        String strProcessUrl;
        HashMap map;
        String userAgent;
        if (z) {
            if (sUsedEvents.contains(str)) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (macroHelper != null) {
                strProcessUrl = macroHelper.processUrl(str);
            } else {
                strProcessUrl = str;
            }
            map = new HashMap();
            userAgent = HyBid.getDeviceInfo().getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                map.put("User-Agent", userAgent);
            }
            PNHttpClient.makeRequest(context, strProcessUrl, map, null, false, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.vpaid.helpers.EventTracker.2
                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onSuccess(String str2, Map<String, List<String>> map2) {
                    Log.d("onSuccess", str2);
                }

                @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
                public void onFailure(Throwable th) {
                    Log.d("onFailure", th.toString());
                }
            });
            sUsedEvents.add(str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (macroHelper != null) {
            strProcessUrl = macroHelper.processUrl(str);
        } else {
            strProcessUrl = str;
        }
        map = new HashMap();
        userAgent = HyBid.getDeviceInfo().getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            map.put("User-Agent", userAgent);
        }
        PNHttpClient.makeRequest(context, strProcessUrl, map, null, false, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.vpaid.helpers.EventTracker.2
            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onSuccess(String str2, Map<String, List<String>> map2) {
                Log.d("onSuccess", str2);
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFailure(Throwable th) {
                Log.d("onFailure", th.toString());
            }
        });
        sUsedEvents.add(str);
        return;
        throw th;
    }

    public static void clear() {
        sUsedEvents.clear();
    }
}
