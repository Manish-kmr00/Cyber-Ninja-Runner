package com.smaato.sdk.nativead.model.soma;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class NativeAdInterceptor implements Interceptor {
    @Override // com.smaato.sdk.core.network.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request.buildUpon().uri(request.uri().buildUpon().appendQueryParameter("nver", POBNativeConstants.NATIVE_DEFAULT_VERSION).appendQueryParameter("nsupport", "title,txt,icon,image,ctatext,starrating").build()).build());
    }
}
