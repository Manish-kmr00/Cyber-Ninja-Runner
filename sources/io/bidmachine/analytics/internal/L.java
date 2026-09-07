package io.bidmachine.analytics.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12052a;
    private final StringBuffer b;
    private Long c;

    public L(int i, int i2) {
        this.f12052a = i2;
        this.b = new StringBuffer(i);
    }

    public final void a(String str) throws IOException {
        if (this.b.length() + str.length() < this.f12052a) {
            this.b.append((CharSequence) str).append('\n');
            this.c = Long.valueOf(System.currentTimeMillis());
        }
    }

    public String toString() {
        return this.b.toString();
    }

    public final Long a() {
        return this.c;
    }
}
