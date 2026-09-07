package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Timeline;
import com.mbridge.msdk.foundation.entity.b;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class R6 {
    public static String[] A06 = {"CAIO5ZQJoGrrOYShD7hb2jiJtmk90Qi", "TVIw8CVNsHI8wTkpJw1XHrztCtft", "hXBhXV1DxyebNKssUcoRgSkElFX8fpm5", b.JSON_KEY_SH, "h0BA7IDzuN7Fql7dlqkH9zMz4fjHlNyu", "S0x90T2j3ZCyjO2U6ODKJCntdTZqcz3L", "hOHnW70bNUwWCTfewRWjhec4kQ4QjIMO", "K0FTOijIvuGKFCgSHX8vkdIGhyuEVDr"};
    public R5 A00;
    public R5 A01;
    public R5 A02;
    public OI<R5> A03 = OI.A03();
    public AbstractC2804lm<R5, Timeline> A04 = AbstractC2804lm.A04();
    public final C2050Yh A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static R5 A00(QQ qq, OI<R5> oi, R5 r5, C2050Yh c2050Yh) {
        Object obj;
        int i;
        Timeline timelineA7W = qq.A7W();
        int iA7S = qq.A7S();
        Object objA0M = timelineA7W.A0N() ? null : timelineA7W.A0M(iA7S);
        int iA07 = (qq.AAS() || timelineA7W.A0N()) ? -1 : timelineA7W.A0H(iA7S, c2050Yh).A07(AbstractC2471gE.A0O(qq.A7U()) - c2050Yh.A0C());
        for (int i2 = 0; i2 < oi.size(); i2++) {
            R5 r6 = oi.get(i2);
            if (A04(r6, objA0M, qq.AAS(), qq.A7O(), qq.A7P(), iA07)) {
                return r6;
            }
        }
        if (oi.isEmpty() && r5 != null) {
            boolean zA04 = A04(r5, obj, qq.AAS(), qq.A7O(), qq.A7P(), i);
            String[] strArr = A06;
            if (strArr[0].length() != strArr[7].length()) {
                obj = objA0M;
                i = iA07;
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "hRaN6qxPXnRTLNonta3GQ8ayDyE0Qqlg";
            strArr2[6] = "hWALmW4eIM2WQjCeUFcaRlEmuoVApryP";
            if (zA04) {
                obj = objA0M;
                i = iA07;
                return r5;
            }
        }
        obj = objA0M;
        i = iA07;
        return null;
    }

    public R6(C2050Yh c2050Yh) {
        this.A05 = c2050Yh;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lk != com.google.common.collect.ImmutableMap$Builder<com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.Timeline> */
    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "builder of ImmutableMap should be a buildOrThrow")
    private void A02(Timeline timeline) {
        C2802lk<R5, Timeline> c2802lkA03 = AbstractC2804lm.A03();
        if (this.A03.isEmpty()) {
            A03(c2802lkA03, this.A01, timeline);
            if (!AbstractC1813Or.A01(this.A02, this.A01)) {
                A03(c2802lkA03, this.A02, timeline);
            }
            if (!AbstractC1813Or.A01(this.A00, this.A01) && !AbstractC1813Or.A01(this.A00, this.A02)) {
                A03(c2802lkA03, this.A00, timeline);
            }
        } else {
            for (int i = 0; i < this.A03.size(); i++) {
                A03(c2802lkA03, this.A03.get(i), timeline);
            }
            if (!this.A03.contains(this.A00)) {
                A03(c2802lkA03, this.A00, timeline);
            }
        }
        this.A04 = c2802lkA03.A07();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lk != com.google.common.collect.ImmutableMap$Builder<com.google.android.exoplayer2.source.MediaSource$MediaPeriodId, com.google.android.exoplayer2.Timeline> */
    private void A03(C2802lk<R5, Timeline> c2802lk, R5 r5, Timeline timeline) {
        if (r5 == null) {
            return;
        }
        if (timeline.A0A(r5.A04) != -1) {
            c2802lk.A05(r5, timeline);
            return;
        }
        Timeline existingTimeline = this.A04.get(r5);
        if (existingTimeline == null) {
            return;
        }
        c2802lk.A05(r5, existingTimeline);
    }

    public static boolean A04(R5 r5, Object obj, boolean z, int i, int i2, int i3) {
        if (r5.A04.equals(obj)) {
            return (z && r5.A00 == i && r5.A01 == i2) || (!z && r5.A00 == -1 && r5.A02 == i3);
        }
        return false;
    }

    public final Timeline A05(R5 r5) {
        return this.A04.get(r5);
    }

    public final R5 A06() {
        return this.A00;
    }

    public final void A07(QQ qq) {
        this.A00 = A00(qq, this.A03, this.A01, this.A05);
        A02(qq.A7W());
    }
}
