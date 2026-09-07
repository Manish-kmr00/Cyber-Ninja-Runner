package com.smaato.sdk.core.network.interceptors;

import com.smaato.sdk.core.network.HttpNoResponseBodyException;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.Response;
import com.smaato.sdk.core.network.SomaException;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes13.dex */
public class HttpStatusToExceptionInterceptor implements Interceptor {
    @Override // com.smaato.sdk.core.network.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        try {
            Response responseProceed = chain.proceed(chain.request());
            if (204 != responseProceed.responseCode()) {
                return responseProceed;
            }
            throw new SomaException(SomaException.Type.NO_CONTENT, "Server returned HTTP response code: 204 for URL: " + responseProceed.request().uri());
        } catch (HttpNoResponseBodyException e) {
            int responseCode = e.getResponseCode();
            if (400 <= responseCode && responseCode < 420) {
                throw new SomaException(SomaException.Type.BAD_REQUEST, e.getCause());
            }
            if (500 <= responseCode && responseCode < 510) {
                throw new SomaException(SomaException.Type.BAD_RESPONSE, e.getCause());
            }
            throw e;
        } catch (SocketTimeoutException e2) {
            throw new SomaException(SomaException.Type.TIMEOUT_ERROR, e2);
        }
    }
}
