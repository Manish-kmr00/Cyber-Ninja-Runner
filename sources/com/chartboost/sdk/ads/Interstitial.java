package com.chartboost.sdk.ads;

import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.impl.b7;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.y2;
import com.chartboost.sdk.impl.y6;
import com.chartboost.sdk.internal.Model.CBError;
import com.json.m5;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/chartboost/sdk/ads/Interstitial;", "Lcom/chartboost/sdk/ads/Ad;", "", "isCache", "", "postSessionNotStartedInMainThread", "(Z)V", Reporting.EventType.CACHE, "()V", "", "bidResponse", "(Ljava/lang/String;)V", m5.v, "clearCache", "isCached", "()Z", "location", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "Lcom/chartboost/sdk/callbacks/InterstitialCallback;", "callback", "Lcom/chartboost/sdk/callbacks/InterstitialCallback;", "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/Mediation;", "Lcom/chartboost/sdk/impl/y6;", "api$delegate", "Lkotlin/Lazy;", "getApi", "()Lcom/chartboost/sdk/impl/y6;", "api", "<init>", "(Ljava/lang/String;Lcom/chartboost/sdk/callbacks/InterstitialCallback;Lcom/chartboost/sdk/Mediation;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class Interstitial implements Ad {

    /* JADX INFO: renamed from: api$delegate, reason: from kotlin metadata */
    private final Lazy api;
    private final InterstitialCallback callback;
    private final String location;
    private final Mediation mediation;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Interstitial c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, Interstitial interstitial) {
            super(0);
            this.b = z;
            this.c = interstitial;
        }

        public final void a() {
            if (this.b) {
                this.c.callback.onAdLoaded(new CacheEvent(null, this.c), new CacheError(CacheError.Code.SESSION_NOT_STARTED, null, 2, null));
            } else {
                this.c.callback.onAdShown(new ShowEvent(null, this.c), new ShowError(ShowError.Code.SESSION_NOT_STARTED, null, 2, null));
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public Interstitial(String location, InterstitialCallback callback, Mediation mediation) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.location = location;
        this.callback = callback;
        this.mediation = mediation;
        this.api = LazyKt.lazy(new a());
    }

    private final void postSessionNotStartedInMainThread(boolean isCache) {
        try {
            y2.b.a().e().a(new b(isCache, this));
        } catch (Exception e) {
            b7.b("Interstitial ad cannot post session not started callback " + e, null, 2, null);
        }
    }

    @Override // com.chartboost.sdk.ads.Ad
    public void cache() {
        if (Chartboost.isSdkStarted()) {
            getApi().a(this, this.callback);
        } else {
            postSessionNotStartedInMainThread(true);
        }
    }

    @Override // com.chartboost.sdk.ads.Ad
    public void clearCache() {
        if (Chartboost.isSdkStarted()) {
            getApi().a();
        }
    }

    @Override // com.chartboost.sdk.ads.Ad
    public String getLocation() {
        return this.location;
    }

    @Override // com.chartboost.sdk.ads.Ad
    public boolean isCached() {
        if (Chartboost.isSdkStarted()) {
            return getApi().b();
        }
        return false;
    }

    @Override // com.chartboost.sdk.ads.Ad
    public void show() {
        if (Chartboost.isSdkStarted()) {
            getApi().b(this, this.callback);
        } else {
            postSessionNotStartedInMainThread(false);
        }
    }

    @Override // com.chartboost.sdk.ads.Ad
    public void cache(String bidResponse) {
        if (!Chartboost.isSdkStarted()) {
            postSessionNotStartedInMainThread(true);
        } else if (bidResponse != null && bidResponse.length() != 0) {
            getApi().a(this, this.callback, bidResponse);
        } else {
            getApi().a("", (CBError.d) CBError.b.INVALID_RESPONSE);
        }
    }

    public /* synthetic */ Interstitial(String str, InterstitialCallback interstitialCallback, Mediation mediation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, interstitialCallback, (i & 4) != 0 ? null : mediation);
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/y6;", "a", "()Lcom/chartboost/sdk/impl/y6;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<y6> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y6 invoke() {
            return i.b(Interstitial.this.mediation);
        }
    }

    private final y6 getApi() {
        return (y6) this.api.getValue();
    }
}
