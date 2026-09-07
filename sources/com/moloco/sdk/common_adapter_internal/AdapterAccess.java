package com.moloco.sdk.common_adapter_internal;

import android.content.Context;
import com.moloco.sdk.Init;
import com.moloco.sdk.internal.android_context.b;
import com.moloco.sdk.internal.n;
import com.moloco.sdk.internal.scheduling.DispatcherProvider;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.UserAgentService;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J(\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0012\u0010\u0019\u001a\u00020\u0013*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c¨\u0006\u001d"}, d2 = {"Lcom/moloco/sdk/common_adapter_internal/AdapterAccess;", "", "()V", "ApplicationContext", "Landroid/content/Context;", "context", "DispatcherProvider", "Lcom/moloco/sdk/internal/scheduling/DispatcherProvider;", "HttpClient", "Lio/ktor/client/HttpClient;", "UserAgentService", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/UserAgentService;", "screenData", "Lcom/moloco/sdk/common_adapter_internal/ScreenData;", "sessionData", "Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "adUnitId", "", "appendMolocoUserAgent", "", "Lio/ktor/http/HeadersBuilder;", "molocoSdkVersion", "androidOSVersion", "mediationInfo", "Lcom/moloco/sdk/publisher/MediationInfo;", "httpRequestTimeoutMillis", "Lio/ktor/client/request/HttpRequestBuilder;", "millis", "", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdapterAccess {
    public static final int $stable = 0;
    public static final AdapterAccess INSTANCE = new AdapterAccess();

    public static /* synthetic */ Context ApplicationContext$default(AdapterAccess adapterAccess, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return adapterAccess.ApplicationContext(context);
    }

    public static /* synthetic */ ScreenData screenData$default(AdapterAccess adapterAccess, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = ApplicationContext$default(adapterAccess, null, 1, null);
        }
        return adapterAccess.screenData(context);
    }

    @JvmStatic
    public static final AdapterSessionData sessionData(String adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Init.SDKInitResponse sDKInitResponseA = a.f.f6470a.b().a();
        if (sDKInitResponseA != null) {
            return AdapterAccessKt.a(sDKInitResponseA, adUnitId);
        }
        return null;
    }

    public final Context ApplicationContext(Context context) {
        return b.a(context);
    }

    public final DispatcherProvider DispatcherProvider() {
        return com.moloco.sdk.internal.scheduling.b.a();
    }

    public final HttpClient HttpClient() {
        return a.i.f6483a.a();
    }

    public final UserAgentService UserAgentService() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.core.b.a();
    }

    public final void appendMolocoUserAgent(HeadersBuilder headersBuilder, String str, String str2, MediationInfo mediationInfo) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        n.a(headersBuilder, str, str2, mediationInfo);
    }

    public final void httpRequestTimeoutMillis(HttpRequestBuilder httpRequestBuilder, long j) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, j);
    }

    public final ScreenData screenData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return q.a(context).invoke();
    }
}
