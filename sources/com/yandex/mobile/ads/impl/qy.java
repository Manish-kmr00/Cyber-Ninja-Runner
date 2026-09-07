package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes5.dex */
public final class qy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10055a;
    public final gc0 b;
    public final gc0 c;
    public final int d;
    public final int e;

    public qy(String str, gc0 gc0Var, gc0 gc0Var2, int i, int i2) {
        hg.a(i == 0 || i2 == 0);
        this.f10055a = hg.a(str);
        this.b = (gc0) hg.a(gc0Var);
        this.c = (gc0) hg.a(gc0Var2);
        this.d = i;
        this.e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qy.class != obj.getClass()) {
            return false;
        }
        qy qyVar = (qy) obj;
        return this.d == qyVar.d && this.e == qyVar.e && this.f10055a.equals(qyVar.f10055a) && this.b.equals(qyVar.b) && this.c.equals(qyVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + v3.a(this.f10055a, (((this.d + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.e) * 31, 31)) * 31);
    }
}
