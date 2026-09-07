package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;
import com.json.b9;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5634a;
    private final String b;

    public g(String str, String str2) {
        this.f5634a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f5634a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f5634a, gVar.f5634a) && TextUtils.equals(this.b, gVar.b);
    }

    public int hashCode() {
        return (this.f5634a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f5634a + ",value=" + this.b + b9.i.e;
    }
}
