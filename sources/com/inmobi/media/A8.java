package com.inmobi.media;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class A8 extends AbstractC3640y8 {
    public final /* synthetic */ K8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A8(K8 k8) {
        super(k8);
        this.e = k8;
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Button(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view, C3455l7 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof Button) {
            K8.a(this.e, (Button) view, asset);
        }
    }

    @Override // com.inmobi.media.AbstractC3640y8
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof Button) {
            HashMap map = K8.c;
            TextView textView = (TextView) view;
            textView.setTypeface(Typeface.DEFAULT, 0);
            textView.setPaintFlags(textView.getPaintFlags() & (-17));
            textView.setPaintFlags(textView.getPaintFlags() & (-9));
            super.a(view);
        }
    }
}
