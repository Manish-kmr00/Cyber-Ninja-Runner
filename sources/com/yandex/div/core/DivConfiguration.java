package com.yandex.div.core;

import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.downloader.DivDownloader;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.expression.variables.DivVariableController;
import com.yandex.div.core.expression.variables.GlobalVariableController;
import com.yandex.div.core.extension.DivExtensionHandler;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.image.DivImageLoaderWrapper;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.player.DivPlayerFactory;
import com.yandex.div.core.player.DivPlayerPreloader;
import com.yandex.div.core.state.DivStateChangeListener;
import com.yandex.div.internal.viewpool.ViewPoolProfiler;
import com.yandex.div.internal.viewpool.ViewPreCreationProfile;
import com.yandex.div.state.DivStateCache;
import com.yandex.div.state.InMemoryDivStateCache;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes10.dex */
@Module
public class DivConfiguration {
    private final boolean mAccessibilityEnabled;
    private final DivActionHandler mActionHandler;
    private boolean mBindOnAttachEnabled;
    private boolean mComplexRebindEnabled;
    private final Div2ImageStubProvider mDiv2ImageStubProvider;
    private final Div2Logger mDiv2Logger;
    private final DivCustomContainerViewAdapter mDivCustomContainerViewAdapter;
    private final DivDataChangeListener mDivDataChangeListener;
    private final DivDownloader mDivDownloader;
    private final DivPlayerFactory mDivPlayerFactory;
    private final DivPlayerPreloader mDivPlayerPreloader;
    private final DivStateCache mDivStateCache;
    private final DivStateChangeListener mDivStateChangeListener;
    private final DivVariableController mDivVariableController;
    private final List<DivVisibilityChangeListener> mDivVisibilityChangeListeners;
    private final List<DivExtensionHandler> mExtensionHandlers;
    private final DivImageLoader mImageLoader;
    private final boolean mLongtapActionsPassToChild;
    private boolean mMultipleStateChangeEnabled;
    private boolean mPagerPageClipEnabled;
    private boolean mPermanentDebugPanelEnabled;
    private float mRecyclerScrollInterceptionAngle;
    private boolean mResourceCacheEnabled;
    private final boolean mShouldIgnoreMenuItemsInActions;
    private final boolean mSupportHyphenation;
    private final boolean mSwipeOutBeaconsEnabled;
    private final boolean mTapBeaconsEnabled;
    private final DivTooltipRestrictor mTooltipRestrictor;
    private final DivTypefaceProvider mTypefaceProvider;
    private final Map<String, DivTypefaceProvider> mTypefaceProviders;
    private boolean mViewPoolEnabled;
    private boolean mViewPoolOptimizationDebug;
    private boolean mViewPoolProfilingEnabled;
    private final ViewPoolProfiler.Reporter mViewPoolReporter;
    private final ViewPreCreationProfile mViewPreCreationProfile;
    private final boolean mVisibilityBeaconsEnabled;
    private final boolean mVisualErrors;

    private DivConfiguration(DivImageLoader divImageLoader, DivActionHandler divActionHandler, Div2Logger div2Logger, DivDataChangeListener divDataChangeListener, DivStateChangeListener divStateChangeListener, DivStateCache divStateCache, Div2ImageStubProvider div2ImageStubProvider, List<DivVisibilityChangeListener> list, DivCustomContainerViewAdapter divCustomContainerViewAdapter, DivPlayerFactory divPlayerFactory, DivPlayerPreloader divPlayerPreloader, DivTooltipRestrictor divTooltipRestrictor, List<DivExtensionHandler> list2, DivDownloader divDownloader, DivTypefaceProvider divTypefaceProvider, Map<String, DivTypefaceProvider> map, ViewPreCreationProfile viewPreCreationProfile, ViewPoolProfiler.Reporter reporter, DivVariableController divVariableController, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, float f) {
        this.mImageLoader = divImageLoader;
        this.mActionHandler = divActionHandler;
        this.mDiv2Logger = div2Logger;
        this.mDivDataChangeListener = divDataChangeListener;
        this.mDivStateChangeListener = divStateChangeListener;
        this.mDivStateCache = divStateCache;
        this.mDiv2ImageStubProvider = div2ImageStubProvider;
        this.mDivVisibilityChangeListeners = list;
        this.mDivCustomContainerViewAdapter = divCustomContainerViewAdapter;
        this.mDivPlayerFactory = divPlayerFactory;
        this.mDivPlayerPreloader = divPlayerPreloader;
        this.mTooltipRestrictor = divTooltipRestrictor;
        this.mExtensionHandlers = list2;
        this.mDivDownloader = divDownloader;
        this.mTypefaceProvider = divTypefaceProvider;
        this.mTypefaceProviders = map;
        this.mViewPoolReporter = reporter;
        this.mTapBeaconsEnabled = z;
        this.mVisibilityBeaconsEnabled = z2;
        this.mSwipeOutBeaconsEnabled = z3;
        this.mLongtapActionsPassToChild = z4;
        this.mShouldIgnoreMenuItemsInActions = z5;
        this.mVisualErrors = z6;
        this.mSupportHyphenation = z7;
        this.mAccessibilityEnabled = z8;
        this.mViewPoolEnabled = z9;
        this.mViewPreCreationProfile = viewPreCreationProfile;
        this.mViewPoolProfilingEnabled = z10;
        this.mViewPoolOptimizationDebug = z11;
        this.mResourceCacheEnabled = z12;
        this.mMultipleStateChangeEnabled = z13;
        this.mBindOnAttachEnabled = z14;
        this.mComplexRebindEnabled = z15;
        this.mPermanentDebugPanelEnabled = z17;
        this.mDivVariableController = divVariableController;
        this.mRecyclerScrollInterceptionAngle = f;
        this.mPagerPageClipEnabled = z16;
    }

    @Provides
    public DivActionHandler getActionHandler() {
        return this.mActionHandler;
    }

    @Provides
    public DivImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    @Provides
    public Div2Logger getDiv2Logger() {
        return this.mDiv2Logger;
    }

    @Provides
    public DivDataChangeListener getDivDataChangeListener() {
        return this.mDivDataChangeListener;
    }

    @Provides
    public DivStateChangeListener getDivStateChangeListener() {
        return this.mDivStateChangeListener;
    }

    @Provides
    public DivStateCache getDivStateCache() {
        return this.mDivStateCache;
    }

    @Provides
    public Div2ImageStubProvider getDiv2ImageStubProvider() {
        return this.mDiv2ImageStubProvider;
    }

    @Provides
    public List<? extends DivVisibilityChangeListener> getDivVisibilityChangeListeners() {
        return this.mDivVisibilityChangeListeners;
    }

    @Provides
    public DivCustomContainerViewAdapter getDivCustomContainerViewAdapter() {
        return this.mDivCustomContainerViewAdapter;
    }

    @Provides
    public DivPlayerFactory getDivPlayerFactory() {
        return this.mDivPlayerFactory;
    }

    @Provides
    public DivPlayerPreloader getDivPlayerPreloader() {
        return this.mDivPlayerPreloader;
    }

    @Provides
    public DivTooltipRestrictor getTooltipRestrictor() {
        return this.mTooltipRestrictor;
    }

    @Provides
    public List<? extends DivExtensionHandler> getExtensionHandlers() {
        return this.mExtensionHandlers;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.TAP_BEACONS_ENABLED)
    public boolean isTapBeaconsEnabled() {
        return this.mTapBeaconsEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.VISIBILITY_BEACONS_ENABLED)
    public boolean isVisibilityBeaconsEnabled() {
        return this.mVisibilityBeaconsEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.SWIPE_OUT_BEACONS_ENABLED)
    public boolean isSwipeOutBeaconsEnabled() {
        return this.mSwipeOutBeaconsEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED)
    public boolean isLongtapActionsPassToChild() {
        return this.mLongtapActionsPassToChild;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.IGNORE_ACTION_MENU_ITEMS_ENABLED)
    public boolean isContextMenuHandlerOverridden() {
        return this.mShouldIgnoreMenuItemsInActions;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.HYPHENATION_SUPPORT_ENABLED)
    public boolean isHyphenationSupported() {
        return this.mSupportHyphenation;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.VIEW_POOL_ENABLED)
    public boolean isViewPoolEnabled() {
        return this.mViewPoolEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.PAGER_PAGE_CLIP_ENABLED)
    public boolean isPagerPageClipEnabled() {
        return this.mPagerPageClipEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.VIEW_POOL_PROFILING_ENABLED)
    public boolean isViewPoolProfilingEnabled() {
        return this.mViewPoolProfilingEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.VIEW_POOL_OPTIMIZATION_DEBUG)
    public boolean isDebuggingViewPoolOptimization() {
        return this.mViewPoolOptimizationDebug;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.RESOURCE_CACHE_ENABLED)
    public boolean isResourceCacheEnabled() {
        return this.mResourceCacheEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.MULTIPLE_STATE_CHANGE_ENABLED)
    public boolean isMultipleStateChangeEnabled() {
        return this.mMultipleStateChangeEnabled;
    }

    @Provides
    public DivDownloader getDivDownloader() {
        return this.mDivDownloader;
    }

    @Provides
    public DivTypefaceProvider getTypefaceProvider() {
        return this.mTypefaceProvider;
    }

    @Provides
    public Map<String, ? extends DivTypefaceProvider> getAdditionalTypefaceProviders() {
        return this.mTypefaceProviders;
    }

    @Provides
    public ViewPreCreationProfile getViewPreCreationProfile() {
        return this.mViewPreCreationProfile;
    }

    @Provides
    public ViewPoolProfiler.Reporter getViewPoolReporter() {
        return this.mViewPoolReporter;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.VISUAL_ERRORS_ENABLED)
    public boolean getAreVisualErrorsEnabled() {
        return this.mVisualErrors;
    }

    @Deprecated(message = "Accessibility is always enabled")
    @Provides
    @ExperimentFlag(experiment = Experiment.ACCESSIBILITY_ENABLED)
    public boolean isAccessibilityEnabled() {
        return this.mAccessibilityEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.BIND_ON_ATTACH_ENABLED)
    public boolean isBindOnAttachEnabled() {
        return this.mBindOnAttachEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.COMPLEX_REBIND_ENABLED)
    public boolean isComplexRebindEnabled() {
        return this.mComplexRebindEnabled;
    }

    @Provides
    @ExperimentFlag(experiment = Experiment.PERMANENT_DEBUG_PANEL_ENABLED)
    public boolean isPermanentDebugPanelEnabled() {
        return this.mPermanentDebugPanelEnabled;
    }

    @Provides
    public float getRecyclerScrollInterceptionAngle() {
        return this.mRecyclerScrollInterceptionAngle;
    }

    public DivVariableController getDivVariableController() {
        return this.mDivVariableController;
    }

    @Deprecated
    public GlobalVariableController getGlobalVariableController() {
        return new GlobalVariableController(this.mDivVariableController);
    }

    public static class Builder {
        private DivActionHandler mActionHandler;
        private Map<String, DivTypefaceProvider> mAdditionalTypefaceProviders;
        private Div2ImageStubProvider mDiv2ImageStubProvider;
        private Div2Logger mDiv2Logger;
        private DivCustomContainerViewAdapter mDivCustomContainerViewAdapter;
        private DivDataChangeListener mDivDataChangeListener;
        private DivDownloader mDivDownloader;
        private DivPlayerFactory mDivPlayerFactory;
        private DivPlayerPreloader mDivPlayerPreloader;
        private DivStateCache mDivStateCache;
        private DivStateChangeListener mDivStateChangeListener;
        private DivVariableController mDivVariableController;
        private final DivImageLoader mImageLoader;
        private DivTooltipRestrictor mTooltipRestrictor;
        private DivTypefaceProvider mTypefaceProvider;
        private ViewPoolProfiler.Reporter mViewPoolReporter;
        private ViewPreCreationProfile mViewPreCreationProfile;
        private final List<DivVisibilityChangeListener> mDivVisibilityChangeListeners = new ArrayList();
        private final List<DivExtensionHandler> mExtensionHandlers = new ArrayList();
        private boolean mTapBeaconsEnabled = Experiment.TAP_BEACONS_ENABLED.getDefaultValue();
        private boolean mVisibilityBeaconsEnabled = Experiment.VISIBILITY_BEACONS_ENABLED.getDefaultValue();
        private boolean mSwipeOutBeaconsEnabled = Experiment.SWIPE_OUT_BEACONS_ENABLED.getDefaultValue();
        private boolean mLongtapActionsPassToChild = Experiment.LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED.getDefaultValue();
        private boolean mShouldIgnoreMenuItemsInActions = Experiment.IGNORE_ACTION_MENU_ITEMS_ENABLED.getDefaultValue();
        private boolean mSupportHyphenation = Experiment.HYPHENATION_SUPPORT_ENABLED.getDefaultValue();
        private boolean mVisualErrors = Experiment.VISUAL_ERRORS_ENABLED.getDefaultValue();
        private boolean mAccessibilityEnabled = Experiment.ACCESSIBILITY_ENABLED.getDefaultValue();
        private boolean mViewPoolEnabled = Experiment.VIEW_POOL_ENABLED.getDefaultValue();
        private boolean mViewPoolProfilingEnabled = Experiment.VIEW_POOL_PROFILING_ENABLED.getDefaultValue();
        private boolean mViewPoolOptimizationDebug = Experiment.VIEW_POOL_OPTIMIZATION_DEBUG.getDefaultValue();
        private boolean mResourceCacheEnabled = Experiment.RESOURCE_CACHE_ENABLED.getDefaultValue();
        private boolean mMultipleStateChangeEnabled = Experiment.MULTIPLE_STATE_CHANGE_ENABLED.getDefaultValue();
        private boolean mBindOnAttachEnabled = false;
        private boolean mComplexRebindEnabled = Experiment.COMPLEX_REBIND_ENABLED.getDefaultValue();
        private boolean mPagerPageClipEnabled = Experiment.PAGER_PAGE_CLIP_ENABLED.getDefaultValue();
        private boolean mPermanentDebugPanelEnabled = Experiment.PERMANENT_DEBUG_PANEL_ENABLED.getDefaultValue();
        private float mRecyclerScrollInterceptionAngle = 0.0f;

        @Deprecated
        public Builder globalVariableController(GlobalVariableController globalVariableController) {
            return this;
        }

        public Builder(DivImageLoader divImageLoader) {
            this.mImageLoader = divImageLoader;
        }

        public Builder actionHandler(DivActionHandler divActionHandler) {
            this.mActionHandler = divActionHandler;
            return this;
        }

        public Builder div2Logger(Div2Logger div2Logger) {
            this.mDiv2Logger = div2Logger;
            return this;
        }

        public Builder divDataChangeListener(DivDataChangeListener divDataChangeListener) {
            this.mDivDataChangeListener = divDataChangeListener;
            return this;
        }

        public Builder divStateChangeListener(DivStateChangeListener divStateChangeListener) {
            this.mDivStateChangeListener = divStateChangeListener;
            return this;
        }

        public Builder divStateCache(DivStateCache divStateCache) {
            this.mDivStateCache = divStateCache;
            return this;
        }

        public Builder div2ImageStubProvider(Div2ImageStubProvider div2ImageStubProvider) {
            this.mDiv2ImageStubProvider = div2ImageStubProvider;
            return this;
        }

        public Builder divVisibilityChangeListener(DivVisibilityChangeListener divVisibilityChangeListener) {
            this.mDivVisibilityChangeListeners.add(divVisibilityChangeListener);
            return this;
        }

        public Builder divCustomContainerViewAdapter(DivCustomContainerViewAdapter divCustomContainerViewAdapter) {
            this.mDivCustomContainerViewAdapter = divCustomContainerViewAdapter;
            return this;
        }

        public Builder divPlayerFactory(DivPlayerFactory divPlayerFactory) {
            this.mDivPlayerFactory = divPlayerFactory;
            return this;
        }

        public Builder divPlayerPreloader(DivPlayerPreloader divPlayerPreloader) {
            this.mDivPlayerPreloader = divPlayerPreloader;
            return this;
        }

        public Builder tooltipRestrictor(DivTooltipRestrictor divTooltipRestrictor) {
            this.mTooltipRestrictor = divTooltipRestrictor;
            return this;
        }

        public Builder enableTapBeacons() {
            this.mTapBeaconsEnabled = true;
            return this;
        }

        public Builder enableVisibilityBeacons() {
            this.mVisibilityBeaconsEnabled = true;
            return this;
        }

        public Builder swipeOutBeacons(Boolean bool) {
            this.mSwipeOutBeaconsEnabled = bool.booleanValue();
            return this;
        }

        public Builder enableLongtapActionsPassingToChild() {
            this.mLongtapActionsPassToChild = true;
            return this;
        }

        public Builder extension(DivExtensionHandler divExtensionHandler) {
            this.mExtensionHandlers.add(divExtensionHandler);
            return this;
        }

        public Builder divDownloader(DivDownloader divDownloader) {
            this.mDivDownloader = divDownloader;
            return this;
        }

        public Builder additionalTypefaceProviders(Map<String, DivTypefaceProvider> map) {
            this.mAdditionalTypefaceProviders = map;
            return this;
        }

        public Builder typefaceProvider(DivTypefaceProvider divTypefaceProvider) {
            this.mTypefaceProvider = divTypefaceProvider;
            return this;
        }

        public Builder viewPreCreationProfile(ViewPreCreationProfile viewPreCreationProfile) {
            this.mViewPreCreationProfile = viewPreCreationProfile;
            return this;
        }

        public Builder viewPoolReporter(ViewPoolProfiler.Reporter reporter) {
            this.mViewPoolReporter = reporter;
            return this;
        }

        public Builder overrideContextMenuHandler(boolean z) {
            this.mShouldIgnoreMenuItemsInActions = z;
            return this;
        }

        public Builder visualErrorsEnabled(boolean z) {
            this.mVisualErrors = z;
            return this;
        }

        public Builder supportHyphenation(boolean z) {
            this.mSupportHyphenation = z;
            return this;
        }

        public Builder enableAccessibility(boolean z) {
            this.mAccessibilityEnabled = z;
            return this;
        }

        public Builder enableViewPool(boolean z) {
            this.mViewPoolEnabled = z;
            return this;
        }

        public Builder enableViewPoolProfiling(boolean z) {
            this.mViewPoolProfilingEnabled = z;
            return this;
        }

        public Builder debugViewPoolOptimization(boolean z) {
            this.mViewPoolOptimizationDebug = z;
            return this;
        }

        public Builder enableResourceCache(boolean z) {
            this.mResourceCacheEnabled = z;
            return this;
        }

        public Builder enableMultipleStateChange(boolean z) {
            this.mMultipleStateChangeEnabled = z;
            return this;
        }

        public Builder enableBindOnAttach(boolean z) {
            this.mBindOnAttachEnabled = z;
            return this;
        }

        public Builder enableComplexRebind(boolean z) {
            this.mComplexRebindEnabled = z;
            return this;
        }

        public Builder enablePagerPageClipping(boolean z) {
            this.mPagerPageClipEnabled = z;
            return this;
        }

        public Builder enablePermanentDebugPanel(boolean z) {
            this.mPermanentDebugPanelEnabled = z;
            return this;
        }

        public Builder divVariableController(DivVariableController divVariableController) {
            this.mDivVariableController = divVariableController;
            return this;
        }

        public Builder recyclerScrollInterceptionAngle(float f) {
            this.mRecyclerScrollInterceptionAngle = f;
            return this;
        }

        public DivConfiguration build() {
            DivTypefaceProvider divTypefaceProvider = this.mTypefaceProvider;
            if (divTypefaceProvider == null) {
                divTypefaceProvider = DivTypefaceProvider.DEFAULT;
            }
            DivTypefaceProvider divTypefaceProvider2 = divTypefaceProvider;
            DivImageLoaderWrapper divImageLoaderWrapper = new DivImageLoaderWrapper(this.mImageLoader);
            DivActionHandler divActionHandler = this.mActionHandler;
            if (divActionHandler == null) {
                divActionHandler = new DivActionHandler();
            }
            DivActionHandler divActionHandler2 = divActionHandler;
            Div2Logger div2Logger = this.mDiv2Logger;
            if (div2Logger == null) {
                div2Logger = Div2Logger.STUB;
            }
            Div2Logger div2Logger2 = div2Logger;
            DivDataChangeListener divDataChangeListener = this.mDivDataChangeListener;
            if (divDataChangeListener == null) {
                divDataChangeListener = DivDataChangeListener.STUB;
            }
            DivDataChangeListener divDataChangeListener2 = divDataChangeListener;
            DivStateChangeListener divStateChangeListener = this.mDivStateChangeListener;
            if (divStateChangeListener == null) {
                divStateChangeListener = DivStateChangeListener.STUB;
            }
            DivStateChangeListener divStateChangeListener2 = divStateChangeListener;
            DivStateCache inMemoryDivStateCache = this.mDivStateCache;
            if (inMemoryDivStateCache == null) {
                inMemoryDivStateCache = new InMemoryDivStateCache();
            }
            DivStateCache divStateCache = inMemoryDivStateCache;
            Div2ImageStubProvider div2ImageStubProvider = this.mDiv2ImageStubProvider;
            if (div2ImageStubProvider == null) {
                div2ImageStubProvider = Div2ImageStubProvider.STUB;
            }
            Div2ImageStubProvider div2ImageStubProvider2 = div2ImageStubProvider;
            List<DivVisibilityChangeListener> list = this.mDivVisibilityChangeListeners;
            DivCustomContainerViewAdapter divCustomContainerViewAdapter = this.mDivCustomContainerViewAdapter;
            if (divCustomContainerViewAdapter == null) {
                divCustomContainerViewAdapter = DivCustomContainerViewAdapter.STUB;
            }
            DivCustomContainerViewAdapter divCustomContainerViewAdapter2 = divCustomContainerViewAdapter;
            DivPlayerFactory divPlayerFactory = this.mDivPlayerFactory;
            if (divPlayerFactory == null) {
                divPlayerFactory = DivPlayerFactory.STUB;
            }
            DivPlayerFactory divPlayerFactory2 = divPlayerFactory;
            DivPlayerPreloader divPlayerPreloader = this.mDivPlayerPreloader;
            if (divPlayerPreloader == null) {
                divPlayerPreloader = DivPlayerPreloader.STUB;
            }
            DivPlayerPreloader divPlayerPreloader2 = divPlayerPreloader;
            DivTooltipRestrictor divTooltipRestrictor = this.mTooltipRestrictor;
            if (divTooltipRestrictor == null) {
                divTooltipRestrictor = DivTooltipRestrictor.STUB;
            }
            DivTooltipRestrictor divTooltipRestrictor2 = divTooltipRestrictor;
            List<DivExtensionHandler> list2 = this.mExtensionHandlers;
            DivDownloader divDownloader = this.mDivDownloader;
            if (divDownloader == null) {
                divDownloader = DivDownloader.STUB;
            }
            DivDownloader divDownloader2 = divDownloader;
            Map map = this.mAdditionalTypefaceProviders;
            if (map == null) {
                map = new HashMap();
            }
            Map map2 = map;
            ViewPreCreationProfile viewPreCreationProfile = this.mViewPreCreationProfile;
            if (viewPreCreationProfile == null) {
                viewPreCreationProfile = new ViewPreCreationProfile();
            }
            ViewPreCreationProfile viewPreCreationProfile2 = viewPreCreationProfile;
            ViewPoolProfiler.Reporter reporter = this.mViewPoolReporter;
            if (reporter == null) {
                reporter = ViewPoolProfiler.Reporter.NO_OP;
            }
            ViewPoolProfiler.Reporter reporter2 = reporter;
            DivVariableController divVariableController = this.mDivVariableController;
            if (divVariableController == null) {
                divVariableController = new DivVariableController();
            }
            return new DivConfiguration(divImageLoaderWrapper, divActionHandler2, div2Logger2, divDataChangeListener2, divStateChangeListener2, divStateCache, div2ImageStubProvider2, list, divCustomContainerViewAdapter2, divPlayerFactory2, divPlayerPreloader2, divTooltipRestrictor2, list2, divDownloader2, divTypefaceProvider2, map2, viewPreCreationProfile2, reporter2, divVariableController, this.mTapBeaconsEnabled, this.mVisibilityBeaconsEnabled, this.mSwipeOutBeaconsEnabled, this.mLongtapActionsPassToChild, this.mShouldIgnoreMenuItemsInActions, this.mVisualErrors, this.mSupportHyphenation, this.mAccessibilityEnabled, this.mViewPoolEnabled, this.mViewPoolProfilingEnabled, this.mViewPoolOptimizationDebug, this.mResourceCacheEnabled, this.mMultipleStateChangeEnabled, this.mBindOnAttachEnabled, this.mComplexRebindEnabled, this.mPagerPageClipEnabled, this.mPermanentDebugPanelEnabled, this.mRecyclerScrollInterceptionAngle);
        }
    }
}
