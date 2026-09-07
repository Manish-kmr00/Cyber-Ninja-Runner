package com.safedk.android.analytics.reporters;

/* JADX INFO: loaded from: classes11.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8129a = "application";
    private StackTraceElement b;
    private String c;
    private String d;
    private int e;

    public c(StackTraceElement stackTraceElement, String str) {
        this.b = stackTraceElement;
        this.c = str;
    }

    public c(StackTraceElement stackTraceElement) {
        this.b = stackTraceElement;
        this.c = "application";
    }

    public StackTraceElement a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }
}
