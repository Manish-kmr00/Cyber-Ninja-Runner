package com.yandex.div.core.view2.divs;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.yandex.div.R;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivCustomWrapper;
import com.yandex.div.core.view2.divs.widgets.DivViewVisitorKt;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivCustom;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivCustomBinder.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJV\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u001aH\u0002J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivCustomBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivCustom;", "Lcom/yandex/div/core/view2/divs/widgets/DivCustomWrapper;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "divCustomContainerViewAdapter", "Lcom/yandex/div/core/DivCustomContainerViewAdapter;", "extensionController", "Lcom/yandex/div/core/extension/DivExtensionController;", "divBinder", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivBinder;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/DivCustomContainerViewAdapter;Lcom/yandex/div/core/extension/DivExtensionController;Ljavax/inject/Provider;)V", "bind", "", "previousWrapper", "oldCustomView", "Landroid/view/View;", "oldDiv", "div", "context", "Lcom/yandex/div/core/view2/BindingContext;", "createView", "Lkotlin/Function0;", "bindView", "Lkotlin/Function1;", "view", "path", "Lcom/yandex/div/core/state/DivStatePath;", "replaceInParent", "parent", "Landroid/view/ViewGroup;", "newCustomView", "divView", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCustomBinder implements DivViewBinder<DivCustom, DivCustomWrapper> {
    private final DivBaseBinder baseBinder;
    private final Provider<DivBinder> divBinder;
    private final DivCustomContainerViewAdapter divCustomContainerViewAdapter;
    private final DivExtensionController extensionController;

    @Inject
    public DivCustomBinder(DivBaseBinder baseBinder, DivCustomContainerViewAdapter divCustomContainerViewAdapter, DivExtensionController extensionController, Provider<DivBinder> divBinder) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(divCustomContainerViewAdapter, "divCustomContainerViewAdapter");
        Intrinsics.checkNotNullParameter(extensionController, "extensionController");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        this.baseBinder = baseBinder;
        this.divCustomContainerViewAdapter = divCustomContainerViewAdapter;
        this.extensionController = extensionController;
        this.divBinder = divBinder;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivCustomWrapper view, final DivCustom div, final DivStatePath path) {
        BindingContext bindingContext;
        ExpressionResolver expressionResolver;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        View customView = view.getCustomView();
        DivCustom div2 = view.getDiv();
        final Div2View divView = context.getDivView();
        final ExpressionResolver expressionResolver2 = context.getExpressionResolver();
        if (div2 == div) {
            Div divRootDiv$div_release = divView.rootDiv$div_release();
            DivBinder divBinder = this.divBinder.get();
            Intrinsics.checkNotNullExpressionValue(divBinder, "divBinder.get()");
            BaseDivViewExtensionsKt.bindStates(view, divRootDiv$div_release, context, expressionResolver2, divBinder);
            return;
        }
        if (customView != null && div2 != null && (bindingContext = view.getBindingContext()) != null && (expressionResolver = bindingContext.getExpressionResolver()) != null) {
            this.extensionController.unbindView(divView, expressionResolver, customView, div2);
        }
        DivCustomWrapper divCustomWrapper = view;
        this.baseBinder.bindView(context, divCustomWrapper, div, null);
        this.baseBinder.bindId$div_release(divView, divCustomWrapper, null);
        if (this.divCustomContainerViewAdapter.isCustomTypeSupported(div.customType)) {
            bind(view, customView, div2, div, context, new Function0<View>() { // from class: com.yandex.div.core.view2.divs.DivCustomBinder.bindView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final View invoke() {
                    return DivCustomBinder.this.divCustomContainerViewAdapter.createView(div, divView, expressionResolver2, path);
                }
            }, new Function1<View, Unit>() { // from class: com.yandex.div.core.view2.divs.DivCustomBinder.bindView.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DivCustomBinder.this.divCustomContainerViewAdapter.bindView(it, div, divView, expressionResolver2, path);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    private final void bind(DivCustomWrapper previousWrapper, View oldCustomView, DivCustom oldDiv, DivCustom div, BindingContext context, Function0<? extends View> createView, Function1<? super View, Unit> bindView) {
        View viewInvoke;
        List<Div> nonNullItems;
        if (oldCustomView != null) {
            DivCustom div2 = previousWrapper.getDiv();
            if (!Intrinsics.areEqual(div2 != null ? div2.customType : null, div.customType) || oldDiv == null || (nonNullItems = DivCollectionExtensionsKt.getNonNullItems(oldDiv)) == null || nonNullItems.size() != DivCollectionExtensionsKt.getNonNullItems(div).size()) {
                viewInvoke = createView.invoke();
                viewInvoke.setTag(R.id.div_custom_tag, div);
            } else {
                viewInvoke = oldCustomView;
            }
        } else {
            viewInvoke = createView.invoke();
            viewInvoke.setTag(R.id.div_custom_tag, div);
        }
        Div2View divView = context.getDivView();
        if (!Intrinsics.areEqual(oldCustomView, viewInvoke)) {
            replaceInParent(previousWrapper, viewInvoke, divView);
        }
        bindView.invoke(viewInvoke);
        this.baseBinder.bindId$div_release(divView, viewInvoke, div.getId());
        this.extensionController.bindView(divView, context.getExpressionResolver(), viewInvoke, div);
    }

    private final void replaceInParent(ViewGroup parent, View newCustomView, Div2View divView) {
        if (parent.getChildCount() != 0) {
            DivViewVisitorKt.visitViewTree(divView.getReleaseViewVisitor$div_release(), ViewGroupKt.get(parent, 0));
            parent.removeViewAt(0);
        }
        parent.addView(newCustomView);
    }
}
