package com.safedk.android.internal.partials;

import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: OkHttpSourceFile */
/* JADX INFO: loaded from: classes3.dex */
public class OkHttpNetworkBridge {
    public static BufferedSource retrofitExceptionCatchingRequestBody_source(ResponseBody targetInstance) {
        Logger.d("OkHttpNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/OkHttpNetworkBridge;->retrofitExceptionCatchingRequestBody_source(Lokhttp3/ResponseBody;)Lokio/BufferedSource;");
        BufferedSource bufferedSourceSource = targetInstance.getSource();
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                int iIdentityHashCode = System.identityHashCode(targetInstance);
                Logger.d("SafeDKNetwork", "retrofit|retrofitExceptionCatchingRequestBody_source bodyId " + iIdentityHashCode + " retroReq " + NetworkBridge.d + ", isOnUiThread = " + n.c());
                NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(iIdentityHashCode));
                if (requestInfo != null) {
                    bufferedSourceSource = CreativeInfoManager.a(requestInfo.a(), requestInfo.b(), bufferedSourceSource, iIdentityHashCode);
                    Logger.d("SafeDKNetwork", "retrofit|retrofitExceptionCatchingRequestBody_source found responseBodyId:" + iIdentityHashCode + ", RequestInfo:" + requestInfo + ", returning Source: " + bufferedSourceSource);
                }
                return bufferedSourceSource;
            } catch (Throwable th) {
                Logger.d("SafeDKNetwork", "retrofit|retrofitExceptionCatchingRequestBody_source error " + th.getMessage());
                return bufferedSourceSource;
            }
        }
        return bufferedSourceSource;
    }
}
