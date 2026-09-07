package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mc, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\u0016H\u0004¨\u0006\u001a"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker;", "", "<init>", "()V", "reportCodecCreating", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$CreatingEvent;", "isVideo", "", "codecName", "", "source", "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;", "reportCodecCreated", "", "creatingEvent", "codecInstanceId", "", "reportCodecAcquiredFromPool", "reportCodecReturnedToPool", "reportCodecReleasing", "reportCodecReleased", "getNowMilliseconds", "", "Source", "CreatingEvent", "ReleasingEvent", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MediaCodecPoolTracker {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-84, -72, -83, -82, -84, -105, -86, -74, -82, 19, Ascii.SI, Ascii.NAK, Ascii.DC2, 3, 5};
    }

    public abstract void A04(MZ mz, int i);

    public abstract void A05(EnumC1757Mb enumC1757Mb, int i);

    public abstract void A06(EnumC1757Mb enumC1757Mb, int i);

    public abstract void A07(EnumC1757Mb enumC1757Mb, int i);

    public abstract void A08(boolean z, String str, EnumC1757Mb enumC1757Mb, int i);

    private final long A00() {
        return C2089Zw.A00().AC0();
    }

    public final MZ A03(boolean z, String str, EnumC1757Mb enumC1757Mb) {
        C2923nk.A09(str, A01(0, 9, 21));
        C2923nk.A09(enumC1757Mb, A01(9, 6, 108));
        return new MZ(A00(), z, str, enumC1757Mb);
    }
}
