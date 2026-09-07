package com.yandex.mobile.ads.instream;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.safedk.android.utils.j;
import com.yandex.mobile.ads.impl.cm0;
import com.yandex.mobile.ads.impl.cm2;
import com.yandex.mobile.ads.impl.el1;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.impl.yl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdLoader;", "Lcom/yandex/mobile/ads/impl/el1;", "Landroid/content/Context;", "context", "Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;", j.c, "", "loadInstreamAd", "(Landroid/content/Context;Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;)V", "Lcom/yandex/mobile/ads/instream/InstreamAdLoadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInstreamAdLoadListener", "(Lcom/yandex/mobile/ads/instream/InstreamAdLoadListener;)V", "<init>", "(Landroid/content/Context;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class InstreamAdLoader extends el1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cm0 f10872a;

    public InstreamAdLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10872a = new cm0(context, new wm2(context));
    }

    public final void loadInstreamAd(Context context, InstreamAdRequestConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f10872a.a(new cm2(configuration));
    }

    public final void setInstreamAdLoadListener(InstreamAdLoadListener listener) {
        this.f10872a.a(listener != null ? new yl2(listener) : null);
    }
}
