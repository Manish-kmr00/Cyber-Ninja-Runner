package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.json.nu;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.d8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0016J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u0016J\r\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u0016J\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0016J\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u001eJ\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0016J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\"R\u0014\u0010%\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010.R\u0013\u00109\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0013\u0010<\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0013\u0010>\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0013\u0010@\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b?\u0010;R\u0013\u0010B\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\bA\u0010;R\u0013\u0010D\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\bC\u0010;R\u0011\u0010H\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0011\u0010J\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bI\u0010.R\u0013\u0010M\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lcom/inmobi/media/d8;", "Lcom/inmobi/media/tc;", "Lcom/inmobi/ads/controllers/PublisherCallbacks;", "callbacks", "<init>", "(Lcom/inmobi/ads/controllers/PublisherCallbacks;)V", "Lcom/inmobi/media/E9;", "pubSettings", "Landroid/content/Context;", "context", "", "sendAdLoadTelemetry", "", "logType", "", "a", "(Lcom/inmobi/media/E9;Landroid/content/Context;ZLjava/lang/String;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/inmobi/ads/AdMetaInfo;)V", "J", "()V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", VastAttributes.HORIZONTAL_POSITION, "N", "K", "M", "L", "(Lcom/inmobi/media/E9;Landroid/content/Context;)V", "i", InneractiveMediationDefs.GENDER_FEMALE, "isMuted", "(Z)V", "o", "Ljava/lang/String;", "DEBUG_LOG_TAG", "kotlin.jvm.PlatformType", "p", "TAG", "Lcom/inmobi/media/k7;", CampaignEx.JSON_KEY_AD_Q, "Lcom/inmobi/media/k7;", "mNativeAdUnit", "F", "()Z", "isAdInReadyState", "Lcom/inmobi/media/C0;", "j", "()Lcom/inmobi/media/C0;", "adUnit", "H", "isInitialised", "Lorg/json/JSONObject;", ExifInterface.LONGITUDE_EAST, "()Lorg/json/JSONObject;", "publisherJson", "D", "()Ljava/lang/String;", "adTitle", "z", "adDescription", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "adIconUrl", "B", "adLandingPageUrl", VastAttributes.VERTICAL_POSITION, "adCtaText", "", "C", "()F", "adRating", "G", "isAppDownload", "I", "()Ljava/lang/Boolean;", "isVideo", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class C3342d8 extends AbstractC3574tc {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final String DEBUG_LOG_TAG;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final String TAG;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private C3439k7 mNativeAdUnit;

    public C3342d8(PublisherCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.DEBUG_LOG_TAG = "InMobi";
        this.TAG = "d8";
        b(callbacks);
    }

    public static /* synthetic */ void a(C3342d8 c3342d8, E9 e9, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str = "native";
        }
        c3342d8.a(e9, context, z, str);
    }

    public final String A() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null || (rVarK = c3439k7.k()) == null) {
            return null;
        }
        Object dataModel = rVarK.getDataModel();
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        if (c3625x7 == null || (c3611w7 = c3625x7.p) == null || (c3597v7 = c3611w7.b) == null) {
            return null;
        }
        return c3597v7.c;
    }

    public final String B() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null || (rVarK = c3439k7.k()) == null) {
            return null;
        }
        Object dataModel = rVarK.getDataModel();
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        if (c3625x7 == null || (c3611w7 = c3625x7.p) == null || (c3597v7 = c3611w7.b) == null) {
            return null;
        }
        return c3597v7.f;
    }

    public final float C() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null && (rVarK = c3439k7.k()) != null) {
            Object dataModel = rVarK.getDataModel();
            C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
            if (c3625x7 != null && (c3611w7 = c3625x7.p) != null && (c3597v7 = c3611w7.b) != null) {
                return c3597v7.e;
            }
        }
        return 0.0f;
    }

    public final String D() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null || (rVarK = c3439k7.k()) == null) {
            return null;
        }
        Object dataModel = rVarK.getDataModel();
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        if (c3625x7 == null || (c3611w7 = c3625x7.p) == null || (c3597v7 = c3611w7.b) == null) {
            return null;
        }
        return c3597v7.f3457a;
    }

    public final JSONObject E() {
        r rVarK;
        C3611w7 c3611w7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null || (rVarK = c3439k7.k()) == null) {
            return null;
        }
        Object dataModel = rVarK.getDataModel();
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        if (c3625x7 == null || (c3611w7 = c3625x7.p) == null) {
            return null;
        }
        return c3611w7.f3466a;
    }

    public final boolean F() {
        C3439k7 c3439k7 = this.mNativeAdUnit;
        return c3439k7 != null && c3439k7.Q() == 4;
    }

    public final boolean G() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null && (rVarK = c3439k7.k()) != null) {
            Object dataModel = rVarK.getDataModel();
            C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
            if (c3625x7 != null && (c3611w7 = c3625x7.p) != null && (c3597v7 = c3611w7.b) != null) {
                return c3597v7.g;
            }
        }
        return false;
    }

    public boolean H() {
        return this.mNativeAdUnit != null;
    }

    public final Boolean I() {
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null) {
            return Boolean.valueOf(c3439k7.k() instanceof C3398h8);
        }
        return null;
    }

    public final void J() {
        C3439k7 c3439k7;
        if (Intrinsics.areEqual(u(), Boolean.FALSE)) {
            L4 l4P = p();
            if (l4P != null) {
                ((M4) l4P).b(this.DEBUG_LOG_TAG, "Cannot call load() API after calling load(byte[])");
                return;
            }
            return;
        }
        a(Boolean.TRUE);
        C3439k7 c3439k8 = this.mNativeAdUnit;
        if (c3439k8 != null) {
            if (a(this.DEBUG_LOG_TAG, String.valueOf(c3439k8 != null ? c3439k8.I() : null), l()) && (c3439k7 = this.mNativeAdUnit) != null && c3439k7.e((byte) 1)) {
                L4 l4P2 = p();
                if (l4P2 != null) {
                    String TAG = this.TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4P2).a(TAG, "internal load timer started");
                }
                a((byte) 1);
                C3439k7 c3439k9 = this.mNativeAdUnit;
                if (c3439k9 != null) {
                    c3439k9.c0();
                }
            }
        }
    }

    public final void K() {
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "pause called");
        }
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null) {
            L4 l4 = c3439k7.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l4).c("k7", com.ironsource.b9.h.t0);
            }
            if (c3439k7.Q() != 4 || (c3439k7.t() instanceof Activity)) {
                return;
            }
            r rVarK = c3439k7.k();
            C3313b7 c3313b7 = rVarK instanceof C3313b7 ? (C3313b7) rVarK : null;
            if (c3313b7 != null) {
                c3313b7.l();
            }
        }
    }

    public final void L() {
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).c(TAG, "reportAdClickAndOpenLandingPage");
        }
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null) {
            L4 l4 = c3439k7.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l4).c("k7", "reportAdClickAndOpenLandingPage");
            }
            r rVarK = c3439k7.k();
            if (rVarK == null) {
                L4 l5 = c3439k7.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l5).b("k7", "container is null. ignoring");
                    return;
                }
                return;
            }
            C3313b7 c3313b7 = rVarK instanceof C3313b7 ? (C3313b7) rVarK : null;
            C3625x7 c3625x7 = c3313b7 != null ? c3313b7.b : null;
            if (c3625x7 instanceof C3625x7) {
                C3611w7 c3611w7 = c3625x7.p;
                C3455l7 c3455l7 = c3611w7 != null ? c3611w7.c : null;
                if (c3455l7 != null) {
                    L4 l6 = c3439k7.j;
                    if (l6 != null) {
                        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                        ((M4) l6).a("k7", "reporting ad click and opening landing page");
                    }
                    c3313b7.a((View) null, c3455l7);
                    c3313b7.a(c3455l7, true);
                }
            }
        }
    }

    public final void M() {
        Sc sc;
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "resume called");
        }
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null) {
            L4 l4 = c3439k7.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l4).c("k7", com.ironsource.b9.h.u0);
            }
            if (c3439k7.Q() != 4 || (c3439k7.t() instanceof Activity)) {
                return;
            }
            r rVarK = c3439k7.k();
            C3313b7 c3313b7 = rVarK instanceof C3313b7 ? (C3313b7) rVarK : null;
            if (c3313b7 != null) {
                L4 l5 = c3313b7.j;
                if (l5 != null) {
                    String TAG2 = c3313b7.m;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).c(TAG2, com.ironsource.b9.h.u0);
                }
                c3313b7.u = false;
                C3314b8 c3314b8A = C3313b7.a(c3313b7.g());
                if (c3314b8A != null) {
                    c3314b8A.c();
                }
                c3313b7.p();
                Context contextD = c3313b7.d();
                if (contextD == null || (sc = c3313b7.p) == null) {
                    return;
                }
                sc.a(contextD, (byte) 0);
            }
        }
    }

    public final void N() {
        C3313b7 c3313b7G;
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).c(TAG, "takeAction");
        }
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                String TAG2 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l4P2).b(TAG2, "InMobiNative is not initialized. Ignoring takeAction");
                return;
            }
            return;
        }
        if (c3439k7 == null || (c3313b7G = c3439k7.G()) == null) {
            return;
        }
        L4 l4 = c3313b7G.j;
        if (l4 != null) {
            String TAG3 = c3313b7G.m;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((M4) l4).c(TAG3, "takeAction");
        }
        C3455l7 c3455l7 = c3313b7G.E;
        String str = c3313b7G.F;
        Intent intent = c3313b7G.G;
        Context context = (Context) c3313b7G.x.get();
        if (c3455l7 != null && str != null) {
            c3313b7G.a(c3455l7, c3455l7.g, str, null);
        } else {
            if (intent == null || context == null) {
                return;
            }
            C3517pb.f3400a.a(context, intent);
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).c(TAG, "onAdFetchSuccess");
        }
        d(info);
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                String TAG2 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l4P2).b(TAG2, "adunit is null. load failed.");
            }
            a((C0) null, inMobiAdRequestStatus);
            return;
        }
        if (c3439k7.m() == null) {
            L4 l4P3 = p();
            if (l4P3 != null) {
                String TAG3 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((M4) l4P3).b(TAG3, "adObject is null. load failed");
            }
            a((C0) null, inMobiAdRequestStatus);
            return;
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.d8$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3342d8.a(this.f$0, info);
            }
        });
        if (F()) {
            return;
        }
        L4 l4P4 = p();
        if (l4P4 != null) {
            String TAG4 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            ((M4) l4P4).a(TAG4, "ad is ready. start ad render");
        }
        C3439k7 c3439k8 = this.mNativeAdUnit;
        if (c3439k8 != null) {
            c3439k8.j0();
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public void c(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).b(TAG, "onAdLoadSucceeded");
        }
        super.c(info);
        a((byte) 2);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l4P2).d(TAG2, "AdManager state - LOADED");
        }
        s().post(new Runnable() { // from class: com.inmobi.media.d8$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                C3342d8.b(this.f$0, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void d() {
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).b(TAG, nu.e);
        }
        L4 l4P2 = p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void f() {
        s().post(new Runnable() { // from class: com.inmobi.media.d8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3342d8.b(this.f$0);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void i() {
        s().post(new Runnable() { // from class: com.inmobi.media.d8$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3342d8.c(this.f$0);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public C0 j() {
        return this.mNativeAdUnit;
    }

    public final void x() {
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "destroy called");
        }
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null) {
            c3439k7.C0();
        }
        this.mNativeAdUnit = null;
        L4 l4P2 = p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
    }

    public final String y() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null || (rVarK = c3439k7.k()) == null) {
            return null;
        }
        Object dataModel = rVarK.getDataModel();
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        if (c3625x7 == null || (c3611w7 = c3625x7.p) == null || (c3597v7 = c3611w7.b) == null) {
            return null;
        }
        return c3597v7.d;
    }

    public final String z() {
        r rVarK;
        C3611w7 c3611w7;
        C3597v7 c3597v7;
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 == null || (rVarK = c3439k7.k()) == null) {
            return null;
        }
        Object dataModel = rVarK.getDataModel();
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        if (c3625x7 == null || (c3611w7 = c3625x7.p) == null || (c3597v7 = c3611w7.b) == null) {
            return null;
        }
        return c3597v7.b;
    }

    public final void a(E9 pubSettings, Context context, boolean sendAdLoadTelemetry, String logType) {
        C3439k7 c3439k7;
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logType, "logType");
        C3439k7 c3439k8 = this.mNativeAdUnit;
        if (c3439k8 == null) {
            H hA = new H("native").a(pubSettings.f3059a);
            Intrinsics.checkNotNullParameter(context, "context");
            this.mNativeAdUnit = new C3439k7(context, hA.d(context instanceof Activity ? "activity" : "others").c(pubSettings.b).a(pubSettings.c).a(pubSettings.d).e(pubSettings.e).b(pubSettings.f).a(), this);
        } else {
            c3439k8.a(context);
            C3439k7 c3439k9 = this.mNativeAdUnit;
            if (c3439k9 != null) {
                Intrinsics.checkNotNullParameter(context, "context");
                c3439k9.c(context instanceof Activity ? "activity" : "others");
            }
        }
        if (sendAdLoadTelemetry) {
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
            if (l4P2 != null && (c3439k7 = this.mNativeAdUnit) != null) {
                c3439k7.a(l4P2);
            }
            L4 l4P3 = p();
            if (l4P3 != null) {
                String TAG = this.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4P3).a(TAG, "adding mNativeAdUnit to referenceTracker");
            }
            C3439k7 c3439k10 = this.mNativeAdUnit;
            Intrinsics.checkNotNull(c3439k10);
            C3442ka.a(c3439k10, p());
        }
        L4 l4P4 = p();
        if (l4P4 != null) {
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l4P4).a(TAG2, "load called");
        }
        C3439k7 c3439k11 = this.mNativeAdUnit;
        if (c3439k11 != null) {
            c3439k11.a(pubSettings.c);
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void c() {
        s().post(new Runnable() { // from class: com.inmobi.media.d8$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3342d8.a(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3342d8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "callback - onVideoSkipped");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onVideoSkipped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3342d8 this$0, AdMetaInfo info) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3342d8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "callback - onVideoCompleted");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onVideoCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3342d8 this$0, AdMetaInfo info) {
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
        }
    }

    public final void a(E9 pubSettings, Context context) {
        Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.mNativeAdUnit == null) {
            a(this, pubSettings, context, false, null, 8, null);
        }
        L4 l4P = p();
        if (l4P != null) {
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).c(TAG, "showOnLockScreen");
        }
        C3439k7 c3439k7 = this.mNativeAdUnit;
        if (c3439k7 != null) {
            c3439k7.N = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3342d8 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "callback - onAdImpressed");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdImpressed();
        }
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public void a(final boolean isMuted) {
        s().post(new Runnable() { // from class: com.inmobi.media.d8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3342d8.a(this.f$0, isMuted);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3342d8 this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String TAG = this$0.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4P).a(TAG, "callback -onAudioStateChanged - " + z);
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAudioStateChanged(z);
        }
    }
}
