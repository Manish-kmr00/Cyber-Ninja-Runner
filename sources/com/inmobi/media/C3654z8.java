package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.z8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3654z8 extends AbstractC3640y8 {
    public C3654z8(K8 k8) {
        super(k8);
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new C3540r7(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        HashMap map = K8.c;
        C3584u8.a(view, asset.d);
    }
}
