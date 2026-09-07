package com.yandex.mobile.ads.instream;

import com.yandex.mobile.ads.impl.xn0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yandex/mobile/ads/instream/MobileInstreamAds;", "", "()V", "setAdGroupPreloading", "", "enabled", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MobileInstreamAds {
    public static final MobileInstreamAds INSTANCE = new MobileInstreamAds();

    private MobileInstreamAds() {
    }

    @JvmStatic
    public static final void setAdGroupPreloading(boolean enabled) {
        int i = xn0.g;
        xn0.a.a().a(enabled);
    }
}
