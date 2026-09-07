package com.yandex.div.core.actions;

import com.yandex.div.core.expression.storedvalues.StoredValuesActionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.data.StoredValue;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.Url;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionSetStoredValue;
import com.yandex.div2.DivActionTyped;
import com.yandex.div2.DivTypedValue;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedSetStoredValueHandler.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedSetStoredValueHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "createStoredValue", "Lcom/yandex/div/data/StoredValue;", "value", "Lcom/yandex/div2/DivTypedValue;", "name", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleAction", "", "action", "Lcom/yandex/div2/DivActionSetStoredValue;", "view", "Lcom/yandex/div/core/view2/Div2View;", "", "scopeId", "Lcom/yandex/div2/DivActionTyped;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedSetStoredValueHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedSetStoredValueHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.SetStoredValue)) {
            return false;
        }
        handleAction(((DivActionTyped.SetStoredValue) action).getValue(), view, resolver);
        return true;
    }

    private final void handleAction(DivActionSetStoredValue action, Div2View view, ExpressionResolver resolver) {
        String strEvaluate = action.name.evaluate(resolver);
        long jLongValue = action.lifetime.evaluate(resolver).longValue();
        StoredValuesActionHandler.INSTANCE.executeAction(createStoredValue(action.value, strEvaluate, resolver), jLongValue, view);
    }

    private final StoredValue createStoredValue(DivTypedValue value, String name, ExpressionResolver resolver) {
        if (value instanceof DivTypedValue.Str) {
            return new StoredValue.StringStoredValue(name, ((DivTypedValue.Str) value).getValue().value.evaluate(resolver));
        }
        if (value instanceof DivTypedValue.Integer) {
            return new StoredValue.IntegerStoredValue(name, ((DivTypedValue.Integer) value).getValue().value.evaluate(resolver).longValue());
        }
        if (value instanceof DivTypedValue.Bool) {
            return new StoredValue.BooleanStoredValue(name, ((DivTypedValue.Bool) value).getValue().value.evaluate(resolver).booleanValue());
        }
        if (value instanceof DivTypedValue.Number) {
            return new StoredValue.DoubleStoredValue(name, ((DivTypedValue.Number) value).getValue().value.evaluate(resolver).doubleValue());
        }
        if (value instanceof DivTypedValue.Color) {
            return new StoredValue.ColorStoredValue(name, Color.m6218constructorimpl(((DivTypedValue.Color) value).getValue().value.evaluate(resolver).intValue()), null);
        }
        if (value instanceof DivTypedValue.Url) {
            Url.Companion companion = Url.INSTANCE;
            String string = ((DivTypedValue.Url) value).getValue().value.evaluate(resolver).toString();
            Intrinsics.checkNotNullExpressionValue(string, "value.value.value.evaluate(resolver).toString()");
            return new StoredValue.UrlStoredValue(name, companion.m6236fromVcSV9u8(string), null);
        }
        if (value instanceof DivTypedValue.Array) {
            return new StoredValue.ArrayStoredValue(name, ((DivTypedValue.Array) value).getValue().value.evaluate(resolver));
        }
        if (value instanceof DivTypedValue.Dict) {
            return new StoredValue.DictStoredValue(name, ((DivTypedValue.Dict) value).getValue().value);
        }
        throw new NoWhenBranchMatchedException();
    }
}
