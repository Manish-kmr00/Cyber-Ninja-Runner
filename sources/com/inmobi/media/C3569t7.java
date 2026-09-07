package com.inmobi.media;

import io.bidmachine.iab.vast.tags.VastTagName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.t7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3569t7 extends V7 {
    public /* synthetic */ C3569t7(String str, String str2, C3555s7 c3555s7, String str3, String str4) {
        this(str, str2, c3555s7, str3, new ArrayList(), str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3569t7(String assetId, String assetName, C3555s7 assetStyle, String str, List trackers, String interactionMode) {
        super(assetId, assetName, VastTagName.CTA, assetStyle, str);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.s.addAll(trackers);
        Intrinsics.checkNotNullParameter(interactionMode, "<set-?>");
        this.g = interactionMode;
    }
}
