package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface RV {
    public static final ByteBuffer A00 = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    RT A4x(RT rt) throws RU;

    ByteBuffer A8T();

    boolean AAA();

    boolean AAE();

    void AGO();

    void AGP(ByteBuffer byteBuffer);

    void flush();
}
