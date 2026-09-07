package com.inmobi.media;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class A7 extends C3455l7 {
    public final String x;
    public final Lazy y;

    public /* synthetic */ A7(String str, String str2, C3471m7 c3471m7, String str3, String str4, JSONObject jSONObject) {
        this(str, str2, c3471m7, str3, new ArrayList(), str4, jSONObject);
    }

    public static final Z3 a(A7 a7, String str) {
        a7.getClass();
        return Build.VERSION.SDK_INT < 28 ? new C3295a4(str) : new H0(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A7(String assetId, String assetName, C3471m7 assetStyle, final String url, List trackers, final String interactionMode, final JSONObject jSONObject) {
        super(assetId, assetName, "GIF", assetStyle, trackers);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        this.x = "A7";
        this.y = LazyKt.lazy(new C3653z7(this, url));
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.A7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A7.a(url, this, jSONObject, interactionMode);
            }
        });
    }

    public static final void a(String url, A7 this$0, JSONObject jSONObject, String interactionMode) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interactionMode, "$interactionMode");
        C3417j c3417jB = AbstractC3415ib.a().b(url);
        this$0.e = c3417jB != null ? c3417jB.c : null;
        if (jSONObject != null) {
            Intrinsics.checkNotNullParameter(interactionMode, "<set-?>");
            this$0.g = interactionMode;
        }
    }
}
