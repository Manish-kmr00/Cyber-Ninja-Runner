package com.bytedance.adsdk.pA.pA;

/* JADX INFO: loaded from: classes6.dex */
public class Og extends RuntimeException {
    public Og(String str, Throwable th) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th);
    }
}
