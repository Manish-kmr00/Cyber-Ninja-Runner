package com.yandex.mobile.ads.common;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mobile.ads.banner.BannerAdSize;
import com.yandex.mobile.ads.banner.a;
import com.yandex.mobile.ads.impl.af1;
import com.yandex.mobile.ads.impl.bl;
import com.yandex.mobile.ads.impl.c32;
import com.yandex.mobile.ads.impl.cl;
import com.yandex.mobile.ads.impl.g5;
import com.yandex.mobile.ads.impl.jc;
import com.yandex.mobile.ads.impl.m50;
import com.yandex.mobile.ads.impl.ml2;
import com.yandex.mobile.ads.impl.nl2;
import com.yandex.mobile.ads.impl.nu;
import com.yandex.mobile.ads.impl.pv1;
import com.yandex.mobile.ads.impl.qs;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.impl.xe1;
import com.yandex.mobile.ads.impl.xt1;
import com.yandex.mobile.ads.impl.zt1;
import com.yandex.mobile.ads.impl.zy1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/yandex/mobile/ads/common/BidderTokenLoader;", "", "()V", "loadBidderToken", "", "context", "Landroid/content/Context;", "bidderTokenRequestConfiguration", "Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yandex/mobile/ads/common/BidderTokenLoadListener;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BidderTokenLoader {
    static {
        new BidderTokenLoader();
    }

    private BidderTokenLoader() {
    }

    @JvmStatic
    public static final void loadBidderToken(Context context, BidderTokenRequestConfiguration bidderTokenRequestConfiguration, BidderTokenLoadListener listener) {
        qs qsVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bidderTokenRequestConfiguration, "bidderTokenRequestConfiguration");
        Intrinsics.checkNotNullParameter(listener, "listener");
        wm2 wm2Var = new wm2(context);
        ml2 ml2Var = new ml2(listener);
        Intrinsics.checkNotNullParameter(bidderTokenRequestConfiguration, "request");
        switch (nl2.f9740a[bidderTokenRequestConfiguration.getCom.smaato.sdk.video.vast.model.Ad.AD_TYPE java.lang.String().ordinal()]) {
            case 1:
                qsVar = null;
                break;
            case 2:
                qsVar = qs.d;
                break;
            case 3:
                qsVar = qs.e;
                break;
            case 4:
                qsVar = qs.f;
                break;
            case 5:
                qsVar = qs.g;
                break;
            case 6:
                qsVar = qs.i;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        BannerAdSize bannerAdSize = bidderTokenRequestConfiguration.getBannerAdSize();
        zy1 zy1VarA = bannerAdSize != null ? a.a(bannerAdSize).a() : null;
        Map<String, String> parameters = bidderTokenRequestConfiguration.getParameters();
        if (parameters == null) {
            parameters = MapsKt.emptyMap();
        }
        cl clVar = new cl(qsVar, zy1VarA, parameters);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(nu.a()));
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        g5 g5Var = new g5();
        int i = m50.e;
        m50 m50VarA = m50.a.a(applicationContext);
        jc jcVar = new jc();
        pv1 pv1Var = new pv1(applicationContext, wm2Var, CoroutineScope, g5Var, m50VarA, jcVar);
        int i2 = c32.d;
        new zt1(context, wm2Var, CoroutineScope, applicationContext, g5Var, m50VarA, jcVar, pv1Var, c32.a.a(), new xt1(g5Var), new af1(g5Var, wm2Var.c(), new bl(), new xe1(g5Var))).a(clVar, ml2Var);
    }
}
