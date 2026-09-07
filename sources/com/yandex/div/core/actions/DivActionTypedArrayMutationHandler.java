package com.yandex.div.core.actions;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionArrayInsertValue;
import com.yandex.div2.DivActionArrayRemoveValue;
import com.yandex.div2.DivActionArraySetValue;
import com.yandex.div2.DivActionTyped;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: DivActionTypedArrayMutationHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedArrayMutationHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handle", "", "action", "Lcom/yandex/div2/DivActionArrayInsertValue;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "Lcom/yandex/div2/DivActionArrayRemoveValue;", "Lcom/yandex/div2/DivActionArraySetValue;", "handleAction", "", "scopeId", "", "Lcom/yandex/div2/DivActionTyped;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedArrayMutationHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedArrayMutationHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (action instanceof DivActionTyped.ArrayInsertValue) {
            handle(((DivActionTyped.ArrayInsertValue) action).getValue(), view, resolver);
            return true;
        }
        if (action instanceof DivActionTyped.ArrayRemoveValue) {
            handle(((DivActionTyped.ArrayRemoveValue) action).getValue(), view, resolver);
            return true;
        }
        if (!(action instanceof DivActionTyped.ArraySetValue)) {
            return false;
        }
        handle(((DivActionTyped.ArraySetValue) action).getValue(), view, resolver);
        return true;
    }

    private final void handle(DivActionArrayInsertValue action, final Div2View view, ExpressionResolver resolver) {
        final String strEvaluate = action.variableName.evaluate(resolver);
        Expression<Long> expression = action.index;
        final Integer numValueOf = expression != null ? Integer.valueOf((int) expression.evaluate(resolver).longValue()) : null;
        final Object objEvaluate = DivActionTypedUtilsKt.evaluate(action.value, resolver);
        DivActionTypedArrayMutationHandlerKt.updateVariable(view, strEvaluate, resolver, new Function1<JSONArray, JSONArray>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final JSONArray invoke(JSONArray array) {
                Intrinsics.checkNotNullParameter(array, "array");
                int length = array.length();
                Integer num = numValueOf;
                if (num == null || num.intValue() == length) {
                    final Object obj = objEvaluate;
                    return DivActionTypedArrayMutationHandlerKt.mutate(array, new Function1<List<Object>, Unit>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<Object> list) {
                            invoke2(list);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<Object> mutate) {
                            Intrinsics.checkNotNullParameter(mutate, "$this$mutate");
                            mutate.add(obj);
                        }
                    });
                }
                if (RangesKt.until(0, length).contains(num.intValue())) {
                    final Integer num2 = numValueOf;
                    final Object obj2 = objEvaluate;
                    return DivActionTypedArrayMutationHandlerKt.mutate(array, new Function1<List<Object>, Unit>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<Object> list) {
                            invoke2(list);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<Object> mutate) {
                            Intrinsics.checkNotNullParameter(mutate, "$this$mutate");
                            mutate.add(num2.intValue(), obj2);
                        }
                    });
                }
                DivActionTypedUtilsKt.logError(view, new IndexOutOfBoundsException("Index out of bound (" + numValueOf + ") for mutation " + strEvaluate + " (" + length + ')'));
                return array;
            }
        });
    }

    private final void handle(DivActionArrayRemoveValue action, final Div2View view, ExpressionResolver resolver) {
        final String strEvaluate = action.variableName.evaluate(resolver);
        final int iLongValue = (int) action.index.evaluate(resolver).longValue();
        DivActionTypedArrayMutationHandlerKt.updateVariable(view, strEvaluate, resolver, new Function1<JSONArray, JSONArray>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final JSONArray invoke(JSONArray array) {
                Intrinsics.checkNotNullParameter(array, "array");
                int length = array.length();
                int i = iLongValue;
                if (i >= 0 && i < length) {
                    final int i2 = iLongValue;
                    return DivActionTypedArrayMutationHandlerKt.mutate(array, new Function1<List<Object>, Unit>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<Object> list) {
                            invoke2(list);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<Object> mutate) {
                            Intrinsics.checkNotNullParameter(mutate, "$this$mutate");
                            mutate.remove(i2);
                        }
                    });
                }
                DivActionTypedUtilsKt.logError(view, new IndexOutOfBoundsException("Index out of bound (" + iLongValue + ") for mutation " + strEvaluate + " (" + length + ')'));
                return array;
            }
        });
    }

    private final void handle(DivActionArraySetValue action, final Div2View view, ExpressionResolver resolver) {
        final String strEvaluate = action.variableName.evaluate(resolver);
        final int iLongValue = (int) action.index.evaluate(resolver).longValue();
        final Object objEvaluate = DivActionTypedUtilsKt.evaluate(action.value, resolver);
        DivActionTypedArrayMutationHandlerKt.updateVariable(view, strEvaluate, resolver, new Function1<JSONArray, JSONArray>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final JSONArray invoke(JSONArray array) {
                Intrinsics.checkNotNullParameter(array, "array");
                int length = array.length();
                int i = iLongValue;
                if (i >= 0 && i < length) {
                    final int i2 = iLongValue;
                    final Object obj = objEvaluate;
                    return DivActionTypedArrayMutationHandlerKt.mutate(array, new Function1<List<Object>, Unit>() { // from class: com.yandex.div.core.actions.DivActionTypedArrayMutationHandler.handle.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<Object> list) {
                            invoke2(list);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<Object> mutate) {
                            Intrinsics.checkNotNullParameter(mutate, "$this$mutate");
                            mutate.set(i2, obj);
                        }
                    });
                }
                DivActionTypedUtilsKt.logError(view, new IndexOutOfBoundsException("Index out of bound (" + iLongValue + ") for mutation " + strEvaluate + " (" + length + ')'));
                return array;
            }
        });
    }
}
