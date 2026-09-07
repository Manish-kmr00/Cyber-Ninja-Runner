package com.yandex.div.core.view2.divs;

import android.view.KeyEvent;
import android.widget.TextView;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivInput;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DivInputBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class DivInputBinder$observeEnterTypeAndActions$callback$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ BindingContext $bindingContext;
    final /* synthetic */ DivInput $div;
    final /* synthetic */ ExpressionResolver $resolver;
    final /* synthetic */ DivInputView $this_observeEnterTypeAndActions;
    final /* synthetic */ DivInputBinder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DivInputBinder$observeEnterTypeAndActions$callback$1(DivInput divInput, ExpressionResolver expressionResolver, DivInputView divInputView, DivInputBinder divInputBinder, BindingContext bindingContext) {
        super(1);
        this.$div = divInput;
        this.$resolver = expressionResolver;
        this.$this_observeEnterTypeAndActions = divInputView;
        this.this$0 = divInputBinder;
        this.$bindingContext = bindingContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
        DivInput.EnterKeyType enterKeyTypeEvaluate = this.$div.enterKeyType.evaluate(this.$resolver);
        DivInputView divInputView = this.$this_observeEnterTypeAndActions;
        divInputView.setImeOptions(divInputView.getImeOptions() + this.this$0.getImeAction(enterKeyTypeEvaluate));
        final List<DivAction> list = this.$div.enterKeyActions;
        List<DivAction> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            final DivInputView divInputView2 = this.$this_observeEnterTypeAndActions;
            final DivInputBinder divInputBinder = this.this$0;
            final BindingContext bindingContext = this.$bindingContext;
            divInputView2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.yandex.div.core.view2.divs.DivInputBinder$observeEnterTypeAndActions$callback$1$$ExternalSyntheticLambda0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return DivInputBinder$observeEnterTypeAndActions$callback$1.invoke$lambda$0(divInputBinder, bindingContext, divInputView2, list, textView, i, keyEvent);
                }
            });
            return;
        }
        this.$this_observeEnterTypeAndActions.setOnEditorActionListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(DivInputBinder this$0, BindingContext bindingContext, DivInputView this_observeEnterTypeAndActions, List list, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bindingContext, "$bindingContext");
        Intrinsics.checkNotNullParameter(this_observeEnterTypeAndActions, "$this_observeEnterTypeAndActions");
        if ((i & 255) == 0) {
            return false;
        }
        this$0.actionBinder.handleBulkActions$div_release(bindingContext, this_observeEnterTypeAndActions, list, "enter");
        return false;
    }
}
