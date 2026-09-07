package okhttp3;

import com.safedk.android.internal.partials.NetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.annotations.PartialClassExtension;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import java.io.IOException;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: OkHttpSourceFile */
/* JADX INFO: loaded from: classes6.dex */
@PartialClassExtension(partialName = AndroidInitializeBoldSDK.MSG_NETWORK)
public class OkHttpOkHttp3Extension {
    public static Response okhttp3RealCall_getResponseWithInterceptorChain$okhttp(RealCall targetInstance) throws IOException {
        Logger.d("OkHttpNetwork|SafeDK: Partial-Network> Lokhttp3/OkHttpOkHttp3Extension;->okhttp3RealCall_getResponseWithInterceptorChain$okhttp(Lokhttp3/internal/connection/RealCall;)Lokhttp3/Response;");
        Response responseWithInterceptorChain$okhttp = targetInstance.getResponseWithInterceptorChain$okhttp();
        try {
            int iIdentityHashCode = System.identityHashCode(targetInstance.request());
            NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(iIdentityHashCode));
            Logger.d("SafeDKNetwork", "retrofit|okhttp3 RealCall.getResponseWithInterceptorChain$okhttp reqId:" + iIdentityHashCode + ", RequestInfo:" + requestInfo);
            if (requestInfo != null) {
                int iIdentityHashCode2 = System.identityHashCode(responseWithInterceptorChain$okhttp);
                NetworkBridge.d.put(Integer.valueOf(iIdentityHashCode2), requestInfo);
                Logger.d("SafeDKNetwork", "retrofit|okhttp3 RealCall.getResponseWithInterceptorChain$okhttp replace reqId:" + iIdentityHashCode + ", RequestInfo:" + requestInfo + " - with response id" + iIdentityHashCode2);
            } else {
                Logger.d("SafeDKNetwork", "retrofit|okhttp3 RealCall.getResponseWithInterceptorChain$okhttp, skipping response Id:" + iIdentityHashCode);
            }
        } catch (Throwable th) {
            Logger.d("SafeDKNetwork", "retrofit|okhttp3 RealCall.getResponseWithInterceptorChain$okhttp error " + th.getMessage());
        }
        return responseWithInterceptorChain$okhttp;
    }
}
