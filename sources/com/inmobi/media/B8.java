package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class B8 extends AbstractC3640y8 {
    public final /* synthetic */ K8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B8(K8 k8) {
        super(k8);
        this.e = k8;
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new C3310b4(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof C3310b4) {
            C3310b4 c3310b4 = (C3310b4) view;
            this.e.getClass();
            HashMap map = K8.c;
            c3310b4.setLayoutParams(new ViewGroup.LayoutParams(C3584u8.a(asset.d.f3375a.x), C3584u8.a(asset.d.f3375a.y)));
            c3310b4.setContentMode(asset.d.g);
            Intrinsics.checkNotNull(asset, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeGifAsset");
            c3310b4.setGifImpl((Z3) ((A7) asset).y.getValue());
            C3584u8.a(c3310b4, asset.d);
        }
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof C3310b4) {
            ((C3310b4) view).setGifImpl(null);
            super.a(view);
        }
    }
}
