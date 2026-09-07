package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.exoplayer.dash.DashMediaSource;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S5 {
    public static byte[] A0X;
    public static String[] A0Y = {"8wbacqVK6DiJ9rQyfINmnV9qACxWjbdS", "NYsom1LLawXas8SUtNFVMj33KoHCQK26", "ESP3CpeSXxSHFVNVD", "Fkx7whNUPhs8wrRKOWyDkcaMBe6MunWz", "Igd7mjyBaLicz35A8Y1zNChJ3yjQ9wDf", "DYoMGgGHF4cXBYvSM9Z2HLLFwRlh2oRV", "FqpDNxSGzfyPMjuX4e0xBHLQxAoXaM", "sLBg2sulOnfLDnGrTrTN9MFQszzZ4z"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public long A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public AudioTrack A0N;
    public S2 A0O;
    public Method A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public final S3 A0V;
    public final long[] A0W;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0X, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0X = new byte[]{7, 5, Ascii.DC4, -20, 1, Ascii.DC4, 5, Ascii.SO, 3, Ascii.EM};
    }

    static {
        A06();
    }

    public S5(S3 s3) {
        this.A0V = (S3) AbstractC2388es.A01(s3);
        if (AbstractC2471gE.A02 >= 18) {
            try {
                this.A0P = AudioTrack.class.getMethod(A03(0, 10, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.A0W = new long[10];
    }

    private long A00() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.A0M != -9223372036854775807L) {
            long currentTimeMs = this.A0M;
            long elapsedTimeSinceStopUs = (1000 * jElapsedRealtime) - currentTimeMs;
            long jA0Q = AbstractC2471gE.A0Q(elapsedTimeSinceStopUs, this.A00);
            long mediaTimeSinceStopUs = this.A04;
            long elapsedTimeSinceStopUs2 = this.A07;
            long currentTimeMs2 = this.A0L;
            return Math.min(elapsedTimeSinceStopUs2, currentTimeMs2 + ((mediaTimeSinceStopUs * jA0Q) / 1000000));
        }
        long currentTimeMs3 = this.A0C;
        if (jElapsedRealtime - currentTimeMs3 >= 5) {
            A09(jElapsedRealtime);
            this.A0C = jElapsedRealtime;
        }
        return this.A0I + (this.A0J << 32);
    }

    private long A01() {
        return A02(A00());
    }

    private long A02(long j) {
        return (1000000 * j) / ((long) this.A04);
    }

    private void A04() {
        long jNanoTime = System.nanoTime() / 1000;
        long systemTimeUs = this.A0A;
        if (jNanoTime - systemTimeUs >= 30000) {
            long jA01 = A01();
            if (jA01 == 0) {
                return;
            }
            this.A0W[this.A02] = AbstractC2471gE.A0R(jA01, this.A00) - jNanoTime;
            this.A02 = (this.A02 + 1) % 10;
            if (this.A05 < 10) {
                this.A05++;
            }
            this.A0A = jNanoTime;
            this.A0K = 0L;
            for (int i = 0; i < this.A05; i++) {
                long j = this.A0K;
                long j2 = this.A0W[i];
                long playbackPositionUs = this.A05;
                if (A0Y[2].length() != 17) {
                    throw new RuntimeException();
                }
                A0Y[3] = "eVr3vDMEgXazxVBLYwDFMkwHxHWXOK5u";
                this.A0K = j + (j2 / playbackPositionUs);
            }
        }
        if (this.A0T) {
            return;
        }
        A07(jNanoTime);
        A08(jNanoTime);
    }

    private void A05() {
        this.A0K = 0L;
        this.A05 = 0;
        this.A02 = 0;
        this.A0A = 0L;
        this.A0D = 0L;
        this.A0H = 0L;
        this.A0U = false;
    }

    private void A07(long j) {
        S2 s2 = (S2) AbstractC2388es.A01(this.A0O);
        if (!s2.A07(j)) {
            return;
        }
        long jA02 = s2.A02();
        long jA01 = s2.A01();
        long audioTimestampSystemTimeUs = A01();
        if (Math.abs(jA02 - j) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
            this.A0V.AFH(jA01, jA02, j, audioTimestampSystemTimeUs);
            s2.A04();
        } else if (Math.abs(A02(jA01) - audioTimestampSystemTimeUs) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
            this.A0V.AEc(jA01, jA02, j, audioTimestampSystemTimeUs);
            s2.A04();
        } else {
            s2.A03();
        }
    }

    private void A08(long j) {
        if (this.A0R && this.A0P != null && j - this.A09 >= 500000) {
            try {
                this.A0E = (((long) ((Integer) AbstractC2471gE.A0f((Integer) this.A0P.invoke(AbstractC2388es.A01(this.A0N), new Object[0]))).intValue()) * 1000) - this.A06;
                this.A0E = Math.max(this.A0E, 0L);
                if (this.A0E > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                    this.A0V.ADb(this.A0E);
                    this.A0E = 0L;
                }
            } catch (Exception unused) {
                this.A0P = null;
            }
            this.A09 = j;
        }
    }

    private void A09(long j) {
        AudioTrack audioTrack = (AudioTrack) AbstractC2388es.A01(this.A0N);
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return;
        }
        long rawPlaybackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.A0T) {
            String[] strArr = A0Y;
            String str = strArr[6];
            String str2 = strArr[7];
            int state = str.length();
            if (state != str2.length()) {
                throw new RuntimeException();
            }
            A0Y[2] = "n5TjXeqXqsQz2ph0c";
            if (playState == 2 && rawPlaybackHeadPosition == 0) {
                this.A0F = this.A0I;
            }
            long j2 = this.A0F;
            String[] strArr2 = A0Y;
            String str3 = strArr2[6];
            String str4 = strArr2[7];
            int state2 = str3.length();
            if (state2 != str4.length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0Y;
            strArr3[6] = "x8qj6cjvwFnzzrIskXNXV59LdD3KV8";
            strArr3[7] = "NzVNDfRit63WR7T8gz6GmPtiaEIQlB";
            rawPlaybackHeadPosition += j2;
        }
        int state3 = AbstractC2471gE.A02;
        if (state3 <= 29) {
            if (rawPlaybackHeadPosition == 0 && this.A0I > 0) {
                int state4 = A0Y[0].charAt(18);
                if (state4 != 78) {
                    throw new RuntimeException();
                }
                A0Y[3] = "0B56dO5wwcgPgsHq71zLdNstBKLm4Nh0";
                if (playState == 3) {
                    if (this.A08 == -9223372036854775807L) {
                        this.A08 = j;
                        return;
                    }
                    return;
                }
            }
            this.A08 = -9223372036854775807L;
        }
        if (this.A0I > rawPlaybackHeadPosition) {
            long j3 = this.A0J;
            int state5 = A0Y[0].charAt(18);
            if (state5 != 78) {
                this.A0J = j3 + 1;
            } else {
                String[] strArr4 = A0Y;
                strArr4[1] = "KeMAtBG5u95BPypwerH9XJrym2gjsq7l";
                strArr4[4] = "vCyjbLg9JpbTUDPQN4wt55t5TXuVZX9d";
                this.A0J = j3 + 1;
            }
        }
        this.A0I = rawPlaybackHeadPosition;
    }

    private boolean A0A() {
        return this.A0T && ((AudioTrack) AbstractC2388es.A01(this.A0N)).getPlayState() == 2 && A00() == 0;
    }

    public static boolean A0B(int i) {
        if (AbstractC2471gE.A02 < 23) {
            if (i != 5) {
                if (A0Y[0].charAt(18) != 'N') {
                    throw new RuntimeException();
                }
                A0Y[0] = "6RWKPdvcclumOu7126NegMcjgdt4OIjz";
                if (i == 6) {
                }
            }
            return true;
        }
        return false;
    }

    public final int A0C(long j) {
        int bytesPending = (int) (j - (A00() * ((long) this.A03)));
        return this.A01 - bytesPending;
    }

    public final long A0D(boolean z) {
        long jA0Q;
        if (((AudioTrack) AbstractC2388es.A01(this.A0N)).getPlayState() == 3) {
            A04();
        }
        long jNanoTime = System.nanoTime() / 1000;
        S2 s2 = (S2) AbstractC2388es.A01(this.A0O);
        boolean zA06 = s2.A06();
        if (zA06) {
            jA0Q = A02(s2.A01()) + AbstractC2471gE.A0Q(jNanoTime - s2.A02(), this.A00);
        } else {
            if (this.A05 == 0) {
                jA0Q = A01();
            } else {
                jA0Q = AbstractC2471gE.A0Q(this.A0K + jNanoTime, this.A00);
            }
            if (!z) {
                jA0Q = Math.max(0L, jA0Q - this.A0E);
            }
        }
        if (this.A0S != zA06) {
            this.A0H = this.A0D;
            this.A0G = this.A0B;
        }
        long j = jNanoTime - this.A0H;
        if (j < 1000000) {
            long jA0Q2 = this.A0G + AbstractC2471gE.A0Q(j, this.A00);
            String[] strArr = A0Y;
            if (strArr[1].charAt(13) == strArr[4].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Y;
            strArr2[1] = "eKsrd17kDOCc3WQJgxvNNEOO76uR1zC9";
            strArr2[4] = "aZjfb7u22Ipk2hwfTZo2h7TaCEu14RbG";
            long j2 = (j * 1000) / 1000000;
            jA0Q = ((jA0Q * j2) + ((1000 - j2) * jA0Q2)) / 1000;
        }
        boolean z2 = this.A0U;
        String[] strArr3 = A0Y;
        if (strArr3[6].length() != strArr3[7].length()) {
            throw new RuntimeException();
        }
        A0Y[0] = "DTNkOZavrnFMqcdww4NZ0ue9OABpdJ4o";
        if (!z2) {
            long systemTimeUs = this.A0B;
            if (jA0Q > systemTimeUs) {
                this.A0U = true;
                long jA0P = AbstractC2471gE.A0P(jA0Q - this.A0B);
                if (A0Y[3].charAt(8) == '1') {
                    throw new RuntimeException();
                }
                A0Y[2] = "o7Jv65SdG9Ddlx7A2";
                this.A0V.AEa(System.currentTimeMillis() - AbstractC2471gE.A0P(AbstractC2471gE.A0R(jA0P, this.A00)));
            }
        }
        this.A0D = jNanoTime;
        this.A0B = jA0Q;
        this.A0S = zA06;
        return jA0Q;
    }

    public final void A0E() {
        A05();
        this.A0N = null;
        this.A0O = null;
    }

    public final void A0F() {
        ((S2) AbstractC2388es.A01(this.A0O)).A05();
    }

    public final void A0G(float f) {
        this.A00 = f;
        if (this.A0O != null) {
            this.A0O.A05();
        }
        A05();
    }

    public final void A0H(long j) {
        this.A0L = A00();
        this.A0M = SystemClock.elapsedRealtime() * 1000;
        this.A07 = j;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0065  */
    public final void A0I(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        boolean z2;
        this.A0N = audioTrack;
        this.A03 = i2;
        this.A01 = i3;
        this.A0O = new S2(audioTrack);
        this.A04 = audioTrack.getSampleRate();
        if (z) {
            boolean zA0B = A0B(i);
            if (A0Y[3].charAt(8) == '1') {
                throw new RuntimeException();
            }
            A0Y[3] = "qVnZXnffR2i8TvGrKyzCxjUh4EeU23CC";
            if (zA0B) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.A0T = z2;
        this.A0R = AbstractC2471gE.A15(i);
        this.A06 = this.A0R ? A02(i3 / i2) : -9223372036854775807L;
        this.A0I = 0L;
        this.A0J = 0L;
        this.A0F = 0L;
        this.A0Q = false;
        this.A0M = -9223372036854775807L;
        this.A08 = -9223372036854775807L;
        this.A09 = 0L;
        this.A0E = 0L;
        this.A00 = 1.0f;
    }

    public final boolean A0J() {
        return ((AudioTrack) AbstractC2388es.A01(this.A0N)).getPlayState() == 3;
    }

    public final boolean A0K() {
        A05();
        if (this.A0M == -9223372036854775807L) {
            ((S2) AbstractC2388es.A01(this.A0O)).A05();
            return true;
        }
        return false;
    }

    public final boolean A0L(long j) {
        return j > A00() || A0A();
    }

    public final boolean A0M(long j) {
        if (this.A08 != -9223372036854775807L && j > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (A0Y[5].charAt(1) != 'Y') {
                throw new RuntimeException();
            }
            A0Y[3] = "ewfrQCHA6LhOQLWe9bWqr3r93C9sdiPY";
            if (jElapsedRealtime - this.A08 >= 200) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
    
        if (r7 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (r7 == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0N(long r10) {
        /*
            r9 = this;
            android.media.AudioTrack r0 = r9.A0N
            java.lang.Object r0 = com.facebook.ads.redexgen.core.AbstractC2388es.A01(r0)
            android.media.AudioTrack r0 = (android.media.AudioTrack) r0
            int r3 = r0.getPlayState()
            boolean r0 = r9.A0T
            r4 = 1
            if (r0 == 0) goto L5d
            r6 = 2
            r5 = 0
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.S5.A0Y
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 17
            if (r1 == r0) goto L26
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L26:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.S5.A0Y
            java.lang.String r1 = "fYaBr0fBAYoXw14XS0LlIlydWNI0S8ek"
            r0 = 5
            r2[r0] = r1
            if (r3 != r6) goto L32
            r9.A0Q = r5
            return r5
        L32:
            if (r3 != r4) goto L5d
            long r7 = r9.A00()
            r0 = 0
            int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.S5.A0Y
            r0 = 1
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 13
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L5a
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.S5.A0Y
            java.lang.String r1 = "K9K75Eynd1NA52jHnJGfOkaO4hd6hfrX"
            r0 = 3
            r2[r0] = r1
            if (r6 != 0) goto L5d
        L59:
            return r5
        L5a:
            if (r6 != 0) goto L5d
            goto L59
        L5d:
            boolean r1 = r9.A0Q
            boolean r0 = r9.A0L(r10)
            r9.A0Q = r0
            if (r1 == 0) goto L7a
            boolean r0 = r9.A0Q
            if (r0 != 0) goto L7a
            if (r3 == r4) goto L7a
            com.facebook.ads.redexgen.X.S3 r3 = r9.A0V
            int r2 = r9.A01
            long r0 = r9.A06
            long r0 = com.facebook.ads.redexgen.core.AbstractC2471gE.A0P(r0)
            r3.AFQ(r2, r0)
        L7a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.S5.A0N(long):boolean");
    }
}
