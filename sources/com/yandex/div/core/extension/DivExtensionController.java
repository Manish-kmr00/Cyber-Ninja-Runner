package com.yandex.div.core.extension;

import android.view.View;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivExtension;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivExtensionController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0012J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/extension/DivExtensionController;", "", "extensionHandlers", "", "Lcom/yandex/div/core/extension/DivExtensionHandler;", "(Ljava/util/List;)V", "beforeBindView", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "view", "Landroid/view/View;", "div", "Lcom/yandex/div2/DivBase;", "bindView", "hasExtensions", "", "preprocessExtensions", "unbindView", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivExtensionController {
    private final List<DivExtensionHandler> extensionHandlers;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public DivExtensionController(List<? extends DivExtensionHandler> extensionHandlers) {
        Intrinsics.checkNotNullParameter(extensionHandlers, "extensionHandlers");
        this.extensionHandlers = extensionHandlers;
    }

    public void preprocessExtensions(DivBase div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (hasExtensions(div)) {
            for (DivExtensionHandler divExtensionHandler : this.extensionHandlers) {
                if (divExtensionHandler.matches(div)) {
                    divExtensionHandler.preprocess(div, resolver);
                }
            }
        }
    }

    public void beforeBindView(Div2View divView, ExpressionResolver resolver, View view, DivBase div) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        if (hasExtensions(div)) {
            for (DivExtensionHandler divExtensionHandler : this.extensionHandlers) {
                if (divExtensionHandler.matches(div)) {
                    divExtensionHandler.beforeBindView(divView, resolver, view, div);
                }
            }
        }
    }

    public void bindView(Div2View divView, ExpressionResolver resolver, View view, DivBase div) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        if (hasExtensions(div)) {
            for (DivExtensionHandler divExtensionHandler : this.extensionHandlers) {
                if (divExtensionHandler.matches(div)) {
                    divExtensionHandler.bindView(divView, resolver, view, div);
                }
            }
        }
    }

    public void unbindView(Div2View divView, ExpressionResolver resolver, View view, DivBase div) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        if (hasExtensions(div)) {
            for (DivExtensionHandler divExtensionHandler : this.extensionHandlers) {
                if (divExtensionHandler.matches(div)) {
                    divExtensionHandler.unbindView(divView, resolver, view, div);
                }
            }
        }
    }

    private boolean hasExtensions(DivBase div) {
        List<DivExtension> extensions = div.getExtensions();
        return (extensions == null || extensions.isEmpty() || this.extensionHandlers.isEmpty()) ? false : true;
    }
}
