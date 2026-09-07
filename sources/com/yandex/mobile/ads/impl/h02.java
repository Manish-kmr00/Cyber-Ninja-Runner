package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h02 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ri f9050a;
    private final al b;
    private final i02 c;
    private final uj0 d;
    private final Bitmap e;

    public h02(ri axisBackgroundColorProvider, al bestSmartCenterProvider, i02 smartCenterMatrixScaler, uj0 imageValue, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(axisBackgroundColorProvider, "axisBackgroundColorProvider");
        Intrinsics.checkNotNullParameter(bestSmartCenterProvider, "bestSmartCenterProvider");
        Intrinsics.checkNotNullParameter(smartCenterMatrixScaler, "smartCenterMatrixScaler");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.f9050a = axisBackgroundColorProvider;
        this.b = bestSmartCenterProvider;
        this.c = smartCenterMatrixScaler;
        this.d = imageValue;
        this.e = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(h02 this$0, RectF viewRect, ImageView view) {
        ti tiVarA;
        c02 c02VarB;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewRect, "$viewRect");
        Intrinsics.checkNotNullParameter(view, "$view");
        this$0.getClass();
        if (viewRect.height() == 0.0f) {
            return;
        }
        ri riVar = this$0.f9050a;
        uj0 imageValue = this$0.d;
        riVar.getClass();
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        k02 k02VarE = imageValue.e();
        if (k02VarE != null && (tiVarA = k02VarE.a()) != null) {
            boolean z = (tiVarA.a() == null || tiVarA.d() == null || !Intrinsics.areEqual(tiVarA.a(), tiVarA.d())) ? false : true;
            boolean z2 = (tiVarA.b() == null || tiVarA.c() == null || !Intrinsics.areEqual(tiVarA.b(), tiVarA.c())) ? false : true;
            if (z || z2) {
                ri riVar2 = this$0.f9050a;
                uj0 uj0Var = this$0.d;
                riVar2.getClass();
                String strA = ri.a(viewRect, uj0Var);
                k02 k02VarE2 = this$0.d.e();
                if (k02VarE2 == null || (c02VarB = k02VarE2.b()) == null) {
                    return;
                }
                if (strA != null) {
                    this$0.c.a(view, this$0.e, c02VarB, strA);
                    return;
                } else {
                    this$0.c.a(view, this$0.e, c02VarB);
                    return;
                }
            }
        }
        c02 c02VarA = this$0.b.a(viewRect, this$0.d);
        if (c02VarA != null) {
            this$0.c.a(view, this$0.e, c02VarA);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        final ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
        if (imageView == null) {
            return;
        }
        int i9 = i7 - i5;
        boolean z = false;
        boolean z2 = (i3 - i == i9 && i4 - i2 == i8 - i6) ? false : true;
        if (i4 != i2 && i != i3) {
            z = true;
        }
        if (z2 && z) {
            final RectF rectF = new RectF(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            imageView.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.h02$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    h02.a(this.f$0, rectF, imageView);
                }
            });
        }
    }
}
