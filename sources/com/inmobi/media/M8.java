package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class M8 extends C3455l7 {
    public final boolean x;
    public String y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M8(String assetId, String assetName, C3471m7 assetStyle, String textValue, boolean z) {
        super(assetId, assetName, "WEBVIEW", assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(textValue, "textValue");
        this.x = z;
        this.e = textValue;
    }

    public final void b() {
        this.z = true;
    }

    public final void e(String str) {
        this.y = str;
    }
}
