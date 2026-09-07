package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes13.dex */
public class k0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1923a;

    public k0(String str, int i) {
        super(str);
        this.f1923a = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return String.valueOf(this.f1923a);
    }
}
