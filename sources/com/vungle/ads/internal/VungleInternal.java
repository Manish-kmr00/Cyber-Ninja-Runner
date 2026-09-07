package com.vungle.ads.internal;

import android.content.Context;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BidTokenCallback;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAds;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.executor.FutureResult;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import com.vungle.ads.internal.util.LogEntry;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VungleInternal.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/vungle/ads/internal/VungleInternal;", "", "()V", "getAvailableBidTokens", "", "context", "Landroid/content/Context;", "getAvailableBidTokensAsync", "", "callback", "Lcom/vungle/ads/BidTokenCallback;", "getSdkVersion", "vungle-ads_release", IronSourceConstants.EVENTS_PROVIDER, "Lcom/vungle/ads/internal/util/ConcurrencyTimeoutProvider;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/SDKExecutors;", "bidTokenEncoder", "Lcom/vungle/ads/internal/bidding/BidTokenEncoder;"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VungleInternal {
    public final String getAvailableBidTokens(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        timeIntervalMetric.markStart();
        if (!VungleAds.INSTANCE.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ConcurrencyTimeoutProvider>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokens$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.ConcurrencyTimeoutProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrencyTimeoutProvider invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(ConcurrencyTimeoutProvider.class);
            }
        });
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SDKExecutors>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokens$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.SDKExecutors, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SDKExecutors invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(SDKExecutors.class);
            }
        });
        ServiceLocator.Companion companion3 = ServiceLocator.INSTANCE;
        final Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<BidTokenEncoder>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokens$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.bidding.BidTokenEncoder, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BidTokenEncoder invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(BidTokenEncoder.class);
            }
        });
        String str = (String) new FutureResult(m6027getAvailableBidTokens$lambda1(lazy2).getAPI_EXECUTOR().submit(new Callable() { // from class: com.vungle.ads.internal.VungleInternal$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return VungleInternal.m6029getAvailableBidTokens$lambda3(lazy3);
            }
        })).get(m6026getAvailableBidTokens$lambda0(lazy).getTimeout(), TimeUnit.MILLISECONDS);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            timeIntervalMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            timeIntervalMetric.setMeta("Bid token is null or empty");
        }
        timeIntervalMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, (LogEntry) null, (String) null, 6, (Object) null);
        return str;
    }

    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-0, reason: not valid java name */
    private static final ConcurrencyTimeoutProvider m6026getAvailableBidTokens$lambda0(Lazy<ConcurrencyTimeoutProvider> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-1, reason: not valid java name */
    private static final SDKExecutors m6027getAvailableBidTokens$lambda1(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-2, reason: not valid java name */
    private static final BidTokenEncoder m6028getAvailableBidTokens$lambda2(Lazy<BidTokenEncoder> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-3, reason: not valid java name */
    public static final String m6029getAvailableBidTokens$lambda3(Lazy bidTokenEncoder$delegate) {
        Intrinsics.checkNotNullParameter(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        return m6028getAvailableBidTokens$lambda2(bidTokenEncoder$delegate).encode().getBidToken();
    }

    public final void getAvailableBidTokensAsync(final Context context, final BidTokenCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!VungleAds.INSTANCE.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<BidTokenEncoder>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokensAsync$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.bidding.BidTokenEncoder, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BidTokenEncoder invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(BidTokenEncoder.class);
            }
        });
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        m6031getAvailableBidTokensAsync$lambda5(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SDKExecutors>() { // from class: com.vungle.ads.internal.VungleInternal$getAvailableBidTokensAsync$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.SDKExecutors, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SDKExecutors invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(SDKExecutors.class);
            }
        })).getAPI_EXECUTOR().execute(new Runnable() { // from class: com.vungle.ads.internal.VungleInternal$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VungleInternal.m6032getAvailableBidTokensAsync$lambda6(callback, lazy);
            }
        });
    }

    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-4, reason: not valid java name */
    private static final BidTokenEncoder m6030getAvailableBidTokensAsync$lambda4(Lazy<BidTokenEncoder> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-5, reason: not valid java name */
    private static final SDKExecutors m6031getAvailableBidTokensAsync$lambda5(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-6, reason: not valid java name */
    public static final void m6032getAvailableBidTokensAsync$lambda6(BidTokenCallback callback, Lazy bidTokenEncoder$delegate) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        timeIntervalMetric.markStart();
        BidTokenEncoder.BiddingTokenInfo biddingTokenInfoEncode = m6030getAvailableBidTokensAsync$lambda4(bidTokenEncoder$delegate).encode();
        timeIntervalMetric.markEnd();
        if (biddingTokenInfoEncode.getBidToken().length() > 0) {
            callback.onBidTokenCollected(biddingTokenInfoEncode.getBidToken());
        } else {
            timeIntervalMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            timeIntervalMetric.setMeta(biddingTokenInfoEncode.getErrorMessage());
            callback.onBidTokenError(biddingTokenInfoEncode.getErrorMessage());
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, (LogEntry) null, (String) null, 6, (Object) null);
    }

    public final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }
}
