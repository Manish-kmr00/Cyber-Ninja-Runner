package com.mbridge.msdk.mbsignalcommon.mapping;

/* JADX INFO: compiled from: Mapping.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f5248a;
    private String b;

    public a(String str) {
        super(str);
    }

    public void a(Class<?> cls) {
        this.f5248a = cls;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getCause() != null ? getClass().getName() + ": " + getCause() : super.toString();
    }

    public a(Exception exc) {
        super(exc);
    }

    public void a(String str) {
        this.b = str;
    }
}
