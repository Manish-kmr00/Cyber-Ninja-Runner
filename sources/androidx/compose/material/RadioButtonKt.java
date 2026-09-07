package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = Dp.m3843constructorimpl(24);
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;

    /* JADX WARN: Code duplicated, block: B:100:0x014c  */
    /* JADX WARN: Code duplicated, block: B:101:0x0155  */
    /* JADX WARN: Code duplicated, block: B:104:0x018d  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:108:0x01df  */
    /* JADX WARN: Code duplicated, block: B:111:0x021f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0227  */
    /* JADX WARN: Code duplicated, block: B:118:0x0248  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:91:0x0114  */
    /* JADX WARN: Code duplicated, block: B:93:0x0121  */
    /* JADX WARN: Code duplicated, block: B:96:0x0126  */
    /* JADX WARN: Code duplicated, block: B:97:0x0141  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v13 */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        RadioButtonColors radioButtonColorsM1145colorsRGew2ao;
        Modifier.Companion companion;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        Modifier modifier3;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        float fM3843constructorimpl;
        final State<Dp> stateM105animateDpAsStateKz89ssw;
        final State<Color> stateRadioColor;
        ?? r12;
        boolean z6;
        Modifier.Companion companionM639selectableO2vRcR0;
        Modifier.Companion companionMinimumTouchTargetSize;
        boolean zChanged;
        Object objRememberedValue2;
        final MutableInteractionSource mutableInteractionSource5;
        final boolean z7;
        final RadioButtonColors radioButtonColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1314435585);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)P(5,4,3,1,2)78@3687L39,79@3780L8,81@3813L164,85@4006L29,109@4847L385,102@4551L681:RadioButton.kt#jmzs0o");
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
                            radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                            int i10 = composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
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
                                modifier3 = companion;
                                z5 = z4;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                            } else {
                                i8 = i3;
                                modifier3 = companion;
                                z5 = z4;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i8 = i3;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (z) {
                            fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                        int i11 = i8 >> 9;
                        stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i11 & 896) | (i11 & 14) | ((i8 << 3) & 112));
                        composerStartRestartGroup.startReplaceableGroup(1941632354);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                        if (function0 != null) {
                            z6 = z5;
                            r12 = 0;
                            companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                        } else {
                            r12 = 0;
                            z6 = z5;
                            companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        companionMinimumTouchTargetSize = Modifier.INSTANCE;
                        if (function0 != null) {
                            companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                        }
                        Modifier modifier4 = modifier3;
                        Modifier modifierM456requiredSize3ABfNKs = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                    float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                    float f2 = f / 2;
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                    if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                        DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(modifierM456requiredSize3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                        modifier2 = modifier4;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        z7 = z6;
                        radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z7 = z3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
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
                            RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (z) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                    int i12 = i8 >> 9;
                    stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i12 & 896) | (i12 & 14) | ((i8 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                    if (function0 != null) {
                        z6 = z5;
                        r12 = 0;
                        companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                    } else {
                        r12 = 0;
                        z6 = z5;
                        companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifier5 = modifier3;
                    Modifier modifierM456requiredSize3ABfNKs2 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier5.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM456requiredSize3ABfNKs2, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                    modifier2 = modifier5;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z6;
                    radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (z) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                    int i13 = i8 >> 9;
                    stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i13 & 896) | (i13 & 14) | ((i8 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                    if (function0 != null) {
                        z6 = z5;
                        r12 = 0;
                        companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                    } else {
                        r12 = 0;
                        z6 = z5;
                        companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifier6 = modifier3;
                    Modifier modifierM456requiredSize3ABfNKs3 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier6.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM456requiredSize3ABfNKs3, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                    modifier2 = modifier6;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z6;
                    radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
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
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (z) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                    int i14 = i8 >> 9;
                    stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i14 & 896) | (i14 & 14) | ((i8 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                    if (function0 != null) {
                        z6 = z5;
                        r12 = 0;
                        companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                    } else {
                        r12 = 0;
                        z6 = z5;
                        companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifier7 = modifier3;
                    Modifier modifierM456requiredSize3ABfNKs4 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier7.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM456requiredSize3ABfNKs4, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                    modifier2 = modifier7;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z6;
                    radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (z) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                    int i15 = i8 >> 9;
                    stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i15 & 896) | (i15 & 14) | ((i8 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                    if (function0 != null) {
                        z6 = z5;
                        r12 = 0;
                        companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                    } else {
                        r12 = 0;
                        z6 = z5;
                        companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifier8 = modifier3;
                    Modifier modifierM456requiredSize3ABfNKs5 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier8.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM456requiredSize3ABfNKs5, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                    modifier2 = modifier8;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z6;
                    radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i16) {
                        RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (z) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                int i16 = i8 >> 9;
                stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i16 & 896) | (i16 & 14) | ((i8 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                if (function0 != null) {
                    z6 = z5;
                    r12 = 0;
                    companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                } else {
                    r12 = 0;
                    z6 = z5;
                    companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifier9 = modifier3;
                Modifier modifierM456requiredSize3ABfNKs6 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier9.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM456requiredSize3ABfNKs6, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                modifier2 = modifier9;
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z6;
                radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (z) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                int i17 = i8 >> 9;
                stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i17 & 896) | (i17 & 14) | ((i8 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                if (function0 != null) {
                    z6 = z5;
                    r12 = 0;
                    companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                } else {
                    r12 = 0;
                    z6 = z5;
                    companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifier10 = modifier3;
                Modifier modifierM456requiredSize3ABfNKs7 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier10.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM456requiredSize3ABfNKs7, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                modifier2 = modifier10;
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z6;
                radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i18) {
                    RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
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
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (z) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                    int i18 = i8 >> 9;
                    stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i18 & 896) | (i18 & 14) | ((i8 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                    if (function0 != null) {
                        z6 = z5;
                        r12 = 0;
                        companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                    } else {
                        r12 = 0;
                        z6 = z5;
                        companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifier11 = modifier3;
                    Modifier modifierM456requiredSize3ABfNKs8 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier11.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM456requiredSize3ABfNKs8, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                    modifier2 = modifier11;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z6;
                    radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
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
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                        } else {
                            i8 = i3;
                            modifier3 = companion;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (z) {
                        fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                    int i19 = i8 >> 9;
                    stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i19 & 896) | (i19 & 14) | ((i8 << 3) & 112));
                    composerStartRestartGroup.startReplaceableGroup(1941632354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                    if (function0 != null) {
                        z6 = z5;
                        r12 = 0;
                        companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                    } else {
                        r12 = 0;
                        z6 = z5;
                        companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionMinimumTouchTargetSize = Modifier.INSTANCE;
                    if (function0 != null) {
                        companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                    }
                    Modifier modifier12 = modifier3;
                    Modifier modifierM456requiredSize3ABfNKs9 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier12.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                                float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                                float f2 = f / 2;
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                    DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(modifierM456requiredSize3ABfNKs9, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                    modifier2 = modifier12;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z6;
                    radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i110) {
                        RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (z) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                int i110 = i8 >> 9;
                stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i110 & 896) | (i110 & 14) | ((i8 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                if (function0 != null) {
                    z6 = z5;
                    r12 = 0;
                    companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                } else {
                    r12 = 0;
                    z6 = z5;
                    companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifier13 = modifier3;
                Modifier modifierM456requiredSize3ABfNKs10 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier13.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM456requiredSize3ABfNKs10, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                modifier2 = modifier13;
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z6;
                radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (z) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                int i111 = i8 >> 9;
                stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i111 & 896) | (i111 & 14) | ((i8 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                if (function0 != null) {
                    z6 = z5;
                    r12 = 0;
                    companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                } else {
                    r12 = 0;
                    z6 = z5;
                    companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifier14 = modifier3;
                Modifier modifierM456requiredSize3ABfNKs11 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier14.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM456requiredSize3ABfNKs11, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                modifier2 = modifier14;
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z6;
                radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i112) {
                    RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
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
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (z) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                int i112 = i8 >> 9;
                stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i112 & 896) | (i112 & 14) | ((i8 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                if (function0 != null) {
                    z6 = z5;
                    r12 = 0;
                    companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                } else {
                    r12 = 0;
                    z6 = z5;
                    companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifier15 = modifier3;
                Modifier modifierM456requiredSize3ABfNKs12 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier15.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM456requiredSize3ABfNKs12, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                modifier2 = modifier15;
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z6;
                radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
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
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                    } else {
                        i8 = i3;
                        modifier3 = companion;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (z) {
                    fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
                int i113 = i8 >> 9;
                stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i113 & 896) | (i113 & 14) | ((i8 << 3) & 112));
                composerStartRestartGroup.startReplaceableGroup(1941632354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
                if (function0 != null) {
                    z6 = z5;
                    r12 = 0;
                    companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
                } else {
                    r12 = 0;
                    z6 = z5;
                    companionM639selectableO2vRcR0 = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionMinimumTouchTargetSize = Modifier.INSTANCE;
                if (function0 != null) {
                    companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
                }
                Modifier modifier16 = modifier3;
                Modifier modifierM456requiredSize3ABfNKs13 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier16.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                            float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                            float f2 = f / 2;
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                            if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                                DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierM456requiredSize3ABfNKs13, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
                modifier2 = modifier16;
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z6;
                radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i114) {
                    RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
                if (composerStartRestartGroup.changed(radioButtonColorsM1145colorsRGew2ao)) {
                }
                i3 |= i10;
            } else {
                radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
            }
            i3 |= i10;
        } else {
            radioButtonColorsM1145colorsRGew2ao = radioButtonColors;
        }
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
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
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
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
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (z) {
                fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM3843constructorimpl = Dp.m3843constructorimpl(0);
            }
            stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
            int i114 = i8 >> 9;
            stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i114 & 896) | (i114 & 14) | ((i8 << 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(1941632354);
            ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
            if (function0 != null) {
                z6 = z5;
                r12 = 0;
                companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
            } else {
                r12 = 0;
                z6 = z5;
                companionM639selectableO2vRcR0 = Modifier.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            companionMinimumTouchTargetSize = Modifier.INSTANCE;
            if (function0 != null) {
                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
            }
            Modifier modifier17 = modifier3;
            Modifier modifierM456requiredSize3ABfNKs14 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier17.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                        float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                        float f2 = f / 2;
                        DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                        if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                        float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                        float f2 = f / 2;
                        DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                        if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM456requiredSize3ABfNKs14, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
            modifier2 = modifier17;
            mutableInteractionSource5 = mutableInteractionSource4;
            z7 = z6;
            radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
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
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
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
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    radioButtonColorsM1145colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1145colorsRGew2ao(0L, 0L, 0L, composerStartRestartGroup, 3072, 7);
                } else {
                    i8 = i3;
                    modifier3 = companion;
                    z5 = z4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (z) {
                fM3843constructorimpl = Dp.m3843constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM3843constructorimpl = Dp.m3843constructorimpl(0);
            }
            stateM105animateDpAsStateKz89ssw = AnimateAsStateKt.m105animateDpAsStateKz89ssw(fM3843constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composerStartRestartGroup, 48, 4);
            int i115 = i8 >> 9;
            stateRadioColor = radioButtonColorsM1145colorsRGew2ao.radioColor(z5, z, composerStartRestartGroup, (i115 & 896) | (i115 & 14) | ((i8 << 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(1941632354);
            ComposerKt.sourceInformation(composerStartRestartGroup, "94@4361L123");
            if (function0 != null) {
                z6 = z5;
                r12 = 0;
                companionM639selectableO2vRcR0 = SelectableKt.m639selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1265rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, composerStartRestartGroup, 54, 4), z6, Role.m3380boximpl(Role.INSTANCE.m3390getRadioButtono7Vup1c()), function0);
            } else {
                r12 = 0;
                z6 = z5;
                companionM639selectableO2vRcR0 = Modifier.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            companionMinimumTouchTargetSize = Modifier.INSTANCE;
            if (function0 != null) {
                companionMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(companionMinimumTouchTargetSize);
            }
            Modifier modifier18 = modifier3;
            Modifier modifierM456requiredSize3ABfNKs15 = SizeKt.m456requiredSize3ABfNKs(PaddingKt.m423padding3ABfNKs(SizeKt.wrapContentSize$default(modifier18.then(companionMinimumTouchTargetSize).then(companionM639selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r12, 2, null), RadioButtonPadding), RadioButtonSize);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM105animateDpAsStateKz89ssw);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                        float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                        float f2 = f / 2;
                        DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                        if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
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
                        float f = Canvas.mo318toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                        float f2 = f / 2;
                        DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(RadioButtonKt.RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                        if (Dp.m3842compareTo0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl(), Dp.m3843constructorimpl(0)) > 0) {
                            DrawScope.m2107drawCircleVaOC9Bg$default(Canvas, stateRadioColor.getValue().m1641unboximpl(), Canvas.mo318toPx0680j_4(stateM105animateDpAsStateKz89ssw.getValue().m3857unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierM456requiredSize3ABfNKs15, (Function1) objRememberedValue2, composerStartRestartGroup, r12);
            modifier2 = modifier18;
            mutableInteractionSource5 = mutableInteractionSource4;
            z7 = z6;
            radioButtonColors2 = radioButtonColorsM1145colorsRGew2ao;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i116) {
                RadioButtonKt.RadioButton(z, function0, modifier2, z7, mutableInteractionSource5, radioButtonColors2, composer2, i | 1, i2);
            }
        });
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m3843constructorimpl(f);
        float fM3843constructorimpl = Dp.m3843constructorimpl(20);
        RadioButtonSize = fM3843constructorimpl;
        RadioRadius = Dp.m3843constructorimpl(fM3843constructorimpl / f);
        RadioButtonDotSize = Dp.m3843constructorimpl(12);
        RadioStrokeWidth = Dp.m3843constructorimpl(f);
    }
}
