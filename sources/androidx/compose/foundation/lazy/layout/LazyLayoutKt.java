package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:66:0x010b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0138  */
    /* JADX WARN: Code duplicated, block: B:71:0x0140  */
    /* JADX WARN: Code duplicated, block: B:76:0x0165  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    @ExperimentalFoundationApi
    public static final void LazyLayout(final LazyLayoutItemProvider itemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, final Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Modifier.Companion companion;
        LazyLayoutPrefetchState lazyLayoutPrefetchState2;
        final State stateRememberUpdatedState;
        SaveableStateHolder saveableStateHolderRememberSaveableStateHolder;
        Object objRememberedValue;
        final LazyLayoutItemContentFactory lazyLayoutItemContentFactory;
        Object objRememberedValue2;
        SubcomposeLayoutState subcomposeLayoutState;
        boolean zChanged;
        Object objRememberedValue3;
        final Modifier modifier2;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(852831187);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyLayout)P(!1,2,3)48@2002L34,50@2068L29,51@2127L104,54@2264L93,68@2602L311,65@2527L392:LazyLayout.kt#wow0x6");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(itemProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(lazyLayoutPrefetchState)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(measurePolicy)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        lazyLayoutPrefetchState2 = null;
                    } else {
                        lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                    }
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
                    saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final LazyLayoutItemProvider invoke() {
                                return stateRememberUpdatedState.getValue();
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(617316839);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
                    if (lazyLayoutPrefetchState2 != null) {
                        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                        Unit unit = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                                lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                                return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
                    modifier2 = companion;
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    lazyLayoutPrefetchState3 = lazyLayoutPrefetchState;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        LazyLayoutKt.LazyLayout(itemProvider, modifier2, lazyLayoutPrefetchState3, measurePolicy, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(measurePolicy)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 5851) == 1170) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState2 = null;
                } else {
                    lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
                saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final LazyLayoutItemProvider invoke() {
                            return stateRememberUpdatedState.getValue();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(617316839);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
                if (lazyLayoutPrefetchState2 != null) {
                    LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                    Unit unit2 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
                modifier2 = companion;
                lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState2 = null;
                } else {
                    lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
                saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final LazyLayoutItemProvider invoke() {
                            return stateRememberUpdatedState.getValue();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(617316839);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
                if (lazyLayoutPrefetchState2 != null) {
                    LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                    Unit unit3 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
                modifier2 = companion;
                lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    LazyLayoutKt.LazyLayout(itemProvider, modifier2, lazyLayoutPrefetchState3, measurePolicy, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(lazyLayoutPrefetchState)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(measurePolicy)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 5851) == 1170) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState2 = null;
                } else {
                    lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
                saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final LazyLayoutItemProvider invoke() {
                            return stateRememberUpdatedState.getValue();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(617316839);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
                if (lazyLayoutPrefetchState2 != null) {
                    LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                    Unit unit4 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
                modifier2 = companion;
                lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    lazyLayoutPrefetchState2 = null;
                } else {
                    lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
                saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final LazyLayoutItemProvider invoke() {
                            return stateRememberUpdatedState.getValue();
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(617316839);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
                if (lazyLayoutPrefetchState2 != null) {
                    LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                    Unit unit5 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                            lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                            return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
                modifier2 = companion;
                lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    LazyLayoutKt.LazyLayout(itemProvider, modifier2, lazyLayoutPrefetchState3, measurePolicy, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(measurePolicy)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 5851) == 1170) {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i4 != 0) {
                lazyLayoutPrefetchState2 = null;
            } else {
                lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
            }
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
            saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LazyLayoutItemProvider invoke() {
                        return stateRememberUpdatedState.getValue();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(617316839);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
            if (lazyLayoutPrefetchState2 != null) {
                LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                Unit unit6 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                        lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                        return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                        lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                        return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
            modifier2 = companion;
            lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i4 != 0) {
                lazyLayoutPrefetchState2 = null;
            } else {
                lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
            }
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(itemProvider, composerStartRestartGroup, i3 & 14);
            saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolderRememberSaveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$itemContentFactory$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LazyLayoutItemProvider invoke() {
                        return stateRememberUpdatedState.getValue();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(617316839);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2391L124");
            if (lazyLayoutPrefetchState2 != null) {
                LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, composerStartRestartGroup, ((i3 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                Unit unit7 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(lazyLayoutItemContentFactory) | composerStartRestartGroup.changed(measurePolicy);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                        lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                        return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m634invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m634invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$null");
                        lazyLayoutItemContentFactory.m633onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
                        return measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.m3787boximpl(j));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, companion, (Function2) objRememberedValue3, composerStartRestartGroup, SubcomposeLayoutState.$stable | (i3 & 112), 0);
            modifier2 = companion;
            lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                LazyLayoutKt.LazyLayout(itemProvider, modifier2, lazyLayoutPrefetchState3, measurePolicy, composer2, i | 1, i2);
            }
        });
    }
}
