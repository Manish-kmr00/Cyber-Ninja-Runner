package com.yandex.mobile.ads.instream.pauseroll;

import android.content.Context;
import com.yandex.mobile.ads.impl.bt;
import com.yandex.mobile.ads.impl.jt;
import com.yandex.mobile.ads.impl.mg1;
import com.yandex.mobile.ads.impl.rt0;
import com.yandex.mobile.ads.impl.wl2;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.instream.InstreamAd;
import com.yandex.mobile.ads.instream.InstreamAdBreakQueue;
import com.yandex.mobile.ads.instream.InstreamAdBreakType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/yandex/mobile/ads/instream/pauseroll/PauserollQueueProvider;", "", "Lcom/yandex/mobile/ads/instream/InstreamAdBreakQueue;", "Lcom/yandex/mobile/ads/instream/pauseroll/Pauseroll;", "getQueue", "()Lcom/yandex/mobile/ads/instream/InstreamAdBreakQueue;", "queue", "Landroid/content/Context;", "context", "Lcom/yandex/mobile/ads/instream/InstreamAd;", "instreamAd", "<init>", "(Landroid/content/Context;Lcom/yandex/mobile/ads/instream/InstreamAd;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class PauserollQueueProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mg1 f10878a;
    private final rt0<Pauseroll> b;

    public PauserollQueueProvider(Context context, InstreamAd instreamAd) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        wm2 wm2Var = new wm2(context);
        bt btVarA = jt.a(instreamAd);
        this.f10878a = new mg1();
        this.b = new rt0<>(context, wm2Var, btVarA);
    }

    public final InstreamAdBreakQueue<Pauseroll> getQueue() {
        return new wl2(this.b.a(this.f10878a, InstreamAdBreakType.PAUSEROLL));
    }
}
