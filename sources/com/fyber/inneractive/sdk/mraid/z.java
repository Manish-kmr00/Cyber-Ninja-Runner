package com.fyber.inneractive.sdk.mraid;

/* JADX INFO: loaded from: classes11.dex */
public final class z extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1902a;
    public final int b;
    public final int d = 0;
    public final int c = 0;

    public z(int i, int i2) {
        this.f1902a = i;
        this.b = i2;
    }

    @Override // com.fyber.inneractive.sdk.mraid.y
    public final String a() {
        return "currentPosition: { x: " + this.c + ", y: " + this.d + ", width: " + this.f1902a + ", height: " + this.b + " }";
    }
}
