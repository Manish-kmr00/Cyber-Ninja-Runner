package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.i5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC4183i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4282m5 f11595a;
    public final String b = "[ComponentMigrationToV113]";

    public AbstractC4183i5(C4282m5 c4282m5) {
        this.f11595a = c4282m5;
    }

    public final C4282m5 a() {
        return this.f11595a;
    }

    public final String b() {
        return this.b;
    }

    public abstract boolean b(int i);

    public abstract void c();

    public final void a(int i) {
        if (b(i)) {
            c();
        }
    }
}
