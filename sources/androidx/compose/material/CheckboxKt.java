package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a9\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aA\u0010,\u001a\u00020\f*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\n\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m3843constructorimpl(24);
    private static final float CheckboxSize = Dp.m3843constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0156  */
    /* JADX WARN: Code duplicated, block: B:102:0x0174  */
    /* JADX WARN: Code duplicated, block: B:104:0x017c  */
    /* JADX WARN: Code duplicated, block: B:106:0x018e  */
    /* JADX WARN: Code duplicated, block: B:111:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea A[PHI: r3 r4 r5 r6
  0x00ea: PHI (r3v24 int) = (r3v19 int), (r3v26 int) binds: [B:96:0x0123, B:81:0x00e7] A[DONT_GENERATE, DONT_INLINE]
  0x00ea: PHI (r4v13 androidx.compose.ui.Modifier) = (r4v8 androidx.compose.ui.Modifier), (r4v15 androidx.compose.ui.Modifier) binds: [B:96:0x0123, B:81:0x00e7] A[DONT_GENERATE, DONT_INLINE]
  0x00ea: PHI (r5v8 boolean) = (r5v4 boolean), (r5v9 boolean) binds: [B:96:0x0123, B:81:0x00e7] A[DONT_GENERATE, DONT_INLINE]
  0x00ea: PHI (r6v15 androidx.compose.foundation.interaction.MutableInteractionSource) = 
  (r6v6 androidx.compose.foundation.interaction.MutableInteractionSource)
  (r6v16 androidx.compose.foundation.interaction.MutableInteractionSource)
 binds: [B:96:0x0123, B:81:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:92:0x0113  */
    /* JADX WARN: Code duplicated, block: B:94:0x0120  */
    /* JADX WARN: Code duplicated, block: B:97:0x0125  */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        CheckboxColors checkboxColors2;
        Modifier.Companion companion;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        CheckboxColors checkboxColorsM944colorszjMxDiM;
        Object objRememberedValue;
        Function0 function0;
        final CheckboxColors checkboxColors3;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource4;
        boolean zChanged;
        Object objRememberedValue2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118660998);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)P(!1,5,4,2,3)90@4153L39,91@4240L8,93@4257L284:Checkbox.kt#jmzs0o");
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
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            checkboxColors2 = checkboxColors;
                            int i10 = composerStartRestartGroup.changed(checkboxColors2) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            checkboxColors2 = checkboxColors;
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier2;
                            z4 = z3;
                            mutableInteractionSource3 = mutableInteractionSource2;
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
                                i8 = i3 & (-458753);
                                checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            composerStartRestartGroup.endDefaults();
                            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                            composerStartRestartGroup.startReplaceableGroup(1433125990);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                            if (function1 != null) {
                                Boolean boolValueOf = Boolean.valueOf(z);
                                composerStartRestartGroup.startReplaceableGroup(511388516);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(function1);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            function1.invoke(Boolean.valueOf(!z));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                function0 = (Function0) objRememberedValue2;
                            } else {
                                function0 = null;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            TriStateCheckbox(ToggleableState, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource5;
                        }
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        composerStartRestartGroup.endDefaults();
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        composerStartRestartGroup.startReplaceableGroup(1433125990);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                        if (function1 != null) {
                            Boolean boolValueOf2 = Boolean.valueOf(z);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf2) | composerStartRestartGroup.changed(function1);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function1.invoke(Boolean.valueOf(!z));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function1.invoke(Boolean.valueOf(!z));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            function0 = (Function0) objRememberedValue2;
                        } else {
                            function0 = null;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TriStateCheckbox(ToggleableState2, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                        checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                        public final void invoke(Composer composer2, int i11) {
                            CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ToggleableState ToggleableState3 = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1433125990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                    if (function1 != null) {
                        Boolean boolValueOf3 = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf3) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        function0 = (Function0) objRememberedValue2;
                    } else {
                        function0 = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState3, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource7;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ToggleableState ToggleableState4 = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1433125990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                    if (function1 != null) {
                        Boolean boolValueOf4 = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf4) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        function0 = (Function0) objRememberedValue2;
                    } else {
                        function0 = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState4, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                    MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                    public final void invoke(Composer composer2, int i11) {
                        CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
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
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ToggleableState ToggleableState5 = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1433125990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                    if (function1 != null) {
                        Boolean boolValueOf5 = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        function0 = (Function0) objRememberedValue2;
                    } else {
                        function0 = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState5, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource9;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ToggleableState ToggleableState6 = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1433125990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                    if (function1 != null) {
                        Boolean boolValueOf6 = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf6) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        function0 = (Function0) objRememberedValue2;
                    } else {
                        function0 = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState6, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                    public final void invoke(Composer composer2, int i11) {
                        CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ToggleableState ToggleableState7 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1433125990);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                if (function1 != null) {
                    Boolean boolValueOf7 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf7) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    function0 = (Function0) objRememberedValue2;
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState7, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                modifier3 = companion;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource11;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ToggleableState ToggleableState8 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1433125990);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                if (function1 != null) {
                    Boolean boolValueOf8 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf8) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    function0 = (Function0) objRememberedValue2;
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState8, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                modifier3 = companion;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource12;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
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
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ToggleableState ToggleableState9 = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1433125990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                    if (function1 != null) {
                        Boolean boolValueOf9 = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf9) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        function0 = (Function0) objRememberedValue2;
                    } else {
                        function0 = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState9, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource3;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource13;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                            i8 = i3 & (-458753);
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    ToggleableState ToggleableState10 = ToggleableStateKt.ToggleableState(z);
                    composerStartRestartGroup.startReplaceableGroup(1433125990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                    if (function1 != null) {
                        Boolean boolValueOf10 = Boolean.valueOf(z);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf10) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(Boolean.valueOf(!z));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        function0 = (Function0) objRememberedValue2;
                    } else {
                        function0 = null;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TriStateCheckbox(ToggleableState10, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource3;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                    public final void invoke(Composer composer2, int i11) {
                        CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ToggleableState ToggleableState11 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1433125990);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                if (function1 != null) {
                    Boolean boolValueOf11 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf11) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    function0 = (Function0) objRememberedValue2;
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState11, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource3;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                modifier3 = companion;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource15;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ToggleableState ToggleableState12 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1433125990);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                if (function1 != null) {
                    Boolean boolValueOf12 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf12) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    function0 = (Function0) objRememberedValue2;
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState12, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource3;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                modifier3 = companion;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource16;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
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
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ToggleableState ToggleableState13 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1433125990);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                if (function1 != null) {
                    Boolean boolValueOf13 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf13) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    function0 = (Function0) objRememberedValue2;
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState13, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource3;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                modifier3 = companion;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource17;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                        i8 = i3 & (-458753);
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                ToggleableState ToggleableState14 = ToggleableStateKt.ToggleableState(z);
                composerStartRestartGroup.startReplaceableGroup(1433125990);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
                if (function1 != null) {
                    Boolean boolValueOf14 = Boolean.valueOf(z);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf14) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(Boolean.valueOf(!z));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    function0 = (Function0) objRememberedValue2;
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState14, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource3;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                modifier3 = companion;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                checkboxColors2 = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColors2)) {
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColors2 = checkboxColors;
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
                    i8 = i3 & (-458753);
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                    i8 = i3 & (-458753);
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            ToggleableState ToggleableState15 = ToggleableStateKt.ToggleableState(z);
            composerStartRestartGroup.startReplaceableGroup(1433125990);
            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
            if (function1 != null) {
                Boolean boolValueOf15 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf15) | composerStartRestartGroup.changed(function1);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(Boolean.valueOf(!z));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(Boolean.valueOf(!z));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                function0 = (Function0) objRememberedValue2;
            } else {
                function0 = null;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TriStateCheckbox(ToggleableState15, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
            MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource3;
            checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            modifier3 = companion;
            z5 = z4;
            mutableInteractionSource4 = mutableInteractionSource19;
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
                    i8 = i3 & (-458753);
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
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
                    i8 = i3 & (-458753);
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            ToggleableState ToggleableState16 = ToggleableStateKt.ToggleableState(z);
            composerStartRestartGroup.startReplaceableGroup(1433125990);
            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4366L29");
            if (function1 != null) {
                Boolean boolValueOf16 = Boolean.valueOf(z);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf16) | composerStartRestartGroup.changed(function1);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(Boolean.valueOf(!z));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(Boolean.valueOf(!z));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                function0 = (Function0) objRememberedValue2;
            } else {
                function0 = null;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TriStateCheckbox(ToggleableState16, function0, companion, z4, mutableInteractionSource3, checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, i8 & 524160, 0);
            MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource3;
            checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            modifier3 = companion;
            z5 = z4;
            mutableInteractionSource4 = mutableInteractionSource110;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

            public final void invoke(Composer composer2, int i11) {
                CheckboxKt.Checkbox(z, function1, modifier3, z5, mutableInteractionSource4, checkboxColors3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0169  */
    /* JADX WARN: Code duplicated, block: B:102:0x0195  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:110:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0101  */
    /* JADX WARN: Code duplicated, block: B:88:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX WARN: Code duplicated, block: B:92:0x011d  */
    /* JADX WARN: Code duplicated, block: B:94:0x012a  */
    /* JADX WARN: Code duplicated, block: B:97:0x012f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0151  */
    public static final void TriStateCheckbox(final ToggleableState state, final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        CheckboxColors checkboxColors2;
        Modifier.Companion companion;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        Modifier modifier3;
        boolean z4;
        MutableInteractionSource mutableInteractionSource4;
        CheckboxColors checkboxColorsM944colorszjMxDiM;
        Object objRememberedValue;
        Modifier.Companion companionM650triStateToggleableO2vRcR0;
        Modifier.Companion companionMinimumTouchTargetSize;
        final Modifier modifier4;
        final MutableInteractionSource mutableInteractionSource5;
        final CheckboxColors checkboxColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(2031255194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)P(5,4,3,1,2)136@6460L39,137@6547L8,155@7071L301:Checkbox.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
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
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
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
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            checkboxColors2 = checkboxColors;
                            int i10 = composerStartRestartGroup.changed(checkboxColors2) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            checkboxColors2 = checkboxColors;
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i8 = i3;
                            modifier3 = modifier2;
                            z4 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
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
                                i8 = i3 & (-458753);
                                modifier3 = companion;
                                z4 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                i8 = i3;
                                modifier3 = companion;
                                z4 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            composerStartRestartGroup.endDefaults();
                            composerStartRestartGroup.startReplaceableGroup(-1517549514);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                            if (function0 != null) {
                                companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                            } else {
                                companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            companionMinimumTouchTargetSize = Modifier.INSTANCE;
                            if (function0 != null) {
                                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                            }
                            CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                            modifier4 = modifier3;
                            z2 = z4;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                        }
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(-1517549514);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                        if (function0 != null) {
                            companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                        } else {
                            companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        companionMinimumTouchTargetSize = Modifier.INSTANCE;
                        if (function0 != null) {
                            companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                        }
                        CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                        modifier4 = modifier3;
                        z2 = z4;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        composerStartRestartGroup = composerStartRestartGroup;
                        checkboxColors3 = checkboxColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-1517549514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                    if (function0 != null) {
                        companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                    } else {
                        companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    modifier4 = modifier3;
                    z2 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-1517549514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                    if (function0 != null) {
                        companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                    } else {
                        companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    modifier4 = modifier3;
                    z2 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z2 = z;
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
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-1517549514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                    if (function0 != null) {
                        companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                    } else {
                        companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    modifier4 = modifier3;
                    z2 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-1517549514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                    if (function0 != null) {
                        companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                    } else {
                        companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    modifier4 = modifier3;
                    z2 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-1517549514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                if (function0 != null) {
                    companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                } else {
                    companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                modifier4 = modifier3;
                z2 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-1517549514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                if (function0 != null) {
                    companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                } else {
                    companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                modifier4 = modifier3;
                z2 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
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
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-1517549514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                    if (function0 != null) {
                        companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                    } else {
                        companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    modifier4 = modifier3;
                    z2 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
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
                            i8 = i3 & (-458753);
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            checkboxColorsM944colorszjMxDiM = checkboxColors2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-1517549514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                    if (function0 != null) {
                        companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                    } else {
                        companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    modifier4 = modifier3;
                    z2 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    checkboxColors3 = checkboxColorsM944colorszjMxDiM;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-1517549514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                if (function0 != null) {
                    companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                } else {
                    companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                modifier4 = modifier3;
                z2 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-1517549514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                if (function0 != null) {
                    companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                } else {
                    companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                modifier4 = modifier3;
                z2 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z2 = z;
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
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
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
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-1517549514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                if (function0 != null) {
                    companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                } else {
                    companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                modifier4 = modifier3;
                z2 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
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
                        i8 = i3 & (-458753);
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        checkboxColorsM944colorszjMxDiM = checkboxColors2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-1517549514);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
                if (function0 != null) {
                    companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
                } else {
                    companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                modifier4 = modifier3;
                z2 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                checkboxColors3 = checkboxColorsM944colorszjMxDiM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                checkboxColors2 = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColors2)) {
                }
                i3 |= i10;
            } else {
                checkboxColors2 = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColors2 = checkboxColors;
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
                    z3 = true;
                } else {
                    z3 = z2;
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
                    i8 = i3 & (-458753);
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
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
                    i8 = i3 & (-458753);
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-1517549514);
            ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
            if (function0 != null) {
                companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
            } else {
                companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            companionMinimumTouchTargetSize = Modifier.INSTANCE;
            if (function0 != null) {
                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
            }
            CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
            modifier4 = modifier3;
            z2 = z4;
            mutableInteractionSource5 = mutableInteractionSource4;
            checkboxColors3 = checkboxColorsM944colorszjMxDiM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
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
                    i8 = i3 & (-458753);
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
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
                    i8 = i3 & (-458753);
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = CheckboxDefaults.INSTANCE.m944colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    checkboxColorsM944colorszjMxDiM = checkboxColors2;
                }
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-1517549514);
            ComposerKt.sourceInformation(composerStartRestartGroup, "147@6884L120");
            if (function0 != null) {
                companionM650triStateToggleableO2vRcR0 = ToggleableKt.m650triStateToggleableO2vRcR0(Modifier.INSTANCE, state, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, composerStartRestartGroup, 54, 4), z4, Role.m3380boximpl(Role.INSTANCE.m3388getCheckboxo7Vup1c()), function0);
            } else {
                companionM650triStateToggleableO2vRcR0 = Modifier.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            companionMinimumTouchTargetSize = Modifier.INSTANCE;
            if (function0 != null) {
                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
            }
            CheckboxImpl(z4, state, PaddingKt.m423padding3ABfNKs(modifier3.then(companionMinimumTouchTargetSize).then(companionM650triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColorsM944colorszjMxDiM, composerStartRestartGroup, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
            modifier4 = modifier3;
            z2 = z4;
            mutableInteractionSource5 = mutableInteractionSource4;
            checkboxColors3 = checkboxColorsM944colorszjMxDiM;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i11) {
                CheckboxKt.TriStateCheckbox(state, function0, modifier4, z2, mutableInteractionSource5, checkboxColors3, composer2, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, Composer composer, final int i) {
        float f;
        float f2;
        float f3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118895727);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxImpl)P(1,3,2)258@10957L23,259@11021L443,275@11524L458,290@12004L32,291@12066L21,292@12115L24,293@12170L27,294@12280L508,294@12202L586:Checkbox.kt#jmzs0o");
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(toggleableState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            int i4 = i3 >> 3;
            int i5 = i4 & 14;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i5, 2);
            CheckboxKt$CheckboxImpl$checkDrawFraction$2 checkboxKt$CheckboxImpl$checkDrawFraction$2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> animateFloat, Composer composer2, int i6) {
                    SpringSpec springSpecSnap;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(-1707702900);
                    if (animateFloat.getInitialState() == ToggleableState.Off) {
                        springSpecSnap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    } else {
                        springSpecSnap = animateFloat.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    composer2.endReplaceableGroup();
                    return springSpecSnap;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            ToggleableState toggleableState2 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Checkbox.kt#jmzs0o");
            int i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i6 == 1) {
                f = 1.0f;
            } else if (i6 != 2) {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf = Float.valueOf(f);
            ToggleableState toggleableState3 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Checkbox.kt#jmzs0o");
            int i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
            if (i7 == 1) {
                f2 = 1.0f;
            } else if (i7 != 2) {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), checkboxKt$CheckboxImpl$checkDrawFraction$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> animateFloat, Composer composer2, int i8) {
                    TweenSpec tweenSpecSnap;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    composer2.startReplaceableGroup(1075283605);
                    if (animateFloat.getInitialState() == ToggleableState.Off) {
                        tweenSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        tweenSpecSnap = animateFloat.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecSnap;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            ToggleableState toggleableState4 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Checkbox.kt#jmzs0o");
            int i8 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
            if (i8 == 1 || i8 == 2) {
                f3 = 0.0f;
            } else {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f3 = 1.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf2 = Float.valueOf(f3);
            ToggleableState toggleableState5 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:Checkbox.kt#jmzs0o");
            int i9 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
            if (i9 != 1 && i9 != 2) {
                if (i9 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f4 = 1.0f;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final CheckDrawingCache checkDrawingCache = (CheckDrawingCache) objRememberedValue;
            final State<Color> stateCheckmarkColor = checkboxColors.checkmarkColor(toggleableState, composerStartRestartGroup, i5 | ((i3 >> 6) & 112));
            int i10 = (i4 & 896) | (i3 & 126);
            final State<Color> stateBoxColor = checkboxColors.boxColor(z, toggleableState, composerStartRestartGroup, i10);
            final State<Color> stateBorderColor = checkboxColors.borderColor(z, toggleableState, composerStartRestartGroup, i10);
            Modifier modifierM456requiredSize3ABfNKs = SizeKt.m456requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
            Object[] objArr = {stateBoxColor, stateBorderColor, stateCheckmarkColor, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, checkDrawingCache};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i11 = 0; i11 < 6; i11++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i11]);
            }
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
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
                        float fFloor = (float) Math.floor(Canvas.mo318toPx0680j_4(CheckboxKt.StrokeWidth));
                        CheckboxKt.m957drawBox1wkBAMs(Canvas, CheckboxKt.m949CheckboxImpl$lambda9(stateBoxColor), CheckboxKt.m945CheckboxImpl$lambda10(stateBorderColor), Canvas.mo318toPx0680j_4(CheckboxKt.RadiusSize), fFloor);
                        CheckboxKt.m958drawCheck3IgeMak(Canvas, CheckboxKt.m948CheckboxImpl$lambda8(stateCheckmarkColor), CheckboxKt.m946CheckboxImpl$lambda4(stateCreateTransitionAnimation), CheckboxKt.m947CheckboxImpl$lambda6(stateCreateTransitionAnimation2), fFloor, checkDrawingCache);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM456requiredSize3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.CheckboxImpl.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i12) {
                CheckboxKt.CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m957drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float fM1464getWidthimpl = Size.m1464getWidthimpl(drawScope.mo2125getSizeNHjbRc());
        if (Color.m1632equalsimpl0(j, j2)) {
            DrawScope.m2122drawRoundRectuAw5IA$default(drawScope, j, 0L, androidx.compose.ui.geometry.SizeKt.Size(fM1464getWidthimpl, fM1464getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f4 = fM1464getWidthimpl - (2 * f2);
        DrawScope.m2122drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f2, f2), androidx.compose.ui.geometry.SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = fM1464getWidthimpl - f2;
        DrawScope.m2122drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f3, f3), androidx.compose.ui.geometry.SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m958drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.INSTANCE.m1937getSquareKaPHkGw(), 0, null, 26, null);
        float fM1464getWidthimpl = Size.m1464getWidthimpl(drawScope.mo2125getSizeNHjbRc());
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fM1464getWidthimpl, fLerp3 * fM1464getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fM1464getWidthimpl, fLerp2 * fM1464getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fM1464getWidthimpl, fM1464getWidthimpl * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m2116drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-4, reason: not valid java name */
    public static final float m946CheckboxImpl$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-6, reason: not valid java name */
    public static final float m947CheckboxImpl$lambda6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-8, reason: not valid java name */
    public static final long m948CheckboxImpl$lambda8(State<Color> state) {
        return state.getValue().m1641unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-9, reason: not valid java name */
    public static final long m949CheckboxImpl$lambda9(State<Color> state) {
        return state.getValue().m1641unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-10, reason: not valid java name */
    public static final long m945CheckboxImpl$lambda10(State<Color> state) {
        return state.getValue().m1641unboximpl();
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m3843constructorimpl(f);
        StrokeWidth = Dp.m3843constructorimpl(f);
        RadiusSize = Dp.m3843constructorimpl(f);
    }
}
