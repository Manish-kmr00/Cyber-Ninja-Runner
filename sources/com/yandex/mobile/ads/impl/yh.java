package com.yandex.mobile.ads.impl;

import android.media.AudioTrack;
import android.os.SystemClock;
import io.bidmachine.media3.exoplayer.dash.DashMediaSource;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
final class yh {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10734a;
    private final long[] b;
    private AudioTrack c;
    private int d;
    private int e;
    private xh f;
    private int g;
    private boolean h;
    private long i;
    private float j;
    private boolean k;
    private long l;
    private long m;
    private Method n;
    private long o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private long t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;
    private long z;

    public interface a {
        void a(int i, long j);

        void a(long j);

        void a(long j, long j2, long j3, long j4);

        void b(long j);

        void b(long j, long j2, long j3, long j4);
    }

    public yh(a aVar) {
        this.f10734a = (a) hg.a(aVar);
        if (x82.f10629a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    public final boolean f(long j) {
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.h) {
            if (playState == 2) {
                this.p = false;
                return false;
            }
            if (playState == 1 && a() == 0) {
                return false;
            }
        }
        boolean z = this.p;
        boolean zD = d(j);
        this.p = zD;
        if (z && !zD && playState != 1) {
            this.f10734a.a(this.e, x82.b(this.i));
        }
        return true;
    }

    public final int b(long j) {
        return this.e - ((int) (j - (a() * ((long) this.d))));
    }

    public final boolean e(long j) {
        return this.y != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.y >= 200;
    }

    public final void c(long j) {
        this.z = a();
        this.x = SystemClock.elapsedRealtime() * 1000;
        this.A = j;
    }

    public final boolean c() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
        if (this.x != -9223372036854775807L) {
            return false;
        }
        xh xhVar = this.f;
        xhVar.getClass();
        xhVar.f();
        return true;
    }

    public final boolean d(long j) {
        if (j <= a()) {
            if (this.h) {
                AudioTrack audioTrack = this.c;
                audioTrack.getClass();
                if (audioTrack.getPlayState() != 2 || a() != 0) {
                }
            }
            return false;
        }
        return true;
    }

    public final void d() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
        this.c = null;
        this.f = null;
    }

    private long a(long j) {
        return (j * 1000000) / ((long) this.g);
    }

    public final boolean b() {
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final void e() {
        xh xhVar = this.f;
        xhVar.getClass();
        xhVar.f();
    }

    public final long a(boolean z) {
        long jMax;
        int i;
        Method method;
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long jA = a(a());
            if (jA != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.m >= 30000) {
                    long[] jArr = this.b;
                    int i2 = this.v;
                    jArr[i2] = jA - jNanoTime;
                    this.v = (i2 + 1) % 10;
                    int i3 = this.w;
                    if (i3 < 10) {
                        this.w = i3 + 1;
                    }
                    this.m = jNanoTime;
                    this.l = 0L;
                    int i4 = 0;
                    while (true) {
                        int i5 = this.w;
                        if (i4 >= i5) {
                            break;
                        }
                        this.l = (this.b[i4] / ((long) i5)) + this.l;
                        i4++;
                    }
                }
                if (!this.h) {
                    xh xhVar = this.f;
                    xhVar.getClass();
                    if (xhVar.a(jNanoTime)) {
                        long jC = xhVar.c();
                        long jB = xhVar.b();
                        if (Math.abs(jC - jNanoTime) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                            i = 0;
                            this.f10734a.b(jB, jC, jNanoTime, jA);
                            xhVar.e();
                        } else {
                            i = 0;
                            if (Math.abs(a(jB) - jA) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                this.f10734a.a(jB, jC, jNanoTime, jA);
                                xhVar.e();
                            } else {
                                xhVar.a();
                            }
                        }
                    } else {
                        i = 0;
                    }
                    if (this.q && (method = this.n) != null && jNanoTime - this.r >= 500000) {
                        try {
                            AudioTrack audioTrack2 = this.c;
                            audioTrack2.getClass();
                            Integer num = (Integer) method.invoke(audioTrack2, new Object[i]);
                            int i6 = x82.f10629a;
                            long jIntValue = (((long) num.intValue()) * 1000) - this.i;
                            this.o = jIntValue;
                            long jMax2 = Math.max(jIntValue, 0L);
                            this.o = jMax2;
                            if (jMax2 > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                this.f10734a.b(jMax2);
                                this.o = 0L;
                            }
                        } catch (Exception unused) {
                            this.n = null;
                        }
                        this.r = jNanoTime;
                    }
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        xh xhVar2 = this.f;
        xhVar2.getClass();
        boolean zD = xhVar2.d();
        if (zD) {
            long jA2 = a(xhVar2.b());
            long jC2 = jNanoTime2 - xhVar2.c();
            float f = this.j;
            int i7 = x82.f10629a;
            if (f != 1.0f) {
                jC2 = Math.round(jC2 * ((double) f));
            }
            jMax = jC2 + jA2;
        } else {
            if (this.w == 0) {
                jMax = a(a());
            } else {
                jMax = this.l + jNanoTime2;
            }
            if (!z) {
                jMax = Math.max(0L, jMax - this.o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j = jNanoTime2 - this.F;
        if (j < 1000000) {
            long j2 = this.E;
            float f2 = this.j;
            int i8 = x82.f10629a;
            long j3 = jMax;
            long jRound = f2 == 1.0f ? j : Math.round(j * ((double) f2));
            long j4 = (j * 1000) / 1000000;
            jMax = (((1000 - j4) * (jRound + j2)) + (j3 * j4)) / 1000;
        }
        if (!this.k) {
            long j5 = this.B;
            if (jMax > j5) {
                this.k = true;
                long jB2 = x82.b(jMax - j5);
                float f3 = this.j;
                if (f3 != 1.0f) {
                    jB2 = Math.round(jB2 / ((double) f3));
                }
                this.f10734a.a(System.currentTimeMillis() - x82.b(jB2));
            }
        }
        this.C = jNanoTime2;
        this.B = jMax;
        this.D = zD;
        return jMax;
    }

    private long a() {
        AudioTrack audioTrack = this.c;
        audioTrack.getClass();
        if (this.x != -9223372036854775807L) {
            return Math.min(this.A, this.z + ((((SystemClock.elapsedRealtime() * 1000) - this.x) * ((long) this.g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.u = this.s;
            }
            playbackHeadPosition += this.u;
        }
        if (x82.f10629a <= 29) {
            if (playbackHeadPosition == 0 && this.s > 0 && playState == 3) {
                if (this.y == -9223372036854775807L) {
                    this.y = SystemClock.elapsedRealtime();
                }
                return this.s;
            }
            this.y = -9223372036854775807L;
        }
        if (this.s > playbackHeadPosition) {
            this.t++;
        }
        this.s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    public final void a(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new xh(audioTrack);
        this.g = audioTrack.getSampleRate();
        this.h = z && x82.f10629a < 23 && (i == 5 || i == 6);
        boolean zE = x82.e(i);
        this.q = zE;
        this.i = zE ? a(i3 / i2) : -9223372036854775807L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.p = false;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }

    public final void a(float f) {
        this.j = f;
        xh xhVar = this.f;
        if (xhVar != null) {
            xhVar.f();
        }
    }
}
