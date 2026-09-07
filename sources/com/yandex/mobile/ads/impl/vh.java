package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
public interface vh {

    public static final class a extends Exception {
        public final gc0 b;

        public a(th.b bVar, gc0 gc0Var) {
            super(bVar);
            this.b = gc0Var;
        }

        public a(String str, gc0 gc0Var) {
            super(str);
            this.b = gc0Var;
        }
    }

    public static final class b extends Exception {
        public final int b;
        public final boolean c;
        public final gc0 d;

        public b(int i, int i2, int i3, int i4, gc0 gc0Var, boolean z, RuntimeException runtimeException) {
            super("AudioTrack init failed " + i + " Config(" + i2 + ", " + i3 + ", " + i4 + ")" + (z ? " (recoverable)" : ""), runtimeException);
            this.b = i;
            this.c = z;
            this.d = gc0Var;
        }
    }

    public interface c {
    }

    public static final class e extends Exception {
        public final int b;
        public final boolean c;
        public final gc0 d;

        public e(int i, gc0 gc0Var, boolean z) {
            super(oe.a("AudioTrack write failed: ", i));
            this.c = z;
            this.b = i;
            this.d = gc0Var;
        }
    }

    long a(boolean z);

    void a(int i);

    void a(gc0 gc0Var, int[] iArr) throws a;

    default void a(ii1 ii1Var) {
    }

    void a(ii iiVar);

    void a(oh ohVar);

    void a(xh1 xh1Var);

    boolean a();

    boolean a(gc0 gc0Var);

    boolean a(ByteBuffer byteBuffer, long j, int i) throws e, b;

    int b(gc0 gc0Var);

    void b();

    void b(boolean z);

    void c();

    void d() throws e;

    boolean e();

    void f();

    void flush();

    void g();

    xh1 getPlaybackParameters();

    void pause();

    void play();

    void setVolume(float f);

    public static final class d extends Exception {
        public d(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
        }
    }
}
