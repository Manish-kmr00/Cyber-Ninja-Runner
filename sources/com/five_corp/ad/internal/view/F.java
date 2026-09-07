package com.five_corp.ad.internal.view;

import com.five_corp.ad.CreativeType;

/* JADX INFO: loaded from: classes10.dex */
public abstract /* synthetic */ class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1565a;

    static {
        int[] iArr = new int[CreativeType.values().length];
        f1565a = iArr;
        try {
            iArr[CreativeType.MOVIE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1565a[CreativeType.IMAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
