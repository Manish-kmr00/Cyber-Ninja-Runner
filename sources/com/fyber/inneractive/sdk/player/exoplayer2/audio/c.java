package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f1975a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    ByteBuffer a();

    void a(ByteBuffer byteBuffer);

    boolean a(int i, int i2, int i3);

    void b();

    boolean c();

    boolean d();

    int e();

    void f();

    void flush();
}
