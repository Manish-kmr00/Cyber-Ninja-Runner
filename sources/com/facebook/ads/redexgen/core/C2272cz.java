package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2272cz {
    public static byte[] A04;
    public static String[] A05 = {"B66vZb5Pnl4cT5Z1t9OYvzCKJUl6Li1W", "jlNFgL", "sGIFv1OQm6h", "k2Ul4WHyIhGCov", "DL", "fBnlQwdap93tUPypB1L5p0ErpWiSUSsr", "loPjA9dn7Rhv07Y9rtGiKh4esduwYCG", "QpJXieoKMwU0dn9RtROdbiUCkkjRq3OR"};
    public Spatializer.OnSpatializerStateChangedListener A00;
    public Handler A01;
    public final Spatializer A02;
    public final boolean A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[4].length() == 1) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[2] = "dpI6kHDDS3r";
            strArr[3] = "4LbVi5OAgtbSKv";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
            i4++;
        }
    }

    public static void A02() {
        A04 = new byte[]{-37, -17, -34, -29, -23, 9, Ascii.GS, Ascii.FF, 17, Ascii.ETB, -41, Ascii.CR, 9, Ascii.VT, -37, -43, Ascii.DC2, Ascii.ETB, Ascii.VT};
    }

    static {
        A02();
    }

    public C2272cz(Spatializer spatializer) {
        this.A02 = spatializer;
        this.A03 = spatializer.getImmersiveAudioLevel() != 0;
    }

    public static C2272cz A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(0, 5, 4));
        if (audioManager == null) {
            return null;
        }
        return new C2272cz(audioManager.getSpatializer());
    }

    public final void A03(C13555u c13555u, Looper looper) {
        if (this.A00 != null || this.A01 != null) {
            return;
        }
        this.A00 = new C2271cy(this, c13555u);
        this.A01 = new Handler(looper);
        Spatializer spatializer = this.A02;
        Handler handler = this.A01;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new SN(handler), this.A00);
    }

    public final boolean A04() {
        return this.A02.isAvailable();
    }

    public final boolean A05() {
        return this.A02.isEnabled();
    }

    public final boolean A06() {
        return this.A03;
    }

    public final boolean A07(C2080Zm c2080Zm, ZM zm) {
        int i;
        if (A01(5, 14, 50).equals(zm.A0W) && zm.A06 == 16) {
            i = 12;
        } else {
            i = zm.A06;
        }
        AudioFormat.Builder encoding = new AudioFormat.Builder().setEncoding(2);
        int linearChannelCount = AbstractC2471gE.A01(i);
        AudioFormat.Builder channelMask = encoding.setChannelMask(linearChannelCount);
        if (zm.A0G != -1) {
            int linearChannelCount2 = zm.A0G;
            channelMask.setSampleRate(linearChannelCount2);
        }
        return this.A02.canBeSpatialized(c2080Zm.A01().A00, channelMask.build());
    }
}
