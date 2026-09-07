package com.bytedance.sdk.component.Og.pA;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes11.dex */
public final class Bzk {
    private String Og;
    private String pA;

    private Bzk(String str) {
        this.pA = str;
    }

    public static Bzk pA(String str) {
        return new Bzk(str);
    }

    public String pA() {
        return this.pA;
    }

    public Charset pA(Charset charset) {
        try {
            String str = this.Og;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
