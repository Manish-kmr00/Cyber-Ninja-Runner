package com.safedk.android.analytics;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.sdk.AppLovinSdk;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.n;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class AppLovinBridge {
    private static final String A = "ad_review_creative_id";
    private static Context P = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7952a = "SafeDK";
    public static final String b = "v1/events";
    public static final String c = "v1/image_uploaded";
    public static final String d = "v1/resolved";
    public static final String e = "v1/file_uploaded";
    public static final String f = "platform";
    public static final String g = "package";
    public static final String h = "android";
    public static final String i = "body";
    private static final String k = "AppLovinBridge";
    private static final String l = "max_ad_events";
    private static final String m = "safedk_init";
    private static final String n = "user_info";
    private static final String o = "send_http_request";
    private static final String p = "receive_http_response";
    private static final String q = "safedk_ad_info";
    private static final String r = "max_revenue_events";
    private static final String s = "url";
    private static final String t = "backup_url";
    private static final String u = "post_body";
    private static final String v = "report";
    private static final String w = "metadata";
    private static final String x = "events";
    private static final String y = "public";
    private static final String z = "private";
    private static String B = "https://edge.safedk.com/v1/events";
    private static String C = "https://edge.safedk.com/v1/events";
    private static String D = "https://edge.safedk.com/v1/image_uploaded";
    private static String E = "https://edge.safedk.com/v1/image_uploaded";
    private static String F = "https://edge.safedk.com/v1/resolved";
    private static String G = "https://edge.safedk.com/v1/resolved";
    private static String H = "https://edge.safedk.com/v1/file_uploaded";
    private static String I = "https://edge.safedk.com/v1/file_uploaded";
    private static final String[] J = {"platform"};
    private static final String[] K = {"sdk_uuid", "impression_id", "ad_format_type", "timestamp"};
    private static final String[] L = {FileUploadManager.c};
    private static final String[] M = {"file"};
    private static final String[] N = {FileUploadManager.b};
    private static final HashMap<String, ArrayList<b>> O = new HashMap<>();
    private static AppLovinCommunicator Q = null;
    static AppLovinCommunicatorSubscriber j = new AppLovinCommunicatorSubscriber() { // from class: com.safedk.android.analytics.AppLovinBridge.1
        @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
        public void onMessageReceived(AppLovinCommunicatorMessage message) {
            Logger.d(AppLovinBridge.k, "Response received " + message.getMessageData() + ", topic=" + message.getTopic() + ", url=" + message.getMessageData().getString("url"));
            Bundle messageData = message.getMessageData();
            String string = message.getMessageData().getString("url");
            if (string.endsWith(AppLovinBridge.b)) {
                AppLovinBridge.b(AppLovinBridge.b, messageData.getBundle("body"));
            } else if (string.endsWith(AppLovinBridge.c)) {
                AppLovinBridge.b(AppLovinBridge.c, messageData.getBundle("body"));
            } else if (string.endsWith(AppLovinBridge.d)) {
                AppLovinBridge.b(AppLovinBridge.d, messageData.getBundle("body"));
            }
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorEntity
        public String getCommunicatorId() {
            return AppLovinBridge.f7952a;
        }
    };

    public static void init(Context context) {
        P = context;
        registerToReceiveResponse(j);
    }

    public static void receiveEdgeUrls(String url, String backupUrl) {
        Logger.d(k, "receive edge urls, url=" + url + ", backupUrl=" + backupUrl);
        if (!TextUtils.isEmpty(url)) {
            B = url + RemoteSettings.FORWARD_SLASH_STRING + b;
            Logger.d(k, "receive edge urls, BrandSafetyReportUrl updated to " + B);
            D = url + RemoteSettings.FORWARD_SLASH_STRING + c;
            Logger.d(k, "receive edge urls, ImageUploadedUrl updated to " + D);
            F = url + RemoteSettings.FORWARD_SLASH_STRING + d;
            Logger.d(k, "receive edge urls, ResolvedUrl updated to " + F);
            H = url + RemoteSettings.FORWARD_SLASH_STRING + e;
            Logger.d(k, "receive edge urls, FileUploadedUrl updated to " + H);
        }
        if (!TextUtils.isEmpty(backupUrl)) {
            C = backupUrl + RemoteSettings.FORWARD_SLASH_STRING + b;
            Logger.d(k, "Backup BrandSafetyReportUrl updated to " + C);
            E = backupUrl + RemoteSettings.FORWARD_SLASH_STRING + c;
            Logger.d(k, "Backup ImageUploadedUrl updated to " + E);
            G = backupUrl + RemoteSettings.FORWARD_SLASH_STRING + d;
            Logger.d(k, "Backup ResolvedUrl updated to " + G);
            I = backupUrl + RemoteSettings.FORWARD_SLASH_STRING + e;
            Logger.d(k, "Backup FileUploadUrl updated to " + I);
        }
    }

    public static AppLovinCommunicator getApplovinCommunicator() {
        String str;
        if (Q != null) {
            return Q;
        }
        try {
            Logger.d(k, "get communicator: current applovin sdk is: " + AppLovinSdk.VERSION);
            Class<?> cls = Class.forName("com.applovin.communicator.AppLovinCommunicator");
            try {
                Q = (AppLovinCommunicator) cls.getMethod("getInstance", Context.class).invoke(null, P);
                str = "Context";
            } catch (Throwable th) {
                Q = (AppLovinCommunicator) cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                str = "empty";
            }
        } catch (Throwable th2) {
            Logger.d(k, "Failed to initialize AppLovinCommunicator", th2);
            str = null;
        }
        Logger.d(k, "get communicator: returned: " + Q + " with overload: " + str);
        return Q;
    }

    static void a(ArrayList<Bundle> arrayList, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher) {
        n.b(k, "report stats events start " + arrayList.size() + " events. edgeUrl=" + B + ", events : " + arrayList);
        Bundle bundle = new Bundle();
        bundle.putString("url", B);
        bundle.putString(t, C);
        Bundle bundle2 = new Bundle();
        Bundle bundleC = SafeDK.getInstance().x().c();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        for (Bundle bundle3 : arrayList) {
            if (("impression".equals(bundle3.getString("event_type")) && a(bundle3, K, "stats event")) || !a(bundle3)) {
                Logger.d(k, "report stats events, skipping event with missing fields.");
            } else {
                arrayList2.add(bundle3);
            }
        }
        if (arrayList2.isEmpty() || a(bundleC, J, "metadata")) {
            Logger.d(k, "report stats events not completed. there are missing fields.");
            return;
        }
        bundle2.putBundle("metadata", bundleC);
        bundle2.putParcelableArrayList("events", arrayList2);
        Bundle bundle4 = new Bundle();
        bundle4.putBundle("report", bundle2);
        bundle.putBundle(u, bundle4);
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, o, appLovinCommunicatorPublisher);
        AppLovinCommunicator applovinCommunicator = getApplovinCommunicator();
        if (applovinCommunicator == null) {
            Logger.d(k, "could not get communicator");
        } else {
            Logger.d(k, "publishing message with " + arrayList.size() + " events");
            applovinCommunicator.getMessagingService().publish(appLovinCommunicatorMessage);
        }
    }

    public static Bundle initHttpRequestBundle(String httpRequestUrl, String httpRequestBackupUrl, Bundle data) {
        Bundle bundle = new Bundle();
        bundle.putString("url", httpRequestUrl);
        bundle.putString(t, httpRequestBackupUrl);
        bundle.putBundle(u, data);
        return bundle;
    }

    public static void reportImageUploadEvent(Bundle data, AppLovinCommunicatorPublisher callback) {
        Logger.d(k, "report image upload event start. Data=" + data);
        Bundle bundleC = SafeDK.getInstance().x().c();
        data.putBundle("metadata", bundleC);
        if (a(data, L, "image uploaded") || a(bundleC, J, "metadata")) {
            Logger.d(k, "report image upload event not completed. there are missing fields.");
            return;
        }
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(initHttpRequestBundle(D, E, data), o, callback);
        AppLovinCommunicator applovinCommunicator = getApplovinCommunicator();
        if (applovinCommunicator == null) {
            Logger.d(k, "could not get communicator");
        } else {
            Logger.d(k, "publishing message. body=" + data);
            applovinCommunicator.getMessagingService().publish(appLovinCommunicatorMessage);
        }
    }

    public static void reportFileUploadEvent(Bundle data, AppLovinCommunicatorPublisher callback) {
        Logger.d(k, "report File upload event start. Data=" + data);
        data.putString("sdk_key", SafeDK.getInstance().x().a());
        Bundle bundleC = SafeDK.getInstance().x().c();
        data.putBundle("metadata", bundleC);
        if (a(data, M, "file uploaded") || a(bundleC, J, "metadata")) {
            Logger.d(k, "report File upload event not completed. there are missing fields.");
            return;
        }
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(initHttpRequestBundle(H, I, data), o, callback);
        AppLovinCommunicator applovinCommunicator = getApplovinCommunicator();
        if (applovinCommunicator == null) {
            Logger.d(k, "could not get communicator");
        } else {
            Logger.d(k, "publishing message. body=" + data);
            applovinCommunicator.getMessagingService().publish(appLovinCommunicatorMessage);
        }
    }

    public static void reportClickUrlResolvedEvent(Bundle data, AppLovinCommunicatorPublisher callback) {
        Logger.d(k, "report click url resolved event start");
        Bundle bundleC = SafeDK.getInstance().x().c();
        data.putBundle("metadata", bundleC);
        if (a(data, N, "resolved") || a(bundleC, J, "metadata")) {
            Logger.d(k, "report image upload event not completed. there are missing fields.");
            return;
        }
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(initHttpRequestBundle(F, G, data), o, callback);
        AppLovinCommunicator applovinCommunicator = getApplovinCommunicator();
        if (applovinCommunicator == null) {
            Logger.d(k, "could not get communicator");
        } else {
            Logger.d(k, "publishing message. body=" + data);
            applovinCommunicator.getMessagingService().publish(appLovinCommunicatorMessage);
        }
    }

    public static void reportMaxCreativeId(Bundle appLovinMaxBundle, String creativeId, AppLovinCommunicatorPublisher callback) {
        Logger.d(k, "report max creative ID start, creative ID=" + creativeId + ", appLovin max bundle=" + appLovinMaxBundle.toString());
        Bundle bundle = new Bundle();
        bundle.putString(A, creativeId);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("public", bundle);
        bundle2.putBundle("private", appLovinMaxBundle);
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle2, q, callback);
        AppLovinCommunicator applovinCommunicator = getApplovinCommunicator();
        if (applovinCommunicator == null) {
            Logger.d(k, "could not get communicator");
        } else {
            Logger.d(k, "report max creative ID, publishing message. body=" + bundle2);
            applovinCommunicator.getMessagingService().publish(appLovinCommunicatorMessage);
        }
    }

    private static boolean a(Bundle bundle) {
        return SdksMapping.getSdkPackageByPackageUUID(bundle.getString("sdk_uuid")) != null;
    }

    private static boolean a(Bundle bundle, String[] strArr, String str) {
        if (strArr != null) {
            HashSet hashSet = new HashSet();
            for (String str2 : strArr) {
                if (!bundle.containsKey(str2)) {
                    hashSet.add(str2);
                } else {
                    Object obj = bundle.get(str2);
                    if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
                        hashSet.add(str2);
                    }
                }
            }
            if (!hashSet.isEmpty()) {
                Logger.d(k, "missing fields in " + str + " data: " + hashSet);
                return true;
            }
        }
        return false;
    }

    public static void registerToReceiveMaxEvents(AppLovinCommunicatorSubscriber subscriber) {
        a(subscriber, l);
    }

    public static void registerToReceiveResponse(AppLovinCommunicatorSubscriber subscriber) {
        a(subscriber, p);
    }

    public static void registerToReceiveSafeDKSettings(AppLovinCommunicatorSubscriber subscriber) {
        a(subscriber, m);
    }

    public static void registerToReceiveMaxRevenueEvents(AppLovinCommunicatorSubscriber subscriber) {
        a(subscriber, r);
    }

    public static void registerToReceiveUserInfo(AppLovinCommunicatorSubscriber subscriber) {
        a(subscriber, n);
    }

    private static void a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (getApplovinCommunicator() != null) {
            getApplovinCommunicator().subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
        } else {
            Logger.d(k, "could not register - communicator is null");
        }
    }

    public static void registerListener(String requestName, b listener) {
        try {
            Logger.d(k, "register listener started, request name=" + requestName);
            if (!O.containsKey(requestName)) {
                Logger.d(k, "register listener, listener list created for request name=" + requestName);
                O.put(requestName, new ArrayList<>());
            }
            ArrayList<b> arrayList = O.get(requestName);
            Logger.d(k, "register listener, listener added for request name=" + requestName + StringUtils.COMMA + listener);
            arrayList.add(listener);
        } catch (Throwable th) {
            Logger.e(k, "register listener failed. request name:" + requestName + ", listener: " + listener, th);
            new CrashReporter().caughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, Bundle bundle) {
        try {
            Logger.d(k, "notify listeners started, request name=" + str + ", data=" + bundle);
            ArrayList<b> arrayList = O.get(str);
            if (arrayList != null) {
                for (b bVar : arrayList) {
                    Logger.d(k, "Invoking handler for request name '" + str + "', Bundle : " + bundle);
                    bVar.a(str, bundle);
                }
            }
        } catch (Throwable th) {
            Logger.e(k, "Failed to read response", th);
        }
    }
}
