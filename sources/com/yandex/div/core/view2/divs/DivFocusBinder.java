package com.yandex.div.core.view2.divs;

import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.div.R;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.widgets.DivBorderSupports;
import com.yandex.div.internal.util.CollectionsKt;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivBorder;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivFocusBinder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J8\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\u001e\u0010\u0014\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivFocusBinder;", "", "actionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "(Lcom/yandex/div/core/view2/divs/DivActionBinder;)V", "bindDivBorder", "", "view", "Landroid/view/View;", "context", "Lcom/yandex/div/core/view2/BindingContext;", "focusedBorder", "Lcom/yandex/div2/DivBorder;", "defaultBorder", "bindDivFocusActions", TypedValues.AttributesType.S_TARGET, "onFocusActions", "", "Lcom/yandex/div2/DivAction;", "onBlurActions", "applyBorder", "bindingContext", OutlinedTextFieldKt.BorderId, "FocusChangeListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivFocusBinder {
    private final DivActionBinder actionBinder;

    @Inject
    public DivFocusBinder(DivActionBinder actionBinder) {
        Intrinsics.checkNotNullParameter(actionBinder, "actionBinder");
        this.actionBinder = actionBinder;
    }

    public void bindDivBorder(View view, BindingContext context, DivBorder focusedBorder, DivBorder defaultBorder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        applyBorder(view, context, (focusedBorder == null || BaseDivViewExtensionsKt.isConstantlyEmpty(focusedBorder) || !view.isFocused()) ? defaultBorder : focusedBorder);
        View.OnFocusChangeListener onFocusChangeListener = view.getOnFocusChangeListener();
        FocusChangeListener focusChangeListener = onFocusChangeListener instanceof FocusChangeListener ? (FocusChangeListener) onFocusChangeListener : null;
        if (focusChangeListener == null && BaseDivViewExtensionsKt.isConstantlyEmpty(focusedBorder)) {
            return;
        }
        if (focusChangeListener != null && focusChangeListener.getFocusActions() == null && focusChangeListener.getBlurActions() == null && BaseDivViewExtensionsKt.isConstantlyEmpty(focusedBorder)) {
            view.setOnFocusChangeListener(null);
            return;
        }
        FocusChangeListener focusChangeListener2 = new FocusChangeListener(this, context);
        focusChangeListener2.setBorders(focusedBorder, defaultBorder);
        if (focusChangeListener != null) {
            focusChangeListener2.setActions(focusChangeListener.getFocusActions(), focusChangeListener.getBlurActions());
        }
        view.setOnFocusChangeListener(focusChangeListener2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void applyBorder(View view, BindingContext bindingContext, DivBorder divBorder) {
        if (view instanceof DivBorderSupports) {
            ((DivBorderSupports) view).setBorder(bindingContext, divBorder, view);
            return;
        }
        float dimension = 0.0f;
        if (divBorder != null && !BaseDivViewExtensionsKt.isConstantlyEmpty(divBorder) && divBorder.hasShadow.evaluate(bindingContext.getExpressionResolver()).booleanValue() && divBorder.shadow == null) {
            dimension = view.getResources().getDimension(R.dimen.div_shadow_elevation);
        }
        view.setElevation(dimension);
    }

    public void bindDivFocusActions(View target, BindingContext context, List<DivAction> onFocusActions, List<DivAction> onBlurActions) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(context, "context");
        View.OnFocusChangeListener onFocusChangeListener = target.getOnFocusChangeListener();
        FocusChangeListener focusChangeListener = onFocusChangeListener instanceof FocusChangeListener ? (FocusChangeListener) onFocusChangeListener : null;
        if (focusChangeListener == null && CollectionsKt.allIsNullOrEmpty(onFocusActions, onBlurActions)) {
            return;
        }
        if (focusChangeListener != null && focusChangeListener.getFocusedBorder() == null && CollectionsKt.allIsNullOrEmpty(onFocusActions, onBlurActions)) {
            target.setOnFocusChangeListener(null);
            return;
        }
        FocusChangeListener focusChangeListener2 = new FocusChangeListener(this, context);
        if (focusChangeListener != null) {
            focusChangeListener2.setBorders(focusChangeListener.getFocusedBorder(), focusChangeListener.getBlurredBorder());
        }
        focusChangeListener2.setActions(onFocusActions, onBlurActions);
        target.setOnFocusChangeListener(focusChangeListener2);
    }

    /* JADX INFO: compiled from: DivFocusBinder.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u00020\u00142\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u001a\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000bJ\"\u0010\"\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002R.\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006&"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivFocusBinder$FocusChangeListener;", "Landroid/view/View$OnFocusChangeListener;", "context", "Lcom/yandex/div/core/view2/BindingContext;", "(Lcom/yandex/div/core/view2/divs/DivFocusBinder;Lcom/yandex/div/core/view2/BindingContext;)V", "<set-?>", "", "Lcom/yandex/div2/DivAction;", "blurActions", "getBlurActions", "()Ljava/util/List;", "Lcom/yandex/div2/DivBorder;", "blurredBorder", "getBlurredBorder", "()Lcom/yandex/div2/DivBorder;", "focusActions", "getFocusActions", "focusedBorder", "getFocusedBorder", "applyBorder", "", "view", "Landroid/view/View;", OutlinedTextFieldKt.BorderId, "onFocusChange", "v", "hasFocus", "", "setActions", "onFocus", "onBlur", "setBorders", "focused", "blurred", "handle", TypedValues.AttributesType.S_TARGET, "actionLogType", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class FocusChangeListener implements View.OnFocusChangeListener {
        private List<DivAction> blurActions;
        private DivBorder blurredBorder;
        private final BindingContext context;
        private List<DivAction> focusActions;
        private DivBorder focusedBorder;
        final /* synthetic */ DivFocusBinder this$0;

        public FocusChangeListener(DivFocusBinder divFocusBinder, BindingContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = divFocusBinder;
            this.context = context;
        }

        public final DivBorder getFocusedBorder() {
            return this.focusedBorder;
        }

        public final DivBorder getBlurredBorder() {
            return this.blurredBorder;
        }

        public final List<DivAction> getFocusActions() {
            return this.focusActions;
        }

        public final List<DivAction> getBlurActions() {
            return this.blurActions;
        }

        public final void setBorders(DivBorder focused, DivBorder blurred) {
            this.focusedBorder = focused;
            this.blurredBorder = blurred;
        }

        public final void setActions(List<DivAction> onFocus, List<DivAction> onBlur) {
            this.focusActions = onFocus;
            this.blurActions = onBlur;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (hasFocus) {
                applyBorder(v, this.focusedBorder);
                List<DivAction> list = this.focusActions;
                if (list != null) {
                    handle(list, v, "focus");
                    return;
                }
                return;
            }
            if (this.focusedBorder != null) {
                applyBorder(v, this.blurredBorder);
            }
            List<DivAction> list2 = this.blurActions;
            if (list2 != null) {
                handle(list2, v, "blur");
            }
        }

        private final void applyBorder(View view, DivBorder border) {
            this.this$0.applyBorder(view, this.context, border);
        }

        private final void handle(List<DivAction> list, View view, String str) {
            this.this$0.actionBinder.handleBulkActions$div_release(this.context, view, list, str);
        }
    }
}
