package com.yandex.mobile.ads.impl;

import android.R;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivCustom;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class z10 implements DivCustomContainerViewAdapter {
    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final void bindView(View view, DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final View createView(DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path) throws JSONException {
        int color;
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(path, "path");
        String string = null;
        ProgressBar progressBar = new ProgressBar(divView.getContext(), null, R.attr.progressBarStyleHorizontal);
        JSONObject jSONObject = div.customProps;
        if (jSONObject == null || !jSONObject.has("progress_color")) {
            string = "#000000";
        } else {
            JSONObject jSONObject2 = div.customProps;
            if (jSONObject2 != null) {
                string = jSONObject2.getString("progress_color");
            }
        }
        try {
            color = Color.parseColor(string);
        } catch (Throwable unused) {
            color = ViewCompat.MEASURED_STATE_MASK;
        }
        Drawable drawable = progressBar.getContext().getDrawable(com.yandex.mobile.ads.R.drawable.monetization_ads_internal_circular_close_progress);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        }
        progressBar.setProgressDrawable(drawable);
        return progressBar;
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final boolean isCustomTypeSupported(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual(type, "close_progress_view");
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final void release(View view, DivCustom div) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
    }
}
