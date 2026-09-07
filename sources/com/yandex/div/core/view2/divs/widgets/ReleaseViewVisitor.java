package com.yandex.div.core.view2.divs.widgets;

import android.view.View;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.dagger.DivViewScope;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.Releasable;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivCustom;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReleaseViewVisitor.kt */
/* JADX INFO: loaded from: classes14.dex */
@DivViewScope
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0011¢\u0006\u0002\b\u000fJ$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0012J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0017H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/ReleaseViewVisitor;", "Lcom/yandex/div/core/view2/divs/widgets/DivViewVisitor;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "divCustomContainerViewAdapter", "Lcom/yandex/div/core/DivCustomContainerViewAdapter;", "divExtensionController", "Lcom/yandex/div/core/extension/DivExtensionController;", "(Lcom/yandex/div/core/view2/Div2View;Lcom/yandex/div/core/DivCustomContainerViewAdapter;Lcom/yandex/div/core/extension/DivExtensionController;)V", "defaultVisit", "", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "release", "Landroid/view/View;", "release$div_release", "releaseInternal", "div", "Lcom/yandex/div2/DivBase;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "visit", "Lcom/yandex/div/core/view2/divs/widgets/DivCustomWrapper;", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ReleaseViewVisitor extends DivViewVisitor {
    private final DivCustomContainerViewAdapter divCustomContainerViewAdapter;
    private final DivExtensionController divExtensionController;
    private final Div2View divView;

    @Inject
    public ReleaseViewVisitor(Div2View divView, DivCustomContainerViewAdapter divCustomContainerViewAdapter, DivExtensionController divExtensionController) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(divCustomContainerViewAdapter, "divCustomContainerViewAdapter");
        Intrinsics.checkNotNullParameter(divExtensionController, "divExtensionController");
        this.divView = divView;
        this.divCustomContainerViewAdapter = divCustomContainerViewAdapter;
        this.divExtensionController = divExtensionController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.div.core.view2.divs.widgets.DivViewVisitor
    public void defaultVisit(DivHolderView<?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View view2 = (View) view;
        DivBase div = view.getDiv();
        BindingContext bindingContext = view.getBindingContext();
        releaseInternal(view2, div, bindingContext != null ? bindingContext.getExpressionResolver() : null);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivViewVisitor
    public void visit(DivPagerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.visit(view);
        view.getViewPager().setAdapter(null);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivViewVisitor
    public void visit(DivRecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.visit(view);
        view.setAdapter(null);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivViewVisitor
    public void visit(DivCustomWrapper view) {
        BindingContext bindingContext;
        ExpressionResolver expressionResolver;
        Intrinsics.checkNotNullParameter(view, "view");
        DivCustom div = view.getDiv();
        if (div == null || (bindingContext = view.getBindingContext()) == null || (expressionResolver = bindingContext.getExpressionResolver()) == null) {
            return;
        }
        release$div_release(view);
        View customView = view.getCustomView();
        if (customView != null) {
            this.divExtensionController.unbindView(this.divView, expressionResolver, customView, div);
            this.divCustomContainerViewAdapter.release(customView, div);
        }
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivViewVisitor
    public void visit(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        release$div_release(view);
    }

    private void releaseInternal(View view, DivBase div, ExpressionResolver resolver) {
        if (div != null && resolver != null) {
            this.divExtensionController.unbindView(this.divView, resolver, view, div);
        }
        release$div_release(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release$div_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof Releasable) {
            ((Releasable) view).release();
        }
        Iterable<Releasable> releasableList = ReleasablesKt.getReleasableList(view);
        if (releasableList != null) {
            Iterator<Releasable> it = releasableList.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
    }
}
