package io.appmetrica.analytics.impl;

import java.util.Set;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.yb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4587yb implements Oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oa f11857a;

    public C4587yb(Oa oa) {
        this.f11857a = oa;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, String str2) {
        this.f11857a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final void b() {
        this.f11857a.b();
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final boolean getBoolean(String str, boolean z) {
        return this.f11857a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final int getInt(String str, int i) {
        return this.f11857a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final long getLong(String str, long j) {
        return this.f11857a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final String getString(String str, String str2) {
        return this.f11857a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa remove(String str) {
        this.f11857a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, long j) {
        this.f11857a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(int i, String str) {
        this.f11857a.a(i, str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, boolean z) {
        this.f11857a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, float f) {
        this.f11857a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final boolean a(String str) {
        return this.f11857a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Set a() {
        return this.f11857a.a();
    }
}
