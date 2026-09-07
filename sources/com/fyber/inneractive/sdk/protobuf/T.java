package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes13.dex */
public abstract /* synthetic */ class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2269a;

    static {
        int[] iArr = new int[L1.values().length];
        f2269a = iArr;
        try {
            iArr[L1.MESSAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2269a[L1.ENUM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
