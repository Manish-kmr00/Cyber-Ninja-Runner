package com.pubmatic.sdk.webrendering.mraid;

/* JADX INFO: loaded from: classes4.dex */
public class POBViewRect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f7915a;
    final String b;
    int c;
    int d;
    int e;
    int f;

    public POBViewRect(int i, int i2, int i3, int i4, boolean z, String str) {
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.f7915a = z;
        this.b = str;
    }

    public int getHeight() {
        return this.e;
    }

    public String getStatusMsg() {
        return this.b;
    }

    public int getWidth() {
        return this.f;
    }

    public int getxPosition() {
        return this.c;
    }

    public int getyPosition() {
        return this.d;
    }

    public boolean isStatus() {
        return this.f7915a;
    }

    public POBViewRect(boolean z, String str) {
        this.f7915a = z;
        this.b = str;
    }
}
