package com.yandex.div.core.dagger;

import android.renderscript.RenderScript;
import android.view.ContextThemeWrapper;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div.core.DivCreationTracker;
import com.yandex.div.core.DivCustomContainerChildFactory;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.DivDataChangeListener;
import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.actions.DivActionTypedHandlerCombiner;
import com.yandex.div.core.downloader.DivDownloader;
import com.yandex.div.core.downloader.DivPatchManager;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.expression.ExpressionsRuntimeProvider;
import com.yandex.div.core.expression.storedvalues.StoredValuesController;
import com.yandex.div.core.expression.variables.DivVariableController;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.player.DivPlayerFactory;
import com.yandex.div.core.player.DivPlayerPreloader;
import com.yandex.div.core.player.DivVideoActionHandler;
import com.yandex.div.core.player.DivVideoViewMapper;
import com.yandex.div.core.state.DivStateChangeListener;
import com.yandex.div.core.state.DivStateManager;
import com.yandex.div.core.state.TabsStateCache;
import com.yandex.div.core.state.TemporaryDivStateCache;
import com.yandex.div.core.timer.DivTimerEventDispatcherProvider;
import com.yandex.div.core.tooltip.DivTooltipController;
import com.yandex.div.core.view2.Div2Builder;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivImagePreloader;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.DivVisibilityActionDispatcher;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.ReleaseManager;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.widgets.BitmapEffectHelper;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.internal.viewpool.optimization.PerformanceDependentSessionProfiler;
import com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository;
import com.yandex.yatagan.BindsInstance;
import com.yandex.yatagan.Component;
import javax.inject.Named;

/* JADX INFO: loaded from: classes9.dex */
@DivScope
@Component(isRoot = false, modules = {Div2Module.class, DivConfiguration.class, DivHistogramsModule.class})
public interface Div2Component {

    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder baseContext(ContextThemeWrapper contextThemeWrapper);

        Div2Component build();

        Builder configuration(DivConfiguration divConfiguration);

        @BindsInstance
        Builder divCreationTracker(DivCreationTracker divCreationTracker);

        @BindsInstance
        Builder divVariableController(DivVariableController divVariableController);

        @BindsInstance
        Builder themeId(@Named(Names.THEME) int i);
    }

    DivActionBinder getActionBinder();

    DivActionHandler getActionHandler();

    DivActionTypedHandlerCombiner getActionTypedHandlerCombiner();

    BitmapEffectHelper getBitmapEffectHelper();

    Div2Builder getDiv2Builder();

    Div2Logger getDiv2Logger();

    DivBinder getDivBinder();

    DivCreationTracker getDivCreationTracker();

    DivCustomContainerChildFactory getDivCustomContainerChildFactory();

    DivCustomContainerViewAdapter getDivCustomContainerViewAdapter();

    DivDataChangeListener getDivDataChangeListener();

    DivDownloader getDivDownloader();

    DivStateChangeListener getDivStateChangeListener();

    DivTimerEventDispatcherProvider getDivTimersControllerProvider();

    DivVariableController getDivVariableController();

    DivVideoActionHandler getDivVideoActionHandler();

    @Deprecated
    DivPlayerFactory getDivVideoFactory();

    DivPlayerPreloader getDivVideoPreloader();

    DivVideoViewMapper getDivVideoViewMapper();

    DivViewCreator getDivViewCreator();

    ErrorCollectors getErrorCollectors();

    ExpressionsRuntimeProvider getExpressionsRuntimeProvider();

    DivExtensionController getExtensionController();

    HistogramReporter getHistogramReporter();

    DivImagePreloader getImagePreloader();

    DivPatchManager getPatchManager();

    PerformanceDependentSessionProfiler getPerformanceDependentSessionProfiler();

    DivPreloader getPreloader();

    ReleaseManager getReleaseManager();

    @Deprecated
    RenderScript getRenderScript();

    DivStateManager getStateManager();

    StoredValuesController getStoredValuesController();

    TabsStateCache getTabsStateCache();

    TemporaryDivStateCache getTemporaryDivStateCache();

    DivTooltipController getTooltipController();

    ViewPreCreationProfileRepository getViewPreCreationProfileRepository();

    DivVisibilityActionDispatcher getVisibilityActionDispatcher();

    DivVisibilityActionTracker getVisibilityActionTracker();

    @ExperimentFlag(experiment = Experiment.BIND_ON_ATTACH_ENABLED)
    boolean isBindOnAttachEnabled();

    @ExperimentFlag(experiment = Experiment.COMPLEX_REBIND_ENABLED)
    boolean isComplexRebindEnabled();

    @ExperimentFlag(experiment = Experiment.PAGER_PAGE_CLIP_ENABLED)
    boolean isPagerPageClipEnabled();

    Div2ViewComponent.Builder viewComponent();
}
