package com.yandex.div.core.view2.divs.pager;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import com.json.b9;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.DivCollectionViewHolder;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.Div;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivPager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPagerViewHolder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\u001c\u0010\u001b\u001a\u00020\u0014*\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerViewHolder;", "Lcom/yandex/div/core/view2/divs/DivCollectionViewHolder;", "parentContext", "Lcom/yandex/div/core/view2/BindingContext;", "pageLayout", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPageLayout;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "accessibilityEnabled", "", "isHorizontal", "Lkotlin/Function0;", "crossAxisAlignment", "Lcom/yandex/div2/DivPager$ItemAlignment;", "(Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/view2/divs/pager/DivPagerPageLayout;Lcom/yandex/div/core/view2/DivBinder;Lcom/yandex/div/core/view2/DivViewCreator;Lcom/yandex/div/core/state/DivStatePath;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bind", "", "bindingContext", "div", "Lcom/yandex/div2/Div;", b9.h.L, "", "logReuseError", "setCrossAxisAlignment", "Lcom/yandex/div/internal/widget/DivLayoutParams;", "Lcom/yandex/div2/DivBase;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerViewHolder extends DivCollectionViewHolder {
    public static final String TAG = "DivPagerViewHolder";
    private final boolean accessibilityEnabled;
    private final Function0<DivPager.ItemAlignment> crossAxisAlignment;
    private final Function0<Boolean> isHorizontal;
    private final DivPagerPageLayout pageLayout;
    private final BindingContext parentContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.yandex.div.core.view2.divs.pager.DivPagerViewHolder$special$$inlined$doOnEveryDetach$1] */
    public DivPagerViewHolder(BindingContext parentContext, DivPagerPageLayout pageLayout, DivBinder divBinder, DivViewCreator viewCreator, DivStatePath path, boolean z, Function0<Boolean> isHorizontal, Function0<? extends DivPager.ItemAlignment> crossAxisAlignment) {
        super(pageLayout, parentContext, divBinder, viewCreator, path);
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(pageLayout, "pageLayout");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(isHorizontal, "isHorizontal");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        this.parentContext = parentContext;
        this.pageLayout = pageLayout;
        this.accessibilityEnabled = z;
        this.isHorizontal = isHorizontal;
        this.crossAxisAlignment = crossAxisAlignment;
        final View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        final ?? r9 = new View.OnAttachStateChangeListener() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerViewHolder$special$$inlined$doOnEveryDetach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                Div oldDiv = this.this$0.getOldDiv();
                if (oldDiv == null) {
                    return;
                }
                this.this$0.parentContext.getDivView().getDiv2Component().getVisibilityActionTracker().startTrackingViewsHierarchy(this.this$0.parentContext, view, oldDiv);
            }
        };
        itemView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) r9);
        new Disposable() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerViewHolder$special$$inlined$doOnEveryDetach$2
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                itemView.removeOnAttachStateChangeListener(r9);
            }
        };
    }

    @Override // com.yandex.div.core.view2.divs.DivCollectionViewHolder
    public void bind(BindingContext bindingContext, Div div, int position) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(div, "div");
        super.bind(bindingContext, div, position);
        View child = this.pageLayout.getChild();
        ViewGroup.LayoutParams layoutParams = child != null ? child.getLayoutParams() : null;
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams != null) {
            setCrossAxisAlignment(divLayoutParams, div.value(), bindingContext.getExpressionResolver());
        }
        if (this.accessibilityEnabled) {
            this.pageLayout.setTag(R.id.div_pager_item_clip_id, Integer.valueOf(position));
        }
    }

    private final void setCrossAxisAlignment(DivLayoutParams divLayoutParams, DivBase divBase, ExpressionResolver expressionResolver) {
        Enum enumInvoke;
        Expression alignmentVertical = this.isHorizontal.invoke().booleanValue() ? divBase.getAlignmentVertical() : divBase.getAlignmentHorizontal();
        if (alignmentVertical == null || (enumInvoke = (Enum) alignmentVertical.evaluate(expressionResolver)) == null) {
            enumInvoke = this.crossAxisAlignment.invoke();
        }
        int i = 17;
        if (this.isHorizontal.invoke().booleanValue()) {
            if (enumInvoke != DivPager.ItemAlignment.CENTER && enumInvoke != DivAlignmentVertical.CENTER) {
                i = (enumInvoke == DivPager.ItemAlignment.END || enumInvoke == DivAlignmentVertical.BOTTOM) ? 80 : 48;
            }
        } else if (enumInvoke != DivPager.ItemAlignment.CENTER && enumInvoke != DivAlignmentHorizontal.CENTER) {
            if (enumInvoke == DivPager.ItemAlignment.END || enumInvoke == DivAlignmentHorizontal.END) {
                i = GravityCompat.END;
            } else if (enumInvoke == DivAlignmentHorizontal.LEFT) {
                i = 3;
            } else {
                i = enumInvoke == DivAlignmentHorizontal.RIGHT ? 5 : GravityCompat.START;
            }
        }
        divLayoutParams.setGravity(i);
        this.pageLayout.requestLayout();
    }

    @Override // com.yandex.div.core.view2.divs.DivCollectionViewHolder
    protected void logReuseError() {
        KLog kLog = KLog.INSTANCE;
        if (kLog.isAtLeast(Severity.DEBUG)) {
            kLog.print(3, TAG, "Pager holder reuse failed");
        }
    }
}
