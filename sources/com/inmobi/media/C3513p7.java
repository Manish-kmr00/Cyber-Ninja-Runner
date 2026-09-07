package com.inmobi.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.p7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3513p7 extends C3455l7 implements Iterable, KMappedMarker {
    public final ArrayList A;
    public int B;
    public final boolean C;
    public final boolean D;
    public final int x;
    public long y;
    public final byte z;

    public /* synthetic */ C3513p7(String str, String str2, C3471m7 c3471m7, String str3, JSONObject jSONObject, byte b) {
        this(str, str2, c3471m7, new ArrayList(), str3, jSONObject, b);
    }

    public final void a(C3455l7 child) {
        Intrinsics.checkNotNullParameter(child, "child");
        int i = this.B;
        if (i < this.x) {
            this.B = i + 1;
            this.A.add(child);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C3499o7(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3513p7(String assetId, String assetName, C3471m7 assetStyle, List trackers, String interactionMode, JSONObject rawAssetJson, byte b) {
        super(assetId, assetName, "CONTAINER", assetStyle, trackers);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        Intrinsics.checkNotNullParameter(rawAssetJson, "rawAssetJson");
        this.x = 16;
        this.z = b;
        this.A = new ArrayList();
        Intrinsics.checkNotNullParameter(interactionMode, "<set-?>");
        this.g = interactionMode;
        this.C = StringsKt.equals("root", assetName, true);
        this.D = StringsKt.equals("card_scrollable", assetName, true);
    }
}
