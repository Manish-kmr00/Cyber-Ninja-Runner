package com.five_corp.ad.internal.context;

import com.five_corp.ad.CreativeType;

/* JADX INFO: loaded from: classes11.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1358a;

    static {
        int[] iArr = new int[CreativeType.values().length];
        f1358a = iArr;
        try {
            iArr[CreativeType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1358a[CreativeType.MOVIE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1358a[CreativeType.NOT_LOADED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
