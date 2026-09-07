package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public abstract /* synthetic */ class AbstractC3037x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1506a;

    static {
        int[] iArr = new int[EnumC3019n0.values().length];
        f1506a = iArr;
        try {
            iArr[EnumC3019n0.BeforeBox.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1506a[EnumC3019n0.AfterSize.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1506a[EnumC3019n0.AfterType.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1506a[EnumC3019n0.AfterExtendedSze.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1506a[EnumC3019n0.InBox.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
