package com.five_corp.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.internal.B;
import com.five_corp.ad.internal.context.q;
import com.five_corp.ad.internal.context.r;
import com.five_corp.ad.internal.context.s;
import com.five_corp.ad.internal.context.t;
import com.five_corp.ad.internal.v;
import com.five_corp.ad.internal.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class AdLoader {
    public static final Object m = new Object();
    public static AdLoader n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1242a;
    public final FiveAdConfig b;
    public final j c;
    public final com.five_corp.ad.internal.soundstate.e d;
    public final com.five_corp.ad.internal.context.k e;
    public final com.five_corp.ad.internal.context.g f;
    public final z g;
    public final B h;
    public final s i;
    public final Handler j = new Handler(Looper.getMainLooper());
    public final com.five_corp.ad.internal.adselector.a k;
    public final com.five_corp.ad.internal.hub.a l;

    public interface CollectSignalCallback {
        void onCollect(String str);

        void onError(FiveAdErrorCode fiveAdErrorCode);
    }

    public interface LoadBannerAdCallback {
        void onError(FiveAdErrorCode fiveAdErrorCode);

        void onLoad(FiveAdCustomLayout fiveAdCustomLayout);
    }

    public interface LoadInterstitialAdCallback {
        void onError(FiveAdErrorCode fiveAdErrorCode);

        void onLoad(FiveAdInterstitial fiveAdInterstitial);
    }

    public interface LoadNativeAdCallback {
        void onError(FiveAdErrorCode fiveAdErrorCode);

        void onLoad(FiveAdNative fiveAdNative);
    }

    public interface LoadRewardAdCallback {
        void onError(FiveAdErrorCode fiveAdErrorCode);

        void onLoad(FiveAdVideoReward fiveAdVideoReward);
    }

    public AdLoader(Context context, FiveAdConfig fiveAdConfig, j jVar, com.five_corp.ad.internal.soundstate.e eVar, z zVar, B b, com.five_corp.ad.internal.context.k kVar, com.five_corp.ad.internal.context.g gVar, s sVar, com.five_corp.ad.internal.adselector.a aVar) {
        this.f1242a = context;
        this.b = fiveAdConfig;
        this.c = jVar;
        this.d = eVar;
        this.f = gVar;
        this.g = zVar;
        this.h = b;
        this.i = sVar;
        this.e = kVar;
        this.k = aVar;
        this.l = jVar.f1595a;
    }

    public static AdLoader forConfig(Context context, FiveAdConfig fiveAdConfig) {
        AdLoader adLoader;
        Context applicationContext = context.getApplicationContext();
        FiveAd.initialize(applicationContext, fiveAdConfig);
        j jVar = k.a().f1596a;
        synchronized (m) {
            if (n == null) {
                n = new AdLoader(applicationContext, fiveAdConfig, jVar, jVar.p, jVar.c, jVar.q, jVar.e, jVar.k, jVar.z, jVar.l);
            }
            adLoader = n;
        }
        return adLoader;
    }

    @Deprecated
    public static AdLoader getAdLoader(Context context, FiveAdConfig fiveAdConfig) {
        return forConfig(context, fiveAdConfig);
    }

    public static String getSemanticVersion() {
        return BuildConfig.SEMVER;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(final CollectSignalCallback collectSignalCallback, t tVar) {
        Handler handler;
        Runnable runnable;
        final com.five_corp.ad.internal.util.f fVarA = this.g.a(tVar.f1370a, tVar.d, this.d.a());
        if (fVarA.f1560a) {
            handler = this.j;
            runnable = new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    AdLoader.b(collectSignalCallback, fVarA);
                }
            };
        } else {
            handler = this.j;
            runnable = new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    AdLoader.a(collectSignalCallback, fVarA);
                }
            };
        }
        handler.post(runnable);
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void a(final h hVar, final com.five_corp.ad.internal.context.l lVar) {
        this.j.post(new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(hVar, lVar);
            }
        });
    }

    public void collectSignal(AdSlotConfig adSlotConfig, final CollectSignalCallback collectSignalCallback) {
        this.i.a(this.f.a(adSlotConfig.slotId), 1000L, new q() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda18
            @Override // com.five_corp.ad.internal.context.q
            public final void a(t tVar) {
                this.f$0.b(collectSignalCallback, tVar);
            }
        }, new r() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda19
            @Override // com.five_corp.ad.internal.context.r
            public final void a(com.five_corp.ad.internal.o oVar) {
                this.f$0.b(collectSignalCallback, oVar);
            }
        });
    }

    public void loadBannerAd(AdSlotConfig adSlotConfig, final int i, final LoadBannerAdCallback loadBannerAdCallback) {
        com.five_corp.ad.internal.context.i iVarA = this.f.a(adSlotConfig.slotId);
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.CUSTOM_LAYOUT;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda16
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.b(loadBannerAdCallback, i, lVar);
            }
        };
        Objects.requireNonNull(loadBannerAdCallback);
        a(iVarA, hVar, hVar2, new AdLoader$$ExternalSyntheticLambda17(loadBannerAdCallback));
    }

    public void loadInterstitialAd(AdSlotConfig adSlotConfig, final LoadInterstitialAdCallback loadInterstitialAdCallback) {
        com.five_corp.ad.internal.context.i iVarA = this.f.a(adSlotConfig.slotId);
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.INTERSTITIAL;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda5
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.b(loadInterstitialAdCallback, lVar);
            }
        };
        Objects.requireNonNull(loadInterstitialAdCallback);
        a(iVarA, hVar, hVar2, new AdLoader$$ExternalSyntheticLambda6(loadInterstitialAdCallback));
    }

    public void loadNativeAd(AdSlotConfig adSlotConfig, final int i, final LoadNativeAdCallback loadNativeAdCallback) {
        com.five_corp.ad.internal.context.i iVarA = this.f.a(adSlotConfig.slotId);
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.NATIVE;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda9
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.b(loadNativeAdCallback, i, lVar);
            }
        };
        Objects.requireNonNull(loadNativeAdCallback);
        a(iVarA, hVar, hVar2, new AdLoader$$ExternalSyntheticLambda4(loadNativeAdCallback));
    }

    public void loadRewardAd(AdSlotConfig adSlotConfig, final LoadRewardAdCallback loadRewardAdCallback) {
        com.five_corp.ad.internal.context.i iVarA = this.f.a(adSlotConfig.slotId);
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.VIDEO_REWARD;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda23
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.b(loadRewardAdCallback, lVar);
            }
        };
        Objects.requireNonNull(loadRewardAdCallback);
        a(iVarA, hVar, hVar2, new AdLoader$$ExternalSyntheticLambda24(loadRewardAdCallback));
    }

    public final /* synthetic */ void b(final CollectSignalCallback collectSignalCallback, final com.five_corp.ad.internal.o oVar) {
        this.j.post(new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                collectSignalCallback.onError(oVar.a());
            }
        });
    }

    public void collectSignal(String str, CollectSignalCallback collectSignalCallback) {
        collectSignal(new AdSlotConfig(str), collectSignalCallback);
    }

    public void loadBannerAd(BidData bidData, final int i, final LoadBannerAdCallback loadBannerAdCallback) {
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.CUSTOM_LAYOUT;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda11
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.a(loadBannerAdCallback, i, lVar);
            }
        };
        Objects.requireNonNull(loadBannerAdCallback);
        a(bidData, hVar, new AdLoader$$ExternalSyntheticLambda17(loadBannerAdCallback), hVar2);
    }

    public void loadInterstitialAd(BidData bidData, final LoadInterstitialAdCallback loadInterstitialAdCallback) {
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.INTERSTITIAL;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda7
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.a(loadInterstitialAdCallback, lVar);
            }
        };
        Objects.requireNonNull(loadInterstitialAdCallback);
        a(bidData, hVar, new AdLoader$$ExternalSyntheticLambda6(loadInterstitialAdCallback), hVar2);
    }

    public void loadNativeAd(BidData bidData, final int i, final LoadNativeAdCallback loadNativeAdCallback) {
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.NATIVE;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda3
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.a(loadNativeAdCallback, i, lVar);
            }
        };
        Objects.requireNonNull(loadNativeAdCallback);
        a(bidData, hVar, new AdLoader$$ExternalSyntheticLambda4(loadNativeAdCallback), hVar2);
    }

    public void loadRewardAd(BidData bidData, final LoadRewardAdCallback loadRewardAdCallback) {
        com.five_corp.ad.internal.context.h hVar = com.five_corp.ad.internal.context.h.VIDEO_REWARD;
        h hVar2 = new h() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda10
            @Override // com.five_corp.ad.h
            public final void a(com.five_corp.ad.internal.context.l lVar) {
                this.f$0.a(loadRewardAdCallback, lVar);
            }
        };
        Objects.requireNonNull(loadRewardAdCallback);
        a(bidData, hVar, new AdLoader$$ExternalSyntheticLambda24(loadRewardAdCallback), hVar2);
    }

    public static void b(CollectSignalCallback collectSignalCallback, com.five_corp.ad.internal.util.f fVar) {
        collectSignalCallback.onCollect((String) fVar.c);
    }

    public final void a(final BidData bidData, final com.five_corp.ad.internal.context.h hVar, final i iVar, final h hVar2) {
        this.j.post(new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(bidData, hVar, iVar, hVar2);
            }
        });
    }

    @Deprecated
    public void loadBannerAd(BidData bidData, LoadBannerAdCallback loadBannerAdCallback) {
        loadBannerAd(bidData, 0, loadBannerAdCallback);
    }

    public void loadNativeAd(BidData bidData, LoadNativeAdCallback loadNativeAdCallback) {
        loadNativeAd(bidData, 0, loadNativeAdCallback);
    }

    public final void a(final com.five_corp.ad.internal.context.j jVar, final t tVar, final com.five_corp.ad.internal.context.h hVar, final i iVar, final String str, final h hVar2) {
        this.j.post(new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(jVar, tVar, hVar, iVar, str, hVar2);
            }
        });
    }

    public final void b(final BidData bidData, final com.five_corp.ad.internal.context.h hVar, final i iVar, final h hVar2) {
        com.five_corp.ad.internal.util.f fVarA = com.five_corp.ad.internal.parser.e.a(bidData.bidResponse);
        if (!fVarA.f1560a) {
            b(iVar, fVarA.b, null, null, hVar);
            return;
        }
        final com.five_corp.ad.internal.ad.b bVar = (com.five_corp.ad.internal.ad.b) fVarA.c;
        String str = bVar.b;
        String str2 = this.b.appId;
        final com.five_corp.ad.internal.context.i iVar2 = new com.five_corp.ad.internal.context.i(str, bVar.f1267a);
        final com.five_corp.ad.internal.context.j jVarA = this.e.a(bVar.c);
        if (jVarA == null) {
            b(iVar, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.N5, null, null, null), bVar.c, iVar2, hVar);
        } else {
            this.i.a(iVar2, 1000L, new q() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda1
                @Override // com.five_corp.ad.internal.context.q
                public final void a(t tVar) {
                    this.f$0.a(jVarA, bidData, hVar, hVar2, iVar, tVar);
                }
            }, new r() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda2
                @Override // com.five_corp.ad.internal.context.r
                public final void a(com.five_corp.ad.internal.o oVar) {
                    this.f$0.a(bVar, iVar2, hVar, iVar, oVar);
                }
            });
        }
    }

    public static void a(CollectSignalCallback collectSignalCallback, com.five_corp.ad.internal.util.f fVar) {
        collectSignalCallback.onError(fVar.b.a());
    }

    public final /* synthetic */ void a(com.five_corp.ad.internal.context.j jVar, BidData bidData, com.five_corp.ad.internal.context.h hVar, h hVar2, i iVar, t tVar) {
        a(jVar, tVar, hVar, iVar, bidData.watermark, hVar2);
    }

    public final /* synthetic */ void a(com.five_corp.ad.internal.ad.b bVar, com.five_corp.ad.internal.context.i iVar, com.five_corp.ad.internal.context.h hVar, i iVar2, com.five_corp.ad.internal.o oVar) {
        b(iVar2, oVar, bVar.c, iVar, hVar);
    }

    public final /* synthetic */ void a(com.five_corp.ad.internal.context.j jVar, t tVar, com.five_corp.ad.internal.context.h hVar, i iVar, com.five_corp.ad.internal.o oVar) {
        b(iVar, oVar, jVar.f1362a, tVar.f1370a, hVar);
    }

    public final /* synthetic */ void a(LoadBannerAdCallback loadBannerAdCallback, int i, com.five_corp.ad.internal.context.l lVar) {
        loadBannerAdCallback.onLoad(new FiveAdCustomLayout(this.f1242a, this.c, lVar, i));
    }

    public final void b(final com.five_corp.ad.internal.context.j jVar, final t tVar, final com.five_corp.ad.internal.context.h hVar, final i iVar, String str, final h hVar2) {
        com.five_corp.ad.internal.ad.format_config.a aVarA;
        int iOrdinal;
        com.five_corp.ad.internal.ad.a aVar = jVar.f1362a;
        String str2 = tVar.f1370a.b;
        if (v.a(aVar, System.currentTimeMillis()) && com.five_corp.ad.internal.ad.a.a(aVar, str2) != null && (aVarA = com.five_corp.ad.internal.ad.a.a(aVar, str2)) != null && ((iOrdinal = hVar.ordinal()) == 0 || iOrdinal == 1 ? aVarA.b != null : (iOrdinal == 2 || iOrdinal == 3) && aVarA.c != null)) {
            this.f.a(jVar, str, tVar, hVar, new com.five_corp.ad.internal.context.e() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda12
                @Override // com.five_corp.ad.internal.context.e
                public final void a(com.five_corp.ad.internal.context.l lVar) {
                    this.f$0.a(hVar2, lVar);
                }
            }, new com.five_corp.ad.internal.context.f() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda13
                @Override // com.five_corp.ad.internal.context.f
                public final void a(com.five_corp.ad.internal.o oVar) {
                    this.f$0.a(jVar, tVar, hVar, iVar, oVar);
                }
            });
        } else {
            b(iVar, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.O5, null, null, null), jVar.f1362a, tVar.f1370a, hVar);
        }
    }

    public final /* synthetic */ void a(LoadInterstitialAdCallback loadInterstitialAdCallback, com.five_corp.ad.internal.context.l lVar) {
        loadInterstitialAdCallback.onLoad(new FiveAdInterstitial(this.f1242a, this.c, lVar));
    }

    public final /* synthetic */ void a(LoadNativeAdCallback loadNativeAdCallback, int i, com.five_corp.ad.internal.context.l lVar) {
        loadNativeAdCallback.onLoad(new FiveAdNative(this.f1242a, this.c, lVar, i));
    }

    public final /* synthetic */ void a(LoadRewardAdCallback loadRewardAdCallback, com.five_corp.ad.internal.context.l lVar) {
        loadRewardAdCallback.onLoad(new FiveAdVideoReward(this.f1242a, this.c, lVar));
    }

    public final void a(i iVar, com.five_corp.ad.internal.o oVar, com.five_corp.ad.internal.ad.a aVar, com.five_corp.ad.internal.context.i iVar2, com.five_corp.ad.internal.context.h hVar) {
        iVar.onError(oVar.a());
        com.five_corp.ad.internal.hub.a aVar2 = this.l;
        com.five_corp.ad.internal.beacon.b bVar = new com.five_corp.ad.internal.beacon.b(aVar, iVar2, hVar, oVar, new com.five_corp.ad.internal.soundstate.a(1, 1, 1, this.d.a()), 0L, null, null);
        Iterator it = aVar2.b.a().iterator();
        while (it.hasNext()) {
            B b = (B) ((com.five_corp.ad.internal.hub.b) it.next());
            if (!b.f.contains(Integer.valueOf(bVar.d.f1517a.f1518a))) {
                b.c.a(new com.five_corp.ad.internal.bgtask.f(bVar, b.f1262a, b.b));
            }
        }
    }

    public final /* synthetic */ void b(LoadBannerAdCallback loadBannerAdCallback, int i, com.five_corp.ad.internal.context.l lVar) {
        loadBannerAdCallback.onLoad(new FiveAdCustomLayout(this.f1242a, this.c, lVar, i));
    }

    public final /* synthetic */ void b(LoadInterstitialAdCallback loadInterstitialAdCallback, com.five_corp.ad.internal.context.l lVar) {
        loadInterstitialAdCallback.onLoad(new FiveAdInterstitial(this.f1242a, this.c, lVar));
    }

    public final /* synthetic */ void b(LoadNativeAdCallback loadNativeAdCallback, int i, com.five_corp.ad.internal.context.l lVar) {
        loadNativeAdCallback.onLoad(new FiveAdNative(this.f1242a, this.c, lVar, i));
    }

    public final /* synthetic */ void b(LoadRewardAdCallback loadRewardAdCallback, com.five_corp.ad.internal.context.l lVar) {
        loadRewardAdCallback.onLoad(new FiveAdVideoReward(this.f1242a, this.c, lVar));
    }

    public final void b(h hVar, com.five_corp.ad.internal.context.l lVar) {
        hVar.a(lVar);
        this.h.a(new com.five_corp.ad.internal.beacon.a(lVar, 5, new com.five_corp.ad.internal.soundstate.a(1, 1, 1, this.d.a()), 0L, 0.0d));
    }

    public final void a(com.five_corp.ad.internal.context.i iVar, com.five_corp.ad.internal.context.h hVar, h hVar2, i iVar2) {
        com.five_corp.ad.internal.adselector.a aVar = this.k;
        com.five_corp.ad.internal.soundstate.d dVarA = this.d.a();
        Object obj = new Object();
        com.five_corp.ad.internal.soundstate.a aVar2 = new com.five_corp.ad.internal.soundstate.a(1, 1, 1, dVarA);
        new ArrayList();
        synchronized (obj) {
        }
        aVar.a(iVar, hVar, aVar2, new g(this, hVar2, iVar, hVar, iVar2));
    }

    public final void b(final i iVar, final com.five_corp.ad.internal.o oVar, final com.five_corp.ad.internal.ad.a aVar, final com.five_corp.ad.internal.context.i iVar2, final com.five_corp.ad.internal.context.h hVar) {
        this.j.post(new Runnable() { // from class: com.five_corp.ad.AdLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(iVar, oVar, aVar, iVar2, hVar);
            }
        });
    }
}
