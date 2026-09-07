package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.callbacks.DismissibleAdCallback;
import com.chartboost.sdk.callbacks.RewardedCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ClickEvent;
import com.chartboost.sdk.events.DismissEvent;
import com.chartboost.sdk.events.ImpressionEvent;
import com.chartboost.sdk.events.RewardEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ+\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\u0010J+\u0010\u0011\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0010J5\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\u0013J5\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\u0015J+\u0010\u0016\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/chartboost/sdk/impl/d;", "", "", "adId", "Lcom/chartboost/sdk/events/ShowError;", "error", "Lcom/chartboost/sdk/ads/Ad;", Reporting.Key.CLICK_SOURCE_TYPE_AD, "Lcom/chartboost/sdk/callbacks/AdCallback;", "callback", "", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/events/ShowError;Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;)V", "", "reward", "(Ljava/lang/String;Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;I)V", "(Ljava/lang/String;Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/events/CacheError;", "(Ljava/lang/String;Lcom/chartboost/sdk/events/CacheError;Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;)V", "Lcom/chartboost/sdk/events/ClickError;", "(Ljava/lang/String;Lcom/chartboost/sdk/events/ClickError;Lcom/chartboost/sdk/ads/Ad;Lcom/chartboost/sdk/callbacks/AdCallback;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lcom/chartboost/sdk/ads/Ad;)Ljava/lang/String;", "Lcom/chartboost/sdk/impl/sa;", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "<init>", "(Lcom/chartboost/sdk/impl/sa;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final sa uiPoster;

    public d(sa uiPoster) {
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        this.uiPoster = uiPoster;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Ad b;
        public final /* synthetic */ AdCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ShowError e;
        public final /* synthetic */ d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Ad ad, AdCallback adCallback, String str, ShowError showError, d dVar) {
            super(0);
            this.b = ad;
            this.c = adCallback;
            this.d = str;
            this.e = showError;
            this.f = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            Ad ad = this.b;
            if (ad != null) {
                AdCallback adCallback = this.c;
                String str = this.d;
                ShowError showError = this.e;
                d dVar = this.f;
                if (adCallback != null) {
                    adCallback.onAdShown(new ShowEvent(str, ad), showError);
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    b7.c("Callback missing for " + dVar.a(ad) + " on onAdShown", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Ad is missing on onAdShown", null, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdCallback b;
        public final /* synthetic */ Ad c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AdCallback adCallback, Ad ad, String str, int i) {
            super(0);
            this.b = adCallback;
            this.c = ad;
            this.d = str;
            this.e = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            AdCallback adCallback = this.b;
            if (adCallback != null) {
                Ad ad = this.c;
                String str = this.d;
                int i = this.e;
                if (adCallback instanceof RewardedCallback) {
                    if (ad != null) {
                        ((RewardedCallback) adCallback).onRewardEarned(new RewardEvent(str, ad, i));
                        unit2 = Unit.INSTANCE;
                    } else {
                        unit2 = null;
                    }
                    if (unit2 == null) {
                        b7.b("Ad is missing on didEarnReward", null, 2, null);
                    }
                } else {
                    b7.b("Invalid ad type to send a reward", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Missing callback on sendRewardCallbackOnMainThread", null, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdCallback b;
        public final /* synthetic */ Ad c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdCallback adCallback, Ad ad, String str) {
            super(0);
            this.b = adCallback;
            this.c = ad;
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            AdCallback adCallback = this.b;
            if (adCallback != null) {
                Ad ad = this.c;
                String str = this.d;
                if (adCallback instanceof DismissibleAdCallback) {
                    if (ad != null) {
                        ((DismissibleAdCallback) adCallback).onAdDismiss(new DismissEvent(str, ad));
                        unit2 = Unit.INSTANCE;
                    } else {
                        unit2 = null;
                    }
                    if (unit2 == null) {
                        b7.b("Ad is missing on onAdDismiss", null, 2, null);
                    }
                } else {
                    b7.b("Invalid ad type to send onAdDismiss", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Missing callback on sendDismissCallbackOnMainThread", null, 2, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.chartboost.sdk.impl.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class C0261d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Ad b;
        public final /* synthetic */ AdCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0261d(Ad ad, AdCallback adCallback, String str, d dVar) {
            super(0);
            this.b = ad;
            this.c = adCallback;
            this.d = str;
            this.e = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            Ad ad = this.b;
            if (ad != null) {
                AdCallback adCallback = this.c;
                String str = this.d;
                d dVar = this.e;
                if (adCallback != null) {
                    adCallback.onImpressionRecorded(new ImpressionEvent(str, ad));
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    b7.c("Callback missing for " + dVar.a(ad) + " on onImpressionRecorded", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Ad is missing on onImpressionRecorded", null, 2, null);
            }
        }
    }

    public final void b(String adId, Ad ad, AdCallback callback) {
        this.uiPoster.a(new C0261d(ad, callback, adId, this));
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Ad b;
        public final /* synthetic */ AdCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CacheError e;
        public final /* synthetic */ d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Ad ad, AdCallback adCallback, String str, CacheError cacheError, d dVar) {
            super(0);
            this.b = ad;
            this.c = adCallback;
            this.d = str;
            this.e = cacheError;
            this.f = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            Ad ad = this.b;
            if (ad != null) {
                AdCallback adCallback = this.c;
                String str = this.d;
                CacheError cacheError = this.e;
                d dVar = this.f;
                if (adCallback != null) {
                    adCallback.onAdLoaded(new CacheEvent(str, ad), cacheError);
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    b7.c("Callback missing for " + dVar.a(ad) + " on onAdLoaded", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Ad is missing on onAdLoaded", null, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Ad b;
        public final /* synthetic */ AdCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ClickError e;
        public final /* synthetic */ d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ad ad, AdCallback adCallback, String str, ClickError clickError, d dVar) {
            super(0);
            this.b = ad;
            this.c = adCallback;
            this.d = str;
            this.e = clickError;
            this.f = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            Ad ad = this.b;
            if (ad != null) {
                AdCallback adCallback = this.c;
                String str = this.d;
                ClickError clickError = this.e;
                d dVar = this.f;
                if (adCallback != null) {
                    adCallback.onAdClicked(new ClickEvent(str, ad), clickError);
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    b7.c("Callback missing for " + dVar.a(ad) + " on onAdClicked", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Ad is missing on onAdClicked", null, 2, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Ad b;
        public final /* synthetic */ AdCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Ad ad, AdCallback adCallback, String str, d dVar) {
            super(0);
            this.b = ad;
            this.c = adCallback;
            this.d = str;
            this.e = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Unit unit;
            Unit unit2;
            Ad ad = this.b;
            if (ad != null) {
                AdCallback adCallback = this.c;
                String str = this.d;
                d dVar = this.e;
                if (adCallback != null) {
                    adCallback.onAdRequestedToShow(new ShowEvent(str, ad));
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    b7.c("Callback missing for " + dVar.a(ad) + " on onAdRequestedToShow", null, 2, null);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Ad is missing on onAdRequestedToShow", null, 2, null);
            }
        }
    }

    public final void c(String adId, Ad ad, AdCallback callback) {
        this.uiPoster.a(new e(ad, callback, adId, this));
    }

    public final String a(Ad ad) {
        if (ad instanceof Interstitial) {
            return u.b.g.getName();
        }
        if (ad instanceof Rewarded) {
            return u.c.g.getName();
        }
        if (ad instanceof Banner) {
            return u.a.g.getName();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void a(String adId, CacheError error, Ad ad, AdCallback callback) {
        this.uiPoster.a(new a(ad, callback, adId, error, this));
    }

    public final void a(String adId, ClickError error, Ad ad, AdCallback callback) {
        this.uiPoster.a(new b(ad, callback, adId, error, this));
    }

    public final void a(String adId, Ad ad, AdCallback callback) {
        this.uiPoster.a(new c(callback, ad, adId));
    }

    public final void a(String adId, Ad ad, AdCallback callback, int reward) {
        this.uiPoster.a(new f(callback, ad, adId, reward));
    }

    public final void a(String adId, ShowError error, Ad ad, AdCallback callback) {
        this.uiPoster.a(new g(ad, callback, adId, error, this));
    }
}
