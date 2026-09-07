package com.yandex.div.core.view2.errors;

import android.view.ViewGroup;
import com.yandex.div.core.dagger.DivViewScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.view2.Binding;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.ViewBindingProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorVisualMonitor.kt */
/* JADX INFO: loaded from: classes13.dex */
@DivViewScope
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010\u001b\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/core/view2/errors/ErrorVisualMonitor;", "", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "visualErrorsEnabled", "", "showPermanently", "bindingProvider", "Lcom/yandex/div/core/view2/ViewBindingProvider;", "(Lcom/yandex/div/core/view2/errors/ErrorCollectors;Lcom/yandex/div/core/view2/Div2View;ZZLcom/yandex/div/core/view2/ViewBindingProvider;)V", "value", "enabled", "getEnabled$div_release", "()Z", "setEnabled$div_release", "(Z)V", "errorModel", "Lcom/yandex/div/core/view2/errors/ErrorModel;", "errorView", "Lcom/yandex/div/core/view2/errors/ErrorView;", "lastConnectionView", "Landroid/view/ViewGroup;", "connect", "", "root", "connectOrDisconnect", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorVisualMonitor {
    private final ViewBindingProvider bindingProvider;
    private boolean enabled;
    private final ErrorModel errorModel;
    private ErrorView errorView;
    private ViewGroup lastConnectionView;
    private final boolean showPermanently;
    private final boolean visualErrorsEnabled;

    @Inject
    public ErrorVisualMonitor(ErrorCollectors errorCollectors, Div2View divView, @ExperimentFlag(experiment = Experiment.VISUAL_ERRORS_ENABLED) boolean z, @ExperimentFlag(experiment = Experiment.PERMANENT_DEBUG_PANEL_ENABLED) boolean z2, ViewBindingProvider bindingProvider) {
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(bindingProvider, "bindingProvider");
        this.visualErrorsEnabled = z;
        this.showPermanently = z2;
        this.bindingProvider = bindingProvider;
        this.enabled = z || z2;
        this.errorModel = new ErrorModel(errorCollectors, divView, z);
        connectOrDisconnect();
    }

    /* JADX INFO: renamed from: getEnabled$div_release, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled$div_release(boolean z) {
        this.enabled = z;
        connectOrDisconnect();
    }

    private final void connectOrDisconnect() {
        if (this.enabled) {
            this.bindingProvider.observeAndGet(new Function1<Binding, Unit>() { // from class: com.yandex.div.core.view2.errors.ErrorVisualMonitor.connectOrDisconnect.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Binding binding) {
                    invoke2(binding);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Binding it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ErrorVisualMonitor.this.errorModel.bind(it);
                }
            });
            ViewGroup viewGroup = this.lastConnectionView;
            if (viewGroup != null) {
                connect(viewGroup);
                return;
            }
            return;
        }
        ErrorView errorView = this.errorView;
        if (errorView != null) {
            errorView.close();
        }
        this.errorView = null;
    }

    public final void connect(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.lastConnectionView = root;
        if (this.enabled) {
            ErrorView errorView = this.errorView;
            if (errorView != null) {
                errorView.close();
            }
            this.errorView = new ErrorView(root, this.errorModel, this.showPermanently);
        }
    }
}
