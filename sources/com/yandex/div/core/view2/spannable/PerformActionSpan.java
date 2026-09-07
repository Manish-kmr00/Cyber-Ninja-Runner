package com.yandex.div.core.view2.spannable;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div2.DivAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerformActionSpan.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/spannable/PerformActionSpan;", "Landroid/text/style/ClickableSpan;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "actions", "", "Lcom/yandex/div2/DivAction;", "(Lcom/yandex/div/core/view2/BindingContext;Ljava/util/List;)V", "actionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "getActionBinder", "()Lcom/yandex/div/core/view2/divs/DivActionBinder;", "getActions", "()Ljava/util/List;", "onClick", "", "view", "Landroid/view/View;", "updateDrawState", "paint", "Landroid/text/TextPaint;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PerformActionSpan extends ClickableSpan {
    private final List<DivAction> actions;
    private final BindingContext bindingContext;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    public final List<DivAction> getActions() {
        return this.actions;
    }

    public PerformActionSpan(BindingContext bindingContext, List<DivAction> actions) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.bindingContext = bindingContext;
        this.actions = actions;
    }

    private final DivActionBinder getActionBinder() {
        DivActionBinder actionBinder = this.bindingContext.getDivView().getDiv2Component().getActionBinder();
        Intrinsics.checkNotNullExpressionValue(actionBinder, "bindingContext.divView.div2Component.actionBinder");
        return actionBinder;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getActionBinder().handleTapClick$div_release(this.bindingContext, view, this.actions);
    }
}
