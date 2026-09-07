package com.fyber.inneractive.sdk.util;

import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.EnumC3138n;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3255t {
    public static String b(HttpURLConnection httpURLConnection) throws Exception {
        int iHttpUrlConnectionGetResponseCode = DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
        if (iHttpUrlConnectionGetResponseCode != 302 && iHttpUrlConnectionGetResponseCode != 303 && iHttpUrlConnectionGetResponseCode != 307) {
            return null;
        }
        IAlog.a("getRedirectUrl: received redirect code %s", Integer.toString(iHttpUrlConnectionGetResponseCode));
        String headerField = httpURLConnection.getHeaderField(EnumC3138n.LOCATION.a());
        if (TextUtils.isEmpty(headerField)) {
            throw new Exception("Server returned HTTP " + Integer.toString(iHttpUrlConnectionGetResponseCode) + " with empty location header!");
        }
        IAlog.a("getRedirectUrl: redirecting target url: %s", headerField);
        return headerField;
    }

    public static boolean a() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static String a(String str, int i, int i2) throws Exception {
        String string;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.connect();
            FilterInputStream filterInputStreamA = a(httpURLConnection);
            String strB = b(httpURLConnection);
            if (!TextUtils.isEmpty(strB)) {
                DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                return a(strB, i2, i);
            }
            int iHttpUrlConnectionGetResponseCode = DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
            if (iHttpUrlConnectionGetResponseCode != 200) {
                IAlog.a("isResponseValid: found invalid response status: %s", Integer.toString(iHttpUrlConnectionGetResponseCode));
                string = null;
            } else {
                string = AbstractC3256u.a((InputStream) filterInputStreamA).toString();
            }
            DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            return string;
        } catch (Exception e) {
            IAlog.a("getBodyFromUrl failed with exception", e, new Object[0]);
            throw e;
        } catch (Throwable th) {
            IAlog.a("getBodyFromUrl failed with error", th, new Object[0]);
            return null;
        }
    }

    public static FilterInputStream a(HttpURLConnection httpURLConnection) {
        FilterInputStream bufferedInputStream;
        try {
            InputStream inputStreamUrlConnectionGetInputStream = DTExchangeNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
            if (TextUtils.equals("gzip", httpURLConnection.getContentEncoding())) {
                bufferedInputStream = new GZIPInputStream(inputStreamUrlConnectionGetInputStream);
            } else {
                bufferedInputStream = new BufferedInputStream(inputStreamUrlConnectionGetInputStream);
            }
            return bufferedInputStream;
        } catch (Exception unused) {
            return null;
        }
    }
}
