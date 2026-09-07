package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends WebViewClientCompat implements g {
    public static final a m = new a(null);
    public static final String n = "WebViewClientImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f6682a;
    public final s b;
    public final h c;
    public final MutableStateFlow<Boolean> d;
    public final StateFlow<Boolean> e;
    public final MutableStateFlow<Boolean> f;
    public final StateFlow<Boolean> g;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> h;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> i;
    public final MutableSharedFlow<Unit> j;
    public final SharedFlow<Unit> k;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.WebViewClientImpl$shouldOverrideUrlLoading$1$1$1", f = "WebViewClientImpl.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6683a;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6683a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar = c.this.b;
                String str = this.c;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar = this.d;
                h hVarE = c.this.e();
                MutableSharedFlow<Unit> mutableSharedFlow = c.this.j;
                this.f6683a = 1;
                if (sVar.a(str, aVar, hVarE, mutableSharedFlow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ c(CoroutineScope coroutineScope, s sVar, h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, sVar, (i & 4) != 0 ? j.a() : hVar);
    }

    public static /* synthetic */ void l() {
    }

    public final void c() {
        this.d.setValue(Boolean.TRUE);
    }

    public final h e() {
        return this.c;
    }

    public final SharedFlow<Unit> h() {
        return this.k;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a i() {
        return this.l;
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> m() {
        return this.i;
    }

    public final StateFlow<Boolean> o() {
        return this.e;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.D, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/staticrenderer/c;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.D, webView, str);
        safedk_c_onPageFinished_9444f99215a88f43293d419eee97b07d(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.D, view, url);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/staticrenderer/c;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.D, webView, i, str, str2);
        safedk_c_onReceivedError_a182e53f8dc92939dd84b051f30079a3(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g.STATIC_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, n, "onRenderProcessGone", null, false, 12, null);
        return true;
    }

    public final StateFlow<Boolean> s() {
        return this.g;
    }

    public void safedk_c_onPageFinished_9444f99215a88f43293d419eee97b07d(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        MutableStateFlow<Boolean> mutableStateFlow = this.d;
        Boolean bool = Boolean.TRUE;
        mutableStateFlow.setValue(bool);
        this.f.setValue(bool);
    }

    @Deprecated(message = "Deprecated in Android API 23")
    public void safedk_c_onReceivedError_a182e53f8dc92939dd84b051f30079a3(WebView p0, int p1, String p2, String p3) {
        super.onReceivedError(p0, p1, p2, p3);
        this.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g.STATIC_AD_WEBVIEW_RECEIVED_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, n, "onReceivedError " + p2, null, false, 12, null);
    }

    @Deprecated(message = "Deprecated in Android API 24")
    public boolean safedk_c_shouldOverrideUrlLoading_6981853ef9fbea81f31e8f41863c0872(WebView p0, String p1) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar;
        if (p1 == null || (aVar = this.l) == null) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(this.f6682a, null, null, new b(p1, aVar, null), 3, null);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.D, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 24")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/staticrenderer/c;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_c_shouldOverrideUrlLoading_6981853ef9fbea81f31e8f41863c0872 = safedk_c_shouldOverrideUrlLoading_6981853ef9fbea81f31e8f41863c0872(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.D, webView, str, zSafedk_c_shouldOverrideUrlLoading_6981853ef9fbea81f31e8f41863c0872);
        return zSafedk_c_shouldOverrideUrlLoading_6981853ef9fbea81f31e8f41863c0872;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a bannerAdTouch) {
        Intrinsics.checkNotNullParameter(bannerAdTouch, "bannerAdTouch");
        this.l = bannerAdTouch;
    }

    public c(CoroutineScope scope, s clickthroughService, h buttonTracker) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.f6682a = scope;
        this.b = clickthroughService;
        this.c = buttonTracker;
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.d = MutableStateFlow;
        this.e = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.f = MutableStateFlow2;
        this.g = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.h = MutableStateFlow3;
        this.i = FlowKt.asStateFlow(MutableStateFlow3);
        MutableSharedFlow<Unit> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.j = mutableSharedFlowMutableSharedFlow$default;
        this.k = mutableSharedFlowMutableSharedFlow$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.c.a(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.c.a(buttonType);
    }
}
