package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ButtonKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0128  */
    /* JADX WARN: Code duplicated, block: B:102:0x012b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0130  */
    /* JADX WARN: Code duplicated, block: B:106:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x0139  */
    /* JADX WARN: Code duplicated, block: B:111:0x0145  */
    /* JADX WARN: Code duplicated, block: B:115:0x015c  */
    /* JADX WARN: Code duplicated, block: B:117:0x016f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0199 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x019b  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:150:0x020e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0211  */
    /* JADX WARN: Code duplicated, block: B:154:0x0217  */
    /* JADX WARN: Code duplicated, block: B:155:0x022e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0232  */
    /* JADX WARN: Code duplicated, block: B:158:0x023d  */
    /* JADX WARN: Code duplicated, block: B:163:0x0289  */
    /* JADX WARN: Code duplicated, block: B:165:0x0295  */
    /* JADX WARN: Code duplicated, block: B:166:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:171:0x030c  */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108  */
    /* JADX WARN: Code duplicated, block: B:93:0x010c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    /* JADX WARN: Code duplicated, block: B:96:0x0119  */
    /* JADX WARN: Instruction removed from duplicated block: B:115:0x015c, please report this as an issue */
    public static final void Button(final Function0<Unit> onClick, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final int i3;
        int i4;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        ButtonElevation buttonElevationM930elevationR_JCAzs;
        Shape small;
        int i8;
        int i9;
        final ButtonColors buttonColorsM929buttonColorsro_MJ88;
        int i10;
        final PaddingValues paddingValues2;
        int i11;
        int i12;
        Modifier modifier2;
        boolean z2;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke2;
        final PaddingValues contentPadding;
        ButtonElevation buttonElevation2;
        Shape shape2;
        boolean z3;
        Object objRememberedValue;
        State<Dp> stateElevation;
        float fM3843constructorimpl;
        Composer composer2;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final ButtonElevation buttonElevation3;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Button)P(8,7,5,6,4,9!2,3)94@4533L39,95@4623L11,96@4669L6,98@4759L14,102@4922L21,108@5086L24,111@5228L37,103@4948L1086:Button.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        if ((i2 & 16) == 0) {
                            buttonElevationM930elevationR_JCAzs = buttonElevation;
                            int i15 = composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs) ? 16384 : 8192;
                            i3 |= i15;
                        } else {
                            buttonElevationM930elevationR_JCAzs = buttonElevation;
                        }
                        i3 |= i15;
                    } else {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                    }
                    if ((458752 & i) == 0) {
                        small = shape;
                        if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(small)) {
                            i13 = 65536;
                        } else {
                            i13 = 131072;
                        }
                        i3 |= i13;
                    } else {
                        small = shape;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((29360128 & i) == 0) {
                        if ((i2 & 128) == 0) {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            int i16 = composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88) ? 8388608 : 4194304;
                            i3 |= i16;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        i3 |= i16;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 234881024) == 0) {
                            paddingValues2 = paddingValues;
                            if (composerStartRestartGroup.changed(paddingValues2)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 536870912;
                            } else {
                                i12 = 268435456;
                            }
                            i3 |= i12;
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
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
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i3 &= -29360129;
                                } else {
                                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                } else {
                                    contentPadding = paddingValues;
                                }
                                buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                                shape2 = small;
                                z3 = z2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                borderStroke2 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                contentPadding = paddingValues2;
                                shape2 = small;
                                z3 = z;
                                buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i17 = i3 >> 6;
                            int i18 = (i17 & 14) | ((i3 >> 18) & 112);
                            final State<Color> stateContentColor = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i18);
                            long jM1641unboximpl = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i18).getValue().m1641unboximpl();
                            long jM1630copywmQWz5c$default = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            stateElevation = buttonElevation2 != null ? buttonElevation2.elevation(z3, mutableInteractionSource3, composerStartRestartGroup, i17 & 1022) : null;
                            if (stateElevation != null) {
                                fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                            } else {
                                fM3843constructorimpl = Dp.m3843constructorimpl(0);
                            }
                            PaddingValues paddingValues3 = contentPadding;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl, jM1630copywmQWz5c$default, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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
                                    ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                    if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor))))};
                                        final PaddingValues paddingValues4 = contentPadding;
                                        final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                        final int i20 = i3;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i21) {
                                                ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                    final PaddingValues paddingValues5 = paddingValues4;
                                                    final Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                                                    final int i22 = i20;
                                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                            invoke(composer5, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer5, int i23) {
                                                            ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                            if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues5);
                                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                                int i24 = ((i22 >> 18) & 7168) | 432;
                                                                composer5.startReplaceableGroup(693286680);
                                                                ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                                composer5.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                Object objConsume = composer5.consume(localDensity);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                Density density = (Density) objConsume;
                                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                Object objConsume2 = composer5.consume(localLayoutDirection);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                Object objConsume3 = composer5.consume(localViewConfiguration);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                composer5.disableReusing();
                                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                                composer5.enableReusing();
                                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                                composer5.startReplaceableGroup(2058660585);
                                                                composer5.startReplaceableGroup(-678309503);
                                                                ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                                function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                                composer5.endReplaceableGroup();
                                                                composer5.endReplaceableGroup();
                                                                composer5.endNode();
                                                                composer5.endReplaceableGroup();
                                                                composer5.endReplaceableGroup();
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, 48);
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 56);
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, (i17 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                            buttonElevation3 = buttonElevation2;
                            paddingValues2 = paddingValues3;
                            modifier3 = modifier2;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z4 = z;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            buttonElevation3 = buttonElevationM930elevationR_JCAzs;
                            shape3 = small;
                            composer2 = composerStartRestartGroup;
                            borderStroke3 = borderStroke;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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
                                ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                            }
                        });
                    }
                    i3 |= 100663296;
                    paddingValues2 = paddingValues;
                    if ((i2 & 512) != 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i19 = i3 >> 6;
                        int i110 = (i19 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor2 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i110);
                        long jM1641unboximpl2 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i110).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default2 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues4 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl2, jM1630copywmQWz5c$default2, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i111 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor2))))};
                                    final PaddingValues paddingValues5 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues6 = paddingValues5;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues6);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i19 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues4;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i111 = i3 >> 6;
                        int i112 = (i111 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor3 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i112);
                        long jM1641unboximpl3 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i112).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default3 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor3), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues5 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl3, jM1630copywmQWz5c$default3, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i113 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor3))))};
                                    final PaddingValues paddingValues6 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues7 = paddingValues6;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues7);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i111 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues5;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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
                            ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                        }
                    });
                }
                i3 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                        }
                        i3 |= i15;
                    } else {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i15;
                } else {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                }
                if ((458752 & i) == 0) {
                    small = shape;
                    if ((i2 & 32) == 0) {
                        i13 = 65536;
                    } else {
                        i13 = 65536;
                    }
                    i3 |= i13;
                } else {
                    small = shape;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((29360128 & i) == 0) {
                    if ((i2 & 128) == 0) {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                        }
                        i3 |= i16;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    i3 |= i16;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i113 = i3 >> 6;
                        int i114 = (i113 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor4 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i114);
                        long jM1641unboximpl4 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i114).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default4 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor4), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues6 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl4, jM1630copywmQWz5c$default4, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i115 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor4))))};
                                    final PaddingValues paddingValues7 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues8 = paddingValues7;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues8);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i113 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues6;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i115 = i3 >> 6;
                        int i116 = (i115 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor5 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i116);
                        long jM1641unboximpl5 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i116).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default5 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor5), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues7 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl5, jM1630copywmQWz5c$default5, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i117 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor5))))};
                                    final PaddingValues paddingValues8 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues9 = paddingValues8;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues9);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i115 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues7;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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
                            ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                        }
                    });
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i117 = i3 >> 6;
                    int i118 = (i117 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor6 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i118);
                    long jM1641unboximpl6 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i118).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default6 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues8 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl6, jM1630copywmQWz5c$default6, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i119) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i119 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor6))))};
                                final PaddingValues paddingValues9 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues10 = paddingValues9;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues10);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i117 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues8;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i119 = i3 >> 6;
                    int i1110 = (i119 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor7 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1110);
                    long jM1641unboximpl7 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1110).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default7 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor7), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues9 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl7, jM1630copywmQWz5c$default7, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i1111) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i1111 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor7))))};
                                final PaddingValues paddingValues10 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues11 = paddingValues10;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues11);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i119 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues9;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                    public final void invoke(Composer composer3, int i1111) {
                        ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 384;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                        }
                        i3 |= i15;
                    } else {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i15;
                } else {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                }
                if ((458752 & i) == 0) {
                    small = shape;
                    if ((i2 & 32) == 0) {
                        i13 = 65536;
                    } else {
                        i13 = 65536;
                    }
                    i3 |= i13;
                } else {
                    small = shape;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((29360128 & i) == 0) {
                    if ((i2 & 128) == 0) {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                        }
                        i3 |= i16;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    i3 |= i16;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111 = i3 >> 6;
                        int i1112 = (i1111 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor8 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1112);
                        long jM1641unboximpl8 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1112).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default8 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor8), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues10 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl8, jM1630copywmQWz5c$default8, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                            public final void invoke(Composer composer3, int i1113) {
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i1113 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor8))))};
                                    final PaddingValues paddingValues11 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues12 = paddingValues11;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues12);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i1111 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues10;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1113 = i3 >> 6;
                        int i1114 = (i1113 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor9 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1114);
                        long jM1641unboximpl9 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1114).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default9 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor9), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues11 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl9, jM1630copywmQWz5c$default9, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                            public final void invoke(Composer composer3, int i1115) {
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i1115 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor9))))};
                                    final PaddingValues paddingValues12 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues13 = paddingValues12;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues13);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i1113 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues11;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                        public final void invoke(Composer composer3, int i1115) {
                            ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                        }
                    });
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1115 = i3 >> 6;
                    int i1116 = (i1115 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor10 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1116);
                    long jM1641unboximpl10 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1116).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default10 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor10), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues12 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl10, jM1630copywmQWz5c$default10, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i1117) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i1117 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor10))))};
                                final PaddingValues paddingValues13 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues14 = paddingValues13;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues14);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i1115 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues12;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1117 = i3 >> 6;
                    int i1118 = (i1117 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor11 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1118);
                    long jM1641unboximpl11 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1118).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default11 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor11), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues13 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl11, jM1630copywmQWz5c$default11, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i1119) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i1119 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor11))))};
                                final PaddingValues paddingValues14 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues15 = paddingValues14;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues15);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i1117 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues13;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                    public final void invoke(Composer composer3, int i1119) {
                        ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                    }
                    i3 |= i15;
                } else {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                }
                i3 |= i15;
            } else {
                buttonElevationM930elevationR_JCAzs = buttonElevation;
            }
            if ((458752 & i) == 0) {
                small = shape;
                if ((i2 & 32) == 0) {
                    i13 = 65536;
                } else {
                    i13 = 65536;
                }
                i3 |= i13;
            } else {
                small = shape;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((29360128 & i) == 0) {
                if ((i2 & 128) == 0) {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                    }
                    i3 |= i16;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                i3 |= i16;
            } else {
                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1119 = i3 >> 6;
                    int i11110 = (i1119 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor12 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11110);
                    long jM1641unboximpl12 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11110).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default12 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor12), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues14 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl12, jM1630copywmQWz5c$default12, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i11111) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i11111 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor12))))};
                                final PaddingValues paddingValues15 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues16 = paddingValues15;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues16);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i1119 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues14;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111 = i3 >> 6;
                    int i11112 = (i11111 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor13 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11112);
                    long jM1641unboximpl13 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11112).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default13 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor13), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues15 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl13, jM1630copywmQWz5c$default13, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i11113) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i11113 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor13))))};
                                final PaddingValues paddingValues16 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues17 = paddingValues16;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues17);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i11111 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues15;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                    public final void invoke(Composer composer3, int i11113) {
                        ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= C.ENCODING_PCM_32BIT;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i11113 = i3 >> 6;
                int i11114 = (i11113 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor14 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11114);
                long jM1641unboximpl14 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11114).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default14 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor14), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues16 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl14, jM1630copywmQWz5c$default14, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i11115) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i11115 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor14))))};
                            final PaddingValues paddingValues17 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues18 = paddingValues17;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues18);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i11113 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues16;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i11115 = i3 >> 6;
                int i11116 = (i11115 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor15 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11116);
                long jM1641unboximpl15 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11116).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default15 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor15), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues17 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl15, jM1630copywmQWz5c$default15, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i11117) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i11117 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor15))))};
                            final PaddingValues paddingValues18 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues19 = paddingValues18;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues19);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i11115 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues17;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                public final void invoke(Composer composer3, int i11117) {
                    ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                        }
                        i3 |= i15;
                    } else {
                        buttonElevationM930elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i15;
                } else {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                }
                if ((458752 & i) == 0) {
                    small = shape;
                    if ((i2 & 32) == 0) {
                        i13 = 65536;
                    } else {
                        i13 = 65536;
                    }
                    i3 |= i13;
                } else {
                    small = shape;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((29360128 & i) == 0) {
                    if ((i2 & 128) == 0) {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                        }
                        i3 |= i16;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    i3 |= i16;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i11117 = i3 >> 6;
                        int i11118 = (i11117 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor16 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11118);
                        long jM1641unboximpl16 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11118).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default16 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor16), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues18 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl16, jM1630copywmQWz5c$default16, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                            public final void invoke(Composer composer3, int i11119) {
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i11119 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor16))))};
                                    final PaddingValues paddingValues19 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues110 = paddingValues19;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues110);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i11117 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues18;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
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
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i3 &= -29360129;
                            } else {
                                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                            shape2 = small;
                            z3 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i11119 = i3 >> 6;
                        int i111110 = (i11119 & 14) | ((i3 >> 18) & 112);
                        final State<Color> stateContentColor17 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i111110);
                        long jM1641unboximpl17 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i111110).getValue().m1641unboximpl();
                        long jM1630copywmQWz5c$default17 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor17), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        if (stateElevation != null) {
                            fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                        } else {
                            fM3843constructorimpl = Dp.m3843constructorimpl(0);
                        }
                        PaddingValues paddingValues19 = contentPadding;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl17, jM1630copywmQWz5c$default17, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                            public final void invoke(Composer composer3, int i111111) {
                                ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                                if ((i111111 & 11) != 2 || !composer3.getSkipping()) {
                                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor17))))};
                                    final PaddingValues paddingValues110 = contentPadding;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                    final int i20 = i3;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i21) {
                                            ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues111 = paddingValues110;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                                final int i22 = i20;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                        if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues111);
                                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                            int i24 = ((i22 >> 18) & 7168) | 432;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume = composer5.consume(localDensity);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            Density density = (Density) objConsume;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume2 = composer5.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object objConsume3 = composer5.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            composer5.disableReusing();
                                                            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                            Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            composer5.enableReusing();
                                                            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            composer5.startReplaceableGroup(-678309503);
                                                            ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                            function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 56);
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i11119 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                        buttonElevation3 = buttonElevation2;
                        paddingValues2 = paddingValues19;
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                        public final void invoke(Composer composer3, int i111111) {
                            ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                        }
                    });
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111111 = i3 >> 6;
                    int i111112 = (i111111 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor18 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i111112);
                    long jM1641unboximpl18 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i111112).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default18 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor18), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues110 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl18, jM1630copywmQWz5c$default18, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i111113) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i111113 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor18))))};
                                final PaddingValues paddingValues111 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues112 = paddingValues111;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues112);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i111111 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues110;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111113 = i3 >> 6;
                    int i111114 = (i111113 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor19 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i111114);
                    long jM1641unboximpl19 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i111114).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default19 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor19), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues111 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl19, jM1630copywmQWz5c$default19, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i111115) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i111115 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor19))))};
                                final PaddingValues paddingValues112 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues113 = paddingValues112;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues113);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i111113 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues111;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                    public final void invoke(Composer composer3, int i111115) {
                        ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                    }
                    i3 |= i15;
                } else {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                }
                i3 |= i15;
            } else {
                buttonElevationM930elevationR_JCAzs = buttonElevation;
            }
            if ((458752 & i) == 0) {
                small = shape;
                if ((i2 & 32) == 0) {
                    i13 = 65536;
                } else {
                    i13 = 65536;
                }
                i3 |= i13;
            } else {
                small = shape;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((29360128 & i) == 0) {
                if ((i2 & 128) == 0) {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                    }
                    i3 |= i16;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                i3 |= i16;
            } else {
                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111115 = i3 >> 6;
                    int i111116 = (i111115 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor110 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i111116);
                    long jM1641unboximpl110 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i111116).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default110 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues112 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl110, jM1630copywmQWz5c$default110, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i111117) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i111117 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor110))))};
                                final PaddingValues paddingValues113 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues114 = paddingValues113;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues114);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i111115 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues112;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111117 = i3 >> 6;
                    int i111118 = (i111117 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor111 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i111118);
                    long jM1641unboximpl111 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i111118).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default111 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues113 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl111, jM1630copywmQWz5c$default111, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i111119) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i111119 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor111))))};
                                final PaddingValues paddingValues114 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues115 = paddingValues114;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues115);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i111117 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues113;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                    public final void invoke(Composer composer3, int i111119) {
                        ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= C.ENCODING_PCM_32BIT;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i111119 = i3 >> 6;
                int i1111110 = (i111119 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor112 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1111110);
                long jM1641unboximpl112 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1111110).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default112 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues114 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl112, jM1630copywmQWz5c$default112, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i1111111) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i1111111 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor112))))};
                            final PaddingValues paddingValues115 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues116 = paddingValues115;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues116);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i111119 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues114;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111 = i3 >> 6;
                int i1111112 = (i1111111 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor113 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1111112);
                long jM1641unboximpl113 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1111112).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default113 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues115 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl113, jM1630copywmQWz5c$default113, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i1111113) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i1111113 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor113))))};
                            final PaddingValues paddingValues116 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues117 = paddingValues116;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues117);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i1111111 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues115;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                public final void invoke(Composer composer3, int i1111113) {
                    ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                    }
                    i3 |= i15;
                } else {
                    buttonElevationM930elevationR_JCAzs = buttonElevation;
                }
                i3 |= i15;
            } else {
                buttonElevationM930elevationR_JCAzs = buttonElevation;
            }
            if ((458752 & i) == 0) {
                small = shape;
                if ((i2 & 32) == 0) {
                    i13 = 65536;
                } else {
                    i13 = 65536;
                }
                i3 |= i13;
            } else {
                small = shape;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((29360128 & i) == 0) {
                if ((i2 & 128) == 0) {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                    }
                    i3 |= i16;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                i3 |= i16;
            } else {
                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1111113 = i3 >> 6;
                    int i1111114 = (i1111113 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor114 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1111114);
                    long jM1641unboximpl114 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1111114).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default114 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues116 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl114, jM1630copywmQWz5c$default114, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i1111115) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i1111115 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor114))))};
                                final PaddingValues paddingValues117 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues118 = paddingValues117;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues118);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i1111113 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues116;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
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
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i3 &= -29360129;
                        } else {
                            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                        shape2 = small;
                        z3 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1111115 = i3 >> 6;
                    int i1111116 = (i1111115 & 14) | ((i3 >> 18) & 112);
                    final State<Color> stateContentColor115 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1111116);
                    long jM1641unboximpl115 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1111116).getValue().m1641unboximpl();
                    long jM1630copywmQWz5c$default115 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    if (stateElevation != null) {
                        fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                    } else {
                        fM3843constructorimpl = Dp.m3843constructorimpl(0);
                    }
                    PaddingValues paddingValues117 = contentPadding;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl115, jM1630copywmQWz5c$default115, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                        public final void invoke(Composer composer3, int i1111117) {
                            ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                            if ((i1111117 & 11) != 2 || !composer3.getSkipping()) {
                                ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor115))))};
                                final PaddingValues paddingValues118 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                                final int i20 = i3;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues119 = paddingValues118;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                            final int i22 = i20;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i23) {
                                                    ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                        Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues119);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                        int i24 = ((i22 >> 18) & 7168) | 432;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume = composer5.consume(localDensity);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        Density density = (Density) objConsume;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume2 = composer5.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object objConsume3 = composer5.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        composer5.disableReusing();
                                                        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        composer5.enableReusing();
                                                        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        composer5.startReplaceableGroup(-678309503);
                                                        ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                        function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i1111115 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                    buttonElevation3 = buttonElevation2;
                    paddingValues2 = paddingValues117;
                    modifier3 = modifier2;
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                    public final void invoke(Composer composer3, int i1111117) {
                        ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= C.ENCODING_PCM_32BIT;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111117 = i3 >> 6;
                int i1111118 = (i1111117 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor116 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i1111118);
                long jM1641unboximpl116 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i1111118).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default116 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues118 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl116, jM1630copywmQWz5c$default116, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i1111119) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i1111119 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor116))))};
                            final PaddingValues paddingValues119 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues1110 = paddingValues119;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues1110);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i1111117 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues118;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111119 = i3 >> 6;
                int i11111110 = (i1111119 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor117 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11111110);
                long jM1641unboximpl117 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11111110).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default117 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues119 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl117, jM1630copywmQWz5c$default117, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i11111111) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i11111111 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor117))))};
                            final PaddingValues paddingValues1110 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues1111 = paddingValues1110;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues1111);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i1111119 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues119;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                public final void invoke(Composer composer3, int i11111111) {
                    ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                buttonElevationM930elevationR_JCAzs = buttonElevation;
                if (composerStartRestartGroup.changed(buttonElevationM930elevationR_JCAzs)) {
                }
                i3 |= i15;
            } else {
                buttonElevationM930elevationR_JCAzs = buttonElevation;
            }
            i3 |= i15;
        } else {
            buttonElevationM930elevationR_JCAzs = buttonElevation;
        }
        if ((458752 & i) == 0) {
            small = shape;
            if ((i2 & 32) == 0) {
                i13 = 65536;
            } else {
                i13 = 65536;
            }
            i3 |= i13;
        } else {
            small = shape;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((29360128 & i) == 0) {
            if ((i2 & 128) == 0) {
                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                if (composerStartRestartGroup.changed(buttonColorsM929buttonColorsro_MJ88)) {
                }
                i3 |= i16;
            } else {
                buttonColorsM929buttonColorsro_MJ88 = buttonColors;
            }
            i3 |= i16;
        } else {
            buttonColorsM929buttonColorsro_MJ88 = buttonColors;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 234881024) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                i3 |= C.ENCODING_PCM_32BIT;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i11111111 = i3 >> 6;
                int i11111112 = (i11111111 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor118 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11111112);
                long jM1641unboximpl118 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11111112).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default118 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues1110 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl118, jM1630copywmQWz5c$default118, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i11111113) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i11111113 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor118))))};
                            final PaddingValues paddingValues1111 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues1112 = paddingValues1111;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues1112);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i11111111 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues1110;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
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
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i3 &= -29360129;
                    } else {
                        buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                    shape2 = small;
                    z3 = z2;
                }
                composerStartRestartGroup.endDefaults();
                int i11111113 = i3 >> 6;
                int i11111114 = (i11111113 & 14) | ((i3 >> 18) & 112);
                final State<Color> stateContentColor119 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11111114);
                long jM1641unboximpl119 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11111114).getValue().m1641unboximpl();
                long jM1630copywmQWz5c$default119 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                if (stateElevation != null) {
                    fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
                } else {
                    fM3843constructorimpl = Dp.m3843constructorimpl(0);
                }
                PaddingValues paddingValues1111 = contentPadding;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl119, jM1630copywmQWz5c$default119, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                    public final void invoke(Composer composer3, int i11111115) {
                        ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                        if ((i11111115 & 11) != 2 || !composer3.getSkipping()) {
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor119))))};
                            final PaddingValues paddingValues1112 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                            final int i20 = i3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues1113 = paddingValues1112;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                        final int i22 = i20;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                                if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues1113);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                    int i24 = ((i22 >> 18) & 7168) | 432;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume = composer5.consume(localDensity);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    Density density = (Density) objConsume;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object objConsume3 = composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    composer5.disableReusing();
                                                    Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                    Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    composer5.enableReusing();
                                                    function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    composer5.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                    function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 56);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i11111113 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
                buttonElevation3 = buttonElevation2;
                paddingValues2 = paddingValues1111;
                modifier3 = modifier2;
                z4 = z3;
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

                public final void invoke(Composer composer3, int i11111115) {
                    ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 100663296;
        paddingValues2 = paddingValues;
        if ((i2 & 512) != 0) {
            i3 |= C.ENCODING_PCM_32BIT;
        } else if ((1879048192 & i) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i12 = 536870912;
            } else {
                i12 = 268435456;
            }
            i3 |= i12;
        }
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -29360129;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                shape2 = small;
                z3 = z2;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -29360129;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                shape2 = small;
                z3 = z2;
            }
            composerStartRestartGroup.endDefaults();
            int i11111115 = i3 >> 6;
            int i11111116 = (i11111115 & 14) | ((i3 >> 18) & 112);
            final State<Color> stateContentColor1110 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11111116);
            long jM1641unboximpl1110 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11111116).getValue().m1641unboximpl();
            long jM1630copywmQWz5c$default1110 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor1110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            if (buttonElevation2 != null) {
            }
            if (stateElevation != null) {
                fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
            } else {
                fM3843constructorimpl = Dp.m3843constructorimpl(0);
            }
            PaddingValues paddingValues1112 = contentPadding;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl1110, jM1630copywmQWz5c$default1110, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                public final void invoke(Composer composer3, int i11111117) {
                    ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                    if ((i11111117 & 11) != 2 || !composer3.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor1110))))};
                        final PaddingValues paddingValues1113 = contentPadding;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                        final int i20 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i21) {
                                ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final PaddingValues paddingValues1114 = paddingValues1113;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i22 = i20;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i23) {
                                            ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                            if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues1114);
                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i24 = ((i22 >> 18) & 7168) | 432;
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer5.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer5.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer5.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                composer5.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer5.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                composer5.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 48);
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 56);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i11111115 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
            shape3 = shape2;
            borderStroke3 = borderStroke2;
            buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
            buttonElevation3 = buttonElevation2;
            paddingValues2 = paddingValues1112;
            modifier3 = modifier2;
            z4 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -29360129;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                shape2 = small;
                z3 = z2;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
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
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    buttonElevationM930elevationR_JCAzs = ButtonDefaults.INSTANCE.m930elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM929buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m929buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i3 &= -29360129;
                } else {
                    buttonColorsM929buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                buttonElevation2 = buttonElevationM930elevationR_JCAzs;
                shape2 = small;
                z3 = z2;
            }
            composerStartRestartGroup.endDefaults();
            int i11111117 = i3 >> 6;
            int i11111118 = (i11111117 & 14) | ((i3 >> 18) & 112);
            final State<Color> stateContentColor1111 = buttonColorsM929buttonColorsro_MJ88.contentColor(z3, composerStartRestartGroup, i11111118);
            long jM1641unboximpl1111 = buttonColorsM929buttonColorsro_MJ88.backgroundColor(z3, composerStartRestartGroup, i11111118).getValue().m1641unboximpl();
            long jM1630copywmQWz5c$default1111 = Color.m1630copywmQWz5c$default(m939Button$lambda1(stateContentColor1111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            if (buttonElevation2 != null) {
            }
            if (stateElevation != null) {
                fM3843constructorimpl = stateElevation.getValue().m3857unboximpl();
            } else {
                fM3843constructorimpl = Dp.m3843constructorimpl(0);
            }
            PaddingValues paddingValues1113 = contentPadding;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1176SurfaceLPr_se0(onClick, modifier2, z3, shape2, jM1641unboximpl1111, jM1630copywmQWz5c$default1111, borderStroke2, fM3843constructorimpl, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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

                public final void invoke(Composer composer3, int i11111119) {
                    ComposerKt.sourceInformation(composer3, "C114@5345L683:Button.kt#jmzs0o");
                    if ((i11111119 & 11) != 2 || !composer3.getSkipping()) {
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1633getAlphaimpl(ButtonKt.m939Button$lambda1(stateContentColor1111))))};
                        final PaddingValues paddingValues1114 = contentPadding;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                        final int i20 = i3;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i21) {
                                ComposerKt.sourceInformation(composer4, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final PaddingValues paddingValues1115 = paddingValues1114;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4 = function3;
                                    final int i22 = i20;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i23) {
                                            ComposerKt.sourceInformation(composer5, "C118@5537L467:Button.kt#jmzs0o");
                                            if ((i23 & 11) != 2 || !composer5.getSkipping()) {
                                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m448defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m935getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m934getMinHeightD9Ej5fM()), paddingValues1115);
                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                                int i24 = ((i22 >> 18) & 7168) | 432;
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume = composer5.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                Density density = (Density) objConsume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume2 = composer5.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composer5.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPadding);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                composer5.disableReusing();
                                                Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composer5);
                                                Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                composer5.enableReusing();
                                                function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                composer5.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation(composer5, "C80@3988L9:Row.kt#2w3rfo");
                                                function5.invoke(RowScopeInstance.INSTANCE, composer5, Integer.valueOf(((i24 >> 6) & 112) | 6));
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 48);
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 56);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i11111117 & 7168) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 112) | (i3 & 896) | (i3 & 3670016) | ((i3 << 15) & 234881024), 0);
            shape3 = shape2;
            borderStroke3 = borderStroke2;
            buttonColorsM929buttonColorsro_MJ88 = buttonColorsM929buttonColorsro_MJ88;
            buttonElevation3 = buttonElevation2;
            paddingValues2 = paddingValues1113;
            modifier3 = modifier2;
            z4 = z3;
            mutableInteractionSource4 = mutableInteractionSource3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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

            public final void invoke(Composer composer3, int i11111119) {
                ButtonKt.Button(onClick, modifier3, z4, mutableInteractionSource4, buttonElevation3, shape3, borderStroke3, buttonColorsM929buttonColorsro_MJ88, paddingValues2, content, composer3, i | 1, i2);
            }
        });
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-1776134358);
        ComposerKt.sourceInformation(composer, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)168@7956L39,170@8070L6,171@8127L14,172@8185L22,175@8325L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Button(onClick, modifier2, z2, mutableInteractionSource2, (i2 & 16) != 0 ? null : buttonElevation, (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape, (i2 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke, (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m937outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors, (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues, content, composer, i & 2147483646, 0);
        composer.endReplaceableGroup();
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(288797557);
        ComposerKt.sourceInformation(composer, "C(TextButton)P(8,7,5,6,4,9!2,3)222@10527L39,224@10641L6,226@10731L18,229@10877L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Button(onClick, modifier2, z2, mutableInteractionSource2, (i2 & 16) != 0 ? null : buttonElevation, (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape, (i2 & 64) != 0 ? null : borderStroke, (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m938textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors, (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues, content, composer, i & 2147483646, 0);
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Button$lambda-1, reason: not valid java name */
    public static final long m939Button$lambda1(State<Color> state) {
        return state.getValue().m1641unboximpl();
    }
}
