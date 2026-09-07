package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public interface th {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f10299a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    a a(a aVar) throws b;

    void a(ByteBuffer byteBuffer);

    boolean a();

    void b();

    ByteBuffer c();

    void d();

    void flush();

    boolean isActive();

    public static final class a {
        public static final a e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10300a;
        public final int b;
        public final int c;
        public final int d;

        public final String toString() {
            return "AudioFormat[sampleRate=" + this.f10300a + ", channelCount=" + this.b + ", encoding=" + this.c + AbstractJsonLexerKt.END_LIST;
        }

        public a(int i, int i2, int i3) {
            this.f10300a = i;
            this.b = i2;
            this.c = i3;
            this.d = x82.e(i3) ? x82.b(i3, i2) : -1;
        }
    }

    public static final class b extends Exception {
        public b(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }
}
