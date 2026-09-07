package com.yandex.div.core.dagger;

import com.yandex.div.core.expression.local.DivRuntimeVisitor;
import com.yandex.div.core.tooltip.DivTooltipController;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivTransitionBuilder;
import com.yandex.div.core.view2.DivViewIdProvider;
import com.yandex.div.core.view2.ViewBindingProvider;
import com.yandex.div.core.view2.animations.DivAnimatorController;
import com.yandex.div.core.view2.divs.widgets.MediaReleaseViewVisitor;
import com.yandex.div.core.view2.divs.widgets.ReleaseViewVisitor;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.core.view2.errors.ErrorVisualMonitor;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.core.view2.state.DivStateSwitcher;
import com.yandex.div.core.view2.state.DivStateTransitionHolder;
import com.yandex.yatagan.BindsInstance;
import com.yandex.yatagan.Component;
import kotlin.Metadata;

/* JADX INFO: compiled from: Div2ViewComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
@DivViewScope
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u00016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00067À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/dagger/Div2ViewComponent;", "", "animatorController", "Lcom/yandex/div/core/view2/animations/DivAnimatorController;", "getAnimatorController", "()Lcom/yandex/div/core/view2/animations/DivAnimatorController;", "bindingProvider", "Lcom/yandex/div/core/view2/ViewBindingProvider;", "getBindingProvider", "()Lcom/yandex/div/core/view2/ViewBindingProvider;", "divTooltipController", "Lcom/yandex/div/core/tooltip/DivTooltipController;", "getDivTooltipController", "()Lcom/yandex/div/core/tooltip/DivTooltipController;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "getErrorCollectors", "()Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "errorMonitor", "Lcom/yandex/div/core/view2/errors/ErrorVisualMonitor;", "getErrorMonitor", "()Lcom/yandex/div/core/view2/errors/ErrorVisualMonitor;", "inputFocusTracker", "Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "getInputFocusTracker", "()Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "mediaReleaseViewVisitor", "Lcom/yandex/div/core/view2/divs/widgets/MediaReleaseViewVisitor;", "getMediaReleaseViewVisitor", "()Lcom/yandex/div/core/view2/divs/widgets/MediaReleaseViewVisitor;", "releaseViewVisitor", "Lcom/yandex/div/core/view2/divs/widgets/ReleaseViewVisitor;", "getReleaseViewVisitor", "()Lcom/yandex/div/core/view2/divs/widgets/ReleaseViewVisitor;", "runtimeVisitor", "Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;", "getRuntimeVisitor", "()Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;", "stateSwitcher", "Lcom/yandex/div/core/view2/state/DivStateSwitcher;", "getStateSwitcher", "()Lcom/yandex/div/core/view2/state/DivStateSwitcher;", "stateTransitionHolder", "Lcom/yandex/div/core/view2/state/DivStateTransitionHolder;", "getStateTransitionHolder", "()Lcom/yandex/div/core/view2/state/DivStateTransitionHolder;", "transitionBuilder", "Lcom/yandex/div/core/view2/DivTransitionBuilder;", "getTransitionBuilder", "()Lcom/yandex/div/core/view2/DivTransitionBuilder;", "viewIdProvider", "Lcom/yandex/div/core/view2/DivViewIdProvider;", "getViewIdProvider", "()Lcom/yandex/div/core/view2/DivViewIdProvider;", "Builder", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Component(isRoot = false, modules = {Div2ViewModule.class})
public interface Div2ViewComponent {

    /* JADX INFO: compiled from: Div2ViewComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/dagger/Div2ViewComponent$Builder;", "", "build", "Lcom/yandex/div/core/dagger/Div2ViewComponent;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Component.Builder
    public interface Builder {
        Div2ViewComponent build();

        @BindsInstance
        Builder divView(Div2View divView);
    }

    DivAnimatorController getAnimatorController();

    ViewBindingProvider getBindingProvider();

    DivTooltipController getDivTooltipController();

    ErrorCollectors getErrorCollectors();

    ErrorVisualMonitor getErrorMonitor();

    InputFocusTracker getInputFocusTracker();

    MediaReleaseViewVisitor getMediaReleaseViewVisitor();

    ReleaseViewVisitor getReleaseViewVisitor();

    DivRuntimeVisitor getRuntimeVisitor();

    DivStateSwitcher getStateSwitcher();

    DivStateTransitionHolder getStateTransitionHolder();

    DivTransitionBuilder getTransitionBuilder();

    DivViewIdProvider getViewIdProvider();
}
