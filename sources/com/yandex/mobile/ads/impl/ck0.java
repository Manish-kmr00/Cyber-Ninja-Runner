package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ck0 extends ng2<ImageView, uj0> {
    private final pj0 c;
    private final gj0 d;
    private final yj0 e;
    private final f02 f;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ck0(ImageView imageView, pj0 pj0Var, o8 o8Var) {
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this(imageView, pj0Var, o8Var, new gj0(context, new z81(o8Var), pj0Var), new yj0(pj0Var), new f02());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck0(ImageView view, pj0 imageProvider, o8<?> adResponse, gj0 imageForPresentProvider, yj0 imageValueValidator, f02 smartCenterImageRenderer) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(imageForPresentProvider, "imageForPresentProvider");
        Intrinsics.checkNotNullParameter(imageValueValidator, "imageValueValidator");
        Intrinsics.checkNotNullParameter(smartCenterImageRenderer, "smartCenterImageRenderer");
        this.c = imageProvider;
        this.d = imageForPresentProvider;
        this.e = imageValueValidator;
        this.f = smartCenterImageRenderer;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(View view) {
        ImageView view2 = (ImageView) view;
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setImageDrawable(null);
        this.f.a(view2);
        super.a(view2);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, uj0 uj0Var) {
        ImageView view2 = (ImageView) view;
        uj0 imageValue = uj0Var;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        a(imageValue);
    }

    public final void a(ImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setImageDrawable(null);
        this.f.a(view);
        super.a(view);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, uj0 uj0Var) {
        ImageView imageView = (ImageView) view;
        uj0 imageValue = uj0Var;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        return this.e.a(imageView.getDrawable(), imageValue);
    }

    public final void a(ImageView view, uj0 imageValue) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        a(imageValue);
    }

    private final void a(final uj0 uj0Var) {
        this.d.a(uj0Var, new gj0.b() { // from class: com.yandex.mobile.ads.impl.ck0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.gj0.b
            public final void a(Bitmap bitmap) {
                ck0.a(this.f$0, uj0Var, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck0 this$0, uj0 imageValue, Bitmap bitmap) {
        ImageView imageViewB;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageValue, "$imageValue");
        if (bitmap == null || (imageViewB = this$0.b()) == null) {
            return;
        }
        if (imageValue.e() != null) {
            this$0.f.a(bitmap, imageViewB, imageValue);
        } else {
            imageViewB.setImageBitmap(bitmap);
        }
    }
}
