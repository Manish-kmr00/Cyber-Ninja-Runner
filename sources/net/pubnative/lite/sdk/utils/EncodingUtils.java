package net.pubnative.lite.sdk.utils;

import com.json.cc;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes5.dex */
public class EncodingUtils {
    private static final String TAG = "EncodingUtils";

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, cc.N);
        } catch (UnsupportedEncodingException e) {
            HyBid.reportException((Exception) e);
            Logger.e(TAG, "Error url encoding string: ", e);
            return "";
        }
    }
}
