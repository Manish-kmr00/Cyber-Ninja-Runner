package net.pubnative.lite.sdk.views.shape.path.parser;

import java.io.InputStream;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes4.dex */
public class IoUtil {
    public static final void closeQuitely(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th) {
                HyBid.reportException(th);
            }
        }
    }
}
