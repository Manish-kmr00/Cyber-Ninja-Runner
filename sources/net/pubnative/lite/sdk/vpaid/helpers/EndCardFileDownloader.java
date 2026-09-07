package net.pubnative.lite.sdk.vpaid.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.safedk.android.internal.partials.VerveNetworkBridge;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public class EndCardFileDownloader {
    private static final String TAG = "EndCardFileDownloader";

    /* JADX WARN: Code duplicated, block: B:22:0x003f  */
    public static Bitmap mLoad(String str) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        URL urlMStringToURL = mStringToURL(str);
        if (urlMStringToURL == null) {
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) urlMStringToURL.openConnection();
            try {
                try {
                    httpURLConnection.connect();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new BufferedInputStream(VerveNetworkBridge.urlConnectionGetInputStream(httpURLConnection)));
                    if (httpURLConnection != null) {
                        VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                    }
                    return bitmapDecodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                Logger.e(TAG, e.getMessage());
                if (httpURLConnection != null) {
                    VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                }
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            }
            throw th;
        }
    }

    private static URL mStringToURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }
}
