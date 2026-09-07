package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3234y0 {
    public static final C3230w0 b = new C3230w0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0 f2304a;

    public C3234y0() {
        C0 c0;
        try {
            c0 = (C0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            c0 = b;
        }
        C3232x0 c3232x0 = new C3232x0(S.f2267a, c0);
        Charset charset = AbstractC3205m0.f2291a;
        this.f2304a = c3232x0;
    }
}
