package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;

/* JADX INFO: loaded from: classes13.dex */
public abstract /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1970a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[VideoClickOrigin.values().length];
        b = iArr;
        try {
            iArr[VideoClickOrigin.STORE_PROMO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[VideoClickOrigin.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[VideoClickOrigin.APP_INFO.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[com.fyber.inneractive.sdk.player.enums.b.values().length];
        f1970a = iArr2;
        try {
            iArr2[com.fyber.inneractive.sdk.player.enums.b.Prepared.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Buffering.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Playing.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Paused.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Completed.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Error.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Preparing.ordinal()] = 7;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f1970a[com.fyber.inneractive.sdk.player.enums.b.Seeking.ordinal()] = 8;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
