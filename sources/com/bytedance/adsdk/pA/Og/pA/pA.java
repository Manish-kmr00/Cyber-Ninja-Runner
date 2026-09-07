package com.bytedance.adsdk.pA.Og.pA;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    private Object[] Og;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public Object[] Og() {
        return this.Og;
    }

    public void pA(Object[] objArr) {
        this.Og = objArr;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.pA + "', args=" + Arrays.toString(this.Og) + AbstractJsonLexerKt.END_OBJ;
    }
}
