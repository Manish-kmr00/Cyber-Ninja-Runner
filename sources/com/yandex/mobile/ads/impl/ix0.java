package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.monetization.ads.fullscreen.template.view.ExtendedViewContainer;
import com.monetization.ads.nativeads.CustomizableMediaView;
import com.monetization.ads.nativeads.view.pager.MultiBannerControlsContainer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ix0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m31 f9265a = new m31();
    private final f31 b = new f31();
    private final e31 c = new e31();

    public final uv1 a(o8 adResponse, o3 adConfiguration, CustomizableMediaView mediaView, pj0 imageProvider, List imageValues, kx0 mediaViewRenderController, rx1 rx1Var) {
        c31 c31Var;
        Long lB;
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Context context = mediaView.getContext();
        ViewPager2 viewPager = new ViewPager2(context);
        Intrinsics.checkNotNull(context);
        g31 g31Var = new g31(context, adResponse, adConfiguration);
        n31 n31Var = new n31(viewPager);
        long jLongValue = (rx1Var == null || (lB = rx1Var.b()) == null) ? 0L : lB.longValue();
        if (jLongValue > 0) {
            c31Var = new c31(viewPager, n31Var, g31Var, new gt0());
            viewPager.addOnAttachStateChangeListener(new j31(c31Var, jLongValue));
        } else {
            c31Var = null;
        }
        viewPager.registerOnPageChangeCallback(new tf1(g31Var, c31Var));
        MultiBannerControlsContainer multiBannerControlsContainerA = this.b.a(context);
        if (multiBannerControlsContainerA != null) {
            multiBannerControlsContainerA.a(viewPager);
            multiBannerControlsContainerA.setOnClickLeftButtonListener(new is.a(n31Var, g31Var, c31Var));
            multiBannerControlsContainerA.setOnClickRightButtonListener(new is.b(n31Var, g31Var, c31Var));
        }
        ExtendedViewContainer container = this.c.a(context, imageValues);
        this.f9265a.getClass();
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Context context2 = mediaView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (!u80.a(context2, t80.e)) {
            mediaView.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        container.addView(viewPager, layoutParams);
        if (multiBannerControlsContainerA != null) {
            container.addView(multiBannerControlsContainerA, layoutParams);
        }
        mediaView.addView(container, layoutParams);
        o31 o31Var = new o31(viewPager, imageProvider, adConfiguration.q().c(), adResponse);
        return new uv1(mediaView, o31Var, mediaViewRenderController, new og2(o31Var));
    }
}
