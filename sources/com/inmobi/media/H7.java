package com.inmobi.media;

import com.google.common.base.Ascii;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes5.dex */
public final class H7 implements InterfaceC3500o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ L7 f3089a;
    public final /* synthetic */ C3426j8 b;

    public H7(L7 l7, C3426j8 c3426j8) {
        this.f3089a = l7;
        this.b = c3426j8;
    }

    public final void a(byte b) {
        C3313b7 c3313b7 = this.f3089a.b;
        if (c3313b7.t || !(c3313b7 instanceof C3398h8)) {
            return;
        }
        C3398h8 c3398h8 = (C3398h8) c3313b7;
        C3426j8 videoAsset = this.b;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (!c3398h8.t) {
            if (b == 0) {
                videoAsset.a(EventConstants.FIRST_QUARTILE, c3398h8.j(videoAsset), (T6) null, c3398h8.W);
                L4 l4 = c3398h8.W;
                if (l4 != null) {
                    String TAG = c3398h8.X;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).c(TAG, "onVideoQuartileEvent(Q1)");
                }
                Sc sc = c3398h8.p;
                if (sc != null) {
                    sc.a((byte) 9);
                }
            } else if (b == 1) {
                videoAsset.a("midpoint", c3398h8.j(videoAsset), (T6) null, c3398h8.W);
                L4 l5 = c3398h8.W;
                if (l5 != null) {
                    String TAG2 = c3398h8.X;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).c(TAG2, "onVideoQuartileEvent(Q2)");
                }
                Sc sc2 = c3398h8.p;
                if (sc2 != null) {
                    sc2.a((byte) 10);
                }
            } else if (b == 2) {
                videoAsset.a(EventConstants.THIRD_QUARTILE, c3398h8.j(videoAsset), (T6) null, c3398h8.W);
                L4 l6 = c3398h8.W;
                if (l6 != null) {
                    String TAG3 = c3398h8.X;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l6).c(TAG3, "onVideoQuartileEvent(Q3)");
                }
                Sc sc3 = c3398h8.p;
                if (sc3 != null) {
                    sc3.a(Ascii.VT);
                }
            } else if (b == 3) {
                Object obj = videoAsset.t.get("didQ4Fire");
                if (Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.FALSE)) {
                    c3398h8.d(videoAsset);
                }
            } else {
                L4 l7 = c3398h8.W;
                if (l7 != null) {
                    String TAG4 = c3398h8.X;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    ((M4) l7).b(TAG4, "Unhandled quartileEvent ( " + ((int) b) + " ) for Native Video");
                }
            }
        }
        if (3 == b) {
            try {
                ((C3398h8) this.f3089a.b).c(this.b);
            } catch (Exception e) {
                L7 l8 = this.f3089a;
                L4 l9 = l8.f;
                if (l9 != null) {
                    String str = l8.g;
                    ((M4) l9).b(str, ld.a(e, O5.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in handling the onVideoCompleted event; ")));
                }
            }
        }
    }
}
