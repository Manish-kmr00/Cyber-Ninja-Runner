package com.yandex.div.core.view2.divs;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.json.b9;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.animations.DivComparator;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.core.view2.divs.widgets.ReleaseUtils;
import com.yandex.div.core.view2.reuse.util.RebindUtilsKt;
import com.yandex.div.core.widget.DivViewWrapper;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivCollectionViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0017H$R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivCollectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewWrapper", "Lcom/yandex/div/core/widget/DivViewWrapper;", "parentContext", "Lcom/yandex/div/core/view2/BindingContext;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "(Lcom/yandex/div/core/widget/DivViewWrapper;Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/view2/DivBinder;Lcom/yandex/div/core/view2/DivViewCreator;Lcom/yandex/div/core/state/DivStatePath;)V", "childrenPaths", "", "", "oldDiv", "Lcom/yandex/div2/Div;", "getOldDiv", "()Lcom/yandex/div2/Div;", "setOldDiv", "(Lcom/yandex/div2/Div;)V", "bind", "", "bindingContext", "div", b9.h.L, "", "createChildView", "Landroid/view/View;", "logReuseError", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivCollectionViewHolder extends RecyclerView.ViewHolder {
    private final Map<String, DivStatePath> childrenPaths;
    private final DivBinder divBinder;
    private Div oldDiv;
    private final BindingContext parentContext;
    private final DivStatePath path;
    private final DivViewCreator viewCreator;
    private final DivViewWrapper viewWrapper;

    protected abstract void logReuseError();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivCollectionViewHolder(DivViewWrapper viewWrapper, BindingContext parentContext, DivBinder divBinder, DivViewCreator viewCreator, DivStatePath path) {
        super(viewWrapper);
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(path, "path");
        this.viewWrapper = viewWrapper;
        this.parentContext = parentContext;
        this.divBinder = divBinder;
        this.viewCreator = viewCreator;
        this.path = path;
        this.childrenPaths = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Div getOldDiv() {
        return this.oldDiv;
    }

    protected final void setOldDiv(Div div) {
        this.oldDiv = div;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    public void bind(BindingContext bindingContext, Div div, int position) {
        View viewCreateChildView;
        BindingContext bindingContext2;
        ExpressionResolver expressionResolver;
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(div, "div");
        ExpressionResolver expressionResolver2 = bindingContext.getExpressionResolver();
        if (RebindUtilsKt.tryRebindRecycleContainerChildren(this.viewWrapper, bindingContext.getDivView(), div)) {
            this.oldDiv = div;
            return;
        }
        View child = this.viewWrapper.getChild();
        if (child != null) {
            viewCreateChildView = null;
            View view = this.oldDiv != null ? child : null;
            if (view != null) {
                DivHolderView divHolderView = view instanceof DivHolderView ? (DivHolderView) view : null;
                if (divHolderView != null && (bindingContext2 = divHolderView.getBindingContext()) != null && (expressionResolver = bindingContext2.getExpressionResolver()) != null && DivComparator.areDivsReplaceable$default(DivComparator.INSTANCE, this.oldDiv, div, expressionResolver, expressionResolver2, null, 16, null)) {
                    viewCreateChildView = view;
                }
                if (viewCreateChildView == null) {
                    viewCreateChildView = createChildView(bindingContext, div);
                }
            } else {
                viewCreateChildView = createChildView(bindingContext, div);
            }
        } else {
            viewCreateChildView = createChildView(bindingContext, div);
        }
        this.oldDiv = div;
        String childPathUnit = BaseDivViewExtensionsKt.getChildPathUnit(div.value(), position);
        Map<String, DivStatePath> map = this.childrenPaths;
        DivStatePath divStatePathResolvePath = map.get(childPathUnit);
        if (divStatePathResolvePath == null) {
            divStatePathResolvePath = BaseDivViewExtensionsKt.resolvePath(div.value(), childPathUnit, this.path);
            map.put(childPathUnit, divStatePathResolvePath);
        }
        DivStatePath divStatePath = divStatePathResolvePath;
        if (!Intrinsics.areEqual(this.parentContext.getExpressionResolver(), bindingContext.getExpressionResolver())) {
            BaseDivViewExtensionsKt.resolveRuntime(bindingContext.getRuntimeStore(), div.value(), divStatePath.getFullPath$div_release(), expressionResolver2, this.parentContext.getExpressionResolver());
        }
        this.divBinder.bind(bindingContext, viewCreateChildView, div, divStatePath);
        RuntimeStore runtimeStore = bindingContext.getRuntimeStore();
        if (runtimeStore != null) {
            runtimeStore.showWarningIfNeeded$div_release(div.value());
        }
    }

    private final View createChildView(BindingContext bindingContext, Div div) {
        if (this.oldDiv != null) {
            logReuseError();
        }
        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(this.viewWrapper, bindingContext.getDivView());
        View viewCreate = this.viewCreator.create(div, bindingContext.getExpressionResolver());
        this.viewWrapper.addView(viewCreate);
        return viewCreate;
    }
}
