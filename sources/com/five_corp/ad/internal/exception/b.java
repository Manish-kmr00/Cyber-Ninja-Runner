package com.five_corp.ad.internal.exception;

import com.five_corp.ad.internal.p;

/* JADX INFO: loaded from: classes11.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f1373a;

    public b(p pVar, String str) {
        super(str, null);
        this.f1373a = pVar;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + this.f1373a.toString() + (getCause() == null ? "" : getCause().toString());
    }
}
