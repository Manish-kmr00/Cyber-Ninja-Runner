package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u009c\u0001\u0010&\u001a\u0019\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0\u0007¢\u0006\u0002\b\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020*H\u0003ø\u0001\u0000¢\u0006\u0002\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridKt {
    /* JADX WARN: Code duplicated, block: B:101:0x013e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0144  */
    /* JADX WARN: Code duplicated, block: B:104:0x0147  */
    /* JADX WARN: Code duplicated, block: B:107:0x014e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0151  */
    /* JADX WARN: Code duplicated, block: B:110:0x0155  */
    /* JADX WARN: Code duplicated, block: B:112:0x015b  */
    /* JADX WARN: Code duplicated, block: B:113:0x015d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0161  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0186  */
    /* JADX WARN: Code duplicated, block: B:126:0x018e  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:139:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:146:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:149:0x021b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0256  */
    /* JADX WARN: Code duplicated, block: B:154:0x025e  */
    /* JADX WARN: Code duplicated, block: B:157:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:158:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:161:0x0339 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:163:0x033e  */
    /* JADX WARN: Code duplicated, block: B:168:0x0374  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:77:0x0101  */
    /* JADX WARN: Code duplicated, block: B:79:0x0105  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0110  */
    /* JADX WARN: Code duplicated, block: B:87:0x011d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0121  */
    /* JADX WARN: Code duplicated, block: B:91:0x0125  */
    /* JADX WARN: Code duplicated, block: B:93:0x012b  */
    /* JADX WARN: Code duplicated, block: B:94:0x012e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:99:0x0139  */
    public static final void LazyGrid(Modifier modifier, final LazyGridState state, final Function2<? super Density, ? super Constraints, ? extends List<Integer>> slotSizesSums, PaddingValues paddingValues, boolean z, final boolean z2, FlingBehavior flingBehavior, final boolean z3, final Arrangement.Vertical verticalArrangement, final Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyGridScope, Unit> content, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier.Companion companion;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        boolean z4;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        boolean z5;
        PaddingValues paddingValues3;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composer2;
        Orientation orientation;
        boolean z6;
        Object objConsume;
        boolean z7;
        final PaddingValues paddingValues4;
        final Modifier modifier3;
        final boolean z8;
        final FlingBehavior flingBehavior3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(slotSizesSums, "slotSizesSums");
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(152645664);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)66@3081L15,76@3522L18,78@3565L36,80@3619L24,81@3672L92,86@3838L275,101@4154L42,108@4434L293,104@4289L1624:LazyGrid.kt#7791vq");
        int i14 = i3 & 1;
        if (i14 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(slotSizesSums) ? 256 : 128;
        }
        int i15 = i3 & 8;
        if (i15 == 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                i4 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i13 = 524288;
                    } else {
                        i13 = 1048576;
                    }
                    i4 |= i13;
                }
                if ((i3 & 128) != 0) {
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i4 |= i8;
                    }
                    if ((i3 & 256) != 0) {
                        if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changed(verticalArrangement)) {
                                i9 = 67108864;
                            } else {
                                i9 = 33554432;
                            }
                        }
                        if ((i3 & 512) != 0) {
                            if ((1879048192 & i) == 0) {
                                if (composerStartRestartGroup.changed(horizontalArrangement)) {
                                    i10 = 536870912;
                                } else {
                                    i10 = 268435456;
                                }
                            }
                            if ((i3 & 1024) != 0) {
                                i11 = i2 | 6;
                            } else if ((i2 & 14) == 0) {
                                if (composerStartRestartGroup.changed(content)) {
                                    i12 = 4;
                                } else {
                                    i12 = 2;
                                }
                                i11 = i2 | i12;
                            } else {
                                i11 = i2;
                            }
                            if ((i4 & 1533916891) == 306783378 || (i11 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i14 != 0) {
                                        companion = Modifier.INSTANCE;
                                    } else {
                                        companion = modifier;
                                    }
                                    if (i15 != 0) {
                                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                    } else {
                                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                    }
                                    z4 = i5 == 0 ? z : false;
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                        z5 = z4;
                                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        modifier2 = companion;
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                        modifier2 = companion;
                                        z5 = z4;
                                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    z5 = z;
                                    flingBehavior2 = flingBehavior;
                                    paddingValues3 = paddingValues2;
                                    modifier2 = modifier;
                                }
                                composerStartRestartGroup.endDefaults();
                                OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                                int i16 = i4 >> 3;
                                LazyGridItemProvider lazyGridItemProviderRememberItemProvider = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i16 & 14) | ((i11 << 3) & 112));
                                composerStartRestartGroup.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    objRememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                composerStartRestartGroup.endReplaceableGroup();
                                Boolean boolValueOf = Boolean.valueOf(z2);
                                composerStartRestartGroup.startReplaceableGroup(511388516);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(state);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator = (LazyGridItemPlacementAnimator) objRememberedValue2;
                                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator);
                                int i17 = i4 & 112;
                                int i18 = i4 << 3;
                                int i19 = i18 & 458752;
                                Modifier modifier4 = modifier2;
                                composer2 = composerStartRestartGroup;
                                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider, state, overscrollEffect, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator, composer2, i17 | 1073741824 | (i18 & 7168) | (i18 & 57344) | i19 | (i18 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                                state.setVertical$foundation_release(z2);
                                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider, state, composer2, i17);
                                if (z2) {
                                    orientation = Orientation.Vertical;
                                } else {
                                    orientation = Orientation.Horizontal;
                                }
                                Orientation orientation2 = orientation;
                                Modifier modifierOverscroll = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier4.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider, state, coroutineScope, z2, z5, z3, composer2, (i18 & 896) | 4096 | (i16 & 57344) | i19 | (i16 & 3670016)), orientation2), overscrollEffect);
                                composer2.startReplaceableGroup(-1163690407);
                                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                                z6 = !z5;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                objConsume = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (objConsume == LayoutDirection.Rtl || z2) {
                                    z7 = z6;
                                } else {
                                    z7 = z5;
                                }
                                composer2.endReplaceableGroup();
                                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider, ScrollableKt.scrollable(modifierOverscroll, state, orientation2, overscrollEffect, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy, composer2, 0, 0);
                                paddingValues4 = paddingValues3;
                                modifier3 = modifier4;
                                z8 = z5;
                                flingBehavior3 = flingBehavior2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                z8 = z;
                                paddingValues4 = paddingValues2;
                                composer2 = composerStartRestartGroup;
                                flingBehavior3 = flingBehavior;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                                }
                            });
                        }
                        i10 = C.ENCODING_PCM_32BIT;
                        i4 |= i10;
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect2 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i110 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider2 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i110 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller2;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf2 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator2 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator2);
                            int i111 = i4 & 112;
                            int i112 = i4 << 3;
                            int i113 = i112 & 458752;
                            Modifier modifier5 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy2 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider2, state, overscrollEffect2, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator2, composer2, i111 | 1073741824 | (i112 & 7168) | (i112 & 57344) | i113 | (i112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider2, state, composer2, i111);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation3 = orientation;
                            Modifier modifierOverscroll2 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier5.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider2, state, coroutineScope, z2, z5, z3, composer2, (i112 & 896) | 4096 | (i110 & 57344) | i113 | (i110 & 3670016)), orientation3), overscrollEffect2);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider2, ScrollableKt.scrollable(modifierOverscroll2, state, orientation3, overscrollEffect2, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy2, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier5;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect3 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i114 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider3 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i114 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller3;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf3 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator3 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator3);
                            int i115 = i4 & 112;
                            int i116 = i4 << 3;
                            int i117 = i116 & 458752;
                            Modifier modifier6 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy3 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider3, state, overscrollEffect3, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator3, composer2, i115 | 1073741824 | (i116 & 7168) | (i116 & 57344) | i117 | (i116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider3, state, composer2, i115);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation4 = orientation;
                            Modifier modifierOverscroll3 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier6.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider3, state, coroutineScope, z2, z5, z3, composer2, (i116 & 896) | 4096 | (i114 & 57344) | i117 | (i114 & 3670016)), orientation4), overscrollEffect3);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection3);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider3, ScrollableKt.scrollable(modifierOverscroll3, state, orientation4, overscrollEffect3, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy3, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier6;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                            }
                        });
                    }
                    i9 = 100663296;
                    i4 |= i9;
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontalArrangement)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect4 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i118 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider4 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i118 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller4;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf4 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf4) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator4 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator4);
                            int i119 = i4 & 112;
                            int i1110 = i4 << 3;
                            int i1111 = i1110 & 458752;
                            Modifier modifier7 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy4 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider4, state, overscrollEffect4, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator4, composer2, i119 | 1073741824 | (i1110 & 7168) | (i1110 & 57344) | i1111 | (i1110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider4, state, composer2, i119);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation5 = orientation;
                            Modifier modifierOverscroll4 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier7.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider4, state, coroutineScope, z2, z5, z3, composer2, (i1110 & 896) | 4096 | (i118 & 57344) | i1111 | (i118 & 3670016)), orientation5), overscrollEffect4);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection4);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider4, ScrollableKt.scrollable(modifierOverscroll4, state, orientation5, overscrollEffect4, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy4, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier7;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect5 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i1112 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider5 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1112 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller5;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf5 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf5) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator5 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator5);
                            int i1113 = i4 & 112;
                            int i1114 = i4 << 3;
                            int i1115 = i1114 & 458752;
                            Modifier modifier8 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy5 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider5, state, overscrollEffect5, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator5, composer2, i1113 | 1073741824 | (i1114 & 7168) | (i1114 & 57344) | i1115 | (i1114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider5, state, composer2, i1113);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation6 = orientation;
                            Modifier modifierOverscroll5 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier8.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider5, state, coroutineScope, z2, z5, z3, composer2, (i1114 & 896) | 4096 | (i1112 & 57344) | i1115 | (i1112 & 3670016)), orientation6), overscrollEffect5);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection5);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider5, ScrollableKt.scrollable(modifierOverscroll5, state, orientation6, overscrollEffect5, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy5, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier8;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                            }
                        });
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect6 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1116 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider6 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1116 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller6;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf6 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator6 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator6);
                        int i1117 = i4 & 112;
                        int i1118 = i4 << 3;
                        int i1119 = i1118 & 458752;
                        Modifier modifier9 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy6 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider6, state, overscrollEffect6, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator6, composer2, i1117 | 1073741824 | (i1118 & 7168) | (i1118 & 57344) | i1119 | (i1118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider6, state, composer2, i1117);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation7 = orientation;
                        Modifier modifierOverscroll6 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier9.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider6, state, coroutineScope, z2, z5, z3, composer2, (i1118 & 896) | 4096 | (i1116 & 57344) | i1119 | (i1116 & 3670016)), orientation7), overscrollEffect6);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider6, ScrollableKt.scrollable(modifierOverscroll6, state, orientation7, overscrollEffect6, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy6, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier9;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect7 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i11110 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider7 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11110 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller7;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf7 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf7) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator7 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator7);
                        int i11111 = i4 & 112;
                        int i11112 = i4 << 3;
                        int i11113 = i11112 & 458752;
                        Modifier modifier10 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy7 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider7, state, overscrollEffect7, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator7, composer2, i11111 | 1073741824 | (i11112 & 7168) | (i11112 & 57344) | i11113 | (i11112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider7, state, composer2, i11111);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation8 = orientation;
                        Modifier modifierOverscroll7 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier10.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider7, state, coroutineScope, z2, z5, z3, composer2, (i11112 & 896) | 4096 | (i11110 & 57344) | i11113 | (i11110 & 3670016)), orientation8), overscrollEffect7);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection7);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider7, ScrollableKt.scrollable(modifierOverscroll7, state, orientation8, overscrollEffect7, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy7, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier10;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i4 |= 12582912;
                if ((i3 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(verticalArrangement)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontalArrangement)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect8 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i11114 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider8 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11114 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller8;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf8 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf8) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator8 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator8);
                            int i11115 = i4 & 112;
                            int i11116 = i4 << 3;
                            int i11117 = i11116 & 458752;
                            Modifier modifier11 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy8 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider8, state, overscrollEffect8, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator8, composer2, i11115 | 1073741824 | (i11116 & 7168) | (i11116 & 57344) | i11117 | (i11116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider8, state, composer2, i11115);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation9 = orientation;
                            Modifier modifierOverscroll8 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider8, state, coroutineScope, z2, z5, z3, composer2, (i11116 & 896) | 4096 | (i11114 & 57344) | i11117 | (i11114 & 3670016)), orientation9), overscrollEffect8);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection8);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider8, ScrollableKt.scrollable(modifierOverscroll8, state, orientation9, overscrollEffect8, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy8, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier11;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect9 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i11118 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider9 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11118 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller9;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf9 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf9) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator9 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator9);
                            int i11119 = i4 & 112;
                            int i111110 = i4 << 3;
                            int i111111 = i111110 & 458752;
                            Modifier modifier12 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy9 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider9, state, overscrollEffect9, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator9, composer2, i11119 | 1073741824 | (i111110 & 7168) | (i111110 & 57344) | i111111 | (i111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider9, state, composer2, i11119);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation10 = orientation;
                            Modifier modifierOverscroll9 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier12.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider9, state, coroutineScope, z2, z5, z3, composer2, (i111110 & 896) | 4096 | (i11118 & 57344) | i111111 | (i11118 & 3670016)), orientation10), overscrollEffect9);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection9);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider9, ScrollableKt.scrollable(modifierOverscroll9, state, orientation10, overscrollEffect9, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy9, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier12;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                            }
                        });
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect10 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111112 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider10 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111112 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller10;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf10 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf10) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator10 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator10);
                        int i111113 = i4 & 112;
                        int i111114 = i4 << 3;
                        int i111115 = i111114 & 458752;
                        Modifier modifier13 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy10 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider10, state, overscrollEffect10, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator10, composer2, i111113 | 1073741824 | (i111114 & 7168) | (i111114 & 57344) | i111115 | (i111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider10, state, composer2, i111113);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11 = orientation;
                        Modifier modifierOverscroll10 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier13.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider10, state, coroutineScope, z2, z5, z3, composer2, (i111114 & 896) | 4096 | (i111112 & 57344) | i111115 | (i111112 & 3670016)), orientation11), overscrollEffect10);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection10);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider10, ScrollableKt.scrollable(modifierOverscroll10, state, orientation11, overscrollEffect10, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy10, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier13;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect11 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111116 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider11 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111116 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller11;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf11 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf11) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11);
                        int i111117 = i4 & 112;
                        int i111118 = i4 << 3;
                        int i111119 = i111118 & 458752;
                        Modifier modifier14 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11, state, overscrollEffect11, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11, composer2, i111117 | 1073741824 | (i111118 & 7168) | (i111118 & 57344) | i111119 | (i111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11, state, composer2, i111117);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation12 = orientation;
                        Modifier modifierOverscroll11 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier14.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11, state, coroutineScope, z2, z5, z3, composer2, (i111118 & 896) | 4096 | (i111116 & 57344) | i111119 | (i111116 & 3670016)), orientation12), overscrollEffect11);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection11);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11, ScrollableKt.scrollable(modifierOverscroll11, state, orientation12, overscrollEffect11, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier14;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i9 = 100663296;
                i4 |= i9;
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect12 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111110 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider12 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111110 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller12;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf12 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf12) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator12 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator12);
                        int i1111111 = i4 & 112;
                        int i1111112 = i4 << 3;
                        int i1111113 = i1111112 & 458752;
                        Modifier modifier15 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy12 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider12, state, overscrollEffect12, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator12, composer2, i1111111 | 1073741824 | (i1111112 & 7168) | (i1111112 & 57344) | i1111113 | (i1111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider12, state, composer2, i1111111);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation13 = orientation;
                        Modifier modifierOverscroll12 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier15.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider12, state, coroutineScope, z2, z5, z3, composer2, (i1111112 & 896) | 4096 | (i1111110 & 57344) | i1111113 | (i1111110 & 3670016)), orientation13), overscrollEffect12);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection12);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider12, ScrollableKt.scrollable(modifierOverscroll12, state, orientation13, overscrollEffect12, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy12, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier15;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect13 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111114 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider13 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111114 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller13;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf13 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf13) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator13 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator13);
                        int i1111115 = i4 & 112;
                        int i1111116 = i4 << 3;
                        int i1111117 = i1111116 & 458752;
                        Modifier modifier16 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy13 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider13, state, overscrollEffect13, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator13, composer2, i1111115 | 1073741824 | (i1111116 & 7168) | (i1111116 & 57344) | i1111117 | (i1111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider13, state, composer2, i1111115);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation14 = orientation;
                        Modifier modifierOverscroll13 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier16.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider13, state, coroutineScope, z2, z5, z3, composer2, (i1111116 & 896) | 4096 | (i1111114 & 57344) | i1111117 | (i1111114 & 3670016)), orientation14), overscrollEffect13);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection13);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider13, ScrollableKt.scrollable(modifierOverscroll13, state, orientation14, overscrollEffect13, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy13, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier16;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i10 = C.ENCODING_PCM_32BIT;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect14 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111118 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider14 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111118 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller14;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf14 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf14) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator14 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator14);
                    int i1111119 = i4 & 112;
                    int i11111110 = i4 << 3;
                    int i11111111 = i11111110 & 458752;
                    Modifier modifier17 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy14 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider14, state, overscrollEffect14, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator14, composer2, i1111119 | 1073741824 | (i11111110 & 7168) | (i11111110 & 57344) | i11111111 | (i11111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider14, state, composer2, i1111119);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation15 = orientation;
                    Modifier modifierOverscroll14 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier17.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider14, state, coroutineScope, z2, z5, z3, composer2, (i11111110 & 896) | 4096 | (i1111118 & 57344) | i11111111 | (i1111118 & 3670016)), orientation15), overscrollEffect14);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection14);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider14, ScrollableKt.scrollable(modifierOverscroll14, state, orientation15, overscrollEffect14, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy14, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier17;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect15 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111112 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider15 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111112 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller15;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf15 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf15) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator15 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator15);
                    int i11111113 = i4 & 112;
                    int i11111114 = i4 << 3;
                    int i11111115 = i11111114 & 458752;
                    Modifier modifier18 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy15 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider15, state, overscrollEffect15, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator15, composer2, i11111113 | 1073741824 | (i11111114 & 7168) | (i11111114 & 57344) | i11111115 | (i11111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider15, state, composer2, i11111113);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation16 = orientation;
                    Modifier modifierOverscroll15 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier18.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider15, state, coroutineScope, z2, z5, z3, composer2, (i11111114 & 896) | 4096 | (i11111112 & 57344) | i11111115 | (i11111112 & 3670016)), orientation16), overscrollEffect15);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection15);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider15, ScrollableKt.scrollable(modifierOverscroll15, state, orientation16, overscrollEffect15, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy15, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier18;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i7;
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i4 |= i13;
            }
            if ((i3 & 128) != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
                if ((i3 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(verticalArrangement)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontalArrangement)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect16 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i11111116 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider16 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111116 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller16 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller16);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller16;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf16 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf16) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator16 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator16);
                            int i11111117 = i4 & 112;
                            int i11111118 = i4 << 3;
                            int i11111119 = i11111118 & 458752;
                            Modifier modifier19 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy16 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider16, state, overscrollEffect16, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator16, composer2, i11111117 | 1073741824 | (i11111118 & 7168) | (i11111118 & 57344) | i11111119 | (i11111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider16, state, composer2, i11111117);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation17 = orientation;
                            Modifier modifierOverscroll16 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier19.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider16, state, coroutineScope, z2, z5, z3, composer2, (i11111118 & 896) | 4096 | (i11111116 & 57344) | i11111119 | (i11111116 & 3670016)), orientation17), overscrollEffect16);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection16);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider16, ScrollableKt.scrollable(modifierOverscroll16, state, orientation17, overscrollEffect16, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy16, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier19;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect17 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i111111110 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider17 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111110 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller17 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller17);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller17;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf17 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf17) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator17 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator17);
                            int i111111111 = i4 & 112;
                            int i111111112 = i4 << 3;
                            int i111111113 = i111111112 & 458752;
                            Modifier modifier110 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy17 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider17, state, overscrollEffect17, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator17, composer2, i111111111 | 1073741824 | (i111111112 & 7168) | (i111111112 & 57344) | i111111113 | (i111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider17, state, composer2, i111111111);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation18 = orientation;
                            Modifier modifierOverscroll17 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier110.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider17, state, coroutineScope, z2, z5, z3, composer2, (i111111112 & 896) | 4096 | (i111111110 & 57344) | i111111113 | (i111111110 & 3670016)), orientation18), overscrollEffect17);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection17 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection17);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider17, ScrollableKt.scrollable(modifierOverscroll17, state, orientation18, overscrollEffect17, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy17, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier110;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                            }
                        });
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect18 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111114 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider18 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111114 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller18 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller18);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller18;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf18 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf18) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator18 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator18);
                        int i111111115 = i4 & 112;
                        int i111111116 = i4 << 3;
                        int i111111117 = i111111116 & 458752;
                        Modifier modifier111 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy18 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider18, state, overscrollEffect18, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator18, composer2, i111111115 | 1073741824 | (i111111116 & 7168) | (i111111116 & 57344) | i111111117 | (i111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider18, state, composer2, i111111115);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation19 = orientation;
                        Modifier modifierOverscroll18 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider18, state, coroutineScope, z2, z5, z3, composer2, (i111111116 & 896) | 4096 | (i111111114 & 57344) | i111111117 | (i111111114 & 3670016)), orientation19), overscrollEffect18);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection18 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection18);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider18, ScrollableKt.scrollable(modifierOverscroll18, state, orientation19, overscrollEffect18, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy18, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier111;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect19 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111118 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider19 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111118 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller19 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller19);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller19;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf19 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf19) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator19 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator19);
                        int i111111119 = i4 & 112;
                        int i1111111110 = i4 << 3;
                        int i1111111111 = i1111111110 & 458752;
                        Modifier modifier112 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy19 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider19, state, overscrollEffect19, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator19, composer2, i111111119 | 1073741824 | (i1111111110 & 7168) | (i1111111110 & 57344) | i1111111111 | (i1111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider19, state, composer2, i111111119);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation110 = orientation;
                        Modifier modifierOverscroll19 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier112.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider19, state, coroutineScope, z2, z5, z3, composer2, (i1111111110 & 896) | 4096 | (i111111118 & 57344) | i1111111111 | (i111111118 & 3670016)), orientation110), overscrollEffect19);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection19 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection19);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider19, ScrollableKt.scrollable(modifierOverscroll19, state, orientation110, overscrollEffect19, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy19, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier112;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i9 = 100663296;
                i4 |= i9;
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect110 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111112 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider110 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111112 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller110);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller110;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf110 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf110) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator110 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator110);
                        int i1111111113 = i4 & 112;
                        int i1111111114 = i4 << 3;
                        int i1111111115 = i1111111114 & 458752;
                        Modifier modifier113 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy110 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider110, state, overscrollEffect110, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator110, composer2, i1111111113 | 1073741824 | (i1111111114 & 7168) | (i1111111114 & 57344) | i1111111115 | (i1111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider110, state, composer2, i1111111113);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation111 = orientation;
                        Modifier modifierOverscroll110 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier113.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider110, state, coroutineScope, z2, z5, z3, composer2, (i1111111114 & 896) | 4096 | (i1111111112 & 57344) | i1111111115 | (i1111111112 & 3670016)), orientation111), overscrollEffect110);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection110 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection110);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider110, ScrollableKt.scrollable(modifierOverscroll110, state, orientation111, overscrollEffect110, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy110, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier113;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect111 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111116 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider111 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111116 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller111;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf111 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf111) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111);
                        int i1111111117 = i4 & 112;
                        int i1111111118 = i4 << 3;
                        int i1111111119 = i1111111118 & 458752;
                        Modifier modifier114 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111, state, overscrollEffect111, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111, composer2, i1111111117 | 1073741824 | (i1111111118 & 7168) | (i1111111118 & 57344) | i1111111119 | (i1111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111, state, composer2, i1111111117);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation112 = orientation;
                        Modifier modifierOverscroll111 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier114.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111, state, coroutineScope, z2, z5, z3, composer2, (i1111111118 & 896) | 4096 | (i1111111116 & 57344) | i1111111119 | (i1111111116 & 3670016)), orientation112), overscrollEffect111);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection111);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111, ScrollableKt.scrollable(modifierOverscroll111, state, orientation112, overscrollEffect111, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier114;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i10 = C.ENCODING_PCM_32BIT;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect112 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111110 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider112 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111110 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller112);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller112;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf112 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf112) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator112 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator112);
                    int i11111111111 = i4 & 112;
                    int i11111111112 = i4 << 3;
                    int i11111111113 = i11111111112 & 458752;
                    Modifier modifier115 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy112 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider112, state, overscrollEffect112, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator112, composer2, i11111111111 | 1073741824 | (i11111111112 & 7168) | (i11111111112 & 57344) | i11111111113 | (i11111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider112, state, composer2, i11111111111);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation113 = orientation;
                    Modifier modifierOverscroll112 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier115.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider112, state, coroutineScope, z2, z5, z3, composer2, (i11111111112 & 896) | 4096 | (i11111111110 & 57344) | i11111111113 | (i11111111110 & 3670016)), orientation113), overscrollEffect112);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection112);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider112, ScrollableKt.scrollable(modifierOverscroll112, state, orientation113, overscrollEffect112, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy112, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier115;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect113 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111114 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider113 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111114 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller113);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller113;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf113 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf113) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator113 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator113);
                    int i11111111115 = i4 & 112;
                    int i11111111116 = i4 << 3;
                    int i11111111117 = i11111111116 & 458752;
                    Modifier modifier116 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy113 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider113, state, overscrollEffect113, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator113, composer2, i11111111115 | 1073741824 | (i11111111116 & 7168) | (i11111111116 & 57344) | i11111111117 | (i11111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider113, state, composer2, i11111111115);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation114 = orientation;
                    Modifier modifierOverscroll113 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier116.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider113, state, coroutineScope, z2, z5, z3, composer2, (i11111111116 & 896) | 4096 | (i11111111114 & 57344) | i11111111117 | (i11111111114 & 3670016)), orientation114), overscrollEffect113);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection113 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection113);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider113, ScrollableKt.scrollable(modifierOverscroll113, state, orientation114, overscrollEffect113, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy113, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier116;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 12582912;
            if ((i3 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(verticalArrangement)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect114 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111111118 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider114 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111118 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller114);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller114;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf114 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf114) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator114 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator114);
                        int i11111111119 = i4 & 112;
                        int i111111111110 = i4 << 3;
                        int i111111111111 = i111111111110 & 458752;
                        Modifier modifier117 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy114 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider114, state, overscrollEffect114, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator114, composer2, i11111111119 | 1073741824 | (i111111111110 & 7168) | (i111111111110 & 57344) | i111111111111 | (i111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider114, state, composer2, i11111111119);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation115 = orientation;
                        Modifier modifierOverscroll114 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier117.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider114, state, coroutineScope, z2, z5, z3, composer2, (i111111111110 & 896) | 4096 | (i11111111118 & 57344) | i111111111111 | (i11111111118 & 3670016)), orientation115), overscrollEffect114);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection114 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection114);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider114, ScrollableKt.scrollable(modifierOverscroll114, state, orientation115, overscrollEffect114, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy114, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier117;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect115 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111112 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider115 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111112 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller115);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller115;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf115 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf115) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator115 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator115);
                        int i111111111113 = i4 & 112;
                        int i111111111114 = i4 << 3;
                        int i111111111115 = i111111111114 & 458752;
                        Modifier modifier118 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy115 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider115, state, overscrollEffect115, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator115, composer2, i111111111113 | 1073741824 | (i111111111114 & 7168) | (i111111111114 & 57344) | i111111111115 | (i111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider115, state, composer2, i111111111113);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation116 = orientation;
                        Modifier modifierOverscroll115 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier118.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider115, state, coroutineScope, z2, z5, z3, composer2, (i111111111114 & 896) | 4096 | (i111111111112 & 57344) | i111111111115 | (i111111111112 & 3670016)), orientation116), overscrollEffect115);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection115 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection115);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider115, ScrollableKt.scrollable(modifierOverscroll115, state, orientation116, overscrollEffect115, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy115, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier118;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i10 = C.ENCODING_PCM_32BIT;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect116 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111116 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider116 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111116 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller116);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller116;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf116 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf116) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator116 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator116);
                    int i111111111117 = i4 & 112;
                    int i111111111118 = i4 << 3;
                    int i111111111119 = i111111111118 & 458752;
                    Modifier modifier119 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy116 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider116, state, overscrollEffect116, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator116, composer2, i111111111117 | 1073741824 | (i111111111118 & 7168) | (i111111111118 & 57344) | i111111111119 | (i111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider116, state, composer2, i111111111117);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation117 = orientation;
                    Modifier modifierOverscroll116 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier119.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider116, state, coroutineScope, z2, z5, z3, composer2, (i111111111118 & 896) | 4096 | (i111111111116 & 57344) | i111111111119 | (i111111111116 & 3670016)), orientation117), overscrollEffect116);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection116 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection116);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider116, ScrollableKt.scrollable(modifierOverscroll116, state, orientation117, overscrollEffect116, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy116, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier119;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect117 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111110 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider117 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111110 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller117);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller117;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf117 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf117) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator117 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator117);
                    int i1111111111111 = i4 & 112;
                    int i1111111111112 = i4 << 3;
                    int i1111111111113 = i1111111111112 & 458752;
                    Modifier modifier1110 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy117 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider117, state, overscrollEffect117, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator117, composer2, i1111111111111 | 1073741824 | (i1111111111112 & 7168) | (i1111111111112 & 57344) | i1111111111113 | (i1111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider117, state, composer2, i1111111111111);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation118 = orientation;
                    Modifier modifierOverscroll117 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1110.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider117, state, coroutineScope, z2, z5, z3, composer2, (i1111111111112 & 896) | 4096 | (i1111111111110 & 57344) | i1111111111113 | (i1111111111110 & 3670016)), orientation118), overscrollEffect117);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection117 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection117);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider117, ScrollableKt.scrollable(modifierOverscroll117, state, orientation118, overscrollEffect117, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy117, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier1110;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i9 = 100663296;
            i4 |= i9;
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect118 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111114 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider118 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111114 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller118);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller118;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf118 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf118) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator118 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator118);
                    int i1111111111115 = i4 & 112;
                    int i1111111111116 = i4 << 3;
                    int i1111111111117 = i1111111111116 & 458752;
                    Modifier modifier1111 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy118 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider118, state, overscrollEffect118, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator118, composer2, i1111111111115 | 1073741824 | (i1111111111116 & 7168) | (i1111111111116 & 57344) | i1111111111117 | (i1111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider118, state, composer2, i1111111111115);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation119 = orientation;
                    Modifier modifierOverscroll118 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider118, state, coroutineScope, z2, z5, z3, composer2, (i1111111111116 & 896) | 4096 | (i1111111111114 & 57344) | i1111111111117 | (i1111111111114 & 3670016)), orientation119), overscrollEffect118);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection118 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection118);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider118, ScrollableKt.scrollable(modifierOverscroll118, state, orientation119, overscrollEffect118, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy118, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier1111;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect119 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111118 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider119 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111118 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller119);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller119;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf119 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf119) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator119 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator119);
                    int i1111111111119 = i4 & 112;
                    int i11111111111110 = i4 << 3;
                    int i11111111111111 = i11111111111110 & 458752;
                    Modifier modifier1112 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy119 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider119, state, overscrollEffect119, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator119, composer2, i1111111111119 | 1073741824 | (i11111111111110 & 7168) | (i11111111111110 & 57344) | i11111111111111 | (i11111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider119, state, composer2, i1111111111119);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation1110 = orientation;
                    Modifier modifierOverscroll119 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1112.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider119, state, coroutineScope, z2, z5, z3, composer2, (i11111111111110 & 896) | 4096 | (i1111111111118 & 57344) | i11111111111111 | (i1111111111118 & 3670016)), orientation1110), overscrollEffect119);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection119 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection119);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider119, ScrollableKt.scrollable(modifierOverscroll119, state, orientation1110, overscrollEffect119, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy119, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier1112;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i10 = C.ENCODING_PCM_32BIT;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect1110 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111112 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider1110 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111112 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1110);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller1110;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf1110 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf1110) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1110 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1110);
                int i11111111111113 = i4 & 112;
                int i11111111111114 = i4 << 3;
                int i11111111111115 = i11111111111114 & 458752;
                Modifier modifier1113 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1110 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1110, state, overscrollEffect1110, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1110, composer2, i11111111111113 | 1073741824 | (i11111111111114 & 7168) | (i11111111111114 & 57344) | i11111111111115 | (i11111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1110, state, composer2, i11111111111113);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111 = orientation;
                Modifier modifierOverscroll1110 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1113.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1110, state, coroutineScope, z2, z5, z3, composer2, (i11111111111114 & 896) | 4096 | (i11111111111112 & 57344) | i11111111111115 | (i11111111111112 & 3670016)), orientation1111), overscrollEffect1110);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1110 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection1110);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1110, ScrollableKt.scrollable(modifierOverscroll1110, state, orientation1111, overscrollEffect1110, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1110, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier1113;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect1111 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111116 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider1111 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111116 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller1111;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf1111 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf1111) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1111 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1111);
                int i11111111111117 = i4 & 112;
                int i11111111111118 = i4 << 3;
                int i11111111111119 = i11111111111118 & 458752;
                Modifier modifier1114 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1111 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1111, state, overscrollEffect1111, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1111, composer2, i11111111111117 | 1073741824 | (i11111111111118 & 7168) | (i11111111111118 & 57344) | i11111111111119 | (i11111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1111, state, composer2, i11111111111117);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1112 = orientation;
                Modifier modifierOverscroll1111 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1114.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1111, state, coroutineScope, z2, z5, z3, composer2, (i11111111111118 & 896) | 4096 | (i11111111111116 & 57344) | i11111111111119 | (i11111111111116 & 3670016)), orientation1112), overscrollEffect1111);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection1111);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1111, ScrollableKt.scrollable(modifierOverscroll1111, state, orientation1112, overscrollEffect1111, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1111, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier1114;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i4 |= 3072;
        paddingValues2 = paddingValues;
        i5 = i3 & 16;
        if (i5 != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i4 |= i6;
        }
        if ((i3 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i4 |= i13;
            }
            if ((i3 & 128) != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
                if ((i3 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(verticalArrangement)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                    }
                    if ((i3 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(horizontalArrangement)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 4;
                            } else {
                                i12 = 2;
                            }
                            i11 = i2 | i12;
                        } else {
                            i11 = i2;
                        }
                        if ((i4 & 1533916891) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect1112 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i111111111111110 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider1112 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111110 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1112);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller1112;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf1112 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf1112) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1112 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1112);
                            int i111111111111111 = i4 & 112;
                            int i111111111111112 = i4 << 3;
                            int i111111111111113 = i111111111111112 & 458752;
                            Modifier modifier1115 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1112 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1112, state, overscrollEffect1112, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1112, composer2, i111111111111111 | 1073741824 | (i111111111111112 & 7168) | (i111111111111112 & 57344) | i111111111111113 | (i111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1112, state, composer2, i111111111111111);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation1113 = orientation;
                            Modifier modifierOverscroll1112 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1115.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1112, state, coroutineScope, z2, z5, z3, composer2, (i111111111111112 & 896) | 4096 | (i111111111111110 & 57344) | i111111111111113 | (i111111111111110 & 3670016)), orientation1113), overscrollEffect1112);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1112 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection1112);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1112, ScrollableKt.scrollable(modifierOverscroll1112, state, orientation1113, overscrollEffect1112, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1112, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier1115;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            } else {
                                if (i14 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i15 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i5 == 0) {
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    modifier2 = companion;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                    modifier2 = companion;
                                    z5 = z4;
                                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            OverscrollEffect overscrollEffect1113 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                            int i111111111111114 = i4 >> 3;
                            LazyGridItemProvider lazyGridItemProviderRememberItemProvider1113 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111114 & 14) | ((i11 << 3) & 112));
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1113);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller1113;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Boolean boolValueOf1113 = Boolean.valueOf(z2);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf1113) | composerStartRestartGroup.changed(state);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1113 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1113);
                            int i111111111111115 = i4 & 112;
                            int i111111111111116 = i4 << 3;
                            int i111111111111117 = i111111111111116 & 458752;
                            Modifier modifier1116 = modifier2;
                            composer2 = composerStartRestartGroup;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1113 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1113, state, overscrollEffect1113, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1113, composer2, i111111111111115 | 1073741824 | (i111111111111116 & 7168) | (i111111111111116 & 57344) | i111111111111117 | (i111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                            state.setVertical$foundation_release(z2);
                            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1113, state, composer2, i111111111111115);
                            if (z2) {
                                orientation = Orientation.Vertical;
                            } else {
                                orientation = Orientation.Horizontal;
                            }
                            Orientation orientation1114 = orientation;
                            Modifier modifierOverscroll1113 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1116.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1113, state, coroutineScope, z2, z5, z3, composer2, (i111111111111116 & 896) | 4096 | (i111111111111114 & 57344) | i111111111111117 | (i111111111111114 & 3670016)), orientation1114), overscrollEffect1113);
                            composer2.startReplaceableGroup(-1163690407);
                            ComposerKt.sourceInformation(composer2, "*125@5311L7");
                            z6 = !z5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1113 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composer2.consume(localLayoutDirection1113);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = z6;
                            } else {
                                z7 = z6;
                            }
                            composer2.endReplaceableGroup();
                            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1113, ScrollableKt.scrollable(modifierOverscroll1113, state, orientation1114, overscrollEffect1113, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1113, composer2, 0, 0);
                            paddingValues4 = paddingValues3;
                            modifier3 = modifier1116;
                            z8 = z5;
                            flingBehavior3 = flingBehavior2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                            }
                        });
                    }
                    i10 = C.ENCODING_PCM_32BIT;
                    i4 |= i10;
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect1114 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111111118 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider1114 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111118 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1114);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller1114;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf1114 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf1114) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1114 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1114);
                        int i111111111111119 = i4 & 112;
                        int i1111111111111110 = i4 << 3;
                        int i1111111111111111 = i1111111111111110 & 458752;
                        Modifier modifier1117 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1114 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1114, state, overscrollEffect1114, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1114, composer2, i111111111111119 | 1073741824 | (i1111111111111110 & 7168) | (i1111111111111110 & 57344) | i1111111111111111 | (i1111111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1114, state, composer2, i111111111111119);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1115 = orientation;
                        Modifier modifierOverscroll1114 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1117.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1114, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111110 & 896) | 4096 | (i111111111111118 & 57344) | i1111111111111111 | (i111111111111118 & 3670016)), orientation1115), overscrollEffect1114);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1114 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection1114);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1114, ScrollableKt.scrollable(modifierOverscroll1114, state, orientation1115, overscrollEffect1114, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1114, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier1117;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect1115 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111111111112 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider1115 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111112 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1115);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller1115;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf1115 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf1115) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1115 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1115);
                        int i1111111111111113 = i4 & 112;
                        int i1111111111111114 = i4 << 3;
                        int i1111111111111115 = i1111111111111114 & 458752;
                        Modifier modifier1118 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1115 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1115, state, overscrollEffect1115, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1115, composer2, i1111111111111113 | 1073741824 | (i1111111111111114 & 7168) | (i1111111111111114 & 57344) | i1111111111111115 | (i1111111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1115, state, composer2, i1111111111111113);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1116 = orientation;
                        Modifier modifierOverscroll1115 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1118.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1115, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111114 & 896) | 4096 | (i1111111111111112 & 57344) | i1111111111111115 | (i1111111111111112 & 3670016)), orientation1116), overscrollEffect1115);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1115 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection1115);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1115, ScrollableKt.scrollable(modifierOverscroll1115, state, orientation1116, overscrollEffect1115, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1115, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier1118;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i9 = 100663296;
                i4 |= i9;
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect1116 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i1111111111111116 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider1116 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111116 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1116);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller1116;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf1116 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf1116) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1116 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1116);
                        int i1111111111111117 = i4 & 112;
                        int i1111111111111118 = i4 << 3;
                        int i1111111111111119 = i1111111111111118 & 458752;
                        Modifier modifier1119 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1116 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1116, state, overscrollEffect1116, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1116, composer2, i1111111111111117 | 1073741824 | (i1111111111111118 & 7168) | (i1111111111111118 & 57344) | i1111111111111119 | (i1111111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1116, state, composer2, i1111111111111117);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1117 = orientation;
                        Modifier modifierOverscroll1116 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1119.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1116, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111118 & 896) | 4096 | (i1111111111111116 & 57344) | i1111111111111119 | (i1111111111111116 & 3670016)), orientation1117), overscrollEffect1116);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1116 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection1116);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1116, ScrollableKt.scrollable(modifierOverscroll1116, state, orientation1117, overscrollEffect1116, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1116, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier1119;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect1117 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i11111111111111110 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider1117 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111110 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1117);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller1117;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf1117 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf1117) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1117 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1117);
                        int i11111111111111111 = i4 & 112;
                        int i11111111111111112 = i4 << 3;
                        int i11111111111111113 = i11111111111111112 & 458752;
                        Modifier modifier11110 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1117 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1117, state, overscrollEffect1117, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1117, composer2, i11111111111111111 | 1073741824 | (i11111111111111112 & 7168) | (i11111111111111112 & 57344) | i11111111111111113 | (i11111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1117, state, composer2, i11111111111111111);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation1118 = orientation;
                        Modifier modifierOverscroll1117 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11110.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1117, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111112 & 896) | 4096 | (i11111111111111110 & 57344) | i11111111111111113 | (i11111111111111110 & 3670016)), orientation1118), overscrollEffect1117);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1117 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection1117);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1117, ScrollableKt.scrollable(modifierOverscroll1117, state, orientation1118, overscrollEffect1117, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1117, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier11110;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i10 = C.ENCODING_PCM_32BIT;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect1118 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111114 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider1118 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111114 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1118);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller1118;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf1118 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf1118) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1118 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1118);
                    int i11111111111111115 = i4 & 112;
                    int i11111111111111116 = i4 << 3;
                    int i11111111111111117 = i11111111111111116 & 458752;
                    Modifier modifier11111 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1118 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1118, state, overscrollEffect1118, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1118, composer2, i11111111111111115 | 1073741824 | (i11111111111111116 & 7168) | (i11111111111111116 & 57344) | i11111111111111117 | (i11111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1118, state, composer2, i11111111111111115);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation1119 = orientation;
                    Modifier modifierOverscroll1118 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11111.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1118, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111116 & 896) | 4096 | (i11111111111111114 & 57344) | i11111111111111117 | (i11111111111111114 & 3670016)), orientation1119), overscrollEffect1118);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1118 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection1118);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1118, ScrollableKt.scrollable(modifierOverscroll1118, state, orientation1119, overscrollEffect1118, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1118, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier11111;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect1119 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111118 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider1119 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111118 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1119);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller1119;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf1119 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf1119) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1119 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1119);
                    int i11111111111111119 = i4 & 112;
                    int i111111111111111110 = i4 << 3;
                    int i111111111111111111 = i111111111111111110 & 458752;
                    Modifier modifier11112 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1119 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1119, state, overscrollEffect1119, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1119, composer2, i11111111111111119 | 1073741824 | (i111111111111111110 & 7168) | (i111111111111111110 & 57344) | i111111111111111111 | (i111111111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1119, state, composer2, i11111111111111119);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11110 = orientation;
                    Modifier modifierOverscroll1119 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11112.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1119, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111110 & 896) | 4096 | (i11111111111111118 & 57344) | i111111111111111111 | (i11111111111111118 & 3670016)), orientation11110), overscrollEffect1119);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1119 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection1119);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1119, ScrollableKt.scrollable(modifierOverscroll1119, state, orientation11110, overscrollEffect1119, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1119, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier11112;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 12582912;
            if ((i3 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(verticalArrangement)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect11110 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111111111112 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider11110 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111112 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11110);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller11110;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf11110 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf11110) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11110 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11110);
                        int i111111111111111113 = i4 & 112;
                        int i111111111111111114 = i4 << 3;
                        int i111111111111111115 = i111111111111111114 & 458752;
                        Modifier modifier11113 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11110 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11110, state, overscrollEffect11110, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11110, composer2, i111111111111111113 | 1073741824 | (i111111111111111114 & 7168) | (i111111111111111114 & 57344) | i111111111111111115 | (i111111111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11110, state, composer2, i111111111111111113);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11111 = orientation;
                        Modifier modifierOverscroll11110 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11113.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11110, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111114 & 896) | 4096 | (i111111111111111112 & 57344) | i111111111111111115 | (i111111111111111112 & 3670016)), orientation11111), overscrollEffect11110);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11110 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection11110);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11110, ScrollableKt.scrollable(modifierOverscroll11110, state, orientation11111, overscrollEffect11110, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11110, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier11113;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect11111 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111111111116 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider11111 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111116 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11111);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller11111;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf11111 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf11111) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11111 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11111);
                        int i111111111111111117 = i4 & 112;
                        int i111111111111111118 = i4 << 3;
                        int i111111111111111119 = i111111111111111118 & 458752;
                        Modifier modifier11114 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11111 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11111, state, overscrollEffect11111, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11111, composer2, i111111111111111117 | 1073741824 | (i111111111111111118 & 7168) | (i111111111111111118 & 57344) | i111111111111111119 | (i111111111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11111, state, composer2, i111111111111111117);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11112 = orientation;
                        Modifier modifierOverscroll11111 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11114.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11111, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111118 & 896) | 4096 | (i111111111111111116 & 57344) | i111111111111111119 | (i111111111111111116 & 3670016)), orientation11112), overscrollEffect11111);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11111 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection11111);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11111, ScrollableKt.scrollable(modifierOverscroll11111, state, orientation11112, overscrollEffect11111, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11111, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier11114;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i10 = C.ENCODING_PCM_32BIT;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect11112 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111110 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider11112 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111110 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11112);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller11112;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf11112 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf11112) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11112 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11112);
                    int i1111111111111111111 = i4 & 112;
                    int i1111111111111111112 = i4 << 3;
                    int i1111111111111111113 = i1111111111111111112 & 458752;
                    Modifier modifier11115 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11112 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11112, state, overscrollEffect11112, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11112, composer2, i1111111111111111111 | 1073741824 | (i1111111111111111112 & 7168) | (i1111111111111111112 & 57344) | i1111111111111111113 | (i1111111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11112, state, composer2, i1111111111111111111);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11113 = orientation;
                    Modifier modifierOverscroll11112 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11115.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11112, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111112 & 896) | 4096 | (i1111111111111111110 & 57344) | i1111111111111111113 | (i1111111111111111110 & 3670016)), orientation11113), overscrollEffect11112);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection11112);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11112, ScrollableKt.scrollable(modifierOverscroll11112, state, orientation11113, overscrollEffect11112, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11112, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier11115;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect11113 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111114 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider11113 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111114 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11113);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller11113;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf11113 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf11113) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11113 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11113);
                    int i1111111111111111115 = i4 & 112;
                    int i1111111111111111116 = i4 << 3;
                    int i1111111111111111117 = i1111111111111111116 & 458752;
                    Modifier modifier11116 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11113 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11113, state, overscrollEffect11113, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11113, composer2, i1111111111111111115 | 1073741824 | (i1111111111111111116 & 7168) | (i1111111111111111116 & 57344) | i1111111111111111117 | (i1111111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11113, state, composer2, i1111111111111111115);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11114 = orientation;
                    Modifier modifierOverscroll11113 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11116.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11113, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111116 & 896) | 4096 | (i1111111111111111114 & 57344) | i1111111111111111117 | (i1111111111111111114 & 3670016)), orientation11114), overscrollEffect11113);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11113 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection11113);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11113, ScrollableKt.scrollable(modifierOverscroll11113, state, orientation11114, overscrollEffect11113, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11113, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier11116;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i9 = 100663296;
            i4 |= i9;
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect11114 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111118 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider11114 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111118 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11114);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller11114;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf11114 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf11114) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11114 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11114);
                    int i1111111111111111119 = i4 & 112;
                    int i11111111111111111110 = i4 << 3;
                    int i11111111111111111111 = i11111111111111111110 & 458752;
                    Modifier modifier11117 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11114 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11114, state, overscrollEffect11114, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11114, composer2, i1111111111111111119 | 1073741824 | (i11111111111111111110 & 7168) | (i11111111111111111110 & 57344) | i11111111111111111111 | (i11111111111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11114, state, composer2, i1111111111111111119);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11115 = orientation;
                    Modifier modifierOverscroll11114 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11117.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11114, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111110 & 896) | 4096 | (i1111111111111111118 & 57344) | i11111111111111111111 | (i1111111111111111118 & 3670016)), orientation11115), overscrollEffect11114);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11114 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection11114);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11114, ScrollableKt.scrollable(modifierOverscroll11114, state, orientation11115, overscrollEffect11114, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11114, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier11117;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect11115 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111111112 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider11115 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111112 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11115);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller11115;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf11115 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf11115) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11115 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11115);
                    int i11111111111111111113 = i4 & 112;
                    int i11111111111111111114 = i4 << 3;
                    int i11111111111111111115 = i11111111111111111114 & 458752;
                    Modifier modifier11118 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11115 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11115, state, overscrollEffect11115, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11115, composer2, i11111111111111111113 | 1073741824 | (i11111111111111111114 & 7168) | (i11111111111111111114 & 57344) | i11111111111111111115 | (i11111111111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11115, state, composer2, i11111111111111111113);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation11116 = orientation;
                    Modifier modifierOverscroll11115 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11118.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11115, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111114 & 896) | 4096 | (i11111111111111111112 & 57344) | i11111111111111111115 | (i11111111111111111112 & 3670016)), orientation11116), overscrollEffect11115);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11115 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection11115);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11115, ScrollableKt.scrollable(modifierOverscroll11115, state, orientation11116, overscrollEffect11115, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11115, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier11118;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i10 = C.ENCODING_PCM_32BIT;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect11116 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111116 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider11116 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111116 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11116);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller11116;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf11116 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf11116) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11116 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11116);
                int i11111111111111111117 = i4 & 112;
                int i11111111111111111118 = i4 << 3;
                int i11111111111111111119 = i11111111111111111118 & 458752;
                Modifier modifier11119 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11116 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11116, state, overscrollEffect11116, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11116, composer2, i11111111111111111117 | 1073741824 | (i11111111111111111118 & 7168) | (i11111111111111111118 & 57344) | i11111111111111111119 | (i11111111111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11116, state, composer2, i11111111111111111117);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation11117 = orientation;
                Modifier modifierOverscroll11116 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier11119.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11116, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111118 & 896) | 4096 | (i11111111111111111116 & 57344) | i11111111111111111119 | (i11111111111111111116 & 3670016)), orientation11117), overscrollEffect11116);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11116 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection11116);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11116, ScrollableKt.scrollable(modifierOverscroll11116, state, orientation11117, overscrollEffect11116, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11116, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier11119;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect11117 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i111111111111111111110 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider11117 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111110 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11117);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller11117;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf11117 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf11117) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11117 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11117);
                int i111111111111111111111 = i4 & 112;
                int i111111111111111111112 = i4 << 3;
                int i111111111111111111113 = i111111111111111111112 & 458752;
                Modifier modifier111110 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11117 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11117, state, overscrollEffect11117, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11117, composer2, i111111111111111111111 | 1073741824 | (i111111111111111111112 & 7168) | (i111111111111111111112 & 57344) | i111111111111111111113 | (i111111111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11117, state, composer2, i111111111111111111111);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation11118 = orientation;
                Modifier modifierOverscroll11117 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111110.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11117, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111112 & 896) | 4096 | (i111111111111111111110 & 57344) | i111111111111111111113 | (i111111111111111111110 & 3670016)), orientation11118), overscrollEffect11117);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11117 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection11117);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11117, ScrollableKt.scrollable(modifierOverscroll11117, state, orientation11118, overscrollEffect11117, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11117, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier111110;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i7;
        if ((i & 3670016) != 0) {
            if ((i3 & 64) == 0) {
                i13 = 524288;
            } else {
                i13 = 524288;
            }
            i4 |= i13;
        }
        if ((i3 & 128) != 0) {
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            if ((i3 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(verticalArrangement)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                }
                if ((i3 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                    }
                    if ((i3 & 1024) != 0) {
                        i11 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 4;
                        } else {
                            i12 = 2;
                        }
                        i11 = i2 | i12;
                    } else {
                        i11 = i2;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect11118 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111111111111114 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider11118 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111114 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11118);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller11118;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf11118 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf11118) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11118 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11118);
                        int i111111111111111111115 = i4 & 112;
                        int i111111111111111111116 = i4 << 3;
                        int i111111111111111111117 = i111111111111111111116 & 458752;
                        Modifier modifier111111 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11118 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11118, state, overscrollEffect11118, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11118, composer2, i111111111111111111115 | 1073741824 | (i111111111111111111116 & 7168) | (i111111111111111111116 & 57344) | i111111111111111111117 | (i111111111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11118, state, composer2, i111111111111111111115);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation11119 = orientation;
                        Modifier modifierOverscroll11118 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111111.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11118, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111116 & 896) | 4096 | (i111111111111111111114 & 57344) | i111111111111111111117 | (i111111111111111111114 & 3670016)), orientation11119), overscrollEffect11118);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11118 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection11118);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11118, ScrollableKt.scrollable(modifierOverscroll11118, state, orientation11119, overscrollEffect11118, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11118, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier111111;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        } else {
                            if (i14 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i15 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i5 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                modifier2 = companion;
                            } else {
                                flingBehavior2 = flingBehavior;
                                modifier2 = companion;
                                z5 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        OverscrollEffect overscrollEffect11119 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                        int i111111111111111111118 = i4 >> 3;
                        LazyGridItemProvider lazyGridItemProviderRememberItemProvider11119 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111118 & 14) | ((i11 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11119);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller11119;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Boolean boolValueOf11119 = Boolean.valueOf(z2);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf11119) | composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator11119 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                        state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator11119);
                        int i111111111111111111119 = i4 & 112;
                        int i1111111111111111111110 = i4 << 3;
                        int i1111111111111111111111 = i1111111111111111111110 & 458752;
                        Modifier modifier111112 = modifier2;
                        composer2 = composerStartRestartGroup;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy11119 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider11119, state, overscrollEffect11119, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator11119, composer2, i111111111111111111119 | 1073741824 | (i1111111111111111111110 & 7168) | (i1111111111111111111110 & 57344) | i1111111111111111111111 | (i1111111111111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                        state.setVertical$foundation_release(z2);
                        ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider11119, state, composer2, i111111111111111111119);
                        if (z2) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        Orientation orientation111110 = orientation;
                        Modifier modifierOverscroll11119 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111112.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider11119, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111111110 & 896) | 4096 | (i111111111111111111118 & 57344) | i1111111111111111111111 | (i111111111111111111118 & 3670016)), orientation111110), overscrollEffect11119);
                        composer2.startReplaceableGroup(-1163690407);
                        ComposerKt.sourceInformation(composer2, "*125@5311L7");
                        z6 = !z5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11119 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composer2.consume(localLayoutDirection11119);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = z6;
                        } else {
                            z7 = z6;
                        }
                        composer2.endReplaceableGroup();
                        LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider11119, ScrollableKt.scrollable(modifierOverscroll11119, state, orientation111110, overscrollEffect11119, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy11119, composer2, 0, 0);
                        paddingValues4 = paddingValues3;
                        modifier3 = modifier111112;
                        z8 = z5;
                        flingBehavior3 = flingBehavior2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                        }
                    });
                }
                i10 = C.ENCODING_PCM_32BIT;
                i4 |= i10;
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect111110 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111111112 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider111110 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111111112 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111110);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111110;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf111110 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111110) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111110 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111110);
                    int i1111111111111111111113 = i4 & 112;
                    int i1111111111111111111114 = i4 << 3;
                    int i1111111111111111111115 = i1111111111111111111114 & 458752;
                    Modifier modifier111113 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111110 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111110, state, overscrollEffect111110, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111110, composer2, i1111111111111111111113 | 1073741824 | (i1111111111111111111114 & 7168) | (i1111111111111111111114 & 57344) | i1111111111111111111115 | (i1111111111111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111110, state, composer2, i1111111111111111111113);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111111 = orientation;
                    Modifier modifierOverscroll111110 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111113.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111110, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111111114 & 896) | 4096 | (i1111111111111111111112 & 57344) | i1111111111111111111115 | (i1111111111111111111112 & 3670016)), orientation111111), overscrollEffect111110);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111110 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection111110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111110, ScrollableKt.scrollable(modifierOverscroll111110, state, orientation111111, overscrollEffect111110, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111110, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier111113;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect111111 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111111116 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider111111 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111111116 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111111);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111111;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf111111 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111111) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111111 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111111);
                    int i1111111111111111111117 = i4 & 112;
                    int i1111111111111111111118 = i4 << 3;
                    int i1111111111111111111119 = i1111111111111111111118 & 458752;
                    Modifier modifier111114 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111111 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111111, state, overscrollEffect111111, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111111, composer2, i1111111111111111111117 | 1073741824 | (i1111111111111111111118 & 7168) | (i1111111111111111111118 & 57344) | i1111111111111111111119 | (i1111111111111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111111, state, composer2, i1111111111111111111117);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111112 = orientation;
                    Modifier modifierOverscroll111111 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111114.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111111, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111111118 & 896) | 4096 | (i1111111111111111111116 & 57344) | i1111111111111111111119 | (i1111111111111111111116 & 3670016)), orientation111112), overscrollEffect111111);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111111 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection111111);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111111, ScrollableKt.scrollable(modifierOverscroll111111, state, orientation111112, overscrollEffect111111, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111111, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier111114;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i9 = 100663296;
            i4 |= i9;
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect111112 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111111111110 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider111112 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111111110 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111112);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111112;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf111112 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111112) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111112 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111112);
                    int i11111111111111111111111 = i4 & 112;
                    int i11111111111111111111112 = i4 << 3;
                    int i11111111111111111111113 = i11111111111111111111112 & 458752;
                    Modifier modifier111115 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111112 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111112, state, overscrollEffect111112, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111112, composer2, i11111111111111111111111 | 1073741824 | (i11111111111111111111112 & 7168) | (i11111111111111111111112 & 57344) | i11111111111111111111113 | (i11111111111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111112, state, composer2, i11111111111111111111111);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111113 = orientation;
                    Modifier modifierOverscroll111112 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111115.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111112, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111111112 & 896) | 4096 | (i11111111111111111111110 & 57344) | i11111111111111111111113 | (i11111111111111111111110 & 3670016)), orientation111113), overscrollEffect111112);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111112 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection111112);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111112, ScrollableKt.scrollable(modifierOverscroll111112, state, orientation111113, overscrollEffect111112, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111112, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier111115;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect111113 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i11111111111111111111114 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider111113 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111111114 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111113);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111113;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf111113 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111113) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111113 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111113);
                    int i11111111111111111111115 = i4 & 112;
                    int i11111111111111111111116 = i4 << 3;
                    int i11111111111111111111117 = i11111111111111111111116 & 458752;
                    Modifier modifier111116 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111113 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111113, state, overscrollEffect111113, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111113, composer2, i11111111111111111111115 | 1073741824 | (i11111111111111111111116 & 7168) | (i11111111111111111111116 & 57344) | i11111111111111111111117 | (i11111111111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111113, state, composer2, i11111111111111111111115);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111114 = orientation;
                    Modifier modifierOverscroll111113 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111116.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111113, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111111116 & 896) | 4096 | (i11111111111111111111114 & 57344) | i11111111111111111111117 | (i11111111111111111111114 & 3670016)), orientation111114), overscrollEffect111113);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111113 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection111113);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111113, ScrollableKt.scrollable(modifierOverscroll111113, state, orientation111114, overscrollEffect111113, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111113, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier111116;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i10 = C.ENCODING_PCM_32BIT;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect111114 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111111118 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider111114 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111111118 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111114);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller111114;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf111114 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf111114) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111114 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111114);
                int i11111111111111111111119 = i4 & 112;
                int i111111111111111111111110 = i4 << 3;
                int i111111111111111111111111 = i111111111111111111111110 & 458752;
                Modifier modifier111117 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111114 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111114, state, overscrollEffect111114, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111114, composer2, i11111111111111111111119 | 1073741824 | (i111111111111111111111110 & 7168) | (i111111111111111111111110 & 57344) | i111111111111111111111111 | (i111111111111111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111114, state, composer2, i11111111111111111111119);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation111115 = orientation;
                Modifier modifierOverscroll111114 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111117.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111114, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111111110 & 896) | 4096 | (i11111111111111111111118 & 57344) | i111111111111111111111111 | (i11111111111111111111118 & 3670016)), orientation111115), overscrollEffect111114);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111114 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection111114);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111114, ScrollableKt.scrollable(modifierOverscroll111114, state, orientation111115, overscrollEffect111114, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111114, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier111117;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect111115 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i111111111111111111111112 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider111115 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111111112 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111115);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller111115;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf111115 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf111115) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111115 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111115);
                int i111111111111111111111113 = i4 & 112;
                int i111111111111111111111114 = i4 << 3;
                int i111111111111111111111115 = i111111111111111111111114 & 458752;
                Modifier modifier111118 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111115 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111115, state, overscrollEffect111115, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111115, composer2, i111111111111111111111113 | 1073741824 | (i111111111111111111111114 & 7168) | (i111111111111111111111114 & 57344) | i111111111111111111111115 | (i111111111111111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111115, state, composer2, i111111111111111111111113);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation111116 = orientation;
                Modifier modifierOverscroll111115 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111118.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111115, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111111114 & 896) | 4096 | (i111111111111111111111112 & 57344) | i111111111111111111111115 | (i111111111111111111111112 & 3670016)), orientation111116), overscrollEffect111115);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111115 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection111115);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111115, ScrollableKt.scrollable(modifierOverscroll111115, state, orientation111116, overscrollEffect111115, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111115, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier111118;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i4 |= 12582912;
        if ((i3 & 256) != 0) {
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(verticalArrangement)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
            }
            if ((i3 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                }
                if ((i3 & 1024) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i4 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect111116 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i111111111111111111111116 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider111116 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111111116 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111116);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111116;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf111116 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111116) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111116 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111116);
                    int i111111111111111111111117 = i4 & 112;
                    int i111111111111111111111118 = i4 << 3;
                    int i111111111111111111111119 = i111111111111111111111118 & 458752;
                    Modifier modifier111119 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111116 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111116, state, overscrollEffect111116, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111116, composer2, i111111111111111111111117 | 1073741824 | (i111111111111111111111118 & 7168) | (i111111111111111111111118 & 57344) | i111111111111111111111119 | (i111111111111111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111116, state, composer2, i111111111111111111111117);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111117 = orientation;
                    Modifier modifierOverscroll111116 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier111119.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111116, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111111118 & 896) | 4096 | (i111111111111111111111116 & 57344) | i111111111111111111111119 | (i111111111111111111111116 & 3670016)), orientation111117), overscrollEffect111116);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111116 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection111116);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111116, ScrollableKt.scrollable(modifierOverscroll111116, state, orientation111117, overscrollEffect111116, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111116, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier111119;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    } else {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i15 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            modifier2 = companion;
                        } else {
                            flingBehavior2 = flingBehavior;
                            modifier2 = companion;
                            z5 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    OverscrollEffect overscrollEffect111117 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i1111111111111111111111110 = i4 >> 3;
                    LazyGridItemProvider lazyGridItemProviderRememberItemProvider111117 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111111111110 & 14) | ((i11 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111117);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111117;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf111117 = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111117) | composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111117 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                    state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111117);
                    int i1111111111111111111111111 = i4 & 112;
                    int i1111111111111111111111112 = i4 << 3;
                    int i1111111111111111111111113 = i1111111111111111111111112 & 458752;
                    Modifier modifier1111110 = modifier2;
                    composer2 = composerStartRestartGroup;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111117 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111117, state, overscrollEffect111117, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111117, composer2, i1111111111111111111111111 | 1073741824 | (i1111111111111111111111112 & 7168) | (i1111111111111111111111112 & 57344) | i1111111111111111111111113 | (i1111111111111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                    state.setVertical$foundation_release(z2);
                    ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111117, state, composer2, i1111111111111111111111111);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation111118 = orientation;
                    Modifier modifierOverscroll111117 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111110.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111117, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111111111112 & 896) | 4096 | (i1111111111111111111111110 & 57344) | i1111111111111111111111113 | (i1111111111111111111111110 & 3670016)), orientation111118), overscrollEffect111117);
                    composer2.startReplaceableGroup(-1163690407);
                    ComposerKt.sourceInformation(composer2, "*125@5311L7");
                    z6 = !z5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111117 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection111117);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = z6;
                    } else {
                        z7 = z6;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111117, ScrollableKt.scrollable(modifierOverscroll111117, state, orientation111118, overscrollEffect111117, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111117, composer2, 0, 0);
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier1111110;
                    z8 = z5;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i10 = C.ENCODING_PCM_32BIT;
            i4 |= i10;
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect111118 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i1111111111111111111111114 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider111118 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111111111114 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111118);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller111118;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf111118 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf111118) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111118 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111118);
                int i1111111111111111111111115 = i4 & 112;
                int i1111111111111111111111116 = i4 << 3;
                int i1111111111111111111111117 = i1111111111111111111111116 & 458752;
                Modifier modifier1111111 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111118 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111118, state, overscrollEffect111118, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111118, composer2, i1111111111111111111111115 | 1073741824 | (i1111111111111111111111116 & 7168) | (i1111111111111111111111116 & 57344) | i1111111111111111111111117 | (i1111111111111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111118, state, composer2, i1111111111111111111111115);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation111119 = orientation;
                Modifier modifierOverscroll111118 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111111.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111118, state, coroutineScope, z2, z5, z3, composer2, (i1111111111111111111111116 & 896) | 4096 | (i1111111111111111111111114 & 57344) | i1111111111111111111111117 | (i1111111111111111111111114 & 3670016)), orientation111119), overscrollEffect111118);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111118 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection111118);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111118, ScrollableKt.scrollable(modifierOverscroll111118, state, orientation111119, overscrollEffect111118, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111118, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier1111111;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect111119 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i1111111111111111111111118 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider111119 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1111111111111111111111118 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111119);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller111119;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf111119 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf111119) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator111119 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator111119);
                int i1111111111111111111111119 = i4 & 112;
                int i11111111111111111111111110 = i4 << 3;
                int i11111111111111111111111111 = i11111111111111111111111110 & 458752;
                Modifier modifier1111112 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy111119 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider111119, state, overscrollEffect111119, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator111119, composer2, i1111111111111111111111119 | 1073741824 | (i11111111111111111111111110 & 7168) | (i11111111111111111111111110 & 57344) | i11111111111111111111111111 | (i11111111111111111111111110 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider111119, state, composer2, i1111111111111111111111119);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111110 = orientation;
                Modifier modifierOverscroll111119 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111112.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider111119, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111111111110 & 896) | 4096 | (i1111111111111111111111118 & 57344) | i11111111111111111111111111 | (i1111111111111111111111118 & 3670016)), orientation1111110), overscrollEffect111119);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111119 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection111119);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider111119, ScrollableKt.scrollable(modifierOverscroll111119, state, orientation1111110, overscrollEffect111119, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy111119, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier1111112;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i9 = 100663296;
        i4 |= i9;
        if ((i3 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(horizontalArrangement)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
            }
            if ((i3 & 1024) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i4 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect1111110 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111111111112 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider1111110 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111111111112 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111110);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller1111110;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf1111110 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf1111110) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1111110 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1111110);
                int i11111111111111111111111113 = i4 & 112;
                int i11111111111111111111111114 = i4 << 3;
                int i11111111111111111111111115 = i11111111111111111111111114 & 458752;
                Modifier modifier1111113 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1111110 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1111110, state, overscrollEffect1111110, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1111110, composer2, i11111111111111111111111113 | 1073741824 | (i11111111111111111111111114 & 7168) | (i11111111111111111111111114 & 57344) | i11111111111111111111111115 | (i11111111111111111111111114 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1111110, state, composer2, i11111111111111111111111113);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111111 = orientation;
                Modifier modifierOverscroll1111110 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111113.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1111110, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111111111114 & 896) | 4096 | (i11111111111111111111111112 & 57344) | i11111111111111111111111115 | (i11111111111111111111111112 & 3670016)), orientation1111111), overscrollEffect1111110);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111110 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection1111110);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1111110, ScrollableKt.scrollable(modifierOverscroll1111110, state, orientation1111111, overscrollEffect1111110, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1111110, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier1111113;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i15 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        modifier2 = companion;
                    } else {
                        flingBehavior2 = flingBehavior;
                        modifier2 = companion;
                        z5 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                OverscrollEffect overscrollEffect1111111 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i11111111111111111111111116 = i4 >> 3;
                LazyGridItemProvider lazyGridItemProviderRememberItemProvider1111111 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i11111111111111111111111116 & 14) | ((i11 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111111);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller1111111;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf1111111 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf1111111) | composerStartRestartGroup.changed(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1111111 = (LazyGridItemPlacementAnimator) objRememberedValue2;
                state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1111111);
                int i11111111111111111111111117 = i4 & 112;
                int i11111111111111111111111118 = i4 << 3;
                int i11111111111111111111111119 = i11111111111111111111111118 & 458752;
                Modifier modifier1111114 = modifier2;
                composer2 = composerStartRestartGroup;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1111111 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1111111, state, overscrollEffect1111111, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1111111, composer2, i11111111111111111111111117 | 1073741824 | (i11111111111111111111111118 & 7168) | (i11111111111111111111111118 & 57344) | i11111111111111111111111119 | (i11111111111111111111111118 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
                state.setVertical$foundation_release(z2);
                ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1111111, state, composer2, i11111111111111111111111117);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation1111112 = orientation;
                Modifier modifierOverscroll1111111 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111114.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1111111, state, coroutineScope, z2, z5, z3, composer2, (i11111111111111111111111118 & 896) | 4096 | (i11111111111111111111111116 & 57344) | i11111111111111111111111119 | (i11111111111111111111111116 & 3670016)), orientation1111112), overscrollEffect1111111);
                composer2.startReplaceableGroup(-1163690407);
                ComposerKt.sourceInformation(composer2, "*125@5311L7");
                z6 = !z5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111111 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection1111111);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = z6;
                } else {
                    z7 = z6;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1111111, ScrollableKt.scrollable(modifierOverscroll1111111, state, orientation1111112, overscrollEffect1111111, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1111111, composer2, 0, 0);
                paddingValues4 = paddingValues3;
                modifier3 = modifier1111114;
                z8 = z5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i10 = C.ENCODING_PCM_32BIT;
        i4 |= i10;
        if ((i3 & 1024) != 0) {
            i11 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i12 = 4;
            } else {
                i12 = 2;
            }
            i11 = i2 | i12;
        } else {
            i11 = i2;
        }
        if ((i4 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i15 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    modifier2 = companion;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = companion;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                }
            } else {
                if (i14 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i15 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    modifier2 = companion;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = companion;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                }
            }
            composerStartRestartGroup.endDefaults();
            OverscrollEffect overscrollEffect1111112 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
            int i111111111111111111111111110 = i4 >> 3;
            LazyGridItemProvider lazyGridItemProviderRememberItemProvider1111112 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111111111110 & 14) | ((i11 << 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111112);
                objRememberedValue = compositionScopedCoroutineScopeCanceller1111112;
            }
            composerStartRestartGroup.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Boolean boolValueOf1111112 = Boolean.valueOf(z2);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(boolValueOf1111112) | composerStartRestartGroup.changed(state);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1111112 = (LazyGridItemPlacementAnimator) objRememberedValue2;
            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1111112);
            int i111111111111111111111111111 = i4 & 112;
            int i111111111111111111111111112 = i4 << 3;
            int i111111111111111111111111113 = i111111111111111111111111112 & 458752;
            Modifier modifier1111115 = modifier2;
            composer2 = composerStartRestartGroup;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1111112 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1111112, state, overscrollEffect1111112, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1111112, composer2, i111111111111111111111111111 | 1073741824 | (i111111111111111111111111112 & 7168) | (i111111111111111111111111112 & 57344) | i111111111111111111111111113 | (i111111111111111111111111112 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
            state.setVertical$foundation_release(z2);
            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1111112, state, composer2, i111111111111111111111111111);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation1111113 = orientation;
            Modifier modifierOverscroll1111112 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111115.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1111112, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111111111112 & 896) | 4096 | (i111111111111111111111111110 & 57344) | i111111111111111111111111113 | (i111111111111111111111111110 & 3670016)), orientation1111113), overscrollEffect1111112);
            composer2.startReplaceableGroup(-1163690407);
            ComposerKt.sourceInformation(composer2, "*125@5311L7");
            z6 = !z5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111112 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            objConsume = composer2.consume(localLayoutDirection1111112);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (objConsume == LayoutDirection.Rtl) {
                z7 = z6;
            } else {
                z7 = z6;
            }
            composer2.endReplaceableGroup();
            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1111112, ScrollableKt.scrollable(modifierOverscroll1111112, state, orientation1111113, overscrollEffect1111112, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1111112, composer2, 0, 0);
            paddingValues4 = paddingValues3;
            modifier3 = modifier1111115;
            z8 = z5;
            flingBehavior3 = flingBehavior2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i15 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    modifier2 = companion;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = companion;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                }
            } else {
                if (i14 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i15 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    modifier2 = companion;
                } else {
                    flingBehavior2 = flingBehavior;
                    modifier2 = companion;
                    z5 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                }
            }
            composerStartRestartGroup.endDefaults();
            OverscrollEffect overscrollEffect1111113 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
            int i111111111111111111111111114 = i4 >> 3;
            LazyGridItemProvider lazyGridItemProviderRememberItemProvider1111113 = LazyGridItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i111111111111111111111111114 & 14) | ((i11 << 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111113);
                objRememberedValue = compositionScopedCoroutineScopeCanceller1111113;
            }
            composerStartRestartGroup.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Boolean boolValueOf1111113 = Boolean.valueOf(z2);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(boolValueOf1111113) | composerStartRestartGroup.changed(state);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new LazyGridItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator1111113 = (LazyGridItemPlacementAnimator) objRememberedValue2;
            state.setPlacementAnimator$foundation_release(lazyGridItemPlacementAnimator1111113);
            int i111111111111111111111111115 = i4 & 112;
            int i111111111111111111111111116 = i4 << 3;
            int i111111111111111111111111117 = i111111111111111111111111116 & 458752;
            Modifier modifier1111116 = modifier2;
            composer2 = composerStartRestartGroup;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyGridMeasurePolicy1111113 = rememberLazyGridMeasurePolicy(lazyGridItemProviderRememberItemProvider1111113, state, overscrollEffect1111113, slotSizesSums, paddingValues3, z5, z2, horizontalArrangement, verticalArrangement, lazyGridItemPlacementAnimator1111113, composer2, i111111111111111111111111115 | 1073741824 | (i111111111111111111111111116 & 7168) | (i111111111111111111111111116 & 57344) | i111111111111111111111111117 | (i111111111111111111111111116 & 3670016) | ((i4 >> 6) & 29360128) | (i4 & 234881024), 0);
            state.setVertical$foundation_release(z2);
            ScrollPositionUpdater(lazyGridItemProviderRememberItemProvider1111113, state, composer2, i111111111111111111111111115);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation1111114 = orientation;
            Modifier modifierOverscroll1111113 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyGridSemantics(modifier1111116.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyGridItemProviderRememberItemProvider1111113, state, coroutineScope, z2, z5, z3, composer2, (i111111111111111111111111116 & 896) | 4096 | (i111111111111111111111111114 & 57344) | i111111111111111111111111117 | (i111111111111111111111111114 & 3670016)), orientation1111114), overscrollEffect1111113);
            composer2.startReplaceableGroup(-1163690407);
            ComposerKt.sourceInformation(composer2, "*125@5311L7");
            z6 = !z5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111113 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            objConsume = composer2.consume(localLayoutDirection1111113);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (objConsume == LayoutDirection.Rtl) {
                z7 = z6;
            } else {
                z7 = z6;
            }
            composer2.endReplaceableGroup();
            LazyLayoutKt.LazyLayout(lazyGridItemProviderRememberItemProvider1111113, ScrollableKt.scrollable(modifierOverscroll1111113, state, orientation1111114, overscrollEffect1111113, z3, z7, flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyGridMeasurePolicy1111113, composer2, 0, 0);
            paddingValues4 = paddingValues3;
            modifier3 = modifier1111116;
            z8 = z5;
            flingBehavior3 = flingBehavior2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i20) {
                LazyGridKt.LazyGrid(modifier3, state, slotSizesSums, paddingValues4, z8, z2, flingBehavior3, z3, verticalArrangement, horizontalArrangement, content, composer3, i | 1, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final LazyGridItemProvider lazyGridItemProvider, final LazyGridState lazyGridState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(950944068);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyGridItemProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (lazyGridItemProvider.getItemCount() > 0) {
                lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.ScrollPositionUpdater.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                LazyGridKt.ScrollPositionUpdater(lazyGridItemProvider, lazyGridState, composer2, i | 1);
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final LazyGridItemProvider lazyGridItemProvider, final LazyGridState lazyGridState, final OverscrollEffect overscrollEffect, final Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, final PaddingValues paddingValues, final boolean z, final boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1958911962);
        ComposerKt.sourceInformation(composer, "C(rememberLazyGridMeasurePolicy)P(3,8,4,7!1,6,2!1,9)178@7377L8234:LazyGrid.kt#7791vq");
        Arrangement.Horizontal horizontal2 = (i2 & 128) != 0 ? null : horizontal;
        Arrangement.Vertical vertical2 = (i2 & 256) == 0 ? vertical : null;
        Object[] objArr = {lazyGridState, overscrollEffect, function2, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal2, vertical2, lazyGridItemPlacementAnimator};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i3 = 0; i3 < 9; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical vertical3 = vertical2;
            final Arrangement.Horizontal horizontal3 = horizontal2;
            objRememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m594invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m594invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i4;
                    int i5;
                    int i6;
                    float spacing;
                    float spacing2;
                    int iM3799getMaxWidthimpl;
                    long jIntOffset;
                    int firstVisibleItemScrollOffset;
                    int iM610getLineIndexOfItem_Ze7BM;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m191checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i4 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.mo404calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i4 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.mo405calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i7 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.getTop());
                    int i8 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.getBottom());
                    final int i9 = i7 + i8;
                    final int i10 = i4 + i5;
                    boolean z3 = z2;
                    int i11 = z3 ? i9 : i10;
                    if (z3 && !z) {
                        i6 = i7;
                    } else if (z3 && z) {
                        i6 = i8;
                    } else {
                        i6 = (z3 || z) ? i5 : i4;
                    }
                    final int i12 = i11 - i6;
                    long jM3815offsetNN6EwU = ConstraintsKt.m3815offsetNN6EwU(j, -i10, -i9);
                    lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
                    final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProvider.getSpanLayoutProvider();
                    final List<Integer> listInvoke = function2.invoke(lazyLayoutMeasureScope, Constraints.m3787boximpl(j));
                    spanLayoutProvider.setSlotsPerLine(listInvoke.size());
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    lazyGridState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    lazyGridState.setSlotsPerLine$foundation_release(listInvoke.size());
                    if (z2) {
                        Arrangement.Vertical vertical4 = vertical3;
                        if (vertical4 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical4.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal4 = horizontal3;
                        if (horizontal4 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal4.getSpacing();
                    }
                    int i13 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(spacing);
                    if (z2) {
                        Arrangement.Horizontal horizontal5 = horizontal3;
                        spacing2 = horizontal5 != null ? horizontal5.getSpacing() : Dp.m3843constructorimpl(0);
                    } else {
                        Arrangement.Vertical vertical5 = vertical3;
                        spacing2 = vertical5 != null ? vertical5.getSpacing() : Dp.m3843constructorimpl(0);
                    }
                    final int i14 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(spacing2);
                    int itemCount = lazyGridItemProvider.getItemCount();
                    if (z2) {
                        iM3799getMaxWidthimpl = Constraints.m3798getMaxHeightimpl(j) - i9;
                    } else {
                        iM3799getMaxWidthimpl = Constraints.m3799getMaxWidthimpl(j) - i10;
                    }
                    int i15 = iM3799getMaxWidthimpl;
                    if (!z || i15 > 0) {
                        jIntOffset = IntOffsetKt.IntOffset(i4, i7);
                    } else {
                        boolean z4 = z2;
                        if (!z4) {
                            i4 += i15;
                        }
                        if (z4) {
                            i7 += i15;
                        }
                        jIntOffset = IntOffsetKt.IntOffset(i4, i7);
                    }
                    final long j2 = jIntOffset;
                    LazyGridItemProvider lazyGridItemProvider2 = lazyGridItemProvider;
                    final boolean z5 = z2;
                    final boolean z6 = z;
                    final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator2 = lazyGridItemPlacementAnimator;
                    final int i16 = i6;
                    LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(lazyGridItemProvider2, lazyLayoutMeasureScope, i13, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        @Override // androidx.compose.foundation.lazy.grid.MeasuredItemFactory
                        /* JADX INFO: renamed from: createItem-PU_OBEw, reason: not valid java name */
                        public final LazyMeasuredItem mo596createItemPU_OBEw(int i17, Object key, int i18, int i19, Placeable[] placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyMeasuredItem(i17, key, z5, i18, i19, z6, lazyLayoutMeasureScope.getLayoutDirection(), i16, i12, placeables, lazyGridItemPlacementAnimator2, j2, null);
                        }
                    });
                    boolean z7 = z2;
                    final boolean z8 = z2;
                    final LazyMeasuredLineProvider lazyMeasuredLineProvider = new LazyMeasuredLineProvider(z7, listInvoke, i14, itemCount, i13, lazyMeasuredItemProvider, spanLayoutProvider, new MeasuredLineFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        @Override // androidx.compose.foundation.lazy.grid.MeasuredLineFactory
                        /* JADX INFO: renamed from: createLine-H9FfpSk, reason: not valid java name */
                        public final LazyMeasuredLine mo597createLineH9FfpSk(int i17, LazyMeasuredItem[] items, List<GridItemSpan> spans, int i18) {
                            Intrinsics.checkNotNullParameter(items, "items");
                            Intrinsics.checkNotNullParameter(spans, "spans");
                            return new LazyMeasuredLine(i17, items, spans, z8, listInvoke.size(), lazyLayoutMeasureScope.getLayoutDirection(), i18, i14, null);
                        }
                    });
                    lazyGridState.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
                            return m595invokebKFJvoY(lineIndex.m630unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-bKFJvoY, reason: not valid java name */
                        public final ArrayList<Pair<Integer, Constraints>> m595invokebKFJvoY(int i17) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(i17);
                            int iM568constructorimpl = ItemIndex.m568constructorimpl(lineConfiguration.getFirstItemIndex());
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyMeasuredLineProvider lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
                            int size = spans.size();
                            int i18 = 0;
                            for (int i19 = 0; i19 < size; i19++) {
                                int iM562getCurrentLineSpanimpl = GridItemSpan.m562getCurrentLineSpanimpl(spans.get(i19).getPackedValue());
                                arrayList.add(TuplesKt.to(Integer.valueOf(iM568constructorimpl), lazyMeasuredLineProvider2.getChildConstraints$foundation_release().invoke(Integer.valueOf(i18), Integer.valueOf(iM562getCurrentLineSpanimpl))));
                                iM568constructorimpl = ItemIndex.m568constructorimpl(iM568constructorimpl + 1);
                                i18 += iM562getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    });
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyGridState lazyGridState2 = lazyGridState;
                    Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                        try {
                            if (lazyGridState2.getFirstVisibleItemIndex() < itemCount || itemCount <= 0) {
                                int iM610getLineIndexOfItem_Ze7BM2 = spanLayoutProvider.m610getLineIndexOfItem_Ze7BM(lazyGridState2.getFirstVisibleItemIndex());
                                firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
                                iM610getLineIndexOfItem_Ze7BM = iM610getLineIndexOfItem_Ze7BM2;
                            } else {
                                firstVisibleItemScrollOffset = 0;
                                iM610getLineIndexOfItem_Ze7BM = spanLayoutProvider.m610getLineIndexOfItem_Ze7BM(itemCount - 1);
                            }
                            Unit unit = Unit.INSTANCE;
                            snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                            snapshotCreateNonObservableSnapshot.dispose();
                            LazyGridMeasureResult lazyGridMeasureResultM598measureLazyGridzIfe3eg = LazyGridMeasureKt.m598measureLazyGridzIfe3eg(itemCount, lazyMeasuredLineProvider, lazyMeasuredItemProvider, i15, listInvoke.size(), i6, i12, iM610getLineIndexOfItem_Ze7BM, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), jM3815offsetNN6EwU, z2, vertical3, horizontal3, z, lazyLayoutMeasureScope2, lazyGridItemPlacementAnimator, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i17, int i18, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                    Intrinsics.checkNotNullParameter(placement, "placement");
                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m3813constrainWidthK40F9xA(j, i17 + i10), ConstraintsKt.m3812constrainHeightK40F9xA(j, i18 + i9), MapsKt.emptyMap(), placement);
                                }
                            });
                            LazyGridState lazyGridState3 = lazyGridState;
                            OverscrollEffect overscrollEffect2 = overscrollEffect;
                            lazyGridState3.applyMeasureResult$foundation_release(lazyGridMeasureResultM598measureLazyGridzIfe3eg);
                            LazyGridKt.refreshOverscrollInfo(overscrollEffect2, lazyGridMeasureResultM598measureLazyGridzIfe3eg);
                            return lazyGridMeasureResultM598measureLazyGridzIfe3eg;
                        } catch (Throwable th) {
                            snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        snapshotCreateNonObservableSnapshot.dispose();
                        throw th2;
                    }
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function3 = (Function2) objRememberedValue;
        composer.endReplaceableGroup();
        return function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyGridMeasureResult lazyGridMeasureResult) {
        Object obj;
        LazyMeasuredItem[] items;
        boolean canScrollForward = lazyGridMeasureResult.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        if (firstVisibleLine == null || (items = firstVisibleLine.getItems()) == null || (obj = (LazyMeasuredItem) ArraysKt.firstOrNull(items)) == null) {
            obj = 0;
        }
        overscrollEffect.setEnabled(canScrollForward || (!Intrinsics.areEqual(obj, (Object) 0) || lazyGridMeasureResult.getFirstVisibleLineScrollOffset() != 0));
    }
}
