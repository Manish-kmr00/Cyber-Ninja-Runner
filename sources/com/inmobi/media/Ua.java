package com.inmobi.media;

/* JADX INFO: loaded from: classes7.dex */
public final class Ua {
    public static final Ta Companion = new Ta();
    public static final String DEFAULT_POSITION = "top-right";
    private static final String TAG = "Ua";
    private boolean allowOffscreen;
    private String customClosePosition;
    private int height;
    private int offsetX;
    private int offsetY;
    private int width;

    public Ua(String str, boolean z) {
        this.customClosePosition = str;
        this.allowOffscreen = z;
    }

    public final boolean a() {
        return this.allowOffscreen;
    }

    public final String b() {
        return this.customClosePosition;
    }

    public final int c() {
        return this.height;
    }

    public final int d() {
        return this.offsetX;
    }

    public final int e() {
        return this.offsetY;
    }

    public final int f() {
        return this.width;
    }

    public final void a(boolean z) {
        this.allowOffscreen = z;
    }

    public final void a(String str) {
        this.customClosePosition = str;
    }
}
