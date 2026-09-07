package com.inmobi.media;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: renamed from: com.inmobi.media.y5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J1\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\r\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\bJ\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b\u0013\u0010%J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b\r\u0010*J\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0003R*\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b-\u0010.\u0012\u0004\b2\u0010\u0003\u001a\u0004\b/\u00100\"\u0004\b\r\u00101R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010:\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0016R\u0011\u0010<\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b;\u0010\u0016¨\u0006="}, d2 = {"Lcom/inmobi/media/y5;", "Lcom/inmobi/media/tc;", "<init>", "()V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "", "e", "(Lcom/inmobi/ads/AdMetaInfo;)V", "", "shouldResetPubState", "", "errorCode", "a", "(ZS)V", "Lcom/inmobi/media/C0;", "adUnit", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lcom/inmobi/media/C0;Lcom/inmobi/ads/InMobiAdRequestStatus;)V", VastAttributes.HORIZONTAL_POSITION, "()Z", VastAttributes.VERTICAL_POSITION, "Lcom/inmobi/media/E9;", "pubSettings", "Landroid/content/Context;", "context", "sendLoadCalledTelemetry", "", "logType", "(Lcom/inmobi/media/E9;Landroid/content/Context;ZLjava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "D", "d", "Lcom/inmobi/ads/controllers/PublisherCallbacks;", "callbacks", "(Lcom/inmobi/ads/controllers/PublisherCallbacks;)V", "F", "g", "Lcom/inmobi/ads/WatermarkData;", "watermarkData", "(Lcom/inmobi/ads/WatermarkData;)V", ExifInterface.LONGITUDE_EAST, "Lcom/inmobi/media/w5;", "o", "Lcom/inmobi/media/w5;", "z", "()Lcom/inmobi/media/w5;", "(Lcom/inmobi/media/w5;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "interstitialAdUnit", "p", "Z", "showRequested", "j", "()Lcom/inmobi/media/C0;", "C", "isInitialised", "B", "isAdInReadyState", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class C3637y5 extends AbstractC3574tc {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private C3609w5 interstitialAdUnit;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private boolean showRequested;

    public static /* synthetic */ void A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3637y5 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        L4 l4P = this$0.p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", "callback - onAdLoadSucceeded");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdLoadSucceeded(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3637y5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", "callback - onAdDisplayFailed");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdDisplayFailed();
        }
        L4 l4P2 = this$0.p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
        this$0.y();
    }

    private final void e(final AdMetaInfo info) {
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).c("InterstitialUnifiedAdManager", "onLoadSuccess");
        }
        super.c(info);
        L4 l4P2 = p();
        if (l4P2 != null) {
            ((M4) l4P2).d("InterstitialUnifiedAdManager", "AdManager state - LOADED");
        }
        a((byte) 2);
        s().post(new Runnable() { // from class: com.inmobi.media.y5$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3637y5.b(this.f$0, info);
            }
        });
    }

    private final boolean x() {
        byte bQ = q();
        if (bQ == 1) {
            L4 l4P = p();
            if (l4P != null) {
                ((M4) l4P).b("InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            }
            AbstractC3498o6.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            a(false, (short) 2147);
            return false;
        }
        if (bQ == 7) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).b("InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            }
            a(false, (short) 2168);
            return false;
        }
        if (bQ != 5) {
            if (!this.showRequested) {
                return true;
            }
            C3609w5 c3609w5 = this.interstitialAdUnit;
            if (c3609w5 != null) {
                c3609w5.c((short) 2149);
            }
            AbstractC3498o6.a((byte) 1, "InMobi", AbstractC3574tc.k);
            L4 l4P3 = p();
            if (l4P3 != null) {
                ((M4) l4P3).b("InMobi", AbstractC3574tc.k);
            }
            return false;
        }
        if (this.interstitialAdUnit == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(AbstractC3574tc.j);
        C3609w5 c3609w6 = this.interstitialAdUnit;
        AbstractC3498o6.a((byte) 1, "InMobi", sb.append(c3609w6 != null ? c3609w6.I() : null).toString());
        L4 l4P4 = p();
        if (l4P4 != null) {
            StringBuilder sb2 = new StringBuilder(AbstractC3574tc.j);
            C3609w5 c3609w7 = this.interstitialAdUnit;
            ((M4) l4P4).b("InMobi", sb2.append(c3609w7 != null ? c3609w7.I() : null).toString());
        }
        a(false, (short) 2148);
        return false;
    }

    private final void y() {
        C3609w5 c3609w5 = this.interstitialAdUnit;
        if (c3609w5 != null) {
            c3609w5.b((byte) 4);
        }
    }

    public final boolean B() {
        C3609w5 c3609w5 = this.interstitialAdUnit;
        if (c3609w5 != null && 2 == q()) {
            return c3609w5.G0();
        }
        return false;
    }

    public boolean C() {
        return this.interstitialAdUnit != null;
    }

    public final void D() throws IllegalStateException {
        C0 c0J;
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", Reporting.EventType.RENDER);
        }
        C3609w5 c3609w5 = this.interstitialAdUnit;
        if (c3609w5 == null) {
            throw new IllegalStateException(AbstractC3574tc.m);
        }
        if (c3609w5.G0() && n() != null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).c("InterstitialUnifiedAdManager", "already in ready state");
            }
            AdMetaInfo adMetaInfoN = n();
            Intrinsics.checkNotNull(adMetaInfoN);
            e(adMetaInfoN);
            return;
        }
        if (this.showRequested) {
            L4 l4P3 = p();
            if (l4P3 != null) {
                ((M4) l4P3).b("InMobi", AbstractC3574tc.k);
            }
            AbstractC3498o6.a((byte) 1, "InMobi", AbstractC3574tc.k);
            b(this.interstitialAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            C3609w5 c3609w6 = this.interstitialAdUnit;
            if (c3609w6 != null) {
                c3609w6.b((short) 2128);
                return;
            }
            return;
        }
        C3609w5 c3609w7 = this.interstitialAdUnit;
        C3389h c3389hM = c3609w7 != null ? c3609w7.m() : null;
        C3609w5 c3609w8 = this.interstitialAdUnit;
        boolean zA = a("InMobi", String.valueOf(c3609w8 != null ? c3609w8.I() : null));
        if (c3389hM == null) {
            L4 l4P4 = p();
            if (l4P4 != null) {
                ((M4) l4P4).b("InterstitialUnifiedAdManager", "ad is null. failure");
            }
            b(this.interstitialAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            C3609w5 c3609w9 = this.interstitialAdUnit;
            if (c3609w9 != null) {
                c3609w9.a((short) 2166);
            }
        }
        if (n() == null) {
            L4 l4P5 = p();
            if (l4P5 != null) {
                ((M4) l4P5).b("InterstitialUnifiedAdManager", "ad meta info is null. failure");
            }
            b(this.interstitialAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            C3609w5 c3609w10 = this.interstitialAdUnit;
            if (c3609w10 != null) {
                c3609w10.a((short) 2167);
            }
        }
        if (c3389hM == null || !zA) {
            return;
        }
        if (v() && (c0J = j()) != null) {
            c0J.e((byte) 1);
        }
        L4 l4P6 = p();
        if (l4P6 != null) {
            ((M4) l4P6).d("InterstitialUnifiedAdManager", "AdManager state - LOADING_INTO_VIEW");
        }
        a((byte) 8);
        C3609w5 c3609w11 = this.interstitialAdUnit;
        if (c3609w11 != null) {
            c3609w11.j0();
        }
    }

    public final void E() {
        C3609w5 c3609w5;
        Mb mbF0;
        C3609w5 c3609w6 = this.interstitialAdUnit;
        if ((c3609w6 == null || (mbF0 = c3609w6.F0()) == null || !mbF0.b) && (c3609w5 = this.interstitialAdUnit) != null) {
            c3609w5.J0();
        }
    }

    public final void F() {
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", com.json.m5.v);
        }
        C3609w5 c3609w5 = this.interstitialAdUnit;
        Mb mbF0 = c3609w5 != null ? c3609w5.F0() : null;
        if (mbF0 != null) {
            mbF0.b = true;
        }
        C3609w5 c3609w6 = this.interstitialAdUnit;
        if (c3609w6 != null) {
            c3609w6.w0();
        }
        if (x()) {
            if (!X3.f3234a.a()) {
                if (this.interstitialAdUnit != null) {
                    a(true, (short) 2141);
                    return;
                }
                return;
            }
            C3609w5 c3609w7 = this.interstitialAdUnit;
            if (c3609w7 == null || !c3609w7.e((byte) 4)) {
                return;
            }
            this.showRequested = true;
            C3609w5 c3609w8 = this.interstitialAdUnit;
            if (c3609w8 != null) {
                c3609w8.j(this);
            }
        }
    }

    public final void a(C3609w5 c3609w5) {
        this.interstitialAdUnit = c3609w5;
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void d() {
        s().post(new Runnable() { // from class: com.inmobi.media.y5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3637y5.b(this.f$0);
            }
        });
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).d("InterstitialUnifiedAdManager", "AdManager state - DISPLAY_FAILED");
        }
        a((byte) 6);
        C3609w5 c3609w5 = this.interstitialAdUnit;
        if (c3609w5 != null) {
            c3609w5.g();
        }
        L4 l4P2 = p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void g() {
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", "showTimeOut");
        }
        C0 c0J = j();
        if (c0J != null) {
            if (c0J.Q() == 6 || c0J.Q() == 7) {
                c0J.a(this);
            } else {
                a(true, (short) 2159);
            }
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public C0 j() {
        return this.interstitialAdUnit;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final C3609w5 getInterstitialAdUnit() {
        return this.interstitialAdUnit;
    }

    private final void a(boolean shouldResetPubState, short errorCode) {
        C3609w5 c3609w5;
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).c("InterstitialUnifiedAdManager", "onShowFailure");
        }
        if (errorCode != 0 && (c3609w5 = this.interstitialAdUnit) != null) {
            c3609w5.c(errorCode);
        }
        s().post(new Runnable() { // from class: com.inmobi.media.y5$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3637y5.c(this.f$0);
            }
        });
        if (shouldResetPubState) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).d("InterstitialUnifiedAdManager", "AdManager state - FAILED");
            }
            a((byte) 6);
            C3609w5 c3609w6 = this.interstitialAdUnit;
            if (c3609w6 != null) {
                c3609w6.g();
            }
        }
        L4 l4P3 = p();
        if (l4P3 != null) {
            ((M4) l4P3).a();
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).c("InterstitialUnifiedAdManager", "onAdFetchSuccess");
        }
        d(info);
        if (this.interstitialAdUnit == null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).b("InterstitialUnifiedAdManager", "onAdFetchSuccess - adUnit is null - fail");
            }
            a((C0) null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            a((short) 2190);
            return;
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.y5$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3637y5.a(this.f$0, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void c(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).c("InterstitialUnifiedAdManager", "onAdLoadSucceeded");
        }
        if (this.interstitialAdUnit == null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).b("InterstitialUnifiedAdManager", "adUnit is null");
            }
            c(null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        e(info);
    }

    public final void c(PublisherCallbacks callbacks) {
        C3609w5 c3609w5;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        if (l() == null) {
            b(callbacks);
        }
        if (Intrinsics.areEqual(u(), Boolean.FALSE)) {
            C3609w5 c3609w6 = this.interstitialAdUnit;
            if (c3609w6 != null) {
                c3609w6.a((short) 2006);
            }
            callbacks.onAdLoadFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            L4 l4P = p();
            if (l4P != null) {
                ((M4) l4P).b("InMobi", "Cannot call load() API after calling load(byte[])");
            }
            AbstractC3498o6.a((byte) 1, "InMobi", "Cannot call load() API after calling load(byte[])");
            return;
        }
        if (this.showRequested) {
            C3609w5 c3609w7 = this.interstitialAdUnit;
            if (c3609w7 != null) {
                c3609w7.a((short) 2004);
            }
            callbacks.onAdLoadFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).b("InMobi", AbstractC3574tc.k);
            }
            AbstractC3498o6.a((byte) 1, "InMobi", AbstractC3574tc.k);
            return;
        }
        a(Boolean.TRUE);
        C3609w5 c3609w8 = this.interstitialAdUnit;
        if (c3609w8 == null || !a("InMobi", String.valueOf(c3609w8.I()), callbacks) || (c3609w5 = this.interstitialAdUnit) == null || !c3609w5.e(o())) {
            return;
        }
        a((byte) 1);
        L4 l4P3 = p();
        if (l4P3 != null) {
            StringBuilder sb = new StringBuilder("Fetching an Interstitial ad for placement id: ");
            C3609w5 c3609w9 = this.interstitialAdUnit;
            ((M4) l4P3).c("InterstitialUnifiedAdManager", sb.append(c3609w9 != null ? c3609w9.I() : null).toString());
        }
        StringBuilder sb2 = new StringBuilder("Fetching an Interstitial ad for placement id: ");
        C3609w5 c3609w10 = this.interstitialAdUnit;
        AbstractC3498o6.a((byte) 2, "InterstitialUnifiedAdManager", sb2.append(c3609w10 != null ? c3609w10.I() : null).toString());
        C3609w5 c3609w11 = this.interstitialAdUnit;
        if (c3609w11 != null) {
            c3609w11.g(this);
        }
        C3609w5 c3609w12 = this.interstitialAdUnit;
        if (c3609w12 != null) {
            c3609w12.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3637y5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", "callback - onAdDisplayFailed");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdDisplayFailed();
        }
        this$0.y();
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void b() {
        s().post(new Runnable() { // from class: com.inmobi.media.y5$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3637y5.a(this.f$0);
            }
        });
        L4 l4P = p();
        if (l4P != null) {
            ((M4) l4P).d("InterstitialUnifiedAdManager", "AdManager state - CREATED");
        }
        a((byte) 0);
        a((Boolean) null);
        C3609w5 c3609w5 = this.interstitialAdUnit;
        if (c3609w5 != null) {
            c3609w5.g();
        }
        L4 l4P2 = p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
    }

    public static /* synthetic */ void a(C3637y5 c3637y5, E9 e9, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str = "intHtml";
        }
        c3637y5.a(e9, context, z, str);
    }

    public final void a(E9 pubSettings, Context context, boolean sendLoadCalledTelemetry, String logType) {
        C3609w5 c3609w5;
        C3609w5 c3609w6;
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logType, "logType");
        if (this.interstitialAdUnit == null) {
            this.interstitialAdUnit = new C3609w5(context, new H(com.safedk.android.analytics.brandsafety.l.w).a(pubSettings.f3059a).c(pubSettings.b).a(pubSettings.c).e(pubSettings.e).b(pubSettings.f).a(), this);
        }
        if (sendLoadCalledTelemetry) {
            w();
        }
        String str = pubSettings.e;
        if (str != null) {
            L4 l4P = p();
            if (l4P != null) {
                ((M4) l4P).a();
            }
            EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
            a(C3442ka.a(logType, str, false));
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).a("InterstitialUnifiedAdManager", "Ad Unit initialised");
            }
            L4 l4P3 = p();
            if (l4P3 != null && (c3609w6 = this.interstitialAdUnit) != null) {
                c3609w6.a(l4P3);
            }
            L4 l4P4 = p();
            if (l4P4 != null) {
                ((M4) l4P4).a("InterstitialUnifiedAdManager", "adding interstitialAdUnit in referenceTracker");
            }
            C3609w5 c3609w7 = this.interstitialAdUnit;
            Intrinsics.checkNotNull(c3609w7);
            C3442ka.a(c3609w7, p());
        }
        C3609w5 c3609w8 = this.interstitialAdUnit;
        if (c3609w8 != null) {
            c3609w8.a(context);
        }
        C3609w5 c3609w9 = this.interstitialAdUnit;
        if (c3609w9 != null) {
            c3609w9.a(pubSettings.c);
        }
        C3609w5 c3609w10 = this.interstitialAdUnit;
        if (c3609w10 != null) {
            c3609w10.c("activity");
        }
        if (pubSettings.d && (c3609w5 = this.interstitialAdUnit) != null) {
            c3609w5.E0();
        }
        WatermarkData watermarkDataT = t();
        if (watermarkDataT != null) {
            C3609w5 c3609w11 = this.interstitialAdUnit;
            if (c3609w11 != null) {
                c3609w11.a(watermarkDataT);
            }
            L4 l4P5 = p();
            if (l4P5 != null) {
                ((M4) l4P5).c("InterstitialUnifiedAdManager", "setting up watermark");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3637y5 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        L4 l4P = this$0.p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", "callback - onAdFetchSuccessful");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdFetchSuccessful(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3637y5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            ((M4) l4P).a("InterstitialUnifiedAdManager", "callback - onAdDismissed");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdDismissed();
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void a(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.a(info);
        C0 c0J = j();
        if (c0J != null) {
            c0J.x0();
        }
        this.showRequested = false;
    }

    private final void c(C0 adUnit, InMobiAdRequestStatus status) {
        byte bQ = q();
        if (bQ == 8 || bQ == 1) {
            b(adUnit, status);
            return;
        }
        if (bQ == 2) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Unable to Show Ad, canShowAd Failed");
            L4 l4P = p();
            if (l4P != null) {
                ((M4) l4P).b("InMobi", "Unable to Show Ad, canShowAd Failed");
            }
            a(true, (short) 0);
            return;
        }
        if (bQ == 5) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Ad will be dismissed, Internal error");
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).b("InMobi", "Ad will be dismissed, Internal error");
            }
            y();
            b();
            return;
        }
        AbstractC3498o6.a((byte) 1, "InMobi", "Invalid state passed in fireErrorScenarioCallback");
        L4 l4P3 = p();
        if (l4P3 != null) {
            ((M4) l4P3).b("InMobi", "Invalid state passed in fireErrorScenarioCallback");
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        super.a(watermarkData);
        C3609w5 c3609w5 = this.interstitialAdUnit;
        if (c3609w5 != null) {
            c3609w5.a(watermarkData);
        }
    }
}
