package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes13.dex */
public class fv0 extends ny {
    public final String b;

    public fv0(IllegalStateException illegalStateException, gv0 gv0Var) {
        super("Decoder failed: " + (gv0Var == null ? null : gv0Var.f9037a), illegalStateException);
        this.b = x82.f10629a >= 21 ? a(illegalStateException) : null;
    }

    private static String a(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).getDiagnosticInfo();
        }
        return null;
    }
}
