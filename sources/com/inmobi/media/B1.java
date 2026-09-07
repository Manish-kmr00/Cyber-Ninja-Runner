package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.commons.core.configs.AdConfig;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0003J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0017¢\u0006\u0004\b\f\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u0015J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\f\u0010 J\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u0003J!\u0010\f\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\f\u0010$J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u0003J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b\f\u0010(J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b\f\u0010+J\r\u0010,\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\u0003J\r\u0010-\u001a\u00020\u000b¢\u0006\u0004\b-\u0010\u0003J\u001d\u0010\f\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0016¢\u0006\u0004\b\f\u00100J\u0015\u0010\f\u001a\u00020\u00132\u0006\u00102\u001a\u000201¢\u0006\u0004\b\f\u00103J\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u0010\u0003J\r\u00105\u001a\u00020\u0013¢\u0006\u0004\b5\u0010\u0015J\r\u00106\u001a\u00020\u000b¢\u0006\u0004\b6\u0010\u0003J\r\u00107\u001a\u00020\u000b¢\u0006\u0004\b7\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b\u0010\u0010:J\u000f\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010\u0015J\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020&H\u0002¢\u0006\u0004\b\u0010\u0010(R\u0014\u0010?\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010B\u001a\n @*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010>R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010ER\u0016\u0010P\u001a\u0004\u0018\u00010M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0015R\u0011\u0010U\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010W\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bV\u0010\u0015¨\u0006X"}, d2 = {"Lcom/inmobi/media/B1;", "Lcom/inmobi/media/tc;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/inmobi/media/E9;", "pubSettings", "", "adSize", "logType", "", "a", "(Landroid/content/Context;Lcom/inmobi/media/E9;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/inmobi/ads/AdMetaInfo;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "C", "()Z", "", "next", "callerIndex", "Lcom/inmobi/media/Ba;", "renderView", "(IILcom/inmobi/media/Ba;)V", VastAttributes.VERTICAL_POSITION, "Lcom/inmobi/ads/controllers/PublisherCallbacks;", "callbacks", "isRefreshRequest", "(Lcom/inmobi/ads/controllers/PublisherCallbacks;Ljava/lang/String;Z)V", "G", "", "response", "([BLcom/inmobi/ads/controllers/PublisherCallbacks;)V", "J", "Landroid/widget/RelativeLayout;", "banner", "(Landroid/widget/RelativeLayout;)V", "Lcom/inmobi/ads/WatermarkData;", "watermarkData", "(Lcom/inmobi/ads/WatermarkData;)V", "H", ExifInterface.LONGITUDE_EAST, "_refreshInterval", "previousInterval", "(II)I", "", "adLoadCalledTimestamp", "(J)Z", "K", VastAttributes.HORIZONTAL_POSITION, "F", "z", "", "errorCode", "(S)V", "I", "inMobiBanner", "o", "Ljava/lang/String;", "DEBUG_LOG_TAG", "kotlin.jvm.PlatformType", "p", "TAG", "Lcom/inmobi/media/w1;", CampaignEx.JSON_KEY_AD_Q, "Lcom/inmobi/media/w1;", "mBannerAdUnit1", "r", "mBannerAdUnit2", "s", "mForegroundBannerAdUnit", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "mBackgroundBannerAdUnit", "Lcom/inmobi/media/C0;", "j", "()Lcom/inmobi/media/C0;", "adUnit", "D", "isInitialised", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "defaultRefreshInterval", "B", "isActive", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class B1 extends AbstractC3574tc {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final String DEBUG_LOG_TAG = "InMobi";

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final String TAG = "B1";

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private C3605w1 mBannerAdUnit1;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private C3605w1 mBannerAdUnit2;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private C3605w1 mForegroundBannerAdUnit;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private C3605w1 mBackgroundBannerAdUnit;

    private final boolean I() {
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        Byte bValueOf = c3605w1 != null ? Byte.valueOf(c3605w1.Q()) : null;
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).c(TAG, "shouldUseForegroundUnit " + this + " state - " + bValueOf);
        }
        return (bValueOf != null && bValueOf.byteValue() == 4) || (bValueOf != null && bValueOf.byteValue() == 7) || (bValueOf != null && bValueOf.byteValue() == 6);
    }

    public final int A() {
        AdConfig adConfigJ;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "defaultRefreshInterval ", this));
        }
        C0 c0J = j();
        if (c0J == null || (adConfigJ = c0J.j()) == null) {
            return -1;
        }
        return adConfigJ.getDefaultRefreshInterval();
    }

    public final boolean B() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        Intrinsics.areEqual(this.mForegroundBannerAdUnit, this.mBannerAdUnit1);
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.areEqual(this.mBackgroundBannerAdUnit, this.mBannerAdUnit1);
        String TAG3 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        Intrinsics.areEqual(this.mForegroundBannerAdUnit, this.mBannerAdUnit2);
        String TAG4 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
        Intrinsics.areEqual(this.mBackgroundBannerAdUnit, this.mBannerAdUnit2);
        String TAG5 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
        C3605w1 c3605w1 = this.mBannerAdUnit1;
        if (c3605w1 != null) {
            c3605w1.D0();
        }
        C3605w1 c3605w2 = this.mBannerAdUnit1;
        if (c3605w2 != null) {
            c3605w2.Q();
        }
        Objects.toString(this.mBannerAdUnit1);
        String TAG6 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
        C3605w1 c3605w3 = this.mBannerAdUnit2;
        if (c3605w3 != null) {
            c3605w3.D0();
        }
        C3605w1 c3605w4 = this.mBannerAdUnit2;
        if (c3605w4 != null) {
            c3605w4.Q();
        }
        Objects.toString(this.mBannerAdUnit2);
        C3605w1 c3605w5 = this.mForegroundBannerAdUnit;
        if (c3605w5 != null) {
            return c3605w5.D0();
        }
        return false;
    }

    public final boolean C() {
        C3389h c3389hM;
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        if (c3605w1 == null || (c3389hM = c3605w1.m()) == null) {
            return false;
        }
        return Intrinsics.areEqual(c3389hM.p(), "audio");
    }

    public boolean D() {
        return (this.mBannerAdUnit1 == null || this.mBannerAdUnit2 == null) ? false : true;
    }

    public final void E() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "pause ", this));
        }
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        if (c3605w1 != null) {
            c3605w1.E0();
        }
    }

    public final void F() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "registerLifeCycleCallbacks ", this));
        }
        C3605w1 c3605w1 = this.mBannerAdUnit1;
        if (c3605w1 != null) {
            c3605w1.G0();
        }
        C3605w1 c3605w2 = this.mBannerAdUnit2;
        if (c3605w2 != null) {
            c3605w2.G0();
        }
    }

    public final void G() throws IllegalStateException {
        C3605w1 c3605w1;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "render ", this));
        }
        C3605w1 c3605w2 = this.mBackgroundBannerAdUnit;
        if (c3605w2 == null) {
            throw new IllegalStateException(AbstractC3574tc.m);
        }
        if (c3605w2 == null || !a(this.DEBUG_LOG_TAG, c3605w2.I().toString())) {
            return;
        }
        if (v() && (c3605w1 = this.mBackgroundBannerAdUnit) != null) {
            c3605w1.e((byte) 1);
        }
        a((byte) 8);
        c3605w2.j0();
    }

    public final void H() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "resume ", this));
        }
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        if (c3605w1 != null) {
            c3605w1.F0();
        }
    }

    public final void J() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "swapAdUnits ", this));
        }
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        if (c3605w1 == null) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit1;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit2;
        } else if (Intrinsics.areEqual(c3605w1, this.mBannerAdUnit1)) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit2;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit1;
        } else if (Intrinsics.areEqual(c3605w1, this.mBannerAdUnit2)) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit1;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit2;
        }
    }

    public final void K() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "unregisterLifeCycleCallbacks ", this));
        }
        C3605w1 c3605w1 = this.mBannerAdUnit1;
        if (c3605w1 != null) {
            c3605w1.I0();
        }
        C3605w1 c3605w2 = this.mBannerAdUnit2;
        if (c3605w2 != null) {
            c3605w2.I0();
        }
    }

    public final void a(Context context, E9 pubSettings, String adSize, String logType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullExpressionValue(this.TAG, "TAG");
        H h = new H("banner");
        Intrinsics.checkNotNullParameter(context, "context");
        J jA = h.d(context instanceof Activity ? "activity" : "others").a(pubSettings.f3059a).c(pubSettings.b).a(pubSettings.c).a(adSize).a(pubSettings.d).e(pubSettings.e).b(pubSettings.f).a();
        String str = pubSettings.e;
        if (str != null) {
            L4 l4P = p();
            if (l4P != null) {
                ((M4) l4P).a();
            }
            EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
            a(C3442ka.a(logType, str, false));
        }
        C3605w1 c3605w1 = this.mBannerAdUnit1;
        if (c3605w1 == null || this.mBannerAdUnit2 == null) {
            this.mBannerAdUnit1 = new C3605w1(context, jA, this);
            C3605w1 c3605w2 = new C3605w1(context, jA, this);
            this.mBannerAdUnit2 = c3605w2;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit1;
            this.mForegroundBannerAdUnit = c3605w2;
        } else {
            c3605w1.a(context, jA, this);
            C3605w1 c3605w3 = this.mBannerAdUnit2;
            if (c3605w3 != null) {
                c3605w3.a(context, jA, this);
            }
        }
        L4 l4P2 = p();
        if (l4P2 != null) {
            C3605w1 c3605w4 = this.mBannerAdUnit1;
            if (c3605w4 != null) {
                c3605w4.a(l4P2);
            }
            C3605w1 c3605w5 = this.mBannerAdUnit2;
            if (c3605w5 != null) {
                c3605w5.a(l4P2);
            }
            L4 l4P3 = p();
            if (l4P3 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4P3).a(TAG, "adding mBannerAdUnit1 to reference tracker");
            }
            EnumC3396h6 enumC3396h7 = C3442ka.f3360a;
            C3605w1 c3605w6 = this.mBannerAdUnit1;
            Intrinsics.checkNotNull(c3605w6);
            C3442ka.a(c3605w6, p());
            L4 l4P4 = p();
            if (l4P4 != null) {
                String TAG2 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l4P4).a(TAG2, "adding mBannerAdUnit2 to reference tracker");
            }
            C3605w1 c3605w7 = this.mBannerAdUnit2;
            Intrinsics.checkNotNull(c3605w7);
            C3442ka.a(c3605w7, p());
        }
        WatermarkData watermarkDataT = t();
        if (watermarkDataT != null) {
            C3605w1 c3605w8 = this.mBannerAdUnit1;
            if (c3605w8 != null) {
                c3605w8.a(watermarkDataT);
            }
            C3605w1 c3605w9 = this.mBannerAdUnit2;
            if (c3605w9 != null) {
                c3605w9.a(watermarkDataT);
            }
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "onAdFetchSuccess ", this));
        }
        d(info);
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        C3605w1 c3605w1 = this.mBackgroundBannerAdUnit;
        if ((c3605w1 != null ? c3605w1.m() : null) == null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4P2).b(TAG, "backgroundAdUnit ad object is null");
            }
            a((C0) null, inMobiAdRequestStatus);
            b((short) 2189);
            return;
        }
        L4 l4P3 = p();
        if (l4P3 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l4P3).a(TAG2, "Ad fetch successful, calling loadAd()");
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.B1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                B1.a(this.f$0, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void c(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "onAdLoadSucceeded ", this));
        }
        super.c(info);
        a((byte) 0);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P2).a(TAG, "Ad load successful, providing callback");
        }
        s().post(new Runnable() { // from class: com.inmobi.media.B1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                B1.b(this.f$0, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public C0 j() {
        return I() ? this.mForegroundBannerAdUnit : this.mBackgroundBannerAdUnit;
    }

    public final boolean x() {
        C3605w1 c3605w1;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "canProceedForSuccess ", this));
        }
        if (this.mForegroundBannerAdUnit != null && (c3605w1 = this.mBackgroundBannerAdUnit) != null) {
            c3605w1.Q();
        }
        return true;
    }

    public final boolean y() {
        C3605w1 c3605w1;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "canScheduleRefresh ", this));
        }
        C3605w1 c3605w2 = this.mBackgroundBannerAdUnit;
        if (c3605w2 == null) {
            return false;
        }
        Byte bValueOf = c3605w2 != null ? Byte.valueOf(c3605w2.Q()) : null;
        if ((bValueOf == null || bValueOf.byteValue() != 4) && ((bValueOf == null || bValueOf.byteValue() != 1) && ((bValueOf == null || bValueOf.byteValue() != 2) && ((c3605w1 = this.mForegroundBannerAdUnit) == null || c3605w1.Q() != 7)))) {
            return true;
        }
        L4 l4P2 = p();
        if (l4P2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P2).a(TAG, "Ignoring an attempt to schedule refresh when an ad is already loading or active.");
        }
        return false;
    }

    public final void z() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "clear ", this));
        }
        K();
        C3605w1 c3605w1 = this.mBannerAdUnit1;
        if (c3605w1 != null) {
            c3605w1.g();
        }
        this.mBannerAdUnit1 = null;
        C3605w1 c3605w2 = this.mBannerAdUnit2;
        if (c3605w2 != null) {
            c3605w2.g();
        }
        this.mBannerAdUnit2 = null;
        a((L4) null);
        this.mForegroundBannerAdUnit = null;
        this.mBackgroundBannerAdUnit = null;
        a((Boolean) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(B1 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "callback - onAdFetchSuccessful");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdFetchSuccessful(info);
            return;
        }
        L4 l4P2 = this$0.p();
        if (l4P2 != null) {
            String TAG2 = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l4P2).b(TAG2, "callback null");
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(int next, final int callerIndex, Ba renderView) {
        ViewParent parent;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "onShowNextPodAd ", this));
        }
        super.a(next, callerIndex, renderView);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P2).a(TAG, "on Show next pod ad index: " + next);
        }
        if (renderView != null) {
            try {
                parent = renderView.getParent();
            } catch (Exception unused) {
                C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
                if (c3605w1 != null) {
                    c3605w1.f(callerIndex);
                }
                C3605w1 c3605w2 = this.mForegroundBannerAdUnit;
                if (c3605w2 != null) {
                    c3605w2.b(callerIndex, false);
                    return;
                }
                return;
            }
        } else {
            parent = null;
        }
        InMobiBanner inMobiBanner = parent instanceof InMobiBanner ? (InMobiBanner) parent : null;
        if (inMobiBanner != null) {
            C3605w1 c3605w3 = this.mForegroundBannerAdUnit;
            if (c3605w3 != null) {
                c3605w3.b(callerIndex, true);
            }
            b(inMobiBanner);
            s().post(new Runnable() { // from class: com.inmobi.media.B1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    B1.a(this.f$0, callerIndex);
                }
            });
            return;
        }
        C3605w1 c3605w4 = this.mForegroundBannerAdUnit;
        if (c3605w4 != null) {
            c3605w4.f(callerIndex);
        }
        C3605w1 c3605w5 = this.mForegroundBannerAdUnit;
        if (c3605w5 != null) {
            c3605w5.b(callerIndex, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(B1 this$0, AdMetaInfo info) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "callback - onAdLoadSucceeded");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdLoadSucceeded(info);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.b((short) 2184);
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void b() {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "onAdDismissed ", this));
        }
        a((byte) 0);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P2).d(TAG, "AdManager state - CREATED");
        }
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(B1 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3605w1 c3605w1 = this$0.mForegroundBannerAdUnit;
        if (c3605w1 != null) {
            c3605w1.a(i, false);
        }
    }

    public final void a(PublisherCallbacks callbacks, String adSize, boolean isRefreshRequest) {
        C3605w1 c3605w1;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "load 1 ", this));
        }
        if (Intrinsics.areEqual(u(), Boolean.FALSE)) {
            b(this.mBackgroundBannerAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
            C3605w1 c3605w2 = this.mBackgroundBannerAdUnit;
            if (c3605w2 != null) {
                c3605w2.a((short) 2006);
            }
            AbstractC3498o6.a((byte) 1, this.DEBUG_LOG_TAG, "Cannot call load() API after calling load(byte[])");
            L4 l4P2 = p();
            if (l4P2 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4P2).b(TAG, "Cannot call load() API after calling load(byte[])");
                return;
            }
            return;
        }
        a(Boolean.TRUE);
        if (l() == null) {
            b(callbacks);
        }
        C3605w1 c3605w3 = this.mBackgroundBannerAdUnit;
        if (c3605w3 == null || !a(this.DEBUG_LOG_TAG, String.valueOf(c3605w3.I()), callbacks) || (c3605w1 = this.mBackgroundBannerAdUnit) == null || !c3605w1.e(o())) {
            return;
        }
        L4 l4P3 = p();
        if (l4P3 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l4P3).d(TAG2, "AdManager state - LOADING");
        }
        a((byte) 1);
        d(null);
        C3605w1 c3605w4 = this.mBackgroundBannerAdUnit;
        Intrinsics.checkNotNull(c3605w4);
        c3605w4.e(adSize);
        C3605w1 c3605w5 = this.mBackgroundBannerAdUnit;
        Intrinsics.checkNotNull(c3605w5);
        c3605w5.d(isRefreshRequest);
    }

    private final void b(RelativeLayout inMobiBanner) {
        J jI;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "displayInternal ", this));
        }
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        if (c3605w1 == null) {
            return;
        }
        r rVarK = c3605w1.k();
        Ba ba = rVarK instanceof Ba ? (Ba) rVarK : null;
        if (ba == null) {
            return;
        }
        Tc viewableAd = ba.getViewableAd();
        C3605w1 c3605w2 = this.mForegroundBannerAdUnit;
        if (c3605w2 != null && (jI = c3605w2.I()) != null && jI.p()) {
            ba.e();
        }
        View viewD = viewableAd.d();
        viewableAd.a(new HashMap());
        ViewParent parent = ba.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (viewGroup == null) {
            inMobiBanner.addView(viewD, layoutParams);
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(viewD, layoutParams);
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public void a(byte[] response, PublisherCallbacks callbacks) {
        C3605w1 c3605w1;
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "load 2 ", this));
        }
        if (Intrinsics.areEqual(u(), Boolean.TRUE)) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Cannot call load(byte[]) API after load() API is called");
            L4 l4P2 = p();
            if (l4P2 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4P2).b(TAG, "Cannot call load(byte[]) API after load() API is called");
                return;
            }
            return;
        }
        a(Boolean.FALSE);
        a((byte) 1);
        b(callbacks);
        if (this.mBackgroundBannerAdUnit != null) {
            C3605w1 c3605w2 = this.mForegroundBannerAdUnit;
            if ((c3605w2 == null || !c3605w2.Y()) && (c3605w1 = this.mBackgroundBannerAdUnit) != null && c3605w1.e((byte) 1)) {
                L4 l4P3 = p();
                if (l4P3 != null) {
                    String TAG2 = this.TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l4P3).a(TAG2, "timer started - load banner");
                }
                C3605w1 c3605w3 = this.mBackgroundBannerAdUnit;
                if (c3605w3 != null) {
                    c3605w3.e0();
                }
                C3605w1 c3605w4 = this.mBackgroundBannerAdUnit;
                if (c3605w4 != null) {
                    c3605w4.a(response);
                }
            }
        }
    }

    public final void b(short errorCode) {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "submitAdLoadFailed ", this));
        }
        C0 c0J = j();
        if (c0J != null) {
            c0J.b(errorCode);
        }
    }

    public final void a(RelativeLayout banner) {
        J jI;
        Intrinsics.checkNotNullParameter(banner, "banner");
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).a(str, A1.a(str, "TAG", "displayAd ", this));
        }
        C3605w1 c3605w1 = this.mForegroundBannerAdUnit;
        r rVarK = c3605w1 != null ? c3605w1.k() : null;
        Ba ba = rVarK instanceof Ba ? (Ba) rVarK : null;
        if (ba == null) {
            return;
        }
        Tc viewableAd = ba.getViewableAd();
        C3605w1 c3605w2 = this.mForegroundBannerAdUnit;
        if (c3605w2 != null && (jI = c3605w2.I()) != null && jI.p()) {
            ba.e();
        }
        ViewParent parent = ba.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View viewD = viewableAd.d();
        viewableAd.a(new HashMap());
        C3605w1 c3605w3 = this.mBackgroundBannerAdUnit;
        if (c3605w3 != null) {
            c3605w3.E0();
        }
        if (viewGroup == null) {
            banner.addView(viewD, layoutParams);
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(viewD, layoutParams);
        }
        C3605w1 c3605w4 = this.mBackgroundBannerAdUnit;
        if (c3605w4 != null) {
            c3605w4.g();
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        super.a(watermarkData);
        C3605w1 c3605w1 = this.mBannerAdUnit1;
        if (c3605w1 != null) {
            c3605w1.a(watermarkData);
        }
        C3605w1 c3605w2 = this.mBannerAdUnit2;
        if (c3605w2 != null) {
            c3605w2.a(watermarkData);
        }
    }

    public final int a(int _refreshInterval, int previousInterval) {
        AdConfig adConfigJ;
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "getRefreshInterval ", this));
        }
        C3605w1 c3605w1 = this.mBackgroundBannerAdUnit;
        if (c3605w1 == null || (adConfigJ = c3605w1.j()) == null) {
            return previousInterval;
        }
        return _refreshInterval < adConfigJ.getMinimumRefreshInterval() ? adConfigJ.getMinimumRefreshInterval() : _refreshInterval;
    }

    public final boolean a(long adLoadCalledTimestamp) {
        L4 l4P = p();
        if (l4P != null) {
            String str = this.TAG;
            ((M4) l4P).c(str, A1.a(str, "TAG", "checkForRefreshRate ", this));
        }
        C3605w1 c3605w1 = this.mBackgroundBannerAdUnit;
        if (c3605w1 == null) {
            return false;
        }
        AdConfig adConfigJ = c3605w1.j();
        Intrinsics.checkNotNull(adConfigJ);
        int minimumRefreshInterval = adConfigJ.getMinimumRefreshInterval();
        if (SystemClock.elapsedRealtime() - adLoadCalledTimestamp >= minimumRefreshInterval * 1000) {
            return true;
        }
        a((short) 2175);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P2).b(TAG, "Early refresh request");
        }
        b(this.mBackgroundBannerAdUnit, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + minimumRefreshInterval + " seconds"));
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        StringBuilder sbAppend = new StringBuilder("Ad cannot be refreshed before ").append(minimumRefreshInterval).append(" seconds (AdPlacement Id = ");
        C3605w1 c3605w2 = this.mBackgroundBannerAdUnit;
        AbstractC3498o6.a((byte) 1, TAG2, sbAppend.append(c3605w2 != null ? c3605w2.I() : null).append(')').toString());
        L4 l4P3 = p();
        if (l4P3 != null) {
            String TAG3 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            StringBuilder sbAppend2 = new StringBuilder("Ad cannot be refreshed before ").append(minimumRefreshInterval).append(" seconds (AdPlacement Id = ");
            C3605w1 c3605w3 = this.mBackgroundBannerAdUnit;
            ((M4) l4P3).b(TAG3, sbAppend2.append(c3605w3 != null ? c3605w3.I() : null).append(')').toString());
        }
        return false;
    }
}
