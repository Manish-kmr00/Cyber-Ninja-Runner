package com.yandex.div.core.dagger;

import android.content.Context;
import android.renderscript.RenderScript;
import android.view.ContextThemeWrapper;
import com.yandex.android.beacon.SendBeaconConfiguration;
import com.yandex.android.beacon.SendBeaconManager;
import com.yandex.div.core.Div2ImageStubProvider;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div.core.DivCreationTracker;
import com.yandex.div.core.DivCustomContainerChildFactory;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.DivDataChangeListener;
import com.yandex.div.core.DivKitConfiguration;
import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.DivTooltipRestrictor;
import com.yandex.div.core.actions.DivActionTypedArrayMutationHandler;
import com.yandex.div.core.actions.DivActionTypedClearFocusHandler;
import com.yandex.div.core.actions.DivActionTypedCopyToClipboardHandler;
import com.yandex.div.core.actions.DivActionTypedDictSetValueHandler;
import com.yandex.div.core.actions.DivActionTypedFocusElementHandler;
import com.yandex.div.core.actions.DivActionTypedHandler;
import com.yandex.div.core.actions.DivActionTypedHandlerCombiner;
import com.yandex.div.core.actions.DivActionTypedHideTooltipHandler;
import com.yandex.div.core.actions.DivActionTypedScrollHandler;
import com.yandex.div.core.actions.DivActionTypedSetStateHandler;
import com.yandex.div.core.actions.DivActionTypedSetStoredValueHandler;
import com.yandex.div.core.actions.DivActionTypedSetVariableHandler;
import com.yandex.div.core.actions.DivActionTypedShowTooltipHandler;
import com.yandex.div.core.actions.DivActionTypedTimerHandler;
import com.yandex.div.core.actions.DivActionTypedVideoHandler;
import com.yandex.div.core.actions.DivAnimatorTypedActionHandler;
import com.yandex.div.core.downloader.DivDownloader;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.downloader.DivPatchManager;
import com.yandex.div.core.expression.ExpressionsRuntimeProvider;
import com.yandex.div.core.expression.local.DivRuntimeVisitor;
import com.yandex.div.core.expression.storedvalues.StoredValuesController;
import com.yandex.div.core.expression.variables.DivVariableController;
import com.yandex.div.core.expression.variables.TwoWayBooleanVariableBinder;
import com.yandex.div.core.expression.variables.TwoWayIntegerVariableBinder;
import com.yandex.div.core.expression.variables.TwoWayStringVariableBinder;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.images.DivImageLoader;
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
import com.yandex.div.core.tooltip.DivTooltipViewBuilder;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.view2.Div2Builder;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivAccessibilityBinder;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivImagePreloader;
import com.yandex.div.core.view2.DivPlaceholderLoader;
import com.yandex.div.core.view2.DivTransitionBuilder;
import com.yandex.div.core.view2.DivTypefaceResolver;
import com.yandex.div.core.view2.DivValidator;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.DivViewIdProvider;
import com.yandex.div.core.view2.DivVisibilityActionDispatcher;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.ReleaseManager;
import com.yandex.div.core.view2.ViewBindingProvider;
import com.yandex.div.core.view2.ViewVisibilityCalculator;
import com.yandex.div.core.view2.animations.DivAnimatorController;
import com.yandex.div.core.view2.divs.DivActionBeaconSender;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.DivBackgroundBinder;
import com.yandex.div.core.view2.divs.DivBaseBinder;
import com.yandex.div.core.view2.divs.DivContainerBinder;
import com.yandex.div.core.view2.divs.DivCustomBinder;
import com.yandex.div.core.view2.divs.DivFocusBinder;
import com.yandex.div.core.view2.divs.DivGifImageBinder;
import com.yandex.div.core.view2.divs.DivGridBinder;
import com.yandex.div.core.view2.divs.DivImageBinder;
import com.yandex.div.core.view2.divs.DivIndicatorBinder;
import com.yandex.div.core.view2.divs.DivInputBinder;
import com.yandex.div.core.view2.divs.DivSelectBinder;
import com.yandex.div.core.view2.divs.DivSeparatorBinder;
import com.yandex.div.core.view2.divs.DivSliderBinder;
import com.yandex.div.core.view2.divs.DivStateBinder;
import com.yandex.div.core.view2.divs.DivSwitchBinder;
import com.yandex.div.core.view2.divs.DivTextBinder;
import com.yandex.div.core.view2.divs.DivVideoBinder;
import com.yandex.div.core.view2.divs.gallery.DivGalleryBinder;
import com.yandex.div.core.view2.divs.pager.DivPagerBinder;
import com.yandex.div.core.view2.divs.pager.PagerIndicatorConnector;
import com.yandex.div.core.view2.divs.tabs.DivTabsBinder;
import com.yandex.div.core.view2.divs.widgets.BitmapEffectHelper;
import com.yandex.div.core.view2.divs.widgets.MediaReleaseViewVisitor;
import com.yandex.div.core.view2.divs.widgets.ReleaseViewVisitor;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.core.view2.errors.ErrorVisualMonitor;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.core.view2.spannable.SpannedTextBuilder;
import com.yandex.div.core.view2.state.DivJoinedStateSwitcher;
import com.yandex.div.core.view2.state.DivMultipleStateSwitcher;
import com.yandex.div.core.view2.state.DivStateSwitcher;
import com.yandex.div.core.view2.state.DivStateTransitionHolder;
import com.yandex.div.histogram.CpuUsageHistogramReporter;
import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.histogram.HistogramColdTypeChecker;
import com.yandex.div.histogram.HistogramConfiguration;
import com.yandex.div.histogram.HistogramRecordConfiguration;
import com.yandex.div.histogram.HistogramRecorder;
import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.div.internal.viewpool.ViewCreator;
import com.yandex.div.internal.viewpool.ViewPool;
import com.yandex.div.internal.viewpool.ViewPoolProfiler;
import com.yandex.div.internal.viewpool.ViewPreCreationProfile;
import com.yandex.div.internal.viewpool.optimization.PerformanceDependentSessionProfiler;
import com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository;
import com.yandex.div.internal.widget.tabs.TabTextStyleProvider;
import com.yandex.div.state.DivStateCache;
import com.yandex.div.storage.DivStorageComponent;
import com.yandex.yatagan.Lazy;
import com.yandex.yatagan.internal.Checks;
import com.yandex.yatagan.internal.ThreadAssertions;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class Yatagan$DivKitComponent implements DivKitComponent {
    final Context mApplicationContext;
    private volatile Object mDivActionTypedHandlerCombinerInstance;
    final DivKitConfiguration mDivKitConfiguration;
    private volatile Object mDivParsingHistogramReporterInstance;
    private volatile Object mDivStorageComponentInstance;
    private volatile Object mHistogramColdTypeCheckerInstance;
    private volatile Object mHistogramRecorderInstance;
    private volatile Object mSendBeaconManagerInstance;
    private volatile Object mViewCreatorInstance;

    Yatagan$DivKitComponent(Context context, DivKitConfiguration divKitConfiguration) {
        this.mDivActionTypedHandlerCombinerInstance = new UninitializedLock();
        this.mDivStorageComponentInstance = new UninitializedLock();
        this.mViewCreatorInstance = new UninitializedLock();
        this.mSendBeaconManagerInstance = new UninitializedLock();
        this.mHistogramRecorderInstance = new UninitializedLock();
        this.mDivParsingHistogramReporterInstance = new UninitializedLock();
        this.mHistogramColdTypeCheckerInstance = new UninitializedLock();
        this.mApplicationContext = (Context) Checks.checkInputNotNull(context);
        this.mDivKitConfiguration = (DivKitConfiguration) Checks.checkInputNotNull(divKitConfiguration);
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public Div2Component.Builder div2Component() {
        return new Div2ComponentImpl.ComponentFactoryImpl(this);
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public SendBeaconManager getSendBeaconManager() {
        return cacheSendBeaconManager();
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public ExecutorService getExecutorService() {
        return (ExecutorService) Checks.checkProvisionNotNull(this.mDivKitConfiguration.getExecutorService());
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public HistogramRecorder getHistogramRecorder() {
        return cacheHistogramRecorder();
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public HistogramRecordConfiguration getHistogramRecordConfiguration() {
        return (HistogramRecordConfiguration) Checks.checkProvisionNotNull(this.mDivKitConfiguration.histogramRecordConfiguration());
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public DivParsingHistogramReporter getParsingHistogramReporter() {
        return cacheDivParsingHistogramReporter();
    }

    @Override // com.yandex.div.core.dagger.DivKitComponent
    public HistogramReporterDelegate getHistogramReporterDelegate() {
        return accessHistogramReporterDelegate();
    }

    Object switch$$access(int i) {
        if (i == 0) {
            return accessHistogramReporterDelegate();
        }
        if (i == 1) {
            return cacheDivStorageComponent();
        }
        if (i == 2) {
            return Checks.checkProvisionNotNull(this.mDivKitConfiguration.getExecutorService());
        }
        if (i == 3) {
            return cacheSendBeaconManager();
        }
        if (i == 4) {
            return cacheHistogramRecorder();
        }
        if (i == 5) {
            return cacheHistogramColdTypeChecker();
        }
        throw new AssertionError();
    }

    DivActionTypedHandlerCombiner cacheDivActionTypedHandlerCombiner() {
        Object divActionTypedHandlerCombiner;
        Object obj = this.mDivActionTypedHandlerCombinerInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                divActionTypedHandlerCombiner = this.mDivActionTypedHandlerCombinerInstance;
                if (divActionTypedHandlerCombiner instanceof UninitializedLock) {
                    divActionTypedHandlerCombiner = new DivActionTypedHandlerCombiner(manyOfSetDivActionTypedHandler());
                    this.mDivActionTypedHandlerCombinerInstance = divActionTypedHandlerCombiner;
                }
            }
            obj = divActionTypedHandlerCombiner;
        }
        return (DivActionTypedHandlerCombiner) obj;
    }

    HistogramReporterDelegate accessHistogramReporterDelegate() {
        return (HistogramReporterDelegate) Checks.checkProvisionNotNull(DivKitHistogramsModule.INSTANCE.provideHistogramReporterDelegate((HistogramConfiguration) Checks.checkProvisionNotNull(this.mDivKitConfiguration.histogramConfiguration()), new ProviderImpl(this, 4), new ProviderImpl(this, 5)));
    }

    DivStorageComponent cacheDivStorageComponent() {
        Object objCheckProvisionNotNull;
        Object obj = this.mDivStorageComponentInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                objCheckProvisionNotNull = this.mDivStorageComponentInstance;
                if (objCheckProvisionNotNull instanceof UninitializedLock) {
                    objCheckProvisionNotNull = Checks.checkProvisionNotNull(DivStorageModule.INSTANCE.provideDivStorageComponent((ExternalOptional) Checks.checkProvisionNotNull(this.mDivKitConfiguration.externalDivStorageComponent()), this.mApplicationContext, accessHistogramReporterDelegate(), cacheDivParsingHistogramReporter()));
                    this.mDivStorageComponentInstance = objCheckProvisionNotNull;
                }
            }
            obj = objCheckProvisionNotNull;
        }
        return (DivStorageComponent) obj;
    }

    ViewCreator cacheViewCreator() {
        Object objCheckProvisionNotNull;
        Object obj = this.mViewCreatorInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                objCheckProvisionNotNull = this.mViewCreatorInstance;
                if (objCheckProvisionNotNull instanceof UninitializedLock) {
                    DivKitModule divKitModule = DivKitModule.INSTANCE;
                    objCheckProvisionNotNull = Checks.checkProvisionNotNull(DivKitModule.provideViewCreator((CpuUsageHistogramReporter) Checks.checkProvisionNotNull(this.mDivKitConfiguration.cpuUsageHistogramReporter())));
                    this.mViewCreatorInstance = objCheckProvisionNotNull;
                }
            }
            obj = objCheckProvisionNotNull;
        }
        return (ViewCreator) obj;
    }

    SendBeaconManager cacheSendBeaconManager() {
        Object objCheckProvisionNotNull;
        Object obj = this.mSendBeaconManagerInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                objCheckProvisionNotNull = this.mSendBeaconManagerInstance;
                if (objCheckProvisionNotNull instanceof UninitializedLock) {
                    DivKitModule divKitModule = DivKitModule.INSTANCE;
                    objCheckProvisionNotNull = Checks.checkProvisionNotNull(DivKitModule.provideSendBeaconManager(this.mApplicationContext, (SendBeaconConfiguration) Checks.checkProvisionNotNull(this.mDivKitConfiguration.sendBeaconConfiguration())));
                    this.mSendBeaconManagerInstance = objCheckProvisionNotNull;
                }
            }
            obj = objCheckProvisionNotNull;
        }
        return (SendBeaconManager) obj;
    }

    HistogramRecorder cacheHistogramRecorder() {
        Object objCheckProvisionNotNull;
        Object obj = this.mHistogramRecorderInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                objCheckProvisionNotNull = this.mHistogramRecorderInstance;
                if (objCheckProvisionNotNull instanceof UninitializedLock) {
                    objCheckProvisionNotNull = Checks.checkProvisionNotNull(this.mDivKitConfiguration.histogramRecorder());
                    this.mHistogramRecorderInstance = objCheckProvisionNotNull;
                }
            }
            obj = objCheckProvisionNotNull;
        }
        return (HistogramRecorder) obj;
    }

    DivParsingHistogramReporter cacheDivParsingHistogramReporter() {
        Object objCheckProvisionNotNull;
        Object obj = this.mDivParsingHistogramReporterInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                objCheckProvisionNotNull = this.mDivParsingHistogramReporterInstance;
                if (objCheckProvisionNotNull instanceof UninitializedLock) {
                    objCheckProvisionNotNull = Checks.checkProvisionNotNull(DivKitHistogramsModule.INSTANCE.provideDivParsingHistogramReporter((HistogramConfiguration) Checks.checkProvisionNotNull(this.mDivKitConfiguration.histogramConfiguration()), new ProviderImpl(this, 0), new ProviderImpl(this, 2)));
                    this.mDivParsingHistogramReporterInstance = objCheckProvisionNotNull;
                }
            }
            obj = objCheckProvisionNotNull;
        }
        return (DivParsingHistogramReporter) obj;
    }

    HistogramColdTypeChecker cacheHistogramColdTypeChecker() {
        Object histogramColdTypeChecker;
        Object obj = this.mHistogramColdTypeCheckerInstance;
        if (obj instanceof UninitializedLock) {
            synchronized (obj) {
                histogramColdTypeChecker = this.mHistogramColdTypeCheckerInstance;
                if (histogramColdTypeChecker instanceof UninitializedLock) {
                    histogramColdTypeChecker = new HistogramColdTypeChecker();
                    this.mHistogramColdTypeCheckerInstance = histogramColdTypeChecker;
                }
            }
            obj = histogramColdTypeChecker;
        }
        return (HistogramColdTypeChecker) obj;
    }

    Set<DivActionTypedHandler> manyOfSetDivActionTypedHandler() {
        HashSet hashSet = new HashSet(14);
        hashSet.add(new DivAnimatorTypedActionHandler());
        hashSet.add(new DivActionTypedArrayMutationHandler());
        hashSet.add(new DivActionTypedClearFocusHandler());
        hashSet.add(new DivActionTypedCopyToClipboardHandler());
        hashSet.add(new DivActionTypedDictSetValueHandler());
        hashSet.add(new DivActionTypedFocusElementHandler());
        hashSet.add(new DivActionTypedHideTooltipHandler());
        hashSet.add(new DivActionTypedScrollHandler());
        hashSet.add(new DivActionTypedSetStateHandler());
        hashSet.add(new DivActionTypedSetVariableHandler());
        hashSet.add(new DivActionTypedSetStoredValueHandler());
        hashSet.add(new DivActionTypedShowTooltipHandler());
        hashSet.add(new DivActionTypedTimerHandler());
        hashSet.add(new DivActionTypedVideoHandler());
        return hashSet;
    }

    public static DivKitComponent.Builder builder() {
        return new ComponentFactoryImpl();
    }

    /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
    static final class Div2ComponentImpl implements Div2Component {
        private Object mAccessibilityStateProviderInstance;
        final ContextThemeWrapper mBaseContext;
        private Object mBitmapEffectHelperInstance;
        private Object mDiv2BuilderInstance;
        private Object mDivActionBeaconSenderInstance;
        private Object mDivActionBinderInstance;
        private Object mDivBaseBinderInstance;
        private Object mDivBinderInstance;
        final DivConfiguration mDivConfiguration;
        final DivCreationTracker mDivCreationTracker;
        private Object mDivExtensionControllerInstance;
        private Object mDivImagePreloaderInstance;
        final Yatagan$DivKitComponent mDivKitComponent;
        private Object mDivPatchCacheInstance;
        private Object mDivPatchManagerInstance;
        private Object mDivPlaceholderLoaderInstance;
        private Object mDivPreloaderInstance;
        private Object mDivRuntimeVisitorInstance;
        private Object mDivStateManagerInstance;
        private Object mDivTimerEventDispatcherProviderInstance;
        private Object mDivTooltipControllerInstance;
        private Object mDivTypefaceResolverInstance;
        private Object mDivValidatorInstance;
        final DivVariableController mDivVariableController;
        private Object mDivVideoActionHandlerInstance;
        private Object mDivVideoViewMapperInstance;
        private Object mDivViewCreatorInstance;
        private Object mDivViewIdProviderInstance;
        private Object mDivVisibilityActionDispatcherInstance;
        private Object mDivVisibilityActionTrackerInstance;
        private Object mErrorCollectorsInstance;
        private Object mExpressionsRuntimeProviderInstance;
        private Object mHistogramReporterInstance;
        private Object mJavaxInjectNamedValueThemedContextContextInstance;
        private Object mPagerIndicatorConnectorInstance;
        private Object mPerformanceDependentSessionProfilerInstance;
        private Object mReleaseManagerInstance;
        private Object mRenderScriptInstance;
        private Object mStoredValuesControllerInstance;
        private Object mTabsStateCacheInstance;
        private Object mTemporaryDivStateCacheInstance;
        final Integer mThemeId;
        private Object mTwoWayIntegerVariableBinderInstance;
        private Object mTwoWayStringVariableBinderInstance;
        private Object mViewPoolInstance;
        private Object mViewPreCreationProfileRepositoryInstance;

        Div2ComponentImpl(Yatagan$DivKitComponent yatagan$DivKitComponent, ContextThemeWrapper contextThemeWrapper, DivConfiguration divConfiguration, Integer num, DivCreationTracker divCreationTracker, DivVariableController divVariableController) {
            this.mDivKitComponent = yatagan$DivKitComponent;
            this.mBaseContext = (ContextThemeWrapper) Checks.checkInputNotNull(contextThemeWrapper);
            this.mDivConfiguration = (DivConfiguration) Checks.checkInputNotNull(divConfiguration);
            this.mThemeId = (Integer) Checks.checkInputNotNull(num);
            this.mDivCreationTracker = (DivCreationTracker) Checks.checkInputNotNull(divCreationTracker);
            this.mDivVariableController = (DivVariableController) Checks.checkInputNotNull(divVariableController);
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public Div2Builder getDiv2Builder() {
            return cacheDiv2Builder();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivBinder getDivBinder() {
            return cacheDivBinder();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivViewCreator getDivViewCreator() {
            return cacheDivViewCreator();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivImagePreloader getImagePreloader() {
            return cacheDivImagePreloader();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivPreloader getPreloader() {
            return cacheDivPreloader();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public Div2Logger getDiv2Logger() {
            return (Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivVisibilityActionTracker getVisibilityActionTracker() {
            return cacheDivVisibilityActionTracker();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivVisibilityActionDispatcher getVisibilityActionDispatcher() {
            return cacheDivVisibilityActionDispatcher();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivActionBinder getActionBinder() {
            return cacheDivActionBinder();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public TemporaryDivStateCache getTemporaryDivStateCache() {
            return cacheTemporaryDivStateCache();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public TabsStateCache getTabsStateCache() {
            return cacheTabsStateCache();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivCustomContainerChildFactory getDivCustomContainerChildFactory() {
            return new DivCustomContainerChildFactory();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivCustomContainerViewAdapter getDivCustomContainerViewAdapter() {
            return (DivCustomContainerViewAdapter) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivCustomContainerViewAdapter());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivExtensionController getExtensionController() {
            return cacheDivExtensionController();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivDataChangeListener getDivDataChangeListener() {
            return (DivDataChangeListener) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivDataChangeListener());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public ExpressionsRuntimeProvider getExpressionsRuntimeProvider() {
            return cacheExpressionsRuntimeProvider();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivTimerEventDispatcherProvider getDivTimersControllerProvider() {
            return cacheDivTimerEventDispatcherProvider();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivVideoActionHandler getDivVideoActionHandler() {
            return cacheDivVideoActionHandler();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivVideoViewMapper getDivVideoViewMapper() {
            return cacheDivVideoViewMapper();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivStateManager getStateManager() {
            return cacheDivStateManager();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivStateChangeListener getDivStateChangeListener() {
            return (DivStateChangeListener) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivStateChangeListener());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivActionHandler getActionHandler() {
            return (DivActionHandler) Checks.checkProvisionNotNull(this.mDivConfiguration.getActionHandler());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivTooltipController getTooltipController() {
            return cacheDivTooltipController();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivPatchManager getPatchManager() {
            return cacheDivPatchManager();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public Div2ViewComponent.Builder viewComponent() {
            return new Div2ViewComponentImpl.ComponentFactoryImpl(this);
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivDownloader getDivDownloader() {
            return (DivDownloader) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivDownloader());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivVariableController getDivVariableController() {
            return this.mDivVariableController;
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public PerformanceDependentSessionProfiler getPerformanceDependentSessionProfiler() {
            return cachePerformanceDependentSessionProfiler();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public ViewPreCreationProfileRepository getViewPreCreationProfileRepository() {
            return cacheViewPreCreationProfileRepository();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public HistogramReporter getHistogramReporter() {
            return cacheHistogramReporter();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivPlayerFactory getDivVideoFactory() {
            return (DivPlayerFactory) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivPlayerFactory());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivPlayerPreloader getDivVideoPreloader() {
            return (DivPlayerPreloader) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivPlayerPreloader());
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivCreationTracker getDivCreationTracker() {
            return this.mDivCreationTracker;
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public RenderScript getRenderScript() {
            return cacheRenderScript();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public ReleaseManager getReleaseManager() {
            return cacheReleaseManager();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public StoredValuesController getStoredValuesController() {
            return cacheStoredValuesController();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public boolean isBindOnAttachEnabled() {
            return ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isBindOnAttachEnabled()))).booleanValue();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public boolean isComplexRebindEnabled() {
            return ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isComplexRebindEnabled()))).booleanValue();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public boolean isPagerPageClipEnabled() {
            return ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isPagerPageClipEnabled()))).booleanValue();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public DivActionTypedHandlerCombiner getActionTypedHandlerCombiner() {
            return this.mDivKitComponent.cacheDivActionTypedHandlerCombiner();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public ErrorCollectors getErrorCollectors() {
            return cacheErrorCollectors();
        }

        @Override // com.yandex.div.core.dagger.Div2Component
        public BitmapEffectHelper getBitmapEffectHelper() {
            return cacheBitmapEffectHelper();
        }

        Object switch$$access(int i) {
            if (i == 0) {
                return cacheDivBinder();
            }
            if (i == 1) {
                return cacheDiv2Builder();
            }
            if (i == 2) {
                return cacheDivViewCreator();
            }
            throw new AssertionError();
        }

        DivViewIdProvider cacheDivViewIdProvider() {
            Object divViewIdProvider = this.mDivViewIdProviderInstance;
            if (divViewIdProvider == null) {
                ThreadAssertions.assertThreadAccess();
                divViewIdProvider = new DivViewIdProvider();
                this.mDivViewIdProviderInstance = divViewIdProvider;
            }
            return (DivViewIdProvider) divViewIdProvider;
        }

        ErrorCollectors cacheErrorCollectors() {
            Object errorCollectors = this.mErrorCollectorsInstance;
            if (errorCollectors == null) {
                ThreadAssertions.assertThreadAccess();
                errorCollectors = new ErrorCollectors();
                this.mErrorCollectorsInstance = errorCollectors;
            }
            return (ErrorCollectors) errorCollectors;
        }

        DivTooltipController cacheDivTooltipController() {
            Object divTooltipController = this.mDivTooltipControllerInstance;
            if (divTooltipController == null) {
                ThreadAssertions.assertThreadAccess();
                divTooltipController = new DivTooltipController((DivTooltipRestrictor) Checks.checkProvisionNotNull(this.mDivConfiguration.getTooltipRestrictor()), cacheDivVisibilityActionTracker(), cacheDivPreloader(), new DivTooltipViewBuilder(new ProviderImpl(this, 1)), cacheAccessibilityStateProvider(), cacheErrorCollectors());
                this.mDivTooltipControllerInstance = divTooltipController;
            }
            return (DivTooltipController) divTooltipController;
        }

        DivRuntimeVisitor cacheDivRuntimeVisitor() {
            Object divRuntimeVisitor = this.mDivRuntimeVisitorInstance;
            if (divRuntimeVisitor == null) {
                ThreadAssertions.assertThreadAccess();
                divRuntimeVisitor = new DivRuntimeVisitor((DivStateCache) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivStateCache()), cacheTemporaryDivStateCache(), cacheTabsStateCache());
                this.mDivRuntimeVisitorInstance = divRuntimeVisitor;
            }
            return (DivRuntimeVisitor) divRuntimeVisitor;
        }

        DivExtensionController cacheDivExtensionController() {
            Object divExtensionController = this.mDivExtensionControllerInstance;
            if (divExtensionController == null) {
                ThreadAssertions.assertThreadAccess();
                divExtensionController = new DivExtensionController((List) Checks.checkProvisionNotNull(this.mDivConfiguration.getExtensionHandlers()));
                this.mDivExtensionControllerInstance = divExtensionController;
            }
            return (DivExtensionController) divExtensionController;
        }

        DivBinder cacheDivBinder() {
            Object divBinder = this.mDivBinderInstance;
            if (divBinder == null) {
                ThreadAssertions.assertThreadAccess();
                divBinder = new DivBinder(cacheDivValidator(), new DivTextBinder(cacheDivBaseBinder(), cacheDivTypefaceResolver(), new SpannedTextBuilder(cacheDivTypefaceResolver(), (DivImageLoader) Checks.checkProvisionNotNull(this.mDivConfiguration.getImageLoader())), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isHyphenationSupported()))).booleanValue()), new DivContainerBinder(cacheDivBaseBinder(), new ProviderImpl(this, 2), cacheDivPatchManager(), new ProviderImpl(this, 0), cacheErrorCollectors()), new DivSeparatorBinder(cacheDivBaseBinder()), new DivImageBinder(cacheDivBaseBinder(), (DivImageLoader) Checks.checkProvisionNotNull(this.mDivConfiguration.getImageLoader()), cacheDivPlaceholderLoader(), cacheErrorCollectors()), new DivGifImageBinder(cacheDivBaseBinder(), (DivImageLoader) Checks.checkProvisionNotNull(this.mDivConfiguration.getImageLoader()), cacheDivPlaceholderLoader(), cacheErrorCollectors()), new DivGridBinder(cacheDivBaseBinder(), cacheDivPatchManager(), new ProviderImpl(this, 0), new ProviderImpl(this, 2)), new DivGalleryBinder(cacheDivBaseBinder(), cacheDivViewCreator(), new ProviderImpl(this, 0), cacheDivPatchCache(), ((Float) Checks.checkProvisionNotNull(Float.valueOf(this.mDivConfiguration.getRecyclerScrollInterceptionAngle()))).floatValue()), new DivPagerBinder(cacheDivBaseBinder(), cacheDivViewCreator(), new ProviderImpl(this, 0), cacheDivPatchCache(), cacheDivActionBinder(), cachePagerIndicatorConnector(), cacheAccessibilityStateProvider()), new DivTabsBinder(cacheDivBaseBinder(), cacheDivViewCreator(), cacheViewPool(), (TabTextStyleProvider) Checks.checkProvisionNotNull(Div2Module.provideTabTextStyleProvider((DivTypefaceProvider) Checks.checkProvisionNotNull(this.mDivConfiguration.getTypefaceProvider()))), cacheDivActionBinder(), (Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger()), (DivImageLoader) Checks.checkProvisionNotNull(this.mDivConfiguration.getImageLoader()), cacheDivVisibilityActionTracker(), cacheDivPatchCache(), cacheJavaxInjectNamedValueThemedContextContext(), cacheDivRuntimeVisitor(), cacheTabsStateCache()), new DivStateBinder(cacheDivBaseBinder(), cacheDivViewCreator(), new ProviderImpl(this, 0), (DivStateCache) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivStateCache()), cacheTemporaryDivStateCache(), cacheDivActionBinder(), cacheDivActionBeaconSender(), cacheDivPatchManager(), cacheDivPatchCache(), (Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger()), cacheDivVisibilityActionTracker(), cacheErrorCollectors(), cacheTwoWayStringVariableBinder(), cacheDivRuntimeVisitor()), new DivCustomBinder(cacheDivBaseBinder(), (DivCustomContainerViewAdapter) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivCustomContainerViewAdapter()), cacheDivExtensionController(), new ProviderImpl(this, 0)), new DivIndicatorBinder(cacheDivBaseBinder(), cachePagerIndicatorConnector()), new DivSliderBinder(cacheDivBaseBinder(), (Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger()), (DivTypefaceProvider) Checks.checkProvisionNotNull(this.mDivConfiguration.getTypefaceProvider()), cacheTwoWayIntegerVariableBinder(), cacheErrorCollectors(), ((Float) Checks.checkProvisionNotNull(Float.valueOf(this.mDivConfiguration.getRecyclerScrollInterceptionAngle()))).floatValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.getAreVisualErrorsEnabled()))).booleanValue()), new DivInputBinder(cacheDivBaseBinder(), cacheDivTypefaceResolver(), cacheTwoWayStringVariableBinder(), cacheDivActionBinder(), cacheAccessibilityStateProvider(), cacheErrorCollectors()), new DivSelectBinder(cacheDivBaseBinder(), cacheDivTypefaceResolver(), cacheTwoWayStringVariableBinder(), cacheErrorCollectors()), new DivVideoBinder(cacheDivBaseBinder(), cacheTwoWayIntegerVariableBinder(), cacheDivActionBinder(), cacheDivVideoViewMapper(), (ExecutorService) Checks.checkProvisionNotNull(this.mDivKitComponent.mDivKitConfiguration.getExecutorService()), (DivPlayerFactory) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivPlayerFactory())), cacheDivExtensionController(), cachePagerIndicatorConnector(), new DivSwitchBinder(cacheDivBaseBinder(), new TwoWayBooleanVariableBinder(cacheErrorCollectors(), cacheExpressionsRuntimeProvider())));
                this.mDivBinderInstance = divBinder;
            }
            return (DivBinder) divBinder;
        }

        Div2Builder cacheDiv2Builder() {
            Object div2Builder = this.mDiv2BuilderInstance;
            if (div2Builder == null) {
                ThreadAssertions.assertThreadAccess();
                div2Builder = new Div2Builder(cacheDivViewCreator(), cacheDivBinder(), cacheDivRuntimeVisitor());
                this.mDiv2BuilderInstance = div2Builder;
            }
            return (Div2Builder) div2Builder;
        }

        DivViewCreator cacheDivViewCreator() {
            Object divViewCreator = this.mDivViewCreatorInstance;
            if (divViewCreator == null) {
                ThreadAssertions.assertThreadAccess();
                divViewCreator = new DivViewCreator(cacheJavaxInjectNamedValueThemedContextContext(), cacheViewPool(), cacheDivValidator(), (ViewPreCreationProfile) Checks.checkProvisionNotNull(this.mDivConfiguration.getViewPreCreationProfile()), cacheViewPreCreationProfileRepository());
                this.mDivViewCreatorInstance = divViewCreator;
            }
            return (DivViewCreator) divViewCreator;
        }

        DivImagePreloader cacheDivImagePreloader() {
            Object divImagePreloader = this.mDivImagePreloaderInstance;
            if (divImagePreloader == null) {
                ThreadAssertions.assertThreadAccess();
                divImagePreloader = new DivImagePreloader((DivImageLoader) Checks.checkProvisionNotNull(this.mDivConfiguration.getImageLoader()));
                this.mDivImagePreloaderInstance = divImagePreloader;
            }
            return (DivImagePreloader) divImagePreloader;
        }

        DivPreloader cacheDivPreloader() {
            Object objCheckProvisionNotNull = this.mDivPreloaderInstance;
            if (objCheckProvisionNotNull == null) {
                ThreadAssertions.assertThreadAccess();
                objCheckProvisionNotNull = Checks.checkProvisionNotNull(Div2Module.provideDivPreloader(cacheDivImagePreloader(), (DivCustomContainerViewAdapter) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivCustomContainerViewAdapter()), (DivPlayerPreloader) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivPlayerPreloader()), cacheDivExtensionController()));
                this.mDivPreloaderInstance = objCheckProvisionNotNull;
            }
            return (DivPreloader) objCheckProvisionNotNull;
        }

        DivVisibilityActionTracker cacheDivVisibilityActionTracker() {
            Object divVisibilityActionTracker = this.mDivVisibilityActionTrackerInstance;
            if (divVisibilityActionTracker == null) {
                ThreadAssertions.assertThreadAccess();
                divVisibilityActionTracker = new DivVisibilityActionTracker(new ViewVisibilityCalculator(), cacheDivVisibilityActionDispatcher());
                this.mDivVisibilityActionTrackerInstance = divVisibilityActionTracker;
            }
            return (DivVisibilityActionTracker) divVisibilityActionTracker;
        }

        DivVisibilityActionDispatcher cacheDivVisibilityActionDispatcher() {
            Object divVisibilityActionDispatcher = this.mDivVisibilityActionDispatcherInstance;
            if (divVisibilityActionDispatcher == null) {
                ThreadAssertions.assertThreadAccess();
                divVisibilityActionDispatcher = new DivVisibilityActionDispatcher((Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger()), (List) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivVisibilityChangeListeners()), (DivActionHandler) Checks.checkProvisionNotNull(this.mDivConfiguration.getActionHandler()), cacheDivActionBeaconSender());
                this.mDivVisibilityActionDispatcherInstance = divVisibilityActionDispatcher;
            }
            return (DivVisibilityActionDispatcher) divVisibilityActionDispatcher;
        }

        DivActionBinder cacheDivActionBinder() {
            Object divActionBinder = this.mDivActionBinderInstance;
            if (divActionBinder == null) {
                ThreadAssertions.assertThreadAccess();
                divActionBinder = new DivActionBinder((DivActionHandler) Checks.checkProvisionNotNull(this.mDivConfiguration.getActionHandler()), (Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger()), cacheDivActionBeaconSender(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isLongtapActionsPassToChild()))).booleanValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isContextMenuHandlerOverridden()))).booleanValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isAccessibilityEnabled()))).booleanValue());
                this.mDivActionBinderInstance = divActionBinder;
            }
            return (DivActionBinder) divActionBinder;
        }

        TemporaryDivStateCache cacheTemporaryDivStateCache() {
            Object temporaryDivStateCache = this.mTemporaryDivStateCacheInstance;
            if (temporaryDivStateCache == null) {
                ThreadAssertions.assertThreadAccess();
                temporaryDivStateCache = new TemporaryDivStateCache();
                this.mTemporaryDivStateCacheInstance = temporaryDivStateCache;
            }
            return (TemporaryDivStateCache) temporaryDivStateCache;
        }

        TabsStateCache cacheTabsStateCache() {
            Object tabsStateCache = this.mTabsStateCacheInstance;
            if (tabsStateCache == null) {
                ThreadAssertions.assertThreadAccess();
                tabsStateCache = new TabsStateCache();
                this.mTabsStateCacheInstance = tabsStateCache;
            }
            return (TabsStateCache) tabsStateCache;
        }

        ExpressionsRuntimeProvider cacheExpressionsRuntimeProvider() {
            Object expressionsRuntimeProvider = this.mExpressionsRuntimeProviderInstance;
            if (expressionsRuntimeProvider == null) {
                ThreadAssertions.assertThreadAccess();
                expressionsRuntimeProvider = new ExpressionsRuntimeProvider(this.mDivVariableController, cacheDivActionBinder(), cacheErrorCollectors(), (Div2Logger) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2Logger()), cacheStoredValuesController());
                this.mExpressionsRuntimeProviderInstance = expressionsRuntimeProvider;
            }
            return (ExpressionsRuntimeProvider) expressionsRuntimeProvider;
        }

        DivTimerEventDispatcherProvider cacheDivTimerEventDispatcherProvider() {
            Object divTimerEventDispatcherProvider = this.mDivTimerEventDispatcherProviderInstance;
            if (divTimerEventDispatcherProvider == null) {
                ThreadAssertions.assertThreadAccess();
                divTimerEventDispatcherProvider = new DivTimerEventDispatcherProvider(cacheDivActionBinder(), cacheErrorCollectors());
                this.mDivTimerEventDispatcherProviderInstance = divTimerEventDispatcherProvider;
            }
            return (DivTimerEventDispatcherProvider) divTimerEventDispatcherProvider;
        }

        DivVideoActionHandler cacheDivVideoActionHandler() {
            Object divVideoActionHandler = this.mDivVideoActionHandlerInstance;
            if (divVideoActionHandler == null) {
                ThreadAssertions.assertThreadAccess();
                divVideoActionHandler = new DivVideoActionHandler(cacheDivVideoViewMapper());
                this.mDivVideoActionHandlerInstance = divVideoActionHandler;
            }
            return (DivVideoActionHandler) divVideoActionHandler;
        }

        DivVideoViewMapper cacheDivVideoViewMapper() {
            Object divVideoViewMapper = this.mDivVideoViewMapperInstance;
            if (divVideoViewMapper == null) {
                ThreadAssertions.assertThreadAccess();
                divVideoViewMapper = new DivVideoViewMapper();
                this.mDivVideoViewMapperInstance = divVideoViewMapper;
            }
            return (DivVideoViewMapper) divVideoViewMapper;
        }

        DivStateManager cacheDivStateManager() {
            Object divStateManager = this.mDivStateManagerInstance;
            if (divStateManager == null) {
                ThreadAssertions.assertThreadAccess();
                divStateManager = new DivStateManager((DivStateCache) Checks.checkProvisionNotNull(this.mDivConfiguration.getDivStateCache()), cacheTemporaryDivStateCache());
                this.mDivStateManagerInstance = divStateManager;
            }
            return (DivStateManager) divStateManager;
        }

        DivPatchManager cacheDivPatchManager() {
            Object divPatchManager = this.mDivPatchManagerInstance;
            if (divPatchManager == null) {
                ThreadAssertions.assertThreadAccess();
                divPatchManager = new DivPatchManager(cacheDivPatchCache(), new ProviderImpl(this, 1));
                this.mDivPatchManagerInstance = divPatchManager;
            }
            return (DivPatchManager) divPatchManager;
        }

        PerformanceDependentSessionProfiler cachePerformanceDependentSessionProfiler() {
            Object performanceDependentSessionProfiler = this.mPerformanceDependentSessionProfilerInstance;
            if (performanceDependentSessionProfiler == null) {
                ThreadAssertions.assertThreadAccess();
                performanceDependentSessionProfiler = new PerformanceDependentSessionProfiler(((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isDebuggingViewPoolOptimization()))).booleanValue());
                this.mPerformanceDependentSessionProfilerInstance = performanceDependentSessionProfiler;
            }
            return (PerformanceDependentSessionProfiler) performanceDependentSessionProfiler;
        }

        ViewPreCreationProfileRepository cacheViewPreCreationProfileRepository() {
            Object viewPreCreationProfileRepository = this.mViewPreCreationProfileRepositoryInstance;
            if (viewPreCreationProfileRepository == null) {
                ThreadAssertions.assertThreadAccess();
                viewPreCreationProfileRepository = new ViewPreCreationProfileRepository(this.mDivKitComponent.mApplicationContext, (ViewPreCreationProfile) Checks.checkProvisionNotNull(this.mDivConfiguration.getViewPreCreationProfile()));
                this.mViewPreCreationProfileRepositoryInstance = viewPreCreationProfileRepository;
            }
            return (ViewPreCreationProfileRepository) viewPreCreationProfileRepository;
        }

        HistogramReporter cacheHistogramReporter() {
            Object objCheckProvisionNotNull = this.mHistogramReporterInstance;
            if (objCheckProvisionNotNull == null) {
                ThreadAssertions.assertThreadAccess();
                objCheckProvisionNotNull = Checks.checkProvisionNotNull(DivHistogramsModule.INSTANCE.provideHistogramReporter(this.mDivKitComponent.accessHistogramReporterDelegate()));
                this.mHistogramReporterInstance = objCheckProvisionNotNull;
            }
            return (HistogramReporter) objCheckProvisionNotNull;
        }

        RenderScript cacheRenderScript() {
            Object objCheckProvisionNotNull = this.mRenderScriptInstance;
            if (objCheckProvisionNotNull == null) {
                ThreadAssertions.assertThreadAccess();
                objCheckProvisionNotNull = Checks.checkProvisionNotNull(Div2Module.provideRenderScript(this.mBaseContext));
                this.mRenderScriptInstance = objCheckProvisionNotNull;
            }
            return (RenderScript) objCheckProvisionNotNull;
        }

        ReleaseManager cacheReleaseManager() {
            Object releaseManager = this.mReleaseManagerInstance;
            if (releaseManager == null) {
                ThreadAssertions.assertThreadAccess();
                releaseManager = new ReleaseManager(cacheExpressionsRuntimeProvider());
                this.mReleaseManagerInstance = releaseManager;
            }
            return (ReleaseManager) releaseManager;
        }

        StoredValuesController cacheStoredValuesController() {
            Object storedValuesController = this.mStoredValuesControllerInstance;
            if (storedValuesController == null) {
                ThreadAssertions.assertThreadAccess();
                storedValuesController = new StoredValuesController(new ProviderImpl(this.mDivKitComponent, 1));
                this.mStoredValuesControllerInstance = storedValuesController;
            }
            return (StoredValuesController) storedValuesController;
        }

        BitmapEffectHelper cacheBitmapEffectHelper() {
            Object bitmapEffectHelper = this.mBitmapEffectHelperInstance;
            if (bitmapEffectHelper == null) {
                ThreadAssertions.assertThreadAccess();
                bitmapEffectHelper = new BitmapEffectHelper(cacheRenderScript());
                this.mBitmapEffectHelperInstance = bitmapEffectHelper;
            }
            return (BitmapEffectHelper) bitmapEffectHelper;
        }

        AccessibilityStateProvider cacheAccessibilityStateProvider() {
            Object accessibilityStateProvider = this.mAccessibilityStateProviderInstance;
            if (accessibilityStateProvider == null) {
                ThreadAssertions.assertThreadAccess();
                accessibilityStateProvider = new AccessibilityStateProvider(((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isAccessibilityEnabled()))).booleanValue());
                this.mAccessibilityStateProviderInstance = accessibilityStateProvider;
            }
            return (AccessibilityStateProvider) accessibilityStateProvider;
        }

        DivValidator cacheDivValidator() {
            Object divValidator = this.mDivValidatorInstance;
            if (divValidator == null) {
                ThreadAssertions.assertThreadAccess();
                divValidator = new DivValidator();
                this.mDivValidatorInstance = divValidator;
            }
            return (DivValidator) divValidator;
        }

        PagerIndicatorConnector cachePagerIndicatorConnector() {
            Object pagerIndicatorConnector = this.mPagerIndicatorConnectorInstance;
            if (pagerIndicatorConnector == null) {
                ThreadAssertions.assertThreadAccess();
                pagerIndicatorConnector = new PagerIndicatorConnector();
                this.mPagerIndicatorConnectorInstance = pagerIndicatorConnector;
            }
            return (PagerIndicatorConnector) pagerIndicatorConnector;
        }

        Context cacheJavaxInjectNamedValueThemedContextContext() {
            Object objCheckProvisionNotNull = this.mJavaxInjectNamedValueThemedContextContextInstance;
            if (objCheckProvisionNotNull == null) {
                ThreadAssertions.assertThreadAccess();
                objCheckProvisionNotNull = Checks.checkProvisionNotNull(Div2Module.provideThemedContext(this.mBaseContext, this.mThemeId.intValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isResourceCacheEnabled()))).booleanValue()));
                this.mJavaxInjectNamedValueThemedContextContextInstance = objCheckProvisionNotNull;
            }
            return (Context) objCheckProvisionNotNull;
        }

        ViewPool cacheViewPool() {
            Object objCheckProvisionNotNull = this.mViewPoolInstance;
            if (objCheckProvisionNotNull == null) {
                ThreadAssertions.assertThreadAccess();
                objCheckProvisionNotNull = Checks.checkProvisionNotNull(Div2Module.provideViewPool(((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isViewPoolEnabled()))).booleanValue(), (ExternalOptional) Checks.checkProvisionNotNull(Div2Module.provideViewPoolProfiler(((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isViewPoolProfilingEnabled()))).booleanValue(), (ViewPoolProfiler.Reporter) Checks.checkProvisionNotNull(this.mDivConfiguration.getViewPoolReporter()))), cachePerformanceDependentSessionProfiler(), this.mDivKitComponent.cacheViewCreator()));
                this.mViewPoolInstance = objCheckProvisionNotNull;
            }
            return (ViewPool) objCheckProvisionNotNull;
        }

        DivActionBeaconSender cacheDivActionBeaconSender() {
            Object divActionBeaconSender = this.mDivActionBeaconSenderInstance;
            if (divActionBeaconSender == null) {
                ThreadAssertions.assertThreadAccess();
                divActionBeaconSender = new DivActionBeaconSender(new ProviderImpl(this.mDivKitComponent, 3), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isTapBeaconsEnabled()))).booleanValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isVisibilityBeaconsEnabled()))).booleanValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isSwipeOutBeaconsEnabled()))).booleanValue());
                this.mDivActionBeaconSenderInstance = divActionBeaconSender;
            }
            return (DivActionBeaconSender) divActionBeaconSender;
        }

        DivPatchCache cacheDivPatchCache() {
            Object divPatchCache = this.mDivPatchCacheInstance;
            if (divPatchCache == null) {
                ThreadAssertions.assertThreadAccess();
                divPatchCache = new DivPatchCache();
                this.mDivPatchCacheInstance = divPatchCache;
            }
            return (DivPatchCache) divPatchCache;
        }

        DivBaseBinder cacheDivBaseBinder() {
            Object divBaseBinder = this.mDivBaseBinderInstance;
            if (divBaseBinder == null) {
                ThreadAssertions.assertThreadAccess();
                divBaseBinder = new DivBaseBinder(new DivBackgroundBinder((DivImageLoader) Checks.checkProvisionNotNull(this.mDivConfiguration.getImageLoader())), cacheDivTooltipController(), new DivFocusBinder(cacheDivActionBinder()), new DivAccessibilityBinder(((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDivConfiguration.isAccessibilityEnabled()))).booleanValue(), cacheAccessibilityStateProvider()));
                this.mDivBaseBinderInstance = divBaseBinder;
            }
            return (DivBaseBinder) divBaseBinder;
        }

        DivTypefaceResolver cacheDivTypefaceResolver() {
            Object divTypefaceResolver = this.mDivTypefaceResolverInstance;
            if (divTypefaceResolver == null) {
                ThreadAssertions.assertThreadAccess();
                divTypefaceResolver = new DivTypefaceResolver((Map) Checks.checkProvisionNotNull(this.mDivConfiguration.getAdditionalTypefaceProviders()), (DivTypefaceProvider) Checks.checkProvisionNotNull(this.mDivConfiguration.getTypefaceProvider()));
                this.mDivTypefaceResolverInstance = divTypefaceResolver;
            }
            return (DivTypefaceResolver) divTypefaceResolver;
        }

        DivPlaceholderLoader cacheDivPlaceholderLoader() {
            Object divPlaceholderLoader = this.mDivPlaceholderLoaderInstance;
            if (divPlaceholderLoader == null) {
                ThreadAssertions.assertThreadAccess();
                divPlaceholderLoader = new DivPlaceholderLoader((Div2ImageStubProvider) Checks.checkProvisionNotNull(this.mDivConfiguration.getDiv2ImageStubProvider()), (ExecutorService) Checks.checkProvisionNotNull(this.mDivKitComponent.mDivKitConfiguration.getExecutorService()));
                this.mDivPlaceholderLoaderInstance = divPlaceholderLoader;
            }
            return (DivPlaceholderLoader) divPlaceholderLoader;
        }

        TwoWayStringVariableBinder cacheTwoWayStringVariableBinder() {
            Object twoWayStringVariableBinder = this.mTwoWayStringVariableBinderInstance;
            if (twoWayStringVariableBinder == null) {
                ThreadAssertions.assertThreadAccess();
                twoWayStringVariableBinder = new TwoWayStringVariableBinder(cacheErrorCollectors(), cacheExpressionsRuntimeProvider());
                this.mTwoWayStringVariableBinderInstance = twoWayStringVariableBinder;
            }
            return (TwoWayStringVariableBinder) twoWayStringVariableBinder;
        }

        TwoWayIntegerVariableBinder cacheTwoWayIntegerVariableBinder() {
            Object twoWayIntegerVariableBinder = this.mTwoWayIntegerVariableBinderInstance;
            if (twoWayIntegerVariableBinder == null) {
                ThreadAssertions.assertThreadAccess();
                twoWayIntegerVariableBinder = new TwoWayIntegerVariableBinder(cacheErrorCollectors(), cacheExpressionsRuntimeProvider());
                this.mTwoWayIntegerVariableBinderInstance = twoWayIntegerVariableBinder;
            }
            return (TwoWayIntegerVariableBinder) twoWayIntegerVariableBinder;
        }

        /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
        static final class Div2ViewComponentImpl implements Div2ViewComponent {
            final Div2ComponentImpl mDiv2Component;
            private Object mDivAnimatorControllerInstance;
            private Object mDivStateSwitcherInstance;
            private Object mDivStateTransitionHolderInstance;
            private Object mDivTransitionBuilderInstance;
            final Div2View mDivView;
            private Object mErrorVisualMonitorInstance;
            private Object mInputFocusTrackerInstance;
            private Object mMediaReleaseViewVisitorInstance;
            private Object mReleaseViewVisitorInstance;
            private Object mViewBindingProviderInstance;

            Div2ViewComponentImpl(Div2ComponentImpl div2ComponentImpl, Div2View div2View) {
                this.mDiv2Component = div2ComponentImpl;
                this.mDivView = (Div2View) Checks.checkInputNotNull(div2View);
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivViewIdProvider getViewIdProvider() {
                return this.mDiv2Component.cacheDivViewIdProvider();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivTransitionBuilder getTransitionBuilder() {
                return cacheDivTransitionBuilder();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public ReleaseViewVisitor getReleaseViewVisitor() {
                return cacheReleaseViewVisitor();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public MediaReleaseViewVisitor getMediaReleaseViewVisitor() {
                return cacheMediaReleaseViewVisitor();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivStateSwitcher getStateSwitcher() {
                return cacheDivStateSwitcher();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivStateTransitionHolder getStateTransitionHolder() {
                return cacheDivStateTransitionHolder();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public ErrorVisualMonitor getErrorMonitor() {
                return cacheErrorVisualMonitor();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public ViewBindingProvider getBindingProvider() {
                return cacheViewBindingProvider();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public ErrorCollectors getErrorCollectors() {
                return this.mDiv2Component.cacheErrorCollectors();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public InputFocusTracker getInputFocusTracker() {
                return cacheInputFocusTracker();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivAnimatorController getAnimatorController() {
                return cacheDivAnimatorController();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivTooltipController getDivTooltipController() {
                return this.mDiv2Component.cacheDivTooltipController();
            }

            @Override // com.yandex.div.core.dagger.Div2ViewComponent
            public DivRuntimeVisitor getRuntimeVisitor() {
                return this.mDiv2Component.cacheDivRuntimeVisitor();
            }

            Object switch$$access(int i) {
                if (i == 0) {
                    return new DivJoinedStateSwitcher(this.mDivView, this.mDiv2Component.cacheDivBinder());
                }
                if (i == 1) {
                    return new DivMultipleStateSwitcher(this.mDivView, this.mDiv2Component.cacheDivBinder());
                }
                throw new AssertionError();
            }

            DivTransitionBuilder cacheDivTransitionBuilder() {
                Object divTransitionBuilder = this.mDivTransitionBuilderInstance;
                if (divTransitionBuilder == null) {
                    ThreadAssertions.assertThreadAccess();
                    divTransitionBuilder = new DivTransitionBuilder(this.mDiv2Component.mBaseContext, this.mDiv2Component.cacheDivViewIdProvider());
                    this.mDivTransitionBuilderInstance = divTransitionBuilder;
                }
                return (DivTransitionBuilder) divTransitionBuilder;
            }

            ReleaseViewVisitor cacheReleaseViewVisitor() {
                Object releaseViewVisitor = this.mReleaseViewVisitorInstance;
                if (releaseViewVisitor == null) {
                    ThreadAssertions.assertThreadAccess();
                    releaseViewVisitor = new ReleaseViewVisitor(this.mDivView, (DivCustomContainerViewAdapter) Checks.checkProvisionNotNull(this.mDiv2Component.mDivConfiguration.getDivCustomContainerViewAdapter()), this.mDiv2Component.cacheDivExtensionController());
                    this.mReleaseViewVisitorInstance = releaseViewVisitor;
                }
                return (ReleaseViewVisitor) releaseViewVisitor;
            }

            MediaReleaseViewVisitor cacheMediaReleaseViewVisitor() {
                Object mediaReleaseViewVisitor = this.mMediaReleaseViewVisitorInstance;
                if (mediaReleaseViewVisitor == null) {
                    ThreadAssertions.assertThreadAccess();
                    mediaReleaseViewVisitor = new MediaReleaseViewVisitor();
                    this.mMediaReleaseViewVisitorInstance = mediaReleaseViewVisitor;
                }
                return (MediaReleaseViewVisitor) mediaReleaseViewVisitor;
            }

            DivStateSwitcher cacheDivStateSwitcher() {
                Object objCheckProvisionNotNull = this.mDivStateSwitcherInstance;
                if (objCheckProvisionNotNull == null) {
                    ThreadAssertions.assertThreadAccess();
                    Div2ViewModule div2ViewModule = Div2ViewModule.INSTANCE;
                    objCheckProvisionNotNull = Checks.checkProvisionNotNull(Div2ViewModule.provideStateSwitcher(((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDiv2Component.mDivConfiguration.isMultipleStateChangeEnabled()))).booleanValue(), new CachingProviderImpl(this, 0), new CachingProviderImpl(this, 1)));
                    this.mDivStateSwitcherInstance = objCheckProvisionNotNull;
                }
                return (DivStateSwitcher) objCheckProvisionNotNull;
            }

            DivStateTransitionHolder cacheDivStateTransitionHolder() {
                Object divStateTransitionHolder = this.mDivStateTransitionHolderInstance;
                if (divStateTransitionHolder == null) {
                    ThreadAssertions.assertThreadAccess();
                    divStateTransitionHolder = new DivStateTransitionHolder(this.mDivView);
                    this.mDivStateTransitionHolderInstance = divStateTransitionHolder;
                }
                return (DivStateTransitionHolder) divStateTransitionHolder;
            }

            ErrorVisualMonitor cacheErrorVisualMonitor() {
                Object errorVisualMonitor = this.mErrorVisualMonitorInstance;
                if (errorVisualMonitor == null) {
                    ThreadAssertions.assertThreadAccess();
                    errorVisualMonitor = new ErrorVisualMonitor(this.mDiv2Component.cacheErrorCollectors(), this.mDivView, ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDiv2Component.mDivConfiguration.getAreVisualErrorsEnabled()))).booleanValue(), ((Boolean) Checks.checkProvisionNotNull(Boolean.valueOf(this.mDiv2Component.mDivConfiguration.isPermanentDebugPanelEnabled()))).booleanValue(), cacheViewBindingProvider());
                    this.mErrorVisualMonitorInstance = errorVisualMonitor;
                }
                return (ErrorVisualMonitor) errorVisualMonitor;
            }

            ViewBindingProvider cacheViewBindingProvider() {
                Object viewBindingProvider = this.mViewBindingProviderInstance;
                if (viewBindingProvider == null) {
                    ThreadAssertions.assertThreadAccess();
                    viewBindingProvider = new ViewBindingProvider();
                    this.mViewBindingProviderInstance = viewBindingProvider;
                }
                return (ViewBindingProvider) viewBindingProvider;
            }

            InputFocusTracker cacheInputFocusTracker() {
                Object inputFocusTracker = this.mInputFocusTrackerInstance;
                if (inputFocusTracker == null) {
                    ThreadAssertions.assertThreadAccess();
                    inputFocusTracker = new InputFocusTracker(this.mDivView);
                    this.mInputFocusTrackerInstance = inputFocusTracker;
                }
                return (InputFocusTracker) inputFocusTracker;
            }

            DivAnimatorController cacheDivAnimatorController() {
                Object divAnimatorController = this.mDivAnimatorControllerInstance;
                if (divAnimatorController == null) {
                    ThreadAssertions.assertThreadAccess();
                    divAnimatorController = new DivAnimatorController(this.mDivView);
                    this.mDivAnimatorControllerInstance = divAnimatorController;
                }
                return (DivAnimatorController) divAnimatorController;
            }

            /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
            private static final class CachingProviderImpl implements Lazy {
                private final Div2ViewComponentImpl mDelegate;
                private final int mIndex;
                private Object mValue;

                CachingProviderImpl(Div2ViewComponentImpl div2ViewComponentImpl, int i) {
                    this.mDelegate = div2ViewComponentImpl;
                    this.mIndex = i;
                }

                @Override // javax.inject.Provider
                public Object get() {
                    Object obj = this.mValue;
                    if (obj != null) {
                        return obj;
                    }
                    ThreadAssertions.assertThreadAccess();
                    Object objSwitch$$access = this.mDelegate.switch$$access(this.mIndex);
                    this.mValue = objSwitch$$access;
                    return objSwitch$$access;
                }
            }

            /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
            private static final class ComponentFactoryImpl implements Div2ViewComponent.Builder {
                Div2ComponentImpl fDiv2Component;
                private Div2View mDivView;

                ComponentFactoryImpl(Div2ComponentImpl div2ComponentImpl) {
                    this.fDiv2Component = div2ComponentImpl;
                }

                @Override // com.yandex.div.core.dagger.Div2ViewComponent.Builder
                public Div2ViewComponent.Builder divView(Div2View div2View) {
                    this.mDivView = div2View;
                    return this;
                }

                @Override // com.yandex.div.core.dagger.Div2ViewComponent.Builder
                public Div2ViewComponent build() {
                    return new Div2ViewComponentImpl(this.fDiv2Component, this.mDivView);
                }
            }
        }

        /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
        static final class ProviderImpl implements Lazy {
            private final Div2ComponentImpl mDelegate;
            private final int mIndex;

            ProviderImpl(Div2ComponentImpl div2ComponentImpl, int i) {
                this.mDelegate = div2ComponentImpl;
                this.mIndex = i;
            }

            @Override // javax.inject.Provider
            public Object get() {
                return this.mDelegate.switch$$access(this.mIndex);
            }
        }

        /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
        private static final class ComponentFactoryImpl implements Div2Component.Builder {
            Yatagan$DivKitComponent fDivKitComponent;
            private ContextThemeWrapper mBaseContext;
            private DivConfiguration mConfiguration;
            private DivCreationTracker mDivCreationTracker;
            private DivVariableController mDivVariableController;
            private Integer mThemeId;

            ComponentFactoryImpl(Yatagan$DivKitComponent yatagan$DivKitComponent) {
                this.fDivKitComponent = yatagan$DivKitComponent;
            }

            @Override // com.yandex.div.core.dagger.Div2Component.Builder
            public Div2Component.Builder baseContext(ContextThemeWrapper contextThemeWrapper) {
                this.mBaseContext = contextThemeWrapper;
                return this;
            }

            @Override // com.yandex.div.core.dagger.Div2Component.Builder
            public Div2Component.Builder configuration(DivConfiguration divConfiguration) {
                this.mConfiguration = divConfiguration;
                return this;
            }

            @Override // com.yandex.div.core.dagger.Div2Component.Builder
            public Div2Component.Builder themeId(int i) {
                this.mThemeId = Integer.valueOf(i);
                return this;
            }

            @Override // com.yandex.div.core.dagger.Div2Component.Builder
            public Div2Component.Builder divCreationTracker(DivCreationTracker divCreationTracker) {
                this.mDivCreationTracker = divCreationTracker;
                return this;
            }

            @Override // com.yandex.div.core.dagger.Div2Component.Builder
            public Div2Component.Builder divVariableController(DivVariableController divVariableController) {
                this.mDivVariableController = divVariableController;
                return this;
            }

            @Override // com.yandex.div.core.dagger.Div2Component.Builder
            public Div2Component build() {
                return new Div2ComponentImpl(this.fDivKitComponent, this.mBaseContext, this.mConfiguration, this.mThemeId, this.mDivCreationTracker, this.mDivVariableController);
            }
        }
    }

    /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
    private static final class UninitializedLock {
        private UninitializedLock() {
        }
    }

    /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
    static final class ProviderImpl implements Lazy {
        private final Yatagan$DivKitComponent mDelegate;
        private final int mIndex;

        ProviderImpl(Yatagan$DivKitComponent yatagan$DivKitComponent, int i) {
            this.mDelegate = yatagan$DivKitComponent;
            this.mIndex = i;
        }

        @Override // javax.inject.Provider
        public Object get() {
            return this.mDelegate.switch$$access(this.mIndex);
        }
    }

    /* JADX INFO: compiled from: Yatagan$DivKitComponent.java */
    private static final class ComponentFactoryImpl implements DivKitComponent.Builder {
        private Context mApplicationContext;
        private DivKitConfiguration mConfiguration;

        private ComponentFactoryImpl() {
        }

        @Override // com.yandex.div.core.dagger.DivKitComponent.Builder
        public DivKitComponent.Builder applicationContext(Context context) {
            this.mApplicationContext = context;
            return this;
        }

        @Override // com.yandex.div.core.dagger.DivKitComponent.Builder
        public DivKitComponent.Builder configuration(DivKitConfiguration divKitConfiguration) {
            this.mConfiguration = divKitConfiguration;
            return this;
        }

        @Override // com.yandex.div.core.dagger.DivKitComponent.Builder
        public DivKitComponent build() {
            return new Yatagan$DivKitComponent(this.mApplicationContext, this.mConfiguration);
        }
    }
}
