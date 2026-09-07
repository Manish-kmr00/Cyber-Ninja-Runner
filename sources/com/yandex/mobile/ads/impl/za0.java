package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class za0 extends ng2<ImageView, wa0> {
    private final gj0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za0(ImageView view, gj0 imageProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        this.c = imageProvider;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, wa0 wa0Var) {
        ImageView view2 = (ImageView) view;
        wa0 feedbackValue = wa0Var;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(feedbackValue, "feedbackValue");
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, wa0 wa0Var) {
        ImageView view2 = (ImageView) view;
        wa0 feedbackValue = wa0Var;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(feedbackValue, "feedbackValue");
        uj0 uj0VarA = feedbackValue.a();
        if (uj0VarA == null) {
            return;
        }
        view2.setForeground(null);
        view2.setBackground(null);
        a(uj0VarA);
    }

    private final void a(uj0 uj0Var) {
        this.c.a(uj0Var, new gj0.b() { // from class: com.yandex.mobile.ads.impl.za0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.gj0.b
            public final void a(Bitmap bitmap) {
                za0.a(this.f$0, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(za0 this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bitmap != null) {
            ImageView imageViewB = this$0.b();
            if (imageViewB != null) {
                imageViewB.setImageBitmap(bitmap);
                return;
            }
            return;
        }
        ImageView imageViewB2 = this$0.b();
        if (imageViewB2 != null) {
            imageViewB2.setImageDrawable(ContextCompat.getDrawable(imageViewB2.getContext(), R.drawable.monetization_ads_internal_default_adtune_feedback_icon));
        }
    }
}
