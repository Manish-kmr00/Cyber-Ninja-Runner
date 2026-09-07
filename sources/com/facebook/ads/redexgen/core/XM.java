package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XM implements InterfaceC1896Rz {
    public static boolean A0v;
    public static int A0w;
    public static ExecutorService A0x;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D23918943: Monitor the audio track usage")
    public static AtomicInteger A0y;
    public static byte[] A0z;
    public static String[] A10 = {"LTYaeJKuzRRSvYUy0dw7f8FEEykfM6Hx", "vtH5JUEFwzc4BNsk5ElKwCRxNHBgSDRl", "iim6hzygxHL", "G6OihyYEo8Oj2QX", "adu7D7vS0WFK0Mz2bBRjzjaWd9EVNKri", "2uZSdxhM2dUuO", "FsuRV3nXr8GpwaicauMPacN3GSz90r8n", "ojQqRoUSDkU73"};
    public static final Object A11;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public AudioTrack A0D;
    public C2080Zm A0E;
    public NY A0F;
    public C2064Yv A0G;
    public RK A0H;
    public InterfaceC1892Rv A0I;
    public SE A0J;
    public SH A0K;
    public SH A0L;
    public SJ A0M;
    public SJ A0N;
    public SP A0O;
    public ByteBuffer A0P;
    public ByteBuffer A0Q;
    public ByteBuffer A0R;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes")
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public RV[] A0d;
    public ByteBuffer[] A0e;
    public final int A0f;
    public final OU A0g;
    public final RN A0h;
    public final RW A0i;
    public final S5 A0j;
    public final C1509Cm A0k;
    public final SF A0l;
    public final SM<C1890Rt> A0m;
    public final SM<C1895Ry> A0n;
    public final Bn A0o;
    public final C2398f2 A0p;
    public final ArrayDeque<SJ> A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final RV[] A0t;
    public final RV[] A0u;

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0z, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 5);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0T() {
        A0z = new byte[]{85, 76, -110, -101, -98, 102, 76, 99, -124, -123, -128, -108, -117, -109, 96, -108, -125, -120, -114, 114, -120, -115, -118, -101, -50, -59, -90, -62, -73, -49, -69, -56, -112, -105, -53, -70, -65, -59, -86, -56, -73, -71, -63, -88, -69, -62, -69, -73, -55, -69, -86, -66, -56, -69, -73, -70, 90, 117, 125, -128, 121, 120, 52, -120, -125, 52, -121, 121, -120, 52, -124, -128, 117, -115, 118, 117, 119, 127, 52, -124, 117, -122, 117, -127, -121, -97, -60, -52, -73, -62, -65, -70, 118, -90, -103, -93, 118, -69, -60, -71, -59, -70, -65, -60, -67, -112, 118, 126, -93, -85, -106, -95, -98, -103, 85, -92, -86, -87, -91, -86, -87, 85, -104, -99, -106, -93, -93, -102, -95, 85, -104, -92, -93, -101, -98, -100, 85, 93, -94, -92, -103, -102, 114, -105, -68, -60, -81, -70, -73, -78, 110, -67, -61, -62, -66, -61, -62, 110, -77, -68, -79, -67, -78, -73, -68, -75, 110, 118, -69, -67, -78, -77, -117, -109, -84, -69, -88, -81, -64, -45, -31, -45, -30, -30, -41, -36, -43, -114, -31, -30, -49, -38, -38, -45, -46, -114, -49, -29, -46, -41, -35, -114, -30, -32, -49, -47, -39, -98, -73, -86, -85, -75, -82, 105, -67, -72, 105, -84, -72, -73, -81, -78, -80, -66, -69, -82, 105, -71, -86, -68, -68, -67, -79, -69, -72, -66, -80, -79, 105, -81, -72, -69, -125, 105, 103, -128, 119, -118, -126, 119, 117, -122, 119, 118, 50, 115, -121, 118, 123, -127, 50, 119, -128, 117, -127, 118, 123, -128, 121, 76, 50, 108, -128, 111, 116, 122, 58, 125, 108, -126};
    }

    static {
        A0T();
        A0v = false;
        A11 = new Object();
        A0y = new AtomicInteger(0);
    }

    @Deprecated
    public XM(RN rn, RV[] rvArr) {
        this(new SG().A05((RN) AbstractC2581i4.A00(rn, RN.A04)).A07(rvArr));
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    public XM(SG sg2) {
        int i;
        this.A0h = sg2.A02;
        this.A0i = sg2.A03;
        this.A0s = AbstractC2471gE.A02 >= 21 && sg2.A05;
        this.A0r = AbstractC2471gE.A02 >= 23 && sg2.A04;
        if (AbstractC2471gE.A02 >= 29) {
            i = sg2.A01;
        } else {
            i = 0;
        }
        this.A0f = i;
        this.A0l = sg2.A00;
        this.A0p = new C2398f2(InterfaceC2395ez.A00);
        this.A0p.A04();
        this.A0j = new S5(new XN(this));
        this.A0k = new C1509Cm();
        this.A0o = new Bn();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new CF(), this.A0k, this.A0o);
        Collections.addAll(arrayList, this.A0i.A6p());
        this.A0u = (RV[]) arrayList.toArray(new RV[0]);
        this.A0t = new RV[]{new CW()};
        this.A00 = 1.0f;
        this.A0E = C2080Zm.A07;
        this.A01 = 0;
        this.A0F = new NY(0, 0.0f);
        this.A0N = new SJ(C2064Yv.A06, false, 0L, 0L);
        this.A0G = C2064Yv.A06;
        this.A03 = -1;
        this.A0d = new RV[0];
        this.A0e = new ByteBuffer[0];
        this.A0q = new ArrayDeque<>();
        this.A0m = new SM<>(100L);
        this.A0n = new SM<>(100L);
        this.A0g = null;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "D58560720: customized audio track retry logic. Feature is available upstream already")
    private int A00() {
        if (MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A1a)) {
            return A01(this.A0K.A06, this.A0K.A02, this.A0K.A03);
        }
        return 1000000;
    }

    public static int A01(int i, int i2, int i3) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        AbstractC2388es.A08(minBufferSize != -2);
        return minBufferSize;
    }

    public static int A02(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return U2.A03(byteBuffer);
            case 7:
            case 8:
                int headerDataInBigEndian = UI.A00(byteBuffer);
                return headerDataInBigEndian;
            case 9:
                int headerDataInBigEndian2 = AbstractC2471gE.A0F(byteBuffer, byteBuffer.position());
                int headerDataInBigEndian3 = UZ.A01(headerDataInBigEndian2);
                if (headerDataInBigEndian3 != -1) {
                    return headerDataInBigEndian3;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException(A0L(244, 27, 13) + i);
            case 14:
                int syncframeOffset = U2.A02(byteBuffer);
                if (syncframeOffset == -1) {
                    return 0;
                }
                int iA04 = U2.A04(byteBuffer, syncframeOffset);
                String[] strArr = A10;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                A10[3] = "IgODgecN83Ykg4gKFNN5rcqN";
                return iA04 * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return U5.A01(byteBuffer);
            case 20:
                return AbstractC1950Ue.A00(byteBuffer);
        }
    }

    private int A03(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        if (AbstractC2471gE.A02 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        if (AbstractC2471gE.A02 == 30 && AbstractC2471gE.A06.startsWith(A0L(173, 5, 62))) {
            return 2;
        }
        return 1;
    }

    public static int A04(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int A05(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (AbstractC2471gE.A02 >= 26) {
            return audioTrack.write(byteBuffer, i, 1, j * 1000);
        }
        if (this.A0P == null) {
            this.A0P = ByteBuffer.allocate(16);
            this.A0P.order(ByteOrder.BIG_ENDIAN);
            this.A0P.putInt(1431633921);
        }
        if (this.A02 == 0) {
            this.A0P.putInt(4, i);
            this.A0P.putLong(8, 1000 * j);
            this.A0P.position(0);
            this.A02 = i;
        }
        int result = this.A0P.remaining();
        if (result > 0) {
            int avSyncHeaderBytesRemaining = audioTrack.write(this.A0P, result, 1);
            if (avSyncHeaderBytesRemaining < 0) {
                this.A02 = 0;
                return avSyncHeaderBytesRemaining;
            }
            if (avSyncHeaderBytesRemaining < result) {
                return 0;
            }
        }
        int iA04 = A04(audioTrack, byteBuffer, i);
        if (iA04 < 0) {
            this.A02 = 0;
            return iA04;
        }
        this.A02 -= iA04;
        return iA04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A06() {
        if (this.A0K.A04 == 0) {
            long j = this.A0A;
            SH sh = this.A0K;
            if (A10[4].charAt(26) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A10;
            strArr[0] = "EQkwp9kj7lhNLdJVA2Ci81cO95QEAtIE";
            strArr[1] = "B3HQJzKvOujIlVRoWhRpHsann8n3R43E";
            return j / ((long) sh.A01);
        }
        return this.A09;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A07() {
        if (this.A0K.A04 == 0) {
            return this.A0C / ((long) this.A0K.A05);
        }
        return this.A0B;
    }

    private long A08(long j) {
        while (!this.A0q.isEmpty() && j >= this.A0q.getFirst().A00) {
            this.A0N = this.A0q.remove();
        }
        long j2 = j - this.A0N.A00;
        if (this.A0N.A02.equals(C2064Yv.A06)) {
            SJ sj = this.A0N;
            if (A10[6].charAt(5) != '3') {
                throw new RuntimeException();
            }
            A10[3] = "YCJ4I1fzU";
            long playoutDurationSinceLastCheckpointUs = sj.A01;
            return playoutDurationSinceLastCheckpointUs + j2;
        }
        if (this.A0q.isEmpty()) {
            long mediaDurationSinceLastCheckpointUs = this.A0i.A8K(j2);
            long playoutDurationSinceLastCheckpointUs2 = this.A0N.A01;
            return playoutDurationSinceLastCheckpointUs2 + mediaDurationSinceLastCheckpointUs;
        }
        SJ first = this.A0q.getFirst();
        long jA0Q = AbstractC2471gE.A0Q(first.A00 - j, this.A0N.A02.A01);
        long playoutDurationSinceLastCheckpointUs3 = first.A01;
        return playoutDurationSinceLastCheckpointUs3 - jA0Q;
    }

    private long A09(long j) {
        return this.A0K.A08(this.A0i.A8y()) + j;
    }

    public static AudioFormat A0D(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    private AudioTrack A0F() throws C1890Rt {
        try {
            return A0G((SH) AbstractC2388es.A01(this.A0K));
        } catch (C1890Rt retryFailure) {
            if (A10[4].charAt(26) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A10;
            strArr[7] = "ysGobXohYIgbN";
            strArr[5] = "CSQZksROa4q0m";
            int retryBufferSize = A00();
            if (this.A0K.A00 > retryBufferSize) {
                SH shA0C = this.A0K.A0C(retryBufferSize);
                try {
                    AudioTrack audioTrackA0G = A0G(shA0C);
                    this.A0K = shA0C;
                    return audioTrackA0G;
                } catch (C1890Rt initialFailure) {
                    retryFailure.addSuppressed(initialFailure);
                    A0O();
                    throw retryFailure;
                }
            }
            A0O();
            throw retryFailure;
        }
    }

    private AudioTrack A0G(SH sh) throws C1890Rt {
        try {
            AudioTrack audioTrackA0A = sh.A0A(this.A0b, this.A0E, this.A01);
            if (0 != 0) {
                A0l(audioTrackA0A);
            }
            return audioTrackA0A;
        } catch (C1890Rt e) {
            if (this.A0I != null) {
                this.A0I.ACO(e);
            }
            throw e;
        }
    }

    private C2064Yv A0I() {
        return A0K().A02;
    }

    private SJ A0K() {
        if (this.A0M != null) {
            return this.A0M;
        }
        boolean zIsEmpty = this.A0q.isEmpty();
        String[] strArr = A10;
        if (strArr[7].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A10[2] = "uqOCVT";
        if (!zIsEmpty) {
            return this.A0q.getLast();
        }
        return this.A0N;
    }

    private void A0N() {
        for (int i = 0; i < i; i++) {
            RV rv = this.A0d[i];
            rv.flush();
            this.A0e[i] = rv.A8T();
        }
    }

    private void A0O() {
        if (!this.A0K.A0D()) {
            return;
        }
        this.A0W = true;
    }

    private void A0P() {
        if (!this.A0a) {
            this.A0a = true;
            this.A0j.A0H(A07());
            if (A10[6].charAt(5) != '3') {
                throw new RuntimeException();
            }
            A10[3] = "eGmdH4rTG8h0MdcM";
            this.A0D.stop();
            this.A02 = 0;
        }
    }

    private void A0Q() {
        this.A0A = 0L;
        this.A09 = 0L;
        this.A0C = 0L;
        this.A0B = 0L;
        this.A0V = false;
        this.A04 = 0;
        this.A0N = new SJ(A0I(), A0p(), 0L, 0L);
        this.A08 = 0L;
        this.A0M = null;
        this.A0q.clear();
        this.A0Q = null;
        this.A05 = 0;
        this.A0R = null;
        this.A0a = false;
        this.A0U = false;
        this.A03 = -1;
        this.A0P = null;
        this.A02 = 0;
        this.A0o.A0D();
        A0N();
    }

    private void A0R() {
        if (!A0h()) {
            return;
        }
        if (AbstractC2471gE.A02 >= 21) {
            A0X(this.A0D, this.A00);
        } else {
            A0Y(this.A0D, this.A00);
        }
    }

    private void A0S() {
        RV[] rvArr = this.A0K.A09;
        ArrayList arrayList = new ArrayList();
        for (RV rv : rvArr) {
            if (rv.AAA()) {
                arrayList.add(rv);
            } else {
                rv.flush();
            }
        }
        int size = arrayList.size();
        RV[] audioProcessors = new RV[size];
        this.A0d = (RV[]) arrayList.toArray(audioProcessors);
        this.A0e = new ByteBuffer[size];
        A0N();
    }

    private void A0U(long j) {
        C2064Yv c2064YvA45;
        boolean zA46;
        if (A0i()) {
            RW rw = this.A0i;
            if (A10[2].length() == 0) {
                throw new RuntimeException();
            }
            String[] strArr = A10;
            strArr[0] = "526SrfQ48e11UU36iTqPBwokJTLwC4Yw";
            strArr[1] = "YpoVtRImwoS4c1cHSKrr6FKAP20CnVq4";
            c2064YvA45 = rw.A45(A0I());
        } else {
            c2064YvA45 = C2064Yv.A06;
        }
        if (A0i()) {
            zA46 = this.A0i.A46(A0p());
        } else {
            zA46 = false;
        }
        this.A0q.add(new SJ(c2064YvA45, zA46, Math.max(0L, j), this.A0K.A08(A07())));
        A0S();
        if (this.A0I != null) {
            this.A0I.AF7(zA46);
        }
    }

    private void A0V(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.A0d.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                int count = i - 1;
                byteBuffer = this.A0e[count];
            } else {
                byteBuffer = this.A0Q != null ? this.A0Q : RV.A00;
            }
            if (i == length) {
                A0e(byteBuffer, j);
            } else {
                RV rv = this.A0d[i];
                int index = A10[3].length();
                if (index != 20) {
                    A10[3] = "zbBTKtOMr3HfkPEt";
                    int count2 = this.A03;
                    if (i > count2) {
                        rv.AGP(byteBuffer);
                    }
                    ByteBuffer byteBufferA8T = rv.A8T();
                    this.A0e[i] = byteBufferA8T;
                    String[] strArr = A10;
                    String str = strArr[0];
                    String str2 = strArr[1];
                    int index2 = str.charAt(18);
                    int count3 = str2.charAt(18);
                    if (index2 != count3) {
                        A10[4] = "NTaYEJRnvG1wlOc7wM7B86gEWhjToBRI";
                        if (byteBufferA8T.hasRemaining()) {
                            i++;
                        }
                    }
                }
                throw new RuntimeException();
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private void A0W(AudioTrack audioTrack) {
        if (this.A0O == null) {
            this.A0O = new SP(this);
        }
        this.A0O.A00(audioTrack);
    }

    public static void A0X(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    public static void A0Y(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    public static /* synthetic */ void A0Z(AudioTrack audioTrack, final InterfaceC1892Rv interfaceC1892Rv, Handler handler, final C1888Rr c1888Rr, C2398f2 c2398f2) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (interfaceC1892Rv != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.SA
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC1892Rv.ACQ(c1888Rr);
                    }
                });
            }
            c2398f2.A04();
            synchronized (A11) {
                A0w--;
                if (A0w == 0) {
                    A0x.shutdown();
                    A0x = null;
                }
            }
        } catch (Throwable th) {
            if (interfaceC1892Rv != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.SA
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC1892Rv.ACQ(c1888Rr);
                    }
                });
            }
            c2398f2.A04();
            synchronized (A11) {
                A0w--;
                if (A0w == 0) {
                    A0x.shutdown();
                    A0x = null;
                }
                throw th;
            }
        }
    }

    private void A0a(final AudioTrack audioTrack, final C2398f2 c2398f2, final InterfaceC1892Rv interfaceC1892Rv, final C1888Rr c1888Rr) {
        c2398f2.A02();
        final Handler handler = new Handler(Looper.myLooper());
        synchronized (A11) {
            if (A0x == null) {
                A0x = AbstractC2471gE.A0u(A0L(23, 33, 81));
            }
            A0w++;
            A0x.execute(new Runnable() { // from class: com.facebook.ads.redexgen.X.S9
                @Override // java.lang.Runnable
                public final void run() {
                    XM.A0Z(audioTrack, interfaceC1892Rv, handler, c1888Rr, c2398f2);
                }
            });
        }
    }

    private void A0b(C2064Yv c2064Yv) {
        if (A0h()) {
            try {
                this.A0D.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(c2064Yv.A01).setPitch(c2064Yv.A00).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                AbstractC2432fb.A0A(A0L(7, 16, 26), A0L(56, 29, 15), e);
            }
            PlaybackParams playbackParams = this.A0D.getPlaybackParams();
            float speed = playbackParams.getSpeed();
            PlaybackParams playbackParams2 = this.A0D.getPlaybackParams();
            c2064Yv = new C2064Yv(speed, playbackParams2.getPitch());
            this.A0j.A0G(c2064Yv.A01);
        }
        this.A0G = c2064Yv;
    }

    private void A0c(C2064Yv c2064Yv, boolean z) {
        SJ sjA0K = A0K();
        if (!c2064Yv.equals(sjA0K.A02) || z != sjA0K.A03) {
            SJ mediaPositionParameters = new SJ(c2064Yv, z, -9223372036854775807L, -9223372036854775807L);
            if (A0h()) {
                this.A0M = mediaPositionParameters;
            } else {
                this.A0N = mediaPositionParameters;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00af  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:58:0x0100  */
    private void A0e(ByteBuffer byteBuffer, long j) throws Exception {
        byte[] bArr;
        int error;
        int bytesRemaining;
        boolean z;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        if (this.A0R != null) {
            ByteBuffer byteBuffer2 = this.A0R;
            if (A10[2].length() != 0) {
                A10[4] = "gSRMBrmJge8of8iVybI21zTuay25L76B";
                AbstractC2388es.A07(byteBuffer2 == byteBuffer);
            }
            throw new RuntimeException();
        }
        this.A0R = byteBuffer;
        if (AbstractC2471gE.A02 < 21) {
            int iRemaining = byteBuffer.remaining();
            if (this.A0c != null) {
                int bytesRemaining2 = this.A0c.length;
                if (bytesRemaining2 < iRemaining) {
                    bArr = new byte[iRemaining];
                    String[] strArr = A10;
                    String str = strArr[7];
                    String str2 = strArr[5];
                    error = str.length();
                    bytesRemaining = str2.length();
                    if (error != bytesRemaining) {
                        throw new RuntimeException();
                    }
                    A10[3] = "ZOGCkBA57O5EE7X0qL3Arcu6bW";
                    this.A0c = bArr;
                }
            } else {
                bArr = new byte[iRemaining];
                String[] strArr2 = A10;
                String str3 = strArr2[7];
                String str4 = strArr2[5];
                error = str3.length();
                bytesRemaining = str4.length();
                if (error != bytesRemaining) {
                    throw new RuntimeException();
                }
                A10[3] = "ZOGCkBA57O5EE7X0qL3Arcu6bW";
                this.A0c = bArr;
            }
            int error2 = byteBuffer.position();
            byteBuffer.get(this.A0c, 0, iRemaining);
            byteBuffer.position(error2);
            this.A06 = 0;
        }
        int iRemaining2 = byteBuffer.remaining();
        int iA04 = 0;
        if (AbstractC2471gE.A02 < 21) {
            int iA0C = this.A0j.A0C(this.A0C);
            if (iA0C > 0) {
                int bytesWrittenOrError = Math.min(iRemaining2, iA0C);
                iA04 = this.A0D.write(this.A0c, this.A06, bytesWrittenOrError);
                if (iA04 > 0) {
                    this.A06 += iA04;
                    byteBuffer.position(byteBuffer.position() + iA04);
                }
            }
        } else if (this.A0b) {
            String[] strArr3 = A10;
            String str5 = strArr3[7];
            String str6 = strArr3[5];
            int error3 = str5.length();
            if (error3 == str6.length()) {
                A10[2] = "Iq6t3E";
                if (j != -9223372036854775807L) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (j != -9223372036854775807L) {
                z = true;
            } else {
                z = false;
            }
            AbstractC2388es.A08(z);
            iA04 = A05(this.A0D, byteBuffer, iRemaining2, j);
        } else {
            iA04 = A04(this.A0D, byteBuffer, iRemaining2);
        }
        this.A07 = SystemClock.elapsedRealtime();
        if (iA04 < 0) {
            C1895Ry c1895Ry = new C1895Ry(iA04, this.A0K.A07, A0k(iA04) && this.A0B > 0);
            if (this.A0I != null) {
                this.A0I.ACO(c1895Ry);
            }
            if (!c1895Ry.A02) {
                this.A0n.A01(c1895Ry);
                return;
            }
            throw c1895Ry;
        }
        this.A0n.A00();
        if (A0l(this.A0D)) {
            if (this.A0B > 0) {
                this.A0V = false;
            }
            if (this.A0X && this.A0I != null && iA04 < iRemaining2 && !this.A0V) {
                this.A0I.AEI();
            }
        }
        int bytesRemaining3 = this.A0K.A04;
        if (bytesRemaining3 == 0) {
            long j2 = this.A0C;
            int bytesWritten = A10[4].charAt(26);
            if (bytesWritten != 70) {
                String[] strArr4 = A10;
                strArr4[0] = "ZZziGhHbYNGkhyjvtWCyXxFYQMJkDG17";
                strArr4[1] = "8xAW1NYX3H2dlcB7HQVuLrFlYDTPWBYX";
                this.A0C = j2 + ((long) iA04);
            }
            throw new RuntimeException();
        }
        if (iA04 == iRemaining2) {
            int bytesRemaining4 = this.A0K.A04;
            if (bytesRemaining4 != 0) {
                AbstractC2388es.A08(byteBuffer == this.A0Q);
                long j3 = this.A0B;
                int bytesRemaining5 = this.A04;
                long j4 = bytesRemaining5;
                int bytesRemaining6 = this.A05;
                this.A0B = j3 + (j4 * ((long) bytesRemaining6));
            }
            this.A0R = null;
        }
    }

    private boolean A0f() throws Exception {
        boolean z = false;
        if (this.A03 == -1) {
            this.A03 = 0;
            z = true;
        }
        while (true) {
            int i = this.A03;
            int length = this.A0d.length;
            if (A10[2].length() == 0) {
                throw new RuntimeException();
            }
            String[] strArr = A10;
            strArr[0] = "TlrtYGWAEFWKC2luZOWxxfwzvxJMuMnA";
            strArr[1] = "rAldzZMue4fzQtHRdqNH0AaHEChNH8HC";
            if (i < length) {
                RV rv = this.A0d[this.A03];
                if (z) {
                    rv.AGO();
                }
                A0V(-9223372036854775807L);
                if (!rv.AAE()) {
                    return false;
                }
                z = true;
                this.A03++;
            } else {
                if (this.A0R != null) {
                    A0e(this.A0R, -9223372036854775807L);
                    if (this.A0R != null) {
                        return false;
                    }
                }
                this.A03 = -1;
                return true;
            }
        }
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes; Upstream has this feature")
    private boolean A0g() throws C1890Rt {
        if (!this.A0p.A03()) {
            return false;
        }
        boolean z = this.A0S;
        if (A10[2].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A10;
        strArr[7] = "4DXaZrFc0P65H";
        strArr[5] = "6Mg3XC2Oq0nsq";
        this.A0D = z ? A0F() : A0G(this.A0K);
        if (A0l(this.A0D)) {
            A0W(this.A0D);
            if (this.A0f != 3) {
                this.A0D.setOffloadDelayPadding(this.A0K.A07.A08, this.A0K.A07.A09);
            }
        }
        int i = AbstractC2471gE.A02;
        if (A10[6].charAt(5) != '3') {
            throw new RuntimeException();
        }
        String[] strArr2 = A10;
        strArr2[0] = "1v7I9djVVvlbe9cT6G6t4rfsPEfzGVC1";
        strArr2[1] = "Bt9aZ2hBQXKUWcmQyiv1NlW589B9MMWd";
        if (i >= 31 && this.A0H != null) {
            SD.A00(this.A0D, this.A0H);
        }
        this.A01 = this.A0D.getAudioSessionId();
        this.A0j.A0I(this.A0D, this.A0K.A04 == 2, this.A0K.A03, this.A0K.A05, this.A0K.A00);
        A0R();
        if (this.A0F.A01 != 0) {
            this.A0D.attachAuxEffect(this.A0F.A01);
            this.A0D.setAuxEffectSendLevel(this.A0F.A00);
        }
        if (this.A0J != null && AbstractC2471gE.A02 >= 23) {
            SC.A00(this.A0D, this.A0J);
        }
        this.A0Y = true;
        if (this.A0I != null) {
            this.A0I.ACP(this.A0K.A0B());
        }
        return true;
    }

    private boolean A0h() {
        return this.A0D != null;
    }

    private boolean A0i() {
        if (!this.A0b) {
            if (A0L(271, 9, 6).equals(this.A0K.A07.A0W) && !A0j(this.A0K.A07.A0C)) {
                return true;
            }
        }
        return false;
    }

    private boolean A0j(int i) {
        return this.A0s && AbstractC2471gE.A14(i);
    }

    public static boolean A0k(int i) {
        return (AbstractC2471gE.A02 >= 24 && i == -6) || i == -32;
    }

    public static boolean A0l(AudioTrack audioTrack) {
        return AbstractC2471gE.A02 >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0049  */
    private boolean A0m(ZM zm, C2080Zm c2080Zm) {
        int iA03;
        int channelConfig;
        if (AbstractC2471gE.A02 < 29 || this.A0f == 0 || (iA03 = Q2.A03((String) AbstractC2388es.A01(zm.A0W), zm.A0R)) == 0) {
            return false;
        }
        int encoding = zm.A06;
        int channelConfig2 = AbstractC2471gE.A01(encoding);
        if (channelConfig2 == 0) {
            return false;
        }
        int encoding2 = zm.A0G;
        switch (A03(A0D(encoding2, channelConfig2, iA03), c2080Zm.A01().A00)) {
            case 0:
                return false;
            case 1:
                int encoding3 = zm.A08;
                if (encoding3 == 0) {
                    int encoding4 = zm.A09;
                    if (encoding4 != 0) {
                        channelConfig = 1;
                    } else {
                        channelConfig = 0;
                    }
                } else {
                    channelConfig = 1;
                }
                int encoding5 = this.A0f;
                int encoding6 = encoding5 == 1 ? 1 : 0;
                return channelConfig == 0 || encoding6 == 0;
            case 2:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public final int A0o(ZM zm) {
        if (!A0L(271, 9, 6).equals(zm.A0W)) {
            return ((this.A0W || !A0m(zm, this.A0E)) && !this.A0h.A0B(zm)) ? 0 : 2;
        }
        if (!AbstractC2471gE.A15(zm.A0C)) {
            AbstractC2432fb.A07(A0L(7, 16, 26), A0L(85, 22, 81) + zm.A0C);
            return 0;
        }
        if (zm.A0C == 2 || (this.A0s && zm.A0C == 4)) {
            return 2;
        }
        if (A10[4].charAt(26) == 'F') {
            throw new RuntimeException();
        }
        String[] strArr = A10;
        strArr[7] = "3mwms1wiG831i";
        strArr[5] = "gPXbYUFi9alFa";
        return 1;
    }

    public final boolean A0p() {
        return A0K().A03;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x012e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x0145  */
    /* JADX WARN: Code duplicated, block: B:53:0x0148  */
    /* JADX WARN: Code duplicated, block: B:54:0x014b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0154  */
    /* JADX WARN: Code duplicated, block: B:59:0x015c  */
    /* JADX WARN: Code duplicated, block: B:61:0x016d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0170  */
    /* JADX WARN: Code duplicated, block: B:63:0x0173  */
    /* JADX WARN: Code duplicated, block: B:65:0x019c  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void A4z(ZM zm, int i, int[] iArr) throws C1889Rs {
        int outputPcmFrameSize;
        RV[] rvArr;
        int outputPcmFrameSize2;
        int outputEncoding;
        int outputSampleRate;
        int inputPcmFrameSize;
        int outputMode;
        String strA0L;
        int outputChannelConfig;
        double d;
        SH sh;
        int iA6v = i;
        int[] iArr2 = iArr;
        if (A0L(271, 9, 6).equals(zm.A0W)) {
            AbstractC2388es.A07(AbstractC2471gE.A15(zm.A0C));
            int i2 = zm.A0C;
            if (A10[6].charAt(5) == '3') {
                String[] strArr = A10;
                strArr[0] = "ZdGSGQM5gbCs7SuyI1oObypW625SgSrW";
                strArr[1] = "lVIdGrevGTItw5liuyXUwGvNQUosSyEK";
                outputPcmFrameSize = AbstractC2471gE.A06(i2, zm.A06);
                if (A0j(zm.A0C)) {
                    rvArr = this.A0t;
                } else {
                    rvArr = this.A0u;
                }
                this.A0o.A0E(zm.A08, zm.A09);
                if (AbstractC2471gE.A02 < 21 && zm.A06 == 8 && iArr2 == null) {
                    iArr2 = new int[6];
                    int i3 = 0;
                    while (true) {
                        int length = iArr2.length;
                        if (A10[2].length() == 0) {
                            throw new RuntimeException();
                        }
                        A10[2] = "i";
                        if (i3 >= length) {
                            break;
                        }
                        iArr2[i3] = i3;
                        i3++;
                    }
                }
                this.A0k.A0C(iArr2);
                RT rt = new RT(zm.A0G, zm.A06, zm.A0C);
                for (RV rv : rvArr) {
                    try {
                        RT rtA4x = rv.A4x(rt);
                        if (rv.AAA()) {
                            rt = rtA4x;
                        }
                    } catch (RU e) {
                        throw new C1889Rs(e, zm);
                    }
                }
                outputSampleRate = 0;
                inputPcmFrameSize = rt.A02;
                outputPcmFrameSize2 = rt.A03;
                int outputMode2 = rt.A01;
                outputMode = AbstractC2471gE.A01(outputMode2);
                int outputMode3 = rt.A01;
                outputEncoding = AbstractC2471gE.A06(inputPcmFrameSize, outputMode3);
                strA0L = A0L(0, 7, 39);
                if (inputPcmFrameSize != 0) {
                    if (outputMode != 0) {
                        if (iA6v == 0) {
                            SF sf = this.A0l;
                            int iA01 = A01(outputPcmFrameSize2, outputMode, inputPcmFrameSize);
                            if (outputEncoding != -1) {
                                outputChannelConfig = outputEncoding;
                            } else {
                                outputChannelConfig = 1;
                            }
                            int i4 = zm.A05;
                            if (this.A0r) {
                                d = 8.0d;
                            } else {
                                d = 1.0d;
                            }
                            iA6v = sf.A6v(iA01, inputPcmFrameSize, outputSampleRate, outputChannelConfig, outputPcmFrameSize2, i4, d);
                        }
                        this.A0W = false;
                        sh = new SH(zm, outputPcmFrameSize, outputSampleRate, outputEncoding, outputPcmFrameSize2, outputMode, inputPcmFrameSize, iA6v, rvArr, this.A0b);
                        if (A0h()) {
                            this.A0L = sh;
                            return;
                        } else {
                            this.A0K = sh;
                            return;
                        }
                    }
                    throw new C1889Rs(A0L(107, 36, 48) + outputSampleRate + strA0L + zm, zm);
                }
                throw new C1889Rs(A0L(143, 30, 73) + outputSampleRate + strA0L + zm, zm);
            }
            throw new RuntimeException();
        }
        outputPcmFrameSize = -1;
        rvArr = new RV[0];
        outputPcmFrameSize2 = zm.A0G;
        outputEncoding = -1;
        if (A0m(zm, this.A0E)) {
            outputSampleRate = 1;
            Object objA01 = AbstractC2388es.A01(zm.A0W);
            if (A10[6].charAt(5) == '3') {
                A10[6] = "vJ4dc3C8XVjDyla3DP7XUVHAcLcYPqIy";
                inputPcmFrameSize = Q2.A03((String) objA01, zm.A0R);
                int outputMode4 = zm.A06;
                outputMode = AbstractC2471gE.A01(outputMode4);
            }
            throw new RuntimeException();
        }
        outputSampleRate = 2;
        Pair<Integer, Integer> pairA09 = this.A0h.A09(zm);
        if (pairA09 != null) {
            inputPcmFrameSize = ((Integer) pairA09.first).intValue();
            outputMode = ((Integer) pairA09.second).intValue();
        } else {
            throw new C1889Rs(A0L(207, 37, 68) + zm, zm);
        }
        strA0L = A0L(0, 7, 39);
        if (inputPcmFrameSize != 0) {
            if (outputMode != 0) {
                if (iA6v == 0) {
                    SF sf2 = this.A0l;
                    int iA02 = A01(outputPcmFrameSize2, outputMode, inputPcmFrameSize);
                    if (outputEncoding != -1) {
                        outputChannelConfig = outputEncoding;
                    } else {
                        outputChannelConfig = 1;
                    }
                    int i5 = zm.A05;
                    if (this.A0r) {
                        d = 8.0d;
                    } else {
                        d = 1.0d;
                    }
                    iA6v = sf2.A6v(iA02, inputPcmFrameSize, outputSampleRate, outputChannelConfig, outputPcmFrameSize2, i5, d);
                }
                this.A0W = false;
                sh = new SH(zm, outputPcmFrameSize, outputSampleRate, outputEncoding, outputPcmFrameSize2, outputMode, inputPcmFrameSize, iA6v, rvArr, this.A0b);
                if (A0h()) {
                    this.A0L = sh;
                    return;
                } else {
                    this.A0K = sh;
                    return;
                }
            }
            throw new C1889Rs(A0L(107, 36, 48) + outputSampleRate + strA0L + zm, zm);
        }
        throw new C1889Rs(A0L(143, 30, 73) + outputSampleRate + strA0L + zm, zm);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void A5p() {
        if (this.A0b) {
            this.A0b = false;
            flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void A6C() {
        AbstractC2388es.A08(AbstractC2471gE.A02 >= 21);
        AbstractC2388es.A08(this.A0T);
        if (!this.A0b) {
            this.A0b = true;
            flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void A6J() {
        if (AbstractC2471gE.A02 < 25) {
            flush();
            return;
        }
        this.A0n.A00();
        this.A0m.A00();
        if (!A0h()) {
            return;
        }
        A0Q();
        if (this.A0j.A0J()) {
            this.A0D.pause();
        }
        this.A0D.flush();
        this.A0j.A0E();
        this.A0j.A0I(this.A0D, this.A0K.A04 == 2, this.A0K.A03, this.A0K.A05, this.A0K.A00);
        this.A0Y = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final long A7V(boolean z) {
        if (!A0h() || this.A0Y) {
            return Long.MIN_VALUE;
        }
        long jA0D = this.A0j.A0D(z);
        SH sh = this.A0K;
        long positionUs = A07();
        return A09(A08(Math.min(jA0D, sh.A08(positionUs))));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final C2064Yv A8c() {
        if (this.A0r) {
            return this.A0G;
        }
        return A0I();
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00f2  */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e8, code lost:
    
        if (r11.A0Z == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ee, code lost:
    
        if (A0f() != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f0, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f1, code lost:
    
        r4 = com.facebook.ads.redexgen.core.XM.A10;
        r4[0] = "B2nSTUuUaU2wPb11458AaeFApdiSho44";
        r4[1] = "f0bsrDRFKILPRIkbFGxYwHw6OYurrGrZ";
        r1 = r1 + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0200, code lost:
    
        if (r11.A0Z != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0203, code lost:
    
        com.facebook.ads.redexgen.core.XM.A10[2] = "xRiubeQ3WB9zPjHc";
        r11.A0M = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x020d, code lost:
    
        r3 = r13 - r1;
        r11.A08 += r3;
        r11.A0Z = false;
        A0U(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021b, code lost:
    
        if (r11.A0I == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0221, code lost:
    
        if (r3 == 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0223, code lost:
    
        r11.A0I.AEb();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x022c, code lost:
    
        if (r11.A0K.A04 != 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022e, code lost:
    
        r11.A0A += (long) r12.remaining();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0238, code lost:
    
        r11.A0Q = r12;
        r11.A05 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x024f, code lost:
    
        r11.A09 += ((long) r11.A04) * ((long) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0141, code lost:
    
        if (r12.hasRemaining() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0143, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0154, code lost:
    
        if (r12.hasRemaining() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015d, code lost:
    
        if (r11.A0K.A04 == 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0161, code lost:
    
        if (r11.A04 != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0163, code lost:
    
        r11.A04 = A02(r11.A0K.A03, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x016f, code lost:
    
        if (r11.A04 != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0171, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0174, code lost:
    
        if (r11.A0M == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017a, code lost:
    
        if (A0f() != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x017c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017d, code lost:
    
        A0U(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018c, code lost:
    
        if (com.facebook.ads.redexgen.core.XM.A10[6].charAt(5) == '3') goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x018e, code lost:
    
        r3 = com.facebook.ads.redexgen.core.XM.A10;
        r3[0] = "kNS3HwrclmfnTaweZkiDET44n66EG8hj";
        r3[1] = "byJZu3So4KLc9o20jeHeyOC0jsnMSk3B";
        r11.A0M = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x019c, code lost:
    
        r1 = r11.A08;
        r8 = r11.A0K.A09(A06() - r11.A0o.A0C());
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01bb, code lost:
    
        if (com.facebook.ads.redexgen.core.XM.A10[6].charAt(5) == '3') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01bd, code lost:
    
        com.facebook.ads.redexgen.core.XM.A10[3] = "IzxU";
        r1 = r1 + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c7, code lost:
    
        if (r11.A0Z != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
    
        if (java.lang.Math.abs(r1 - r13) <= 200000) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d8, code lost:
    
        if (r11.A0I == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01da, code lost:
    
        r11.A0I.ACO(new com.facebook.ads.redexgen.core.C1894Rx(r13, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e4, code lost:
    
        r11.A0Z = true;
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A9U(java.nio.ByteBuffer r12, long r13, int r15) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.XM.A9U(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void A9X() {
        this.A0Z = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final boolean A9e() {
        return A0h() && this.A0j.A0L(A07());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final boolean AAE() {
        return !A0h() || (this.A0U && !A9e());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AG8() {
        this.A0X = true;
        if (A0h()) {
            this.A0j.A0F();
            this.A0D.play();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AGA() throws C1895Ry {
        if (!this.A0U && A0h() && A0f()) {
            A0P();
            this.A0U = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIM(C2080Zm c2080Zm) {
        if (this.A0E.equals(c2080Zm)) {
            return;
        }
        this.A0E = c2080Zm;
        if (this.A0b) {
            return;
        }
        flush();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIN(int i) {
        if (this.A01 != i) {
            this.A01 = i;
            this.A0T = i != 0;
            flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIO(NY ny) {
        if (this.A0F.equals(ny)) {
            return;
        }
        int i = ny.A01;
        float sendLevel = ny.A00;
        if (this.A0D != null) {
            int effectId = this.A0F.A01;
            if (effectId != i) {
                this.A0D.attachAuxEffect(i);
            }
            if (i != 0) {
                this.A0D.setAuxEffectSendLevel(sendLevel);
            }
        }
        this.A0F = ny;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes")
    public final void AIW(boolean z) {
        this.A0S = z;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIb(InterfaceC1892Rv interfaceC1892Rv) {
        this.A0I = interfaceC1892Rv;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIj(C2064Yv c2064Yv) {
        C2064Yv c2064Yv2 = new C2064Yv(AbstractC2471gE.A00(c2064Yv.A01, 0.1f, 8.0f), AbstractC2471gE.A00(c2064Yv.A00, 0.1f, 8.0f));
        if (this.A0r && AbstractC2471gE.A02 >= 23) {
            A0b(c2064Yv2);
        } else {
            A0c(c2064Yv2, A0p());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIm(RK rk) {
        this.A0H = rk;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIo(AudioDeviceInfo audioDeviceInfo) {
        this.A0J = audioDeviceInfo == null ? null : new SE(audioDeviceInfo);
        if (this.A0D != null) {
            AudioTrack audioTrack = this.A0D;
            SE se = this.A0J;
            if (A10[2].length() == 0) {
                throw new RuntimeException();
            }
            A10[6] = "cbjJs3Pjfu2dgGM8A9p0m7tWucTqDMVf";
            SC.A00(audioTrack, se);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void AIu(boolean z) {
        A0c(A0I(), z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final boolean AJS(ZM zm) {
        return A0o(zm) != 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    public final boolean AJU(int i, int i2) {
        if (!AbstractC2471gE.A15(i2)) {
            return this.A0h != null && this.A0h.A0A(i2) && (i == -1 || i <= this.A0h.A08());
        }
        if (i2 != 4) {
            return true;
        }
        int i3 = AbstractC2471gE.A02;
        if (A10[2].length() == 0) {
            throw new RuntimeException();
        }
        A10[4] = "szg9nbohUIfFV0mfg0cbWEN3CZOQAbWf";
        return i3 >= 21;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void flush() {
        if (A0h()) {
            A0Q();
            if (this.A0j.A0J()) {
                this.A0D.pause();
            }
            if (A0l(this.A0D)) {
                ((SP) AbstractC2388es.A01(this.A0O)).A01(this.A0D);
            }
            if (AbstractC2471gE.A02 < 21 && !this.A0T) {
                this.A01 = 0;
            }
            C1888Rr c1888RrA0B = this.A0K.A0B();
            if (this.A0L != null) {
                SH sh = this.A0L;
                if (A10[2].length() == 0) {
                    throw new RuntimeException();
                }
                A10[2] = "Mv51GyaVR";
                this.A0K = sh;
                this.A0L = null;
            }
            this.A0j.A0E();
            A0a(this.A0D, this.A0p, this.A0I, c1888RrA0B);
            this.A0D = null;
        }
        this.A0n.A00();
        this.A0m.A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void pause() {
        this.A0X = false;
        if (A0h() && this.A0j.A0K()) {
            AudioTrack audioTrack = this.A0D;
            String[] strArr = A10;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A10[4] = "w5SLiwSxyda7njczRSo6ynWti6DIcr05";
            audioTrack.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1896Rz
    public final void setVolume(float f) {
        if (this.A00 != f) {
            this.A00 = f;
            A0R();
        }
    }
}
