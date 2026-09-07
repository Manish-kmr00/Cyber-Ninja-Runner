package com.five_corp.ad;

/* JADX INFO: loaded from: classes12.dex */
public abstract /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1601a;

    static {
        int[] iArr = new int[FiveAdState.values().length];
        f1601a = iArr;
        try {
            iArr[FiveAdState.NOT_LOADED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1601a[FiveAdState.LOADING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1601a[FiveAdState.LOADED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1601a[FiveAdState.CLOSED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1601a[FiveAdState.ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
