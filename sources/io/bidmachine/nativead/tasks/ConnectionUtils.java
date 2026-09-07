package io.bidmachine.nativead.tasks;

import android.net.Uri;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.bidmachine.core.Logger;
import io.bidmachine.nativead.utils.NoSSLv3SocketFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes3.dex */
class ConnectionUtils {
    ConnectionUtils() {
    }

    static InputStream getInputStream(String str, int i) throws Exception {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(i);
            uRLConnectionOpenConnection.setReadTimeout(i);
            setupNoSSLv3(uRLConnectionOpenConnection);
            uRLConnectionOpenConnection.connect();
            return BidMachineNetworkBridge.urlConnectionGetInputStream(uRLConnectionOpenConnection);
        } catch (Exception unused) {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.scheme("http");
            URLConnection uRLConnectionOpenConnection2 = new URL(builderBuildUpon.build().toString()).openConnection();
            uRLConnectionOpenConnection2.setConnectTimeout(i);
            uRLConnectionOpenConnection2.setReadTimeout(i);
            uRLConnectionOpenConnection2.connect();
            return BidMachineNetworkBridge.urlConnectionGetInputStream(uRLConnectionOpenConnection2);
        }
    }

    private static void setupNoSSLv3(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
                httpsURLConnection.setSSLSocketFactory(new NoSSLv3SocketFactory(httpsURLConnection.getSSLSocketFactory()));
            }
        } catch (Exception e) {
            Logger.w(e);
        }
    }
}
