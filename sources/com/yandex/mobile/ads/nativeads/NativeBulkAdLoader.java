package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mobile.ads.impl.qm2;
import com.yandex.mobile.ads.impl.tt;
import com.yandex.mobile.ads.impl.wm2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeBulkAdLoader;", "", "Lcom/yandex/mobile/ads/nativeads/NativeBulkAdLoadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setNativeBulkAdLoadListener", "(Lcom/yandex/mobile/ads/nativeads/NativeBulkAdLoadListener;)V", "Lcom/yandex/mobile/ads/nativeads/NativeAdRequestConfiguration;", "nativeAdRequestConfiguration", "", "adsCount", "loadAds", "(Lcom/yandex/mobile/ads/nativeads/NativeAdRequestConfiguration;I)V", "cancelLoading", "()V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class NativeBulkAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tt f10886a;
    private final f b;

    public NativeBulkAdLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10886a = new tt(context, new wm2(context));
        this.b = new f();
    }

    public final void cancelLoading() {
        this.f10886a.a();
    }

    public final void loadAds(NativeAdRequestConfiguration nativeAdRequestConfiguration, int adsCount) {
        Intrinsics.checkNotNullParameter(nativeAdRequestConfiguration, "nativeAdRequestConfiguration");
        this.f10886a.a(this.b.a(nativeAdRequestConfiguration), adsCount);
    }

    public final void setNativeBulkAdLoadListener(NativeBulkAdLoadListener listener) {
        this.f10886a.a(listener != null ? new qm2(listener) : null);
    }
}
