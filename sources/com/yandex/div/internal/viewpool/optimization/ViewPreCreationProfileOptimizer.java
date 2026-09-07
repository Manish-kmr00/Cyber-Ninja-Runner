package com.yandex.div.internal.viewpool.optimization;

import com.google.android.gms.common.Scopes;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.Log;
import com.yandex.div.internal.viewpool.PreCreationModel;
import com.yandex.div.internal.viewpool.ViewPreCreationProfile;
import com.yandex.div.logging.Severity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ViewPreCreationProfileOptimizer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u001e\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/ViewPreCreationProfileOptimizer;", "", "()V", "optimize", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", Scopes.PROFILE, "session", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession;", "convergenceRate", "", "(Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findOptimalDelta", "", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$ViewObtainmentStatistics;", "capacity", CreativeInfo.f, "", "oldProfile", "newProfile", "statistics", "", "", "rate", "optimizeForItem", "Lcom/yandex/div/internal/viewpool/PreCreationModel;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPreCreationProfileOptimizer {
    public static final ViewPreCreationProfileOptimizer INSTANCE = new ViewPreCreationProfileOptimizer();

    private ViewPreCreationProfileOptimizer() {
    }

    public static /* synthetic */ Object optimize$default(ViewPreCreationProfile viewPreCreationProfile, PerformanceDependentSession performanceDependentSession, double d, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            d = 0.6d;
        }
        return optimize(viewPreCreationProfile, performanceDependentSession, d, continuation);
    }

    /* JADX INFO: renamed from: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileOptimizer$optimize$2, reason: invalid class name */
    /* JADX INFO: compiled from: ViewPreCreationProfileOptimizer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileOptimizer$optimize$2", f = "ViewPreCreationProfileOptimizer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ViewPreCreationProfile>, Object> {
        final /* synthetic */ double $convergenceRate;
        final /* synthetic */ ViewPreCreationProfile $profile;
        final /* synthetic */ PerformanceDependentSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ViewPreCreationProfile viewPreCreationProfile, PerformanceDependentSession performanceDependentSession, double d, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$profile = viewPreCreationProfile;
            this.$session = performanceDependentSession;
            this.$convergenceRate = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$profile, this.$session, this.$convergenceRate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ViewPreCreationProfile> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ViewPreCreationProfile viewPreCreationProfileOptimize = ViewPreCreationProfileOptimizer.INSTANCE.optimize(this.$profile, this.$session.getViewObtainmentStatistics(), this.$convergenceRate);
                if (Log.isEnabled()) {
                    ViewPreCreationProfileOptimizer.INSTANCE.log(this.$session, this.$profile, viewPreCreationProfileOptimize);
                }
                return viewPreCreationProfileOptimize;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @JvmStatic
    public static final Object optimize(ViewPreCreationProfile viewPreCreationProfile, PerformanceDependentSession performanceDependentSession, double d, Continuation<? super ViewPreCreationProfile> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass2(viewPreCreationProfile, performanceDependentSession, d, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewPreCreationProfile optimize(ViewPreCreationProfile viewPreCreationProfile, Map<String, ? extends PerformanceDependentSession.ViewObtainmentStatistics> map, double d) {
        String id = viewPreCreationProfile.getId();
        ViewPreCreationProfileOptimizer viewPreCreationProfileOptimizer = INSTANCE;
        return new ViewPreCreationProfile(id, viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getText(), map.get(DivViewCreator.TAG_TEXT), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getImage(), map.get(DivViewCreator.TAG_IMAGE), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getGifImage(), map.get(DivViewCreator.TAG_GIF_IMAGE), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getOverlapContainer(), map.get(DivViewCreator.TAG_OVERLAP_CONTAINER), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getLinearContainer(), map.get(DivViewCreator.TAG_LINEAR_CONTAINER), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getWrapContainer(), map.get(DivViewCreator.TAG_WRAP_CONTAINER), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getGrid(), map.get(DivViewCreator.TAG_GRID), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getGallery(), map.get(DivViewCreator.TAG_GALLERY), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getPager(), map.get(DivViewCreator.TAG_PAGER), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getTab(), map.get(DivViewCreator.TAG_TABS), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getState(), map.get(DivViewCreator.TAG_STATE), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getCustom(), map.get(DivViewCreator.TAG_CUSTOM), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getIndicator(), map.get(DivViewCreator.TAG_INDICATOR), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getSlider(), map.get(DivViewCreator.TAG_SLIDER), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getInput(), map.get(DivViewCreator.TAG_INPUT), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getSelect(), map.get(DivViewCreator.TAG_SELECT), d), viewPreCreationProfileOptimizer.optimizeForItem(viewPreCreationProfile.getVideo(), map.get(DivViewCreator.TAG_VIDEO), d), (PreCreationModel) null, 262144, (DefaultConstructorMarker) null);
    }

    private final PreCreationModel optimizeForItem(PreCreationModel preCreationModel, PerformanceDependentSession.ViewObtainmentStatistics viewObtainmentStatistics, double d) {
        if (viewObtainmentStatistics == null) {
            return preCreationModel;
        }
        int iFindOptimalDelta = findOptimalDelta(viewObtainmentStatistics, preCreationModel.getCapacity());
        return PreCreationModel.copy$default(preCreationModel, RangesKt.coerceIn(MathKt.roundToInt(((double) preCreationModel.getCapacity()) + (((double) MathKt.getSign(iFindOptimalDelta)) * Math.pow(Math.abs(iFindOptimalDelta), d))), preCreationModel.getMin(), preCreationModel.getMax()), 0, 0, 6, null);
    }

    private final int findOptimalDelta(PerformanceDependentSession.ViewObtainmentStatistics viewObtainmentStatistics, int i) {
        Integer numValueOf = Integer.valueOf(viewObtainmentStatistics.getMaxSuccessiveBlocked());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        Integer minUnused = viewObtainmentStatistics.getMinUnused();
        Integer numValueOf2 = minUnused != null ? Integer.valueOf(-minUnused.intValue()) : null;
        return numValueOf2 != null ? numValueOf2.intValue() : -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(PerformanceDependentSession performanceDependentSession, ViewPreCreationProfile viewPreCreationProfile, ViewPreCreationProfile viewPreCreationProfile2) {
        if (!(performanceDependentSession instanceof PerformanceDependentSession.Lightweight)) {
            if (performanceDependentSession instanceof PerformanceDependentSession.Detailed) {
                for (Map.Entry<String, List<PerformanceDependentSession.Detailed.ViewObtainment>> entry : ((PerformanceDependentSession.Detailed) performanceDependentSession).getViewObtainments().entrySet()) {
                    String key = entry.getKey();
                    List<PerformanceDependentSession.Detailed.ViewObtainment> value = entry.getValue();
                    KLog kLog = KLog.INSTANCE;
                    if (kLog.isAtLeast(Severity.DEBUG)) {
                        kLog.print(3, "ViewPreCreationProfileOptimizer", key);
                    }
                    KLog kLog2 = KLog.INSTANCE;
                    if (kLog2.isAtLeast(Severity.DEBUG)) {
                        kLog2.print(3, "ViewPreCreationProfileOptimizer", CollectionsKt.joinToString$default(value, " ", "Obtained with block: ", null, 0, null, new Function1<PerformanceDependentSession.Detailed.ViewObtainment, CharSequence>() { // from class: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileOptimizer$log$2$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(PerformanceDependentSession.Detailed.ViewObtainment it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (it.isObtainedWithBlock()) {
                                    return "1";
                                }
                                return "0";
                            }
                        }, 28, null));
                    }
                    KLog kLog3 = KLog.INSTANCE;
                    if (kLog3.isAtLeast(Severity.DEBUG)) {
                        kLog3.print(3, "ViewPreCreationProfileOptimizer", CollectionsKt.joinToString$default(value, " ", "Available views left: ", null, 0, null, new Function1<PerformanceDependentSession.Detailed.ViewObtainment, CharSequence>() { // from class: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileOptimizer$log$2$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(PerformanceDependentSession.Detailed.ViewObtainment it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return String.valueOf(it.getAvailableViews());
                            }
                        }, 28, null));
                    }
                }
            }
        } else {
            for (Map.Entry<String, PerformanceDependentSession.ViewObtainmentStatistics> entry2 : performanceDependentSession.getViewObtainmentStatistics().entrySet()) {
                String key2 = entry2.getKey();
                PerformanceDependentSession.ViewObtainmentStatistics value2 = entry2.getValue();
                KLog kLog4 = KLog.INSTANCE;
                if (kLog4.isAtLeast(Severity.DEBUG)) {
                    kLog4.print(3, "ViewPreCreationProfileOptimizer", key2 + ": " + value2);
                }
            }
        }
        KLog kLog5 = KLog.INSTANCE;
        if (kLog5.isAtLeast(Severity.DEBUG)) {
            kLog5.print(3, "ViewPreCreationProfileOptimizer", viewPreCreationProfile.toString());
        }
        KLog kLog6 = KLog.INSTANCE;
        if (kLog6.isAtLeast(Severity.DEBUG)) {
            kLog6.print(3, "ViewPreCreationProfileOptimizer", viewPreCreationProfile2.toString());
        }
        KLog kLog7 = KLog.INSTANCE;
        if (kLog7.isAtLeast(Severity.DEBUG)) {
            kLog7.print(3, "ViewPreCreationProfileOptimizer", "Is profile changed: " + (!Intrinsics.areEqual(viewPreCreationProfile, viewPreCreationProfile2)));
        }
    }
}
