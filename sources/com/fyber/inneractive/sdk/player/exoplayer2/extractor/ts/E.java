package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes9.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2072a;
    public final int b;
    public final int c;
    public int d;
    public String e;

    public E(int i, int i2, int i3) {
        this.f2072a = i != Integer.MIN_VALUE ? i + RemoteSettings.FORWARD_SLASH_STRING : "";
        this.b = i2;
        this.c = i3;
        this.d = Integer.MIN_VALUE;
    }

    public final void a() {
        int i = this.d;
        this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
        this.e = this.f2072a + this.d;
    }

    public final void b() {
        if (this.d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }
}
