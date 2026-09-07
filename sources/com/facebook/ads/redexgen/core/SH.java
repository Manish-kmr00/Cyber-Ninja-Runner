package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SH {
    public static byte[] A0A;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final ZM A07;
    public final boolean A08;
    public final RV[] A09;

    static {
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{-43, -10, -9, -14, 6, -3, 5, -46, 6, -11, -6, 0, -28, -6, -1, -4, -29, -10, -22, -19, -27, -62, -10, -27, -22, -16, -43, -13, -30, -28, -20, -69, -95, -12, -11, -30, -11, -26, -66, -90, -27, -83, -95, -30, -10, -27, -22, -16, -43, -13, -30, -28, -20, -62, -19, -19, -16, -28, -30, -11, -26, -27, -81, -24, -26, -11, -87, -86, -66, -90, -27};
    }

    public SH(ZM zm, int i, int i2, int i3, int i4, int i5, int i6, int i7, RV[] rvArr, boolean z) {
        this.A07 = zm;
        this.A01 = i;
        this.A04 = i2;
        this.A05 = i3;
        this.A06 = i4;
        this.A02 = i5;
        this.A03 = i6;
        this.A00 = i7;
        this.A09 = rvArr;
        this.A08 = z;
    }

    public static AudioAttributes A00() {
        return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }

    public static AudioAttributes A01(C2080Zm c2080Zm, boolean z) {
        if (z) {
            return A00();
        }
        return c2080Zm.A01().A00;
    }

    private AudioTrack A02(C2080Zm c2080Zm, int i) {
        int iA04 = AbstractC2471gE.A04(c2080Zm.A05);
        if (i != 0) {
            return new AudioTrack(iA04, this.A06, this.A02, this.A03, this.A00, 1, i);
        }
        return new AudioTrack(iA04, this.A06, this.A02, this.A03, this.A00, 1);
    }

    private AudioTrack A03(boolean z, C2080Zm c2080Zm, int i) {
        if (AbstractC2471gE.A02 >= 29) {
            return A05(z, c2080Zm, i);
        }
        if (AbstractC2471gE.A02 >= 21) {
            return A04(z, c2080Zm, i);
        }
        return A02(c2080Zm, i);
    }

    private AudioTrack A04(boolean z, C2080Zm c2080Zm, int i) {
        return new AudioTrack(A01(c2080Zm, z), XM.A0D(this.A06, this.A02, this.A03), this.A00, 1, i);
    }

    private AudioTrack A05(boolean z, C2080Zm c2080Zm, int i) {
        AudioFormat audioFormatA0D = XM.A0D(this.A06, this.A02, this.A03);
        AudioAttributes audioTrackAttributes = A01(c2080Zm, z);
        AudioTrack.Builder audioFormat = new AudioTrack.Builder().setAudioAttributes(audioTrackAttributes).setAudioFormat(audioFormatA0D);
        boolean z2 = true;
        AudioTrack.Builder sessionId = audioFormat.setTransferMode(1).setBufferSizeInBytes(this.A00).setSessionId(i);
        if (this.A04 != 1) {
            z2 = false;
        }
        return sessionId.setOffloadedPlayback(z2).build();
    }

    public final long A08(long j) {
        return (1000000 * j) / ((long) this.A06);
    }

    public final long A09(long j) {
        return (1000000 * j) / ((long) this.A07.A0G);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D23918943: Monitor the audio track usage through audioTrackAllocated")
    public final AudioTrack A0A(boolean z, C2080Zm c2080Zm, int i) throws C1890Rt {
        try {
            AudioTrack audioTrackA03 = A03(z, c2080Zm, i);
            XM.A0y.incrementAndGet();
            int state = audioTrackA03.getState();
            if (state == 1) {
                return audioTrackA03;
            }
            try {
                audioTrackA03.release();
                XM.A0y.decrementAndGet();
            } catch (Exception e) {
                AbstractC2432fb.A08(A06(0, 16, 30), String.format(A06(16, 55, 14), Integer.valueOf(state), Integer.valueOf(XM.A0y.get())), e);
            }
            throw new C1890Rt(state, this.A06, this.A02, this.A00, this.A07, A0D(), null, XM.A0y.get());
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            throw new C1890Rt(0, this.A06, this.A02, this.A00, this.A07, A0D(), e2, XM.A0y.get());
        }
    }

    public final C1888Rr A0B() {
        return new C1888Rr(this.A03, this.A06, this.A02, this.A08, this.A04 == 1, this.A00);
    }

    public final SH A0C(int i) {
        return new SH(this.A07, this.A01, this.A04, this.A05, this.A06, this.A02, this.A03, i, this.A09, this.A08);
    }

    public final boolean A0D() {
        return this.A04 == 1;
    }

    public final boolean A0E(SH sh) {
        return sh.A04 == this.A04 && sh.A03 == this.A03 && sh.A06 == this.A06 && sh.A02 == this.A02 && sh.A05 == this.A05;
    }
}
