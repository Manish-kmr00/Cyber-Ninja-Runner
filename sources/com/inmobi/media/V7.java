package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class V7 extends C3455l7 {
    public /* synthetic */ V7(String str, String str2, U7 u7, String str3) {
        this(str, str2, "TEXT", u7, str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V7(String assetId, String assetName, String assetType, U7 assetStyle, String str) {
        super(assetId, assetName, assetType, assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        this.e = str;
    }
}
