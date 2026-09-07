package com.yandex.div.core.actions;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivTypedValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0017H\u0000¨\u0006\u0018"}, d2 = {"closeKeyboard", "", "Landroid/view/View;", "colorIntValue", "", "Lcom/yandex/div2/DivTypedValue;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div2/DivTypedValue;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Integer;", "doubleValue", "", "(Lcom/yandex/div2/DivTypedValue;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Double;", "evaluate", "", "logError", "Lcom/yandex/div/core/view2/Div2View;", "throwable", "", "logWarning", "longValue", "", "(Lcom/yandex/div2/DivTypedValue;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Long;", "openKeyboard", "Lcom/yandex/div/core/view2/divs/widgets/DivInputView;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedUtilsKt {
    public static final void logError(Div2View div2View, Throwable throwable) {
        Intrinsics.checkNotNullParameter(div2View, "<this>");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        div2View.getViewComponent().getErrorCollectors().getOrCreate(div2View.getDataTag(), div2View.getDivData()).logError(throwable);
    }

    public static final void logWarning(Div2View div2View, Throwable throwable) {
        Intrinsics.checkNotNullParameter(div2View, "<this>");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        div2View.getViewComponent().getErrorCollectors().getOrCreate(div2View.getDataTag(), div2View.getDivData()).logWarning(throwable);
    }

    public static final Object evaluate(DivTypedValue divTypedValue, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divTypedValue, "<this>");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        if (divTypedValue instanceof DivTypedValue.Integer) {
            return ((DivTypedValue.Integer) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Str) {
            return ((DivTypedValue.Str) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Bool) {
            return ((DivTypedValue.Bool) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Color) {
            return ((DivTypedValue.Color) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Number) {
            return ((DivTypedValue.Number) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Url) {
            return ((DivTypedValue.Url) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Array) {
            return ((DivTypedValue.Array) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        if (divTypedValue instanceof DivTypedValue.Dict) {
            return ((DivTypedValue.Dict) divTypedValue).getValue().value;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Long longValue(DivTypedValue divTypedValue, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divTypedValue, "<this>");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        if (divTypedValue instanceof DivTypedValue.Integer) {
            return ((DivTypedValue.Integer) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        return null;
    }

    public static final Double doubleValue(DivTypedValue divTypedValue, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divTypedValue, "<this>");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        if (divTypedValue instanceof DivTypedValue.Integer) {
            return Double.valueOf(((DivTypedValue.Integer) divTypedValue).getValue().value.evaluate(expressionResolver).longValue());
        }
        if (divTypedValue instanceof DivTypedValue.Number) {
            return Double.valueOf(((DivTypedValue.Number) divTypedValue).getValue().value.evaluate(expressionResolver).doubleValue());
        }
        return null;
    }

    public static final Integer colorIntValue(DivTypedValue divTypedValue, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divTypedValue, "<this>");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        if (divTypedValue instanceof DivTypedValue.Color) {
            return ((DivTypedValue.Color) divTypedValue).getValue().value.evaluate(expressionResolver);
        }
        return null;
    }

    public static final void openKeyboard(DivInputView divInputView) {
        Intrinsics.checkNotNullParameter(divInputView, "<this>");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(divInputView.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(divInputView, 1);
        }
    }

    public static final void closeKeyboard(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }
}
