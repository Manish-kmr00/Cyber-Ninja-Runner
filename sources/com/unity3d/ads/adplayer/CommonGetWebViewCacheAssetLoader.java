package com.unity3d.ads.adplayer;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.webkit.WebViewAssetLoader;
import com.unity3d.ads.core.data.model.WebViewConfiguration;
import com.unity3d.ads.core.domain.GetLatestWebViewConfiguration;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.log.DeviceLog;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CommonGetWebViewCacheAssetLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/unity3d/ads/adplayer/CommonGetWebViewCacheAssetLoader;", "Lcom/unity3d/ads/adplayer/GetWebViewCacheAssetLoader;", "context", "Landroid/content/Context;", "getLatestWebViewConfiguration", "Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;", "(Landroid/content/Context;Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;)V", "invoke", "Landroidx/webkit/WebViewAssetLoader;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonGetWebViewCacheAssetLoader implements GetWebViewCacheAssetLoader {
    private final Context context;
    private final GetLatestWebViewConfiguration getLatestWebViewConfiguration;

    public CommonGetWebViewCacheAssetLoader(Context context, GetLatestWebViewConfiguration getLatestWebViewConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(getLatestWebViewConfiguration, "getLatestWebViewConfiguration");
        this.context = context;
        this.getLatestWebViewConfiguration = getLatestWebViewConfiguration;
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.CommonGetWebViewCacheAssetLoader$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonGetWebViewCacheAssetLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/webkit/WebViewAssetLoader;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.adplayer.CommonGetWebViewCacheAssetLoader$invoke$1", f = "CommonGetWebViewCacheAssetLoader.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WebViewAssetLoader>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommonGetWebViewCacheAssetLoader.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WebViewAssetLoader> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String string;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GetLatestWebViewConfiguration.invoke$default(CommonGetWebViewCacheAssetLoader.this.getLatestWebViewConfiguration, null, null, null, this, 7, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Uri uri = Uri.parse(((WebViewConfiguration) obj).getEntryPoint());
            String path = uri.getPath();
            String str = path;
            if (str == null || str.length() == 0) {
                string = UnityAdsConstants.DefaultUrls.WEBVIEW_ASSET_PATH;
            } else {
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                string = sb.append(StringsKt.substringBeforeLast$default(path, '/', (String) null, 2, (Object) null)).append('/').toString();
            }
            String host = uri.getHost();
            String str2 = host;
            if (str2 == null || str2.length() == 0) {
                host = UnityAdsConstants.DefaultUrls.WEBVIEW_DOMAIN;
            } else {
                Intrinsics.checkNotNullExpressionValue(host, "{\n                it\n            }");
            }
            WebViewAssetLoader.Builder builder = new WebViewAssetLoader.Builder();
            final CommonGetWebViewCacheAssetLoader commonGetWebViewCacheAssetLoader = CommonGetWebViewCacheAssetLoader.this;
            return builder.addPathHandler(string, new WebViewAssetLoader.PathHandler() { // from class: com.unity3d.ads.adplayer.CommonGetWebViewCacheAssetLoader$invoke$1$$ExternalSyntheticLambda0
                @Override // androidx.webkit.WebViewAssetLoader.PathHandler
                public final WebResourceResponse handle(String str3) {
                    return CommonGetWebViewCacheAssetLoader.AnonymousClass1.invokeSuspend$lambda$2(commonGetWebViewCacheAssetLoader, str3);
                }
            }).setDomain(host).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WebResourceResponse invokeSuspend$lambda$2(CommonGetWebViewCacheAssetLoader commonGetWebViewCacheAssetLoader, String str) {
            try {
                InputStream inputStreamOpen = commonGetWebViewCacheAssetLoader.context.getAssets().open(UnityAdsConstants.DefaultUrls.WEBVIEW_ASSET_PATH_LOCAL + str);
                Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(\"$WE…W_ASSET_PATH_LOCAL$path\")");
                return new WebResourceResponse(StringExtensionsKt.guessMimeType(str), null, inputStreamOpen);
            } catch (Exception unused) {
                DeviceLog.debug("Webview Asset not found: %s", str);
                return null;
            }
        }
    }

    @Override // com.unity3d.ads.adplayer.GetWebViewCacheAssetLoader
    public WebViewAssetLoader invoke() throws InterruptedException {
        Object objRunBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
        Intrinsics.checkNotNullExpressionValue(objRunBlocking$default, "override fun invoke(): W…           .build()\n    }");
        return (WebViewAssetLoader) objRunBlocking$default;
    }
}
