package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q9 {
    public static final R5 A0E = new R5(new Object());
    public final int A00;
    public final long A01;
    public final long A02;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Start Stall Logging")
    public final MI A03;
    public final Timeline A04;
    public final R5 A05;
    public final R5 A06;
    public final C1863Qs A07;
    public final C2290dH A08;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "Determine if stall is from Audio for logging")
    public final boolean A09;
    public final boolean A0A;
    public volatile long A0B;
    public volatile long A0C;
    public volatile long A0D;

    public Q9(Timeline timeline, long j, C1863Qs c1863Qs, C2290dH c2290dH) {
        this(timeline, A0E, j, -9223372036854775807L, 1, false, c1863Qs, c2290dH, A0E, j, j, j, MI.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to call base constructor")
    public Q9(Timeline timeline, R5 r5, long j, long j2, int i, boolean z, C1863Qs c1863Qs, C2290dH c2290dH, R5 r6, long j3, long j4, long j5) {
        this(timeline, r5, j, j2, i, z, c1863Qs, c2290dH, r6, j3, j4, j5, MI.A09, false);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Customized to add new parameters")
    public Q9(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) Timeline timeline, @MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) R5 r5, long j, long j2, int i, boolean z, C1863Qs c1863Qs, C2290dH c2290dH, R5 r6, long j3, long j4, long j5, MI mi, boolean z2) {
        this.A04 = timeline;
        this.A06 = r5;
        this.A02 = j;
        this.A01 = j2;
        this.A0C = j;
        this.A00 = i;
        this.A0A = z;
        this.A07 = c1863Qs;
        this.A08 = c2290dH;
        this.A05 = r6;
        this.A0B = j3;
        this.A0D = j4;
        this.A0C = j5;
        this.A03 = mi;
        this.A09 = z2;
    }

    public static void A00(Q9 q9, Q9 q10) {
        q10.A0C = q9.A0C;
        q10.A0B = q9.A0B;
        q10.A0D = q9.A0D;
    }

    public final Q9 A01(int i) {
        Q9 q9 = new Q9(this.A04, this.A06, this.A02, this.A01, i, this.A0A, this.A07, this.A08, this.A05, this.A0B, this.A0D, this.A0C, this.A03, this.A09);
        A00(this, q9);
        return q9;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Stall Reason Logging in Hero")
    public final Q9 A02(int i, MI mi, boolean z) {
        Q9 q9 = new Q9(this.A04, this.A06, this.A02, this.A01, i, this.A0A, this.A07, this.A08, this.A05, this.A0B, this.A0D, this.A0C, mi, z);
        A00(this, q9);
        return q9;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "To track Audio Stalls for Logging")
    public final Q9 A03(int i, boolean z) {
        Q9 q9 = new Q9(this.A04, this.A06, this.A02, this.A01, i, this.A0A, this.A07, this.A08, this.A05, this.A0B, this.A0D, this.A0C, this.A03, z);
        A00(this, q9);
        return q9;
    }

    public final Q9 A04(Timeline timeline) {
        Q9 q9 = new Q9(timeline, this.A06, this.A02, this.A01, this.A00, this.A0A, this.A07, this.A08, this.A05, this.A0B, this.A0D, this.A0C, this.A03, this.A09);
        A00(this, q9);
        return q9;
    }

    public final Q9 A05(R5 r5) {
        return new Q9(this.A04, this.A06, this.A02, this.A01, this.A00, this.A0A, this.A07, this.A08, r5, this.A0B, this.A0D, this.A0C, this.A03, this.A09);
    }

    public final Q9 A06(R5 r5, long j, long j2, long j3) {
        long j4 = j2;
        Timeline timeline = this.A04;
        if (!r5.A00()) {
            j4 = -9223372036854775807L;
        }
        return new Q9(timeline, r5, j, j4, this.A00, this.A0A, this.A07, this.A08, this.A05, this.A0B, j3, j);
    }

    public final Q9 A07(C1863Qs c1863Qs, C2290dH c2290dH) {
        Q9 q9 = new Q9(this.A04, this.A06, this.A02, this.A01, this.A00, this.A0A, c1863Qs, c2290dH, this.A05, this.A0B, this.A0D, this.A0C, this.A03, this.A09);
        A00(this, q9);
        return q9;
    }

    public final Q9 A08(boolean z) {
        Q9 q9 = new Q9(this.A04, this.A06, this.A02, this.A01, this.A00, z, this.A07, this.A08, this.A05, this.A0B, this.A0D, this.A0C, this.A03, this.A09);
        A00(this, q9);
        return q9;
    }
}
