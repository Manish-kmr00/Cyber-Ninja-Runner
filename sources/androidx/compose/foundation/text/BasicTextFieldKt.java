package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.bidmachine.protobuf.EventTypeExtended;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020#2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BasicTextFieldKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0144  */
    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:103:0x014d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:108:0x015a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0160  */
    /* JADX WARN: Code duplicated, block: B:112:0x0166  */
    /* JADX WARN: Code duplicated, block: B:113:0x0169  */
    /* JADX WARN: Code duplicated, block: B:115:0x016e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0174  */
    /* JADX WARN: Code duplicated, block: B:119:0x0177  */
    /* JADX WARN: Code duplicated, block: B:121:0x017d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0183  */
    /* JADX WARN: Code duplicated, block: B:124:0x0186  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:131:0x0197  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:166:0x0219  */
    /* JADX WARN: Code duplicated, block: B:168:0x0222  */
    /* JADX WARN: Code duplicated, block: B:175:0x0250 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x0252  */
    /* JADX WARN: Code duplicated, block: B:177:0x0257  */
    /* JADX WARN: Code duplicated, block: B:179:0x025b  */
    /* JADX WARN: Code duplicated, block: B:180:0x025e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0262  */
    /* JADX WARN: Code duplicated, block: B:183:0x0264  */
    /* JADX WARN: Code duplicated, block: B:185:0x0268  */
    /* JADX WARN: Code duplicated, block: B:186:0x026f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0273  */
    /* JADX WARN: Code duplicated, block: B:189:0x027a  */
    /* JADX WARN: Code duplicated, block: B:191:0x027e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0285  */
    /* JADX WARN: Code duplicated, block: B:194:0x0289  */
    /* JADX WARN: Code duplicated, block: B:195:0x028b  */
    /* JADX WARN: Code duplicated, block: B:197:0x028f  */
    /* JADX WARN: Code duplicated, block: B:198:0x0293  */
    /* JADX WARN: Code duplicated, block: B:200:0x0297  */
    /* JADX WARN: Code duplicated, block: B:201:0x029e  */
    /* JADX WARN: Code duplicated, block: B:203:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:204:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:206:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:208:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:210:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:213:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:214:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:216:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:217:0x030a  */
    /* JADX WARN: Code duplicated, block: B:221:0x0337  */
    /* JADX WARN: Code duplicated, block: B:224:0x038f  */
    /* JADX WARN: Code duplicated, block: B:226:0x0397  */
    /* JADX WARN: Code duplicated, block: B:229:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:230:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:233:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:235:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:240:0x0451  */
    /* JADX WARN: Code duplicated, block: B:242:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x0099  */
    /* JADX WARN: Code duplicated, block: B:48:0x009e  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00be  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:80:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0115  */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013c  */
    public static final void BasicTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function1, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
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
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Modifier.Companion companion;
        boolean z4;
        boolean z5;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean z6;
        int i30;
        VisualTransformation none;
        AnonymousClass1 anonymousClass1;
        MutableInteractionSource mutableInteractionSource2;
        SolidColor solidColor;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M688getLambda1$foundation_release;
        int i31;
        Function1<? super TextLayoutResult, Unit> function2;
        VisualTransformation visualTransformation2;
        int i32;
        Object objRememberedValue;
        int i33;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        final MutableState mutableState2;
        int i34;
        boolean zChanged2;
        Object objRememberedValue4;
        final boolean z7;
        TextStyle textStyle3;
        VisualTransformation visualTransformation3;
        Function1<? super TextLayoutResult, Unit> function4;
        Brush brush2;
        KeyboardOptions keyboardOptions3;
        final boolean z8;
        final Modifier modifier2;
        MutableInteractionSource mutableInteractionSource3;
        int i35;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)133@7729L39,140@8123L57,148@8780L41,152@8898L373,150@8827L980:BasicTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i36 = i4 & 4;
        if (i36 == 0) {
            if ((i2 & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 16;
                if (i8 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(textStyle)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 128;
                if (i14 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(keyboardActions)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i5 |= i15;
                }
                i16 = i4 & 256;
                if (i16 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i5 |= i17;
                }
                i18 = i4 & 512;
                if (i18 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i19 = 536870912;
                    } else {
                        i19 = 268435456;
                    }
                    i5 |= i19;
                }
                i20 = i4 & 1024;
                if (i20 != 0) {
                    i21 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i3 | i22;
                } else {
                    i21 = i3;
                }
                i23 = i4 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i3 & 112) == 0) {
                    if (composerStartRestartGroup.changed(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                i26 = i4 & 4096;
                if (i26 != 0) {
                    if ((i3 & 896) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i27 = 256;
                        } else {
                            i27 = 128;
                        }
                        i25 |= i27;
                    }
                    if ((i3 & 7168) != 0) {
                        i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                    }
                    i28 = i4 & 16384;
                    if (i28 != 0) {
                        i25 |= 24576;
                    } else if ((i3 & 57344) == 0) {
                        i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                    }
                    i29 = i5;
                    if ((i5 & 1533916891) == 306783378 || (46811 & i25) != 9362 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i36 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i10 != 0) {
                                textStyle2 = TextStyle.INSTANCE.getDefault();
                            } else {
                                textStyle2 = textStyle;
                            }
                            if (i12 != 0) {
                                keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i14 != 0) {
                                keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i16 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (i18 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i;
                            }
                            if (i20 != 0) {
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                none = visualTransformation;
                            }
                            if (i23 != 0) {
                                anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                anonymousClass1 = function1;
                            }
                            if (i26 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i4 & 8192) != 0) {
                                solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                                i25 &= -7169;
                            } else {
                                solidColor = brush;
                            }
                            if (i28 != 0) {
                                function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                            } else {
                                function3M688getLambda1$foundation_release = function3;
                            }
                            i31 = i25;
                            function2 = anonymousClass1;
                            visualTransformation2 = none;
                            i32 = i30;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 8192) != 0) {
                                i25 &= -7169;
                            }
                            companion = modifier;
                            z4 = z;
                            z5 = z2;
                            textStyle2 = textStyle;
                            keyboardOptions2 = keyboardOptions;
                            keyboardActions2 = keyboardActions;
                            z6 = z3;
                            i32 = i;
                            visualTransformation2 = visualTransformation;
                            mutableInteractionSource2 = mutableInteractionSource;
                            solidColor = brush;
                            function3M688getLambda1$foundation_release = function3;
                            i31 = i25;
                            function2 = function1;
                        }
                        composerStartRestartGroup.endDefaults();
                        i33 = i32;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) objRememberedValue2;
                        TextFieldValue textFieldValueM3663copy3r_uNRQ$default = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(value);
                        boolean z9 = z5;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableState2 = (MutableState) objRememberedValue3;
                        ImeOptions imeOptions$foundation_release = keyboardOptions2.toImeOptions$foundation_release(z6);
                        boolean z10 = !z6;
                        if (z6) {
                            i34 = 1;
                        } else {
                            i34 = i33;
                        }
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        KeyboardOptions keyboardOptions4 = keyboardOptions2;
                        zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                        boolean z11 = z6;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newTextFieldValueState) {
                                    Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                    mutableState.setValue(newTextFieldValueState);
                                    boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                    mutableState2.setValue(newTextFieldValueState.getText());
                                    if (zAreEqual) {
                                        return;
                                    }
                                    onValueChange.invoke(newTextFieldValueState.getText());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i37 = i31 << 12;
                        int i38 = i29 >> 3;
                        CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z10, i34, imeOptions$foundation_release, keyboardActions2, z4, z9, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i37 & 57344) | (i37 & 458752) | (3670016 & i37) | (i37 & 29360128), (i38 & 7168) | ((i29 >> 18) & 112) | (i38 & 896) | (i31 & 57344), 0);
                        z7 = z9;
                        textStyle3 = textStyle2;
                        visualTransformation3 = visualTransformation2;
                        function4 = function2;
                        brush2 = solidColor;
                        keyboardOptions3 = keyboardOptions4;
                        z8 = z11;
                        modifier2 = companion;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        i35 = i33;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z4 = z;
                        z7 = z2;
                        textStyle3 = textStyle;
                        keyboardOptions3 = keyboardOptions;
                        keyboardActions2 = keyboardActions;
                        z8 = z3;
                        i35 = i;
                        visualTransformation3 = visualTransformation;
                        function4 = function1;
                        mutableInteractionSource3 = mutableInteractionSource;
                        brush2 = brush;
                        function3M688getLambda1$foundation_release = function3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    final boolean z12 = z4;
                    final TextStyle textStyle4 = textStyle3;
                    final KeyboardOptions keyboardOptions5 = keyboardOptions3;
                    final KeyboardActions keyboardActions3 = keyboardActions2;
                    final int i39 = i35;
                    final VisualTransformation visualTransformation4 = visualTransformation3;
                    final Function1<? super TextLayoutResult, Unit> function5 = function4;
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                    final Brush brush3 = brush2;
                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6 = function3M688getLambda1$foundation_release;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                        public final void invoke(Composer composer2, int i40) {
                            BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z12, z7, textStyle4, keyboardOptions5, keyboardActions3, z8, i39, visualTransformation4, function5, mutableInteractionSource4, brush3, function6, composer2, i2 | 1, i3, i4);
                        }
                    });
                }
                i25 |= 384;
                if ((i3 & 7168) != 0) {
                    i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                }
                i28 = i4 & 16384;
                if (i28 != 0) {
                    i25 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                }
                i29 = i5;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    } else {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    }
                    composerStartRestartGroup.endDefaults();
                    i33 = i32;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValueM3663copy3r_uNRQ$default2 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value);
                    boolean z13 = z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) objRememberedValue3;
                    ImeOptions imeOptions$foundation_release2 = keyboardOptions2.toImeOptions$foundation_release(z6);
                    boolean z14 = !z6;
                    if (z6) {
                        i34 = 1;
                    } else {
                        i34 = i33;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    KeyboardOptions keyboardOptions6 = keyboardOptions2;
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                    boolean z15 = z6;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i310 = i31 << 12;
                    int i311 = i29 >> 3;
                    CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default2, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z14, i34, imeOptions$foundation_release2, keyboardActions2, z4, z13, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i310 & 57344) | (i310 & 458752) | (3670016 & i310) | (i310 & 29360128), (i311 & 7168) | ((i29 >> 18) & 112) | (i311 & 896) | (i31 & 57344), 0);
                    z7 = z13;
                    textStyle3 = textStyle2;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    brush2 = solidColor;
                    keyboardOptions3 = keyboardOptions6;
                    z8 = z15;
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i35 = i33;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    } else {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    }
                    composerStartRestartGroup.endDefaults();
                    i33 = i32;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValueM3663copy3r_uNRQ$default3 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value);
                    boolean z16 = z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) objRememberedValue3;
                    ImeOptions imeOptions$foundation_release3 = keyboardOptions2.toImeOptions$foundation_release(z6);
                    boolean z17 = !z6;
                    if (z6) {
                        i34 = 1;
                    } else {
                        i34 = i33;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    KeyboardOptions keyboardOptions7 = keyboardOptions2;
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                    boolean z18 = z6;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i312 = i31 << 12;
                    int i313 = i29 >> 3;
                    CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default3, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z17, i34, imeOptions$foundation_release3, keyboardActions2, z4, z16, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i312 & 57344) | (i312 & 458752) | (3670016 & i312) | (i312 & 29360128), (i313 & 7168) | ((i29 >> 18) & 112) | (i313 & 896) | (i31 & 57344), 0);
                    z7 = z16;
                    textStyle3 = textStyle2;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    brush2 = solidColor;
                    keyboardOptions3 = keyboardOptions7;
                    z8 = z18;
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i35 = i33;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final boolean z19 = z4;
                final TextStyle textStyle5 = textStyle3;
                final KeyboardOptions keyboardOptions8 = keyboardOptions3;
                final KeyboardActions keyboardActions4 = keyboardActions2;
                final int i314 = i35;
                final VisualTransformation visualTransformation5 = visualTransformation3;
                final Function1<? super TextLayoutResult, Unit> function7 = function4;
                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                final Brush brush4 = brush2;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function8 = function3M688getLambda1$foundation_release;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                    public final void invoke(Composer composer2, int i40) {
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z19, z7, textStyle5, keyboardOptions8, keyboardActions4, z8, i314, visualTransformation5, function7, mutableInteractionSource5, brush4, function8, composer2, i2 | 1, i3, i4);
                    }
                });
            }
            i5 |= 3072;
            i8 = i4 & 16;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(textStyle)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(keyboardOptions)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i5 |= i13;
            }
            i14 = i4 & 128;
            if (i14 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i5 |= i15;
            }
            i16 = i4 & 256;
            if (i16 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i5 |= i17;
            }
            i18 = i4 & 512;
            if (i18 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i19 = 536870912;
                } else {
                    i19 = 268435456;
                }
                i5 |= i19;
            }
            i20 = i4 & 1024;
            if (i20 != 0) {
                i21 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i3 | i22;
            } else {
                i21 = i3;
            }
            i23 = i4 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            i26 = i4 & 4096;
            if (i26 != 0) {
                if ((i3 & 896) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i27 = 256;
                    } else {
                        i27 = 128;
                    }
                    i25 |= i27;
                }
                if ((i3 & 7168) != 0) {
                    i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                }
                i28 = i4 & 16384;
                if (i28 != 0) {
                    i25 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                }
                i29 = i5;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    } else {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    }
                    composerStartRestartGroup.endDefaults();
                    i33 = i32;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValueM3663copy3r_uNRQ$default4 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value);
                    boolean z110 = z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) objRememberedValue3;
                    ImeOptions imeOptions$foundation_release4 = keyboardOptions2.toImeOptions$foundation_release(z6);
                    boolean z111 = !z6;
                    if (z6) {
                        i34 = 1;
                    } else {
                        i34 = i33;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    KeyboardOptions keyboardOptions9 = keyboardOptions2;
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                    boolean z112 = z6;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i315 = i31 << 12;
                    int i316 = i29 >> 3;
                    CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default4, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z111, i34, imeOptions$foundation_release4, keyboardActions2, z4, z110, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i315 & 57344) | (i315 & 458752) | (3670016 & i315) | (i315 & 29360128), (i316 & 7168) | ((i29 >> 18) & 112) | (i316 & 896) | (i31 & 57344), 0);
                    z7 = z110;
                    textStyle3 = textStyle2;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    brush2 = solidColor;
                    keyboardOptions3 = keyboardOptions9;
                    z8 = z112;
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i35 = i33;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    } else {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    }
                    composerStartRestartGroup.endDefaults();
                    i33 = i32;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValueM3663copy3r_uNRQ$default5 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value);
                    boolean z113 = z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) objRememberedValue3;
                    ImeOptions imeOptions$foundation_release5 = keyboardOptions2.toImeOptions$foundation_release(z6);
                    boolean z114 = !z6;
                    if (z6) {
                        i34 = 1;
                    } else {
                        i34 = i33;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    KeyboardOptions keyboardOptions10 = keyboardOptions2;
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                    boolean z115 = z6;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i317 = i31 << 12;
                    int i318 = i29 >> 3;
                    CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default5, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z114, i34, imeOptions$foundation_release5, keyboardActions2, z4, z113, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i317 & 57344) | (i317 & 458752) | (3670016 & i317) | (i317 & 29360128), (i318 & 7168) | ((i29 >> 18) & 112) | (i318 & 896) | (i31 & 57344), 0);
                    z7 = z113;
                    textStyle3 = textStyle2;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    brush2 = solidColor;
                    keyboardOptions3 = keyboardOptions10;
                    z8 = z115;
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i35 = i33;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final boolean z116 = z4;
                final TextStyle textStyle6 = textStyle3;
                final KeyboardOptions keyboardOptions11 = keyboardOptions3;
                final KeyboardActions keyboardActions5 = keyboardActions2;
                final int i319 = i35;
                final VisualTransformation visualTransformation6 = visualTransformation3;
                final Function1<? super TextLayoutResult, Unit> function9 = function4;
                final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                final Brush brush5 = brush2;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function10 = function3M688getLambda1$foundation_release;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                    public final void invoke(Composer composer2, int i40) {
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z116, z7, textStyle6, keyboardOptions11, keyboardActions5, z8, i319, visualTransformation6, function9, mutableInteractionSource6, brush5, function10, composer2, i2 | 1, i3, i4);
                    }
                });
            }
            i25 |= 384;
            if ((i3 & 7168) != 0) {
                i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
            }
            i28 = i4 & 16384;
            if (i28 != 0) {
                i25 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
            }
            i29 = i5;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                } else {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                }
                composerStartRestartGroup.endDefaults();
                i33 = i32;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValueM3663copy3r_uNRQ$default6 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value);
                boolean z117 = z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue3;
                ImeOptions imeOptions$foundation_release6 = keyboardOptions2.toImeOptions$foundation_release(z6);
                boolean z118 = !z6;
                if (z6) {
                    i34 = 1;
                } else {
                    i34 = i33;
                }
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                KeyboardOptions keyboardOptions12 = keyboardOptions2;
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                boolean z119 = z6;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3110 = i31 << 12;
                int i3111 = i29 >> 3;
                CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default6, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z118, i34, imeOptions$foundation_release6, keyboardActions2, z4, z117, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i3110 & 57344) | (i3110 & 458752) | (3670016 & i3110) | (i3110 & 29360128), (i3111 & 7168) | ((i29 >> 18) & 112) | (i3111 & 896) | (i31 & 57344), 0);
                z7 = z117;
                textStyle3 = textStyle2;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                brush2 = solidColor;
                keyboardOptions3 = keyboardOptions12;
                z8 = z119;
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                i35 = i33;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                } else {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                }
                composerStartRestartGroup.endDefaults();
                i33 = i32;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValueM3663copy3r_uNRQ$default7 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value);
                boolean z1110 = z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue3;
                ImeOptions imeOptions$foundation_release7 = keyboardOptions2.toImeOptions$foundation_release(z6);
                boolean z1111 = !z6;
                if (z6) {
                    i34 = 1;
                } else {
                    i34 = i33;
                }
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                KeyboardOptions keyboardOptions13 = keyboardOptions2;
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                boolean z1112 = z6;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3112 = i31 << 12;
                int i3113 = i29 >> 3;
                CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default7, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z1111, i34, imeOptions$foundation_release7, keyboardActions2, z4, z1110, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i3112 & 57344) | (i3112 & 458752) | (3670016 & i3112) | (i3112 & 29360128), (i3113 & 7168) | ((i29 >> 18) & 112) | (i3113 & 896) | (i31 & 57344), 0);
                z7 = z1110;
                textStyle3 = textStyle2;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                brush2 = solidColor;
                keyboardOptions3 = keyboardOptions13;
                z8 = z1112;
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                i35 = i33;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final boolean z1113 = z4;
            final TextStyle textStyle7 = textStyle3;
            final KeyboardOptions keyboardOptions14 = keyboardOptions3;
            final KeyboardActions keyboardActions6 = keyboardActions2;
            final int i3114 = i35;
            final VisualTransformation visualTransformation7 = visualTransformation3;
            final Function1<? super TextLayoutResult, Unit> function11 = function4;
            final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
            final Brush brush6 = brush2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function12 = function3M688getLambda1$foundation_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                public final void invoke(Composer composer2, int i40) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z1113, z7, textStyle7, keyboardOptions14, keyboardActions6, z8, i3114, visualTransformation7, function11, mutableInteractionSource7, brush6, function12, composer2, i2 | 1, i3, i4);
                }
            });
        }
        i5 |= 384;
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i2 & 7168) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i5 |= i7;
            }
            i8 = i4 & 16;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(textStyle)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(keyboardOptions)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i5 |= i13;
            }
            i14 = i4 & 128;
            if (i14 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i5 |= i15;
            }
            i16 = i4 & 256;
            if (i16 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i5 |= i17;
            }
            i18 = i4 & 512;
            if (i18 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i19 = 536870912;
                } else {
                    i19 = 268435456;
                }
                i5 |= i19;
            }
            i20 = i4 & 1024;
            if (i20 != 0) {
                i21 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i3 | i22;
            } else {
                i21 = i3;
            }
            i23 = i4 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            i26 = i4 & 4096;
            if (i26 != 0) {
                if ((i3 & 896) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i27 = 256;
                    } else {
                        i27 = 128;
                    }
                    i25 |= i27;
                }
                if ((i3 & 7168) != 0) {
                    i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                }
                i28 = i4 & 16384;
                if (i28 != 0) {
                    i25 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                }
                i29 = i5;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    } else {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    }
                    composerStartRestartGroup.endDefaults();
                    i33 = i32;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValueM3663copy3r_uNRQ$default8 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value);
                    boolean z1114 = z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) objRememberedValue3;
                    ImeOptions imeOptions$foundation_release8 = keyboardOptions2.toImeOptions$foundation_release(z6);
                    boolean z1115 = !z6;
                    if (z6) {
                        i34 = 1;
                    } else {
                        i34 = i33;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    KeyboardOptions keyboardOptions15 = keyboardOptions2;
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                    boolean z1116 = z6;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i3115 = i31 << 12;
                    int i3116 = i29 >> 3;
                    CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default8, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z1115, i34, imeOptions$foundation_release8, keyboardActions2, z4, z1114, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i3115 & 57344) | (i3115 & 458752) | (3670016 & i3115) | (i3115 & 29360128), (i3116 & 7168) | ((i29 >> 18) & 112) | (i3116 & 896) | (i31 & 57344), 0);
                    z7 = z1114;
                    textStyle3 = textStyle2;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    brush2 = solidColor;
                    keyboardOptions3 = keyboardOptions15;
                    z8 = z1116;
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i35 = i33;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    } else {
                        if (i36 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass1 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                        } else {
                            function3M688getLambda1$foundation_release = function3;
                        }
                        i31 = i25;
                        function2 = anonymousClass1;
                        visualTransformation2 = none;
                        i32 = i30;
                    }
                    composerStartRestartGroup.endDefaults();
                    i33 = i32;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValueM3663copy3r_uNRQ$default9 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value);
                    boolean z1117 = z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) objRememberedValue3;
                    ImeOptions imeOptions$foundation_release9 = keyboardOptions2.toImeOptions$foundation_release(z6);
                    boolean z1118 = !z6;
                    if (z6) {
                        i34 = 1;
                    } else {
                        i34 = i33;
                    }
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    KeyboardOptions keyboardOptions16 = keyboardOptions2;
                    zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                    boolean z1119 = z6;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue newTextFieldValueState) {
                                Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                                mutableState.setValue(newTextFieldValueState);
                                boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                                mutableState2.setValue(newTextFieldValueState.getText());
                                if (zAreEqual) {
                                    return;
                                }
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i3117 = i31 << 12;
                    int i3118 = i29 >> 3;
                    CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default9, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z1118, i34, imeOptions$foundation_release9, keyboardActions2, z4, z1117, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i3117 & 57344) | (i3117 & 458752) | (3670016 & i3117) | (i3117 & 29360128), (i3118 & 7168) | ((i29 >> 18) & 112) | (i3118 & 896) | (i31 & 57344), 0);
                    z7 = z1117;
                    textStyle3 = textStyle2;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    brush2 = solidColor;
                    keyboardOptions3 = keyboardOptions16;
                    z8 = z1119;
                    modifier2 = companion;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i35 = i33;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final boolean z11110 = z4;
                final TextStyle textStyle8 = textStyle3;
                final KeyboardOptions keyboardOptions17 = keyboardOptions3;
                final KeyboardActions keyboardActions7 = keyboardActions2;
                final int i3119 = i35;
                final VisualTransformation visualTransformation8 = visualTransformation3;
                final Function1<? super TextLayoutResult, Unit> function13 = function4;
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                final Brush brush7 = brush2;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function14 = function3M688getLambda1$foundation_release;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                    public final void invoke(Composer composer2, int i40) {
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z11110, z7, textStyle8, keyboardOptions17, keyboardActions7, z8, i3119, visualTransformation8, function13, mutableInteractionSource8, brush7, function14, composer2, i2 | 1, i3, i4);
                    }
                });
            }
            i25 |= 384;
            if ((i3 & 7168) != 0) {
                i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
            }
            i28 = i4 & 16384;
            if (i28 != 0) {
                i25 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
            }
            i29 = i5;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                } else {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                }
                composerStartRestartGroup.endDefaults();
                i33 = i32;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValueM3663copy3r_uNRQ$default10 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value);
                boolean z11111 = z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue3;
                ImeOptions imeOptions$foundation_release10 = keyboardOptions2.toImeOptions$foundation_release(z6);
                boolean z11112 = !z6;
                if (z6) {
                    i34 = 1;
                } else {
                    i34 = i33;
                }
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                KeyboardOptions keyboardOptions18 = keyboardOptions2;
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                boolean z11113 = z6;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i31110 = i31 << 12;
                int i31111 = i29 >> 3;
                CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default10, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z11112, i34, imeOptions$foundation_release10, keyboardActions2, z4, z11111, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i31110 & 57344) | (i31110 & 458752) | (3670016 & i31110) | (i31110 & 29360128), (i31111 & 7168) | ((i29 >> 18) & 112) | (i31111 & 896) | (i31 & 57344), 0);
                z7 = z11111;
                textStyle3 = textStyle2;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                brush2 = solidColor;
                keyboardOptions3 = keyboardOptions18;
                z8 = z11113;
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                i35 = i33;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                } else {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                }
                composerStartRestartGroup.endDefaults();
                i33 = i32;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValueM3663copy3r_uNRQ$default11 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value);
                boolean z11114 = z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue3;
                ImeOptions imeOptions$foundation_release11 = keyboardOptions2.toImeOptions$foundation_release(z6);
                boolean z11115 = !z6;
                if (z6) {
                    i34 = 1;
                } else {
                    i34 = i33;
                }
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                KeyboardOptions keyboardOptions19 = keyboardOptions2;
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                boolean z11116 = z6;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i31112 = i31 << 12;
                int i31113 = i29 >> 3;
                CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default11, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z11115, i34, imeOptions$foundation_release11, keyboardActions2, z4, z11114, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i31112 & 57344) | (i31112 & 458752) | (3670016 & i31112) | (i31112 & 29360128), (i31113 & 7168) | ((i29 >> 18) & 112) | (i31113 & 896) | (i31 & 57344), 0);
                z7 = z11114;
                textStyle3 = textStyle2;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                brush2 = solidColor;
                keyboardOptions3 = keyboardOptions19;
                z8 = z11116;
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                i35 = i33;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final boolean z11117 = z4;
            final TextStyle textStyle9 = textStyle3;
            final KeyboardOptions keyboardOptions110 = keyboardOptions3;
            final KeyboardActions keyboardActions8 = keyboardActions2;
            final int i31114 = i35;
            final VisualTransformation visualTransformation9 = visualTransformation3;
            final Function1<? super TextLayoutResult, Unit> function15 = function4;
            final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
            final Brush brush8 = brush2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function16 = function3M688getLambda1$foundation_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                public final void invoke(Composer composer2, int i40) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z11117, z7, textStyle9, keyboardOptions110, keyboardActions8, z8, i31114, visualTransformation9, function15, mutableInteractionSource9, brush8, function16, composer2, i2 | 1, i3, i4);
                }
            });
        }
        i5 |= 3072;
        i8 = i4 & 16;
        if (i8 != 0) {
            i5 |= 24576;
        } else if ((i2 & 57344) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i5 |= i9;
        }
        i10 = i4 & 32;
        if (i10 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & 458752) == 0) {
            if (composerStartRestartGroup.changed(textStyle)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i5 |= i11;
        }
        i12 = i4 & 64;
        if (i12 != 0) {
            i5 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(keyboardOptions)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i5 |= i13;
        }
        i14 = i4 & 128;
        if (i14 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(keyboardActions)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i5 |= i15;
        }
        i16 = i4 & 256;
        if (i16 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i17 = 67108864;
            } else {
                i17 = 33554432;
            }
            i5 |= i17;
        }
        i18 = i4 & 512;
        if (i18 != 0) {
            i5 |= C.ENCODING_PCM_32BIT;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i19 = 536870912;
            } else {
                i19 = 268435456;
            }
            i5 |= i19;
        }
        i20 = i4 & 1024;
        if (i20 != 0) {
            i21 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i21 = i3 | i22;
        } else {
            i21 = i3;
        }
        i23 = i4 & 2048;
        if (i23 != 0) {
            i21 |= 48;
        } else if ((i3 & 112) == 0) {
            if (composerStartRestartGroup.changed(function1)) {
                i24 = 32;
            } else {
                i24 = 16;
            }
            i21 |= i24;
        }
        i25 = i21;
        i26 = i4 & 4096;
        if (i26 != 0) {
            if ((i3 & 896) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i27 = 256;
                } else {
                    i27 = 128;
                }
                i25 |= i27;
            }
            if ((i3 & 7168) != 0) {
                i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
            }
            i28 = i4 & 16384;
            if (i28 != 0) {
                i25 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
            }
            i29 = i5;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                } else {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                }
                composerStartRestartGroup.endDefaults();
                i33 = i32;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValueM3663copy3r_uNRQ$default12 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value);
                boolean z11118 = z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue3;
                ImeOptions imeOptions$foundation_release12 = keyboardOptions2.toImeOptions$foundation_release(z6);
                boolean z11119 = !z6;
                if (z6) {
                    i34 = 1;
                } else {
                    i34 = i33;
                }
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                KeyboardOptions keyboardOptions111 = keyboardOptions2;
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                boolean z111110 = z6;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i31115 = i31 << 12;
                int i31116 = i29 >> 3;
                CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default12, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z11119, i34, imeOptions$foundation_release12, keyboardActions2, z4, z11118, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i31115 & 57344) | (i31115 & 458752) | (3670016 & i31115) | (i31115 & 29360128), (i31116 & 7168) | ((i29 >> 18) & 112) | (i31116 & 896) | (i31 & 57344), 0);
                z7 = z11118;
                textStyle3 = textStyle2;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                brush2 = solidColor;
                keyboardOptions3 = keyboardOptions111;
                z8 = z111110;
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                i35 = i33;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                } else {
                    if (i36 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                    } else {
                        function3M688getLambda1$foundation_release = function3;
                    }
                    i31 = i25;
                    function2 = anonymousClass1;
                    visualTransformation2 = none;
                    i32 = i30;
                }
                composerStartRestartGroup.endDefaults();
                i33 = i32;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValueM3663copy3r_uNRQ$default13 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value);
                boolean z111111 = z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableState2 = (MutableState) objRememberedValue3;
                ImeOptions imeOptions$foundation_release13 = keyboardOptions2.toImeOptions$foundation_release(z6);
                boolean z111112 = !z6;
                if (z6) {
                    i34 = 1;
                } else {
                    i34 = i33;
                }
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                KeyboardOptions keyboardOptions112 = keyboardOptions2;
                zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
                boolean z111113 = z6;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            mutableState.setValue(newTextFieldValueState);
                            boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                            mutableState2.setValue(newTextFieldValueState.getText());
                            if (zAreEqual) {
                                return;
                            }
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i31117 = i31 << 12;
                int i31118 = i29 >> 3;
                CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default13, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z111112, i34, imeOptions$foundation_release13, keyboardActions2, z4, z111111, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i31117 & 57344) | (i31117 & 458752) | (3670016 & i31117) | (i31117 & 29360128), (i31118 & 7168) | ((i29 >> 18) & 112) | (i31118 & 896) | (i31 & 57344), 0);
                z7 = z111111;
                textStyle3 = textStyle2;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                brush2 = solidColor;
                keyboardOptions3 = keyboardOptions112;
                z8 = z111113;
                modifier2 = companion;
                mutableInteractionSource3 = mutableInteractionSource2;
                i35 = i33;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final boolean z111114 = z4;
            final TextStyle textStyle10 = textStyle3;
            final KeyboardOptions keyboardOptions113 = keyboardOptions3;
            final KeyboardActions keyboardActions9 = keyboardActions2;
            final int i31119 = i35;
            final VisualTransformation visualTransformation10 = visualTransformation3;
            final Function1<? super TextLayoutResult, Unit> function17 = function4;
            final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
            final Brush brush9 = brush2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function18 = function3M688getLambda1$foundation_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

                public final void invoke(Composer composer2, int i40) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z111114, z7, textStyle10, keyboardOptions113, keyboardActions9, z8, i31119, visualTransformation10, function17, mutableInteractionSource10, brush9, function18, composer2, i2 | 1, i3, i4);
                }
            });
        }
        i25 |= 384;
        if ((i3 & 7168) != 0) {
            i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
        }
        i28 = i4 & 16384;
        if (i28 != 0) {
            i25 |= 24576;
        } else if ((i3 & 57344) == 0) {
            i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
        }
        i29 = i5;
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i36 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                } else {
                    function3M688getLambda1$foundation_release = function3;
                }
                i31 = i25;
                function2 = anonymousClass1;
                visualTransformation2 = none;
                i32 = i30;
            } else {
                if (i36 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                } else {
                    function3M688getLambda1$foundation_release = function3;
                }
                i31 = i25;
                function2 = anonymousClass1;
                visualTransformation2 = none;
                i32 = i30;
            }
            composerStartRestartGroup.endDefaults();
            i33 = i32;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue2;
            TextFieldValue textFieldValueM3663copy3r_uNRQ$default14 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(value);
            boolean z111115 = z5;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) objRememberedValue3;
            ImeOptions imeOptions$foundation_release14 = keyboardOptions2.toImeOptions$foundation_release(z6);
            boolean z111116 = !z6;
            if (z6) {
                i34 = 1;
            } else {
                i34 = i33;
            }
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            KeyboardOptions keyboardOptions114 = keyboardOptions2;
            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
            boolean z111117 = z6;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                        mutableState.setValue(newTextFieldValueState);
                        boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                        mutableState2.setValue(newTextFieldValueState.getText());
                        if (zAreEqual) {
                            return;
                        }
                        onValueChange.invoke(newTextFieldValueState.getText());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                        mutableState.setValue(newTextFieldValueState);
                        boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                        mutableState2.setValue(newTextFieldValueState.getText());
                        if (zAreEqual) {
                            return;
                        }
                        onValueChange.invoke(newTextFieldValueState.getText());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i311110 = i31 << 12;
            int i311111 = i29 >> 3;
            CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default14, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z111116, i34, imeOptions$foundation_release14, keyboardActions2, z4, z111115, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i311110 & 57344) | (i311110 & 458752) | (3670016 & i311110) | (i311110 & 29360128), (i311111 & 7168) | ((i29 >> 18) & 112) | (i311111 & 896) | (i31 & 57344), 0);
            z7 = z111115;
            textStyle3 = textStyle2;
            visualTransformation3 = visualTransformation2;
            function4 = function2;
            brush2 = solidColor;
            keyboardOptions3 = keyboardOptions114;
            z8 = z111117;
            modifier2 = companion;
            mutableInteractionSource3 = mutableInteractionSource2;
            i35 = i33;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i36 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                } else {
                    function3M688getLambda1$foundation_release = function3;
                }
                i31 = i25;
                function2 = anonymousClass1;
                visualTransformation2 = none;
                i32 = i30;
            } else {
                if (i36 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M688getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m688getLambda1$foundation_release();
                } else {
                    function3M688getLambda1$foundation_release = function3;
                }
                i31 = i25;
                function2 = anonymousClass1;
                visualTransformation2 = none;
                i32 = i30;
            }
            composerStartRestartGroup.endDefaults();
            i33 = i32;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) objRememberedValue2;
            TextFieldValue textFieldValueM3663copy3r_uNRQ$default15 = TextFieldValue.m3663copy3r_uNRQ$default(m677BasicTextField$lambda2(mutableState), value, 0L, (TextRange) null, 6, (Object) null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(value);
            boolean z111118 = z5;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) objRememberedValue3;
            ImeOptions imeOptions$foundation_release15 = keyboardOptions2.toImeOptions$foundation_release(z6);
            boolean z111119 = !z6;
            if (z6) {
                i34 = 1;
            } else {
                i34 = i33;
            }
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            KeyboardOptions keyboardOptions115 = keyboardOptions2;
            zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(onValueChange);
            boolean z1111110 = z6;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                        mutableState.setValue(newTextFieldValueState);
                        boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                        mutableState2.setValue(newTextFieldValueState.getText());
                        if (zAreEqual) {
                            return;
                        }
                        onValueChange.invoke(newTextFieldValueState.getText());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                        mutableState.setValue(newTextFieldValueState);
                        boolean zAreEqual = Intrinsics.areEqual(BasicTextFieldKt.m679BasicTextField$lambda5(mutableState2), newTextFieldValueState.getText());
                        mutableState2.setValue(newTextFieldValueState.getText());
                        if (zAreEqual) {
                            return;
                        }
                        onValueChange.invoke(newTextFieldValueState.getText());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i311112 = i31 << 12;
            int i311113 = i29 >> 3;
            CoreTextFieldKt.CoreTextField(textFieldValueM3663copy3r_uNRQ$default15, (Function1) objRememberedValue4, companion, textStyle2, visualTransformation2, function2, mutableInteractionSource2, solidColor, z111119, i34, imeOptions$foundation_release15, keyboardActions2, z4, z111118, function3M688getLambda1$foundation_release, composerStartRestartGroup, (i29 & 896) | ((i29 >> 6) & 7168) | (i311112 & 57344) | (i311112 & 458752) | (3670016 & i311112) | (i311112 & 29360128), (i311113 & 7168) | ((i29 >> 18) & 112) | (i311113 & 896) | (i31 & 57344), 0);
            z7 = z111118;
            textStyle3 = textStyle2;
            visualTransformation3 = visualTransformation2;
            function4 = function2;
            brush2 = solidColor;
            keyboardOptions3 = keyboardOptions115;
            z8 = z1111110;
            modifier2 = companion;
            mutableInteractionSource3 = mutableInteractionSource2;
            i35 = i33;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final boolean z1111111 = z4;
        final TextStyle textStyle11 = textStyle3;
        final KeyboardOptions keyboardOptions116 = keyboardOptions3;
        final KeyboardActions keyboardActions10 = keyboardActions2;
        final int i311114 = i35;
        final VisualTransformation visualTransformation11 = visualTransformation3;
        final Function1<? super TextLayoutResult, Unit> function19 = function4;
        final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
        final Brush brush10 = brush2;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function110 = function3M688getLambda1$foundation_release;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.4
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

            public final void invoke(Composer composer2, int i40) {
                BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z1111111, z7, textStyle11, keyboardOptions116, keyboardActions10, z8, i311114, visualTransformation11, function19, mutableInteractionSource11, brush10, function110, composer2, i2 | 1, i3, i4);
            }
        });
    }

    /* JADX INFO: renamed from: BasicTextField$lambda-2, reason: not valid java name */
    private static final TextFieldValue m677BasicTextField$lambda2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BasicTextField$lambda-5, reason: not valid java name */
    public static final String m679BasicTextField$lambda5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0144  */
    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:103:0x014d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:108:0x015a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0160  */
    /* JADX WARN: Code duplicated, block: B:112:0x0166  */
    /* JADX WARN: Code duplicated, block: B:113:0x0169  */
    /* JADX WARN: Code duplicated, block: B:115:0x016e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0174  */
    /* JADX WARN: Code duplicated, block: B:119:0x0177  */
    /* JADX WARN: Code duplicated, block: B:121:0x017d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0183  */
    /* JADX WARN: Code duplicated, block: B:124:0x0186  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:131:0x0197  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:166:0x0219  */
    /* JADX WARN: Code duplicated, block: B:168:0x0220  */
    /* JADX WARN: Code duplicated, block: B:175:0x024c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x024e  */
    /* JADX WARN: Code duplicated, block: B:177:0x0253  */
    /* JADX WARN: Code duplicated, block: B:179:0x0257  */
    /* JADX WARN: Code duplicated, block: B:180:0x0259  */
    /* JADX WARN: Code duplicated, block: B:182:0x025d  */
    /* JADX WARN: Code duplicated, block: B:183:0x025f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0263  */
    /* JADX WARN: Code duplicated, block: B:186:0x026a  */
    /* JADX WARN: Code duplicated, block: B:188:0x026e  */
    /* JADX WARN: Code duplicated, block: B:189:0x0275  */
    /* JADX WARN: Code duplicated, block: B:191:0x0279  */
    /* JADX WARN: Code duplicated, block: B:192:0x0280  */
    /* JADX WARN: Code duplicated, block: B:194:0x0284  */
    /* JADX WARN: Code duplicated, block: B:195:0x0286  */
    /* JADX WARN: Code duplicated, block: B:197:0x028a  */
    /* JADX WARN: Code duplicated, block: B:198:0x028e  */
    /* JADX WARN: Code duplicated, block: B:200:0x0292  */
    /* JADX WARN: Code duplicated, block: B:201:0x0299  */
    /* JADX WARN: Code duplicated, block: B:203:0x029d  */
    /* JADX WARN: Code duplicated, block: B:204:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:206:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:208:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:210:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:213:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:214:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:216:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:217:0x0304  */
    /* JADX WARN: Code duplicated, block: B:221:0x0329  */
    /* JADX WARN: Code duplicated, block: B:222:0x032b  */
    /* JADX WARN: Code duplicated, block: B:225:0x0349  */
    /* JADX WARN: Code duplicated, block: B:227:0x0351  */
    /* JADX WARN: Code duplicated, block: B:232:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x0099  */
    /* JADX WARN: Code duplicated, block: B:48:0x009e  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00be  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:80:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0115  */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013c  */
    public static final void BasicTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function1, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
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
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Modifier.Companion companion;
        boolean z4;
        boolean z5;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean z6;
        int i30;
        VisualTransformation none;
        AnonymousClass5 anonymousClass5;
        MutableInteractionSource mutableInteractionSource2;
        SolidColor solidColor;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M689getLambda2$foundation_release;
        boolean z7;
        VisualTransformation visualTransformation2;
        Function1<? super TextLayoutResult, Unit> function2;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z8;
        TextStyle textStyle3;
        KeyboardOptions keyboardOptions3;
        Object objRememberedValue;
        int i31;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composer2;
        final boolean z9;
        final Modifier modifier2;
        final boolean z10;
        final boolean z11;
        final KeyboardOptions keyboardOptions4;
        final TextStyle textStyle4;
        final KeyboardActions keyboardActions4;
        final int i32;
        final VisualTransformation visualTransformation3;
        final Function1<? super TextLayoutResult, Unit> function4;
        final MutableInteractionSource mutableInteractionSource4;
        final Brush brush2;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)269@15694L39,276@15996L90,274@15934L688:BasicTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onValueChange) ? 32 : 16;
        }
        int i33 = i4 & 4;
        if (i33 == 0) {
            if ((i2 & 896) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 16;
                if (i8 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(textStyle)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(keyboardOptions)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 128;
                if (i14 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(keyboardActions)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i5 |= i15;
                }
                i16 = i4 & 256;
                if (i16 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i5 |= i17;
                }
                i18 = i4 & 512;
                if (i18 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i19 = 536870912;
                    } else {
                        i19 = 268435456;
                    }
                    i5 |= i19;
                }
                i20 = i4 & 1024;
                if (i20 != 0) {
                    i21 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i21 = i3 | i22;
                } else {
                    i21 = i3;
                }
                i23 = i4 & 2048;
                if (i23 != 0) {
                    i21 |= 48;
                } else if ((i3 & 112) == 0) {
                    if (composerStartRestartGroup.changed(function1)) {
                        i24 = 32;
                    } else {
                        i24 = 16;
                    }
                    i21 |= i24;
                }
                i25 = i21;
                i26 = i4 & 4096;
                if (i26 != 0) {
                    if ((i3 & 896) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i27 = 256;
                        } else {
                            i27 = 128;
                        }
                        i25 |= i27;
                    }
                    if ((i3 & 7168) != 0) {
                        i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                    }
                    i28 = i4 & 16384;
                    if (i28 != 0) {
                        i25 |= 24576;
                    } else if ((i3 & 57344) == 0) {
                        i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                    }
                    i29 = i5;
                    if ((i5 & 1533916891) == 306783378 || (46811 & i25) != 9362 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i33 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i8 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i10 != 0) {
                                textStyle2 = TextStyle.INSTANCE.getDefault();
                            } else {
                                textStyle2 = textStyle;
                            }
                            if (i12 != 0) {
                                keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                            } else {
                                keyboardOptions2 = keyboardOptions;
                            }
                            if (i14 != 0) {
                                keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i16 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (i18 != 0) {
                                i30 = Integer.MAX_VALUE;
                            } else {
                                i30 = i;
                            }
                            if (i20 != 0) {
                                none = VisualTransformation.INSTANCE.getNone();
                            } else {
                                none = visualTransformation;
                            }
                            if (i23 != 0) {
                                anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                anonymousClass5 = function1;
                            }
                            if (i26 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i4 & 8192) != 0) {
                                solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                                i25 &= -7169;
                            } else {
                                solidColor = brush;
                            }
                            if (i28 != 0) {
                                function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                            } else {
                                function3M689getLambda2$foundation_release = function3;
                            }
                            z7 = z4;
                            visualTransformation2 = none;
                            function2 = anonymousClass5;
                            keyboardActions3 = keyboardActions2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            z8 = z5;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 8192) != 0) {
                                i25 &= -7169;
                            }
                            companion = modifier;
                            z7 = z;
                            z8 = z2;
                            textStyle3 = textStyle;
                            keyboardOptions3 = keyboardOptions;
                            keyboardActions3 = keyboardActions;
                            z6 = z3;
                            i30 = i;
                            visualTransformation2 = visualTransformation;
                            function2 = function1;
                            mutableInteractionSource3 = mutableInteractionSource;
                            solidColor = brush;
                            function3M689getLambda2$foundation_release = function3;
                        }
                        composerStartRestartGroup.endDefaults();
                        ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z6);
                        boolean z12 = !z6;
                        if (z6) {
                            i31 = 1;
                        } else {
                            i31 = i30;
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (Intrinsics.areEqual(value, it)) {
                                        return;
                                    }
                                    onValueChange.invoke(it);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i34 = i25 << 12;
                        int i35 = i29 >> 3;
                        composer2 = composerStartRestartGroup;
                        CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z12, i31, imeOptions$foundation_release, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i34 & 57344) | (i34 & 458752) | (i34 & 3670016) | (i34 & 29360128), (i35 & 7168) | ((i29 >> 18) & 112) | (i35 & 896) | (i25 & 57344), 0);
                        z9 = z6;
                        modifier2 = companion;
                        z10 = z7;
                        z11 = z8;
                        keyboardOptions4 = keyboardOptions3;
                        textStyle4 = textStyle3;
                        keyboardActions4 = keyboardActions3;
                        i32 = i30;
                        visualTransformation3 = visualTransformation2;
                        function4 = function2;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        brush2 = solidColor;
                        function5 = function3M689getLambda2$foundation_release;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z10 = z;
                        z11 = z2;
                        textStyle4 = textStyle;
                        keyboardOptions4 = keyboardOptions;
                        keyboardActions4 = keyboardActions;
                        z9 = z3;
                        visualTransformation3 = visualTransformation;
                        function4 = function1;
                        mutableInteractionSource4 = mutableInteractionSource;
                        brush2 = brush;
                        function5 = function3;
                        composer2 = composerStartRestartGroup;
                        i32 = i;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                        public final void invoke(Composer composer3, int i36) {
                            BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                        }
                    });
                }
                i25 |= 384;
                if ((i3 & 7168) != 0) {
                    i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                }
                i28 = i4 & 16384;
                if (i28 != 0) {
                    i25 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                }
                i29 = i5;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    } else {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ImeOptions imeOptions$foundation_release2 = keyboardOptions3.toImeOptions$foundation_release(z6);
                    boolean z13 = !z6;
                    if (z6) {
                        i31 = 1;
                    } else {
                        i31 = i30;
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i36 = i25 << 12;
                    int i37 = i29 >> 3;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z13, i31, imeOptions$foundation_release2, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i36 & 57344) | (i36 & 458752) | (i36 & 3670016) | (i36 & 29360128), (i37 & 7168) | ((i29 >> 18) & 112) | (i37 & 896) | (i25 & 57344), 0);
                    z9 = z6;
                    modifier2 = companion;
                    z10 = z7;
                    z11 = z8;
                    keyboardOptions4 = keyboardOptions3;
                    textStyle4 = textStyle3;
                    keyboardActions4 = keyboardActions3;
                    i32 = i30;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    brush2 = solidColor;
                    function5 = function3M689getLambda2$foundation_release;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    } else {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ImeOptions imeOptions$foundation_release3 = keyboardOptions3.toImeOptions$foundation_release(z6);
                    boolean z14 = !z6;
                    if (z6) {
                        i31 = 1;
                    } else {
                        i31 = i30;
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i38 = i25 << 12;
                    int i39 = i29 >> 3;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z14, i31, imeOptions$foundation_release3, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i38 & 57344) | (i38 & 458752) | (i38 & 3670016) | (i38 & 29360128), (i39 & 7168) | ((i29 >> 18) & 112) | (i39 & 896) | (i25 & 57344), 0);
                    z9 = z6;
                    modifier2 = companion;
                    z10 = z7;
                    z11 = z8;
                    keyboardOptions4 = keyboardOptions3;
                    textStyle4 = textStyle3;
                    keyboardActions4 = keyboardActions3;
                    i32 = i30;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    brush2 = solidColor;
                    function5 = function3M689getLambda2$foundation_release;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                    public final void invoke(Composer composer3, int i310) {
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                    }
                });
            }
            i5 |= 3072;
            i8 = i4 & 16;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(textStyle)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(keyboardOptions)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i5 |= i13;
            }
            i14 = i4 & 128;
            if (i14 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i5 |= i15;
            }
            i16 = i4 & 256;
            if (i16 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i5 |= i17;
            }
            i18 = i4 & 512;
            if (i18 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i19 = 536870912;
                } else {
                    i19 = 268435456;
                }
                i5 |= i19;
            }
            i20 = i4 & 1024;
            if (i20 != 0) {
                i21 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i3 | i22;
            } else {
                i21 = i3;
            }
            i23 = i4 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            i26 = i4 & 4096;
            if (i26 != 0) {
                if ((i3 & 896) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i27 = 256;
                    } else {
                        i27 = 128;
                    }
                    i25 |= i27;
                }
                if ((i3 & 7168) != 0) {
                    i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                }
                i28 = i4 & 16384;
                if (i28 != 0) {
                    i25 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                }
                i29 = i5;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    } else {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ImeOptions imeOptions$foundation_release4 = keyboardOptions3.toImeOptions$foundation_release(z6);
                    boolean z15 = !z6;
                    if (z6) {
                        i31 = 1;
                    } else {
                        i31 = i30;
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i310 = i25 << 12;
                    int i311 = i29 >> 3;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z15, i31, imeOptions$foundation_release4, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i310 & 57344) | (i310 & 458752) | (i310 & 3670016) | (i310 & 29360128), (i311 & 7168) | ((i29 >> 18) & 112) | (i311 & 896) | (i25 & 57344), 0);
                    z9 = z6;
                    modifier2 = companion;
                    z10 = z7;
                    z11 = z8;
                    keyboardOptions4 = keyboardOptions3;
                    textStyle4 = textStyle3;
                    keyboardActions4 = keyboardActions3;
                    i32 = i30;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    brush2 = solidColor;
                    function5 = function3M689getLambda2$foundation_release;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    } else {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ImeOptions imeOptions$foundation_release5 = keyboardOptions3.toImeOptions$foundation_release(z6);
                    boolean z16 = !z6;
                    if (z6) {
                        i31 = 1;
                    } else {
                        i31 = i30;
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i312 = i25 << 12;
                    int i313 = i29 >> 3;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z16, i31, imeOptions$foundation_release5, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i312 & 57344) | (i312 & 458752) | (i312 & 3670016) | (i312 & 29360128), (i313 & 7168) | ((i29 >> 18) & 112) | (i313 & 896) | (i25 & 57344), 0);
                    z9 = z6;
                    modifier2 = companion;
                    z10 = z7;
                    z11 = z8;
                    keyboardOptions4 = keyboardOptions3;
                    textStyle4 = textStyle3;
                    keyboardActions4 = keyboardActions3;
                    i32 = i30;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    brush2 = solidColor;
                    function5 = function3M689getLambda2$foundation_release;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                    public final void invoke(Composer composer3, int i314) {
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                    }
                });
            }
            i25 |= 384;
            if ((i3 & 7168) != 0) {
                i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
            }
            i28 = i4 & 16384;
            if (i28 != 0) {
                i25 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
            }
            i29 = i5;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                } else {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                }
                composerStartRestartGroup.endDefaults();
                ImeOptions imeOptions$foundation_release6 = keyboardOptions3.toImeOptions$foundation_release(z6);
                boolean z17 = !z6;
                if (z6) {
                    i31 = 1;
                } else {
                    i31 = i30;
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i314 = i25 << 12;
                int i315 = i29 >> 3;
                composer2 = composerStartRestartGroup;
                CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z17, i31, imeOptions$foundation_release6, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i314 & 57344) | (i314 & 458752) | (i314 & 3670016) | (i314 & 29360128), (i315 & 7168) | ((i29 >> 18) & 112) | (i315 & 896) | (i25 & 57344), 0);
                z9 = z6;
                modifier2 = companion;
                z10 = z7;
                z11 = z8;
                keyboardOptions4 = keyboardOptions3;
                textStyle4 = textStyle3;
                keyboardActions4 = keyboardActions3;
                i32 = i30;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                mutableInteractionSource4 = mutableInteractionSource3;
                brush2 = solidColor;
                function5 = function3M689getLambda2$foundation_release;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                } else {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                }
                composerStartRestartGroup.endDefaults();
                ImeOptions imeOptions$foundation_release7 = keyboardOptions3.toImeOptions$foundation_release(z6);
                boolean z18 = !z6;
                if (z6) {
                    i31 = 1;
                } else {
                    i31 = i30;
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i316 = i25 << 12;
                int i317 = i29 >> 3;
                composer2 = composerStartRestartGroup;
                CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z18, i31, imeOptions$foundation_release7, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i316 & 57344) | (i316 & 458752) | (i316 & 3670016) | (i316 & 29360128), (i317 & 7168) | ((i29 >> 18) & 112) | (i317 & 896) | (i25 & 57344), 0);
                z9 = z6;
                modifier2 = companion;
                z10 = z7;
                z11 = z8;
                keyboardOptions4 = keyboardOptions3;
                textStyle4 = textStyle3;
                keyboardActions4 = keyboardActions3;
                i32 = i30;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                mutableInteractionSource4 = mutableInteractionSource3;
                brush2 = solidColor;
                function5 = function3M689getLambda2$foundation_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                public final void invoke(Composer composer3, int i318) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                }
            });
        }
        i5 |= 384;
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i2 & 7168) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i5 |= i7;
            }
            i8 = i4 & 16;
            if (i8 != 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changed(textStyle)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(keyboardOptions)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i5 |= i13;
            }
            i14 = i4 & 128;
            if (i14 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i5 |= i15;
            }
            i16 = i4 & 256;
            if (i16 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i5 |= i17;
            }
            i18 = i4 & 512;
            if (i18 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i19 = 536870912;
                } else {
                    i19 = 268435456;
                }
                i5 |= i19;
            }
            i20 = i4 & 1024;
            if (i20 != 0) {
                i21 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i21 = i3 | i22;
            } else {
                i21 = i3;
            }
            i23 = i4 & 2048;
            if (i23 != 0) {
                i21 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i24 = 32;
                } else {
                    i24 = 16;
                }
                i21 |= i24;
            }
            i25 = i21;
            i26 = i4 & 4096;
            if (i26 != 0) {
                if ((i3 & 896) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i27 = 256;
                    } else {
                        i27 = 128;
                    }
                    i25 |= i27;
                }
                if ((i3 & 7168) != 0) {
                    i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
                }
                i28 = i4 & 16384;
                if (i28 != 0) {
                    i25 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
                }
                i29 = i5;
                if ((i5 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    } else {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ImeOptions imeOptions$foundation_release8 = keyboardOptions3.toImeOptions$foundation_release(z6);
                    boolean z19 = !z6;
                    if (z6) {
                        i31 = 1;
                    } else {
                        i31 = i30;
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i318 = i25 << 12;
                    int i319 = i29 >> 3;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z19, i31, imeOptions$foundation_release8, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i318 & 57344) | (i318 & 458752) | (i318 & 3670016) | (i318 & 29360128), (i319 & 7168) | ((i29 >> 18) & 112) | (i319 & 896) | (i25 & 57344), 0);
                    z9 = z6;
                    modifier2 = companion;
                    z10 = z7;
                    z11 = z8;
                    keyboardOptions4 = keyboardOptions3;
                    textStyle4 = textStyle3;
                    keyboardActions4 = keyboardActions3;
                    i32 = i30;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    brush2 = solidColor;
                    function5 = function3M689getLambda2$foundation_release;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    } else {
                        if (i33 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            textStyle2 = TextStyle.INSTANCE.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i12 != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        if (i14 != 0) {
                            keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i16 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i18 != 0) {
                            i30 = Integer.MAX_VALUE;
                        } else {
                            i30 = i;
                        }
                        if (i20 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i23 != 0) {
                            anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass5 = function1;
                        }
                        if (i26 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if ((i4 & 8192) != 0) {
                            solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                            i25 &= -7169;
                        } else {
                            solidColor = brush;
                        }
                        if (i28 != 0) {
                            function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                        } else {
                            function3M689getLambda2$foundation_release = function3;
                        }
                        z7 = z4;
                        visualTransformation2 = none;
                        function2 = anonymousClass5;
                        keyboardActions3 = keyboardActions2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z8 = z5;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                    }
                    composerStartRestartGroup.endDefaults();
                    ImeOptions imeOptions$foundation_release9 = keyboardOptions3.toImeOptions$foundation_release(z6);
                    boolean z110 = !z6;
                    if (z6) {
                        i31 = 1;
                    } else {
                        i31 = i30;
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (Intrinsics.areEqual(value, it)) {
                                    return;
                                }
                                onValueChange.invoke(it);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i3110 = i25 << 12;
                    int i3111 = i29 >> 3;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z110, i31, imeOptions$foundation_release9, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i3110 & 57344) | (i3110 & 458752) | (i3110 & 3670016) | (i3110 & 29360128), (i3111 & 7168) | ((i29 >> 18) & 112) | (i3111 & 896) | (i25 & 57344), 0);
                    z9 = z6;
                    modifier2 = companion;
                    z10 = z7;
                    z11 = z8;
                    keyboardOptions4 = keyboardOptions3;
                    textStyle4 = textStyle3;
                    keyboardActions4 = keyboardActions3;
                    i32 = i30;
                    visualTransformation3 = visualTransformation2;
                    function4 = function2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    brush2 = solidColor;
                    function5 = function3M689getLambda2$foundation_release;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                    public final void invoke(Composer composer3, int i3112) {
                        BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                    }
                });
            }
            i25 |= 384;
            if ((i3 & 7168) != 0) {
                i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
            }
            i28 = i4 & 16384;
            if (i28 != 0) {
                i25 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
            }
            i29 = i5;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                } else {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                }
                composerStartRestartGroup.endDefaults();
                ImeOptions imeOptions$foundation_release10 = keyboardOptions3.toImeOptions$foundation_release(z6);
                boolean z111 = !z6;
                if (z6) {
                    i31 = 1;
                } else {
                    i31 = i30;
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3112 = i25 << 12;
                int i3113 = i29 >> 3;
                composer2 = composerStartRestartGroup;
                CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z111, i31, imeOptions$foundation_release10, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i3112 & 57344) | (i3112 & 458752) | (i3112 & 3670016) | (i3112 & 29360128), (i3113 & 7168) | ((i29 >> 18) & 112) | (i3113 & 896) | (i25 & 57344), 0);
                z9 = z6;
                modifier2 = companion;
                z10 = z7;
                z11 = z8;
                keyboardOptions4 = keyboardOptions3;
                textStyle4 = textStyle3;
                keyboardActions4 = keyboardActions3;
                i32 = i30;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                mutableInteractionSource4 = mutableInteractionSource3;
                brush2 = solidColor;
                function5 = function3M689getLambda2$foundation_release;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                } else {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                }
                composerStartRestartGroup.endDefaults();
                ImeOptions imeOptions$foundation_release11 = keyboardOptions3.toImeOptions$foundation_release(z6);
                boolean z112 = !z6;
                if (z6) {
                    i31 = 1;
                } else {
                    i31 = i30;
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3114 = i25 << 12;
                int i3115 = i29 >> 3;
                composer2 = composerStartRestartGroup;
                CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z112, i31, imeOptions$foundation_release11, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i3114 & 57344) | (i3114 & 458752) | (i3114 & 3670016) | (i3114 & 29360128), (i3115 & 7168) | ((i29 >> 18) & 112) | (i3115 & 896) | (i25 & 57344), 0);
                z9 = z6;
                modifier2 = companion;
                z10 = z7;
                z11 = z8;
                keyboardOptions4 = keyboardOptions3;
                textStyle4 = textStyle3;
                keyboardActions4 = keyboardActions3;
                i32 = i30;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                mutableInteractionSource4 = mutableInteractionSource3;
                brush2 = solidColor;
                function5 = function3M689getLambda2$foundation_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                public final void invoke(Composer composer3, int i3116) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                }
            });
        }
        i5 |= 3072;
        i8 = i4 & 16;
        if (i8 != 0) {
            i5 |= 24576;
        } else if ((i2 & 57344) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i5 |= i9;
        }
        i10 = i4 & 32;
        if (i10 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & 458752) == 0) {
            if (composerStartRestartGroup.changed(textStyle)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i5 |= i11;
        }
        i12 = i4 & 64;
        if (i12 != 0) {
            i5 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(keyboardOptions)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i5 |= i13;
        }
        i14 = i4 & 128;
        if (i14 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(keyboardActions)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i5 |= i15;
        }
        i16 = i4 & 256;
        if (i16 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i17 = 67108864;
            } else {
                i17 = 33554432;
            }
            i5 |= i17;
        }
        i18 = i4 & 512;
        if (i18 != 0) {
            i5 |= C.ENCODING_PCM_32BIT;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i19 = 536870912;
            } else {
                i19 = 268435456;
            }
            i5 |= i19;
        }
        i20 = i4 & 1024;
        if (i20 != 0) {
            i21 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i21 = i3 | i22;
        } else {
            i21 = i3;
        }
        i23 = i4 & 2048;
        if (i23 != 0) {
            i21 |= 48;
        } else if ((i3 & 112) == 0) {
            if (composerStartRestartGroup.changed(function1)) {
                i24 = 32;
            } else {
                i24 = 16;
            }
            i21 |= i24;
        }
        i25 = i21;
        i26 = i4 & 4096;
        if (i26 != 0) {
            if ((i3 & 896) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i27 = 256;
                } else {
                    i27 = 128;
                }
                i25 |= i27;
            }
            if ((i3 & 7168) != 0) {
                i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
            }
            i28 = i4 & 16384;
            if (i28 != 0) {
                i25 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
            }
            i29 = i5;
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                } else {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                }
                composerStartRestartGroup.endDefaults();
                ImeOptions imeOptions$foundation_release12 = keyboardOptions3.toImeOptions$foundation_release(z6);
                boolean z113 = !z6;
                if (z6) {
                    i31 = 1;
                } else {
                    i31 = i30;
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3116 = i25 << 12;
                int i3117 = i29 >> 3;
                composer2 = composerStartRestartGroup;
                CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z113, i31, imeOptions$foundation_release12, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i3116 & 57344) | (i3116 & 458752) | (i3116 & 3670016) | (i3116 & 29360128), (i3117 & 7168) | ((i29 >> 18) & 112) | (i3117 & 896) | (i25 & 57344), 0);
                z9 = z6;
                modifier2 = companion;
                z10 = z7;
                z11 = z8;
                keyboardOptions4 = keyboardOptions3;
                textStyle4 = textStyle3;
                keyboardActions4 = keyboardActions3;
                i32 = i30;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                mutableInteractionSource4 = mutableInteractionSource3;
                brush2 = solidColor;
                function5 = function3M689getLambda2$foundation_release;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                } else {
                    if (i33 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        textStyle2 = TextStyle.INSTANCE.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i12 != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    if (i14 != 0) {
                        keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i16 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i18 != 0) {
                        i30 = Integer.MAX_VALUE;
                    } else {
                        i30 = i;
                    }
                    if (i20 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i23 != 0) {
                        anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass5 = function1;
                    }
                    if (i26 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if ((i4 & 8192) != 0) {
                        solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                        i25 &= -7169;
                    } else {
                        solidColor = brush;
                    }
                    if (i28 != 0) {
                        function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                    } else {
                        function3M689getLambda2$foundation_release = function3;
                    }
                    z7 = z4;
                    visualTransformation2 = none;
                    function2 = anonymousClass5;
                    keyboardActions3 = keyboardActions2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                }
                composerStartRestartGroup.endDefaults();
                ImeOptions imeOptions$foundation_release13 = keyboardOptions3.toImeOptions$foundation_release(z6);
                boolean z114 = !z6;
                if (z6) {
                    i31 = 1;
                } else {
                    i31 = i30;
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (Intrinsics.areEqual(value, it)) {
                                return;
                            }
                            onValueChange.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3118 = i25 << 12;
                int i3119 = i29 >> 3;
                composer2 = composerStartRestartGroup;
                CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z114, i31, imeOptions$foundation_release13, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i3118 & 57344) | (i3118 & 458752) | (i3118 & 3670016) | (i3118 & 29360128), (i3119 & 7168) | ((i29 >> 18) & 112) | (i3119 & 896) | (i25 & 57344), 0);
                z9 = z6;
                modifier2 = companion;
                z10 = z7;
                z11 = z8;
                keyboardOptions4 = keyboardOptions3;
                textStyle4 = textStyle3;
                keyboardActions4 = keyboardActions3;
                i32 = i30;
                visualTransformation3 = visualTransformation2;
                function4 = function2;
                mutableInteractionSource4 = mutableInteractionSource3;
                brush2 = solidColor;
                function5 = function3M689getLambda2$foundation_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

                public final void invoke(Composer composer3, int i31110) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
                }
            });
        }
        i25 |= 384;
        if ((i3 & 7168) != 0) {
            i25 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(brush)) ? 1024 : 2048;
        }
        i28 = i4 & 16384;
        if (i28 != 0) {
            i25 |= 24576;
        } else if ((i3 & 57344) == 0) {
            i25 |= composerStartRestartGroup.changed(function3) ? 16384 : 8192;
        }
        i29 = i5;
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i33 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass5 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                } else {
                    function3M689getLambda2$foundation_release = function3;
                }
                z7 = z4;
                visualTransformation2 = none;
                function2 = anonymousClass5;
                keyboardActions3 = keyboardActions2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z8 = z5;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
            } else {
                if (i33 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass5 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                } else {
                    function3M689getLambda2$foundation_release = function3;
                }
                z7 = z4;
                visualTransformation2 = none;
                function2 = anonymousClass5;
                keyboardActions3 = keyboardActions2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z8 = z5;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
            }
            composerStartRestartGroup.endDefaults();
            ImeOptions imeOptions$foundation_release14 = keyboardOptions3.toImeOptions$foundation_release(z6);
            boolean z115 = !z6;
            if (z6) {
                i31 = 1;
            } else {
                i31 = i30;
            }
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (Intrinsics.areEqual(value, it)) {
                            return;
                        }
                        onValueChange.invoke(it);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (Intrinsics.areEqual(value, it)) {
                            return;
                        }
                        onValueChange.invoke(it);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i31110 = i25 << 12;
            int i31111 = i29 >> 3;
            composer2 = composerStartRestartGroup;
            CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z115, i31, imeOptions$foundation_release14, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i31110 & 57344) | (i31110 & 458752) | (i31110 & 3670016) | (i31110 & 29360128), (i31111 & 7168) | ((i29 >> 18) & 112) | (i31111 & 896) | (i25 & 57344), 0);
            z9 = z6;
            modifier2 = companion;
            z10 = z7;
            z11 = z8;
            keyboardOptions4 = keyboardOptions3;
            textStyle4 = textStyle3;
            keyboardActions4 = keyboardActions3;
            i32 = i30;
            visualTransformation3 = visualTransformation2;
            function4 = function2;
            mutableInteractionSource4 = mutableInteractionSource3;
            brush2 = solidColor;
            function5 = function3M689getLambda2$foundation_release;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i33 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass5 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                } else {
                    function3M689getLambda2$foundation_release = function3;
                }
                z7 = z4;
                visualTransformation2 = none;
                function2 = anonymousClass5;
                keyboardActions3 = keyboardActions2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z8 = z5;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
            } else {
                if (i33 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    textStyle2 = TextStyle.INSTANCE.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i12 != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i14 != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i16 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i18 != 0) {
                    i30 = Integer.MAX_VALUE;
                } else {
                    i30 = i;
                }
                if (i20 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i23 != 0) {
                    anonymousClass5 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass5 = function1;
                }
                if (i26 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if ((i4 & 8192) != 0) {
                    solidColor = new SolidColor(Color.INSTANCE.m1657getBlack0d7_KjU(), null);
                    i25 &= -7169;
                } else {
                    solidColor = brush;
                }
                if (i28 != 0) {
                    function3M689getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m689getLambda2$foundation_release();
                } else {
                    function3M689getLambda2$foundation_release = function3;
                }
                z7 = z4;
                visualTransformation2 = none;
                function2 = anonymousClass5;
                keyboardActions3 = keyboardActions2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z8 = z5;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
            }
            composerStartRestartGroup.endDefaults();
            ImeOptions imeOptions$foundation_release15 = keyboardOptions3.toImeOptions$foundation_release(z6);
            boolean z116 = !z6;
            if (z6) {
                i31 = 1;
            } else {
                i31 = i30;
            }
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(onValueChange);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (Intrinsics.areEqual(value, it)) {
                            return;
                        }
                        onValueChange.invoke(it);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (Intrinsics.areEqual(value, it)) {
                            return;
                        }
                        onValueChange.invoke(it);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i31112 = i25 << 12;
            int i31113 = i29 >> 3;
            composer2 = composerStartRestartGroup;
            CoreTextFieldKt.CoreTextField(value, (Function1) objRememberedValue2, companion, textStyle3, visualTransformation2, function2, mutableInteractionSource3, solidColor, z116, i31, imeOptions$foundation_release15, keyboardActions3, z7, z8, function3M689getLambda2$foundation_release, composer2, (i29 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | ((i29 >> 6) & 7168) | (i31112 & 57344) | (i31112 & 458752) | (i31112 & 3670016) | (i31112 & 29360128), (i31113 & 7168) | ((i29 >> 18) & 112) | (i31113 & 896) | (i25 & 57344), 0);
            z9 = z6;
            modifier2 = companion;
            z10 = z7;
            z11 = z8;
            keyboardOptions4 = keyboardOptions3;
            textStyle4 = textStyle3;
            keyboardActions4 = keyboardActions3;
            i32 = i30;
            visualTransformation3 = visualTransformation2;
            function4 = function2;
            mutableInteractionSource4 = mutableInteractionSource3;
            brush2 = solidColor;
            function5 = function3M689getLambda2$foundation_release;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.8
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

            public final void invoke(Composer composer3, int i31114) {
                BasicTextFieldKt.BasicTextField(value, onValueChange, modifier2, z10, z11, textStyle4, keyboardOptions4, keyboardActions4, z9, i32, visualTransformation3, function4, mutableInteractionSource4, brush2, function5, composer3, i2 | 1, i3, i4);
            }
        });
    }
}
