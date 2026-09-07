package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mobile.ads.impl.mm2;
import com.yandex.mobile.ads.impl.rm2;
import com.yandex.mobile.ads.impl.st;
import com.yandex.mobile.ads.impl.tt;
import com.yandex.mobile.ads.impl.wm2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAdLoader;", "", "Lcom/yandex/mobile/ads/nativeads/NativeAdLoadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setNativeAdLoadListener", "(Lcom/yandex/mobile/ads/nativeads/NativeAdLoadListener;)V", "Lcom/yandex/mobile/ads/nativeads/NativeAdRequestConfiguration;", "nativeAdRequestConfiguration", "loadAd", "(Lcom/yandex/mobile/ads/nativeads/NativeAdRequestConfiguration;)V", "cancelLoading", "()V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public class NativeAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tt f10881a;
    private final f b;

    public NativeAdLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10881a = new tt(context, new wm2(context));
        this.b = new f();
    }

    public final void cancelLoading() {
        this.f10881a.a();
    }

    public final void loadAd(NativeAdRequestConfiguration nativeAdRequestConfiguration) {
        Intrinsics.checkNotNullParameter(nativeAdRequestConfiguration, "nativeAdRequestConfiguration");
        this.f10881a.a(this.b.a(nativeAdRequestConfiguration));
    }

    public final void setNativeAdLoadListener(NativeAdLoadListener listener) {
        st mm2Var;
        if (listener instanceof a) {
            mm2Var = new rm2((a) listener);
        } else {
            mm2Var = listener != null ? new mm2(listener) : null;
        }
        this.f10881a.a(mm2Var);
    }
}
