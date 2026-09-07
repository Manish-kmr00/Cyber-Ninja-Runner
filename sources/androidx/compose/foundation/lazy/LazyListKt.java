package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
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
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0097\u0001\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0002\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyListKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0142  */
    /* JADX WARN: Code duplicated, block: B:102:0x0145  */
    /* JADX WARN: Code duplicated, block: B:106:0x014d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0152  */
    /* JADX WARN: Code duplicated, block: B:109:0x0158  */
    /* JADX WARN: Code duplicated, block: B:111:0x015e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0161  */
    /* JADX WARN: Code duplicated, block: B:114:0x0166  */
    /* JADX WARN: Code duplicated, block: B:117:0x016c  */
    /* JADX WARN: Code duplicated, block: B:118:0x016f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0173  */
    /* JADX WARN: Code duplicated, block: B:122:0x0179  */
    /* JADX WARN: Code duplicated, block: B:123:0x017c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0189  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:136:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:151:0x021a  */
    /* JADX WARN: Code duplicated, block: B:154:0x0255  */
    /* JADX WARN: Code duplicated, block: B:156:0x025d  */
    /* JADX WARN: Code duplicated, block: B:159:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:160:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:163:0x0367 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:165:0x036c  */
    /* JADX WARN: Code duplicated, block: B:170:0x039d  */
    /* JADX WARN: Code duplicated, block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00df  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:81:0x0102  */
    /* JADX WARN: Code duplicated, block: B:82:0x0105  */
    /* JADX WARN: Code duplicated, block: B:86:0x010f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0116  */
    /* JADX WARN: Code duplicated, block: B:89:0x011c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0122  */
    /* JADX WARN: Code duplicated, block: B:92:0x0125  */
    /* JADX WARN: Code duplicated, block: B:96:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0134  */
    /* JADX WARN: Code duplicated, block: B:99:0x013c  */
    public static final void LazyList(final Modifier modifier, final LazyListState state, final PaddingValues contentPadding, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> content, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Alignment.Horizontal horizontal3;
        Arrangement.Vertical vertical3;
        Alignment.Vertical vertical4;
        Arrangement.Horizontal horizontal4;
        Object objRememberedValue;
        Object objRememberedValue2;
        CoroutineScope coroutineScope;
        boolean zChanged;
        Object objRememberedValue3;
        Composer composer2;
        Orientation orientation;
        boolean z4;
        Object objConsume;
        boolean z5;
        final Alignment.Horizontal horizontal5;
        final Arrangement.Vertical vertical5;
        final Alignment.Vertical vertical6;
        final Arrangement.Horizontal horizontal6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(955299798);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyList)P(6,8,1,7,5,2,9,3,11,10,4)76@3553L18,77@3595L36,78@3659L39,79@3715L24,80@3768L92,85@3934L334,100@4274L42,107@4554L293,116@4911L68,117@4993L48,103@4409L1768:LazyList.kt#428nma");
        if ((i3 & 1) != 0) {
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
            i4 |= composerStartRestartGroup.changed(contentPadding) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((i3 & 32) == 0) {
            if ((i & 458752) == 0) {
                i5 = composerStartRestartGroup.changed(flingBehavior) ? 131072 : 65536;
            }
            if ((i3 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(vertical)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    i4 |= C.ENCODING_PCM_32BIT;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 1024;
                if (i13 != 0) {
                    i14 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i14 = i2 | i15;
                } else {
                    i14 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i14 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i16 = 32;
                    } else {
                        i16 = 16;
                    }
                    i14 |= i16;
                }
                if ((1533916891 & i4) == 306783378 || (i14 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
                    if (i7 != 0) {
                        horizontal3 = null;
                    } else {
                        horizontal3 = horizontal;
                    }
                    if (i9 != 0) {
                        vertical3 = null;
                    } else {
                        vertical3 = vertical;
                    }
                    if (i11 != 0) {
                        vertical4 = null;
                    } else {
                        vertical4 = vertical2;
                    }
                    if (i13 != 0) {
                        horizontal4 = null;
                    } else {
                        horizontal4 = horizontal2;
                    }
                    OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                    int i17 = i4 >> 3;
                    LazyListItemProvider lazyListItemProviderRememberItemProvider = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i17 & 14) | (i14 & 112));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new LazyListBeyondBoundsInfo();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = (LazyListBeyondBoundsInfo) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Boolean boolValueOf = Boolean.valueOf(z2);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(state);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    LazyListItemPlacementAnimator lazyListItemPlacementAnimator = (LazyListItemPlacementAnimator) objRememberedValue3;
                    state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator);
                    int i18 = i4 & 112;
                    int i19 = i4 << 6;
                    int i20 = i19 & 458752;
                    int i21 = i4;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider, state, lazyListBeyondBoundsInfo, overscrollEffect, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator, composerStartRestartGroup, i18 | (MutableVector.$stable << 6) | (i19 & 57344) | i20 | (i19 & 3670016) | (i4 & 29360128) | (i17 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
                    composer2 = composerStartRestartGroup;
                    ScrollPositionUpdater(lazyListItemProviderRememberItemProvider, state, composer2, i18);
                    if (z2) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Horizontal;
                    }
                    Orientation orientation2 = orientation;
                    Modifier modifierOverscroll = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider, state, coroutineScope, z2, z, z3, composer2, ((i21 << 3) & 896) | 4096 | (i21 & 57344) | i20 | (i21 & 3670016)), orientation2), state, lazyListBeyondBoundsInfo, z, composer2, (MutableVector.$stable << 6) | i18 | (i21 & 7168)), state, lazyListBeyondBoundsInfo, composer2, (MutableVector.$stable << 6) | i18), overscrollEffect);
                    composer2.startReplaceableGroup(-908836175);
                    ComposerKt.sourceInformation(composer2, "*126@5575L7");
                    z4 = !z;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (objConsume == LayoutDirection.Rtl || z2) {
                        z5 = z4;
                    } else {
                        z5 = z;
                    }
                    composer2.endReplaceableGroup();
                    LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider, ScrollableKt.scrollable(modifierOverscroll, state, orientation2, overscrollEffect, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy, composer2, 0, 0);
                    horizontal5 = horizontal3;
                    vertical5 = vertical3;
                    vertical6 = vertical4;
                    horizontal6 = horizontal4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    vertical5 = vertical;
                    vertical6 = vertical2;
                    horizontal6 = horizontal2;
                    composer2 = composerStartRestartGroup;
                    horizontal5 = horizontal;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.2
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

                    public final void invoke(Composer composer3, int i22) {
                        LazyListKt.LazyList(modifier, state, contentPadding, z, z2, flingBehavior, z3, horizontal5, vertical5, vertical6, horizontal6, content, composer3, i | 1, i2, i3);
                    }
                });
            }
            i4 |= 1572864;
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i4 |= i10;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                i4 |= C.ENCODING_PCM_32BIT;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
                i4 |= i12;
            }
            i13 = i3 & 1024;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i14 = i2 | i15;
            } else {
                i14 = i2;
            }
            if ((i3 & 2048) != 0) {
                i14 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i14 |= i16;
            }
            if ((1533916891 & i4) == 306783378) {
                if (i7 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i9 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i11 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i13 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                OverscrollEffect overscrollEffect2 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i110 = i4 >> 3;
                LazyListItemProvider lazyListItemProviderRememberItemProvider2 = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i110 & 14) | (i14 & 112));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyListBeyondBoundsInfo();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo2 = (LazyListBeyondBoundsInfo) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller2;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf2 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(state);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListItemPlacementAnimator lazyListItemPlacementAnimator2 = (LazyListItemPlacementAnimator) objRememberedValue3;
                state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator2);
                int i111 = i4 & 112;
                int i112 = i4 << 6;
                int i22 = i112 & 458752;
                int i23 = i4;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider2, state, lazyListBeyondBoundsInfo2, overscrollEffect2, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator2, composerStartRestartGroup, i111 | (MutableVector.$stable << 6) | (i112 & 57344) | i22 | (i112 & 3670016) | (i4 & 29360128) | (i110 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(lazyListItemProviderRememberItemProvider2, state, composer2, i111);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation3 = orientation;
                Modifier modifierOverscroll2 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider2, state, coroutineScope, z2, z, z3, composer2, ((i23 << 3) & 896) | 4096 | (i23 & 57344) | i22 | (i23 & 3670016)), orientation3), state, lazyListBeyondBoundsInfo2, z, composer2, (MutableVector.$stable << 6) | i111 | (i23 & 7168)), state, lazyListBeyondBoundsInfo2, composer2, (MutableVector.$stable << 6) | i111), overscrollEffect2);
                composer2.startReplaceableGroup(-908836175);
                ComposerKt.sourceInformation(composer2, "*126@5575L7");
                z4 = !z;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z5 = z4;
                } else {
                    z5 = z4;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider2, ScrollableKt.scrollable(modifierOverscroll2, state, orientation3, overscrollEffect2, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy2, composer2, 0, 0);
                horizontal5 = horizontal3;
                vertical5 = vertical3;
                vertical6 = vertical4;
                horizontal6 = horizontal4;
            } else {
                if (i7 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i9 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i11 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i13 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                OverscrollEffect overscrollEffect3 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i113 = i4 >> 3;
                LazyListItemProvider lazyListItemProviderRememberItemProvider3 = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i113 & 14) | (i14 & 112));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyListBeyondBoundsInfo();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo3 = (LazyListBeyondBoundsInfo) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller3;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf3 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(state);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListItemPlacementAnimator lazyListItemPlacementAnimator3 = (LazyListItemPlacementAnimator) objRememberedValue3;
                state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator3);
                int i114 = i4 & 112;
                int i115 = i4 << 6;
                int i24 = i115 & 458752;
                int i25 = i4;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy3 = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider3, state, lazyListBeyondBoundsInfo3, overscrollEffect3, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator3, composerStartRestartGroup, i114 | (MutableVector.$stable << 6) | (i115 & 57344) | i24 | (i115 & 3670016) | (i4 & 29360128) | (i113 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(lazyListItemProviderRememberItemProvider3, state, composer2, i114);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation4 = orientation;
                Modifier modifierOverscroll3 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider3, state, coroutineScope, z2, z, z3, composer2, ((i25 << 3) & 896) | 4096 | (i25 & 57344) | i24 | (i25 & 3670016)), orientation4), state, lazyListBeyondBoundsInfo3, z, composer2, (MutableVector.$stable << 6) | i114 | (i25 & 7168)), state, lazyListBeyondBoundsInfo3, composer2, (MutableVector.$stable << 6) | i114), overscrollEffect3);
                composer2.startReplaceableGroup(-908836175);
                ComposerKt.sourceInformation(composer2, "*126@5575L7");
                z4 = !z;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z5 = z4;
                } else {
                    z5 = z4;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider3, ScrollableKt.scrollable(modifierOverscroll3, state, orientation4, overscrollEffect3, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy3, composer2, 0, 0);
                horizontal5 = horizontal3;
                vertical5 = vertical3;
                vertical6 = vertical4;
                horizontal6 = horizontal4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.2
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

                public final void invoke(Composer composer3, int i26) {
                    LazyListKt.LazyList(modifier, state, contentPadding, z, z2, flingBehavior, z3, horizontal5, vertical5, vertical6, horizontal6, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i5 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i5;
        if ((i3 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            i9 = i3 & 256;
            if (i9 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(vertical)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i4 |= i10;
            }
            i11 = i3 & 512;
            if (i11 != 0) {
                i4 |= C.ENCODING_PCM_32BIT;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
                i4 |= i12;
            }
            i13 = i3 & 1024;
            if (i13 != 0) {
                i14 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i14 = i2 | i15;
            } else {
                i14 = i2;
            }
            if ((i3 & 2048) != 0) {
                i14 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i16 = 32;
                } else {
                    i16 = 16;
                }
                i14 |= i16;
            }
            if ((1533916891 & i4) == 306783378) {
                if (i7 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i9 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i11 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i13 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                OverscrollEffect overscrollEffect4 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i116 = i4 >> 3;
                LazyListItemProvider lazyListItemProviderRememberItemProvider4 = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i116 & 14) | (i14 & 112));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyListBeyondBoundsInfo();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo4 = (LazyListBeyondBoundsInfo) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller4;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf4 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf4) | composerStartRestartGroup.changed(state);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListItemPlacementAnimator lazyListItemPlacementAnimator4 = (LazyListItemPlacementAnimator) objRememberedValue3;
                state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator4);
                int i117 = i4 & 112;
                int i118 = i4 << 6;
                int i26 = i118 & 458752;
                int i27 = i4;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy4 = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider4, state, lazyListBeyondBoundsInfo4, overscrollEffect4, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator4, composerStartRestartGroup, i117 | (MutableVector.$stable << 6) | (i118 & 57344) | i26 | (i118 & 3670016) | (i4 & 29360128) | (i116 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(lazyListItemProviderRememberItemProvider4, state, composer2, i117);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation5 = orientation;
                Modifier modifierOverscroll4 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider4, state, coroutineScope, z2, z, z3, composer2, ((i27 << 3) & 896) | 4096 | (i27 & 57344) | i26 | (i27 & 3670016)), orientation5), state, lazyListBeyondBoundsInfo4, z, composer2, (MutableVector.$stable << 6) | i117 | (i27 & 7168)), state, lazyListBeyondBoundsInfo4, composer2, (MutableVector.$stable << 6) | i117), overscrollEffect4);
                composer2.startReplaceableGroup(-908836175);
                ComposerKt.sourceInformation(composer2, "*126@5575L7");
                z4 = !z;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z5 = z4;
                } else {
                    z5 = z4;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider4, ScrollableKt.scrollable(modifierOverscroll4, state, orientation5, overscrollEffect4, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy4, composer2, 0, 0);
                horizontal5 = horizontal3;
                vertical5 = vertical3;
                vertical6 = vertical4;
                horizontal6 = horizontal4;
            } else {
                if (i7 != 0) {
                    horizontal3 = null;
                } else {
                    horizontal3 = horizontal;
                }
                if (i9 != 0) {
                    vertical3 = null;
                } else {
                    vertical3 = vertical;
                }
                if (i11 != 0) {
                    vertical4 = null;
                } else {
                    vertical4 = vertical2;
                }
                if (i13 != 0) {
                    horizontal4 = null;
                } else {
                    horizontal4 = horizontal2;
                }
                OverscrollEffect overscrollEffect5 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
                int i119 = i4 >> 3;
                LazyListItemProvider lazyListItemProviderRememberItemProvider5 = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i119 & 14) | (i14 & 112));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new LazyListBeyondBoundsInfo();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo5 = (LazyListBeyondBoundsInfo) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                    objRememberedValue2 = compositionScopedCoroutineScopeCanceller5;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Boolean boolValueOf5 = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf5) | composerStartRestartGroup.changed(state);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                LazyListItemPlacementAnimator lazyListItemPlacementAnimator5 = (LazyListItemPlacementAnimator) objRememberedValue3;
                state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator5);
                int i1110 = i4 & 112;
                int i1111 = i4 << 6;
                int i28 = i1111 & 458752;
                int i29 = i4;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy5 = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider5, state, lazyListBeyondBoundsInfo5, overscrollEffect5, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator5, composerStartRestartGroup, i1110 | (MutableVector.$stable << 6) | (i1111 & 57344) | i28 | (i1111 & 3670016) | (i4 & 29360128) | (i119 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
                composer2 = composerStartRestartGroup;
                ScrollPositionUpdater(lazyListItemProviderRememberItemProvider5, state, composer2, i1110);
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation6 = orientation;
                Modifier modifierOverscroll5 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider5, state, coroutineScope, z2, z, z3, composer2, ((i29 << 3) & 896) | 4096 | (i29 & 57344) | i28 | (i29 & 3670016)), orientation6), state, lazyListBeyondBoundsInfo5, z, composer2, (MutableVector.$stable << 6) | i1110 | (i29 & 7168)), state, lazyListBeyondBoundsInfo5, composer2, (MutableVector.$stable << 6) | i1110), overscrollEffect5);
                composer2.startReplaceableGroup(-908836175);
                ComposerKt.sourceInformation(composer2, "*126@5575L7");
                z4 = !z;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composer2.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    z5 = z4;
                } else {
                    z5 = z4;
                }
                composer2.endReplaceableGroup();
                LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider5, ScrollableKt.scrollable(modifierOverscroll5, state, orientation6, overscrollEffect5, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy5, composer2, 0, 0);
                horizontal5 = horizontal3;
                vertical5 = vertical3;
                vertical6 = vertical4;
                horizontal6 = horizontal4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.2
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

                public final void invoke(Composer composer3, int i210) {
                    LazyListKt.LazyList(modifier, state, contentPadding, z, z2, flingBehavior, z3, horizontal5, vertical5, vertical6, horizontal6, content, composer3, i | 1, i2, i3);
                }
            });
        }
        i4 |= 1572864;
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(horizontal)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i4 |= i8;
        }
        i9 = i3 & 256;
        if (i9 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(vertical)) {
                i10 = 67108864;
            } else {
                i10 = 33554432;
            }
            i4 |= i10;
        }
        i11 = i3 & 512;
        if (i11 != 0) {
            i4 |= C.ENCODING_PCM_32BIT;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(vertical2)) {
                i12 = 536870912;
            } else {
                i12 = 268435456;
            }
            i4 |= i12;
        }
        i13 = i3 & 1024;
        if (i13 != 0) {
            i14 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changed(horizontal2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i14 = i2 | i15;
        } else {
            i14 = i2;
        }
        if ((i3 & 2048) != 0) {
            i14 |= 48;
        } else if ((i2 & 112) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i14 |= i16;
        }
        if ((1533916891 & i4) == 306783378) {
            if (i7 != 0) {
                horizontal3 = null;
            } else {
                horizontal3 = horizontal;
            }
            if (i9 != 0) {
                vertical3 = null;
            } else {
                vertical3 = vertical;
            }
            if (i11 != 0) {
                vertical4 = null;
            } else {
                vertical4 = vertical2;
            }
            if (i13 != 0) {
                horizontal4 = null;
            } else {
                horizontal4 = horizontal2;
            }
            OverscrollEffect overscrollEffect6 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
            int i1112 = i4 >> 3;
            LazyListItemProvider lazyListItemProviderRememberItemProvider6 = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1112 & 14) | (i14 & 112));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LazyListBeyondBoundsInfo();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo6 = (LazyListBeyondBoundsInfo) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Boolean boolValueOf6 = Boolean.valueOf(z2);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(state);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyListItemPlacementAnimator lazyListItemPlacementAnimator6 = (LazyListItemPlacementAnimator) objRememberedValue3;
            state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator6);
            int i1113 = i4 & 112;
            int i1114 = i4 << 6;
            int i210 = i1114 & 458752;
            int i211 = i4;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy6 = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider6, state, lazyListBeyondBoundsInfo6, overscrollEffect6, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator6, composerStartRestartGroup, i1113 | (MutableVector.$stable << 6) | (i1114 & 57344) | i210 | (i1114 & 3670016) | (i4 & 29360128) | (i1112 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
            composer2 = composerStartRestartGroup;
            ScrollPositionUpdater(lazyListItemProviderRememberItemProvider6, state, composer2, i1113);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation7 = orientation;
            Modifier modifierOverscroll6 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider6, state, coroutineScope, z2, z, z3, composer2, ((i211 << 3) & 896) | 4096 | (i211 & 57344) | i210 | (i211 & 3670016)), orientation7), state, lazyListBeyondBoundsInfo6, z, composer2, (MutableVector.$stable << 6) | i1113 | (i211 & 7168)), state, lazyListBeyondBoundsInfo6, composer2, (MutableVector.$stable << 6) | i1113), overscrollEffect6);
            composer2.startReplaceableGroup(-908836175);
            ComposerKt.sourceInformation(composer2, "*126@5575L7");
            z4 = !z;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            objConsume = composer2.consume(localLayoutDirection6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (objConsume == LayoutDirection.Rtl) {
                z5 = z4;
            } else {
                z5 = z4;
            }
            composer2.endReplaceableGroup();
            LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider6, ScrollableKt.scrollable(modifierOverscroll6, state, orientation7, overscrollEffect6, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy6, composer2, 0, 0);
            horizontal5 = horizontal3;
            vertical5 = vertical3;
            vertical6 = vertical4;
            horizontal6 = horizontal4;
        } else {
            if (i7 != 0) {
                horizontal3 = null;
            } else {
                horizontal3 = horizontal;
            }
            if (i9 != 0) {
                vertical3 = null;
            } else {
                vertical3 = vertical;
            }
            if (i11 != 0) {
                vertical4 = null;
            } else {
                vertical4 = vertical2;
            }
            if (i13 != 0) {
                horizontal4 = null;
            } else {
                horizontal4 = horizontal2;
            }
            OverscrollEffect overscrollEffect7 = ScrollableDefaults.INSTANCE.overscrollEffect(composerStartRestartGroup, 6);
            int i1115 = i4 >> 3;
            LazyListItemProvider lazyListItemProviderRememberItemProvider7 = LazyListItemProviderImplKt.rememberItemProvider(state, content, composerStartRestartGroup, (i1115 & 14) | (i14 & 112));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LazyListBeyondBoundsInfo();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo7 = (LazyListBeyondBoundsInfo) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                objRememberedValue2 = compositionScopedCoroutineScopeCanceller7;
            }
            composerStartRestartGroup.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Boolean boolValueOf7 = Boolean.valueOf(z2);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(boolValueOf7) | composerStartRestartGroup.changed(state);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new LazyListItemPlacementAnimator(coroutineScope, z2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyListItemPlacementAnimator lazyListItemPlacementAnimator7 = (LazyListItemPlacementAnimator) objRememberedValue3;
            state.setPlacementAnimator$foundation_release(lazyListItemPlacementAnimator7);
            int i1116 = i4 & 112;
            int i1117 = i4 << 6;
            int i212 = i1117 & 458752;
            int i213 = i4;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy7 = rememberLazyListMeasurePolicy(lazyListItemProviderRememberItemProvider7, state, lazyListBeyondBoundsInfo7, overscrollEffect7, contentPadding, z, z2, horizontal3, vertical4, horizontal4, vertical3, lazyListItemPlacementAnimator7, composerStartRestartGroup, i1116 | (MutableVector.$stable << 6) | (i1117 & 57344) | i212 | (i1117 & 3670016) | (i4 & 29360128) | (i1115 & 234881024) | ((i14 << 27) & 1879048192), ((i4 >> 24) & 14) | 64, 0);
            composer2 = composerStartRestartGroup;
            ScrollPositionUpdater(lazyListItemProviderRememberItemProvider7, state, composer2, i1116);
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            Orientation orientation8 = orientation;
            Modifier modifierOverscroll7 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazySemanticsKt.lazyListSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), lazyListItemProviderRememberItemProvider7, state, coroutineScope, z2, z, z3, composer2, ((i213 << 3) & 896) | 4096 | (i213 & 57344) | i212 | (i213 & 3670016)), orientation8), state, lazyListBeyondBoundsInfo7, z, composer2, (MutableVector.$stable << 6) | i1116 | (i213 & 7168)), state, lazyListBeyondBoundsInfo7, composer2, (MutableVector.$stable << 6) | i1116), overscrollEffect7);
            composer2.startReplaceableGroup(-908836175);
            ComposerKt.sourceInformation(composer2, "*126@5575L7");
            z4 = !z;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            objConsume = composer2.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (objConsume == LayoutDirection.Rtl) {
                z5 = z4;
            } else {
                z5 = z4;
            }
            composer2.endReplaceableGroup();
            LazyLayoutKt.LazyLayout(lazyListItemProviderRememberItemProvider7, ScrollableKt.scrollable(modifierOverscroll7, state, orientation8, overscrollEffect7, z3, z5, flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), function2RememberLazyListMeasurePolicy7, composer2, 0, 0);
            horizontal5 = horizontal3;
            vertical5 = vertical3;
            vertical6 = vertical4;
            horizontal6 = horizontal4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.2
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

            public final void invoke(Composer composer3, int i214) {
                LazyListKt.LazyList(modifier, state, contentPadding, z, z2, flingBehavior, z3, horizontal5, vertical5, vertical6, horizontal6, content, composer3, i | 1, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final void ScrollPositionUpdater(final LazyListItemProvider lazyListItemProvider, final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(3173830);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyListItemProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (lazyListItemProvider.getItemCount() > 0) {
                lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.ScrollPositionUpdater.1
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
                LazyListKt.ScrollPositionUpdater(lazyListItemProvider, lazyListState, composer2, i | 1);
            }
        });
    }

    @ExperimentalFoundationApi
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final LazyListItemProvider lazyListItemProvider, final LazyListState lazyListState, final LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, final OverscrollEffect overscrollEffect, final PaddingValues paddingValues, final boolean z, final boolean z2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, final LazyListItemPlacementAnimator lazyListItemPlacementAnimator, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(-1404987696);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListMeasurePolicy)P(5,9!1,6!1,8,4!1,10!1,11)183@7919L6558:LazyList.kt#428nma");
        Alignment.Horizontal horizontal3 = (i3 & 128) != 0 ? null : horizontal;
        final Alignment.Vertical vertical3 = (i3 & 256) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i3 & 512) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i3 & 1024) == 0 ? vertical2 : null;
        Object[] objArr = {lazyListState, lazyListBeyondBoundsInfo, overscrollEffect, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4, lazyListItemPlacementAnimator};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i4 = 0; i4 < 11; i4++) {
            zChanged |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical vertical5 = vertical4;
            final Arrangement.Horizontal horizontal5 = horizontal4;
            final Alignment.Horizontal horizontal6 = horizontal3;
            objRememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m538invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m538invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i5;
                    int i6;
                    int i7;
                    float spacing;
                    int iM3799getMaxWidthimpl;
                    long jIntOffset;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m191checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.mo404calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i6 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.mo405calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i8 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.getTop());
                    int i9 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(paddingValues.getBottom());
                    final int i10 = i8 + i9;
                    final int i11 = i5 + i6;
                    boolean z3 = z2;
                    int i12 = z3 ? i10 : i11;
                    if (z3 && !z) {
                        i7 = i8;
                    } else if (z3 && z) {
                        i7 = i9;
                    } else {
                        i7 = (z3 || z) ? i6 : i5;
                    }
                    final int i13 = i12 - i7;
                    long jM3815offsetNN6EwU = ConstraintsKt.m3815offsetNN6EwU(j, -i11, -i10);
                    lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    lazyListState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    lazyListItemProvider.getItemScope().m529setMaxWidth0680j_4(lazyLayoutMeasureScope.mo315toDpu2uoSUM(Constraints.m3799getMaxWidthimpl(jM3815offsetNN6EwU)));
                    lazyListItemProvider.getItemScope().m528setMaxHeight0680j_4(lazyLayoutMeasureScope.mo315toDpu2uoSUM(Constraints.m3798getMaxHeightimpl(jM3815offsetNN6EwU)));
                    if (z2) {
                        Arrangement.Vertical vertical6 = vertical5;
                        if (vertical6 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical6.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal7 = horizontal5;
                        if (horizontal7 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal7.getSpacing();
                    }
                    final int i14 = lazyLayoutMeasureScope.mo312roundToPx0680j_4(spacing);
                    final int itemCount = lazyListItemProvider.getItemCount();
                    if (z2) {
                        iM3799getMaxWidthimpl = Constraints.m3798getMaxHeightimpl(j) - i10;
                    } else {
                        iM3799getMaxWidthimpl = Constraints.m3799getMaxWidthimpl(j) - i11;
                    }
                    int i15 = iM3799getMaxWidthimpl;
                    if (!z || i15 > 0) {
                        jIntOffset = IntOffsetKt.IntOffset(i5, i8);
                    } else {
                        boolean z4 = z2;
                        if (!z4) {
                            i5 += i15;
                        }
                        if (z4) {
                            i8 += i15;
                        }
                        jIntOffset = IntOffsetKt.IntOffset(i5, i8);
                    }
                    final long j2 = jIntOffset;
                    boolean z5 = z2;
                    LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                    final boolean z6 = z2;
                    final Alignment.Horizontal horizontal8 = horizontal6;
                    final Alignment.Vertical vertical7 = vertical3;
                    final boolean z7 = z;
                    final LazyListItemPlacementAnimator lazyListItemPlacementAnimator2 = lazyListItemPlacementAnimator;
                    final int i16 = i7;
                    LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(jM3815offsetNN6EwU, z5, lazyListItemProvider2, lazyLayoutMeasureScope, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        @Override // androidx.compose.foundation.lazy.MeasuredItemFactory
                        /* JADX INFO: renamed from: createItem-HK0c1C0, reason: not valid java name */
                        public final LazyMeasuredItem mo539createItemHK0c1C0(int i17, Object key, Placeable[] placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyMeasuredItem(i17, placeables, z6, horizontal8, vertical7, lazyLayoutMeasureScope.getLayoutDirection(), z7, i16, i13, lazyListItemPlacementAnimator2, i17 == itemCount + (-1) ? 0 : i14, j2, key, null);
                        }
                    }, null);
                    lazyListState.m552setPremeasureConstraintsBRTryo0$foundation_release(lazyMeasuredItemProvider.getChildConstraints());
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyListState lazyListState2 = lazyListState;
                    Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                        try {
                            int iM512constructorimpl = DataIndex.m512constructorimpl(lazyListState2.getFirstVisibleItemIndex());
                            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                            Unit unit = Unit.INSTANCE;
                            snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                            snapshotCreateNonObservableSnapshot.dispose();
                            LazyListMeasureResult lazyListMeasureResultM542measureLazyList7Xnphek = LazyListMeasureKt.m542measureLazyList7Xnphek(itemCount, lazyMeasuredItemProvider, i15, i7, i13, iM512constructorimpl, firstVisibleItemScrollOffset, lazyListState.getScrollToBeConsumed(), jM3815offsetNN6EwU, z2, lazyListItemProvider.getHeaderIndexes(), vertical5, horizontal5, z, lazyLayoutMeasureScope2, lazyListItemPlacementAnimator, lazyListBeyondBoundsInfo, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.2
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
                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m3813constrainWidthK40F9xA(j, i17 + i11), ConstraintsKt.m3812constrainHeightK40F9xA(j, i18 + i10), MapsKt.emptyMap(), placement);
                                }
                            });
                            LazyListState lazyListState3 = lazyListState;
                            OverscrollEffect overscrollEffect2 = overscrollEffect;
                            lazyListState3.applyMeasureResult$foundation_release(lazyListMeasureResultM542measureLazyList7Xnphek);
                            LazyListKt.refreshOverscrollInfo(overscrollEffect2, lazyListMeasureResultM542measureLazyList7Xnphek);
                            return lazyListMeasureResultM542measureLazyList7Xnphek;
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
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
        composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyListMeasureResult lazyListMeasureResult) {
        boolean canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        overscrollEffect.setEnabled(canScrollForward || ((firstVisibleItem != null ? firstVisibleItem.getIndex() : 0) != 0 || lazyListMeasureResult.getFirstVisibleItemScrollOffset() != 0));
    }
}
