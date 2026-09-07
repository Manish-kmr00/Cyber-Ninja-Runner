package com.five_corp.ad.internal;

import android.util.Log;
import com.five_corp.ad.FiveAdErrorCode;

/* JADX INFO: loaded from: classes10.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f1517a;
    public final String b;
    public final Throwable c;
    public final o d;

    public o(p pVar, String str, Throwable th, o oVar) {
        this.f1517a = pVar;
        this.b = str;
        this.c = th;
        this.d = oVar;
    }

    public final FiveAdErrorCode a() {
        o oVar = this.d;
        return oVar != null ? oVar.a() : this.f1517a.b;
    }

    public final String b() {
        o oVar = this.d;
        String strB = oVar != null ? oVar.b() : "null";
        return "DetailedErrorCode: " + this.f1517a.name() + ", information: " + String.valueOf(this.b) + ", exception: " + Log.getStackTraceString(this.c) + ", cause: " + strB;
    }
}
