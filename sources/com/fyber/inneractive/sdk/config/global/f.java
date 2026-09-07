package com.fyber.inneractive.sdk.config.global;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1699a;
    public final boolean b;

    public f(boolean z, String str) {
        this.f1699a = str;
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public final boolean a(e eVar) {
        String str = this.f1699a;
        if (str != null) {
            return str.equalsIgnoreCase("android") ? !this.b : this.b;
        }
        return false;
    }

    public final String toString() {
        return "os - " + this.f1699a + " include: " + this.b;
    }
}
