package com.yandex.div.core.view2.reuse.util;

import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.reuse.ReusableTokenList;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div2.Div;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RebindUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"tryRebindPlainContainerChildren", "", "Landroid/view/ViewGroup;", "divView", "Lcom/yandex/div/core/view2/Div2View;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "divViewCreator", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivViewCreator;", "tryRebindRecycleContainerChildren", "div2View", "div", "Lcom/yandex/div2/Div;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RebindUtilsKt {
    public static final boolean tryRebindRecycleContainerChildren(ViewGroup viewGroup, Div2View div2View, Div div) {
        View uniqueViewForDiv;
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(div, "div");
        ReusableTokenList currentRebindReusableList$div_release = div2View.getCurrentRebindReusableList$div_release();
        if (currentRebindReusableList$div_release == null || (uniqueViewForDiv = currentRebindReusableList$div_release.getUniqueViewForDiv(div)) == null) {
            return false;
        }
        viewGroup.addView(uniqueViewForDiv);
        return true;
    }

    public static final boolean tryRebindPlainContainerChildren(ViewGroup viewGroup, Div2View divView, List<DivItemBuilderResult> items, Provider<DivViewCreator> divViewCreator) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(divViewCreator, "divViewCreator");
        ReusableTokenList currentRebindReusableList$div_release = divView.getCurrentRebindReusableList$div_release();
        if (currentRebindReusableList$div_release == null) {
            return false;
        }
        viewGroup.removeAllViews();
        for (DivItemBuilderResult divItemBuilderResult : items) {
            View uniqueViewForDiv = currentRebindReusableList$div_release.getUniqueViewForDiv(divItemBuilderResult.getDiv());
            if (uniqueViewForDiv == null) {
                uniqueViewForDiv = divViewCreator.get().create(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
            }
            viewGroup.addView(uniqueViewForDiv);
        }
        return true;
    }
}
