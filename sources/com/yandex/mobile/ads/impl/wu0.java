package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdImage;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdMedia;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cj0 f10594a;

    public wu0(cj0 imageAssetConverter) {
        Intrinsics.checkNotNullParameter(imageAssetConverter, "imageAssetConverter");
        this.f10594a = imageAssetConverter;
    }

    public final ax0 a(Map<String, Bitmap> imageValues, MediatedNativeAdImage mediatedNativeAdImage, MediatedNativeAdMedia mediatedNativeAdMedia) {
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        su0 su0Var = mediatedNativeAdMedia != null ? new su0(null, mediatedNativeAdMedia.getAspectRatio()) : null;
        uj0 uj0VarA = this.f10594a.a(imageValues, mediatedNativeAdImage);
        List listMutableListOf = uj0VarA != null ? CollectionsKt.mutableListOf(uj0VarA) : null;
        if (su0Var == null && listMutableListOf == null) {
            return null;
        }
        return new ax0(su0Var, null, listMutableListOf);
    }
}
