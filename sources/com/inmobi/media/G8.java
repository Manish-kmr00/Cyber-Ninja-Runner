package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class G8 extends AbstractC3640y8 {
    public final /* synthetic */ K8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G8(K8 k8) {
        super(k8);
        this.e = k8;
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new C3314b8(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof C3314b8) {
            this.e.getClass();
            K8.a((C3314b8) view, asset);
        }
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof C3314b8) {
            super.a(view);
        }
    }
}
