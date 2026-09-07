package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.div.DivDataTag;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div2.DivData;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r20 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DivData f10067a;
    private final h20 b;
    private final DivConfiguration c;
    private final lp1 d;
    private final LifecycleOwner e;
    private final k30 f;
    private final e20 g;

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }

    public /* synthetic */ r20(DivData divData, h20 h20Var, DivConfiguration divConfiguration, lp1 lp1Var, LifecycleOwner lifecycleOwner) {
        this(divData, h20Var, divConfiguration, lp1Var, lifecycleOwner, new k30(), new e20());
    }

    public r20(DivData divData, h20 divKitActionAdapter, DivConfiguration divConfiguration, lp1 reporter, LifecycleOwner lifecycleOwner, k30 divViewCreator, e20 divDataTagCreator) {
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(divKitActionAdapter, "divKitActionAdapter");
        Intrinsics.checkNotNullParameter(divConfiguration, "divConfiguration");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divViewCreator, "divViewCreator");
        Intrinsics.checkNotNullParameter(divDataTagCreator, "divDataTagCreator");
        this.f10067a = divData;
        this.b = divKitActionAdapter;
        this.c = divConfiguration;
        this.d = reporter;
        this.e = lifecycleOwner;
        this.f = divViewCreator;
        this.g = divDataTagCreator;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView container = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(container, "container");
        try {
            Context context = container.getContext();
            k30 k30Var = this.f;
            Intrinsics.checkNotNull(context);
            DivConfiguration divConfiguration = this.c;
            LifecycleOwner lifecycleOwner = this.e;
            k30Var.getClass();
            Div2View div2ViewA = k30.a(context, divConfiguration, lifecycleOwner);
            container.addView(div2ViewA);
            this.g.getClass();
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            div2ViewA.setData(this.f10067a, new DivDataTag(string));
            r10.a(div2ViewA).a(this.b);
        } catch (Throwable th) {
            op0.b(new Object[0]);
            this.d.reportError("Failed to bind DivKit", th);
        }
    }
}
