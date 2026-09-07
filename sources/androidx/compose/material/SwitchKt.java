package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.amazon.device.ads.DtbConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a?\u0010!\u001a\u00020\u0014*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0014*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u000b\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Landroidx/compose/runtime/State;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX WARN: Code duplicated, block: B:101:0x0188  */
    /* JADX WARN: Code duplicated, block: B:102:0x018d  */
    /* JADX WARN: Code duplicated, block: B:105:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:108:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:109:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:112:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:115:0x021e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x0223  */
    /* JADX WARN: Code duplicated, block: B:120:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:123:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:124:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:129:0x0378  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:87:0x0100  */
    /* JADX WARN: Code duplicated, block: B:88:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX WARN: Code duplicated, block: B:92:0x011d  */
    /* JADX WARN: Code duplicated, block: B:94:0x012a  */
    /* JADX WARN: Code duplicated, block: B:97:0x012f  */
    /* JADX WARN: Code duplicated, block: B:98:0x015a  */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        SwitchColors switchColors2;
        Modifier.Companion companion;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        Modifier modifier3;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        SwitchColors switchColorsM1187colorsSQMK_m0;
        Object objRememberedValue;
        SwitchKt$Switch$swipeableState$1 switchKt$Switch$swipeableState$1;
        Object objConsume;
        boolean z6;
        Composer composer2;
        Modifier.Companion companionM644toggleableO2vRcR0;
        Modifier.Companion companionMinimumTouchTargetSize;
        boolean z7;
        Function0<ComposeUiNode> constructor;
        final boolean z8;
        final MutableInteractionSource mutableInteractionSource5;
        final SwitchColors switchColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)P(!1,5,4,2,3)94@4383L39,95@4466L8,*98@4538L7,99@4599L72,100@4709L7,115@5150L1024:Switch.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i & 458752) == 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            int i10 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i3 |= i10;
                    } else {
                        switchColors2 = switchColors;
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        } else {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                modifier3 = companion;
                                z5 = z4;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            } else {
                                i8 = i3;
                                modifier3 = companion;
                                z5 = z4;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                switchColorsM1187colorsSQMK_m0 = switchColors2;
                            }
                            composerStartRestartGroup.endDefaults();
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float fMo318toPx0680j_4 = ((Density) objConsume2).mo318toPx0680j_4(ThumbPathLength);
                            Boolean boolValueOf = Boolean.valueOf(z);
                            if (function1 == null) {
                                switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                                    public final void invoke(boolean z9) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                switchKt$Switch$swipeableState$1 = function1;
                            }
                            SwipeableState swipeableStateRememberSwipeableStateFor = SwipeableKt.rememberSwipeableStateFor(boolValueOf, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (objConsume == LayoutDirection.Rtl) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (function1 != null) {
                                composer2 = composerStartRestartGroup;
                                companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                            } else {
                                composer2 = composerStartRestartGroup;
                                companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                            }
                            companionMinimumTouchTargetSize = Modifier.INSTANCE;
                            if (function1 != null) {
                                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                            }
                            Modifier modifierThen = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                            Map mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_4), true));
                            Orientation orientation = Orientation.Horizontal;
                            if (z5 || function1 == null) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            Modifier modifierM458requiredSizeVpY3zN4 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen, swipeableStateRememberSwipeableStateFor, mapMapOf, orientation, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function2
                                public final FixedThreshold invoke(T t, T t2) {
                                    return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                                }
                            } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                                    return invoke(bool.booleanValue(), bool2.booleanValue());
                                }

                                public final ThresholdConfig invoke(boolean z9, boolean z10) {
                                    return new FractionalThreshold(0.5f);
                                }
                            }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density = (Density) objConsume3;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            LayoutDirection layoutDirection = (LayoutDirection) objConsume4;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composer2.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume5;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN4);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer2);
                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            composer2.enableReusing();
                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1571176015);
                            ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                            int i11 = i8 << 3;
                            composerStartRestartGroup = composer2;
                            SwitchImpl(boxScopeInstance, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i11 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i11 & 458752));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier2 = modifier3;
                            z8 = z5;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            switchColors3 = switchColorsM1187colorsSQMK_m0;
                        }
                        i8 = i3;
                        composerStartRestartGroup.endDefaults();
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fMo318toPx0680j_5 = ((Density) objConsume6).mo318toPx0680j_4(ThumbPathLength);
                        Boolean boolValueOf2 = Boolean.valueOf(z);
                        if (function1 == null) {
                            switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                                public final void invoke(boolean z9) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            switchKt$Switch$swipeableState$1 = function1;
                        }
                        SwipeableState swipeableStateRememberSwipeableStateFor2 = SwipeableKt.rememberSwipeableStateFor(boolValueOf2, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (objConsume == LayoutDirection.Rtl) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (function1 != null) {
                            composer2 = composerStartRestartGroup;
                            companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                        } else {
                            composer2 = composerStartRestartGroup;
                            companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        companionMinimumTouchTargetSize = Modifier.INSTANCE;
                        if (function1 != null) {
                            companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                        }
                        Modifier modifierThen2 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_5), true));
                        Orientation orientation2 = Orientation.Horizontal;
                        if (z5) {
                            z7 = false;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierM458requiredSizeVpY3zN5 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen2, swipeableStateRememberSwipeableStateFor2, mapMapOf2, orientation2, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function2
                            public final FixedThreshold invoke(T t, T t2) {
                                return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                            }
                        } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                                return invoke(bool.booleanValue(), bool2.booleanValue());
                            }

                            public final ThresholdConfig invoke(boolean z9, boolean z10) {
                                return new FractionalThreshold(0.5f);
                            }
                        }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf2.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composer2.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density2 = (Density) objConsume7;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composer2.consume(localLayoutDirection4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection2 = (LayoutDirection) objConsume8;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composer2.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume9;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN5);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composer2);
                        Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        composer2.enableReusing();
                        function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(1571176015);
                        ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                        int i12 = i8 << 3;
                        composerStartRestartGroup = composer2;
                        SwitchImpl(boxScopeInstance2, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor2.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i12 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i12 & 458752));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        modifier2 = modifier3;
                        z8 = z5;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        switchColors3 = switchColorsM1187colorsSQMK_m0;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z8 = z3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        switchColors3 = switchColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                        public final void invoke(Composer composer3, int i13) {
                            SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i10;
                } else {
                    switchColors2 = switchColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localDensity5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fMo318toPx0680j_6 = ((Density) objConsume10).mo318toPx0680j_4(ThumbPathLength);
                    Boolean boolValueOf3 = Boolean.valueOf(z);
                    if (function1 == null) {
                        switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z9) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        switchKt$Switch$swipeableState$1 = function1;
                    }
                    SwipeableState swipeableStateRememberSwipeableStateFor3 = SwipeableKt.rememberSwipeableStateFor(boolValueOf3, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (function1 != null) {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                    } else {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function1 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifierThen3 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                    Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_6), true));
                    Orientation orientation3 = Orientation.Horizontal;
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierM458requiredSizeVpY3zN6 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen3, swipeableStateRememberSwipeableStateFor3, mapMapOf3, orientation3, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                        }
                    } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                            return invoke(bool.booleanValue(), bool2.booleanValue());
                        }

                        public final ThresholdConfig invoke(boolean z9, boolean z10) {
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf3.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composer2.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density3 = (Density) objConsume11;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composer2.consume(localLayoutDirection6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LayoutDirection layoutDirection3 = (LayoutDirection) objConsume12;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composer2.consume(localViewConfiguration3);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume13;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN6);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composer2);
                    Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composer2.enableReusing();
                    function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(1571176015);
                    ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                    int i13 = i8 << 3;
                    composerStartRestartGroup = composer2;
                    SwitchImpl(boxScopeInstance3, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor3.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i13 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i13 & 458752));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier2 = modifier3;
                    z8 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    switchColors3 = switchColorsM1187colorsSQMK_m0;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fMo318toPx0680j_7 = ((Density) objConsume14).mo318toPx0680j_4(ThumbPathLength);
                    Boolean boolValueOf4 = Boolean.valueOf(z);
                    if (function1 == null) {
                        switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z9) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        switchKt$Switch$swipeableState$1 = function1;
                    }
                    SwipeableState swipeableStateRememberSwipeableStateFor4 = SwipeableKt.rememberSwipeableStateFor(boolValueOf4, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (function1 != null) {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                    } else {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function1 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifierThen4 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                    Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_7), true));
                    Orientation orientation4 = Orientation.Horizontal;
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierM458requiredSizeVpY3zN7 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen4, swipeableStateRememberSwipeableStateFor4, mapMapOf4, orientation4, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                        }
                    } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                            return invoke(bool.booleanValue(), bool2.booleanValue());
                        }

                        public final ThresholdConfig invoke(boolean z9, boolean z10) {
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf4.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composer2.consume(localDensity8);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density4 = (Density) objConsume15;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume16 = composer2.consume(localLayoutDirection8);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LayoutDirection layoutDirection4 = (LayoutDirection) objConsume16;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume17 = composer2.consume(localViewConfiguration4);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume17;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN7);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composer2);
                    Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl4, density4, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl4, viewConfiguration4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composer2.enableReusing();
                    function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(1571176015);
                    ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                    int i14 = i8 << 3;
                    composerStartRestartGroup = composer2;
                    SwitchImpl(boxScopeInstance4, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor4.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i14 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i14 & 458752));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier2 = modifier3;
                    z8 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    switchColors3 = switchColorsM1187colorsSQMK_m0;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                    public final void invoke(Composer composer3, int i15) {
                        SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i10;
                } else {
                    switchColors2 = switchColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume18 = composerStartRestartGroup.consume(localDensity9);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fMo318toPx0680j_8 = ((Density) objConsume18).mo318toPx0680j_4(ThumbPathLength);
                    Boolean boolValueOf5 = Boolean.valueOf(z);
                    if (function1 == null) {
                        switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z9) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        switchKt$Switch$swipeableState$1 = function1;
                    }
                    SwipeableState swipeableStateRememberSwipeableStateFor5 = SwipeableKt.rememberSwipeableStateFor(boolValueOf5, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection9);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (function1 != null) {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                    } else {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function1 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifierThen5 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                    Map mapMapOf5 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_8), true));
                    Orientation orientation5 = Orientation.Horizontal;
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierM458requiredSizeVpY3zN8 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen5, swipeableStateRememberSwipeableStateFor5, mapMapOf5, orientation5, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                        }
                    } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                            return invoke(bool.booleanValue(), bool2.booleanValue());
                        }

                        public final ThresholdConfig invoke(boolean z9, boolean z10) {
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf5.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume19 = composer2.consume(localDensity10);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density5 = (Density) objConsume19;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume110 = composer2.consume(localLayoutDirection10);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LayoutDirection layoutDirection5 = (LayoutDirection) objConsume110;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111 = composer2.consume(localViewConfiguration5);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) objConsume111;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN8);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composer2);
                    Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl5, density5, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl5, viewConfiguration5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composer2.enableReusing();
                    function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(1571176015);
                    ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                    int i15 = i8 << 3;
                    composerStartRestartGroup = composer2;
                    SwitchImpl(boxScopeInstance5, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor5.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i15 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i15 & 458752));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier2 = modifier3;
                    z8 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    switchColors3 = switchColorsM1187colorsSQMK_m0;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fMo318toPx0680j_9 = ((Density) objConsume112).mo318toPx0680j_4(ThumbPathLength);
                    Boolean boolValueOf6 = Boolean.valueOf(z);
                    if (function1 == null) {
                        switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z9) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        switchKt$Switch$swipeableState$1 = function1;
                    }
                    SwipeableState swipeableStateRememberSwipeableStateFor6 = SwipeableKt.rememberSwipeableStateFor(boolValueOf6, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (function1 != null) {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                    } else {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function1 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifierThen6 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                    Map mapMapOf6 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_9), true));
                    Orientation orientation6 = Orientation.Horizontal;
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierM458requiredSizeVpY3zN9 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen6, swipeableStateRememberSwipeableStateFor6, mapMapOf6, orientation6, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                        }
                    } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                            return invoke(bool.booleanValue(), bool2.booleanValue());
                        }

                        public final ThresholdConfig invoke(boolean z9, boolean z10) {
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf6.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume113 = composer2.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density6 = (Density) objConsume113;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume114 = composer2.consume(localLayoutDirection12);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LayoutDirection layoutDirection6 = (LayoutDirection) objConsume114;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume115 = composer2.consume(localViewConfiguration6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ViewConfiguration viewConfiguration6 = (ViewConfiguration) objConsume115;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN9);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM1286constructorimpl6 = Updater.m1286constructorimpl(composer2);
                    Updater.m1293setimpl(composerM1286constructorimpl6, measurePolicyRememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl6, density6, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl6, layoutDirection6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl6, viewConfiguration6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composer2.enableReusing();
                    function3MaterializerOf6.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(1571176015);
                    ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                    int i16 = i8 << 3;
                    composerStartRestartGroup = composer2;
                    SwitchImpl(boxScopeInstance6, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor6.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i16 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i16 & 458752));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier2 = modifier3;
                    z8 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    switchColors3 = switchColorsM1187colorsSQMK_m0;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                    public final void invoke(Composer composer3, int i17) {
                        SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i10;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i10;
            } else {
                switchColors2 = switchColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume116 = composerStartRestartGroup.consume(localDensity13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fMo318toPx0680j_10 = ((Density) objConsume116).mo318toPx0680j_4(ThumbPathLength);
                Boolean boolValueOf7 = Boolean.valueOf(z);
                if (function1 == null) {
                    switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                        public final void invoke(boolean z9) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    switchKt$Switch$swipeableState$1 = function1;
                }
                SwipeableState swipeableStateRememberSwipeableStateFor7 = SwipeableKt.rememberSwipeableStateFor(boolValueOf7, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (function1 != null) {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                } else {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function1 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifierThen7 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                Map mapMapOf7 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_10), true));
                Orientation orientation7 = Orientation.Horizontal;
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierM458requiredSizeVpY3zN10 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen7, swipeableStateRememberSwipeableStateFor7, mapMapOf7, orientation7, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                    }
                } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                        return invoke(bool.booleanValue(), bool2.booleanValue());
                    }

                    public final ThresholdConfig invoke(boolean z9, boolean z10) {
                        return new FractionalThreshold(0.5f);
                    }
                }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf7.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume117 = composer2.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density7 = (Density) objConsume117;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume118 = composer2.consume(localLayoutDirection14);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection7 = (LayoutDirection) objConsume118;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume119 = composer2.consume(localViewConfiguration7);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration7 = (ViewConfiguration) objConsume119;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN10);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM1286constructorimpl7 = Updater.m1286constructorimpl(composer2);
                Updater.m1293setimpl(composerM1286constructorimpl7, measurePolicyRememberBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl7, density7, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl7, layoutDirection7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl7, viewConfiguration7, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf7.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int i17 = i8 << 3;
                composerStartRestartGroup = composer2;
                SwitchImpl(boxScopeInstance7, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor7.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i17 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i17 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier3;
                z8 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
                switchColors3 = switchColorsM1187colorsSQMK_m0;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1110 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fMo318toPx0680j_11 = ((Density) objConsume1110).mo318toPx0680j_4(ThumbPathLength);
                Boolean boolValueOf8 = Boolean.valueOf(z);
                if (function1 == null) {
                    switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                        public final void invoke(boolean z9) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    switchKt$Switch$swipeableState$1 = function1;
                }
                SwipeableState swipeableStateRememberSwipeableStateFor8 = SwipeableKt.rememberSwipeableStateFor(boolValueOf8, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (function1 != null) {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                } else {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function1 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifierThen8 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                Map mapMapOf8 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_11), true));
                Orientation orientation8 = Orientation.Horizontal;
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierM458requiredSizeVpY3zN11 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen8, swipeableStateRememberSwipeableStateFor8, mapMapOf8, orientation8, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                    }
                } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                        return invoke(bool.booleanValue(), bool2.booleanValue());
                    }

                    public final ThresholdConfig invoke(boolean z9, boolean z10) {
                        return new FractionalThreshold(0.5f);
                    }
                }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf8.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1111 = composer2.consume(localDensity16);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density8 = (Density) objConsume1111;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1112 = composer2.consume(localLayoutDirection16);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection8 = (LayoutDirection) objConsume1112;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume1113 = composer2.consume(localViewConfiguration8);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) objConsume1113;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN11);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM1286constructorimpl8 = Updater.m1286constructorimpl(composer2);
                Updater.m1293setimpl(composerM1286constructorimpl8, measurePolicyRememberBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl8, density8, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl8, layoutDirection8, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl8, viewConfiguration8, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf8.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int i18 = i8 << 3;
                composerStartRestartGroup = composer2;
                SwitchImpl(boxScopeInstance8, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor8.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i18 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i18 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier3;
                z8 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
                switchColors3 = switchColorsM1187colorsSQMK_m0;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                public final void invoke(Composer composer3, int i19) {
                    SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i10;
                } else {
                    switchColors2 = switchColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1114 = composerStartRestartGroup.consume(localDensity17);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fMo318toPx0680j_12 = ((Density) objConsume1114).mo318toPx0680j_4(ThumbPathLength);
                    Boolean boolValueOf9 = Boolean.valueOf(z);
                    if (function1 == null) {
                        switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z9) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        switchKt$Switch$swipeableState$1 = function1;
                    }
                    SwipeableState swipeableStateRememberSwipeableStateFor9 = SwipeableKt.rememberSwipeableStateFor(boolValueOf9, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection17 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection17);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (function1 != null) {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                    } else {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function1 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifierThen9 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                    Map mapMapOf9 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_12), true));
                    Orientation orientation9 = Orientation.Horizontal;
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierM458requiredSizeVpY3zN12 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen9, swipeableStateRememberSwipeableStateFor9, mapMapOf9, orientation9, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                        }
                    } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                            return invoke(bool.booleanValue(), bool2.booleanValue());
                        }

                        public final ThresholdConfig invoke(boolean z9, boolean z10) {
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf9.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1115 = composer2.consume(localDensity18);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density9 = (Density) objConsume1115;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection18 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1116 = composer2.consume(localLayoutDirection18);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LayoutDirection layoutDirection9 = (LayoutDirection) objConsume1116;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration9 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1117 = composer2.consume(localViewConfiguration9);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ViewConfiguration viewConfiguration9 = (ViewConfiguration) objConsume1117;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN12);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM1286constructorimpl9 = Updater.m1286constructorimpl(composer2);
                    Updater.m1293setimpl(composerM1286constructorimpl9, measurePolicyRememberBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl9, density9, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl9, layoutDirection9, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl9, viewConfiguration9, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composer2.enableReusing();
                    function3MaterializerOf9.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(1571176015);
                    ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                    int i19 = i8 << 3;
                    composerStartRestartGroup = composer2;
                    SwitchImpl(boxScopeInstance9, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor9.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i19 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i19 & 458752));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier2 = modifier3;
                    z8 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    switchColors3 = switchColorsM1187colorsSQMK_m0;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            i8 = i3;
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            switchColorsM1187colorsSQMK_m0 = switchColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1118 = composerStartRestartGroup.consume(localDensity19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fMo318toPx0680j_13 = ((Density) objConsume1118).mo318toPx0680j_4(ThumbPathLength);
                    Boolean boolValueOf10 = Boolean.valueOf(z);
                    if (function1 == null) {
                        switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                            public final void invoke(boolean z9) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        switchKt$Switch$swipeableState$1 = function1;
                    }
                    SwipeableState swipeableStateRememberSwipeableStateFor10 = SwipeableKt.rememberSwipeableStateFor(boolValueOf10, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection19 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (function1 != null) {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                    } else {
                        composer2 = composerStartRestartGroup;
                        companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function1 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifierThen10 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                    Map mapMapOf10 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_13), true));
                    Orientation orientation10 = Orientation.Horizontal;
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierM458requiredSizeVpY3zN13 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen10, swipeableStateRememberSwipeableStateFor10, mapMapOf10, orientation10, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                        }
                    } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                            return invoke(bool.booleanValue(), bool2.booleanValue());
                        }

                        public final ThresholdConfig invoke(boolean z9, boolean z10) {
                            return new FractionalThreshold(0.5f);
                        }
                    }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf10.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1119 = composer2.consume(localDensity110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density10 = (Density) objConsume1119;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection110 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11110 = composer2.consume(localLayoutDirection110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LayoutDirection layoutDirection10 = (LayoutDirection) objConsume11110;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration10 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11111 = composer2.consume(localViewConfiguration10);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ViewConfiguration viewConfiguration10 = (ViewConfiguration) objConsume11111;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf10 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN13);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM1286constructorimpl10 = Updater.m1286constructorimpl(composer2);
                    Updater.m1293setimpl(composerM1286constructorimpl10, measurePolicyRememberBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1293setimpl(composerM1286constructorimpl10, density10, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1293setimpl(composerM1286constructorimpl10, layoutDirection10, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1293setimpl(composerM1286constructorimpl10, viewConfiguration10, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    composer2.enableReusing();
                    function3MaterializerOf10.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(1571176015);
                    ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                    int i110 = i8 << 3;
                    composerStartRestartGroup = composer2;
                    SwitchImpl(boxScopeInstance10, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor10.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i110 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i110 & 458752));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    modifier2 = modifier3;
                    z8 = z5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    switchColors3 = switchColorsM1187colorsSQMK_m0;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                    public final void invoke(Composer composer3, int i111) {
                        SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i10;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i10;
            } else {
                switchColors2 = switchColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11112 = composerStartRestartGroup.consume(localDensity111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fMo318toPx0680j_14 = ((Density) objConsume11112).mo318toPx0680j_4(ThumbPathLength);
                Boolean boolValueOf11 = Boolean.valueOf(z);
                if (function1 == null) {
                    switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                        public final void invoke(boolean z9) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    switchKt$Switch$swipeableState$1 = function1;
                }
                SwipeableState swipeableStateRememberSwipeableStateFor11 = SwipeableKt.rememberSwipeableStateFor(boolValueOf11, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (function1 != null) {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                } else {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function1 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifierThen11 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                Map mapMapOf11 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_14), true));
                Orientation orientation11 = Orientation.Horizontal;
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierM458requiredSizeVpY3zN14 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen11, swipeableStateRememberSwipeableStateFor11, mapMapOf11, orientation11, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                    }
                } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                        return invoke(bool.booleanValue(), bool2.booleanValue());
                    }

                    public final ThresholdConfig invoke(boolean z9, boolean z10) {
                        return new FractionalThreshold(0.5f);
                    }
                }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf11.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11113 = composer2.consume(localDensity112);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density11 = (Density) objConsume11113;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection112 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11114 = composer2.consume(localLayoutDirection112);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection11 = (LayoutDirection) objConsume11114;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration11 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11115 = composer2.consume(localViewConfiguration11);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration11 = (ViewConfiguration) objConsume11115;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf11 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN14);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM1286constructorimpl11 = Updater.m1286constructorimpl(composer2);
                Updater.m1293setimpl(composerM1286constructorimpl11, measurePolicyRememberBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl11, density11, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl11, layoutDirection11, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl11, viewConfiguration11, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf11.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int i111 = i8 << 3;
                composerStartRestartGroup = composer2;
                SwitchImpl(boxScopeInstance11, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor11.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i111 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i111 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier3;
                z8 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
                switchColors3 = switchColorsM1187colorsSQMK_m0;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11116 = composerStartRestartGroup.consume(localDensity113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fMo318toPx0680j_15 = ((Density) objConsume11116).mo318toPx0680j_4(ThumbPathLength);
                Boolean boolValueOf12 = Boolean.valueOf(z);
                if (function1 == null) {
                    switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                        public final void invoke(boolean z9) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    switchKt$Switch$swipeableState$1 = function1;
                }
                SwipeableState swipeableStateRememberSwipeableStateFor12 = SwipeableKt.rememberSwipeableStateFor(boolValueOf12, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection113 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (function1 != null) {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                } else {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function1 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifierThen12 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                Map mapMapOf12 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_15), true));
                Orientation orientation12 = Orientation.Horizontal;
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierM458requiredSizeVpY3zN15 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen12, swipeableStateRememberSwipeableStateFor12, mapMapOf12, orientation12, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                    }
                } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                        return invoke(bool.booleanValue(), bool2.booleanValue());
                    }

                    public final ThresholdConfig invoke(boolean z9, boolean z10) {
                        return new FractionalThreshold(0.5f);
                    }
                }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf12.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11117 = composer2.consume(localDensity114);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density12 = (Density) objConsume11117;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection114 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11118 = composer2.consume(localLayoutDirection114);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection12 = (LayoutDirection) objConsume11118;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration12 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11119 = composer2.consume(localViewConfiguration12);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration12 = (ViewConfiguration) objConsume11119;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf12 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN15);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM1286constructorimpl12 = Updater.m1286constructorimpl(composer2);
                Updater.m1293setimpl(composerM1286constructorimpl12, measurePolicyRememberBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl12, density12, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl12, layoutDirection12, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl12, viewConfiguration12, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf12.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int i112 = i8 << 3;
                composerStartRestartGroup = composer2;
                SwitchImpl(boxScopeInstance12, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor12.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i112 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i112 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier3;
                z8 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
                switchColors3 = switchColorsM1187colorsSQMK_m0;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                public final void invoke(Composer composer3, int i113) {
                    SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i & 458752) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i10;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i10;
            } else {
                switchColors2 = switchColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111110 = composerStartRestartGroup.consume(localDensity115);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fMo318toPx0680j_16 = ((Density) objConsume111110).mo318toPx0680j_4(ThumbPathLength);
                Boolean boolValueOf13 = Boolean.valueOf(z);
                if (function1 == null) {
                    switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                        public final void invoke(boolean z9) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    switchKt$Switch$swipeableState$1 = function1;
                }
                SwipeableState swipeableStateRememberSwipeableStateFor13 = SwipeableKt.rememberSwipeableStateFor(boolValueOf13, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection115 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection115);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (function1 != null) {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                } else {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function1 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifierThen13 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                Map mapMapOf13 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_16), true));
                Orientation orientation13 = Orientation.Horizontal;
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierM458requiredSizeVpY3zN16 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen13, swipeableStateRememberSwipeableStateFor13, mapMapOf13, orientation13, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                    }
                } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                        return invoke(bool.booleanValue(), bool2.booleanValue());
                    }

                    public final ThresholdConfig invoke(boolean z9, boolean z10) {
                        return new FractionalThreshold(0.5f);
                    }
                }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf13.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111111 = composer2.consume(localDensity116);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density13 = (Density) objConsume111111;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection116 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111112 = composer2.consume(localLayoutDirection116);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection13 = (LayoutDirection) objConsume111112;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration13 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111113 = composer2.consume(localViewConfiguration13);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration13 = (ViewConfiguration) objConsume111113;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf13 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN16);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM1286constructorimpl13 = Updater.m1286constructorimpl(composer2);
                Updater.m1293setimpl(composerM1286constructorimpl13, measurePolicyRememberBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl13, density13, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl13, layoutDirection13, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl13, viewConfiguration13, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf13.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int i113 = i8 << 3;
                composerStartRestartGroup = composer2;
                SwitchImpl(boxScopeInstance13, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor13.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i113 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i113 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier3;
                z8 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
                switchColors3 = switchColorsM1187colorsSQMK_m0;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z3;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        i8 = i3;
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        switchColorsM1187colorsSQMK_m0 = switchColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111114 = composerStartRestartGroup.consume(localDensity117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fMo318toPx0680j_17 = ((Density) objConsume111114).mo318toPx0680j_4(ThumbPathLength);
                Boolean boolValueOf14 = Boolean.valueOf(z);
                if (function1 == null) {
                    switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                        public final void invoke(boolean z9) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    switchKt$Switch$swipeableState$1 = function1;
                }
                SwipeableState swipeableStateRememberSwipeableStateFor14 = SwipeableKt.rememberSwipeableStateFor(boolValueOf14, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection117 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (function1 != null) {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
                } else {
                    composer2 = composerStartRestartGroup;
                    companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function1 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifierThen14 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
                Map mapMapOf14 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_17), true));
                Orientation orientation14 = Orientation.Horizontal;
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierM458requiredSizeVpY3zN17 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen14, swipeableStateRememberSwipeableStateFor14, mapMapOf14, orientation14, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                    }
                } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                        return invoke(bool.booleanValue(), bool2.booleanValue());
                    }

                    public final ThresholdConfig invoke(boolean z9, boolean z10) {
                        return new FractionalThreshold(0.5f);
                    }
                }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf14.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111115 = composer2.consume(localDensity118);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density14 = (Density) objConsume111115;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection118 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111116 = composer2.consume(localLayoutDirection118);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection14 = (LayoutDirection) objConsume111116;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration14 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume111117 = composer2.consume(localViewConfiguration14);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration14 = (ViewConfiguration) objConsume111117;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf14 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN17);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM1286constructorimpl14 = Updater.m1286constructorimpl(composer2);
                Updater.m1293setimpl(composerM1286constructorimpl14, measurePolicyRememberBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl14, density14, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl14, layoutDirection14, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl14, viewConfiguration14, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composer2.enableReusing();
                function3MaterializerOf14.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int i114 = i8 << 3;
                composerStartRestartGroup = composer2;
                SwitchImpl(boxScopeInstance14, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor14.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i114 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i114 & 458752));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                modifier2 = modifier3;
                z8 = z5;
                mutableInteractionSource5 = mutableInteractionSource4;
                switchColors3 = switchColorsM1187colorsSQMK_m0;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

                public final void invoke(Composer composer3, int i115) {
                    SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                switchColors2 = switchColors;
                if (composerStartRestartGroup.changed(switchColors2)) {
                }
                i3 |= i10;
            } else {
                switchColors2 = switchColors;
            }
            i3 |= i10;
        } else {
            switchColors2 = switchColors;
        }
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    i8 = i3;
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = switchColors2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    i8 = i3;
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = switchColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume111118 = composerStartRestartGroup.consume(localDensity119);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fMo318toPx0680j_18 = ((Density) objConsume111118).mo318toPx0680j_4(ThumbPathLength);
            Boolean boolValueOf15 = Boolean.valueOf(z);
            if (function1 == null) {
                switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                    public final void invoke(boolean z9) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                switchKt$Switch$swipeableState$1 = function1;
            }
            SwipeableState swipeableStateRememberSwipeableStateFor15 = SwipeableKt.rememberSwipeableStateFor(boolValueOf15, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection119 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localLayoutDirection119);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (objConsume == LayoutDirection.Rtl) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (function1 != null) {
                composer2 = composerStartRestartGroup;
                companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
            } else {
                composer2 = composerStartRestartGroup;
                companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
            }
            companionMinimumTouchTargetSize = Modifier.INSTANCE;
            if (function1 != null) {
                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
            }
            Modifier modifierThen15 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
            Map mapMapOf15 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_18), true));
            Orientation orientation15 = Orientation.Horizontal;
            if (z5) {
                z7 = false;
            } else {
                z7 = false;
            }
            Modifier modifierM458requiredSizeVpY3zN18 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen15, swipeableStateRememberSwipeableStateFor15, mapMapOf15, orientation15, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                public final FixedThreshold invoke(T t, T t2) {
                    return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                }
            } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                    return invoke(bool.booleanValue(), bool2.booleanValue());
                }

                public final ThresholdConfig invoke(boolean z9, boolean z10) {
                    return new FractionalThreshold(0.5f);
                }
            }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf15.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume111119 = composer2.consume(localDensity1110);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Density density15 = (Density) objConsume111119;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1110 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111110 = composer2.consume(localLayoutDirection1110);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection15 = (LayoutDirection) objConsume1111110;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration15 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111111 = composer2.consume(localViewConfiguration15);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ViewConfiguration viewConfiguration15 = (ViewConfiguration) objConsume1111111;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf15 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN18);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM1286constructorimpl15 = Updater.m1286constructorimpl(composer2);
            Updater.m1293setimpl(composerM1286constructorimpl15, measurePolicyRememberBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl15, density15, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl15, layoutDirection15, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl15, viewConfiguration15, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composer2.enableReusing();
            function3MaterializerOf15.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1571176015);
            ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
            int i115 = i8 << 3;
            composerStartRestartGroup = composer2;
            SwitchImpl(boxScopeInstance15, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor15.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i115 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i115 & 458752));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier2 = modifier3;
            z8 = z5;
            mutableInteractionSource5 = mutableInteractionSource4;
            switchColors3 = switchColorsM1187colorsSQMK_m0;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    i8 = i3;
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = switchColors2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1187colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    i8 = i3;
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    switchColorsM1187colorsSQMK_m0 = switchColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111112 = composerStartRestartGroup.consume(localDensity1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fMo318toPx0680j_19 = ((Density) objConsume1111112).mo318toPx0680j_4(ThumbPathLength);
            Boolean boolValueOf16 = Boolean.valueOf(z);
            if (function1 == null) {
                switchKt$Switch$swipeableState$1 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                    public final void invoke(boolean z9) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                switchKt$Switch$swipeableState$1 = function1;
            }
            SwipeableState swipeableStateRememberSwipeableStateFor16 = SwipeableKt.rememberSwipeableStateFor(boolValueOf16, switchKt$Switch$swipeableState$1, AnimationSpec, composerStartRestartGroup, (i8 & 14) | 384, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localLayoutDirection1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (objConsume == LayoutDirection.Rtl) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (function1 != null) {
                composer2 = composerStartRestartGroup;
                companionM644toggleableO2vRcR0 = ToggleableKt.m644toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, null, z5, Role.m3380boximpl(Role.INSTANCE.m3391getSwitcho7Vup1c()), function1);
            } else {
                composer2 = composerStartRestartGroup;
                companionM644toggleableO2vRcR0 = Modifier.INSTANCE;
            }
            companionMinimumTouchTargetSize = Modifier.INSTANCE;
            if (function1 != null) {
                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
            }
            Modifier modifierThen16 = modifier3.then(companionMinimumTouchTargetSize).then(companionM644toggleableO2vRcR0);
            Map mapMapOf16 = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), Boolean.valueOf((boolean) r6)), TuplesKt.to(Float.valueOf(fMo318toPx0680j_19), true));
            Orientation orientation16 = Orientation.Horizontal;
            if (z5) {
                z7 = false;
            } else {
                z7 = false;
            }
            Modifier modifierM458requiredSizeVpY3zN19 = SizeKt.m458requiredSizeVpY3zN4(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(SwipeableKt.m1185swipeablepPrIpRY(modifierThen16, swipeableStateRememberSwipeableStateFor16, mapMapOf16, orientation16, (32 & 8) != 0 ? true : z7, (32 & 16) != 0 ? false : z6, (32 & 32) != 0 ? null : mutableInteractionSource4, (32 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                public final FixedThreshold invoke(T t, T t2) {
                    return new FixedThreshold(Dp.m3843constructorimpl(56), null);
                }
            } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt.Switch.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                    return invoke(bool.booleanValue(), bool2.booleanValue());
                }

                public final ThresholdConfig invoke(boolean z9, boolean z10) {
                    return new FractionalThreshold(0.5f);
                }
            }, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapMapOf16.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1184getVelocityThresholdD9Ej5fM() : 0.0f), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity1112 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111113 = composer2.consume(localDensity1112);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Density density16 = (Density) objConsume1111113;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1112 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111114 = composer2.consume(localLayoutDirection1112);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection16 = (LayoutDirection) objConsume1111114;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration16 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume1111115 = composer2.consume(localViewConfiguration16);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ViewConfiguration viewConfiguration16 = (ViewConfiguration) objConsume1111115;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf16 = LayoutKt.materializerOf(modifierM458requiredSizeVpY3zN19);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM1286constructorimpl16 = Updater.m1286constructorimpl(composer2);
            Updater.m1293setimpl(composerM1286constructorimpl16, measurePolicyRememberBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl16, density16, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl16, layoutDirection16, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl16, viewConfiguration16, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composer2.enableReusing();
            function3MaterializerOf16.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1571176015);
            ComposerKt.sourceInformation(composer2, "C135@5958L210:Switch.kt#jmzs0o");
            int i116 = i8 << 3;
            composerStartRestartGroup = composer2;
            SwitchImpl(boxScopeInstance16, z, z5, switchColorsM1187colorsSQMK_m0, swipeableStateRememberSwipeableStateFor16.getOffset(), mutableInteractionSource4, composerStartRestartGroup, (i116 & 112) | 6 | ((i8 >> 3) & 896) | ((i8 >> 6) & 7168) | (i116 & 458752));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier2 = modifier3;
            z8 = z5;
            mutableInteractionSource5 = mutableInteractionSource4;
            switchColors3 = switchColorsM1187colorsSQMK_m0;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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

            public final void invoke(Composer composer3, int i117) {
                SwitchKt.Switch(z, function1, modifier2, z8, mutableInteractionSource5, switchColors3, composer3, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final State<Float> state, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        float f;
        int i3;
        long jM1189SwitchImpl$lambda7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1834839253);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchImpl)P(!1,2!1,4)181@7257L46,183@7343L614,183@7309L648,202@8160L28,203@8248L81,203@8193L136,206@8359L28,207@8437L7,*208@8496L7,210@8585L6,218@8838L47,221@8995L59,215@8751L479:Switch.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(state) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i4 = (i2 >> 15) & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function2) new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i4);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float f2 = f;
            int i5 = ((i2 >> 3) & 896) | ((i2 >> 6) & 14) | (i2 & 112);
            final State<Color> stateTrackColor = switchColors.trackColor(z2, z, composerStartRestartGroup, i5);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        SwitchKt.m1192drawTrackRPmYEkk(Canvas, SwitchKt.m1188SwitchImpl$lambda5(stateTrackColor), Canvas.mo318toPx0680j_4(SwitchKt.getTrackWidth()), Canvas.mo318toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z2, z, composerStartRestartGroup, i5);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM3843constructorimpl = Dp.m3843constructorimpl(((Dp) objConsume2).m3857unboximpl() + f2);
            composerStartRestartGroup.startReplaceableGroup(-539245361);
            ComposerKt.sourceInformation(composerStartRestartGroup, "211@8660L36");
            if (Color.m1632equalsimpl0(m1189SwitchImpl$lambda7(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m983getSurface0d7_KjU()) && elevationOverlay != null) {
                i3 = 0;
                jM1189SwitchImpl$lambda7 = elevationOverlay.mo1013apply7g2Lkgo(m1189SwitchImpl$lambda7(stateThumbColor), fM3843constructorimpl, composerStartRestartGroup, 0);
            } else {
                i3 = 0;
                jM1189SwitchImpl$lambda7 = m1189SwitchImpl$lambda7(stateThumbColor);
            }
            long j = jM1189SwitchImpl$lambda7;
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(state);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m3952boximpl(m1193invokeBjo55l4(density));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1193invokeBjo55l4(Density offset) {
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(state.getValue().floatValue()), 0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m175backgroundbw27NRU(ShadowKt.m1324shadows4CzXII$default(SizeKt.m456requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) objRememberedValue4), interactionSource, RippleKt.m1265rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), ThumbDiameter), f2, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), j, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, i3);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.SwitchImpl.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                SwitchKt.SwitchImpl(boxScope, z, z2, switchColors, state, interactionSource, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1192drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        DrawScope.m2112drawLineNGM6Ib0$default(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m1396getYimpl(drawScope.mo2124getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m1396getYimpl(drawScope.mo2124getCenterF1C5BW0())), f2, StrokeCap.INSTANCE.m1936getRoundKaPHkGw(), null, 0.0f, null, 0, DtbConstants.DEFAULT_PLAYER_HEIGHT, null);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchImpl$lambda-5, reason: not valid java name */
    public static final long m1188SwitchImpl$lambda5(State<Color> state) {
        return state.getValue().m1641unboximpl();
    }

    /* JADX INFO: renamed from: SwitchImpl$lambda-7, reason: not valid java name */
    private static final long m1189SwitchImpl$lambda7(State<Color> state) {
        return state.getValue().m1641unboximpl();
    }

    static {
        float fM3843constructorimpl = Dp.m3843constructorimpl(34);
        TrackWidth = fM3843constructorimpl;
        TrackStrokeWidth = Dp.m3843constructorimpl(14);
        float fM3843constructorimpl2 = Dp.m3843constructorimpl(20);
        ThumbDiameter = fM3843constructorimpl2;
        ThumbRippleRadius = Dp.m3843constructorimpl(24);
        DefaultSwitchPadding = Dp.m3843constructorimpl(2);
        SwitchWidth = fM3843constructorimpl;
        SwitchHeight = fM3843constructorimpl2;
        ThumbPathLength = Dp.m3843constructorimpl(fM3843constructorimpl - fM3843constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m3843constructorimpl(1);
        ThumbPressedElevation = Dp.m3843constructorimpl(6);
    }
}
