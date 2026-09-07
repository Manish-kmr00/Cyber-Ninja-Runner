package com.safedk.android.analytics.brandsafety;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.MobileAds;
import com.json.b9;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.analytics.events.RedirectEvent;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BrandSafetyUtils {
    private static final float A = 0.2f;
    private static final float B = 0.2f;
    private static final float C = 0.2f;
    private static int L = 0;
    private static int M = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f7972a = ".jpg";
    static final String b = ".txt";
    static final String c = "unknown";
    static final String d = "com.appsaholic";
    static final int e = 1000;
    static final int f = 500;
    public static final int g = 86400000;
    public static final int h = 20000;
    public static final int i = 5000;
    public static final String j = "INTER";
    public static final String k = "REWARDED";
    public static final String l = "APPOPEN";
    public static final String m = "BANNER";
    public static final String n = "LEADER";
    public static final String o = "MREC";
    public static final String p = "NATIVE";
    private static final String q = "BrandSafetyUtils";
    private static final Set<String> s;
    private static final Set<String> t;
    private static final int v = 100;
    private static final int w = 0;
    private static final int x = 8947848;
    private static final int y = 4473924;
    private static final float z = 0.2f;
    private static final List<Integer> u = new LinkedList();
    private static m D = null;
    private static RedirectDetails E = null;
    private static String F = null;
    private static String G = null;
    private static final ExecutorService H = Executors.newSingleThreadExecutor();
    private static Map<String, x> I = new ConcurrentHashMap();
    private static final LimitedConcurrentHashMap<String, WeakReference<WebView>> J = new LimitedConcurrentHashMap<>();
    private static final LimitedConcurrentHashMap<String, WeakReference<WebView>> K = new LimitedConcurrentHashMap<>();
    private static final String INTERSTITIAL_ACTIVITIES = "Y29tLnVuaXR5M2QuYWRzLmFuZHJvaWQudmlldy5Vbml0eUFkc0Z1bGxzY3JlZW5BY3Rpdml0eXxjb20udW5pdHkzZC5hZHMuYWR1bml0LkFkVW5pdEFjdGl2aXR5fGNvbS51bml0eTNkLmFkcy5hZHVuaXQuQWRVbml0U29mdHdhcmVBY3Rpdml0eXxjb20udW5pdHkzZC5zZXJ2aWNlcy5hZHMuYWR1bml0LkFkVW5pdEFjdGl2aXR5fGNvbS51bml0eTNkLnNlcnZpY2VzLmFkcy5hZHVuaXQuQWRVbml0U29mdHdhcmVBY3Rpdml0eXxjb20udW5pdHkzZC5hZHMuYWRwbGF5ZXIuRnVsbFNjcmVlbldlYlZpZXdEaXNwbGF5fGNvbS5nb29nbGUuYW5kcm9pZC5nbXMuYWRzLkFkQWN0aXZpdHl8Y29tLmdvb2dsZS5hZHMuQWRBY3Rpdml0eXxjb20udnVuZ2xlLnB1Ymxpc2hlci5GdWxsU2NyZWVuQWRBY3Rpdml0eXxjb20udnVuZ2xlLnB1Ymxpc2hlci5NcmFpZEZ1bGxTY3JlZW5BZEFjdGl2aXR5fGNvbS52dW5nbGUucHVibGlzaGVyLlZpZGVvRnVsbFNjcmVlbkFkQWN0aXZpdHl8Y29tLnZ1bmdsZS5wdWJsaXNoZXIuRmxleFZpZXdBZEFjdGl2aXR5fGNvbS52dW5nbGUud2FycmVuLnVpLlZ1bmdsZUFjdGl2aXR5fGNvbS52dW5nbGUud2FycmVuLnVpLlZ1bmdsZUZsZXhWaWV3QWN0aXZpdHl8Y29tLnZ1bmdsZS5hZHMuaW50ZXJuYWwudWkuVnVuZ2xlQWN0aXZpdHl8Y29tLmFwcGxvdmluLmFkdmlldy5BcHBMb3ZpbkludGVyc3RpdGlhbEFjdGl2aXR5fGNvbS5hcHBsb3Zpbi5hZHZpZXcuQXBwTG92aW5GdWxsc2NyZWVuQWN0aXZpdHl8Y29tLmFwcGxvdmluLmFkdmlldy5BcHBMb3ZpbkZ1bGxzY3JlZW5UaGVtZWRBY3Rpdml0eXxjb20uYXBwbG92aW4uaW1wbC5hZHZpZXcuQXBwTG92aW5PcmllbnRhdGlvbkF3YXJlSW50ZXJzdGl0aWFsQWN0aXZpdHl8Y29tLnN1cGVyc29uaWNhZHMuc2RrLmNvbnRyb2xsZXIuQ29udHJvbGxlckFjdGl2aXR5fGNvbS5zdXBlcnNvbmljYWRzLnNkay5jb250cm9sbGVyLkludGVyc3RpdGlhbEFjdGl2aXR5fGNvbS5pcm9uc291cmNlLnNkay5jb250cm9sbGVyLkNvbnRyb2xsZXJBY3Rpdml0eXxjb20uaXJvbnNvdXJjZS5zZGsuY29udHJvbGxlci5JbnRlcnN0aXRpYWxBY3Rpdml0eXxjb20ubWludGVncmFsLm1zZGsuaW50ZXJzdGl0aWFsLnZpZXcuTVRHSW50ZXJzdGl0aWFsQWN0aXZpdHl8Y29tLm1pbnRlZ3JhbC5tc2RrLnJld2FyZC5wbGF5ZXIuTVRHUmV3YXJkVmlkZW9BY3Rpdml0eXxjb20ubWludGVncmFsLm1zZGsubmV3cmV3YXJkLnBsYXllci5NVEdSZXdhcmRWaWRlb0FjdGl2aXR5fGNvbS5taW50ZWdyYWwubXNkay5pbnRlcmFjdGl2ZWFkcy5hY3Rpdml0eS5JbnRlcmFjdGl2ZVNob3dBY3Rpdml0eXxjb20ubWJyaWRnZS5tc2RrLmludGVyc3RpdGlhbC52aWV3Lk1CSW50ZXJzdGl0aWFsQWN0aXZpdHl8Y29tLm1icmlkZ2UubXNkay5yZXdhcmQucGxheWVyLk1CUmV3YXJkVmlkZW9BY3Rpdml0eXxjb20ubWJyaWRnZS5tc2RrLm5ld3Jld2FyZC5wbGF5ZXIuTUJSZXdhcmRWaWRlb0FjdGl2aXR5fGNvbS5tYnJpZGdlLm1zZGsuaW50ZXJhY3RpdmVhZHMuYWN0aXZpdHkuSW50ZXJhY3RpdmVTaG93QWN0aXZpdHl8Y29tLmZ5YmVyLmlubmVyYWN0aXZlLnNkay5hY3Rpdml0aWVzLklubmVyYWN0aXZlRnVsbHNjcmVlbkFkQWN0aXZpdHl8Y29tLmZpdmVfY29ycC5hZC5BZEFjdGl2aXR5fGNvbS5pbm1vYmkuYWRzLnJlbmRlcmluZy5Jbk1vYmlBZEFjdGl2aXR5fGNvbS5ieXRlZGFuY2Uuc2RrLm9wZW5hZHNkay5hY3Rpdml0eS5UVEZ1bGxTY3JlZW5WaWRlb0FjdGl2aXR5fGNvbS5ieXRlZGFuY2Uuc2RrLm9wZW5hZHNkay5hY3Rpdml0eS5UVEZ1bGxTY3JlZW5FeHByZXNzVmlkZW9BY3Rpdml0eXxjb20uYnl0ZWRhbmNlLnNkay5vcGVuYWRzZGsuYWN0aXZpdHkuVFRSZXdhcmRWaWRlb0FjdGl2aXR5fGNvbS5ieXRlZGFuY2Uuc2RrLm9wZW5hZHNkay5hY3Rpdml0eS5UVFJld2FyZEV4cHJlc3NWaWRlb0FjdGl2aXR5fGNvbS5ieXRlZGFuY2Uuc2RrLm9wZW5hZHNkay5hY3Rpdml0eS5UVEFwcE9wZW5BZEFjdGl2aXR5fGNvbS5ieXRlZGFuY2Uuc2RrLm9wZW5hZHNkay5hY3Rpdml0eS5BZEFjdGl2aXR5fGNvbS5ieXRlZGFuY2Uuc2RrLm9wZW5hZHNkay5hY3Rpdml0eS5UVEFkQWN0aXZpdHl8Y29tLmJ5dGVkYW5jZS5zZGsub3BlbmFkc2RrLmFjdGl2aXR5LlRUSW50ZXJzdGl0aWFsQWN0aXZpdHl8Y29tLmJ5dGVkYW5jZS5zZGsub3BlbmFkc2RrLmFjdGl2aXR5LlRUSW50ZXJzdGl0aWFsRXhwcmVzc0FjdGl2aXR5fGNvbS5zbWFhdG8uc2RrLmludGVyc3RpdGlhbC5JbnRlcnN0aXRpYWxBZEFjdGl2aXR5fGNvbS5zbWFhdG8uc2RrLmludGVyc3RpdGlhbC52aWV3LkludGVyc3RpdGlhbEFkQWN0aXZpdHl8Y29tLnNtYWF0by5zZGsucmV3YXJkZWQud2lkZ2V0LlJld2FyZGVkSW50ZXJzdGl0aWFsQWRBY3Rpdml0eXxjb20uc21hYXRvLnNkay5yZXdhcmRlZC52aWV3LlJld2FyZGVkSW50ZXJzdGl0aWFsQWRBY3Rpdml0eXxjb20ubW9sb2NvLnNkay54ZW5vc3Muc2RrZGV2a2l0LmFuZHJvaWQuYWRyZW5kZXJlci5pbnRlcm5hbC5tcmFpZC5NcmFpZEFjdGl2aXR5fGNvbS5tb2xvY28uc2RrLnhlbm9zcy5zZGtkZXZraXQuYW5kcm9pZC5hZHJlbmRlcmVyLmludGVybmFsLnN0YXRpY3JlbmRlcmVyLlN0YXRpY0FkQWN0aXZpdHl8Y29tLm1vbG9jby5zZGsueGVub3NzLnNka2RldmtpdC5hbmRyb2lkLmFkcmVuZGVyZXIuaW50ZXJuYWwudmFzdC5WYXN0QWN0aXZpdHl8Y29tLmV4cGxvcmVzdGFjay5pYWIubXJhaWQuTXJhaWRBY3Rpdml0eXxjb20uZXhwbG9yZXN0YWNrLmlhYi52YXN0LmFjdGl2aXR5LlZhc3RBY3Rpdml0eXxpby5iaWRtYWNoaW5lLnJlbmRlcmluZy5hZC5mdWxsc2NyZWVuLkZ1bGxTY3JlZW5BY3Rpdml0eXxpby5iaWRtYWNoaW5lLmlhYi52YXN0LmFjdGl2aXR5LlZhc3RBY3Rpdml0eXxuZXQucHVibmF0aXZlLmxpdGUuc2RrLmludGVyc3RpdGlhbC5hY3Rpdml0eS5NcmFpZEludGVyc3RpdGlhbEFjdGl2aXR5fG5ldC5wdWJuYXRpdmUubGl0ZS5zZGsuaW50ZXJzdGl0aWFsLmFjdGl2aXR5LlZhc3RJbnRlcnN0aXRpYWxBY3Rpdml0eXxuZXQucHVibmF0aXZlLmxpdGUuc2RrLnJld2FyZGVkLmFjdGl2aXR5Lk1yYWlkUmV3YXJkZWRBY3Rpdml0eXxuZXQucHVibmF0aXZlLmxpdGUuc2RrLnJld2FyZGVkLmFjdGl2aXR5LlZhc3RSZXdhcmRlZEFjdGl2aXR5fGNvbS5tb2JpbGVmdXNlLnNkay5Nb2JpbGVGdXNlRnVsbHNjcmVlbkFjdGl2aXR5fGNvbS5jaGFydGJvb3N0LnNkay52aWV3LkNCSW1wcmVzc2lvbkFjdGl2aXR5fGNvbS5jaGFydGJvb3N0LnNkay52aWV3LkZ1bGxzY3JlZW5BZEFjdGl2aXR5fGNvbS5wdWJtYXRpYy5zZGsud2VicmVuZGVyaW5nLm1yYWlkLlBPQlZpZGVvUGxheWVyQWN0aXZpdHl8Y29tLnB1Ym1hdGljLnNkay53ZWJyZW5kZXJpbmcudWkuUE9CRnVsbFNjcmVlbkFjdGl2aXR5fGNvbS5hbWF6b24uYXBzLmFkcy5hY3Rpdml0eS5BcHNJbnRlcnN0aXRpYWxBY3Rpdml0eQ==";
    private static final Set<String> r = new HashSet(Arrays.asList(new String(Base64.decode(INTERSTITIAL_ACTIVITIES, 0)).split("\\|")));

    public enum AdType {
        INTERSTITIAL,
        MREC,
        BANNER,
        NATIVE
    }

    public enum ScreenShotOrientation {
        NOT_INITIALIZED,
        PORTRAIT,
        LANDSCAPE
    }

    public enum ScreenshotValidity {
        VALID,
        UNIFORMITY_BLACK,
        UNIFORMITY_VERY_HIGH,
        UNIFORMITY_HIGH,
        UNIFORMITY_GRAY,
        NOT_SUITABLE_FOR_DASHBOARD
    }

    static {
        Logger.d(q, "BrandSafetyUtils initialized with " + r + ",  INTERSTITIAL_ACTIVITIES=" + INTERSTITIAL_ACTIVITIES);
        s = new HashSet(Arrays.asList(new String(Base64.decode("Y29tLmJ5dGVkYW5jZS5zZGsub3BlbmFkc2RrLmFjdGl2aXR5LlRUTGFuZGluZ1BhZ2VBY3Rpdml0eXxjb20uYnl0ZWRhbmNlLnNkay5vcGVuYWRzZGsuYWN0aXZpdHkuVFRQbGF5YWJsZUxhbmRpbmdQYWdlQWN0aXZpdHl8Y29tLmJ5dGVkYW5jZS5zZGsub3BlbmFkc2RrLmFjdGl2aXR5LlRUVmlkZW9MYW5kaW5nUGFnZUxpbmsyQWN0aXZpdHl8Y29tLmJ5dGVkYW5jZS5zZGsub3BlbmFkc2RrLmFjdGl2aXR5LlRURGVsZWdhdGVBY3Rpdml0eXxjb20uYnl0ZWRhbmNlLnNkay5vcGVuYWRzZGsuYWN0aXZpdHkuVFRXZWJzaXRlQWN0aXZpdHl8Y29tLmZ5YmVyLmlubmVyYWN0aXZlLnNkay5hY3Rpdml0aWVzLklubmVyYWN0aXZlSW50ZXJuYWxCcm93c2VyQWN0aXZpdHl8Y29tLmlyb25zb3VyY2Uuc2RrLmNvbnRyb2xsZXIuT3BlblVybEFjdGl2aXR5fGNvbS5zbWFhdG8uc2RrLmNvcmUuYnJvd3Nlci5TbWFhdG9TZGtCcm93c2VyQWN0aXZpdHl8Y29tLnB1Ym1hdGljLnNkay5jb21tb24uYnJvd3Nlci5QT0JJbnRlcm5hbEJyb3dzZXJBY3Rpdml0eQ==", 0)).split("\\|")));
        Logger.d(q, "BrandSafetyUtils initialized with " + s + ",  INTERNAL_BROWSER_ACTIVITIES=" + INTERSTITIAL_ACTIVITIES);
        t = new HashSet();
        L = 0;
        M = 0;
    }

    public static void a(String str) {
        s.add(str);
    }

    public static BrandSafetyEvent.AdFormatType a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("ad_format");
            if ("BANNER".equals(string) || n.equals(string)) {
                return BrandSafetyEvent.AdFormatType.BANNER;
            }
            if (o.equals(string)) {
                return BrandSafetyEvent.AdFormatType.MREC;
            }
            if (k.equals(string)) {
                return BrandSafetyEvent.AdFormatType.REWARD;
            }
            if (j.equals(string)) {
                return BrandSafetyEvent.AdFormatType.INTER;
            }
            if (l.equals(string)) {
                return BrandSafetyEvent.AdFormatType.APPOPEN;
            }
            if ("NATIVE".equals(string)) {
                return BrandSafetyEvent.AdFormatType.NATIVE;
            }
        }
        return null;
    }

    public static BrandSafetyEvent.AdFormatType a(AdType adType) {
        if (adType != null) {
            switch (adType) {
                case INTERSTITIAL:
                    return BrandSafetyEvent.AdFormatType.INTER;
                case BANNER:
                    return BrandSafetyEvent.AdFormatType.BANNER;
                case MREC:
                    return BrandSafetyEvent.AdFormatType.MREC;
                case NATIVE:
                    return BrandSafetyEvent.AdFormatType.NATIVE;
            }
        }
        return null;
    }

    public static AdType b(String str) {
        if (str != null) {
            return a(BrandSafetyEvent.AdFormatType.valueOf(str));
        }
        return null;
    }

    public static AdType a(BrandSafetyEvent.AdFormatType adFormatType) {
        if (adFormatType != null) {
            switch (adFormatType) {
                case INTER:
                case REWARD:
                case APPOPEN:
                    return AdType.INTERSTITIAL;
                case BANNER:
                case LEADER:
                    return AdType.BANNER;
                case MREC:
                    return AdType.MREC;
                case NATIVE:
                    return AdType.NATIVE;
            }
        }
        return null;
    }

    static class c implements FilenameFilter {
        c() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File dir, String name) {
            return name.endsWith(BrandSafetyUtils.f7972a);
        }
    }

    static class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7988a;

        public b(String str) {
            this.f7988a = null;
            this.f7988a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File dir, String name) {
            return name.contains(this.f7988a);
        }
    }

    public static void detectAdClick(Intent intent, String sdkPackageName) {
        a(intent, sdkPackageName, false);
    }

    public static void a(final Intent intent, final String str, final boolean z2) {
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            Logger.d(q, "detect ad click invoked, sdk=" + str);
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (com.safedk.android.utils.n.c()) {
                H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrandSafetyUtils.b(intent, str, z2, stackTrace);
                    }
                });
            } else {
                b(intent, str, z2, stackTrace);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Intent intent, String str, boolean z2, StackTraceElement[] stackTraceElementArr) {
        Uri uri;
        String str2;
        String string;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String mainSdkPackage = SdksMapping.getMainSdkPackage(str);
            com.safedk.android.utils.n.b(q, "detect ad click started, current timestamp (elapsed)=" + jElapsedRealtime + ", sdk=" + mainSdkPackage + ", intent=" + com.safedk.android.utils.n.a(intent) + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (SafeDK.getInstance().s()) {
                Logger.d(q, "detect ad click - should monitor");
                if (intent != null) {
                    Intent intent2 = (Intent) intent.clone();
                    Logger.d(q, "detect ad click - intent cloned");
                    int iF = SafeDK.getInstance().f();
                    Logger.d(q, "detect ad click - redirect click timeout is " + iF);
                    Uri data = intent2.getData();
                    String strA = a(mainSdkPackage, intent2);
                    if (strA != null) {
                        Logger.d(q, "detect ad click - uri extracted from intent extras");
                        uri = Uri.parse(strA);
                    } else {
                        uri = data;
                    }
                    String str3 = null;
                    if (uri == null) {
                        str2 = null;
                    } else {
                        String string2 = uri.toString();
                        try {
                            if (com.safedk.android.utils.n.p(uri.toString())) {
                                Logger.d(q, "detect ad click - Uri is a store url: " + uri);
                                string = uri.toString();
                            } else {
                                URL url = new URL(uri.toString());
                                Logger.d(q, "detect ad click - Uri is a standard url: " + url);
                                string = url.toString();
                            }
                            str3 = string;
                            str2 = string2;
                        } catch (MalformedURLException e2) {
                            Logger.d(q, "detect ad click - Uri is not a valid url: " + uri);
                            str2 = string2;
                        }
                    }
                    String strB = b(mainSdkPackage, intent2);
                    v vVarA = DetectTouchUtils.a(mainSdkPackage);
                    long jLongValue = vVarA == null ? 0L : vVarA.f8117a.longValue();
                    long jLongValue2 = vVarA == null ? 0L : vVarA.b.longValue();
                    String str4 = vVarA == null ? null : vVarA.c;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (("android.intent.action.VIEW".equals(intent2.getAction()) || intent2.getAction() == null) && str3 != null) {
                        Logger.d(q, "detect ad click - has URL, intentUrl: " + str3);
                        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(mainSdkPackage);
                        if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.j(str3)) {
                            Logger.d(q, "detect ad click - url should be ignored (by discovery class), skipping");
                            return;
                        }
                        if (!a(intent)) {
                            Logger.d(q, "detect ad click - not handled (yet)");
                            Activity foregroundActivity = com.safedk.android.internal.b.getInstance().getForegroundActivity();
                            StatsCollector statsCollectorC = StatsCollector.c();
                            if (foregroundActivity != null && statsCollectorC != null) {
                                Logger.d(q, "detect ad click - has foreground");
                                InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
                                n nVarD = interstitialFinderZ != null ? interstitialFinderZ.d(foregroundActivity) : null;
                                boolean z3 = false;
                                if (SafeDK.getInstance().A() != null && SafeDK.getInstance().A().l(str4)) {
                                    z3 = true;
                                }
                                if (interstitialFinderZ != null && nVarD != null && !z3) {
                                    Logger.d(q, "detect ad click - has interstitial");
                                    boolean zD = nVarD.d();
                                    Logger.d(q, "detect ad click - clicked " + zD);
                                    Logger.d(q, "detect ad click - last touch event(elapsed): " + jLongValue + " last touch event(current time millis): " + jLongValue2 + ", activityAddress=" + a(foregroundActivity.getClass().getName(), true));
                                    if (jElapsedRealtime2 - jLongValue < 20000 && interstitialFinderZ.a(str3, mainSdkPackage, str4, true)) {
                                        if (str4 != null) {
                                            l.a[] aVarArr = new l.a[2];
                                            aVarArr[0] = new l.a("url", str3);
                                            aVarArr[1] = new l.a(l.J, z2 ? RedirectEvent.j : SDKConstants.PARAM_INTENT);
                                            com.safedk.android.analytics.brandsafety.b.a(str4, l.n, aVarArr);
                                        } else {
                                            n nVarD2 = interstitialFinderZ.d(foregroundActivity);
                                            l.a[] aVarArr2 = new l.a[2];
                                            aVarArr2[0] = new l.a("url", str3);
                                            aVarArr2[1] = new l.a(l.J, z2 ? RedirectEvent.j : SDKConstants.PARAM_INTENT);
                                            nVarD2.a(l.n, aVarArr2);
                                        }
                                    }
                                    String strA2 = t.a(mainSdkPackage, jLongValue);
                                    boolean z4 = true;
                                    if (SafeDK.b() && statsCollectorC.a(mainSdkPackage, strA2)) {
                                        z4 = false;
                                    } else {
                                        Logger.d(q, "Reporter thread not initialized or stats collector instance is null or redirect info does not exist, skipping");
                                    }
                                    Logger.d(q, "detect ad click - should handle click " + z4);
                                    if (z4) {
                                        Logger.d(q, "detect ad click - current elapsed realtime: " + jElapsedRealtime2 + ", activity last touched: " + jLongValue + ", diff: " + (jElapsedRealtime2 - jLongValue) + ", isClicked: " + zD);
                                        if ((jLongValue == 0 || jElapsedRealtime2 - jLongValue > iF) && !zD) {
                                            Logger.d(q, "detect ad click - redirect");
                                            a(mainSdkPackage, jElapsedRealtime, jLongValue2, q(mainSdkPackage) ? RedirectEvent.k : "external", str3, foregroundActivity.getClass().getName());
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Logger.d(q, "detect ad click - no interstitial");
                                a(mainSdkPackage, str2, strB, z2 ? RedirectEvent.j : null, stackTraceElementArr);
                                if (jElapsedRealtime2 - jLongValue < 20000) {
                                    Logger.d(q, "detect ad click - updating click URL. address : " + str4);
                                    for (com.safedk.android.analytics.brandsafety.a aVar : Arrays.asList(SafeDK.getInstance().A(), SafeDK.getInstance().C())) {
                                        if (aVar != null && aVar.a(str3, mainSdkPackage, str4, true) && str4 != null) {
                                            l.a[] aVarArr3 = new l.a[2];
                                            aVarArr3[0] = new l.a("url", str3);
                                            aVarArr3[1] = new l.a(l.J, z2 ? RedirectEvent.j : SDKConstants.PARAM_INTENT);
                                            com.safedk.android.analytics.brandsafety.b.a(str4, l.n, aVarArr3);
                                        }
                                    }
                                }
                                String strA3 = t.a(mainSdkPackage, jLongValue);
                                Logger.d(q, "detect ad click - last touch event(elapsed): " + jLongValue + ", last touch event(current time millis): " + jLongValue2 + ", redirectInfoKey: " + strA3);
                                Logger.d(q, "detect ad click - current elapsed realtime: " + jElapsedRealtime2 + ", last touch event(elapsed): " + jLongValue + ", diff: " + (jElapsedRealtime2 - jLongValue));
                                if (SafeDK.b() && !statsCollectorC.a(mainSdkPackage, strA3) && (jLongValue == 0 || jElapsedRealtime2 - jLongValue > iF)) {
                                    a(mainSdkPackage, jElapsedRealtime, jLongValue2, q(mainSdkPackage) ? RedirectEvent.k : "external", str3, foregroundActivity.getClass().getName());
                                    return;
                                } else {
                                    Logger.d(q, "Reporter thread not initialized or stats collector instance is null or redirect info does not exist, skipping");
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Logger.d(q, "detect ad click - Intent doesn't have url");
                    Activity foregroundActivity2 = com.safedk.android.internal.b.getInstance().getForegroundActivity();
                    if (foregroundActivity2 != null) {
                        if (!a(intent)) {
                            a(mainSdkPackage, str2, strB, z2 ? RedirectEvent.j : null, stackTraceElementArr);
                            if (g(foregroundActivity2.getClass().getName())) {
                                Logger.d(q, "detect ad click - current elapsed realtime: " + jElapsedRealtime2 + ", webview last touched: " + jLongValue + ", diff: " + (jElapsedRealtime2 - jLongValue));
                                if (jLongValue == 0 || jElapsedRealtime2 - jLongValue > iF) {
                                    Logger.d(q, "detect ad click - Redirecting through ad");
                                    a(mainSdkPackage, jElapsedRealtime, jLongValue2, q(mainSdkPackage) ? RedirectEvent.k : RedirectEvent.i, str3, foregroundActivity2.getClass().getName());
                                    return;
                                }
                                return;
                            }
                            Logger.d(q, "detect ad click - activity " + foregroundActivity2.getClass().getName() + " is not in the redirect tracked activities, ignoring");
                            return;
                        }
                        return;
                    }
                    Logger.d(q, "detect ad click - current foreground activity is null");
                }
            }
        } catch (Throwable th) {
            Logger.d(q, "error in detect ad click", th);
            new CrashReporter().caughtException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.StringBuilder] */
    private static String a(String str, Intent intent) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        Logger.d(q, "Attempting to extract url from intent extra, sdkPackageName is " + str + ", intent : " + com.safedk.android.utils.n.a(intent));
        ?? string = 0;
        ?? r0 = 0;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null || (adNetworkDiscoveryI = CreativeInfoManager.i(str)) == null) {
                return null;
            }
            List<String> listE = adNetworkDiscoveryI.e();
            Iterator<String> it = listE.iterator();
            ?? r1 = listE;
            while (true) {
                try {
                    r1 = r0;
                    if (!it.hasNext()) {
                        return r1;
                    }
                    String next = it.next();
                    Logger.d(q, "looking for url in intent extra with name : " + next);
                    string = intent.getExtras().getString(next);
                    if (string != 0) {
                        Logger.d(q, "found url in intent : " + string);
                        return string;
                    }
                    r0 = string;
                    r1 = r1;
                } catch (Throwable th) {
                    string = r1;
                }
            }
        } catch (Throwable th2) {
        }
        Logger.e(q, "Exception when attempting to extract url from intent extra");
        return string;
    }

    private static String b(String str, Intent intent) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        Logger.d(q, "Attempting to extract expanded ad webview address from intent extra, sdkPackageName is " + str + ", intent: " + com.safedk.android.utils.n.a(intent));
        if (intent != null) {
            try {
                if (intent.getExtras() != null && (adNetworkDiscoveryI = CreativeInfoManager.i(str)) != null) {
                    return adNetworkDiscoveryI.a(intent.getExtras());
                }
            } catch (Throwable th) {
                Logger.e(q, "Exception when attempting to extract expanded ad webview address from intent extra");
            }
        }
        return null;
    }

    public static void detectAdClick(final Uri uri, final String sdkPackageName) {
        if (com.safedk.android.utils.n.c()) {
            H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.4
                @Override // java.lang.Runnable
                public void run() {
                    BrandSafetyUtils.b(uri, sdkPackageName);
                }
            });
        } else {
            b(uri, sdkPackageName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Uri uri, String str) {
        RedirectDetails redirectDetailsH;
        Logger.d(q, "detect ad click Uri invoked, sdk=" + str + ", url = " + uri.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        if (com.safedk.android.utils.h.i.equals(str) && SafeDK.T()) {
            v vVarA = DetectTouchUtils.a(str);
            long jLongValue = vVarA == null ? 0L : vVarA.f8117a.longValue();
            if ((jLongValue == 0 || SystemClock.elapsedRealtime() - jLongValue > ((long) SafeDK.getInstance().f())) && ((redirectDetailsH = h()) == null || redirectDetailsH.g == null || !redirectDetailsH.g.equals(uri.toString()))) {
                try {
                    throw new Exception("redirect potential source");
                } catch (Exception e2) {
                    Logger.d(q, "detect ad click, redirect potential source", e2);
                }
            }
        }
        a(intent, str, true);
    }

    private static boolean a(Intent intent) {
        int iIdentityHashCode = System.identityHashCode(intent);
        if (u.contains(Integer.valueOf(iIdentityHashCode))) {
            Logger.d(q, "mark intent as handled found " + iIdentityHashCode);
            return true;
        }
        if (u.size() >= 100) {
            Logger.d(q, "mark intent as handled > MAX events");
            u.remove(0);
        }
        Logger.d(q, "mark intent as handled add " + iIdentityHashCode);
        u.add(Integer.valueOf(iIdentityHashCode));
        return false;
    }

    public static void a(String str, String str2, WebView webView) {
        InterstitialFinder interstitialFinderZ;
        try {
            Logger.d(q, "attach loaded url to detected click started, sdk=" + str + ", url=" + str2 + ", webview=" + webView.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            SafeDK safeDK = SafeDK.getInstance();
            if (!SafeDK.ac() || safeDK == null || str2 == null) {
                Logger.d(q, "attach loaded url to detected click loaded url is empty or app not initialized yet, skipping.");
                return;
            }
            if (str2.equals(AndroidWebViewClient.BLANK_PAGE) || str2.equals("About:blank")) {
                Logger.d(q, "url is blank, skipping");
                return;
            }
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
            if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.j(str2)) {
                Logger.d(q, "url should be ignored (by discovery class), skipping");
                return;
            }
            if ((str2.startsWith(com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v) || str2.startsWith("https://")) && (interstitialFinderZ = SafeDK.getInstance().z()) != null) {
                interstitialFinderZ.a(str2, str, a((Object) webView));
            }
            if (SafeDK.b() && StatsCollector.c() != null) {
                ConcurrentHashMap<String, StatsEvent> concurrentHashMapA = StatsCollector.c().a(StatsCollector.EventType.redirect);
                Iterator<String> it = concurrentHashMapA.keySet().iterator();
                while (it.hasNext()) {
                    RedirectEvent redirectEvent = (RedirectEvent) concurrentHashMapA.get(it.next());
                    if (redirectEvent.k().equals(str) && redirectEvent.f() == null) {
                        Logger.d(q, "Attaching url to url-less redirect event. event = " + redirectEvent.toString() + ", url = " + str2);
                        redirectEvent.a(str2);
                    }
                }
                return;
            }
            Logger.d(q, "Reporter thread not initialized or stats collector instance is null, skipping");
        } catch (Throwable th) {
            Logger.e(q, "failed to attach url to detected click (internal browser)", th);
        }
    }

    static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(byteArray, 0, byteArray.length);
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e2) {
            Logger.e(q, "Failed to get hash value for bitmap", e2);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.graphics.Bitmap] */
    static String a(Bitmap bitmap, AdType adType, String str, String str2, String str3, ScreenShotOrientation screenShotOrientation) throws Throwable {
        FileOutputStream fileOutputStream;
        String strA = a(adType, str, str2, str3, screenShotOrientation);
        if (new File(strA).exists()) {
            new File(strA).delete();
            Logger.d(q, "found existing file, deleted : " + strA);
        }
        ?? r1 = q;
        Logger.d(q, "Saving image to file: " + strA);
        try {
            try {
                Logger.d(q, "Saving screenshot to file " + strA);
                fileOutputStream = new FileOutputStream(strA);
                if (fileOutputStream != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        Logger.e(q, "Failed to save screenshot to file, error : " + th.getMessage(), th);
                        if (fileOutputStream == null) {
                            return "";
                        }
                        try {
                            fileOutputStream.close();
                            return "";
                        } catch (IOException e2) {
                            Logger.e(q, "Failed to save screenshot to file (fos close) , error : " + e2.getMessage(), e2);
                            return "";
                        }
                    }
                }
                if (fileOutputStream == null) {
                    return strA;
                }
                try {
                    fileOutputStream.close();
                    return strA;
                } catch (IOException e3) {
                    Logger.e(q, "Failed to save screenshot to file (fos close) , error : " + e3.getMessage(), e3);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e4) {
                        Logger.e(q, "Failed to save screenshot to file (fos close) , error : " + e4.getMessage(), e4);
                        return "";
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static void a(String str, AdType adType, String str2, String str3, String str4, ScreenShotOrientation screenShotOrientation) throws Throwable {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        String strReplace = a(adType, str2, str3, str4, screenShotOrientation).replace(f7972a, b);
        Logger.d(q, "Saving ad text to file: " + strReplace);
        try {
            fileOutputStream = new FileOutputStream(strReplace);
            try {
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Logger.e(q, "Failed to save ad text to file", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static String a(String str, boolean z2) {
        String str2;
        try {
            if (str == null) {
                Logger.d(q, "Parameter name 'activityName' cannot be null");
                str2 = null;
            } else {
                String[] strArrSplit = str.split("@");
                str2 = strArrSplit.length > 1 ? strArrSplit[z2 ? (char) 1 : (char) 0] : "";
            }
            return str2;
        } catch (Throwable th) {
            Logger.e(q, "Failed to get activity address for " + str, th);
            return "";
        }
    }

    static long c(String str) {
        try {
            return new File(str).length();
        } catch (Throwable th) {
            Logger.e(q, "Failed to create new file for screenshot", th);
            return 0L;
        }
    }

    static synchronized void d(String str) {
        if (str != null) {
            Logger.d(q, "remove ad files started, filepath " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (new File(str).exists()) {
                if (!new File(str).delete()) {
                    Logger.d(q, "remove ad files failed to delete file " + str);
                } else {
                    Logger.d(q, "remove ad files deleted file " + str);
                }
            } else {
                Logger.d(q, "remove ad files filePath does not exist. file=" + str);
            }
            File file = new File(str.replace(f7972a, b));
            if (file.exists()) {
                Logger.d(q, "remove ad files deleting file " + file.getAbsolutePath());
                if (!file.delete()) {
                    Logger.d(q, "remove ad files failed to delete file " + file.getAbsolutePath());
                }
            }
        }
    }

    static synchronized void a(AdType adType, String str) {
        Logger.d(q, "remove all ad files started, adType = " + adType.name() + " , impression = " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (str.contains("_")) {
            String str2 = str.split("_")[1];
            File file = new File(SafeDK.getInstance().af() + adType);
            Logger.d(q, "remove all ad files impressionId = " + str2);
            File[] fileArrListFiles = file.listFiles(new b(str2));
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    Logger.d(q, "remove all ad files deleting file for impression " + str2 + " : " + file2.getAbsolutePath());
                    d(file2.getAbsolutePath());
                }
            }
        }
    }

    public static String a(Class cls) {
        return e(cls.getName());
    }

    public static String e(String str) {
        if (str != null) {
            return u(str) ? com.safedk.android.utils.h.h : SdksMapping.getSdkPackageByClass(str);
        }
        return null;
    }

    public static String b(Class cls) {
        String name = cls.getName();
        String strE = e(name);
        if (strE == null) {
            strE = name;
        }
        Logger.v(q, "SDK package for class " + name + " is " + strE);
        return strE == null ? "unknown" : strE;
    }

    public static boolean f(String str) {
        return u(str) || SdksMapping.getSdkPackageByClass(str) != null;
    }

    private static boolean u(String str) {
        return str.startsWith("maps.bi.f") || str.startsWith("avu") || str.startsWith(MobileAds.ERROR_DOMAIN);
    }

    public static a a(String str, Bitmap bitmap) {
        return a(str, bitmap, 1000, AdType.INTERSTITIAL);
    }

    public static a b(String str, Bitmap bitmap) {
        return a(str, bitmap, 500, AdType.BANNER);
    }

    private static a a(String str, Bitmap bitmap, int i2, AdType adType) {
        a aVar = new a();
        Random random = new Random();
        HashMap map = new HashMap();
        float fA = CreativeInfoManager.a(str, AdNetworkConfiguration.BITMAP_SCAN_TOP_MARGIN_PERCENT, 0.2f);
        float fA2 = CreativeInfoManager.a(str, AdNetworkConfiguration.BITMAP_SCAN_RIGHT_MARGIN_PERCENT, 0.2f);
        float fA3 = CreativeInfoManager.a(str, AdNetworkConfiguration.BITMAP_SCAN_LEFT_MARGIN_PERCENT, 0.2f);
        float fA4 = CreativeInfoManager.a(str, AdNetworkConfiguration.BITMAP_SCAN_BOTTOM_MARGIN_PERCENT, 0.2f);
        Logger.d(q, "scanBitmap started, sdkPackage = " + str + ", adType = " + adType.name() + " bitmap scan : margins are : top " + fA + " , right " + fA2 + ", left " + fA3 + ", right " + fA4 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        int width = bitmap.getWidth();
        int i3 = (int) (fA3 * width);
        int i4 = (int) (width - (fA2 * width));
        int height = bitmap.getHeight();
        int i5 = (int) (fA * height);
        int i6 = (int) (height - (height * fA4));
        for (int i7 = 0; i7 < i2; i7++) {
            int pixel = 16777215 & bitmap.getPixel(random.nextInt(i4 - i3) + i3, random.nextInt(i6 - i5) + i5);
            Integer num = (Integer) map.get(Integer.valueOf(pixel));
            if (num == null) {
                map.put(Integer.valueOf(pixel), 1);
            } else {
                map.put(Integer.valueOf(pixel), Integer.valueOf(num.intValue() + 1));
            }
        }
        Iterator it = map.values().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (iIntValue > i8) {
                aVar.a(iIntValue);
            } else {
                iIntValue = i8;
            }
            i8 = iIntValue;
        }
        Integer num2 = (Integer) map.get(0);
        if (num2 != null) {
            aVar.b((num2.intValue() * 100) / i2);
        }
        Integer num3 = (Integer) map.get(Integer.valueOf(x));
        if (num3 != null) {
            aVar.c((num3.intValue() * 100) / i2);
        }
        Integer num4 = (Integer) map.get(Integer.valueOf(y));
        if (num4 != null) {
            aVar.d((num4.intValue() * 100) / i2);
        }
        if (CreativeInfoManager.a(str, AdNetworkConfiguration.BITMAP_SCAN_SHOULD_CHECK_FOR_GREYSCALE, false)) {
            aVar.a(a((Map<Integer, Integer>) map));
        }
        return aVar;
    }

    private static boolean a(Map<Integer, Integer> map) {
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (Color.red(iIntValue) != Color.blue(iIntValue) || Color.blue(iIntValue) != Color.green(iIntValue)) {
                Logger.d(q, "Image is not Greyscale");
                return false;
            }
        }
        Logger.d(q, "Image is Greyscale");
        return true;
    }

    public static boolean a(int i2) {
        return a(i2, 1000, SafeDK.getInstance().G());
    }

    public static boolean b(int i2) {
        return a(i2, 500, SafeDK.getInstance().X());
    }

    public static boolean c(int i2) {
        return b(i2);
    }

    private static boolean a(int i2, int i3, float f2) {
        Logger.d(q, "isScreenshotEnough Max Uniform Pixel Percentage to Stop Sampling is " + f2);
        return ((float) i2) < (f2 / 100.0f) * ((float) i3);
    }

    public static ScreenshotValidity a(String str, a aVar) {
        return a(str, aVar, 1000, CreativeInfoManager.a(str, AdNetworkConfiguration.SDK_SPECIFIC_MIN_UNIFORM_PIXELS_PERCENTAGE_FOR_UNIFORM_IMAGE, SafeDK.getInstance().H()));
    }

    public static ScreenshotValidity b(String str, a aVar) {
        return a(str, aVar, 500, SafeDK.getInstance().Y());
    }

    public static ScreenshotValidity c(String str, a aVar) {
        return b(str, aVar);
    }

    public static ScreenshotValidity a(String str, a aVar, int i2, float f2) {
        Logger.d(q, "screenshot validity check started, number of samples: " + i2 + ", BitmapScanResult: " + aVar);
        if (aVar.b() > 98) {
            Logger.d(q, "screenshot validity check, black pixel percentage is above threshold, image is black (not valid)");
            return ScreenshotValidity.UNIFORMITY_BLACK;
        }
        int iA = (aVar.a() * 100) / i2;
        if (iA > 98) {
            Logger.d(q, "screenshot validity check, uniform pixel count is " + iA + "% => above threshold, image is uniform (not valid)");
            return ScreenshotValidity.UNIFORMITY_VERY_HIGH;
        }
        if (iA > f2) {
            Logger.d(q, "screenshot validity check, uniformity check : Screenshot max color pixel count is above uniformity threshold, image is not valid (result = " + iA + "%)");
            return ScreenshotValidity.UNIFORMITY_HIGH;
        }
        if (aVar.b() > 10 && (aVar.c() > 10 || aVar.d() > 10)) {
            Logger.d(q, "screenshot validity check, black=" + aVar.b() + "% , grey-1=" + aVar.c() + "% , grey-2=" + aVar.d() + "%, => above threshold, image is not valid");
            return ScreenshotValidity.UNIFORMITY_GRAY;
        }
        if (aVar.c() > 50 || aVar.d() > 50) {
            Logger.d(q, "screenshot validity check, grey-1=" + aVar.c() + "%, grey-2=" + aVar.d() + "%  => above threshold, image is not valid");
            return ScreenshotValidity.UNIFORMITY_GRAY;
        }
        if (CreativeInfoManager.a(str, AdNetworkConfiguration.BITMAP_SCAN_SHOULD_CHECK_FOR_GREYSCALE, false)) {
            if (aVar.e()) {
                Logger.d(q, "screenshot validity check, Screenshot is NSFD");
                return ScreenshotValidity.NOT_SUITABLE_FOR_DASHBOARD;
            }
            Logger.d(q, "screenshot validity check, Screenshot is NOT NSFD");
        }
        return ScreenshotValidity.VALID;
    }

    public static String a(AdType adType, String str, String str2, String str3, ScreenShotOrientation screenShotOrientation) {
        String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(str2);
        Logger.d(q, "getFileName Sdk UUID is " + sdkUUIDByPackage + " for sdk " + str2);
        return SafeDK.getInstance().af() + adType + File.separator + str + "_" + sdkUUIDByPackage + "_" + str3 + "_" + screenShotOrientation.name().toLowerCase() + f7972a;
    }

    public static boolean c(Class cls) {
        return g(cls.getName());
    }

    public static boolean g(String str) {
        Logger.d(q, "Internal browser activity check started, Activity name : " + str + ", result : " + s.contains(str) + ", redirectDetectionInterstitialActivities= " + s);
        return s.contains(str);
    }

    public static boolean d(Class cls) {
        return h(cls.getName());
    }

    public static boolean h(String str) {
        Logger.d(q, "Interstitial activity check started, Activity name : " + str + ", result : " + r.contains(str) + ", interstitialActivities= " + r);
        return r.contains(str);
    }

    public static String i(String str) {
        for (String str2 : r) {
            if (str.startsWith(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static com.safedk.android.analytics.brandsafety.c j(String str) {
        if (str != null) {
            Iterator<com.safedk.android.analytics.brandsafety.b> it = SafeDK.getInstance().y().values().iterator();
            while (it.hasNext()) {
                com.safedk.android.analytics.brandsafety.c cVarK = it.next().k(str);
                if (cVarK != null) {
                    return cVarK;
                }
            }
        }
        return null;
    }

    public static com.safedk.android.analytics.brandsafety.c k(String str) {
        if (str != null) {
            Iterator<com.safedk.android.analytics.brandsafety.b> it = SafeDK.getInstance().y().values().iterator();
            while (it.hasNext()) {
                com.safedk.android.analytics.brandsafety.c cVarB = it.next().b(str);
                if (cVarB != null) {
                    return cVarB;
                }
            }
        }
        return null;
    }

    public static void l(String str) {
        Logger.d(q, "addInterstitialActivity started name=" + str);
        r.add(str);
    }

    public static void m(String str) {
        Logger.d(q, "removeInterstitialActivity started name=" + str);
        r.remove(str);
    }

    public static int b(AdType adType) {
        try {
            Logger.d(q, "get image count by ad type started, adType = " + adType.name() + " : " + adType);
            File file = new File(SafeDK.getInstance().af() + adType);
            File[] fileArrListFiles = file.listFiles();
            String str = "";
            for (File file2 : fileArrListFiles) {
                str = str + ", " + file2.getName();
            }
            Logger.d(q, "get image count by ad type all files in " + file.getName() + " : " + str);
            Logger.d(q, "get image count by ad type returned " + fileArrListFiles.length + " for adType " + adType.name());
            return fileArrListFiles.length;
        } catch (Throwable th) {
            Logger.d(q, "get image count by ad type  error :  " + th.getMessage(), th);
            return -1;
        }
    }

    public static List<d> c(AdType adType) {
        ScreenShotOrientation screenShotOrientationValueOf;
        ArrayList arrayList = new ArrayList();
        try {
            Logger.d(q, "Restoring " + adType + " images for upload, isOnUiThread = " + com.safedk.android.utils.n.c());
            File[] fileArrListFiles = new File(SafeDK.getInstance().af() + adType).listFiles(new c());
            if (fileArrListFiles != null) {
                Logger.d(q, "Found " + fileArrListFiles.length + " candidate images for upload");
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    Logger.d(q, "Checking file " + name);
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath.replace(f7972a, b));
                    Logger.d(q, "Deleting file " + file.getAbsolutePath());
                    file.delete();
                    if (file2.exists()) {
                        file2.delete();
                    }
                    String[] strArrSplit = name.replace(f7972a, "").split("_");
                    if (strArrSplit.length == 4) {
                        String str = strArrSplit[0];
                        String sdkPackageByPackageUUID = strArrSplit[1];
                        Logger.d(q, "sdk = " + strArrSplit[1]);
                        if (SdksMapping.getSdkPackageByPackageUUID(strArrSplit[1]) != null) {
                            sdkPackageByPackageUUID = SdksMapping.getSdkPackageByPackageUUID(strArrSplit[1]);
                            Logger.d(q, "sdk value replaced : " + sdkPackageByPackageUUID);
                        }
                        String str2 = strArrSplit[2];
                        try {
                            screenShotOrientationValueOf = ScreenShotOrientation.valueOf(strArrSplit[3].toUpperCase());
                        } catch (IllegalArgumentException e2) {
                            screenShotOrientationValueOf = ScreenShotOrientation.NOT_INITIALIZED;
                        }
                        Logger.d(q, "Restore image for upload: " + absolutePath);
                        arrayList.add(new d(str, sdkPackageByPackageUUID, str2, screenShotOrientationValueOf, absolutePath, null));
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(q, "Error while restoring ads for upload", th);
            new CrashReporter().caughtException(th);
        }
        return arrayList;
    }

    private static void k() {
        DisplayMetrics displayMetrics = SafeDK.getInstance().m().getResources().getDisplayMetrics();
        M = displayMetrics.heightPixels;
        L = displayMetrics.widthPixels;
    }

    static int a() {
        if (L == 0) {
            k();
        }
        return L;
    }

    static int b() {
        if (M == 0) {
            k();
        }
        return M;
    }

    static ScreenShotOrientation c() {
        DisplayMetrics displayMetrics = SafeDK.getInstance().m().getResources().getDisplayMetrics();
        return displayMetrics.heightPixels > displayMetrics.widthPixels ? ScreenShotOrientation.PORTRAIT : ScreenShotOrientation.LANDSCAPE;
    }

    static ScreenShotOrientation b(Bitmap bitmap) {
        if (bitmap == null) {
            return ScreenShotOrientation.NOT_INITIALIZED;
        }
        return bitmap.getHeight() > bitmap.getWidth() ? ScreenShotOrientation.PORTRAIT : ScreenShotOrientation.LANDSCAPE;
    }

    public static String n(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        return Integer.toHexString(obj.hashCode());
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7989a;
        String b;
        String c;
        ScreenShotOrientation d;
        String e;
        String f;

        public d(String str, String str2, String str3, ScreenShotOrientation screenShotOrientation, String str4, String str5) {
            this.f7989a = str;
            this.b = str2;
            this.c = str3;
            this.d = screenShotOrientation;
            this.e = str4;
            this.f = str5;
        }

        public String a() {
            return this.f7989a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public ScreenShotOrientation d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }
    }

    private static void a(String str, long j2, long j3, String str2, String str3, String str4) {
        if (SafeDK.ac()) {
            try {
                Logger.d(q, "Report click url with no impression to server starting, sdkPackageName=" + str + ", url=" + str3 + ", currentForegroundActivityName=" + str4 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                if (!e.a(str)) {
                    Logger.d(q, "Redirect reporting not supported for Sdk " + str + ", report will not be sent");
                } else if (str3 != null) {
                    Uri uri = Uri.parse(str3);
                    if (uri.getScheme() != null && uri.getHost() != null) {
                        if (e.a(str, str3)) {
                            Logger.d(q, "Ignoring this intent as it was already reported , sdkPackageName=" + str + " ,intentUrl=" + str);
                        } else {
                            RedirectEvent redirectEvent = new RedirectEvent(str, str3, str2, str4, j2, j3);
                            redirectEvent.a(p.a().b());
                            if (SafeDK.b()) {
                                StatsCollector.c().a(redirectEvent);
                            } else {
                                Logger.d(q, "Reporter thread not initialized or stats collector instance is null, skipping");
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.e(q, "Exception during attempt to create redirect event", th);
            }
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f7990a = "SdkUrlRedirectManager";
        private static Map<String, Long> b = new HashMap();
        private static int c = 1000;

        private e() {
        }

        private static String b(String str, String str2) {
            return str + "_" + str2;
        }

        private static boolean c(String str, String str2) {
            Logger.d(f7990a, "Check : does timestamp exist for Sdk and url ?  sdkPackageName=" + str + ", url=" + str2 + " , result = " + b.containsKey(b(str, str2)));
            return b.containsKey(b(str, str2));
        }

        private static long d(String str, String str2) {
            Logger.d(f7990a, "getting latest timestamp for Sdk and url started. sdkPackageName=" + str + ", url=" + str2);
            if (c(str, str2)) {
                return b.get(b(str, str2)).longValue();
            }
            return 0L;
        }

        public static boolean a(String str, String str2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            a();
            long jD = d(str, str2);
            Logger.d(f7990a, "Checking if we should ignore the redirect instance sdkPackageName=" + str + ", url=" + str2 + ", timestamp=" + jCurrentTimeMillis + ",System.currentTimeMillis()=" + System.currentTimeMillis() + ", latestTimestamp=" + jD + ", diff=" + (System.currentTimeMillis() - jD));
            if (jD != 0 && System.currentTimeMillis() - jD < c) {
                Logger.d(f7990a, "should ignore this redirect.");
                return true;
            }
            a(str, str2, jCurrentTimeMillis);
            return false;
        }

        private static void a(String str, String str2, long j) {
            Logger.d(f7990a, "Update latest timestamp for Sdk and url started. sdkPackageName=" + str + ", url=" + str2);
            b.put(b(str, str2), Long.valueOf(j));
            Logger.d(f7990a, "timestamps : " + b.toString());
        }

        private static void a() {
            Logger.d(f7990a, "Clear data started, (" + b.size() + ") : " + b.toString());
            ArrayList<String> arrayList = new ArrayList();
            for (String str : b.keySet()) {
                Logger.d(f7990a, "Clear System.currentTimeMillis()-sdkAndUrlToTimestamp.get(key)=" + (System.currentTimeMillis() - b.get(str).longValue()));
                if (System.currentTimeMillis() - b.get(str).longValue() > c) {
                    Logger.d(f7990a, "Added key for removal : " + str);
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                for (String str2 : arrayList) {
                    Logger.d(f7990a, "Removing key " + str2);
                    b.remove(str2);
                }
            }
            Logger.d(f7990a, "Clear data finished, Items (" + b.size() + ") : " + b.toString());
        }

        public static boolean a(String str) {
            String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(str);
            if (sdkUUIDByPackage != null && sdkUUIDByPackage.length() > 0 && SdksMapping.getRedirectSupportedSdks() != null) {
                Logger.d(f7990a, "sdk=" + str + ", sdkUid=" + sdkUUIDByPackage + ", supported ? " + SdksMapping.getRedirectSupportedSdks().contains(sdkUUIDByPackage));
                return SdksMapping.getRedirectSupportedSdks().contains(sdkUUIDByPackage);
            }
            Logger.d(f7990a, "Cannot determine if sdk is redirect detection supported, sdk=" + str);
            return false;
        }
    }

    public static void o(String str) {
        Logger.d(q, "adding to redirect current open fullscreen ad collection. sdk = " + str + ", redirectDetectionCurrentInterstitialBySdk = " + t.toString());
        t.add(str);
    }

    public static void p(String str) {
        Logger.d(q, "removing from redirect current open fullscreen ad collection. sdk = " + str + ", redirectDetectionCurrentInterstitialBySdk = " + t.toString());
        t.remove(str);
    }

    public static boolean q(String str) {
        Logger.d(q, "checking if there is a redirect current open fullscreen ad in collection. sdk = " + str + ", result is " + t.contains(str) + ", redirectDetectionCurrentInterstitialBySdk = " + t.toString());
        return t.contains(str);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f7987a = "BitmapScanResult";
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f = false;

        public int a() {
            return this.b;
        }

        public void a(int i) {
            this.b = i;
        }

        public int b() {
            return this.c;
        }

        public void b(int i) {
            this.c = i;
        }

        public int c() {
            return this.d;
        }

        public void c(int i) {
            this.d = i;
        }

        public int d() {
            return this.e;
        }

        public void d(int i) {
            this.e = i;
        }

        public boolean e() {
            return this.c > 50 && this.f;
        }

        public void a(boolean z) {
            this.f = z;
        }

        public String toString() {
            return "{max count: " + this.b + ", black: " + this.c + "%, gray-1: " + this.d + "%, gray-2: " + this.e + "%}";
        }
    }

    public static String r(String str) {
        byte[] bArr = new byte[0];
        if (new File(str).exists()) {
            byte[] bArr2 = new byte[0];
            try {
                return new BigInteger(1, MessageDigest.getInstance(SameMD5.TAG).digest(a(new File(str)))).toString(16);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return "";
    }

    public static String a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            return new BigInteger(1, MessageDigest.getInstance(SameMD5.TAG).digest(bArr)).toString(16);
        } catch (NoSuchAlgorithmException e2) {
            return "";
        }
    }

    private static byte[] a(File file) {
        byte[] bArr = new byte[100];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    bufferedInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception e2) {
            Logger.d(q, "Exception reading file : " + e2.getMessage(), e2);
            return null;
        }
    }

    public static void onMraidOpen(String sdkPackageName, String urlJsonString, Object obj, String originatedMethod) {
        String strOptString;
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid open, sdk: " + sdkPackageName + ", urlJsonString: " + urlJsonString + ", object: " + obj + ", originated method: " + originatedMethod);
            if (obj != null && urlJsonString != null) {
                try {
                    strOptString = new JSONObject(urlJsonString).optString("url");
                } catch (JSONException e2) {
                    Logger.d(q, "on mraid open, failed to get url from: " + urlJsonString);
                    strOptString = null;
                }
                for (Field field : obj.getClass().getFields()) {
                    try {
                        if (field.get(obj) instanceof WebView) {
                            onMraidOpen(sdkPackageName, null, strOptString, (WebView) field.get(obj), originatedMethod);
                        }
                    } catch (IllegalAccessException e3) {
                        Logger.d(q, "on mraid open, failed to get webview from: " + obj);
                    }
                }
            }
        }
    }

    public static void onMraidOpen(String sdkPackageName, JSONObject urlJsonString, Object obj, String originatedMethod) {
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid open, sdk: " + sdkPackageName + ", urlJsonString: " + urlJsonString + ", object: " + obj + ", originated method: " + originatedMethod);
            if (obj != null && urlJsonString != null) {
                String strOptString = urlJsonString.optString("url");
                Logger.d(q, "on mraid open - url= " + strOptString);
                ArrayList<Field> arrayList = new ArrayList();
                for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
                }
                for (Field field : arrayList) {
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 instanceof WebView) {
                            onMraidOpen(sdkPackageName, null, strOptString, (WebView) obj2, originatedMethod);
                            return;
                        }
                        continue;
                    } catch (IllegalAccessException e2) {
                        Logger.d(q, "on mraid open, failed to get webview from: " + obj);
                    }
                }
            }
        }
    }

    public static void onMraidExpand(String sdkPackageName, String urlJsonString, Object obj, String originatedMethod) {
        String strOptString;
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid expand, sdk: " + sdkPackageName + ", urlJsonString: " + urlJsonString + ", object: " + obj + ", originated method: " + originatedMethod);
            if (obj != null && urlJsonString != null) {
                try {
                    strOptString = new JSONObject(urlJsonString).optString("url");
                } catch (JSONException e2) {
                    Logger.d(q, "on mraid expand, failed to get url from: " + urlJsonString);
                    strOptString = null;
                }
                for (Field field : obj.getClass().getFields()) {
                    try {
                        if (field.get(obj) instanceof WebView) {
                            onMraidExpand(sdkPackageName, null, strOptString, (WebView) field.get(obj), originatedMethod);
                        }
                    } catch (IllegalAccessException e3) {
                        Logger.d(q, "on mraid expand, failed to get webview from: " + obj);
                    }
                }
            }
        }
    }

    public static void onMraidOpen(final String sdkPackageName, String str, final String url, final WebView view, final String originatedMethod) {
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid open, sdk: " + sdkPackageName + ", str: " + str + ", url: " + url + ", webview: " + view + ", originated method: " + originatedMethod);
            if (sdkPackageName != null && url != null) {
                H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BrandSafetyUtils.a(sdkPackageName, view, url, RedirectDetails.RedirectType.REDIRECT, originatedMethod);
                        } catch (Throwable th) {
                            Logger.e(BrandSafetyUtils.q, "exception while handling mraid open", th);
                        }
                    }
                });
            }
        }
    }

    public static void onMraidExpand(final String sdkPackageName, String str, final String url, final WebView view, final String originatedMethod) {
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid expand, sdk: " + sdkPackageName + ", str: " + str + ", url: " + url + ", webview: " + view + ", originated method: " + originatedMethod);
            if (sdkPackageName != null) {
                H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BrandSafetyUtils.a(sdkPackageName, view, url, RedirectDetails.RedirectType.EXPAND, originatedMethod);
                        } catch (Throwable th) {
                            Logger.e(BrandSafetyUtils.q, "exception while handling mraid expand", th);
                        }
                    }
                });
            }
        }
    }

    public static void onMraidProcessExpand(String sdkPackageName, String url) {
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid process expand, sdk: " + sdkPackageName + ", url: " + url);
            a(sdkPackageName, url, (String) null, RedirectEvent.i);
        }
    }

    public static void onMraidWasExpanded(String sdkPackageName) {
        if (SafeDK.ac()) {
            Logger.d(q, "on mraid was expanded, sdk: " + sdkPackageName);
            s(sdkPackageName);
        }
    }

    public static boolean a(String str, WebView webView) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strA = a((Object) webView);
        v vVarA = DetectTouchUtils.a(str, strA);
        long jLongValue = vVarA == null ? 0L : vVarA.f8117a.longValue();
        boolean z2 = jElapsedRealtime - jLongValue < 20000;
        Logger.d(q, "is ad clicked recently - for package: " + str + " and view address: " + strA + " returned: " + z2 + " last touch event: " + jLongValue + " vs current: " + jElapsedRealtime);
        return z2;
    }

    public static void onWebViewPageCommitVisible(String sdkPackage, WebView webView, String url) {
        if (SafeDK.ac()) {
            Logger.d(q, "WebView page commit visible, sdk: " + sdkPackage + ", webView : " + webView.toString() + ", url " + url);
        }
    }

    public static void onWebViewPageStarted(final String sdkPackage, WebView webView, final String url) {
        com.safedk.android.analytics.brandsafety.c cVarB;
        CreativeInfo creativeInfoJ;
        if (SafeDK.ac()) {
            final String strA = a((Object) webView);
            InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
            if (interstitialFinderZ != null && (cVarB = interstitialFinderZ.b(strA)) != null && (creativeInfoJ = cVarB.j()) != null && creativeInfoJ.ao()) {
                Logger.d(q, "WebView page started, ignore url from website end card");
            } else {
                Logger.d(q, "WebView page started, sdk: " + sdkPackage + ", webView : " + webView.toString() + ", url " + url);
                H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.safedk.android.analytics.brandsafety.a aVar;
                        try {
                            x xVar = (x) BrandSafetyUtils.I.get(strA);
                            if (xVar != null && xVar.a().equals(url) && xVar.d().equals(sdkPackage)) {
                                xVar.a(url);
                                Iterator it = Arrays.asList(SafeDK.getInstance().A(), SafeDK.getInstance().z()).iterator();
                                while (it.hasNext() && ((aVar = (com.safedk.android.analytics.brandsafety.a) it.next()) == null || !aVar.a(sdkPackage, xVar))) {
                                }
                                Logger.d(BrandSafetyUtils.q, "handle website opened, started loading: " + BrandSafetyUtils.I);
                                BrandSafetyUtils.b(xVar, strA, "commit");
                            }
                        } catch (Throwable th) {
                            Logger.e(BrandSafetyUtils.q, "exception while WebView page started", th);
                        }
                    }
                });
            }
        }
    }

    public static void onWebViewPageFinished(String sdkPackage, WebView webView, String url) {
        if (SafeDK.ac()) {
            Logger.d(q, "WebView page finished, sdk: " + sdkPackage + ", webView : " + webView.toString() + ", url " + url);
            SafeDKWebAppInterface.a(sdkPackage, webView, url, false);
        }
    }

    public static void onWebViewReceivedError(final String sdkPackage, WebView webView, int errorCode, String description, final String failingUrl) {
        com.safedk.android.analytics.brandsafety.c cVarB;
        CreativeInfo creativeInfoJ;
        if (SafeDK.ac()) {
            final String strA = a((Object) webView);
            InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
            if (interstitialFinderZ != null && (cVarB = interstitialFinderZ.b(strA)) != null && (creativeInfoJ = cVarB.j()) != null && creativeInfoJ.ao()) {
                Logger.d(q, "WebView received error, ignore url from website end card");
            } else {
                Logger.d(q, "WebView received error, sdk: " + sdkPackage + ", webView: " + webView.toString() + ", errorCode: " + errorCode + ", description: " + description + ", failingUrl: " + failingUrl);
                H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            x xVar = (x) BrandSafetyUtils.I.get(strA);
                            if (xVar != null && xVar.a().equals(failingUrl) && xVar.d().equals(sdkPackage)) {
                                BrandSafetyUtils.I.remove(strA);
                                Logger.d(BrandSafetyUtils.q, "handle suspicion of website loaded into banner, load failed: " + BrandSafetyUtils.I);
                                BrandSafetyUtils.b(xVar, strA, b9.f.e);
                            }
                        } catch (Throwable th) {
                            Logger.e(BrandSafetyUtils.q, "exception while WebView received error", th);
                        }
                    }
                });
            }
        }
    }

    public static void onWebViewReceivedError(String sdkPackage, WebView webView, WebResourceRequest request, WebResourceError error) {
        if (SafeDK.ac()) {
            Logger.d(q, "WebView received error, sdk: " + sdkPackage + ", webView: " + webView.toString() + ", request: " + request + ", error: " + error);
            if (Build.VERSION.SDK_INT >= 23) {
                onWebViewReceivedError(sdkPackage, webView, error.getErrorCode(), error.getDescription().toString(), request.getUrl() != null ? request.getUrl().toString() : "");
            } else {
                onWebViewReceivedError(sdkPackage, webView, -1, "", "");
            }
        }
    }

    public static void onShouldOverrideUrlLoading(String sdkPackageName, WebView view, String url, boolean ret) {
        com.safedk.android.analytics.brandsafety.c cVarB;
        CreativeInfo creativeInfoJ;
        if (SafeDK.ac()) {
            Logger.d(q, "on should override url loading, sdk: " + sdkPackageName + ", webview: " + view + ", url: " + url + ", ret: " + ret);
            CreativeInfoManager.a(sdkPackageName, view, url);
            String strA = a((Object) view);
            if (sdkPackageName != null && view != null && url != null) {
                if (ret) {
                    a(sdkPackageName, view, url, strA);
                    return;
                }
                InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
                if (interstitialFinderZ != null && (cVarB = interstitialFinderZ.b(strA)) != null && (creativeInfoJ = cVarB.j()) != null && creativeInfoJ.ao()) {
                    Logger.d(q, "on should override url loading, ignore url from website end card");
                } else {
                    com.safedk.android.analytics.brandsafety.b.a(strA, l.v, new l.a("api", "so"), new l.a("url", url), new l.a(l.Q, "allow"));
                    a(sdkPackageName, url, strA);
                }
            }
        }
    }

    public static void onShouldOverrideUrlLoading(String sdkPackageName, WebView view, WebResourceRequest webResourceRequest, boolean ret) {
        if (SafeDK.ac() && Build.VERSION.SDK_INT >= 21) {
            onShouldOverrideUrlLoading(sdkPackageName, view, webResourceRequest.getUrl().toString(), ret);
        }
    }

    public static void onWebChromeClientCreateWindow(String sdkPackageName, WebView view, Message msg, boolean ret) {
        if (SafeDK.ac() && sdkPackageName != null && view != null && msg != null && ret) {
            WebView webView = ((WebView.WebViewTransport) msg.obj).getWebView();
            Logger.d(q, "on web chrome client create window, sdk: " + sdkPackageName + ", view: " + view + ", transport view: " + webView);
            if (webView != null) {
                J.put(a((Object) webView), new WeakReference<>(view));
            }
        }
    }

    private static void a(final String str, final WebView webView, final String str2, final String str3) {
        H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
                    if (adNetworkDiscoveryI != null) {
                        RedirectDetails.RedirectType redirectTypeK = adNetworkDiscoveryI.k(str2);
                        String strL = adNetworkDiscoveryI.l(str2);
                        Logger.d(BrandSafetyUtils.q, "on should override url loading: target url is: " + strL + " redirect type is: " + redirectTypeK);
                        if (redirectTypeK != null) {
                            BrandSafetyUtils.a(str, webView, strL, redirectTypeK, "shouldOverrideUrlLoading");
                            if (BrandSafetyUtils.a(str, webView)) {
                                Logger.d(BrandSafetyUtils.q, "on should override url loading, updating click URL. address : " + str3);
                                for (com.safedk.android.analytics.brandsafety.a aVar : Arrays.asList(SafeDK.getInstance().A(), SafeDK.getInstance().C())) {
                                    if (aVar != null && aVar.a(strL, str, str3, false)) {
                                        com.safedk.android.analytics.brandsafety.b.a(str3, l.n, new l.a("url", strL), new l.a(l.J, "shouldOverrideUrlLoading"));
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        Logger.d(BrandSafetyUtils.q, "on should override url loading, ignore redirect, sdk: " + str + ", webview: " + webView + ", url: " + str2);
                    }
                } catch (Throwable th) {
                    Logger.e(BrandSafetyUtils.q, "exception while handling potential redirect", th);
                }
            }
        });
    }

    private static void a(final String str, final String str2, final String str3) {
        H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (str2 == null || !str2.startsWith("http")) {
                        return;
                    }
                    for (com.safedk.android.analytics.brandsafety.a aVar : Arrays.asList(SafeDK.getInstance().A(), SafeDK.getInstance().z())) {
                        if (aVar != null) {
                            v vVarA = null;
                            com.safedk.android.analytics.brandsafety.c cVarB = aVar.b(str3);
                            if (cVarB != null && cVarB.c().equals(str)) {
                                k kVarI = cVarB.i();
                                if (kVarI != null) {
                                    kVarI.l();
                                }
                                for (int size = cVarB.x().size() - 1; size >= 0; size--) {
                                    vVarA = DetectTouchUtils.a(str, cVarB.x().get(size));
                                    if (vVarA != null) {
                                        break;
                                    }
                                }
                                x xVar = new x(str, str2, str3, vVarA, cVarB);
                                BrandSafetyUtils.I.put(str3, xVar);
                                Logger.d(BrandSafetyUtils.q, "handle suspicion of website loaded into banner: " + xVar);
                                BrandSafetyUtils.b(xVar, str3, "suspect");
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    Logger.e(BrandSafetyUtils.q, "exception while handling suspicion of website loaded into banner", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(x xVar, String str, String str2) {
        int iH = SafeDK.getInstance().h();
        v vVarF = xVar.f();
        boolean z2 = vVarF != null && SystemClock.elapsedRealtime() - vVarF.f8117a.longValue() < ((long) iH);
        if (vVarF != null) {
            float fElapsedRealtime = ((SystemClock.elapsedRealtime() - vVarF.f8117a.longValue()) / 100) / 10.0f;
            l.a[] aVarArr = new l.a[4];
            aVarArr[0] = new l.a("typ", str2);
            aVarArr[1] = new l.a("url", xVar.a());
            aVarArr[2] = new l.a(l.U, z2 ? "true" : "false");
            aVarArr[3] = new l.a(l.V, String.valueOf(fElapsedRealtime));
            BannerFinder.a(str, "web", aVarArr);
            return;
        }
        BannerFinder.a(str, "web", new l.a("typ", str2), new l.a("url", xVar.a()), new l.a(l.U, "false"));
    }

    public static void a(String str, WebView webView, WebChromeClient webChromeClient) {
        Logger.d(q, "handle set web chrome client, sdk: " + str + ", webview: " + webView + ", chrome client: " + webChromeClient);
        K.put(a(webChromeClient), new WeakReference<>(webView));
    }

    public static void handleOnConsoleMessage(String sdkPackageName, WebChromeClient chromeClient, ConsoleMessage consoleMessage) {
        String strMessage;
        WeakReference<WebView> weakReference;
        if (Build.VERSION.SDK_INT < 8) {
            strMessage = null;
        } else {
            strMessage = consoleMessage.message();
        }
        Logger.d(q, "handle console message, chromeClient: " + chromeClient + ", message: " + strMessage);
        if (strMessage != null && strMessage.contains("mraid.open")) {
            String[] strArrSplit = strMessage.split("\\s+");
            if (strArrSplit.length > 1) {
                String str = strArrSplit[1];
                WeakReference<WebView> weakReference2 = K.get(a(chromeClient));
                if (weakReference2 != null && weakReference2.get() != null) {
                    Logger.d(q, "handle console message, mraid.open detected, sdk: " + sdkPackageName + ", webview: " + weakReference2.get() + ", url: " + str);
                    a(sdkPackageName, weakReference2.get(), str, RedirectDetails.RedirectType.REDIRECT, "OnConsoleMessage");
                    return;
                }
                return;
            }
            return;
        }
        if (com.safedk.android.utils.h.o.equals(sdkPackageName) && strMessage != null && strMessage.contains("mv:") && (weakReference = K.get(a(chromeClient))) != null && weakReference.get() != null) {
            Logger.d(q, "handle console message, mv: message detected, sdk: " + sdkPackageName + ", webview: " + weakReference.get() + ", message: " + strMessage);
            com.safedk.android.analytics.brandsafety.c cVarK = k(a((Object) weakReference.get()));
            if (cVarK != null) {
                cVarK.d("MUR:mv:" + System.currentTimeMillis() + ",msg:" + strMessage);
            }
        }
    }

    public static void handleOnJsPrompt(WebView webview, String s1, String s2, String s3, JsPromptResult result) {
        com.safedk.android.analytics.brandsafety.c cVarK;
        Logger.d(q, "handle JS console, webview: " + webview + ", s1: " + s1 + ", s2: " + s2 + ", s3: " + s3 + ", result: " + result);
        if (webview != null && (cVarK = k(a((Object) webview))) != null) {
            cVarK.d("MUR:js" + System.currentTimeMillis() + ",s1:" + s1 + ",s2:" + s2 + ",s3:" + s3);
        }
    }

    public static synchronized void a(String str, WebView webView, String str2, RedirectDetails.RedirectType redirectType, String str3) {
        synchronized (BrandSafetyUtils.class) {
            SafeDK safeDK = SafeDK.getInstance();
            if (SafeDK.ac() && safeDK != null) {
                String strReplaceAll = str2 != null ? str2.replaceAll("/$", "") : null;
                if (SafeDK.T() && F != null && str2 != null && !F.equals(str2) && !F.equals(strReplaceAll)) {
                    Logger.d(q, "ignore redirect indication, sdk: " + str + ", url: " + str2);
                    F = null;
                } else {
                    WebView webViewA = a(webView);
                    AdType adTypeA = com.safedk.android.analytics.brandsafety.b.a(str, webViewA);
                    if (adTypeA != AdType.INTERSTITIAL) {
                        m();
                        E = new RedirectDetails(str, adTypeA, redirectType, webViewA != null ? a((Object) webViewA) : null, str2, str3, E != null ? E : null);
                        Logger.d(q, "handle redirect: last redirect - " + E);
                        e();
                    } else {
                        Logger.d(q, "handle redirect, ignore interstitial redirect, sdk: " + str + ", url: " + str2);
                    }
                }
            } else {
                Logger.d(q, "handle redirect, Max/SafeDK not initialized, skipping. ");
            }
        }
    }

    private static WebView a(WebView webView) {
        WeakReference<WebView> weakReference = J.get(a((Object) webView));
        WebView webView2 = weakReference != null ? weakReference.get() : null;
        if (webView2 != null) {
            Logger.d(q, "get redirect view, view: " + webView + ", redirect view: " + webView2);
            return webView2;
        }
        return webView;
    }

    public static synchronized void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, str4, (StackTraceElement[]) null);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00af A[Catch: all -> 0x00aa, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000e, B:11:0x0038, B:13:0x003e, B:15:0x0042, B:17:0x006a, B:19:0x0074, B:21:0x007c, B:23:0x0084, B:29:0x00af, B:31:0x00b6, B:32:0x00b8, B:8:0x0014), top: B:34:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b6 A[Catch: all -> 0x00aa, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000e, B:11:0x0038, B:13:0x003e, B:15:0x0042, B:17:0x006a, B:19:0x0074, B:21:0x007c, B:23:0x0084, B:29:0x00af, B:31:0x00b6, B:32:0x00b8, B:8:0x0014), top: B:34:0x0004 }] */
    public static synchronized void a(String str, String str2, String str3, String str4, StackTraceElement[] stackTraceElementArr) {
        synchronized (BrandSafetyUtils.class) {
            String mainSdkPackage = SdksMapping.getMainSdkPackage(str);
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(mainSdkPackage);
            if (adNetworkDiscoveryI == null || adNetworkDiscoveryI.k(str2) == null) {
                Logger.d(q, "handle redirect, ignore intent for sdk: " + mainSdkPackage + ", url: " + str2);
            } else if (SafeDK.T() && G != null) {
                String strL = adNetworkDiscoveryI.l(str2);
                Logger.d(q, "handle redirect, sdk: " + mainSdkPackage + ", extracted url: " + strL);
                String strReplaceAll = str2 != null ? str2.replaceAll("/$", "") : null;
                if (strL != null && !G.equals(strL) && !G.equals(strReplaceAll)) {
                    Logger.d(q, "handle redirect, ignore intent for sdk: " + mainSdkPackage + ", url: " + strL);
                    G = null;
                } else {
                    l();
                    D = new m(mainSdkPackage, str2, str3, str4, D != null ? D : null, stackTraceElementArr);
                    Logger.d(q, "handle redirect, last intent details: " + D);
                    e();
                }
            } else {
                l();
                D = new m(mainSdkPackage, str2, str3, str4, D != null ? D : null, stackTraceElementArr);
                Logger.d(q, "handle redirect, last intent details: " + D);
                e();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    public static synchronized String d() {
        String str;
        synchronized (BrandSafetyUtils.class) {
            m();
            l();
            if (E != null && D != null && D.c != null && D.c.equals(E.c)) {
                boolean zA = CreativeInfoManager.a(E.c, AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, false);
                if (E.e == RedirectDetails.RedirectType.REDIRECT && zA) {
                    v vVarA = DetectTouchUtils.a(D.c, E.f);
                    long jLongValue = vVarA == null ? 0L : vVarA.f8117a.longValue();
                    if (jLongValue == 0 || SystemClock.elapsedRealtime() - jLongValue > ((long) SafeDK.getInstance().f())) {
                        Logger.d(q, "check for potential auto redirect, identified for " + D.c + ", view address: " + E.f + ", webviewReqURL: " + E.g + ", landingPageURL: " + D.d);
                        str = D.d;
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                }
            } else {
                str = null;
            }
        }
        return str;
    }

    public static synchronized void e() {
        BannerFinder bannerFinder;
        m();
        l();
        if (E != null && D != null) {
            if (D.c != null && D.c.equals(E.c)) {
                a(D.c, true, false);
            }
        } else if (D != null && com.safedk.android.utils.h.o.equals(D.c) && (bannerFinder = (BannerFinder) SafeDK.getInstance().a(AdType.BANNER)) != null) {
            bannerFinder.a(D);
        }
    }

    public static synchronized void f() {
        m();
        l();
        if (E != null && D != null && E.e == RedirectDetails.RedirectType.EXPAND && D.c != null && D.c.equals(E.c) && CreativeInfoManager.a(E.c, AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION_BY_MAX_EVENT, false)) {
            a(D.c, false, true);
        }
    }

    public static synchronized void g() {
        m();
        l();
        if (E != null && D != null && D.c != null && D.c.equals(E.c)) {
            a(D.c, true, true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    public static synchronized com.safedk.android.analytics.brandsafety.e s(String str) {
        com.safedk.android.analytics.brandsafety.e eVarA;
        m();
        l();
        if (E == null || D == null) {
            eVarA = null;
        } else {
            Logger.d(q, "handle redirect if needed with sdk: " + str);
            if (str != null && str.equals(D.c) && str.equals(E.c)) {
                eVarA = a(str, false, true);
            } else {
                eVarA = null;
            }
        }
        return eVarA;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    public static synchronized com.safedk.android.analytics.brandsafety.e a(Activity activity) {
        com.safedk.android.analytics.brandsafety.e eVarA;
        m();
        l();
        if (E == null || D == null) {
            eVarA = null;
        } else {
            String sdkPackageByClass = SdksMapping.getSdkPackageByClass(activity.toString());
            Logger.d(q, "handle redirect if needed with activity sdk: " + sdkPackageByClass);
            if (sdkPackageByClass != null && sdkPackageByClass.equals(D.c) && sdkPackageByClass.equals(E.c)) {
                eVarA = a(sdkPackageByClass, false, true);
            } else {
                eVarA = null;
            }
        }
        return eVarA;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0125 A[Catch: all -> 0x017f, TryCatch #0 {, blocks: (B:4:0x0004, B:10:0x006a, B:7:0x0060, B:13:0x009e, B:15:0x00a4, B:17:0x0118, B:19:0x0125, B:20:0x012b, B:21:0x0130, B:23:0x013a, B:25:0x0144, B:27:0x014a, B:32:0x0182, B:34:0x018c), top: B:37:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x01ff  */
    private static synchronized com.safedk.android.analytics.brandsafety.e a(String str, boolean z2, boolean z3) {
        com.safedk.android.analytics.brandsafety.c cVarA;
        List<CreativeInfo> listA;
        com.safedk.android.analytics.brandsafety.e eVar = null;
        synchronized (BrandSafetyUtils.class) {
            Logger.d(q, "handle redirect report: last redirect name: " + E.e.name().toLowerCase() + ", intent: " + D + ", redirect: " + E);
            boolean zA = CreativeInfoManager.a(E.c, AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, false);
            boolean zA2 = CreativeInfoManager.a(E.c, AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, false);
            if ((E.e == RedirectDetails.RedirectType.REDIRECT && !zA2) || (E.e == RedirectDetails.RedirectType.EXPAND && !zA)) {
                Logger.d(q, "handle " + E.e.name().toLowerCase() + " is not supported for: " + E.c);
            } else if (E.d != null) {
                Logger.d(q, "handle " + E.e.name().toLowerCase() + ", for " + str + " " + E.d + ", view address: " + E.f + ", webviewReqURL: " + E.g + ", landingPageURL: " + D.d);
                com.safedk.android.analytics.brandsafety.a aVarA = SafeDK.getInstance().a(E.d);
                if (aVarA != null) {
                    cVarA = aVarA.a(str, E, D, z2, z3);
                } else {
                    cVarA = null;
                }
                if (z3) {
                    E = null;
                    D = null;
                }
                eVar = (com.safedk.android.analytics.brandsafety.e) cVarA;
            } else {
                InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
                if (interstitialFinderZ != null && (listA = interstitialFinderZ.a(str, E.f)) != null && !listA.isEmpty()) {
                    Logger.d(q, "handle " + E.e.name().toLowerCase() + ", redirect details belong to an interstitial ad, drop it: " + E);
                    E = null;
                } else {
                    BannerFinder bannerFinderA = SafeDK.getInstance().A();
                    if (bannerFinderA != null) {
                        Logger.d(q, "handle " + E.e.name().toLowerCase() + ", for " + str + " " + bannerFinderA.a() + ", view address: " + E.f + ", webviewReqURL: " + E.g + ", landingPageURL: " + D.d);
                        cVarA = bannerFinderA.a(str, E, D, z2, z3);
                    } else {
                        cVarA = null;
                    }
                    if (z3) {
                        E = null;
                        D = null;
                    }
                    eVar = (com.safedk.android.analytics.brandsafety.e) cVarA;
                }
            }
        }
        return eVar;
    }

    private static void l() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iG = SafeDK.getInstance().g();
        if (D != null && jElapsedRealtime - D.b.longValue() > iG) {
            Logger.d(q, "remove old intent: " + D);
            D = null;
        }
    }

    private static void m() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iG = SafeDK.getInstance().g();
        if (E != null && jElapsedRealtime - E.b.longValue() > iG) {
            Logger.d(q, "remove old redirect: " + E);
            E = null;
        }
    }

    public static RedirectDetails h() {
        m();
        return E;
    }

    public static void t(String str) {
        if (SafeDK.T()) {
            F = str;
            G = str;
        }
    }

    public static void i() {
        F = null;
        G = null;
    }

    public static AdType a(long j2, long j3) {
        if (com.safedk.android.utils.n.a(j2, j3)) {
            Logger.d(q, "get ad type, banner identified");
            return AdType.BANNER;
        }
        if (com.safedk.android.utils.n.b(j2, j3)) {
            Logger.d(q, "get ad type, mrec identified");
            return AdType.MREC;
        }
        Logger.d(q, "get ad type, inter identified");
        return AdType.INTERSTITIAL;
    }

    public static void b(Activity activity) {
        Logger.d(q, "report landing page loaded. activity: " + activity);
        n nVarQ = SafeDK.getInstance().z().q(SdksMapping.getSdkPackageByClass(activity.getClass().getName()));
        if (nVarQ != null && nVarQ.an) {
            nVarQ.i().a(l.r, new l.a("ads", Integer.toString(SafeDK.getInstance().A().j() + 1 + SafeDK.getInstance().C().f())), new l.a(l.T, activity.getClass().getCanonicalName()));
        }
    }

    public static void c(Activity activity) {
        Logger.d(q, "report landing page removed. activity: " + activity);
        n nVarQ = SafeDK.getInstance().z().q(SdksMapping.getSdkPackageByClass(activity.getClass().getName()));
        if (nVarQ != null && nVarQ.an) {
            nVarQ.i().a(l.s, new l.a[0]);
        }
    }

    public static void onMobileFuseSetState(String state) {
        Logger.d(q, "on mobilefuse set state - state= " + state);
        if (!TextUtils.isEmpty(state) && state.equals("EXPANDED")) {
            Logger.d(q, "on mobilefuse set state - calling handle redirect (intent)");
            a(com.safedk.android.utils.h.E, (String) null, (String) null, RedirectEvent.i);
        }
    }

    public static void onMobileFuseFullscreenChanged(boolean isChanged) {
        Logger.d(q, "on mobilefuse fullscreen changed - is changed= " + isChanged);
        if (SafeDK.ac() && isChanged) {
            Logger.d(q, "on mobilefuse fullscreen changed - calling handle redirect");
            s(com.safedk.android.utils.h.E);
        }
    }

    public static void onBidMachineOnExpandIntention(WebView expandedWebview) {
        Logger.d(q, "on bidMachine on expand intention - calling handle redirect (intent), expanded webview: " + expandedWebview);
        a("io.bidmachine", (String) null, a((Object) expandedWebview), RedirectEvent.i);
    }

    public static void onBidMachineOnExpanded() {
        Logger.d(q, "on bidMachine on expanded - calling handle redirect (intent)");
        a("io.bidmachine", (String) null, (String) null, RedirectEvent.i);
    }

    public static void onBidMachineOnClose() {
        Logger.d(q, "on bidMachine on close - calling handle redirect");
        if (SafeDK.ac()) {
            s("io.bidmachine");
        }
    }

    public static void onMintegralNativeController(final Object instance, final JSONObject object) {
        Logger.d(q, "on mintegral native controller - instance= " + instance);
        if (instance != null && object != null) {
            H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.11
                @Override // java.lang.Runnable
                public void run() {
                    com.safedk.android.analytics.brandsafety.creatives.discoveries.k.a(instance, object);
                }
            });
        }
    }

    public static void onPubmaticNativeCall(final WebView webview, final String message) {
        Logger.d(q, "on pubmatic native call - webview: " + webview + ", message:" + message);
        H.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BrandSafetyUtils.2
            @Override // java.lang.Runnable
            public void run() {
                RedirectDetails.RedirectType redirectType;
                try {
                    JSONObject jSONObject = new JSONObject(message);
                    String string = jSONObject.getString("name");
                    if (string.equals("open")) {
                        redirectType = RedirectDetails.RedirectType.REDIRECT;
                    } else if (string.equals("expand")) {
                        redirectType = RedirectDetails.RedirectType.EXPAND;
                    } else {
                        return;
                    }
                    BrandSafetyUtils.a(com.safedk.android.utils.h.F, webview, jSONObject.getJSONObject("params").getString("url"), redirectType, "NativeCall");
                } catch (Exception e2) {
                    Logger.d(BrandSafetyUtils.q, "on pubmatic native call - webview: " + webview + ", failed to parse message", e2);
                }
            }
        });
    }
}
