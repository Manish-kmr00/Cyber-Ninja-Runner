package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

/* JADX INFO: loaded from: classes9.dex */
public enum x {
    XmlParsing(100),
    Wrapper(300),
    WrapperTimeout(301),
    WrapperLimit(302),
    WrapperNoAds(303),
    Linear(400),
    LinearFileNotFound(401),
    LinearNotSupportedMedia(403),
    Companion(600),
    Undefined(900);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6910a;

    x(int i) {
        this.f6910a = i;
    }

    public final int b() {
        return this.f6910a;
    }
}
