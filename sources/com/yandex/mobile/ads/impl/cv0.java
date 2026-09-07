package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes12.dex */
public interface cv0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gv0 f8643a;
        public final MediaFormat b;
        public final gc0 c;
        public final Surface d;
        public final MediaCrypto e;

        public static a a(gv0 gv0Var, MediaFormat mediaFormat, gc0 gc0Var, MediaCrypto mediaCrypto) {
            return new a(gv0Var, mediaFormat, gc0Var, null, mediaCrypto);
        }

        private a(gv0 gv0Var, MediaFormat mediaFormat, gc0 gc0Var, Surface surface, MediaCrypto mediaCrypto) {
            this.f8643a = gv0Var;
            this.b = mediaFormat;
            this.c = gc0Var;
            this.d = surface;
            this.e = mediaCrypto;
        }

        public static a a(gv0 gv0Var, MediaFormat mediaFormat, gc0 gc0Var, Surface surface, MediaCrypto mediaCrypto) {
            return new a(gv0Var, mediaFormat, gc0Var, surface, mediaCrypto);
        }
    }

    public interface b {
        cv0 a(a aVar) throws IOException;
    }

    public interface c {
        void a(long j);
    }

    int a(MediaCodec.BufferInfo bufferInfo);

    MediaFormat a();

    void a(int i);

    void a(int i, int i2, long j, int i3);

    void a(int i, long j);

    void a(int i, dv dvVar, long j);

    void a(Bundle bundle);

    void a(Surface surface);

    void a(c cVar, Handler handler);

    void a(boolean z, int i);

    int b();

    ByteBuffer b(int i);

    ByteBuffer c(int i);

    void flush();

    void release();
}
