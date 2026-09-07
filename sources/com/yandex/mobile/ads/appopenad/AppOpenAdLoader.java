package com.yandex.mobile.ads.appopenad;

import android.content.Context;
import com.yandex.mobile.ads.common.AdRequestConfiguration;
import com.yandex.mobile.ads.impl.dl2;
import com.yandex.mobile.ads.impl.jl2;
import com.yandex.mobile.ads.impl.us;
import com.yandex.mobile.ads.impl.wm2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/yandex/mobile/ads/appopenad/AppOpenAdLoader;", "", "Lcom/yandex/mobile/ads/appopenad/AppOpenAdLoadListener;", "appOpenAdLoadListener", "", "setAdLoadListener", "(Lcom/yandex/mobile/ads/appopenad/AppOpenAdLoadListener;)V", "Lcom/yandex/mobile/ads/common/AdRequestConfiguration;", "adRequestConfiguration", "loadAd", "(Lcom/yandex/mobile/ads/common/AdRequestConfiguration;)V", "cancelLoading", "()V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class AppOpenAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final us f8321a;
    private final dl2 b;

    public AppOpenAdLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8321a = new us(context, new wm2(context));
        this.b = new dl2();
    }

    public final void cancelLoading() {
        this.f8321a.a();
    }

    public final void loadAd(AdRequestConfiguration adRequestConfiguration) {
        Intrinsics.checkNotNullParameter(adRequestConfiguration, "adRequestConfiguration");
        this.f8321a.a(this.b.a(adRequestConfiguration));
    }

    public final void setAdLoadListener(AppOpenAdLoadListener appOpenAdLoadListener) {
        this.f8321a.a(appOpenAdLoadListener != null ? new jl2(appOpenAdLoadListener) : null);
    }
}
