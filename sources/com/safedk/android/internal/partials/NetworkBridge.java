package com.safedk.android.internal.partials;

import android.text.TextUtils;
import android.webkit.WebView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.internal.f;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class NetworkBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8143a = "javascript:";
    public static ConcurrentHashMap<HttpURLConnection, f> b = new ConcurrentHashMap<>();
    static final ExecutorService c = Executors.newFixedThreadPool(3);
    public static ConcurrentHashMap<Integer, RequestInfo> d = new ConcurrentHashMap<>();
    private static final String e = "SafeDKNetwork";
    private static final String f = "";

    public static class RequestInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8145a;
        private String b;
        private String c = null;
        private ByteArrayOutputStream d = new ByteArrayOutputStream();

        public RequestInfo(String sdkPackageName, String url) {
            this.f8145a = null;
            this.b = null;
            this.f8145a = sdkPackageName;
            this.b = url;
        }

        public String a() {
            return this.f8145a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            if (this.c == null) {
                this.c = this.d.toString();
            }
            return this.c;
        }

        public boolean d() {
            return (TextUtils.isEmpty(this.f8145a) || TextUtils.isEmpty(this.b)) ? false : true;
        }

        public void a(byte[] bArr, long j) {
            this.d.write(bArr, 0, (int) j);
        }

        public String toString() {
            return "Info{" + this.f8145a + " " + this.b + "}";
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public static void disposeOfConnectionToStreamMapping(HttpURLConnection connection) {
        try {
            b.remove(connection);
        } catch (Throwable th) {
            Logger.e(e, "Caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    public static void logWebviewLoadURLRequest(final String sdk, final WebView webview, final String url) {
        if (TextUtils.isEmpty(url) || url.startsWith("javascript:")) {
            Logger.d(e, "logWebviewLoadURLRequest loadUrl url is null or a javascript command : " + url);
            return;
        }
        Logger.d("logWebviewLoadURLRequest webview", "loadUrl " + webview.getId() + ", webview class name=" + webview.getClass().getCanonicalName() + ", WebView address : " + webview.toString() + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME = ");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (n.c()) {
                c.submit(new Runnable() { // from class: com.safedk.android.internal.partials.NetworkBridge.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkBridge.b(sdk, webview, url);
                    }
                });
            } else {
                b(sdk, webview, url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, WebView webView, String str2) {
        try {
            Logger.d("logWebviewLoadURLRequestImpl webview", "loadUrl " + webView.getId() + ", webview class name=" + webView.getClass().getCanonicalName() + ", WebView address : " + webView.toString() + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME = ");
            Logger.d(e, "logWebviewLoadURLRequest: " + str2);
            if (str2 != null) {
                BrandSafetyUtils.a(str, str2, webView);
            }
        } catch (Throwable th) {
            Logger.e(e, "caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    public static Object invokeMethod(String className, String methodName, Object targetInstance, Class[] parametersTypes, Object[] paramaterValues) throws IOException {
        try {
            Method declaredMethod = Class.forName(className).getDeclaredMethod(methodName, parametersTypes);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(targetInstance, paramaterValues);
        } catch (ClassNotFoundException e2) {
            throw new IOException("Network access denied", e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IOException("Network access denied", e3.getCause());
        } catch (NoSuchMethodException e4) {
            throw new IOException("Network access denied", e4.getCause());
        } catch (InvocationTargetException e5) {
            throw new IOException("Network access denied", e5.getCause());
        } catch (Throwable th) {
            new CrashReporter().caughtException(th);
            throw new IOException("error occurred while trying to access network");
        }
    }
}
