package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.mobile.ads.impl.fn1;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class en1<V extends View & fn1> extends ng2<V, String> {
    private final lp1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en1(V ratingView, lp1 reporter) {
        super(ratingView);
        Intrinsics.checkNotNullParameter(ratingView, "ratingView");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.c = reporter;
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(V view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRating(0.0f);
        super.a(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, String str) {
        String value = str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            ((fn1) view).setRating(RangesKt.coerceAtLeast(Float.parseFloat(value), 0.0f));
        } catch (NumberFormatException e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(String.format("Could not parse rating value. Rating value is %s", Arrays.copyOf(new Object[]{value}, 1)), "format(...)");
            Object[] args = new Object[0];
            int i = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            this.c.reportError("Could not parse rating value", e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, String str) {
        String value = str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        return true;
    }
}
