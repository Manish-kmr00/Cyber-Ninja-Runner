package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class H8 extends AbstractC3640y8 {
    public final /* synthetic */ K8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H8(K8 k8) {
        super(k8);
        this.e = k8;
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new C3570t8(applicationContext);
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof C3570t8) {
            C3570t8 c3570t8 = (C3570t8) view;
            this.e.getClass();
            HashMap map = K8.c;
            C3584u8.a(c3570t8, asset.d);
            Object obj = asset.u;
            if (obj instanceof Bitmap) {
                c3570t8.setPosterImage((Bitmap) obj);
            }
            c3570t8.getProgressBar().setVisibility(0);
        }
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof C3570t8) {
            C3570t8 c3570t8 = (C3570t8) view;
            c3570t8.getProgressBar().setVisibility(8);
            c3570t8.setPosterImage((Bitmap) null);
            c3570t8.getVideoView().f();
            super.a(view);
        }
    }
}
