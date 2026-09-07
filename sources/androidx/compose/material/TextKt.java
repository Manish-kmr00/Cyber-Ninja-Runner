package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TextStyle.INSTANCE.getDefault();
        }
    });

    /* JADX WARN: Code duplicated, block: B:101:0x0145  */
    /* JADX WARN: Code duplicated, block: B:102:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x0150  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:109:0x015b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0161  */
    /* JADX WARN: Code duplicated, block: B:112:0x0164  */
    /* JADX WARN: Code duplicated, block: B:114:0x0169  */
    /* JADX WARN: Code duplicated, block: B:117:0x016f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0174  */
    /* JADX WARN: Code duplicated, block: B:120:0x017a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0180  */
    /* JADX WARN: Code duplicated, block: B:123:0x0183  */
    /* JADX WARN: Code duplicated, block: B:127:0x018d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:130:0x0194  */
    /* JADX WARN: Code duplicated, block: B:132:0x019c  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f  */
    /* JADX WARN: Code duplicated, block: B:138:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:152:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:162:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:165:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:167:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:170:0x0207  */
    /* JADX WARN: Code duplicated, block: B:176:0x023a  */
    /* JADX WARN: Code duplicated, block: B:178:0x0246  */
    /* JADX WARN: Code duplicated, block: B:185:0x027a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:186:0x027c  */
    /* JADX WARN: Code duplicated, block: B:187:0x0281  */
    /* JADX WARN: Code duplicated, block: B:189:0x0285  */
    /* JADX WARN: Code duplicated, block: B:190:0x028c  */
    /* JADX WARN: Code duplicated, block: B:192:0x0290  */
    /* JADX WARN: Code duplicated, block: B:193:0x0297  */
    /* JADX WARN: Code duplicated, block: B:196:0x029c  */
    /* JADX WARN: Code duplicated, block: B:197:0x029e  */
    /* JADX WARN: Code duplicated, block: B:199:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:200:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:202:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:203:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:205:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:206:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:208:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:209:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:212:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:214:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:215:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:217:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:218:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:220:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:221:0x02de  */
    /* JADX WARN: Code duplicated, block: B:223:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:224:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:226:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:227:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:230:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:231:0x0317  */
    /* JADX WARN: Code duplicated, block: B:235:0x033c  */
    /* JADX WARN: Code duplicated, block: B:236:0x033f  */
    /* JADX WARN: Code duplicated, block: B:239:0x034e  */
    /* JADX WARN: Code duplicated, block: B:245:0x0420  */
    /* JADX WARN: Code duplicated, block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x009a  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:79:0x0100  */
    /* JADX WARN: Code duplicated, block: B:81:0x0106  */
    /* JADX WARN: Code duplicated, block: B:82:0x0109  */
    /* JADX WARN: Code duplicated, block: B:86:0x0111  */
    /* JADX WARN: Code duplicated, block: B:87:0x0118  */
    /* JADX WARN: Code duplicated, block: B:89:0x0120  */
    /* JADX WARN: Code duplicated, block: B:91:0x0126  */
    /* JADX WARN: Code duplicated, block: B:92:0x0129  */
    /* JADX WARN: Code duplicated, block: B:96:0x0130  */
    /* JADX WARN: Code duplicated, block: B:97:0x0137  */
    /* JADX WARN: Code duplicated, block: B:99:0x013f  */
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    public static final void m1246TextfLXpl1I(final String text, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
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
        int i30;
        int i31;
        int i32;
        Modifier.Companion companion;
        long jM1667getUnspecified0d7_KjU;
        long jM4035getUnspecifiedXSAIIZE;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long jM4035getUnspecifiedXSAIIZE2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long jM4035getUnspecifiedXSAIIZE3;
        int iM3784getClipgIe3tQ8;
        boolean z2;
        int i33;
        TextKt$Text$1 textKt$Text$1;
        TextStyle textStyle2;
        int i34;
        int i35;
        boolean z3;
        long j5;
        long j6;
        long jM3505getColor0d7_KjU;
        long j7;
        final Modifier modifier2;
        final TextAlign textAlign3;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function2;
        final FontFamily fontFamily3;
        final long j8;
        final boolean z4;
        final FontStyle fontStyle3;
        final int i36;
        final long j9;
        final TextDecoration textDecoration3;
        final long j10;
        final long j11;
        final int i37;
        final FontWeight fontWeight3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i38;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)106@5548L7,129@6306L145:Text.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i39 = i5 & 2;
        if (i39 == 0) {
            if ((i3 & 112) == 0) {
                i6 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 != 0) {
                i6 |= 384;
            } else if ((i3 & 896) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i6 |= i8;
            }
            i9 = i5 & 8;
            if (i9 != 0) {
                i6 |= 3072;
            } else if ((i3 & 7168) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i6 |= i10;
            }
            i11 = i5 & 16;
            if (i11 != 0) {
                i6 |= 24576;
            } else if ((i3 & 57344) == 0) {
                if (composerStartRestartGroup.changed(fontStyle)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i6 |= i12;
            }
            i13 = i5 & 32;
            if (i13 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(fontWeight)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i6 |= i14;
            }
            i15 = i5 & 64;
            if (i15 != 0) {
                i6 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(fontFamily)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i6 |= i16;
            }
            i17 = i5 & 128;
            if (i17 != 0) {
                i6 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            i19 = i5 & 256;
            if (i19 != 0) {
                i6 |= 100663296;
            } else if ((i3 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(textDecoration)) {
                    i20 = 67108864;
                } else {
                    i20 = 33554432;
                }
                i6 |= i20;
            }
            i21 = i5 & 512;
            if (i21 != 0) {
                i6 |= C.ENCODING_PCM_32BIT;
            } else if ((i3 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(textAlign)) {
                    i22 = 536870912;
                } else {
                    i22 = 268435456;
                }
                i6 |= i22;
            }
            i23 = i5 & 1024;
            if (i23 != 0) {
                i24 = i4 | 6;
            } else if ((i4 & 14) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i25 = 4;
                } else {
                    i25 = 2;
                }
                i24 = i4 | i25;
            } else {
                i24 = i4;
            }
            i26 = i5 & 2048;
            if (i26 != 0) {
                i24 |= 48;
            } else if ((i4 & 112) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i27 = 32;
                } else {
                    i27 = 16;
                }
                i24 |= i27;
            }
            i28 = i24;
            i29 = i5 & 4096;
            if (i29 != 0) {
                if ((i4 & 896) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i30 = 256;
                    } else {
                        i30 = 128;
                    }
                    i28 |= i30;
                }
                i31 = i5 & 8192;
                if (i31 != 0) {
                    if ((i4 & 7168) == 0) {
                        i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
                    }
                    i32 = i5 & 16384;
                    if (i32 != 0) {
                        if ((i4 & 57344) == 0) {
                            i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                        }
                        if ((i4 & 458752) != 0) {
                            if ((i5 & 32768) == 0 || !composerStartRestartGroup.changed(textStyle)) {
                                i38 = 65536;
                            } else {
                                i38 = 131072;
                            }
                            i28 |= i38;
                        }
                        if ((i6 & 1533916891) == 306783378 || (374491 & i28) != 74898 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i39 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i7 != 0) {
                                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                                } else {
                                    jM1667getUnspecified0d7_KjU = j;
                                }
                                if (i9 != 0) {
                                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                                } else {
                                    jM4035getUnspecifiedXSAIIZE = j2;
                                }
                                if (i11 != 0) {
                                    fontStyle2 = null;
                                } else {
                                    fontStyle2 = fontStyle;
                                }
                                if (i13 != 0) {
                                    fontWeight2 = null;
                                } else {
                                    fontWeight2 = fontWeight;
                                }
                                if (i15 != 0) {
                                    fontFamily2 = null;
                                } else {
                                    fontFamily2 = fontFamily;
                                }
                                if (i17 != 0) {
                                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                                } else {
                                    jM4035getUnspecifiedXSAIIZE2 = j3;
                                }
                                if (i19 != 0) {
                                    textDecoration2 = null;
                                } else {
                                    textDecoration2 = textDecoration;
                                }
                                textAlign2 = i21 == 0 ? textAlign : null;
                                if (i23 != 0) {
                                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                                } else {
                                    jM4035getUnspecifiedXSAIIZE3 = j4;
                                }
                                if (i26 != 0) {
                                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                                } else {
                                    iM3784getClipgIe3tQ8 = i;
                                }
                                if (i29 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if (i31 != 0) {
                                    i33 = Integer.MAX_VALUE;
                                } else {
                                    i33 = i2;
                                }
                                if (i32 != 0) {
                                    textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                    textKt$Text$1 = function1;
                                }
                                if ((i5 & 32768) != 0) {
                                    TextDecoration textDecoration4 = textDecoration2;
                                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textStyle2 = (TextStyle) objConsume;
                                    i34 = i28 & (-458753);
                                    textDecoration2 = textDecoration4;
                                } else {
                                    textStyle2 = textStyle;
                                    i34 = i28;
                                }
                                i35 = i33;
                                z3 = z2;
                                j5 = jM4035getUnspecifiedXSAIIZE3;
                                j6 = jM4035getUnspecifiedXSAIIZE;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 32768) != 0) {
                                    i28 &= -458753;
                                }
                                companion = modifier;
                                jM1667getUnspecified0d7_KjU = j;
                                j6 = j2;
                                fontStyle2 = fontStyle;
                                fontWeight2 = fontWeight;
                                fontFamily2 = fontFamily;
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                                textDecoration2 = textDecoration;
                                textAlign2 = textAlign;
                                iM3784getClipgIe3tQ8 = i;
                                z3 = z;
                                i35 = i2;
                                textKt$Text$1 = function1;
                                textStyle2 = textStyle;
                                i34 = i28;
                                j5 = j4;
                            }
                            composerStartRestartGroup.endDefaults();
                            composerStartRestartGroup.startReplaceableGroup(1557613088);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                            if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                j7 = jM1667getUnspecified0d7_KjU;
                            } else {
                                jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    long jM1641unboximpl = ((Color) objConsume2).m1641unboximpl();
                                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localContentAlpha);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl, ((Number) objConsume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                }
                                j7 = jM3505getColor0d7_KjU;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            TextStyle textStyle4 = textStyle2;
                            int i40 = i34 << 9;
                            BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle4.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i40 & 57344) | (i40 & 458752) | (i40 & 3670016), 0);
                            modifier2 = companion;
                            textAlign3 = textAlign2;
                            textStyle3 = textStyle4;
                            function2 = textKt$Text$1;
                            fontFamily3 = fontFamily2;
                            j8 = j5;
                            z4 = z3;
                            fontStyle3 = fontStyle2;
                            i36 = i35;
                            j9 = jM4035getUnspecifiedXSAIIZE2;
                            textDecoration3 = textDecoration2;
                            j10 = j6;
                            j11 = jM1667getUnspecified0d7_KjU;
                            FontWeight fontWeight4 = fontWeight2;
                            i37 = iM3784getClipgIe3tQ8;
                            fontWeight3 = fontWeight4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            j11 = j;
                            j10 = j2;
                            fontStyle3 = fontStyle;
                            fontWeight3 = fontWeight;
                            fontFamily3 = fontFamily;
                            j9 = j3;
                            textDecoration3 = textDecoration;
                            textAlign3 = textAlign;
                            j8 = j4;
                            i37 = i;
                            z4 = z;
                            i36 = i2;
                            function2 = function1;
                            textStyle3 = textStyle;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                            public final void invoke(Composer composer2, int i41) {
                                TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                            }
                        });
                    }
                    i28 |= 24576;
                    if ((i4 & 458752) != 0) {
                        if ((i5 & 32768) == 0) {
                            i38 = 65536;
                        } else {
                            i38 = 65536;
                        }
                        i28 |= i38;
                    }
                    if ((i6 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration5 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal2 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composerStartRestartGroup.consume(providableCompositionLocal2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume4;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration5;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration6 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal3 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composerStartRestartGroup.consume(providableCompositionLocal3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume5;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration6;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composerStartRestartGroup.consume(localContentColor2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl2 = ((Color) objConsume6).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume7 = composerStartRestartGroup.consume(localContentAlpha2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl2, ((Number) objConsume7).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle5 = textStyle2;
                        int i41 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle5.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i41 & 57344) | (i41 & 458752) | (i41 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle5;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight5 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration7 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal4 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume8 = composerStartRestartGroup.consume(providableCompositionLocal4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume8;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration7;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration8 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal5 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume9 = composerStartRestartGroup.consume(providableCompositionLocal5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume9;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration8;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume10 = composerStartRestartGroup.consume(localContentColor3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl3 = ((Color) objConsume10).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha3 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11 = composerStartRestartGroup.consume(localContentAlpha3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl3, ((Number) objConsume11).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle6 = textStyle2;
                        int i42 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle6.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i42 & 57344) | (i42 & 458752) | (i42 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle6;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight6 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                        public final void invoke(Composer composer2, int i43) {
                            TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= 3072;
                i32 = i5 & 16384;
                if (i32 != 0) {
                    if ((i4 & 57344) == 0) {
                        i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                    }
                    if ((i4 & 458752) != 0) {
                        if ((i5 & 32768) == 0) {
                            i38 = 65536;
                        } else {
                            i38 = 65536;
                        }
                        i28 |= i38;
                    }
                    if ((i6 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration9 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal6 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume12 = composerStartRestartGroup.consume(providableCompositionLocal6);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume12;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration9;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration10 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal7 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume13 = composerStartRestartGroup.consume(providableCompositionLocal7);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume13;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration10;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume14 = composerStartRestartGroup.consume(localContentColor4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl4 = ((Color) objConsume14).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha4 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume15 = composerStartRestartGroup.consume(localContentAlpha4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl4, ((Number) objConsume15).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle7 = textStyle2;
                        int i43 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle7.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i43 & 57344) | (i43 & 458752) | (i43 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle7;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight7 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight7;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration11 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal8 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume16 = composerStartRestartGroup.consume(providableCompositionLocal8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume16;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration11;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration12 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal9 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume17 = composerStartRestartGroup.consume(providableCompositionLocal9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume17;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration12;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume18 = composerStartRestartGroup.consume(localContentColor5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl5 = ((Color) objConsume18).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha5 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume19 = composerStartRestartGroup.consume(localContentAlpha5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl5, ((Number) objConsume19).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle8 = textStyle2;
                        int i44 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle8.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i44 & 57344) | (i44 & 458752) | (i44 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle8;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight8 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                        public final void invoke(Composer composer2, int i45) {
                            TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= 24576;
                if ((i4 & 458752) != 0) {
                    if ((i5 & 32768) == 0) {
                        i38 = 65536;
                    } else {
                        i38 = 65536;
                    }
                    i28 |= i38;
                }
                if ((i6 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration13 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal10 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume110 = composerStartRestartGroup.consume(providableCompositionLocal10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume110;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration13;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration14 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111 = composerStartRestartGroup.consume(providableCompositionLocal11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume111;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration14;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume112 = composerStartRestartGroup.consume(localContentColor6);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl6 = ((Color) objConsume112).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha6 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume113 = composerStartRestartGroup.consume(localContentAlpha6);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl6, ((Number) objConsume113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle9 = textStyle2;
                    int i45 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle9.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i45 & 57344) | (i45 & 458752) | (i45 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle9;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight9 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration15 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal12 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume114 = composerStartRestartGroup.consume(providableCompositionLocal12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume114;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration15;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration16 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal13 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume115 = composerStartRestartGroup.consume(providableCompositionLocal13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume115;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration16;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume116 = composerStartRestartGroup.consume(localContentColor7);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl7 = ((Color) objConsume116).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha7 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume117 = composerStartRestartGroup.consume(localContentAlpha7);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl7, ((Number) objConsume117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle10 = textStyle2;
                    int i46 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle10.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i46 & 57344) | (i46 & 458752) | (i46 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle10;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight10 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                    public final void invoke(Composer composer2, int i47) {
                        TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 384;
            i31 = i5 & 8192;
            if (i31 != 0) {
                if ((i4 & 7168) == 0) {
                    i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
                }
                i32 = i5 & 16384;
                if (i32 != 0) {
                    if ((i4 & 57344) == 0) {
                        i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                    }
                    if ((i4 & 458752) != 0) {
                        if ((i5 & 32768) == 0) {
                            i38 = 65536;
                        } else {
                            i38 = 65536;
                        }
                        i28 |= i38;
                    }
                    if ((i6 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration17 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal14 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume118 = composerStartRestartGroup.consume(providableCompositionLocal14);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume118;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration17;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration18 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal15 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume119 = composerStartRestartGroup.consume(providableCompositionLocal15);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume119;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration18;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1110 = composerStartRestartGroup.consume(localContentColor8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl8 = ((Color) objConsume1110).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha8 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111 = composerStartRestartGroup.consume(localContentAlpha8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl8, ((Number) objConsume1111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle11 = textStyle2;
                        int i47 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle11.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i47 & 57344) | (i47 & 458752) | (i47 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle11;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight11 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration19 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal16 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1112 = composerStartRestartGroup.consume(providableCompositionLocal16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1112;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration19;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration110 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal17 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1113 = composerStartRestartGroup.consume(providableCompositionLocal17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1113;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration110;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1114 = composerStartRestartGroup.consume(localContentColor9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl9 = ((Color) objConsume1114).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha9 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1115 = composerStartRestartGroup.consume(localContentAlpha9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl9, ((Number) objConsume1115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle12 = textStyle2;
                        int i48 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle12.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i48 & 57344) | (i48 & 458752) | (i48 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle12;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight12 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                        public final void invoke(Composer composer2, int i49) {
                            TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= 24576;
                if ((i4 & 458752) != 0) {
                    if ((i5 & 32768) == 0) {
                        i38 = 65536;
                    } else {
                        i38 = 65536;
                    }
                    i28 |= i38;
                }
                if ((i6 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration111 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal18 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1116 = composerStartRestartGroup.consume(providableCompositionLocal18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1116;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration111;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration112 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal19 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1117 = composerStartRestartGroup.consume(providableCompositionLocal19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1117;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration112;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1118 = composerStartRestartGroup.consume(localContentColor10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl10 = ((Color) objConsume1118).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha10 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1119 = composerStartRestartGroup.consume(localContentAlpha10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl10, ((Number) objConsume1119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle13 = textStyle2;
                    int i49 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle13.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i49 & 57344) | (i49 & 458752) | (i49 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle13;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight13 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration113 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal110 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11110 = composerStartRestartGroup.consume(providableCompositionLocal110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11110;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration113;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration114 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal111 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111 = composerStartRestartGroup.consume(providableCompositionLocal111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration114;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11112 = composerStartRestartGroup.consume(localContentColor11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl11 = ((Color) objConsume11112).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha11 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11113 = composerStartRestartGroup.consume(localContentAlpha11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl11, ((Number) objConsume11113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle14 = textStyle2;
                    int i410 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle14.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i410 & 57344) | (i410 & 458752) | (i410 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle14;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight14 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                    public final void invoke(Composer composer2, int i411) {
                        TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 3072;
            i32 = i5 & 16384;
            if (i32 != 0) {
                if ((i4 & 57344) == 0) {
                    i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                }
                if ((i4 & 458752) != 0) {
                    if ((i5 & 32768) == 0) {
                        i38 = 65536;
                    } else {
                        i38 = 65536;
                    }
                    i28 |= i38;
                }
                if ((i6 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration115 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal112 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11114 = composerStartRestartGroup.consume(providableCompositionLocal112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11114;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration115;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration116 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal113 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11115 = composerStartRestartGroup.consume(providableCompositionLocal113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11115;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration116;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11116 = composerStartRestartGroup.consume(localContentColor12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl12 = ((Color) objConsume11116).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha12 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11117 = composerStartRestartGroup.consume(localContentAlpha12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl12, ((Number) objConsume11117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle15 = textStyle2;
                    int i411 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle15.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i411 & 57344) | (i411 & 458752) | (i411 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle15;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight15 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight15;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration117 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal114 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11118 = composerStartRestartGroup.consume(providableCompositionLocal114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11118;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration117;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration118 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal115 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11119 = composerStartRestartGroup.consume(providableCompositionLocal115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11119;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration118;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111110 = composerStartRestartGroup.consume(localContentColor13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl13 = ((Color) objConsume111110).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha13 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111 = composerStartRestartGroup.consume(localContentAlpha13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl13, ((Number) objConsume111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle16 = textStyle2;
                    int i412 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle16.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i412 & 57344) | (i412 & 458752) | (i412 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle16;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight16 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                    public final void invoke(Composer composer2, int i413) {
                        TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 24576;
            if ((i4 & 458752) != 0) {
                if ((i5 & 32768) == 0) {
                    i38 = 65536;
                } else {
                    i38 = 65536;
                }
                i28 |= i38;
            }
            if ((i6 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration119 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal116 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111112 = composerStartRestartGroup.consume(providableCompositionLocal116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111112;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration119;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration1110 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal117 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111113 = composerStartRestartGroup.consume(providableCompositionLocal117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111113;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration1110;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111114 = composerStartRestartGroup.consume(localContentColor14);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl14 = ((Color) objConsume111114).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha14 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111115 = composerStartRestartGroup.consume(localContentAlpha14);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl14, ((Number) objConsume111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle17 = textStyle2;
                int i413 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle17.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i413 & 57344) | (i413 & 458752) | (i413 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle17;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight17 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration1111 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal118 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111116 = composerStartRestartGroup.consume(providableCompositionLocal118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111116;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration1111;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration1112 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal119 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111117 = composerStartRestartGroup.consume(providableCompositionLocal119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111117;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration1112;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111118 = composerStartRestartGroup.consume(localContentColor15);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl15 = ((Color) objConsume111118).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha15 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111119 = composerStartRestartGroup.consume(localContentAlpha15);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl15, ((Number) objConsume111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle18 = textStyle2;
                int i414 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle18.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i414 & 57344) | (i414 & 458752) | (i414 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle18;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight18 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                public final void invoke(Composer composer2, int i415) {
                    TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i6 |= 48;
        i7 = i5 & 4;
        if (i7 != 0) {
            i6 |= 384;
        } else if ((i3 & 896) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i6 |= i8;
        }
        i9 = i5 & 8;
        if (i9 != 0) {
            i6 |= 3072;
        } else if ((i3 & 7168) == 0) {
            if (composerStartRestartGroup.changed(j2)) {
                i10 = 2048;
            } else {
                i10 = 1024;
            }
            i6 |= i10;
        }
        i11 = i5 & 16;
        if (i11 != 0) {
            i6 |= 24576;
        } else if ((i3 & 57344) == 0) {
            if (composerStartRestartGroup.changed(fontStyle)) {
                i12 = 16384;
            } else {
                i12 = 8192;
            }
            i6 |= i12;
        }
        i13 = i5 & 32;
        if (i13 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & 458752) == 0) {
            if (composerStartRestartGroup.changed(fontWeight)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i6 |= i14;
        }
        i15 = i5 & 64;
        if (i15 != 0) {
            i6 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(fontFamily)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i6 |= i16;
        }
        i17 = i5 & 128;
        if (i17 != 0) {
            i6 |= 12582912;
        } else if ((i3 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(j3)) {
                i18 = 8388608;
            } else {
                i18 = 4194304;
            }
            i6 |= i18;
        }
        i19 = i5 & 256;
        if (i19 != 0) {
            i6 |= 100663296;
        } else if ((i3 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(textDecoration)) {
                i20 = 67108864;
            } else {
                i20 = 33554432;
            }
            i6 |= i20;
        }
        i21 = i5 & 512;
        if (i21 != 0) {
            i6 |= C.ENCODING_PCM_32BIT;
        } else if ((i3 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(textAlign)) {
                i22 = 536870912;
            } else {
                i22 = 268435456;
            }
            i6 |= i22;
        }
        i23 = i5 & 1024;
        if (i23 != 0) {
            i24 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            if (composerStartRestartGroup.changed(j4)) {
                i25 = 4;
            } else {
                i25 = 2;
            }
            i24 = i4 | i25;
        } else {
            i24 = i4;
        }
        i26 = i5 & 2048;
        if (i26 != 0) {
            i24 |= 48;
        } else if ((i4 & 112) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i27 = 32;
            } else {
                i27 = 16;
            }
            i24 |= i27;
        }
        i28 = i24;
        i29 = i5 & 4096;
        if (i29 != 0) {
            if ((i4 & 896) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i30 = 256;
                } else {
                    i30 = 128;
                }
                i28 |= i30;
            }
            i31 = i5 & 8192;
            if (i31 != 0) {
                if ((i4 & 7168) == 0) {
                    i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
                }
                i32 = i5 & 16384;
                if (i32 != 0) {
                    if ((i4 & 57344) == 0) {
                        i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                    }
                    if ((i4 & 458752) != 0) {
                        if ((i5 & 32768) == 0) {
                            i38 = 65536;
                        } else {
                            i38 = 65536;
                        }
                        i28 |= i38;
                    }
                    if ((i6 & 1533916891) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration1113 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1110 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111110 = composerStartRestartGroup.consume(providableCompositionLocal1110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111110;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration1113;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration1114 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1111 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111111 = composerStartRestartGroup.consume(providableCompositionLocal1111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111111;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration1114;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111112 = composerStartRestartGroup.consume(localContentColor16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl16 = ((Color) objConsume1111112).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha16 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111113 = composerStartRestartGroup.consume(localContentAlpha16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl16, ((Number) objConsume1111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle19 = textStyle2;
                        int i415 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle19.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i415 & 57344) | (i415 & 458752) | (i415 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle19;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight19 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight19;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration1115 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1112 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111114 = composerStartRestartGroup.consume(providableCompositionLocal1112);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111114;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration1115;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i39 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i33 = Integer.MAX_VALUE;
                            } else {
                                i33 = i2;
                            }
                            if (i32 != 0) {
                                textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                                textKt$Text$1 = function1;
                            }
                            if ((i5 & 32768) != 0) {
                                TextDecoration textDecoration1116 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1113 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111115 = composerStartRestartGroup.consume(providableCompositionLocal1113);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111115;
                                i34 = i28 & (-458753);
                                textDecoration2 = textDecoration1116;
                            } else {
                                textStyle2 = textStyle;
                                i34 = i28;
                            }
                            i35 = i33;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557613088);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111116 = composerStartRestartGroup.consume(localContentColor17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl17 = ((Color) objConsume1111116).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha17 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111117 = composerStartRestartGroup.consume(localContentAlpha17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl17, ((Number) objConsume1111117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle110 = textStyle2;
                        int i416 = i34 << 9;
                        BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle110.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i416 & 57344) | (i416 & 458752) | (i416 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        textStyle3 = textStyle110;
                        function2 = textKt$Text$1;
                        fontFamily3 = fontFamily2;
                        j8 = j5;
                        z4 = z3;
                        fontStyle3 = fontStyle2;
                        i36 = i35;
                        j9 = jM4035getUnspecifiedXSAIIZE2;
                        textDecoration3 = textDecoration2;
                        j10 = j6;
                        j11 = jM1667getUnspecified0d7_KjU;
                        FontWeight fontWeight110 = fontWeight2;
                        i37 = iM3784getClipgIe3tQ8;
                        fontWeight3 = fontWeight110;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                        public final void invoke(Composer composer2, int i417) {
                            TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= 24576;
                if ((i4 & 458752) != 0) {
                    if ((i5 & 32768) == 0) {
                        i38 = 65536;
                    } else {
                        i38 = 65536;
                    }
                    i28 |= i38;
                }
                if ((i6 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration1117 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1114 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111118 = composerStartRestartGroup.consume(providableCompositionLocal1114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111118;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration1117;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration1118 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1115 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111119 = composerStartRestartGroup.consume(providableCompositionLocal1115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111119;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration1118;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111110 = composerStartRestartGroup.consume(localContentColor18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl18 = ((Color) objConsume11111110).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha18 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111111 = composerStartRestartGroup.consume(localContentAlpha18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl18, ((Number) objConsume11111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle111 = textStyle2;
                    int i417 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle111.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i417 & 57344) | (i417 & 458752) | (i417 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle111;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight111 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration1119 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1116 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111112 = composerStartRestartGroup.consume(providableCompositionLocal1116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111112;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration1119;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration11110 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1117 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111113 = composerStartRestartGroup.consume(providableCompositionLocal1117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111113;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration11110;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111114 = composerStartRestartGroup.consume(localContentColor19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl19 = ((Color) objConsume11111114).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha19 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111115 = composerStartRestartGroup.consume(localContentAlpha19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl19, ((Number) objConsume11111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle112 = textStyle2;
                    int i418 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle112.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i418 & 57344) | (i418 & 458752) | (i418 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle112;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight112 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight112;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                    public final void invoke(Composer composer2, int i419) {
                        TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 3072;
            i32 = i5 & 16384;
            if (i32 != 0) {
                if ((i4 & 57344) == 0) {
                    i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                }
                if ((i4 & 458752) != 0) {
                    if ((i5 & 32768) == 0) {
                        i38 = 65536;
                    } else {
                        i38 = 65536;
                    }
                    i28 |= i38;
                }
                if ((i6 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration11111 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1118 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111116 = composerStartRestartGroup.consume(providableCompositionLocal1118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111116;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration11111;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration11112 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1119 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111117 = composerStartRestartGroup.consume(providableCompositionLocal1119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111117;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration11112;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111118 = composerStartRestartGroup.consume(localContentColor110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl110 = ((Color) objConsume11111118).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha110 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111119 = composerStartRestartGroup.consume(localContentAlpha110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl110, ((Number) objConsume11111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle113 = textStyle2;
                    int i419 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle113.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i419 & 57344) | (i419 & 458752) | (i419 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle113;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight113 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration11113 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11110 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111110 = composerStartRestartGroup.consume(providableCompositionLocal11110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume111111110;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration11113;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration11114 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11111 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111111 = composerStartRestartGroup.consume(providableCompositionLocal11111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume111111111;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration11114;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111112 = composerStartRestartGroup.consume(localContentColor111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl111 = ((Color) objConsume111111112).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha111 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111113 = composerStartRestartGroup.consume(localContentAlpha111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl111, ((Number) objConsume111111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle114 = textStyle2;
                    int i4110 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle114.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4110 & 57344) | (i4110 & 458752) | (i4110 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle114;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight114 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight114;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                    public final void invoke(Composer composer2, int i4111) {
                        TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 24576;
            if ((i4 & 458752) != 0) {
                if ((i5 & 32768) == 0) {
                    i38 = 65536;
                } else {
                    i38 = 65536;
                }
                i28 |= i38;
            }
            if ((i6 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration11115 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11112 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111114 = composerStartRestartGroup.consume(providableCompositionLocal11112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111114;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration11115;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration11116 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11113 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111115 = composerStartRestartGroup.consume(providableCompositionLocal11113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111115;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration11116;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111116 = composerStartRestartGroup.consume(localContentColor112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl112 = ((Color) objConsume111111116).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha112 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111117 = composerStartRestartGroup.consume(localContentAlpha112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl112, ((Number) objConsume111111117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle115 = textStyle2;
                int i4111 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle115.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4111 & 57344) | (i4111 & 458752) | (i4111 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle115;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight115 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration11117 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11114 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111118 = composerStartRestartGroup.consume(providableCompositionLocal11114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111118;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration11117;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration11118 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11115 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111119 = composerStartRestartGroup.consume(providableCompositionLocal11115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111119;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration11118;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111110 = composerStartRestartGroup.consume(localContentColor113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl113 = ((Color) objConsume1111111110).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha113 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111 = composerStartRestartGroup.consume(localContentAlpha113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl113, ((Number) objConsume1111111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle116 = textStyle2;
                int i4112 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle116.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4112 & 57344) | (i4112 & 458752) | (i4112 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle116;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight116 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight116;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                public final void invoke(Composer composer2, int i4113) {
                    TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i28 |= 384;
        i31 = i5 & 8192;
        if (i31 != 0) {
            if ((i4 & 7168) == 0) {
                i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
            }
            i32 = i5 & 16384;
            if (i32 != 0) {
                if ((i4 & 57344) == 0) {
                    i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
                }
                if ((i4 & 458752) != 0) {
                    if ((i5 & 32768) == 0) {
                        i38 = 65536;
                    } else {
                        i38 = 65536;
                    }
                    i28 |= i38;
                }
                if ((i6 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration11119 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11116 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111112 = composerStartRestartGroup.consume(providableCompositionLocal11116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111112;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration11119;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration111110 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11117 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111113 = composerStartRestartGroup.consume(providableCompositionLocal11117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111113;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration111110;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111114 = composerStartRestartGroup.consume(localContentColor114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl114 = ((Color) objConsume1111111114).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha114 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111115 = composerStartRestartGroup.consume(localContentAlpha114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl114, ((Number) objConsume1111111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle117 = textStyle2;
                    int i4113 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle117.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4113 & 57344) | (i4113 & 458752) | (i4113 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle117;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight117 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration111111 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11118 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111116 = composerStartRestartGroup.consume(providableCompositionLocal11118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111116;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration111111;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i39 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i33 = Integer.MAX_VALUE;
                        } else {
                            i33 = i2;
                        }
                        if (i32 != 0) {
                            textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                            textKt$Text$1 = function1;
                        }
                        if ((i5 & 32768) != 0) {
                            TextDecoration textDecoration111112 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11119 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111117 = composerStartRestartGroup.consume(providableCompositionLocal11119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111117;
                            i34 = i28 & (-458753);
                            textDecoration2 = textDecoration111112;
                        } else {
                            textStyle2 = textStyle;
                            i34 = i28;
                        }
                        i35 = i33;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557613088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111118 = composerStartRestartGroup.consume(localContentColor115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl115 = ((Color) objConsume1111111118).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha115 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111119 = composerStartRestartGroup.consume(localContentAlpha115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl115, ((Number) objConsume1111111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle118 = textStyle2;
                    int i4114 = i34 << 9;
                    BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle118.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4114 & 57344) | (i4114 & 458752) | (i4114 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    textStyle3 = textStyle118;
                    function2 = textKt$Text$1;
                    fontFamily3 = fontFamily2;
                    j8 = j5;
                    z4 = z3;
                    fontStyle3 = fontStyle2;
                    i36 = i35;
                    j9 = jM4035getUnspecifiedXSAIIZE2;
                    textDecoration3 = textDecoration2;
                    j10 = j6;
                    j11 = jM1667getUnspecified0d7_KjU;
                    FontWeight fontWeight118 = fontWeight2;
                    i37 = iM3784getClipgIe3tQ8;
                    fontWeight3 = fontWeight118;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                    public final void invoke(Composer composer2, int i4115) {
                        TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 24576;
            if ((i4 & 458752) != 0) {
                if ((i5 & 32768) == 0) {
                    i38 = 65536;
                } else {
                    i38 = 65536;
                }
                i28 |= i38;
            }
            if ((i6 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111113 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111110 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111110 = composerStartRestartGroup.consume(providableCompositionLocal111110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111110;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111113;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111114 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111111 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111 = composerStartRestartGroup.consume(providableCompositionLocal111111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111111;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111114;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111112 = composerStartRestartGroup.consume(localContentColor116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl116 = ((Color) objConsume11111111112).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha116 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111113 = composerStartRestartGroup.consume(localContentAlpha116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl116, ((Number) objConsume11111111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle119 = textStyle2;
                int i4115 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle119.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4115 & 57344) | (i4115 & 458752) | (i4115 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle119;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight119 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111115 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111112 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111114 = composerStartRestartGroup.consume(providableCompositionLocal111112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111114;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111115;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111116 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111113 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111115 = composerStartRestartGroup.consume(providableCompositionLocal111113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111115;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111116;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111116 = composerStartRestartGroup.consume(localContentColor117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl117 = ((Color) objConsume11111111116).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha117 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111117 = composerStartRestartGroup.consume(localContentAlpha117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl117, ((Number) objConsume11111111117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle1110 = textStyle2;
                int i4116 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle1110.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4116 & 57344) | (i4116 & 458752) | (i4116 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle1110;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight1110 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight1110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                public final void invoke(Composer composer2, int i4117) {
                    TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i28 |= 3072;
        i32 = i5 & 16384;
        if (i32 != 0) {
            if ((i4 & 57344) == 0) {
                i28 |= composerStartRestartGroup.changed(function1) ? 16384 : 8192;
            }
            if ((i4 & 458752) != 0) {
                if ((i5 & 32768) == 0) {
                    i38 = 65536;
                } else {
                    i38 = 65536;
                }
                i28 |= i38;
            }
            if ((i6 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111117 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111114 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111118 = composerStartRestartGroup.consume(providableCompositionLocal111114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111118;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111117;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111118 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111115 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111119 = composerStartRestartGroup.consume(providableCompositionLocal111115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111119;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111118;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111110 = composerStartRestartGroup.consume(localContentColor118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl118 = ((Color) objConsume111111111110).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha118 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111 = composerStartRestartGroup.consume(localContentAlpha118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl118, ((Number) objConsume111111111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle1111 = textStyle2;
                int i4117 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle1111.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4117 & 57344) | (i4117 & 458752) | (i4117 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle1111;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight1111 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight1111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration111119 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111116 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111112 = composerStartRestartGroup.consume(providableCompositionLocal111116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111111112;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration111119;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i39 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i33 = Integer.MAX_VALUE;
                    } else {
                        i33 = i2;
                    }
                    if (i32 != 0) {
                        textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                        textKt$Text$1 = function1;
                    }
                    if ((i5 & 32768) != 0) {
                        TextDecoration textDecoration1111110 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111117 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111113 = composerStartRestartGroup.consume(providableCompositionLocal111117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111111113;
                        i34 = i28 & (-458753);
                        textDecoration2 = textDecoration1111110;
                    } else {
                        textStyle2 = textStyle;
                        i34 = i28;
                    }
                    i35 = i33;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557613088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111114 = composerStartRestartGroup.consume(localContentColor119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl119 = ((Color) objConsume111111111114).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha119 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111115 = composerStartRestartGroup.consume(localContentAlpha119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl119, ((Number) objConsume111111111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle1112 = textStyle2;
                int i4118 = i34 << 9;
                BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle1112.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4118 & 57344) | (i4118 & 458752) | (i4118 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                textStyle3 = textStyle1112;
                function2 = textKt$Text$1;
                fontFamily3 = fontFamily2;
                j8 = j5;
                z4 = z3;
                fontStyle3 = fontStyle2;
                i36 = i35;
                j9 = jM4035getUnspecifiedXSAIIZE2;
                textDecoration3 = textDecoration2;
                j10 = j6;
                j11 = jM1667getUnspecified0d7_KjU;
                FontWeight fontWeight1112 = fontWeight2;
                i37 = iM3784getClipgIe3tQ8;
                fontWeight3 = fontWeight1112;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                public final void invoke(Composer composer2, int i4119) {
                    TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i28 |= 24576;
        if ((i4 & 458752) != 0) {
            if ((i5 & 32768) == 0) {
                i38 = 65536;
            } else {
                i38 = 65536;
            }
            i28 |= i38;
        }
        if ((i6 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i39 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i33 = Integer.MAX_VALUE;
                } else {
                    i33 = i2;
                }
                if (i32 != 0) {
                    textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                    textKt$Text$1 = function1;
                }
                if ((i5 & 32768) != 0) {
                    TextDecoration textDecoration1111111 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal111118 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111116 = composerStartRestartGroup.consume(providableCompositionLocal111118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume111111111116;
                    i34 = i28 & (-458753);
                    textDecoration2 = textDecoration1111111;
                } else {
                    textStyle2 = textStyle;
                    i34 = i28;
                }
                i35 = i33;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            } else {
                if (i39 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i33 = Integer.MAX_VALUE;
                } else {
                    i33 = i2;
                }
                if (i32 != 0) {
                    textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                    textKt$Text$1 = function1;
                }
                if ((i5 & 32768) != 0) {
                    TextDecoration textDecoration1111112 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal111119 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111117 = composerStartRestartGroup.consume(providableCompositionLocal111119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume111111111117;
                    i34 = i28 & (-458753);
                    textDecoration2 = textDecoration1111112;
                } else {
                    textStyle2 = textStyle;
                    i34 = i28;
                }
                i35 = i33;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1557613088);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
            if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                j7 = jM1667getUnspecified0d7_KjU;
            } else {
                jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111118 = composerStartRestartGroup.consume(localContentColor1110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long jM1641unboximpl1110 = ((Color) objConsume111111111118).m1641unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha1110 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111119 = composerStartRestartGroup.consume(localContentAlpha1110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl1110, ((Number) objConsume111111111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                }
                j7 = jM3505getColor0d7_KjU;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyle1113 = textStyle2;
            int i4119 = i34 << 9;
            BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle1113.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i4119 & 57344) | (i4119 & 458752) | (i4119 & 3670016), 0);
            modifier2 = companion;
            textAlign3 = textAlign2;
            textStyle3 = textStyle1113;
            function2 = textKt$Text$1;
            fontFamily3 = fontFamily2;
            j8 = j5;
            z4 = z3;
            fontStyle3 = fontStyle2;
            i36 = i35;
            j9 = jM4035getUnspecifiedXSAIIZE2;
            textDecoration3 = textDecoration2;
            j10 = j6;
            j11 = jM1667getUnspecified0d7_KjU;
            FontWeight fontWeight1113 = fontWeight2;
            i37 = iM3784getClipgIe3tQ8;
            fontWeight3 = fontWeight1113;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i39 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i33 = Integer.MAX_VALUE;
                } else {
                    i33 = i2;
                }
                if (i32 != 0) {
                    textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                    textKt$Text$1 = function1;
                }
                if ((i5 & 32768) != 0) {
                    TextDecoration textDecoration1111113 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal1111110 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111110 = composerStartRestartGroup.consume(providableCompositionLocal1111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume1111111111110;
                    i34 = i28 & (-458753);
                    textDecoration2 = textDecoration1111113;
                } else {
                    textStyle2 = textStyle;
                    i34 = i28;
                }
                i35 = i33;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            } else {
                if (i39 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i33 = Integer.MAX_VALUE;
                } else {
                    i33 = i2;
                }
                if (i32 != 0) {
                    textKt$Text$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
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
                    textKt$Text$1 = function1;
                }
                if ((i5 & 32768) != 0) {
                    TextDecoration textDecoration1111114 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal1111111 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111 = composerStartRestartGroup.consume(providableCompositionLocal1111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume1111111111111;
                    i34 = i28 & (-458753);
                    textDecoration2 = textDecoration1111114;
                } else {
                    textStyle2 = textStyle;
                    i34 = i28;
                }
                i35 = i33;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1557613088);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5663L7,111@5702L7");
            if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                j7 = jM1667getUnspecified0d7_KjU;
            } else {
                jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111112 = composerStartRestartGroup.consume(localContentColor1111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long jM1641unboximpl1111 = ((Color) objConsume1111111111112).m1641unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha1111 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111113 = composerStartRestartGroup.consume(localContentAlpha1111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl1111, ((Number) objConsume1111111111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                }
                j7 = jM3505getColor0d7_KjU;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyle1114 = textStyle2;
            int i41110 = i34 << 9;
            BasicTextKt.m685BasicTextBpD7jsM(text, companion, textStyle1114.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$1, iM3784getClipgIe3tQ8, z3, i35, composerStartRestartGroup, (i6 & 126) | ((i34 >> 3) & 7168) | (i41110 & 57344) | (i41110 & 458752) | (i41110 & 3670016), 0);
            modifier2 = companion;
            textAlign3 = textAlign2;
            textStyle3 = textStyle1114;
            function2 = textKt$Text$1;
            fontFamily3 = fontFamily2;
            j8 = j5;
            z4 = z3;
            fontStyle3 = fontStyle2;
            i36 = i35;
            j9 = jM4035getUnspecifiedXSAIIZE2;
            textDecoration3 = textDecoration2;
            j10 = j6;
            j11 = jM1667getUnspecified0d7_KjU;
            FontWeight fontWeight1114 = fontWeight2;
            i37 = iM3784getClipgIe3tQ8;
            fontWeight3 = fontWeight1114;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

            public final void invoke(Composer composer2, int i41111) {
                TextKt.m1246TextfLXpl1I(text, modifier2, j11, j10, fontStyle3, fontWeight3, fontFamily3, j9, textDecoration3, textAlign3, j8, i37, z4, i36, function2, textStyle3, composer2, i3 | 1, i4, i5);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0143  */
    /* JADX WARN: Code duplicated, block: B:102:0x0146  */
    /* JADX WARN: Code duplicated, block: B:106:0x014e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0153  */
    /* JADX WARN: Code duplicated, block: B:109:0x0159  */
    /* JADX WARN: Code duplicated, block: B:111:0x015f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0162  */
    /* JADX WARN: Code duplicated, block: B:114:0x0167  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:123:0x017f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0184  */
    /* JADX WARN: Code duplicated, block: B:128:0x018c  */
    /* JADX WARN: Code duplicated, block: B:129:0x018f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0193  */
    /* JADX WARN: Code duplicated, block: B:133:0x019b  */
    /* JADX WARN: Code duplicated, block: B:134:0x019e  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:153:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:154:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:166:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:169:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:171:0x0204  */
    /* JADX WARN: Code duplicated, block: B:174:0x020a  */
    /* JADX WARN: Code duplicated, block: B:182:0x0248  */
    /* JADX WARN: Code duplicated, block: B:184:0x0254  */
    /* JADX WARN: Code duplicated, block: B:194:0x0290 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:195:0x0292  */
    /* JADX WARN: Code duplicated, block: B:196:0x0297  */
    /* JADX WARN: Code duplicated, block: B:198:0x029b  */
    /* JADX WARN: Code duplicated, block: B:199:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:201:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:202:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:205:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:206:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:208:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:209:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:211:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:212:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:214:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:215:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:217:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:218:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:221:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:223:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:224:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:226:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:227:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:229:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:230:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:232:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:233:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:235:0x0300  */
    /* JADX WARN: Code duplicated, block: B:236:0x030a  */
    /* JADX WARN: Code duplicated, block: B:238:0x030e  */
    /* JADX WARN: Code duplicated, block: B:239:0x0313  */
    /* JADX WARN: Code duplicated, block: B:242:0x0319  */
    /* JADX WARN: Code duplicated, block: B:243:0x033b  */
    /* JADX WARN: Code duplicated, block: B:247:0x0363  */
    /* JADX WARN: Code duplicated, block: B:248:0x0366  */
    /* JADX WARN: Code duplicated, block: B:251:0x0375  */
    /* JADX WARN: Code duplicated, block: B:257:0x0456  */
    /* JADX WARN: Code duplicated, block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00de  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x0107  */
    /* JADX WARN: Code duplicated, block: B:86:0x010f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0116  */
    /* JADX WARN: Code duplicated, block: B:89:0x011e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x0127  */
    /* JADX WARN: Code duplicated, block: B:96:0x012e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:99:0x013d  */
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    public static final void m1245Text4IGK_g(final AnnotatedString text, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
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
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        Modifier.Companion companion;
        long jM1667getUnspecified0d7_KjU;
        long jM4035getUnspecifiedXSAIIZE;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long jM4035getUnspecifiedXSAIIZE2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long jM4035getUnspecifiedXSAIIZE3;
        int iM3784getClipgIe3tQ8;
        boolean z2;
        int i35;
        Map<String, InlineTextContent> mapEmptyMap;
        TextKt$Text$3 textKt$Text$3;
        TextStyle textStyle2;
        int i36;
        int i37;
        Map<String, InlineTextContent> map2;
        int i38;
        boolean z3;
        long j5;
        long j6;
        long jM3505getColor0d7_KjU;
        long j7;
        final Modifier modifier2;
        final TextAlign textAlign3;
        final Function1<? super TextLayoutResult, Unit> function2;
        final FontFamily fontFamily3;
        final int i39;
        final Map<String, InlineTextContent> map3;
        final TextDecoration textDecoration3;
        final boolean z4;
        final int i40;
        final FontWeight fontWeight3;
        final FontStyle fontStyle3;
        final long j8;
        final long j9;
        final long j10;
        final TextStyle textStyle3;
        final long j11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i41;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-422393234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)210@10653L7,232@11410L167:Text.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i42 = i5 & 2;
        if (i42 == 0) {
            if ((i3 & 112) == 0) {
                i6 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 != 0) {
                i6 |= 384;
            } else if ((i3 & 896) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i6 |= i8;
            }
            i9 = i5 & 8;
            if (i9 != 0) {
                i6 |= 3072;
            } else if ((i3 & 7168) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i6 |= i10;
            }
            i11 = i5 & 16;
            if (i11 != 0) {
                i6 |= 24576;
            } else if ((i3 & 57344) == 0) {
                if (composerStartRestartGroup.changed(fontStyle)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i6 |= i12;
            }
            i13 = i5 & 32;
            if (i13 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(fontWeight)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i6 |= i14;
            }
            i15 = i5 & 64;
            if (i15 != 0) {
                i6 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(fontFamily)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i6 |= i16;
            }
            i17 = i5 & 128;
            if (i17 != 0) {
                i6 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i6 |= i18;
            }
            i19 = i5 & 256;
            if (i19 != 0) {
                i6 |= 100663296;
            } else if ((i3 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(textDecoration)) {
                    i20 = 67108864;
                } else {
                    i20 = 33554432;
                }
                i6 |= i20;
            }
            i21 = i5 & 512;
            if (i21 != 0) {
                i6 |= C.ENCODING_PCM_32BIT;
            } else if ((i3 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(textAlign)) {
                    i22 = 536870912;
                } else {
                    i22 = 268435456;
                }
                i6 |= i22;
            }
            i23 = i5 & 1024;
            if (i23 != 0) {
                i24 = i4 | 6;
            } else if ((i4 & 14) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i25 = 4;
                } else {
                    i25 = 2;
                }
                i24 = i4 | i25;
            } else {
                i24 = i4;
            }
            i26 = i5 & 2048;
            if (i26 != 0) {
                i24 |= 48;
            } else if ((i4 & 112) != 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i27 = 32;
                } else {
                    i27 = 16;
                }
                i24 |= i27;
            }
            i28 = i24;
            i29 = i5 & 4096;
            if (i29 != 0) {
                if ((i4 & 896) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i30 = 256;
                    } else {
                        i30 = 128;
                    }
                    i28 |= i30;
                }
                i31 = i5 & 8192;
                if (i31 != 0) {
                    if ((i4 & 7168) == 0) {
                        i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
                    }
                    i32 = i5 & 16384;
                    if (i32 != 0) {
                        i28 |= 8192;
                    }
                    i33 = i5 & 32768;
                    if (i33 != 0) {
                        if ((i4 & 458752) == 0) {
                            if (composerStartRestartGroup.changed(function1)) {
                                i34 = 131072;
                            } else {
                                i34 = 65536;
                            }
                            i28 |= i34;
                        }
                        if ((i4 & 3670016) != 0) {
                            if ((i5 & 65536) == 0 || !composerStartRestartGroup.changed(textStyle)) {
                                i41 = 524288;
                            } else {
                                i41 = 1048576;
                            }
                            i28 |= i41;
                        }
                        if (i32 == 16384 || (1533916891 & i6) != 306783378 || (2995931 & i28) != 599186 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i42 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i7 != 0) {
                                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                                } else {
                                    jM1667getUnspecified0d7_KjU = j;
                                }
                                if (i9 != 0) {
                                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                                } else {
                                    jM4035getUnspecifiedXSAIIZE = j2;
                                }
                                if (i11 != 0) {
                                    fontStyle2 = null;
                                } else {
                                    fontStyle2 = fontStyle;
                                }
                                if (i13 != 0) {
                                    fontWeight2 = null;
                                } else {
                                    fontWeight2 = fontWeight;
                                }
                                if (i15 != 0) {
                                    fontFamily2 = null;
                                } else {
                                    fontFamily2 = fontFamily;
                                }
                                if (i17 != 0) {
                                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                                } else {
                                    jM4035getUnspecifiedXSAIIZE2 = j3;
                                }
                                if (i19 != 0) {
                                    textDecoration2 = null;
                                } else {
                                    textDecoration2 = textDecoration;
                                }
                                textAlign2 = i21 == 0 ? textAlign : null;
                                if (i23 != 0) {
                                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                                } else {
                                    jM4035getUnspecifiedXSAIIZE3 = j4;
                                }
                                if (i26 != 0) {
                                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                                } else {
                                    iM3784getClipgIe3tQ8 = i;
                                }
                                if (i29 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if (i31 != 0) {
                                    i35 = Integer.MAX_VALUE;
                                } else {
                                    i35 = i2;
                                }
                                if (i32 != 0) {
                                    mapEmptyMap = MapsKt.emptyMap();
                                    i28 &= -57345;
                                } else {
                                    mapEmptyMap = map;
                                }
                                if (i33 != 0) {
                                    textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                    textKt$Text$3 = function1;
                                }
                                if ((i5 & 65536) != 0) {
                                    TextDecoration textDecoration4 = textDecoration2;
                                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textStyle2 = (TextStyle) objConsume;
                                    i36 = i28 & (-3670017);
                                    textDecoration2 = textDecoration4;
                                } else {
                                    textStyle2 = textStyle;
                                    i36 = i28;
                                }
                                i37 = iM3784getClipgIe3tQ8;
                                map2 = mapEmptyMap;
                                i38 = i35;
                                z3 = z2;
                                j5 = jM4035getUnspecifiedXSAIIZE3;
                                j6 = jM4035getUnspecifiedXSAIIZE;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if (i32 != 0) {
                                    i28 &= -57345;
                                }
                                if ((i5 & 65536) != 0) {
                                    i28 &= -3670017;
                                }
                                companion = modifier;
                                jM1667getUnspecified0d7_KjU = j;
                                j6 = j2;
                                fontStyle2 = fontStyle;
                                fontWeight2 = fontWeight;
                                fontFamily2 = fontFamily;
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                                textDecoration2 = textDecoration;
                                textAlign2 = textAlign;
                                j5 = j4;
                                z3 = z;
                                i38 = i2;
                                map2 = map;
                                textKt$Text$3 = function1;
                                textStyle2 = textStyle;
                                i36 = i28;
                                i37 = i;
                            }
                            composerStartRestartGroup.endDefaults();
                            composerStartRestartGroup.startReplaceableGroup(1557618192);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                            if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                j7 = jM1667getUnspecified0d7_KjU;
                            } else {
                                jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    long jM1641unboximpl = ((Color) objConsume2).m1641unboximpl();
                                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localContentAlpha);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl, ((Number) objConsume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                }
                                j7 = jM3505getColor0d7_KjU;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            TextStyle textStyle4 = textStyle2;
                            int i43 = i36 << 9;
                            BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle4.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i43 & 57344) | (i43 & 458752) | (i43 & 3670016), 0);
                            modifier2 = companion;
                            textAlign3 = textAlign2;
                            function2 = textKt$Text$3;
                            fontFamily3 = fontFamily2;
                            i39 = i38;
                            map3 = map2;
                            textDecoration3 = textDecoration2;
                            z4 = z3;
                            FontWeight fontWeight4 = fontWeight2;
                            i40 = i37;
                            fontWeight3 = fontWeight4;
                            fontStyle3 = fontStyle2;
                            j8 = j6;
                            j9 = jM1667getUnspecified0d7_KjU;
                            j10 = jM4035getUnspecifiedXSAIIZE2;
                            textStyle3 = textStyle4;
                            j11 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            j9 = j;
                            j8 = j2;
                            fontStyle3 = fontStyle;
                            fontWeight3 = fontWeight;
                            fontFamily3 = fontFamily;
                            j10 = j3;
                            textDecoration3 = textDecoration;
                            textAlign3 = textAlign;
                            j11 = j4;
                            i40 = i;
                            z4 = z;
                            i39 = i2;
                            map3 = map;
                            function2 = function1;
                            textStyle3 = textStyle;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                            public final void invoke(Composer composer2, int i44) {
                                TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                            }
                        });
                    }
                    i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if ((i4 & 3670016) != 0) {
                        if ((i5 & 65536) == 0) {
                            i41 = 524288;
                        } else {
                            i41 = 524288;
                        }
                        i28 |= i41;
                    }
                    if (i32 == 16384) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration5 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal2 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composerStartRestartGroup.consume(providableCompositionLocal2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume4;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration5;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration6 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal3 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composerStartRestartGroup.consume(providableCompositionLocal3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume5;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration6;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composerStartRestartGroup.consume(localContentColor2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl2 = ((Color) objConsume6).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume7 = composerStartRestartGroup.consume(localContentAlpha2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl2, ((Number) objConsume7).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle5 = textStyle2;
                        int i44 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle5.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i44 & 57344) | (i44 & 458752) | (i44 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight5 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight5;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle5;
                        j11 = j5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration7 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal4 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume8 = composerStartRestartGroup.consume(providableCompositionLocal4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume8;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration7;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration8 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal5 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume9 = composerStartRestartGroup.consume(providableCompositionLocal5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume9;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration8;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume10 = composerStartRestartGroup.consume(localContentColor3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl3 = ((Color) objConsume10).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha3 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume11 = composerStartRestartGroup.consume(localContentAlpha3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl3, ((Number) objConsume11).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle6 = textStyle2;
                        int i45 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle6.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i45 & 57344) | (i45 & 458752) | (i45 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight6 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight6;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle6;
                        j11 = j5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                        public final void invoke(Composer composer2, int i46) {
                            TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= 3072;
                i32 = i5 & 16384;
                if (i32 != 0) {
                    i28 |= 8192;
                }
                i33 = i5 & 32768;
                if (i33 != 0) {
                    if ((i4 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(function1)) {
                            i34 = 131072;
                        } else {
                            i34 = 65536;
                        }
                        i28 |= i34;
                    }
                    if ((i4 & 3670016) != 0) {
                        if ((i5 & 65536) == 0) {
                            i41 = 524288;
                        } else {
                            i41 = 524288;
                        }
                        i28 |= i41;
                    }
                    if (i32 == 16384) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration9 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal6 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume12 = composerStartRestartGroup.consume(providableCompositionLocal6);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume12;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration9;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration10 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal7 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume13 = composerStartRestartGroup.consume(providableCompositionLocal7);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume13;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration10;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume14 = composerStartRestartGroup.consume(localContentColor4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl4 = ((Color) objConsume14).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha4 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume15 = composerStartRestartGroup.consume(localContentAlpha4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl4, ((Number) objConsume15).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle7 = textStyle2;
                        int i46 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle7.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i46 & 57344) | (i46 & 458752) | (i46 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight7 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight7;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle7;
                        j11 = j5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration11 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal8 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume16 = composerStartRestartGroup.consume(providableCompositionLocal8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume16;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration11;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration12 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal9 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume17 = composerStartRestartGroup.consume(providableCompositionLocal9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume17;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration12;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume18 = composerStartRestartGroup.consume(localContentColor5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl5 = ((Color) objConsume18).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha5 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume19 = composerStartRestartGroup.consume(localContentAlpha5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl5, ((Number) objConsume19).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle8 = textStyle2;
                        int i47 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle8.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i47 & 57344) | (i47 & 458752) | (i47 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight8 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight8;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle8;
                        j11 = j5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                        public final void invoke(Composer composer2, int i48) {
                            TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i4 & 3670016) != 0) {
                    if ((i5 & 65536) == 0) {
                        i41 = 524288;
                    } else {
                        i41 = 524288;
                    }
                    i28 |= i41;
                }
                if (i32 == 16384) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration13 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal10 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume110 = composerStartRestartGroup.consume(providableCompositionLocal10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume110;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration13;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration14 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111 = composerStartRestartGroup.consume(providableCompositionLocal11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume111;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration14;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume112 = composerStartRestartGroup.consume(localContentColor6);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl6 = ((Color) objConsume112).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha6 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume113 = composerStartRestartGroup.consume(localContentAlpha6);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl6, ((Number) objConsume113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle9 = textStyle2;
                    int i48 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle9.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i48 & 57344) | (i48 & 458752) | (i48 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight9 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight9;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle9;
                    j11 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration15 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal12 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume114 = composerStartRestartGroup.consume(providableCompositionLocal12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume114;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration15;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration16 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal13 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume115 = composerStartRestartGroup.consume(providableCompositionLocal13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume115;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration16;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume116 = composerStartRestartGroup.consume(localContentColor7);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl7 = ((Color) objConsume116).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha7 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume117 = composerStartRestartGroup.consume(localContentAlpha7);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl7, ((Number) objConsume117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle10 = textStyle2;
                    int i49 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle10.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i49 & 57344) | (i49 & 458752) | (i49 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight10 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight10;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle10;
                    j11 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                    public final void invoke(Composer composer2, int i410) {
                        TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 384;
            i31 = i5 & 8192;
            if (i31 != 0) {
                if ((i4 & 7168) == 0) {
                    i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
                }
                i32 = i5 & 16384;
                if (i32 != 0) {
                    i28 |= 8192;
                }
                i33 = i5 & 32768;
                if (i33 != 0) {
                    if ((i4 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(function1)) {
                            i34 = 131072;
                        } else {
                            i34 = 65536;
                        }
                        i28 |= i34;
                    }
                    if ((i4 & 3670016) != 0) {
                        if ((i5 & 65536) == 0) {
                            i41 = 524288;
                        } else {
                            i41 = 524288;
                        }
                        i28 |= i41;
                    }
                    if (i32 == 16384) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration17 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal14 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume118 = composerStartRestartGroup.consume(providableCompositionLocal14);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume118;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration17;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration18 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal15 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume119 = composerStartRestartGroup.consume(providableCompositionLocal15);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume119;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration18;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1110 = composerStartRestartGroup.consume(localContentColor8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl8 = ((Color) objConsume1110).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha8 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111 = composerStartRestartGroup.consume(localContentAlpha8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl8, ((Number) objConsume1111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle11 = textStyle2;
                        int i410 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle11.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i410 & 57344) | (i410 & 458752) | (i410 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight11 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight11;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle11;
                        j11 = j5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration19 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal16 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1112 = composerStartRestartGroup.consume(providableCompositionLocal16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1112;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration19;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration110 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal17 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1113 = composerStartRestartGroup.consume(providableCompositionLocal17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1113;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration110;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1114 = composerStartRestartGroup.consume(localContentColor9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl9 = ((Color) objConsume1114).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha9 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1115 = composerStartRestartGroup.consume(localContentAlpha9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl9, ((Number) objConsume1115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle12 = textStyle2;
                        int i411 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle12.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i411 & 57344) | (i411 & 458752) | (i411 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight12 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight12;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle12;
                        j11 = j5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                        public final void invoke(Composer composer2, int i412) {
                            TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i4 & 3670016) != 0) {
                    if ((i5 & 65536) == 0) {
                        i41 = 524288;
                    } else {
                        i41 = 524288;
                    }
                    i28 |= i41;
                }
                if (i32 == 16384) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration111 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal18 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1116 = composerStartRestartGroup.consume(providableCompositionLocal18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1116;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration111;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration112 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal19 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1117 = composerStartRestartGroup.consume(providableCompositionLocal19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1117;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration112;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1118 = composerStartRestartGroup.consume(localContentColor10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl10 = ((Color) objConsume1118).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha10 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1119 = composerStartRestartGroup.consume(localContentAlpha10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl10, ((Number) objConsume1119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle13 = textStyle2;
                    int i412 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle13.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i412 & 57344) | (i412 & 458752) | (i412 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight13 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight13;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle13;
                    j11 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration113 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal110 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11110 = composerStartRestartGroup.consume(providableCompositionLocal110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11110;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration113;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration114 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal111 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111 = composerStartRestartGroup.consume(providableCompositionLocal111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration114;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11112 = composerStartRestartGroup.consume(localContentColor11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl11 = ((Color) objConsume11112).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha11 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11113 = composerStartRestartGroup.consume(localContentAlpha11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl11, ((Number) objConsume11113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle14 = textStyle2;
                    int i413 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle14.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i413 & 57344) | (i413 & 458752) | (i413 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight14 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight14;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle14;
                    j11 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                    public final void invoke(Composer composer2, int i414) {
                        TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 3072;
            i32 = i5 & 16384;
            if (i32 != 0) {
                i28 |= 8192;
            }
            i33 = i5 & 32768;
            if (i33 != 0) {
                if ((i4 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(function1)) {
                        i34 = 131072;
                    } else {
                        i34 = 65536;
                    }
                    i28 |= i34;
                }
                if ((i4 & 3670016) != 0) {
                    if ((i5 & 65536) == 0) {
                        i41 = 524288;
                    } else {
                        i41 = 524288;
                    }
                    i28 |= i41;
                }
                if (i32 == 16384) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration115 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal112 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11114 = composerStartRestartGroup.consume(providableCompositionLocal112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11114;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration115;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration116 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal113 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11115 = composerStartRestartGroup.consume(providableCompositionLocal113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11115;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration116;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11116 = composerStartRestartGroup.consume(localContentColor12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl12 = ((Color) objConsume11116).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha12 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11117 = composerStartRestartGroup.consume(localContentAlpha12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl12, ((Number) objConsume11117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle15 = textStyle2;
                    int i414 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle15.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i414 & 57344) | (i414 & 458752) | (i414 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight15 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight15;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle15;
                    j11 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration117 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal114 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11118 = composerStartRestartGroup.consume(providableCompositionLocal114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11118;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration117;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration118 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal115 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11119 = composerStartRestartGroup.consume(providableCompositionLocal115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11119;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration118;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111110 = composerStartRestartGroup.consume(localContentColor13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl13 = ((Color) objConsume111110).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha13 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111 = composerStartRestartGroup.consume(localContentAlpha13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl13, ((Number) objConsume111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle16 = textStyle2;
                    int i415 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle16.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i415 & 57344) | (i415 & 458752) | (i415 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight16 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight16;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle16;
                    j11 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                    public final void invoke(Composer composer2, int i416) {
                        TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i4 & 3670016) != 0) {
                if ((i5 & 65536) == 0) {
                    i41 = 524288;
                } else {
                    i41 = 524288;
                }
                i28 |= i41;
            }
            if (i32 == 16384) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration119 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal116 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111112 = composerStartRestartGroup.consume(providableCompositionLocal116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111112;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration119;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration1110 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal117 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111113 = composerStartRestartGroup.consume(providableCompositionLocal117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111113;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration1110;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111114 = composerStartRestartGroup.consume(localContentColor14);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl14 = ((Color) objConsume111114).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha14 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111115 = composerStartRestartGroup.consume(localContentAlpha14);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl14, ((Number) objConsume111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle17 = textStyle2;
                int i416 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle17.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i416 & 57344) | (i416 & 458752) | (i416 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight17 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight17;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle17;
                j11 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration1111 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal118 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111116 = composerStartRestartGroup.consume(providableCompositionLocal118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111116;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration1111;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration1112 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal119 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111117 = composerStartRestartGroup.consume(providableCompositionLocal119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111117;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration1112;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111118 = composerStartRestartGroup.consume(localContentColor15);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl15 = ((Color) objConsume111118).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha15 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111119 = composerStartRestartGroup.consume(localContentAlpha15);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl15, ((Number) objConsume111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle18 = textStyle2;
                int i417 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle18.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i417 & 57344) | (i417 & 458752) | (i417 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight18 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight18;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle18;
                j11 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                public final void invoke(Composer composer2, int i418) {
                    TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i6 |= 48;
        i7 = i5 & 4;
        if (i7 != 0) {
            i6 |= 384;
        } else if ((i3 & 896) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i6 |= i8;
        }
        i9 = i5 & 8;
        if (i9 != 0) {
            i6 |= 3072;
        } else if ((i3 & 7168) == 0) {
            if (composerStartRestartGroup.changed(j2)) {
                i10 = 2048;
            } else {
                i10 = 1024;
            }
            i6 |= i10;
        }
        i11 = i5 & 16;
        if (i11 != 0) {
            i6 |= 24576;
        } else if ((i3 & 57344) == 0) {
            if (composerStartRestartGroup.changed(fontStyle)) {
                i12 = 16384;
            } else {
                i12 = 8192;
            }
            i6 |= i12;
        }
        i13 = i5 & 32;
        if (i13 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & 458752) == 0) {
            if (composerStartRestartGroup.changed(fontWeight)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i6 |= i14;
        }
        i15 = i5 & 64;
        if (i15 != 0) {
            i6 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(fontFamily)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i6 |= i16;
        }
        i17 = i5 & 128;
        if (i17 != 0) {
            i6 |= 12582912;
        } else if ((i3 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(j3)) {
                i18 = 8388608;
            } else {
                i18 = 4194304;
            }
            i6 |= i18;
        }
        i19 = i5 & 256;
        if (i19 != 0) {
            i6 |= 100663296;
        } else if ((i3 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(textDecoration)) {
                i20 = 67108864;
            } else {
                i20 = 33554432;
            }
            i6 |= i20;
        }
        i21 = i5 & 512;
        if (i21 != 0) {
            i6 |= C.ENCODING_PCM_32BIT;
        } else if ((i3 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(textAlign)) {
                i22 = 536870912;
            } else {
                i22 = 268435456;
            }
            i6 |= i22;
        }
        i23 = i5 & 1024;
        if (i23 != 0) {
            i24 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            if (composerStartRestartGroup.changed(j4)) {
                i25 = 4;
            } else {
                i25 = 2;
            }
            i24 = i4 | i25;
        } else {
            i24 = i4;
        }
        i26 = i5 & 2048;
        if (i26 != 0) {
            i24 |= 48;
        } else if ((i4 & 112) != 0) {
            if (composerStartRestartGroup.changed(i)) {
                i27 = 32;
            } else {
                i27 = 16;
            }
            i24 |= i27;
        }
        i28 = i24;
        i29 = i5 & 4096;
        if (i29 != 0) {
            if ((i4 & 896) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i30 = 256;
                } else {
                    i30 = 128;
                }
                i28 |= i30;
            }
            i31 = i5 & 8192;
            if (i31 != 0) {
                if ((i4 & 7168) == 0) {
                    i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
                }
                i32 = i5 & 16384;
                if (i32 != 0) {
                    i28 |= 8192;
                }
                i33 = i5 & 32768;
                if (i33 != 0) {
                    if ((i4 & 458752) == 0) {
                        if (composerStartRestartGroup.changed(function1)) {
                            i34 = 131072;
                        } else {
                            i34 = 65536;
                        }
                        i28 |= i34;
                    }
                    if ((i4 & 3670016) != 0) {
                        if ((i5 & 65536) == 0) {
                            i41 = 524288;
                        } else {
                            i41 = 524288;
                        }
                        i28 |= i41;
                    }
                    if (i32 == 16384) {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration1113 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1110 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111110 = composerStartRestartGroup.consume(providableCompositionLocal1110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111110;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration1113;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration1114 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1111 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111111 = composerStartRestartGroup.consume(providableCompositionLocal1111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111111;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration1114;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111112 = composerStartRestartGroup.consume(localContentColor16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl16 = ((Color) objConsume1111112).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha16 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111113 = composerStartRestartGroup.consume(localContentAlpha16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl16, ((Number) objConsume1111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle19 = textStyle2;
                        int i418 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle19.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i418 & 57344) | (i418 & 458752) | (i418 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight19 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight19;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle19;
                        j11 = j5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration1115 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1112 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111114 = composerStartRestartGroup.consume(providableCompositionLocal1112);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111114;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration1115;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        } else {
                            if (i42 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i7 != 0) {
                                jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                            } else {
                                jM1667getUnspecified0d7_KjU = j;
                            }
                            if (i9 != 0) {
                                jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE = j2;
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            } else {
                                fontStyle2 = fontStyle;
                            }
                            if (i13 != 0) {
                                fontWeight2 = null;
                            } else {
                                fontWeight2 = fontWeight;
                            }
                            if (i15 != 0) {
                                fontFamily2 = null;
                            } else {
                                fontFamily2 = fontFamily;
                            }
                            if (i17 != 0) {
                                jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE2 = j3;
                            }
                            if (i19 != 0) {
                                textDecoration2 = null;
                            } else {
                                textDecoration2 = textDecoration;
                            }
                            if (i21 == 0) {
                            }
                            if (i23 != 0) {
                                jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                            } else {
                                jM4035getUnspecifiedXSAIIZE3 = j4;
                            }
                            if (i26 != 0) {
                                iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                            } else {
                                iM3784getClipgIe3tQ8 = i;
                            }
                            if (i29 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i31 != 0) {
                                i35 = Integer.MAX_VALUE;
                            } else {
                                i35 = i2;
                            }
                            if (i32 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            if (i33 != 0) {
                                textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                                textKt$Text$3 = function1;
                            }
                            if ((i5 & 65536) != 0) {
                                TextDecoration textDecoration1116 = textDecoration2;
                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal1113 = LocalTextStyle;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111115 = composerStartRestartGroup.consume(providableCompositionLocal1113);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textStyle2 = (TextStyle) objConsume1111115;
                                i36 = i28 & (-3670017);
                                textDecoration2 = textDecoration1116;
                            } else {
                                textStyle2 = textStyle;
                                i36 = i28;
                            }
                            i37 = iM3784getClipgIe3tQ8;
                            map2 = mapEmptyMap;
                            i38 = i35;
                            z3 = z2;
                            j5 = jM4035getUnspecifiedXSAIIZE3;
                            j6 = jM4035getUnspecifiedXSAIIZE;
                        }
                        composerStartRestartGroup.endDefaults();
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                        if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            j7 = jM1667getUnspecified0d7_KjU;
                        } else {
                            jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                                ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111116 = composerStartRestartGroup.consume(localContentColor17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM1641unboximpl17 = ((Color) objConsume1111116).m1641unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha17 = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object objConsume1111117 = composerStartRestartGroup.consume(localContentAlpha17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl17, ((Number) objConsume1111117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j7 = jM3505getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextStyle textStyle110 = textStyle2;
                        int i419 = i36 << 9;
                        BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle110.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i419 & 57344) | (i419 & 458752) | (i419 & 3670016), 0);
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function2 = textKt$Text$3;
                        fontFamily3 = fontFamily2;
                        i39 = i38;
                        map3 = map2;
                        textDecoration3 = textDecoration2;
                        z4 = z3;
                        FontWeight fontWeight110 = fontWeight2;
                        i40 = i37;
                        fontWeight3 = fontWeight110;
                        fontStyle3 = fontStyle2;
                        j8 = j6;
                        j9 = jM1667getUnspecified0d7_KjU;
                        j10 = jM4035getUnspecifiedXSAIIZE2;
                        textStyle3 = textStyle110;
                        j11 = j5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                        public final void invoke(Composer composer2, int i4110) {
                            TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                        }
                    });
                }
                i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i4 & 3670016) != 0) {
                    if ((i5 & 65536) == 0) {
                        i41 = 524288;
                    } else {
                        i41 = 524288;
                    }
                    i28 |= i41;
                }
                if (i32 == 16384) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration1117 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1114 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111118 = composerStartRestartGroup.consume(providableCompositionLocal1114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111118;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration1117;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration1118 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1115 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111119 = composerStartRestartGroup.consume(providableCompositionLocal1115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111119;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration1118;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111110 = composerStartRestartGroup.consume(localContentColor18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl18 = ((Color) objConsume11111110).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha18 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111111 = composerStartRestartGroup.consume(localContentAlpha18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl18, ((Number) objConsume11111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle111 = textStyle2;
                    int i4110 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle111.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4110 & 57344) | (i4110 & 458752) | (i4110 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight111 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight111;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle111;
                    j11 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration1119 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1116 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111112 = composerStartRestartGroup.consume(providableCompositionLocal1116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111112;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration1119;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration11110 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1117 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111113 = composerStartRestartGroup.consume(providableCompositionLocal1117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111113;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration11110;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111114 = composerStartRestartGroup.consume(localContentColor19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl19 = ((Color) objConsume11111114).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha19 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111115 = composerStartRestartGroup.consume(localContentAlpha19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl19, ((Number) objConsume11111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle112 = textStyle2;
                    int i4111 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle112.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4111 & 57344) | (i4111 & 458752) | (i4111 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight112 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight112;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle112;
                    j11 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                    public final void invoke(Composer composer2, int i4112) {
                        TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= 3072;
            i32 = i5 & 16384;
            if (i32 != 0) {
                i28 |= 8192;
            }
            i33 = i5 & 32768;
            if (i33 != 0) {
                if ((i4 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(function1)) {
                        i34 = 131072;
                    } else {
                        i34 = 65536;
                    }
                    i28 |= i34;
                }
                if ((i4 & 3670016) != 0) {
                    if ((i5 & 65536) == 0) {
                        i41 = 524288;
                    } else {
                        i41 = 524288;
                    }
                    i28 |= i41;
                }
                if (i32 == 16384) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration11111 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1118 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111116 = composerStartRestartGroup.consume(providableCompositionLocal1118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111116;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration11111;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration11112 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal1119 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111117 = composerStartRestartGroup.consume(providableCompositionLocal1119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume11111117;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration11112;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111118 = composerStartRestartGroup.consume(localContentColor110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl110 = ((Color) objConsume11111118).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha110 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume11111119 = composerStartRestartGroup.consume(localContentAlpha110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl110, ((Number) objConsume11111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle113 = textStyle2;
                    int i4112 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle113.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4112 & 57344) | (i4112 & 458752) | (i4112 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight113 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight113;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle113;
                    j11 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration11113 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11110 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111110 = composerStartRestartGroup.consume(providableCompositionLocal11110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume111111110;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration11113;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration11114 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11111 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111111 = composerStartRestartGroup.consume(providableCompositionLocal11111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume111111111;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration11114;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111112 = composerStartRestartGroup.consume(localContentColor111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl111 = ((Color) objConsume111111112).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha111 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume111111113 = composerStartRestartGroup.consume(localContentAlpha111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl111, ((Number) objConsume111111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle114 = textStyle2;
                    int i4113 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle114.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4113 & 57344) | (i4113 & 458752) | (i4113 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight114 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight114;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle114;
                    j11 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                    public final void invoke(Composer composer2, int i4114) {
                        TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i4 & 3670016) != 0) {
                if ((i5 & 65536) == 0) {
                    i41 = 524288;
                } else {
                    i41 = 524288;
                }
                i28 |= i41;
            }
            if (i32 == 16384) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration11115 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11112 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111114 = composerStartRestartGroup.consume(providableCompositionLocal11112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111114;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration11115;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration11116 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11113 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111115 = composerStartRestartGroup.consume(providableCompositionLocal11113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111115;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration11116;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111116 = composerStartRestartGroup.consume(localContentColor112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl112 = ((Color) objConsume111111116).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha112 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111117 = composerStartRestartGroup.consume(localContentAlpha112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl112, ((Number) objConsume111111117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle115 = textStyle2;
                int i4114 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle115.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4114 & 57344) | (i4114 & 458752) | (i4114 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight115 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight115;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle115;
                j11 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration11117 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11114 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111118 = composerStartRestartGroup.consume(providableCompositionLocal11114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111118;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration11117;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration11118 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal11115 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111119 = composerStartRestartGroup.consume(providableCompositionLocal11115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111119;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration11118;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111110 = composerStartRestartGroup.consume(localContentColor113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl113 = ((Color) objConsume1111111110).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha113 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111111 = composerStartRestartGroup.consume(localContentAlpha113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl113, ((Number) objConsume1111111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle116 = textStyle2;
                int i4115 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle116.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4115 & 57344) | (i4115 & 458752) | (i4115 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight116 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight116;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle116;
                j11 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                public final void invoke(Composer composer2, int i4116) {
                    TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i28 |= 384;
        i31 = i5 & 8192;
        if (i31 != 0) {
            if ((i4 & 7168) == 0) {
                i28 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
            }
            i32 = i5 & 16384;
            if (i32 != 0) {
                i28 |= 8192;
            }
            i33 = i5 & 32768;
            if (i33 != 0) {
                if ((i4 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(function1)) {
                        i34 = 131072;
                    } else {
                        i34 = 65536;
                    }
                    i28 |= i34;
                }
                if ((i4 & 3670016) != 0) {
                    if ((i5 & 65536) == 0) {
                        i41 = 524288;
                    } else {
                        i41 = 524288;
                    }
                    i28 |= i41;
                }
                if (i32 == 16384) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration11119 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11116 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111112 = composerStartRestartGroup.consume(providableCompositionLocal11116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111112;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration11119;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration111110 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11117 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111113 = composerStartRestartGroup.consume(providableCompositionLocal11117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111113;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration111110;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111114 = composerStartRestartGroup.consume(localContentColor114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl114 = ((Color) objConsume1111111114).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha114 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111115 = composerStartRestartGroup.consume(localContentAlpha114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl114, ((Number) objConsume1111111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle117 = textStyle2;
                    int i4116 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle117.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4116 & 57344) | (i4116 & 458752) | (i4116 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight117 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight117;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle117;
                    j11 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration111111 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11118 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111116 = composerStartRestartGroup.consume(providableCompositionLocal11118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111116;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration111111;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    } else {
                        if (i42 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i7 != 0) {
                            jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                        } else {
                            jM1667getUnspecified0d7_KjU = j;
                        }
                        if (i9 != 0) {
                            jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE = j2;
                        }
                        if (i11 != 0) {
                            fontStyle2 = null;
                        } else {
                            fontStyle2 = fontStyle;
                        }
                        if (i13 != 0) {
                            fontWeight2 = null;
                        } else {
                            fontWeight2 = fontWeight;
                        }
                        if (i15 != 0) {
                            fontFamily2 = null;
                        } else {
                            fontFamily2 = fontFamily;
                        }
                        if (i17 != 0) {
                            jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE2 = j3;
                        }
                        if (i19 != 0) {
                            textDecoration2 = null;
                        } else {
                            textDecoration2 = textDecoration;
                        }
                        if (i21 == 0) {
                        }
                        if (i23 != 0) {
                            jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                        } else {
                            jM4035getUnspecifiedXSAIIZE3 = j4;
                        }
                        if (i26 != 0) {
                            iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                        } else {
                            iM3784getClipgIe3tQ8 = i;
                        }
                        if (i29 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i31 != 0) {
                            i35 = Integer.MAX_VALUE;
                        } else {
                            i35 = i2;
                        }
                        if (i32 != 0) {
                            mapEmptyMap = MapsKt.emptyMap();
                            i28 &= -57345;
                        } else {
                            mapEmptyMap = map;
                        }
                        if (i33 != 0) {
                            textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                            textKt$Text$3 = function1;
                        }
                        if ((i5 & 65536) != 0) {
                            TextDecoration textDecoration111112 = textDecoration2;
                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal11119 = LocalTextStyle;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111117 = composerStartRestartGroup.consume(providableCompositionLocal11119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume1111111117;
                            i36 = i28 & (-3670017);
                            textDecoration2 = textDecoration111112;
                        } else {
                            textStyle2 = textStyle;
                            i36 = i28;
                        }
                        i37 = iM3784getClipgIe3tQ8;
                        map2 = mapEmptyMap;
                        i38 = i35;
                        z3 = z2;
                        j5 = jM4035getUnspecifiedXSAIIZE3;
                        j6 = jM4035getUnspecifiedXSAIIZE;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(1557618192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                    if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        j7 = jM1667getUnspecified0d7_KjU;
                    } else {
                        jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                        if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                            ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111118 = composerStartRestartGroup.consume(localContentColor115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long jM1641unboximpl115 = ((Color) objConsume1111111118).m1641unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha115 = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume1111111119 = composerStartRestartGroup.consume(localContentAlpha115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl115, ((Number) objConsume1111111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        j7 = jM3505getColor0d7_KjU;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextStyle textStyle118 = textStyle2;
                    int i4117 = i36 << 9;
                    BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle118.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4117 & 57344) | (i4117 & 458752) | (i4117 & 3670016), 0);
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function2 = textKt$Text$3;
                    fontFamily3 = fontFamily2;
                    i39 = i38;
                    map3 = map2;
                    textDecoration3 = textDecoration2;
                    z4 = z3;
                    FontWeight fontWeight118 = fontWeight2;
                    i40 = i37;
                    fontWeight3 = fontWeight118;
                    fontStyle3 = fontStyle2;
                    j8 = j6;
                    j9 = jM1667getUnspecified0d7_KjU;
                    j10 = jM4035getUnspecifiedXSAIIZE2;
                    textStyle3 = textStyle118;
                    j11 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                    public final void invoke(Composer composer2, int i4118) {
                        TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                    }
                });
            }
            i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i4 & 3670016) != 0) {
                if ((i5 & 65536) == 0) {
                    i41 = 524288;
                } else {
                    i41 = 524288;
                }
                i28 |= i41;
            }
            if (i32 == 16384) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111113 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111110 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111110 = composerStartRestartGroup.consume(providableCompositionLocal111110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111110;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111113;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111114 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111111 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111111 = composerStartRestartGroup.consume(providableCompositionLocal111111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111111;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111114;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111112 = composerStartRestartGroup.consume(localContentColor116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl116 = ((Color) objConsume11111111112).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha116 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111113 = composerStartRestartGroup.consume(localContentAlpha116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl116, ((Number) objConsume11111111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle119 = textStyle2;
                int i4118 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle119.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4118 & 57344) | (i4118 & 458752) | (i4118 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight119 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight119;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle119;
                j11 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111115 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111112 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111114 = composerStartRestartGroup.consume(providableCompositionLocal111112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111114;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111115;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111116 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111113 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111115 = composerStartRestartGroup.consume(providableCompositionLocal111113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111115;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111116;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111116 = composerStartRestartGroup.consume(localContentColor117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl117 = ((Color) objConsume11111111116).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha117 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111117 = composerStartRestartGroup.consume(localContentAlpha117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl117, ((Number) objConsume11111111117).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle1110 = textStyle2;
                int i4119 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle1110.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i4119 & 57344) | (i4119 & 458752) | (i4119 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight1110 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight1110;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle1110;
                j11 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                public final void invoke(Composer composer2, int i41110) {
                    TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i28 |= 3072;
        i32 = i5 & 16384;
        if (i32 != 0) {
            i28 |= 8192;
        }
        i33 = i5 & 32768;
        if (i33 != 0) {
            if ((i4 & 458752) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i34 = 131072;
                } else {
                    i34 = 65536;
                }
                i28 |= i34;
            }
            if ((i4 & 3670016) != 0) {
                if ((i5 & 65536) == 0) {
                    i41 = 524288;
                } else {
                    i41 = 524288;
                }
                i28 |= i41;
            }
            if (i32 == 16384) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111117 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111114 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111118 = composerStartRestartGroup.consume(providableCompositionLocal111114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111118;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111117;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111118 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111115 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume11111111119 = composerStartRestartGroup.consume(providableCompositionLocal111115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume11111111119;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111118;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111110 = composerStartRestartGroup.consume(localContentColor118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl118 = ((Color) objConsume111111111110).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha118 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111111 = composerStartRestartGroup.consume(localContentAlpha118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl118, ((Number) objConsume111111111111).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle1111 = textStyle2;
                int i41110 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle1111.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i41110 & 57344) | (i41110 & 458752) | (i41110 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight1111 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight1111;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle1111;
                j11 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration111119 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111116 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111112 = composerStartRestartGroup.consume(providableCompositionLocal111116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111111112;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration111119;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                } else {
                    if (i42 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i7 != 0) {
                        jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                    } else {
                        jM1667getUnspecified0d7_KjU = j;
                    }
                    if (i9 != 0) {
                        jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE = j2;
                    }
                    if (i11 != 0) {
                        fontStyle2 = null;
                    } else {
                        fontStyle2 = fontStyle;
                    }
                    if (i13 != 0) {
                        fontWeight2 = null;
                    } else {
                        fontWeight2 = fontWeight;
                    }
                    if (i15 != 0) {
                        fontFamily2 = null;
                    } else {
                        fontFamily2 = fontFamily;
                    }
                    if (i17 != 0) {
                        jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE2 = j3;
                    }
                    if (i19 != 0) {
                        textDecoration2 = null;
                    } else {
                        textDecoration2 = textDecoration;
                    }
                    if (i21 == 0) {
                    }
                    if (i23 != 0) {
                        jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                    } else {
                        jM4035getUnspecifiedXSAIIZE3 = j4;
                    }
                    if (i26 != 0) {
                        iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                    } else {
                        iM3784getClipgIe3tQ8 = i;
                    }
                    if (i29 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i31 != 0) {
                        i35 = Integer.MAX_VALUE;
                    } else {
                        i35 = i2;
                    }
                    if (i32 != 0) {
                        mapEmptyMap = MapsKt.emptyMap();
                        i28 &= -57345;
                    } else {
                        mapEmptyMap = map;
                    }
                    if (i33 != 0) {
                        textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                        textKt$Text$3 = function1;
                    }
                    if ((i5 & 65536) != 0) {
                        TextDecoration textDecoration1111110 = textDecoration2;
                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal111117 = LocalTextStyle;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111113 = composerStartRestartGroup.consume(providableCompositionLocal111117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume111111111113;
                        i36 = i28 & (-3670017);
                        textDecoration2 = textDecoration1111110;
                    } else {
                        textStyle2 = textStyle;
                        i36 = i28;
                    }
                    i37 = iM3784getClipgIe3tQ8;
                    map2 = mapEmptyMap;
                    i38 = i35;
                    z3 = z2;
                    j5 = jM4035getUnspecifiedXSAIIZE3;
                    j6 = jM4035getUnspecifiedXSAIIZE;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(1557618192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
                if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    j7 = jM1667getUnspecified0d7_KjU;
                } else {
                    jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111114 = composerStartRestartGroup.consume(localContentColor119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long jM1641unboximpl119 = ((Color) objConsume111111111114).m1641unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha119 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume111111111115 = composerStartRestartGroup.consume(localContentAlpha119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl119, ((Number) objConsume111111111115).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    j7 = jM3505getColor0d7_KjU;
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextStyle textStyle1112 = textStyle2;
                int i41111 = i36 << 9;
                BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle1112.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i41111 & 57344) | (i41111 & 458752) | (i41111 & 3670016), 0);
                modifier2 = companion;
                textAlign3 = textAlign2;
                function2 = textKt$Text$3;
                fontFamily3 = fontFamily2;
                i39 = i38;
                map3 = map2;
                textDecoration3 = textDecoration2;
                z4 = z3;
                FontWeight fontWeight1112 = fontWeight2;
                i40 = i37;
                fontWeight3 = fontWeight1112;
                fontStyle3 = fontStyle2;
                j8 = j6;
                j9 = jM1667getUnspecified0d7_KjU;
                j10 = jM4035getUnspecifiedXSAIIZE2;
                textStyle3 = textStyle1112;
                j11 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                public final void invoke(Composer composer2, int i41112) {
                    TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
                }
            });
        }
        i28 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((i4 & 3670016) != 0) {
            if ((i5 & 65536) == 0) {
                i41 = 524288;
            } else {
                i41 = 524288;
            }
            i28 |= i41;
        }
        if (i32 == 16384) {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i42 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i35 = Integer.MAX_VALUE;
                } else {
                    i35 = i2;
                }
                if (i32 != 0) {
                    mapEmptyMap = MapsKt.emptyMap();
                    i28 &= -57345;
                } else {
                    mapEmptyMap = map;
                }
                if (i33 != 0) {
                    textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                    textKt$Text$3 = function1;
                }
                if ((i5 & 65536) != 0) {
                    TextDecoration textDecoration1111111 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal111118 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111116 = composerStartRestartGroup.consume(providableCompositionLocal111118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume111111111116;
                    i36 = i28 & (-3670017);
                    textDecoration2 = textDecoration1111111;
                } else {
                    textStyle2 = textStyle;
                    i36 = i28;
                }
                i37 = iM3784getClipgIe3tQ8;
                map2 = mapEmptyMap;
                i38 = i35;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            } else {
                if (i42 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i35 = Integer.MAX_VALUE;
                } else {
                    i35 = i2;
                }
                if (i32 != 0) {
                    mapEmptyMap = MapsKt.emptyMap();
                    i28 &= -57345;
                } else {
                    mapEmptyMap = map;
                }
                if (i33 != 0) {
                    textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                    textKt$Text$3 = function1;
                }
                if ((i5 & 65536) != 0) {
                    TextDecoration textDecoration1111112 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal111119 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111117 = composerStartRestartGroup.consume(providableCompositionLocal111119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume111111111117;
                    i36 = i28 & (-3670017);
                    textDecoration2 = textDecoration1111112;
                } else {
                    textStyle2 = textStyle;
                    i36 = i28;
                }
                i37 = iM3784getClipgIe3tQ8;
                map2 = mapEmptyMap;
                i38 = i35;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1557618192);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
            if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                j7 = jM1667getUnspecified0d7_KjU;
            } else {
                jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111118 = composerStartRestartGroup.consume(localContentColor1110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long jM1641unboximpl1110 = ((Color) objConsume111111111118).m1641unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha1110 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111119 = composerStartRestartGroup.consume(localContentAlpha1110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl1110, ((Number) objConsume111111111119).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                }
                j7 = jM3505getColor0d7_KjU;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyle1113 = textStyle2;
            int i41112 = i36 << 9;
            BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle1113.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i41112 & 57344) | (i41112 & 458752) | (i41112 & 3670016), 0);
            modifier2 = companion;
            textAlign3 = textAlign2;
            function2 = textKt$Text$3;
            fontFamily3 = fontFamily2;
            i39 = i38;
            map3 = map2;
            textDecoration3 = textDecoration2;
            z4 = z3;
            FontWeight fontWeight1113 = fontWeight2;
            i40 = i37;
            fontWeight3 = fontWeight1113;
            fontStyle3 = fontStyle2;
            j8 = j6;
            j9 = jM1667getUnspecified0d7_KjU;
            j10 = jM4035getUnspecifiedXSAIIZE2;
            textStyle3 = textStyle1113;
            j11 = j5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i42 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i35 = Integer.MAX_VALUE;
                } else {
                    i35 = i2;
                }
                if (i32 != 0) {
                    mapEmptyMap = MapsKt.emptyMap();
                    i28 &= -57345;
                } else {
                    mapEmptyMap = map;
                }
                if (i33 != 0) {
                    textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                    textKt$Text$3 = function1;
                }
                if ((i5 & 65536) != 0) {
                    TextDecoration textDecoration1111113 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal1111110 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111110 = composerStartRestartGroup.consume(providableCompositionLocal1111110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume1111111111110;
                    i36 = i28 & (-3670017);
                    textDecoration2 = textDecoration1111113;
                } else {
                    textStyle2 = textStyle;
                    i36 = i28;
                }
                i37 = iM3784getClipgIe3tQ8;
                map2 = mapEmptyMap;
                i38 = i35;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            } else {
                if (i42 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i7 != 0) {
                    jM1667getUnspecified0d7_KjU = Color.INSTANCE.m1667getUnspecified0d7_KjU();
                } else {
                    jM1667getUnspecified0d7_KjU = j;
                }
                if (i9 != 0) {
                    jM4035getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE = j2;
                }
                if (i11 != 0) {
                    fontStyle2 = null;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (i13 != 0) {
                    fontWeight2 = null;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (i15 != 0) {
                    fontFamily2 = null;
                } else {
                    fontFamily2 = fontFamily;
                }
                if (i17 != 0) {
                    jM4035getUnspecifiedXSAIIZE2 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE2 = j3;
                }
                if (i19 != 0) {
                    textDecoration2 = null;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (i21 == 0) {
                }
                if (i23 != 0) {
                    jM4035getUnspecifiedXSAIIZE3 = TextUnit.INSTANCE.m4035getUnspecifiedXSAIIZE();
                } else {
                    jM4035getUnspecifiedXSAIIZE3 = j4;
                }
                if (i26 != 0) {
                    iM3784getClipgIe3tQ8 = TextOverflow.INSTANCE.m3784getClipgIe3tQ8();
                } else {
                    iM3784getClipgIe3tQ8 = i;
                }
                if (i29 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i31 != 0) {
                    i35 = Integer.MAX_VALUE;
                } else {
                    i35 = i2;
                }
                if (i32 != 0) {
                    mapEmptyMap = MapsKt.emptyMap();
                    i28 &= -57345;
                } else {
                    mapEmptyMap = map;
                }
                if (i33 != 0) {
                    textKt$Text$3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
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
                    textKt$Text$3 = function1;
                }
                if ((i5 & 65536) != 0) {
                    TextDecoration textDecoration1111114 = textDecoration2;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal1111111 = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111111 = composerStartRestartGroup.consume(providableCompositionLocal1111111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume1111111111111;
                    i36 = i28 & (-3670017);
                    textDecoration2 = textDecoration1111114;
                } else {
                    textStyle2 = textStyle;
                    i36 = i28;
                }
                i37 = iM3784getClipgIe3tQ8;
                map2 = mapEmptyMap;
                i38 = i35;
                z3 = z2;
                j5 = jM4035getUnspecifiedXSAIIZE3;
                j6 = jM4035getUnspecifiedXSAIIZE;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(1557618192);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@10767L7,214@10806L7");
            if (jM1667getUnspecified0d7_KjU != Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                j7 = jM1667getUnspecified0d7_KjU;
            } else {
                jM3505getColor0d7_KjU = textStyle2.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111112 = composerStartRestartGroup.consume(localContentColor1111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long jM1641unboximpl1111 = ((Color) objConsume1111111111112).m1641unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha1111 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111111113 = composerStartRestartGroup.consume(localContentAlpha1111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM3505getColor0d7_KjU = Color.m1630copywmQWz5c$default(jM1641unboximpl1111, ((Number) objConsume1111111111113).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                }
                j7 = jM3505getColor0d7_KjU;
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextStyle textStyle1114 = textStyle2;
            int i41113 = i36 << 9;
            BasicTextKt.m684BasicText4YKlhWE(text, companion, textStyle1114.merge(new TextStyle(j7, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jM4035getUnspecifiedXSAIIZE2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j5, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), textKt$Text$3, i37, z3, i38, map2, composerStartRestartGroup, (i6 & 112) | (i6 & 14) | 16777216 | ((i36 >> 6) & 7168) | (i41113 & 57344) | (i41113 & 458752) | (i41113 & 3670016), 0);
            modifier2 = companion;
            textAlign3 = textAlign2;
            function2 = textKt$Text$3;
            fontFamily3 = fontFamily2;
            i39 = i38;
            map3 = map2;
            textDecoration3 = textDecoration2;
            z4 = z3;
            FontWeight fontWeight1114 = fontWeight2;
            i40 = i37;
            fontWeight3 = fontWeight1114;
            fontStyle3 = fontStyle2;
            j8 = j6;
            j9 = jM1667getUnspecified0d7_KjU;
            j10 = jM4035getUnspecifiedXSAIIZE2;
            textStyle3 = textStyle1114;
            j11 = j5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

            public final void invoke(Composer composer2, int i41114) {
                TextKt.m1245Text4IGK_g(text, modifier2, j9, j8, fontStyle3, fontWeight3, fontFamily3, j10, textDecoration3, textAlign3, j11, i40, z4, i39, map3, function2, textStyle3, composer2, i3 | 1, i4, i5);
            }
        });
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideTextStyle)P(1)263@12533L7,264@12558L80:Text.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) objConsume).merge(value))}, content, composerStartRestartGroup, (i2 & 112) | 8);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt.ProvideTextStyle.1
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

            public final void invoke(Composer composer2, int i3) {
                TextKt.ProvideTextStyle(value, content, composer2, i | 1);
            }
        });
    }
}
