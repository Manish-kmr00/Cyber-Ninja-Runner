package com.yandex.mobile.ads.impl;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o31 extends ng2<ViewPager2, List<? extends uj0>> {
    private final pj0 c;
    private final lp1 d;
    private final o8<?> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o31(ViewPager2 viewPager, pj0 imageProvider, lp1 reporter, o8<?> adResponse) {
        super(viewPager);
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.c = imageProvider;
        this.d = reporter;
        this.e = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, List<? extends uj0> list) {
        ViewPager2 viewPager = (ViewPager2) view;
        List<? extends uj0> imageValues = list;
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        return viewPager.getAdapter() instanceof l31;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, List<? extends uj0> list) {
        ViewPager2 viewPager = (ViewPager2) view;
        List<? extends uj0> imageValues = list;
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        try {
            viewPager.setAdapter(new l31(this.c, imageValues, this.e));
        } catch (IllegalArgumentException e) {
            lp1 lp1Var = this.d;
            String message = e.getMessage();
            if (message == null) {
                message = "IllegalArgumentException: set adapter exception";
            }
            lp1Var.reportError(message, e);
        }
    }
}
