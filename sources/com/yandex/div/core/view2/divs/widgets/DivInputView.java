package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.content.ContextCompat;
import com.android.billingclient.api.BillingClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.internal.widget.SuperLineHeightEditText;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivInput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DivInputView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010B\u001a\u00020;2\u0014\u0010C\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;09H\u0016J\u0013\u0010D\u001a\u00020;2\b\u0010E\u001a\u0004\u0018\u00010=H\u0096\u0001J\t\u0010F\u001a\u00020;H\u0096\u0001J\u0010\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020IH\u0014J\u0010\u0010J\u001a\u00020;2\u0006\u0010H\u001a\u00020IH\u0016J\u000b\u0010K\u001a\u0004\u0018\u00010LH\u0096\u0001J\t\u0010M\u001a\u00020;H\u0096\u0001J\u0019\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0096\u0001J\"\u0010Q\u001a\u00020;2\u0006\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\n2\b\u0010T\u001a\u0004\u0018\u00010UH\u0014J(\u0010V\u001a\u00020;2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0014J\t\u0010[\u001a\u00020;H\u0096\u0001J\t\u0010\\\u001a\u00020;H\u0096\u0001J\b\u0010]\u001a\u00020;H\u0016J#\u0010^\u001a\u00020;2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020bH\u0096\u0001J\u0012\u0010c\u001a\u00020;2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020;2\u0006\u0010g\u001a\u00020\u000fH\u0016J\u0012\u0010h\u001a\u00020;2\b\u0010i\u001a\u0004\u0018\u00010\rH\u0016J\u0011\u0010j\u001a\u00020;2\u0006\u0010a\u001a\u00020bH\u0096\u0001J\u0011\u0010k\u001a\u00020;2\u0006\u0010a\u001a\u00020bH\u0096\u0001R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020\u000fX\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u0012\u0010,\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u0016\u0010-\u001a\u0004\u0018\u00010.X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\n8SX\u0092\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u00020\u000fX\u0096\u000f¢\u0006\f\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\"\u00107\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;0908X\u0092\u0004¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020=08X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0092\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivInputView;", "Lcom/yandex/div/internal/widget/SuperLineHeightEditText;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivInput;", "Lcom/yandex/div/core/view2/divs/widgets/DivAnimator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_hint", "", "_isFocusable", "", "value", "accessibilityEnabled", "getAccessibilityEnabled$div_release", "()Z", "setAccessibilityEnabled$div_release", "(Z)V", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "div", "getDiv", "()Lcom/yandex/div2/DivInput;", "setDiv", "(Lcom/yandex/div2/DivInput;)V", "enabled", "getEnabled", "setEnabled$div_release", "focusTracker", "Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "getFocusTracker$div_release", "()Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "setFocusTracker$div_release", "(Lcom/yandex/div/core/view2/reuse/InputFocusTracker;)V", "isDrawing", "setDrawing", "isTransient", "nativeBackground", "Landroid/graphics/drawable/Drawable;", "getNativeBackground$div_release", "()Landroid/graphics/drawable/Drawable;", "nativeBackgroundResId", "getNativeBackgroundResId", "()I", "needClipping", "getNeedClipping", "setNeedClipping", "onTextChangedActions", "", "Lkotlin/Function1;", "Landroid/text/Editable;", "", BillingClient.FeatureType.SUBSCRIPTIONS, "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "textChangeWatcher", "Landroid/text/TextWatcher;", "addAfterTextChangeAction", "action", "addSubscription", "subscription", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "onBoundsChanged", "width", "height", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "releaseBorderDrawer", "removeAfterTextChangeListener", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "setContentDescription", "contentDescription", "", "setFocusable", "focusable", "setInputHint", ViewHierarchyConstants.HINT_KEY, "transitionFinished", "transitionStarted", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivInputView extends SuperLineHeightEditText implements DivHolderView<DivInput>, DivAnimator {
    private final /* synthetic */ DivHolderViewMixin<DivInput> $$delegate_0;
    private String _hint;
    private boolean _isFocusable;
    private boolean accessibilityEnabled;
    private boolean enabled;
    private InputFocusTracker focusTracker;
    private final Drawable nativeBackground;
    private final List<Function1<Editable, Unit>> onTextChangedActions;
    private TextWatcher textChangeWatcher;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivInputView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public void addSubscription(Disposable subscription) {
        this.$$delegate_0.addSubscription(subscription);
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public void closeAllSubscription() {
        this.$$delegate_0.closeAllSubscription();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public BindingContext getBindingContext() {
        return this.$$delegate_0.getBindingContext();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public DivInput getDiv() {
        return (DivInput) this.$$delegate_0.getDiv();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public DivBorderDrawer getDivBorderDrawer() {
        return this.$$delegate_0.getDivBorderDrawer();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean getNeedClipping() {
        return this.$$delegate_0.getNeedClipping();
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public List<Disposable> getSubscriptions() {
        return this.$$delegate_0.getSubscriptions();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void invalidateBorder() {
        this.$$delegate_0.invalidateBorder();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean isDrawing() {
        return this.$$delegate_0.isDrawing();
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void onBoundsChanged(int width, int height) {
        this.$$delegate_0.onBoundsChanged(width, height);
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber, com.yandex.div.core.view2.Releasable
    public void release() {
        this.$$delegate_0.release();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void releaseBorderDrawer() {
        this.$$delegate_0.releaseBorderDrawer();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public void setBindingContext(BindingContext bindingContext) {
        this.$$delegate_0.setBindingContext(bindingContext);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setBorder(BindingContext bindingContext, DivBorder border, View view) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.setBorder(bindingContext, border, view);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public void setDiv(DivInput divInput) {
        this.$$delegate_0.setDiv(divInput);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setDrawing(boolean z) {
        this.$$delegate_0.setDrawing(z);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setNeedClipping(boolean z) {
        this.$$delegate_0.setNeedClipping(z);
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public void transitionFinished(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.transitionFinished(view);
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public void transitionStarted(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.transitionStarted(view);
    }

    public /* synthetic */ DivInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.divInputStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
        this.nativeBackground = ContextCompat.getDrawable(context, getNativeBackgroundResId());
        this.onTextChangedActions = new ArrayList();
        this._isFocusable = true;
        this.enabled = true;
    }

    private int getNativeBackgroundResId() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.editTextBackground, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: renamed from: getNativeBackground$div_release, reason: from getter */
    public Drawable getNativeBackground() {
        return this.nativeBackground;
    }

    /* JADX INFO: renamed from: getFocusTracker$div_release, reason: from getter */
    public InputFocusTracker getFocusTracker() {
        return this.focusTracker;
    }

    public void setFocusTracker$div_release(InputFocusTracker inputFocusTracker) {
        this.focusTracker = inputFocusTracker;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled$div_release(boolean z) {
        this.enabled = z;
        setFocusable(this._isFocusable);
    }

    /* JADX INFO: renamed from: getAccessibilityEnabled$div_release, reason: from getter */
    public boolean getAccessibilityEnabled() {
        return this.accessibilityEnabled;
    }

    public void setAccessibilityEnabled$div_release(boolean z) {
        this.accessibilityEnabled = z;
        setInputHint(this._hint);
    }

    public void setInputHint(String hint) {
        CharSequence contentDescription;
        String contentDescription2;
        this._hint = hint;
        if (getAccessibilityEnabled()) {
            String str = hint;
            if ((str == null || str.length() == 0) && ((contentDescription = getContentDescription()) == null || contentDescription.length() == 0)) {
                contentDescription2 = null;
            } else if (str == null || str.length() == 0) {
                contentDescription2 = getContentDescription();
            } else {
                CharSequence contentDescription3 = getContentDescription();
                contentDescription2 = (contentDescription3 == null || contentDescription3.length() == 0) ? str : StringsKt.trimEnd(hint, '.') + ". " + ((Object) getContentDescription());
            }
        } else {
            contentDescription2 = hint;
        }
        setHint(contentDescription2);
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence contentDescription) {
        super.setContentDescription(contentDescription);
        setInputHint(this._hint);
    }

    @Override // com.yandex.div.internal.widget.SuperLineHeightEditText, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onBoundsChanged(w, h);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        InputFocusTracker focusTracker = getFocusTracker();
        if (focusTracker != null) {
            focusTracker.inputFocusChanged(getTag(), this, focused);
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivInputView divInputView = this;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        divInputView.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divInputView.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            if (divBorderDrawer == null) {
                super.draw(canvas);
            } else {
                float f = scrollX;
                float f2 = scrollY;
                int iSave = canvas.save();
                try {
                    canvas.translate(f, f2);
                    divBorderDrawer.clipCorners(canvas);
                    canvas.translate(-f, -f2);
                    super.draw(canvas);
                    canvas.translate(f, f2);
                    divBorderDrawer.drawBorder(canvas);
                    canvas.restoreToCount(iSave);
                } catch (Throwable th) {
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.draw(canvas);
        }
        divInputView.setDrawing(false);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivInputView divInputView = this;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (!divInputView.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divInputView.getDivBorderDrawer();
            if (divBorderDrawer != null) {
                if (divBorderDrawer == null) {
                    super.dispatchDraw(canvas);
                } else {
                    float f = scrollX;
                    float f2 = scrollY;
                    int iSave = canvas.save();
                    try {
                        canvas.translate(f, f2);
                        divBorderDrawer.clipCorners(canvas);
                        canvas.translate(-f, -f2);
                        super.dispatchDraw(canvas);
                        canvas.translate(f, f2);
                        divBorderDrawer.drawBorder(canvas);
                        canvas.restoreToCount(iSave);
                    } catch (Throwable th) {
                        canvas.restoreToCount(iSave);
                        throw th;
                    }
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void setFocusable(boolean focusable) {
        this._isFocusable = focusable;
        boolean z = focusable && getEnabled();
        super.setFocusable(z);
        setFocusableInTouchMode(z);
    }

    public void addAfterTextChangeAction(Function1<? super Editable, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.textChangeWatcher == null) {
            TextWatcher textWatcher = new TextWatcher() { // from class: com.yandex.div.core.view2.divs.widgets.DivInputView$addAfterTextChangeAction$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence text, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Iterator it = this.this$0.onTextChangedActions.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(s);
                    }
                }
            };
            addTextChangedListener(textWatcher);
            this.textChangeWatcher = textWatcher;
        }
        this.onTextChangedActions.add(action);
    }

    public void removeAfterTextChangeListener() {
        removeTextChangedListener(this.textChangeWatcher);
        this.onTextChangedActions.clear();
        this.textChangeWatcher = null;
    }
}
