package com.yandex.mobile.ads.feed;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.yandex.mobile.ads.impl.a90;
import com.yandex.mobile.ads.impl.aa0;
import com.yandex.mobile.ads.impl.b90;
import com.yandex.mobile.ads.impl.c90;
import com.yandex.mobile.ads.impl.f01;
import com.yandex.mobile.ads.impl.h90;
import com.yandex.mobile.ads.impl.i90;
import com.yandex.mobile.ads.impl.ka0;
import com.yandex.mobile.ads.impl.o3;
import com.yandex.mobile.ads.impl.q90;
import com.yandex.mobile.ads.impl.qs;
import com.yandex.mobile.ads.impl.s10;
import com.yandex.mobile.ads.impl.t90;
import com.yandex.mobile.ads.impl.u90;
import com.yandex.mobile.ads.impl.v7;
import com.yandex.mobile.ads.impl.v90;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.impl.y90;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R.\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/yandex/mobile/ads/feed/FeedAd;", "Lcom/yandex/mobile/ads/feed/a;", "", "preloadAd", "()V", "Lcom/yandex/mobile/ads/feed/FeedAdLoadListener;", "value", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/yandex/mobile/ads/feed/FeedAdLoadListener;", "getLoadListener", "()Lcom/yandex/mobile/ads/feed/FeedAdLoadListener;", "setLoadListener", "(Lcom/yandex/mobile/ads/feed/FeedAdLoadListener;)V", "loadListener", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class FeedAd extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ka0 f8339a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private FeedAdLoadListener loadListener;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/yandex/mobile/ads/feed/FeedAd$Builder;", "", "Lcom/yandex/mobile/ads/feed/FeedAd;", "build", "()Lcom/yandex/mobile/ads/feed/FeedAd;", "Landroid/content/Context;", "context", "Lcom/yandex/mobile/ads/feed/FeedAdRequestConfiguration;", "requestConfiguration", "Lcom/yandex/mobile/ads/feed/FeedAdAppearance;", "appearance", "<init>", "(Landroid/content/Context;Lcom/yandex/mobile/ads/feed/FeedAdRequestConfiguration;Lcom/yandex/mobile/ads/feed/FeedAdAppearance;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f8340a;
        private final FeedAdRequestConfiguration b;
        private final FeedAdAppearance c;
        private final b90 d;

        public Builder(Context context, FeedAdRequestConfiguration requestConfiguration, FeedAdAppearance appearance) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
            Intrinsics.checkNotNullParameter(appearance, "appearance");
            this.f8340a = context;
            this.b = requestConfiguration;
            this.c = appearance;
            this.d = new b90();
        }

        public final FeedAd build() {
            v7 v7VarA = this.d.a(this.b, this.c);
            wm2 wm2Var = new wm2(this.f8340a);
            Context applicationContext = this.f8340a.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext);
            h90 h90Var = new h90(applicationContext, wm2Var.c());
            i90 i90Var = new i90(h90Var, wm2Var.c(), new s10());
            o3 o3Var = new o3(qs.j, wm2Var);
            MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
            t90 t90Var = new t90(applicationContext, wm2Var, o3Var);
            u90 u90Var = new u90(t90Var, new c90());
            y90 y90Var = new y90(i90Var);
            f01 f01Var = new f01();
            v90 v90Var = new v90(f01Var);
            aa0 aa0Var = new aa0(v7VarA, u90Var, y90Var, v90Var);
            return new FeedAd(new ka0(applicationContext, wm2Var, v7VarA, h90Var, i90Var, o3Var, mutableSharedFlowMutableSharedFlow$default, t90Var, u90Var, y90Var, f01Var, v90Var, aa0Var, new q90(mutableSharedFlowMutableSharedFlow$default, aa0Var), CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)))), null);
        }
    }

    public final FeedAdLoadListener getLoadListener() {
        return this.loadListener;
    }

    public final void preloadAd() {
        this.f8339a.f();
    }

    public final void setLoadListener(FeedAdLoadListener feedAdLoadListener) {
        this.f8339a.a(new a90(feedAdLoadListener));
        this.loadListener = feedAdLoadListener;
    }

    private FeedAd(ka0 ka0Var) {
        this.f8339a = ka0Var;
    }

    public /* synthetic */ FeedAd(ka0 ka0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(ka0Var);
    }

    @Override // com.yandex.mobile.ads.feed.a
    /* JADX INFO: renamed from: b, reason: from getter */
    protected final ka0 getF8339a() {
        return this.f8339a;
    }
}
