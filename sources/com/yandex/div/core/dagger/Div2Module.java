package com.yandex.div.core.dagger;

import android.content.Context;
import android.renderscript.RenderScript;
import android.view.ContextThemeWrapper;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.player.DivPlayerPreloader;
import com.yandex.div.core.resources.ContextThemeWrapperWithResourceCache;
import com.yandex.div.core.view2.DivImagePreloader;
import com.yandex.div.internal.viewpool.AdvanceViewPool;
import com.yandex.div.internal.viewpool.PseudoViewPool;
import com.yandex.div.internal.viewpool.ViewCreator;
import com.yandex.div.internal.viewpool.ViewPool;
import com.yandex.div.internal.viewpool.ViewPoolProfiler;
import com.yandex.div.internal.viewpool.optimization.PerformanceDependentSessionProfiler;
import com.yandex.div.internal.widget.tabs.TabTextStyleProvider;
import com.yandex.yatagan.Binds;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import javax.inject.Named;

/* JADX INFO: loaded from: classes13.dex */
@Module
public abstract class Div2Module {
    @Binds
    @Named("context")
    public abstract Context bindContext(ContextThemeWrapper contextThemeWrapper);

    @Provides
    @DivScope
    @Named(Names.THEMED_CONTEXT)
    public static Context provideThemedContext(ContextThemeWrapper contextThemeWrapper, @Named(Names.THEME) int i, @ExperimentFlag(experiment = Experiment.RESOURCE_CACHE_ENABLED) boolean z) {
        if (z) {
            return new ContextThemeWrapperWithResourceCache(contextThemeWrapper, i);
        }
        return new ContextThemeWrapper(contextThemeWrapper, i);
    }

    @Provides
    @DivScope
    public static ViewPool provideViewPool(@ExperimentFlag(experiment = Experiment.VIEW_POOL_ENABLED) boolean z, ExternalOptional<ViewPoolProfiler> externalOptional, PerformanceDependentSessionProfiler performanceDependentSessionProfiler, ViewCreator viewCreator) {
        if (z) {
            return new AdvanceViewPool(externalOptional.getOptional().orNull(), performanceDependentSessionProfiler, viewCreator);
        }
        return new PseudoViewPool();
    }

    @Provides
    @DivScope
    public static TabTextStyleProvider provideTabTextStyleProvider(DivTypefaceProvider divTypefaceProvider) {
        return new TabTextStyleProvider(divTypefaceProvider);
    }

    @Provides
    @DivScope
    public static ExternalOptional<ViewPoolProfiler> provideViewPoolProfiler(@ExperimentFlag(experiment = Experiment.VIEW_POOL_PROFILING_ENABLED) boolean z, ViewPoolProfiler.Reporter reporter) {
        if (z) {
            return ExternalOptional.of(new ViewPoolProfiler(reporter));
        }
        return ExternalOptional.empty();
    }

    @Provides
    @DivScope
    public static RenderScript provideRenderScript(@Named("context") Context context) {
        return RenderScript.createMultiContext(context, RenderScript.ContextType.NORMAL, 0, context.getApplicationInfo().targetSdkVersion);
    }

    @Provides
    @DivScope
    public static DivPreloader provideDivPreloader(DivImagePreloader divImagePreloader, DivCustomContainerViewAdapter divCustomContainerViewAdapter, DivPlayerPreloader divPlayerPreloader, DivExtensionController divExtensionController) {
        return new DivPreloader(divImagePreloader, divCustomContainerViewAdapter, divExtensionController, divPlayerPreloader);
    }
}
