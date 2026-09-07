package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes12.dex */
public abstract class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A0 f2251a;
    public static final A0 b;

    static {
        A0 a0 = null;
        try {
            a0 = (A0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f2251a = a0;
        b = new A0();
    }
}
