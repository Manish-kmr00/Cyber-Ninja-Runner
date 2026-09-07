package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes7.dex */
public abstract class M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L0 f2263a;
    public static final L0 b;

    static {
        L0 l0 = null;
        try {
            l0 = (L0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f2263a = l0;
        b = new L0();
    }
}
