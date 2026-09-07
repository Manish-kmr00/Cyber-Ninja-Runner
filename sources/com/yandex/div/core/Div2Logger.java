package com.yandex.div.core;

import android.view.View;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.logging.patch.PatchResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivData;
import com.yandex.div2.DivDisappearAction;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivPager;
import com.yandex.div2.DivPatch;
import com.yandex.div2.DivVisibilityAction;

/* JADX INFO: loaded from: classes6.dex */
public interface Div2Logger {
    public static final Div2Logger STUB = new Div2Logger() { // from class: com.yandex.div.core.Div2Logger.1
    };

    default void logActiveTabTitleClick(Div2View div2View, ExpressionResolver expressionResolver, int i, DivAction divAction) {
    }

    default void logBindingResult(Div2View div2View, DivData divData, DivData divData2, String str, String str2) {
    }

    default void logClick(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction) {
    }

    default void logDoubleClick(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction) {
    }

    default void logFocusChanged(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction, boolean z) {
    }

    default void logGalleryCompleteScroll(Div2View div2View, ExpressionResolver expressionResolver, DivGallery divGallery, int i, int i2, String str) {
    }

    default void logGalleryScroll(Div2View div2View) {
    }

    default void logHoverChanged(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction, boolean z) {
    }

    default void logImeEnter(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction) {
    }

    default void logLongClick(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction) {
    }

    default void logPagerChangePage(Div2View div2View, ExpressionResolver expressionResolver, DivPager divPager, int i, String str) {
    }

    default void logPatchResult(Div2View div2View, DivPatch divPatch, @PatchResult String str, String str2) {
    }

    default void logPopupMenuItemClick(Div2View div2View, ExpressionResolver expressionResolver, int i, String str, DivAction divAction) {
    }

    default void logPressChanged(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction, boolean z) {
    }

    default void logSliderDrag(Div2View div2View, View view, Float f) {
    }

    default void logSwipedAway(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction) {
    }

    default void logTabPageChanged(Div2View div2View, int i) {
    }

    default void logTabTitlesScroll(Div2View div2View) {
    }

    default void logTrigger(Div2View div2View, DivAction divAction) {
    }

    default void logViewDisappeared(Div2View div2View, ExpressionResolver expressionResolver, View view, DivDisappearAction divDisappearAction) {
    }

    default void logViewShown(Div2View div2View, ExpressionResolver expressionResolver, View view, DivVisibilityAction divVisibilityAction) {
    }

    default void logClick(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction, String str) {
        logClick(div2View, expressionResolver, view, divAction);
    }

    default void logLongClick(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction, String str) {
        logLongClick(div2View, expressionResolver, view, divAction);
    }

    default void logDoubleClick(Div2View div2View, ExpressionResolver expressionResolver, View view, DivAction divAction, String str) {
        logDoubleClick(div2View, expressionResolver, view, divAction);
    }

    default void logViewShown(Div2View div2View, ExpressionResolver expressionResolver, View view, DivVisibilityAction divVisibilityAction, String str) {
        logViewShown(div2View, expressionResolver, view, divVisibilityAction);
    }

    default void logViewDisappeared(Div2View div2View, ExpressionResolver expressionResolver, View view, DivDisappearAction divDisappearAction, String str) {
        logViewDisappeared(div2View, expressionResolver, view, divDisappearAction);
    }
}
