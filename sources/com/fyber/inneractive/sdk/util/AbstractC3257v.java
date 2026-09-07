package com.fyber.inneractive.sdk.util;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract /* synthetic */ class AbstractC3257v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2379a;

    static {
        int[] iArr = new int[EnumC3259x.values().length];
        f2379a = iArr;
        try {
            iArr[EnumC3259x.Mraid.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2379a[EnumC3259x.Video.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
