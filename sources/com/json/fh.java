package com.json;

/* JADX INFO: loaded from: classes10.dex */
public class fh {
    public static final int c = 1001;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3697a;
    private int b;

    public fh(int i, String str) {
        this.b = i;
        this.f3697a = str == null ? "" : str;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.f3697a;
    }

    public String toString() {
        return "error - code:" + this.b + ", message:" + this.f3697a;
    }
}
