package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020-2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u009a\u0001\u0010/\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\u00107\u001a]\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a\u0014\u0010L\u001a\u00020\u0010*\u00020\u00102\u0006\u0010M\u001a\u00020NH\u0000\u001at\u0010O\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u000204H\u0002\u001aZ\u0010[\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010\\\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", TextFieldImplKt.TextFieldId, "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m3843constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m3843constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m3843constructorimpl(4);

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
    /* JADX WARN: Code duplicated, block: B:119:0x0179  */
    /* JADX WARN: Code duplicated, block: B:121:0x017f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0185  */
    /* JADX WARN: Code duplicated, block: B:124:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:130:0x0194  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:156:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:161:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:163:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:165:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:166:0x0200  */
    /* JADX WARN: Code duplicated, block: B:170:0x0208  */
    /* JADX WARN: Code duplicated, block: B:171:0x020f  */
    /* JADX WARN: Code duplicated, block: B:173:0x0215  */
    /* JADX WARN: Code duplicated, block: B:175:0x021b  */
    /* JADX WARN: Code duplicated, block: B:176:0x021e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0226  */
    /* JADX WARN: Code duplicated, block: B:182:0x022c  */
    /* JADX WARN: Code duplicated, block: B:185:0x0235  */
    /* JADX WARN: Code duplicated, block: B:187:0x023a  */
    /* JADX WARN: Code duplicated, block: B:190:0x0240  */
    /* JADX WARN: Code duplicated, block: B:192:0x0248  */
    /* JADX WARN: Code duplicated, block: B:195:0x0251  */
    /* JADX WARN: Code duplicated, block: B:197:0x0256  */
    /* JADX WARN: Code duplicated, block: B:200:0x0262  */
    /* JADX WARN: Code duplicated, block: B:206:0x029b  */
    /* JADX WARN: Code duplicated, block: B:208:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:227:0x02f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:228:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:229:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:231:0x0300  */
    /* JADX WARN: Code duplicated, block: B:232:0x0302  */
    /* JADX WARN: Code duplicated, block: B:234:0x0306  */
    /* JADX WARN: Code duplicated, block: B:235:0x0308  */
    /* JADX WARN: Code duplicated, block: B:238:0x030e  */
    /* JADX WARN: Code duplicated, block: B:239:0x0330  */
    /* JADX WARN: Code duplicated, block: B:241:0x0338  */
    /* JADX WARN: Code duplicated, block: B:242:0x033a  */
    /* JADX WARN: Code duplicated, block: B:244:0x033e  */
    /* JADX WARN: Code duplicated, block: B:245:0x0340  */
    /* JADX WARN: Code duplicated, block: B:247:0x0344  */
    /* JADX WARN: Code duplicated, block: B:248:0x0346  */
    /* JADX WARN: Code duplicated, block: B:250:0x034a  */
    /* JADX WARN: Code duplicated, block: B:251:0x034c  */
    /* JADX WARN: Code duplicated, block: B:253:0x0350  */
    /* JADX WARN: Code duplicated, block: B:254:0x0352  */
    /* JADX WARN: Code duplicated, block: B:256:0x0356  */
    /* JADX WARN: Code duplicated, block: B:257:0x035d  */
    /* JADX WARN: Code duplicated, block: B:260:0x0363  */
    /* JADX WARN: Code duplicated, block: B:261:0x036c  */
    /* JADX WARN: Code duplicated, block: B:264:0x0374  */
    /* JADX WARN: Code duplicated, block: B:265:0x039e  */
    /* JADX WARN: Code duplicated, block: B:267:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:268:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:270:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:271:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:274:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:276:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:278:0x03da  */
    /* JADX WARN: Code duplicated, block: B:281:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:282:0x0419  */
    /* JADX WARN: Code duplicated, block: B:285:0x0422  */
    /* JADX WARN: Code duplicated, block: B:286:0x0469  */
    /* JADX WARN: Code duplicated, block: B:291:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:296:0x0604  */
    /* JADX WARN: Code duplicated, block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x0096  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:80:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0117  */
    /* JADX WARN: Code duplicated, block: B:88:0x011e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013c  */
    public static final void TextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
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
        Modifier.Companion companion;
        boolean z5;
        boolean z6;
        TextStyle textStyle2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        boolean z7;
        VisualTransformation none;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean z8;
        int i29;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource2;
        CornerBasedShape cornerBasedShapeCopy$default;
        TextFieldColors textFieldColorsM1226textFieldColorsdx8h9Zs;
        Function2<? super Composer, ? super Integer, Unit> function10;
        VisualTransformation visualTransformation2;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        boolean z9;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        Modifier modifier2;
        boolean z11;
        TextStyle textStyle3;
        Shape shape2;
        Object objRememberedValue;
        long jM3505getColor0d7_KjU;
        Composer composer2;
        final boolean z12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final Function2<? super Composer, ? super Integer, Unit> function16;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions4;
        final boolean z13;
        final MutableInteractionSource mutableInteractionSource3;
        final TextFieldColors textFieldColors2;
        final Shape shape3;
        final boolean z14;
        final TextStyle textStyle4;
        final boolean z15;
        final Modifier modifier3;
        final int i30;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i31;
        int i32;
        int i33;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)163@8397L7,174@8951L39,176@9033L6,177@9158L17,189@9576L24,199@10014L20,186@9478L1542:TextField.kt#jmzs0o");
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
        int i34 = i4 & 4;
        if (i34 == 0) {
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
                if ((i2 & 458752) != 0) {
                    if ((i4 & 32) == 0 || !composerStartRestartGroup.changed(textStyle)) {
                        i33 = 65536;
                    } else {
                        i33 = 131072;
                    }
                    i5 |= i33;
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 128;
                if (i12 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 256;
                if (i14 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(function4)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i5 |= i15;
                }
                i16 = i4 & 512;
                if (i16 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(function5)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                    i5 |= i17;
                }
                i18 = i4 & 1024;
                if (i18 != 0) {
                    i19 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i20 = 4;
                    } else {
                        i20 = 2;
                    }
                    i19 = i3 | i20;
                } else {
                    i19 = i3;
                }
                i21 = i4 & 2048;
                if (i21 != 0) {
                    i19 |= 48;
                } else if ((i3 & 112) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i22 = 32;
                    } else {
                        i22 = 16;
                    }
                    i19 |= i22;
                }
                if ((i3 & 896) != 0) {
                    i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
                }
                if ((i3 & 7168) != 0) {
                    i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
                }
                i23 = i19;
                i24 = i4 & 16384;
                if (i24 != 0) {
                    i23 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                i25 = i4 & 32768;
                if (i25 != 0) {
                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i23 |= i26;
                }
                i27 = i4 & 65536;
                if (i27 != 0) {
                    i23 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i23 |= i28;
                }
                if ((i3 & 29360128) != 0) {
                    if ((i4 & 131072) == 0 || !composerStartRestartGroup.changed(shape)) {
                        i32 = 4194304;
                    } else {
                        i32 = 8388608;
                    }
                    i23 |= i32;
                }
                if ((i3 & 234881024) != 0) {
                    if ((i4 & 262144) == 0 || !composerStartRestartGroup.changed(textFieldColors)) {
                        i31 = 33554432;
                    } else {
                        i31 = 67108864;
                    }
                    i23 |= i31;
                }
                if ((i5 & 1533916891) == 306783378 || (191739611 & i23) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i34 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z2;
                        }
                        if ((i4 & 32) != 0) {
                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume;
                            i5 &= -458753;
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i10 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i14 != 0) {
                            function8 = null;
                        } else {
                            function8 = function4;
                        }
                        if (i16 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i18 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (i21 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if ((i4 & 4096) != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                            i23 &= -897;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        int i35 = i5;
                        if ((i4 & 8192) != 0) {
                            keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            i23 &= -7169;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i24 != 0) {
                            z8 = false;
                        } else {
                            z8 = z4;
                        }
                        if (i25 != 0) {
                            i29 = Integer.MAX_VALUE;
                        } else {
                            i29 = i;
                        }
                        keyboardActions3 = keyboardActions2;
                        if (i27 != 0) {
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
                        if ((i4 & 131072) != 0) {
                            cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                            i23 = (-29360129) & i23;
                        } else {
                            cornerBasedShapeCopy$default = shape;
                        }
                        if ((262144 & i4) != 0) {
                            textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                            i23 &= -234881025;
                        } else {
                            textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        function10 = function9;
                        visualTransformation2 = none;
                        function11 = function7;
                        function12 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        modifier2 = companion;
                        z11 = z5;
                        textStyle3 = textStyle2;
                        shape2 = cornerBasedShapeCopy$default;
                        i5 = i35;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i4 & 32) != 0) {
                            i5 &= -458753;
                        }
                        if ((i4 & 4096) != 0) {
                            i23 &= -897;
                        }
                        if ((i4 & 8192) != 0) {
                            i23 &= -7169;
                        }
                        if ((i4 & 131072) != 0) {
                            i23 &= -29360129;
                        }
                        if ((262144 & i4) != 0) {
                            i23 &= -234881025;
                        }
                        modifier2 = modifier;
                        z11 = z;
                        z10 = z2;
                        textStyle3 = textStyle;
                        function12 = function2;
                        function11 = function3;
                        function8 = function4;
                        function10 = function5;
                        z7 = z3;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions3 = keyboardOptions;
                        keyboardActions3 = keyboardActions;
                        z9 = z4;
                        i29 = i;
                        mutableInteractionSource2 = mutableInteractionSource;
                        shape2 = shape;
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-833027444);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
                    jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i36 = (i23 >> 21) & 112;
                    final boolean z16 = z11;
                    final boolean z17 = z9;
                    final VisualTransformation visualTransformation4 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    final boolean z18 = z7;
                    final Function2<? super Composer, ? super Integer, Unit> function17 = function12;
                    final Function2<? super Composer, ? super Integer, Unit> function18 = function11;
                    final Function2<? super Composer, ? super Integer, Unit> function19 = function8;
                    final Function2<? super Composer, ? super Integer, Unit> function20 = function10;
                    final TextFieldColors textFieldColors3 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                    final int i37 = i5;
                    final int i38 = i23;
                    int i39 = i23 << 12;
                    composer2 = composerStartRestartGroup;
                    boolean z19 = z11;
                    Modifier modifier4 = modifier2;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i36).getValue().m1641unboximpl(), shape2), z16, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i36).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function21, Composer composer3, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function21, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                            int i41;
                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                            ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                            if ((i40 & 14) == 0) {
                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                            } else {
                                i41 = i40;
                            }
                            if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                String str = value;
                                boolean z20 = z16;
                                boolean z21 = z17;
                                VisualTransformation visualTransformation5 = visualTransformation4;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                boolean z22 = z18;
                                Function2<Composer, Integer, Unit> function21 = function17;
                                Function2<Composer, Integer, Unit> function22 = function18;
                                Function2<Composer, Integer, Unit> function23 = function19;
                                Function2<Composer, Integer, Unit> function24 = function20;
                                TextFieldColors textFieldColors4 = textFieldColors3;
                                int i42 = i37;
                                int i43 = i38;
                                textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation5, mutableInteractionSource5, z22, function21, function22, function23, function24, textFieldColors4, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i5 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                    z12 = z10;
                    function13 = function12;
                    function14 = function11;
                    function15 = function8;
                    function16 = function10;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                    z13 = z9;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                    shape3 = shape2;
                    z14 = z7;
                    textStyle4 = textStyle3;
                    z15 = z19;
                    modifier3 = modifier4;
                    i30 = i29;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z15 = z;
                    z12 = z2;
                    textStyle4 = textStyle;
                    function14 = function3;
                    function15 = function4;
                    function16 = function5;
                    z14 = z3;
                    visualTransformation3 = visualTransformation;
                    keyboardOptions4 = keyboardOptions;
                    keyboardActions4 = keyboardActions;
                    z13 = z4;
                    i30 = i;
                    mutableInteractionSource3 = mutableInteractionSource;
                    shape3 = shape;
                    textFieldColors2 = textFieldColors;
                    composer2 = composerStartRestartGroup;
                    function13 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.3
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

                    public final void invoke(Composer composer3, int i40) {
                        TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
            if ((i2 & 458752) != 0) {
                if ((i4 & 32) == 0) {
                    i33 = 65536;
                } else {
                    i33 = 65536;
                }
                i5 |= i33;
            }
            i10 = i4 & 64;
            if (i10 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i5 |= i11;
            }
            i12 = i4 & 128;
            if (i12 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i4 & 256;
            if (i14 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i5 |= i15;
            }
            i16 = i4 & 512;
            if (i16 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(function5)) {
                    i17 = 536870912;
                } else {
                    i17 = 268435456;
                }
                i5 |= i17;
            }
            i18 = i4 & 1024;
            if (i18 != 0) {
                i19 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i20 = 4;
                } else {
                    i20 = 2;
                }
                i19 = i3 | i20;
            } else {
                i19 = i3;
            }
            i21 = i4 & 2048;
            if (i21 != 0) {
                i19 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 32;
                } else {
                    i22 = 16;
                }
                i19 |= i22;
            }
            if ((i3 & 896) != 0) {
                i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
            }
            i23 = i19;
            i24 = i4 & 16384;
            if (i24 != 0) {
                i23 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
            }
            i25 = i4 & 32768;
            if (i25 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i23 |= i26;
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
                i23 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i23 |= i28;
            }
            if ((i3 & 29360128) != 0) {
                if ((i4 & 131072) == 0) {
                    i32 = 4194304;
                } else {
                    i32 = 4194304;
                }
                i23 |= i32;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i31 = 33554432;
                } else {
                    i31 = 33554432;
                }
                i23 |= i31;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localTextStyle2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume2;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i310 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i310;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle3 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localTextStyle3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume3;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i311 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i311;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833027444);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i312 = (i23 >> 21) & 112;
                final boolean z110 = z11;
                final boolean z111 = z9;
                final VisualTransformation visualTransformation5 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                final boolean z112 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function110 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function111 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function112 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function21 = function10;
                final TextFieldColors textFieldColors4 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i313 = i5;
                final int i314 = i23;
                int i315 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z113 = z11;
                Modifier modifier5 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i312).getValue().m1641unboximpl(), shape2), z110, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i312).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function22, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function22, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z20 = z110;
                            boolean z21 = z111;
                            VisualTransformation visualTransformation6 = visualTransformation5;
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                            boolean z22 = z112;
                            Function2<Composer, Integer, Unit> function22 = function110;
                            Function2<Composer, Integer, Unit> function23 = function111;
                            Function2<Composer, Integer, Unit> function24 = function112;
                            Function2<Composer, Integer, Unit> function25 = function21;
                            TextFieldColors textFieldColors5 = textFieldColors4;
                            int i42 = i313;
                            int i43 = i314;
                            textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation6, mutableInteractionSource6, z22, function22, function23, function24, function25, textFieldColors5, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i315 & 3670016) | (KeyboardActions.$stable << 21) | (i315 & 29360128) | (i315 & 234881024) | (i315 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z113;
                modifier3 = modifier5;
                i30 = i29;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle4 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localTextStyle4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume4;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i316 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i316;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle5 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localTextStyle5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume5;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i317 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i317;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833027444);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i318 = (i23 >> 21) & 112;
                final boolean z114 = z11;
                final boolean z115 = z9;
                final VisualTransformation visualTransformation6 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                final boolean z116 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function113 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function114 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function115 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function22 = function10;
                final TextFieldColors textFieldColors5 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i319 = i5;
                final int i3110 = i23;
                int i3111 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z117 = z11;
                Modifier modifier6 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i318).getValue().m1641unboximpl(), shape2), z114, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i318).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function23, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function23, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z20 = z114;
                            boolean z21 = z115;
                            VisualTransformation visualTransformation7 = visualTransformation6;
                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                            boolean z22 = z116;
                            Function2<Composer, Integer, Unit> function23 = function113;
                            Function2<Composer, Integer, Unit> function24 = function114;
                            Function2<Composer, Integer, Unit> function25 = function115;
                            Function2<Composer, Integer, Unit> function26 = function22;
                            TextFieldColors textFieldColors6 = textFieldColors5;
                            int i42 = i319;
                            int i43 = i3110;
                            textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation7, mutableInteractionSource7, z22, function23, function24, function25, function26, textFieldColors6, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3111 & 3670016) | (KeyboardActions.$stable << 21) | (i3111 & 29360128) | (i3111 & 234881024) | (i3111 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z117;
                modifier3 = modifier6;
                i30 = i29;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.3
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

                public final void invoke(Composer composer3, int i40) {
                    TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
            if ((i2 & 458752) != 0) {
                if ((i4 & 32) == 0) {
                    i33 = 65536;
                } else {
                    i33 = 65536;
                }
                i5 |= i33;
            }
            i10 = i4 & 64;
            if (i10 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i5 |= i11;
            }
            i12 = i4 & 128;
            if (i12 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i4 & 256;
            if (i14 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i5 |= i15;
            }
            i16 = i4 & 512;
            if (i16 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(function5)) {
                    i17 = 536870912;
                } else {
                    i17 = 268435456;
                }
                i5 |= i17;
            }
            i18 = i4 & 1024;
            if (i18 != 0) {
                i19 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i20 = 4;
                } else {
                    i20 = 2;
                }
                i19 = i3 | i20;
            } else {
                i19 = i3;
            }
            i21 = i4 & 2048;
            if (i21 != 0) {
                i19 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 32;
                } else {
                    i22 = 16;
                }
                i19 |= i22;
            }
            if ((i3 & 896) != 0) {
                i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
            }
            i23 = i19;
            i24 = i4 & 16384;
            if (i24 != 0) {
                i23 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
            }
            i25 = i4 & 32768;
            if (i25 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i23 |= i26;
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
                i23 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i23 |= i28;
            }
            if ((i3 & 29360128) != 0) {
                if ((i4 & 131072) == 0) {
                    i32 = 4194304;
                } else {
                    i32 = 4194304;
                }
                i23 |= i32;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i31 = 33554432;
                } else {
                    i31 = 33554432;
                }
                i23 |= i31;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle6 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localTextStyle6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume6;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3112 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i3112;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle7 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localTextStyle7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume7;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3113 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i3113;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833027444);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3114 = (i23 >> 21) & 112;
                final boolean z118 = z11;
                final boolean z119 = z9;
                final VisualTransformation visualTransformation7 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                final boolean z1110 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function116 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function117 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function118 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function23 = function10;
                final TextFieldColors textFieldColors6 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i3115 = i5;
                final int i3116 = i23;
                int i3117 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z1111 = z11;
                Modifier modifier7 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i3114).getValue().m1641unboximpl(), shape2), z118, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i3114).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function24, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function24, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z20 = z118;
                            boolean z21 = z119;
                            VisualTransformation visualTransformation8 = visualTransformation7;
                            MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource7;
                            boolean z22 = z1110;
                            Function2<Composer, Integer, Unit> function24 = function116;
                            Function2<Composer, Integer, Unit> function25 = function117;
                            Function2<Composer, Integer, Unit> function26 = function118;
                            Function2<Composer, Integer, Unit> function27 = function23;
                            TextFieldColors textFieldColors7 = textFieldColors6;
                            int i42 = i3115;
                            int i43 = i3116;
                            textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation8, mutableInteractionSource8, z22, function24, function25, function26, function27, textFieldColors7, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3117 & 3670016) | (KeyboardActions.$stable << 21) | (i3117 & 29360128) | (i3117 & 234881024) | (i3117 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z1111;
                modifier3 = modifier7;
                i30 = i29;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle8 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composerStartRestartGroup.consume(localTextStyle8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume8;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3118 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i3118;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle9 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localTextStyle9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume9;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3119 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                        i23 = (-29360129) & i23;
                    } else {
                        cornerBasedShapeCopy$default = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = cornerBasedShapeCopy$default;
                    i5 = i3119;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833027444);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i31110 = (i23 >> 21) & 112;
                final boolean z1112 = z11;
                final boolean z1113 = z9;
                final VisualTransformation visualTransformation8 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                final boolean z1114 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function119 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function1110 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function1111 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
                final TextFieldColors textFieldColors7 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i31111 = i5;
                final int i31112 = i23;
                int i31113 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z1115 = z11;
                Modifier modifier8 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31110).getValue().m1641unboximpl(), shape2), z1112, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i31110).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function25, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function25, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str = value;
                            boolean z20 = z1112;
                            boolean z21 = z1113;
                            VisualTransformation visualTransformation9 = visualTransformation8;
                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource8;
                            boolean z22 = z1114;
                            Function2<Composer, Integer, Unit> function25 = function119;
                            Function2<Composer, Integer, Unit> function26 = function1110;
                            Function2<Composer, Integer, Unit> function27 = function1111;
                            Function2<Composer, Integer, Unit> function28 = function24;
                            TextFieldColors textFieldColors8 = textFieldColors7;
                            int i42 = i31111;
                            int i43 = i31112;
                            textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation9, mutableInteractionSource9, z22, function25, function26, function27, function28, textFieldColors8, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i31113 & 3670016) | (KeyboardActions.$stable << 21) | (i31113 & 29360128) | (i31113 & 234881024) | (i31113 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z1115;
                modifier3 = modifier8;
                i30 = i29;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.3
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

                public final void invoke(Composer composer3, int i40) {
                    TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
        if ((i2 & 458752) != 0) {
            if ((i4 & 32) == 0) {
                i33 = 65536;
            } else {
                i33 = 65536;
            }
            i5 |= i33;
        }
        i10 = i4 & 64;
        if (i10 != 0) {
            i5 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(function2)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i5 |= i11;
        }
        i12 = i4 & 128;
        if (i12 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(function3)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i5 |= i13;
        }
        i14 = i4 & 256;
        if (i14 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(function4)) {
                i15 = 67108864;
            } else {
                i15 = 33554432;
            }
            i5 |= i15;
        }
        i16 = i4 & 512;
        if (i16 != 0) {
            i5 |= C.ENCODING_PCM_32BIT;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(function5)) {
                i17 = 536870912;
            } else {
                i17 = 268435456;
            }
            i5 |= i17;
        }
        i18 = i4 & 1024;
        if (i18 != 0) {
            i19 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i20 = 4;
            } else {
                i20 = 2;
            }
            i19 = i3 | i20;
        } else {
            i19 = i3;
        }
        i21 = i4 & 2048;
        if (i21 != 0) {
            i19 |= 48;
        } else if ((i3 & 112) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i22 = 32;
            } else {
                i22 = 16;
            }
            i19 |= i22;
        }
        if ((i3 & 896) != 0) {
            i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
        }
        if ((i3 & 7168) != 0) {
            i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
        }
        i23 = i19;
        i24 = i4 & 16384;
        if (i24 != 0) {
            i23 |= 24576;
        } else if ((i3 & 57344) == 0) {
            i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
        }
        i25 = i4 & 32768;
        if (i25 != 0) {
            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & 458752) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i26 = 131072;
            } else {
                i26 = 65536;
            }
            i23 |= i26;
        }
        i27 = i4 & 65536;
        if (i27 != 0) {
            i23 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i28 = 1048576;
            } else {
                i28 = 524288;
            }
            i23 |= i28;
        }
        if ((i3 & 29360128) != 0) {
            if ((i4 & 131072) == 0) {
                i32 = 4194304;
            } else {
                i32 = 4194304;
            }
            i23 |= i32;
        }
        if ((i3 & 234881024) != 0) {
            if ((i4 & 262144) == 0) {
                i31 = 33554432;
            } else {
                i31 = 33554432;
            }
            i23 |= i31;
        }
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle10 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localTextStyle10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume10;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i31114 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                    i23 = (-29360129) & i23;
                } else {
                    cornerBasedShapeCopy$default = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = cornerBasedShapeCopy$default;
                i5 = i31114;
            } else {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle11 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localTextStyle11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume11;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i31115 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                    i23 = (-29360129) & i23;
                } else {
                    cornerBasedShapeCopy$default = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = cornerBasedShapeCopy$default;
                i5 = i31115;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-833027444);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i31116 = (i23 >> 21) & 112;
            final boolean z1116 = z11;
            final boolean z1117 = z9;
            final VisualTransformation visualTransformation9 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
            final boolean z1118 = z7;
            final Function2<? super Composer, ? super Integer, Unit> function1112 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function1113 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function1114 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function10;
            final TextFieldColors textFieldColors8 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            final int i31117 = i5;
            final int i31118 = i23;
            int i31119 = i23 << 12;
            composer2 = composerStartRestartGroup;
            boolean z1119 = z11;
            Modifier modifier9 = modifier2;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31116).getValue().m1641unboximpl(), shape2), z1116, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i31116).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function26, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function26, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z20 = z1116;
                        boolean z21 = z1117;
                        VisualTransformation visualTransformation10 = visualTransformation9;
                        MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource9;
                        boolean z22 = z1118;
                        Function2<Composer, Integer, Unit> function26 = function1112;
                        Function2<Composer, Integer, Unit> function27 = function1113;
                        Function2<Composer, Integer, Unit> function28 = function1114;
                        Function2<Composer, Integer, Unit> function29 = function25;
                        TextFieldColors textFieldColors9 = textFieldColors8;
                        int i42 = i31117;
                        int i43 = i31118;
                        textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation10, mutableInteractionSource10, z22, function26, function27, function28, function29, textFieldColors9, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i31119 & 3670016) | (KeyboardActions.$stable << 21) | (i31119 & 29360128) | (i31119 & 234881024) | (i31119 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            z12 = z10;
            function13 = function12;
            function14 = function11;
            function15 = function8;
            function16 = function10;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions4 = keyboardActions3;
            z13 = z9;
            mutableInteractionSource3 = mutableInteractionSource2;
            textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            shape3 = shape2;
            z14 = z7;
            textStyle4 = textStyle3;
            z15 = z1119;
            modifier3 = modifier9;
            i30 = i29;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle12 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localTextStyle12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume12;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i311110 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                    i23 = (-29360129) & i23;
                } else {
                    cornerBasedShapeCopy$default = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = cornerBasedShapeCopy$default;
                i5 = i311110;
            } else {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle13 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localTextStyle13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume13;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i311111 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                    i23 = (-29360129) & i23;
                } else {
                    cornerBasedShapeCopy$default = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = cornerBasedShapeCopy$default;
                i5 = i311111;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-833027444);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*181@9327L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i311112 = (i23 >> 21) & 112;
            final boolean z11110 = z11;
            final boolean z11111 = z9;
            final VisualTransformation visualTransformation10 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
            final boolean z11112 = z7;
            final Function2<? super Composer, ? super Integer, Unit> function1115 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function1116 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function1117 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function10;
            final TextFieldColors textFieldColors9 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            final int i311113 = i5;
            final int i311114 = i23;
            int i311115 = i23 << 12;
            composer2 = composerStartRestartGroup;
            boolean z11113 = z11;
            Modifier modifier10 = modifier2;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i311112).getValue().m1641unboximpl(), shape2), z11110, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i311112).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1994363936, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function27, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function27, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C208@10466L538:TextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z20 = z11110;
                        boolean z21 = z11111;
                        VisualTransformation visualTransformation11 = visualTransformation10;
                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource10;
                        boolean z22 = z11112;
                        Function2<Composer, Integer, Unit> function27 = function1115;
                        Function2<Composer, Integer, Unit> function28 = function1116;
                        Function2<Composer, Integer, Unit> function29 = function1117;
                        Function2<Composer, Integer, Unit> function210 = function26;
                        TextFieldColors textFieldColors10 = textFieldColors9;
                        int i42 = i311113;
                        int i43 = i311114;
                        textFieldDefaults.TextFieldDecorationBox(str, innerTextField, z20, z21, visualTransformation11, mutableInteractionSource11, z22, function27, function28, function29, function210, textFieldColors10, null, composer3, ((i43 >> 3) & 7168) | (i42 & 14) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i311115 & 3670016) | (KeyboardActions.$stable << 21) | (i311115 & 29360128) | (i311115 & 234881024) | (i311115 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            z12 = z10;
            function13 = function12;
            function14 = function11;
            function15 = function8;
            function16 = function10;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions4 = keyboardActions3;
            z13 = z9;
            mutableInteractionSource3 = mutableInteractionSource2;
            textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            shape3 = shape2;
            z14 = z7;
            textStyle4 = textStyle3;
            z15 = z11113;
            modifier3 = modifier10;
            i30 = i29;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.3
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

            public final void invoke(Composer composer3, int i40) {
                TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
            }
        });
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
    /* JADX WARN: Code duplicated, block: B:119:0x0179  */
    /* JADX WARN: Code duplicated, block: B:121:0x017f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0185  */
    /* JADX WARN: Code duplicated, block: B:124:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:130:0x0194  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:156:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:161:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:163:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:165:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:166:0x0200  */
    /* JADX WARN: Code duplicated, block: B:170:0x0208  */
    /* JADX WARN: Code duplicated, block: B:171:0x020f  */
    /* JADX WARN: Code duplicated, block: B:173:0x0215  */
    /* JADX WARN: Code duplicated, block: B:175:0x021b  */
    /* JADX WARN: Code duplicated, block: B:176:0x021e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0226  */
    /* JADX WARN: Code duplicated, block: B:182:0x022c  */
    /* JADX WARN: Code duplicated, block: B:185:0x0235  */
    /* JADX WARN: Code duplicated, block: B:187:0x023a  */
    /* JADX WARN: Code duplicated, block: B:190:0x0240  */
    /* JADX WARN: Code duplicated, block: B:192:0x0248  */
    /* JADX WARN: Code duplicated, block: B:195:0x0251  */
    /* JADX WARN: Code duplicated, block: B:197:0x0256  */
    /* JADX WARN: Code duplicated, block: B:200:0x0262  */
    /* JADX WARN: Code duplicated, block: B:206:0x029b  */
    /* JADX WARN: Code duplicated, block: B:208:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:227:0x02f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:228:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:229:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:231:0x0300  */
    /* JADX WARN: Code duplicated, block: B:232:0x0302  */
    /* JADX WARN: Code duplicated, block: B:234:0x0306  */
    /* JADX WARN: Code duplicated, block: B:235:0x0308  */
    /* JADX WARN: Code duplicated, block: B:238:0x030e  */
    /* JADX WARN: Code duplicated, block: B:239:0x0330  */
    /* JADX WARN: Code duplicated, block: B:241:0x0338  */
    /* JADX WARN: Code duplicated, block: B:242:0x033a  */
    /* JADX WARN: Code duplicated, block: B:244:0x033e  */
    /* JADX WARN: Code duplicated, block: B:245:0x0340  */
    /* JADX WARN: Code duplicated, block: B:247:0x0344  */
    /* JADX WARN: Code duplicated, block: B:248:0x0346  */
    /* JADX WARN: Code duplicated, block: B:250:0x034a  */
    /* JADX WARN: Code duplicated, block: B:251:0x034c  */
    /* JADX WARN: Code duplicated, block: B:253:0x0350  */
    /* JADX WARN: Code duplicated, block: B:254:0x0352  */
    /* JADX WARN: Code duplicated, block: B:256:0x0356  */
    /* JADX WARN: Code duplicated, block: B:257:0x035d  */
    /* JADX WARN: Code duplicated, block: B:260:0x0363  */
    /* JADX WARN: Code duplicated, block: B:261:0x036c  */
    /* JADX WARN: Code duplicated, block: B:264:0x0374  */
    /* JADX WARN: Code duplicated, block: B:265:0x039e  */
    /* JADX WARN: Code duplicated, block: B:267:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:268:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:270:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:271:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:274:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:276:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:278:0x03da  */
    /* JADX WARN: Code duplicated, block: B:281:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:282:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:285:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:286:0x0441  */
    /* JADX WARN: Code duplicated, block: B:291:0x047c  */
    /* JADX WARN: Code duplicated, block: B:296:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x0096  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:80:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0117  */
    /* JADX WARN: Code duplicated, block: B:88:0x011e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013c  */
    public static final void TextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
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
        Modifier.Companion companion;
        boolean z5;
        boolean z6;
        TextStyle textStyle2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        boolean z7;
        VisualTransformation none;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean z8;
        int i29;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource2;
        Shape textFieldShape;
        TextFieldColors textFieldColorsM1226textFieldColorsdx8h9Zs;
        Function2<? super Composer, ? super Integer, Unit> function10;
        VisualTransformation visualTransformation2;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        boolean z9;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        Modifier modifier2;
        boolean z11;
        TextStyle textStyle3;
        Shape shape2;
        Object objRememberedValue;
        long jM3505getColor0d7_KjU;
        Composer composer2;
        final boolean z12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final Function2<? super Composer, ? super Integer, Unit> function15;
        final Function2<? super Composer, ? super Integer, Unit> function16;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions4;
        final boolean z13;
        final MutableInteractionSource mutableInteractionSource3;
        final TextFieldColors textFieldColors2;
        final Shape shape3;
        final boolean z14;
        final TextStyle textStyle4;
        final boolean z15;
        final Modifier modifier3;
        final int i30;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i31;
        int i32;
        int i33;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)298@15761L7,309@16315L39,310@16393L14,311@16457L17,323@16875L24,333@17313L20,320@16777L1547:TextField.kt#jmzs0o");
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
        int i34 = i4 & 4;
        if (i34 == 0) {
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
                if ((i2 & 458752) != 0) {
                    if ((i4 & 32) == 0 || !composerStartRestartGroup.changed(textStyle)) {
                        i33 = 65536;
                    } else {
                        i33 = 131072;
                    }
                    i5 |= i33;
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i5 |= i11;
                }
                i12 = i4 & 128;
                if (i12 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i5 |= i13;
                }
                i14 = i4 & 256;
                if (i14 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(function4)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i5 |= i15;
                }
                i16 = i4 & 512;
                if (i16 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(function5)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                    i5 |= i17;
                }
                i18 = i4 & 1024;
                if (i18 != 0) {
                    i19 = i3 | 6;
                } else if ((i3 & 14) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i20 = 4;
                    } else {
                        i20 = 2;
                    }
                    i19 = i3 | i20;
                } else {
                    i19 = i3;
                }
                i21 = i4 & 2048;
                if (i21 != 0) {
                    i19 |= 48;
                } else if ((i3 & 112) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i22 = 32;
                    } else {
                        i22 = 16;
                    }
                    i19 |= i22;
                }
                if ((i3 & 896) != 0) {
                    i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
                }
                if ((i3 & 7168) != 0) {
                    i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
                }
                i23 = i19;
                i24 = i4 & 16384;
                if (i24 != 0) {
                    i23 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                i25 = i4 & 32768;
                if (i25 != 0) {
                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i26 = 131072;
                    } else {
                        i26 = 65536;
                    }
                    i23 |= i26;
                }
                i27 = i4 & 65536;
                if (i27 != 0) {
                    i23 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i28 = 1048576;
                    } else {
                        i28 = 524288;
                    }
                    i23 |= i28;
                }
                if ((i3 & 29360128) != 0) {
                    if ((i4 & 131072) == 0 || !composerStartRestartGroup.changed(shape)) {
                        i32 = 4194304;
                    } else {
                        i32 = 8388608;
                    }
                    i23 |= i32;
                }
                if ((i3 & 234881024) != 0) {
                    if ((i4 & 262144) == 0 || !composerStartRestartGroup.changed(textFieldColors)) {
                        i31 = 33554432;
                    } else {
                        i31 = 67108864;
                    }
                    i23 |= i31;
                }
                if ((i5 & 1533916891) == 306783378 || (191739611 & i23) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i34 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z2;
                        }
                        if ((i4 & 32) != 0) {
                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            textStyle2 = (TextStyle) objConsume;
                            i5 &= -458753;
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i10 != 0) {
                            function6 = null;
                        } else {
                            function6 = function2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if (i14 != 0) {
                            function8 = null;
                        } else {
                            function8 = function4;
                        }
                        if (i16 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i18 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (i21 != 0) {
                            none = VisualTransformation.INSTANCE.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if ((i4 & 4096) != 0) {
                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                            i23 &= -897;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                        }
                        int i35 = i5;
                        if ((i4 & 8192) != 0) {
                            keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                            i23 &= -7169;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i24 != 0) {
                            z8 = false;
                        } else {
                            z8 = z4;
                        }
                        if (i25 != 0) {
                            i29 = Integer.MAX_VALUE;
                        } else {
                            i29 = i;
                        }
                        keyboardActions3 = keyboardActions2;
                        if (i27 != 0) {
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
                        if ((i4 & 131072) != 0) {
                            textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                            i23 = (-29360129) & i23;
                        } else {
                            textFieldShape = shape;
                        }
                        if ((262144 & i4) != 0) {
                            textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                            i23 &= -234881025;
                        } else {
                            textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        function10 = function9;
                        visualTransformation2 = none;
                        function11 = function7;
                        function12 = function6;
                        z9 = z8;
                        keyboardOptions3 = keyboardOptions2;
                        z10 = z6;
                        modifier2 = companion;
                        z11 = z5;
                        textStyle3 = textStyle2;
                        shape2 = textFieldShape;
                        i5 = i35;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i4 & 32) != 0) {
                            i5 &= -458753;
                        }
                        if ((i4 & 4096) != 0) {
                            i23 &= -897;
                        }
                        if ((i4 & 8192) != 0) {
                            i23 &= -7169;
                        }
                        if ((i4 & 131072) != 0) {
                            i23 &= -29360129;
                        }
                        if ((262144 & i4) != 0) {
                            i23 &= -234881025;
                        }
                        modifier2 = modifier;
                        z11 = z;
                        z10 = z2;
                        textStyle3 = textStyle;
                        function12 = function2;
                        function11 = function3;
                        function8 = function4;
                        function10 = function5;
                        z7 = z3;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions3 = keyboardOptions;
                        keyboardActions3 = keyboardActions;
                        z9 = z4;
                        i29 = i;
                        mutableInteractionSource2 = mutableInteractionSource;
                        shape2 = shape;
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    composerStartRestartGroup.startReplaceableGroup(-833020145);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
                    jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                    if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                        jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i36 = (i23 >> 21) & 112;
                    final boolean z16 = z11;
                    final boolean z17 = z9;
                    final VisualTransformation visualTransformation4 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    final boolean z18 = z7;
                    final Function2<? super Composer, ? super Integer, Unit> function17 = function12;
                    final Function2<? super Composer, ? super Integer, Unit> function18 = function11;
                    final Function2<? super Composer, ? super Integer, Unit> function19 = function8;
                    final Function2<? super Composer, ? super Integer, Unit> function20 = function10;
                    final TextFieldColors textFieldColors3 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                    final int i37 = i5;
                    final int i38 = i23;
                    int i39 = i23 << 12;
                    composer2 = composerStartRestartGroup;
                    boolean z19 = z11;
                    Modifier modifier4 = modifier2;
                    BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i36).getValue().m1641unboximpl(), shape2), z16, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i36).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function21, Composer composer3, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function21, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                            int i41;
                            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                            ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                            if ((i40 & 14) == 0) {
                                i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                            } else {
                                i41 = i40;
                            }
                            if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                String text = value.getText();
                                boolean z20 = z16;
                                boolean z21 = z17;
                                VisualTransformation visualTransformation5 = visualTransformation4;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                boolean z22 = z18;
                                Function2<Composer, Integer, Unit> function21 = function17;
                                Function2<Composer, Integer, Unit> function22 = function18;
                                Function2<Composer, Integer, Unit> function23 = function19;
                                Function2<Composer, Integer, Unit> function24 = function20;
                                TextFieldColors textFieldColors4 = textFieldColors3;
                                int i42 = i37;
                                int i43 = i38;
                                textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation5, mutableInteractionSource5, z22, function21, function22, function23, function24, textFieldColors4, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i5 & 64638) | (i39 & 3670016) | (KeyboardActions.$stable << 21) | (i39 & 29360128) | (i39 & 234881024) | (i39 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                    z12 = z10;
                    function13 = function12;
                    function14 = function11;
                    function15 = function8;
                    function16 = function10;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                    z13 = z9;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                    shape3 = shape2;
                    z14 = z7;
                    textStyle4 = textStyle3;
                    z15 = z19;
                    modifier3 = modifier4;
                    i30 = i29;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z15 = z;
                    z12 = z2;
                    textStyle4 = textStyle;
                    function14 = function3;
                    function15 = function4;
                    function16 = function5;
                    z14 = z3;
                    visualTransformation3 = visualTransformation;
                    keyboardOptions4 = keyboardOptions;
                    keyboardActions4 = keyboardActions;
                    z13 = z4;
                    i30 = i;
                    mutableInteractionSource3 = mutableInteractionSource;
                    shape3 = shape;
                    textFieldColors2 = textFieldColors;
                    composer2 = composerStartRestartGroup;
                    function13 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.6
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

                    public final void invoke(Composer composer3, int i40) {
                        TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
            if ((i2 & 458752) != 0) {
                if ((i4 & 32) == 0) {
                    i33 = 65536;
                } else {
                    i33 = 65536;
                }
                i5 |= i33;
            }
            i10 = i4 & 64;
            if (i10 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i5 |= i11;
            }
            i12 = i4 & 128;
            if (i12 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i4 & 256;
            if (i14 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i5 |= i15;
            }
            i16 = i4 & 512;
            if (i16 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(function5)) {
                    i17 = 536870912;
                } else {
                    i17 = 268435456;
                }
                i5 |= i17;
            }
            i18 = i4 & 1024;
            if (i18 != 0) {
                i19 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i20 = 4;
                } else {
                    i20 = 2;
                }
                i19 = i3 | i20;
            } else {
                i19 = i3;
            }
            i21 = i4 & 2048;
            if (i21 != 0) {
                i19 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 32;
                } else {
                    i22 = 16;
                }
                i19 |= i22;
            }
            if ((i3 & 896) != 0) {
                i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
            }
            i23 = i19;
            i24 = i4 & 16384;
            if (i24 != 0) {
                i23 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
            }
            i25 = i4 & 32768;
            if (i25 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i23 |= i26;
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
                i23 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i23 |= i28;
            }
            if ((i3 & 29360128) != 0) {
                if ((i4 & 131072) == 0) {
                    i32 = 4194304;
                } else {
                    i32 = 4194304;
                }
                i23 |= i32;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i31 = 33554432;
                } else {
                    i31 = 33554432;
                }
                i23 |= i31;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localTextStyle2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume2;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i310 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i310;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle3 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localTextStyle3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume3;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i311 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i311;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833020145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i312 = (i23 >> 21) & 112;
                final boolean z110 = z11;
                final boolean z111 = z9;
                final VisualTransformation visualTransformation5 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                final boolean z112 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function110 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function111 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function112 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function21 = function10;
                final TextFieldColors textFieldColors4 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i313 = i5;
                final int i314 = i23;
                int i315 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z113 = z11;
                Modifier modifier5 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i312).getValue().m1641unboximpl(), shape2), z110, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i312).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function22, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function22, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z20 = z110;
                            boolean z21 = z111;
                            VisualTransformation visualTransformation6 = visualTransformation5;
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                            boolean z22 = z112;
                            Function2<Composer, Integer, Unit> function22 = function110;
                            Function2<Composer, Integer, Unit> function23 = function111;
                            Function2<Composer, Integer, Unit> function24 = function112;
                            Function2<Composer, Integer, Unit> function25 = function21;
                            TextFieldColors textFieldColors5 = textFieldColors4;
                            int i42 = i313;
                            int i43 = i314;
                            textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation6, mutableInteractionSource6, z22, function22, function23, function24, function25, textFieldColors5, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i315 & 3670016) | (KeyboardActions.$stable << 21) | (i315 & 29360128) | (i315 & 234881024) | (i315 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z113;
                modifier3 = modifier5;
                i30 = i29;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle4 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localTextStyle4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume4;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i316 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i316;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle5 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localTextStyle5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume5;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i317 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i317;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833020145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i318 = (i23 >> 21) & 112;
                final boolean z114 = z11;
                final boolean z115 = z9;
                final VisualTransformation visualTransformation6 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                final boolean z116 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function113 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function114 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function115 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function22 = function10;
                final TextFieldColors textFieldColors5 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i319 = i5;
                final int i3110 = i23;
                int i3111 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z117 = z11;
                Modifier modifier6 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i318).getValue().m1641unboximpl(), shape2), z114, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i318).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function23, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function23, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z20 = z114;
                            boolean z21 = z115;
                            VisualTransformation visualTransformation7 = visualTransformation6;
                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                            boolean z22 = z116;
                            Function2<Composer, Integer, Unit> function23 = function113;
                            Function2<Composer, Integer, Unit> function24 = function114;
                            Function2<Composer, Integer, Unit> function25 = function115;
                            Function2<Composer, Integer, Unit> function26 = function22;
                            TextFieldColors textFieldColors6 = textFieldColors5;
                            int i42 = i319;
                            int i43 = i3110;
                            textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation7, mutableInteractionSource7, z22, function23, function24, function25, function26, textFieldColors6, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3111 & 3670016) | (KeyboardActions.$stable << 21) | (i3111 & 29360128) | (i3111 & 234881024) | (i3111 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z117;
                modifier3 = modifier6;
                i30 = i29;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.6
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

                public final void invoke(Composer composer3, int i40) {
                    TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
            if ((i2 & 458752) != 0) {
                if ((i4 & 32) == 0) {
                    i33 = 65536;
                } else {
                    i33 = 65536;
                }
                i5 |= i33;
            }
            i10 = i4 & 64;
            if (i10 != 0) {
                i5 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i5 |= i11;
            }
            i12 = i4 & 128;
            if (i12 != 0) {
                i5 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i5 |= i13;
            }
            i14 = i4 & 256;
            if (i14 != 0) {
                i5 |= 100663296;
            } else if ((i2 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i5 |= i15;
            }
            i16 = i4 & 512;
            if (i16 != 0) {
                i5 |= C.ENCODING_PCM_32BIT;
            } else if ((i2 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(function5)) {
                    i17 = 536870912;
                } else {
                    i17 = 268435456;
                }
                i5 |= i17;
            }
            i18 = i4 & 1024;
            if (i18 != 0) {
                i19 = i3 | 6;
            } else if ((i3 & 14) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i20 = 4;
                } else {
                    i20 = 2;
                }
                i19 = i3 | i20;
            } else {
                i19 = i3;
            }
            i21 = i4 & 2048;
            if (i21 != 0) {
                i19 |= 48;
            } else if ((i3 & 112) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i22 = 32;
                } else {
                    i22 = 16;
                }
                i19 |= i22;
            }
            if ((i3 & 896) != 0) {
                i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
            }
            if ((i3 & 7168) != 0) {
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
            }
            i23 = i19;
            i24 = i4 & 16384;
            if (i24 != 0) {
                i23 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
            }
            i25 = i4 & 32768;
            if (i25 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i26 = 131072;
                } else {
                    i26 = 65536;
                }
                i23 |= i26;
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
                i23 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i28 = 1048576;
                } else {
                    i28 = 524288;
                }
                i23 |= i28;
            }
            if ((i3 & 29360128) != 0) {
                if ((i4 & 131072) == 0) {
                    i32 = 4194304;
                } else {
                    i32 = 4194304;
                }
                i23 |= i32;
            }
            if ((i3 & 234881024) != 0) {
                if ((i4 & 262144) == 0) {
                    i31 = 33554432;
                } else {
                    i31 = 33554432;
                }
                i23 |= i31;
            }
            if ((i5 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle6 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localTextStyle6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume6;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3112 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i3112;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle7 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localTextStyle7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume7;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3113 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i3113;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833020145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i3114 = (i23 >> 21) & 112;
                final boolean z118 = z11;
                final boolean z119 = z9;
                final VisualTransformation visualTransformation7 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                final boolean z1110 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function116 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function117 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function118 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function23 = function10;
                final TextFieldColors textFieldColors6 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i3115 = i5;
                final int i3116 = i23;
                int i3117 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z1111 = z11;
                Modifier modifier7 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i3114).getValue().m1641unboximpl(), shape2), z118, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i3114).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function24, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function24, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z20 = z118;
                            boolean z21 = z119;
                            VisualTransformation visualTransformation8 = visualTransformation7;
                            MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource7;
                            boolean z22 = z1110;
                            Function2<Composer, Integer, Unit> function24 = function116;
                            Function2<Composer, Integer, Unit> function25 = function117;
                            Function2<Composer, Integer, Unit> function26 = function118;
                            Function2<Composer, Integer, Unit> function27 = function23;
                            TextFieldColors textFieldColors7 = textFieldColors6;
                            int i42 = i3115;
                            int i43 = i3116;
                            textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation8, mutableInteractionSource8, z22, function24, function25, function26, function27, textFieldColors7, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i3117 & 3670016) | (KeyboardActions.$stable << 21) | (i3117 & 29360128) | (i3117 & 234881024) | (i3117 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z1111;
                modifier3 = modifier7;
                i30 = i29;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle8 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composerStartRestartGroup.consume(localTextStyle8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume8;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3118 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i3118;
                } else {
                    if (i34 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if ((i4 & 32) != 0) {
                        ProvidableCompositionLocal<TextStyle> localTextStyle9 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localTextStyle9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        textStyle2 = (TextStyle) objConsume9;
                        i5 &= -458753;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if (i14 != 0) {
                        function8 = null;
                    } else {
                        function8 = function4;
                    }
                    if (i16 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i18 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (i21 != 0) {
                        none = VisualTransformation.INSTANCE.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if ((i4 & 4096) != 0) {
                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                        i23 &= -897;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                    }
                    int i3119 = i5;
                    if ((i4 & 8192) != 0) {
                        keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                        i23 &= -7169;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i24 != 0) {
                        z8 = false;
                    } else {
                        z8 = z4;
                    }
                    if (i25 != 0) {
                        i29 = Integer.MAX_VALUE;
                    } else {
                        i29 = i;
                    }
                    keyboardActions3 = keyboardActions2;
                    if (i27 != 0) {
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
                    if ((i4 & 131072) != 0) {
                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                        i23 = (-29360129) & i23;
                    } else {
                        textFieldShape = shape;
                    }
                    if ((262144 & i4) != 0) {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                        i23 &= -234881025;
                    } else {
                        textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    function10 = function9;
                    visualTransformation2 = none;
                    function11 = function7;
                    function12 = function6;
                    z9 = z8;
                    keyboardOptions3 = keyboardOptions2;
                    z10 = z6;
                    modifier2 = companion;
                    z11 = z5;
                    textStyle3 = textStyle2;
                    shape2 = textFieldShape;
                    i5 = i3119;
                }
                composerStartRestartGroup.endDefaults();
                composerStartRestartGroup.startReplaceableGroup(-833020145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
                jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
                if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                    jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i31110 = (i23 >> 21) & 112;
                final boolean z1112 = z11;
                final boolean z1113 = z9;
                final VisualTransformation visualTransformation8 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                final boolean z1114 = z7;
                final Function2<? super Composer, ? super Integer, Unit> function119 = function12;
                final Function2<? super Composer, ? super Integer, Unit> function1110 = function11;
                final Function2<? super Composer, ? super Integer, Unit> function1111 = function8;
                final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
                final TextFieldColors textFieldColors7 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                final int i31111 = i5;
                final int i31112 = i23;
                int i31113 = i23 << 12;
                composer2 = composerStartRestartGroup;
                boolean z1115 = z11;
                Modifier modifier8 = modifier2;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31110).getValue().m1641unboximpl(), shape2), z1112, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i31110).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function25, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function25, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                        int i41;
                        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                        ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                        if ((i40 & 14) == 0) {
                            i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                        } else {
                            i41 = i40;
                        }
                        if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            boolean z20 = z1112;
                            boolean z21 = z1113;
                            VisualTransformation visualTransformation9 = visualTransformation8;
                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource8;
                            boolean z22 = z1114;
                            Function2<Composer, Integer, Unit> function25 = function119;
                            Function2<Composer, Integer, Unit> function26 = function1110;
                            Function2<Composer, Integer, Unit> function27 = function1111;
                            Function2<Composer, Integer, Unit> function28 = function24;
                            TextFieldColors textFieldColors8 = textFieldColors7;
                            int i42 = i31111;
                            int i43 = i31112;
                            textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation9, mutableInteractionSource9, z22, function25, function26, function27, function28, textFieldColors8, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i5 & 64638) | (i31113 & 3670016) | (KeyboardActions.$stable << 21) | (i31113 & 29360128) | (i31113 & 234881024) | (i31113 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
                z12 = z10;
                function13 = function12;
                function14 = function11;
                function15 = function8;
                function16 = function10;
                visualTransformation3 = visualTransformation2;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
                z13 = z9;
                mutableInteractionSource3 = mutableInteractionSource2;
                textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
                shape3 = shape2;
                z14 = z7;
                textStyle4 = textStyle3;
                z15 = z1115;
                modifier3 = modifier8;
                i30 = i29;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.6
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

                public final void invoke(Composer composer3, int i40) {
                    TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
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
        if ((i2 & 458752) != 0) {
            if ((i4 & 32) == 0) {
                i33 = 65536;
            } else {
                i33 = 65536;
            }
            i5 |= i33;
        }
        i10 = i4 & 64;
        if (i10 != 0) {
            i5 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(function2)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i5 |= i11;
        }
        i12 = i4 & 128;
        if (i12 != 0) {
            i5 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(function3)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i5 |= i13;
        }
        i14 = i4 & 256;
        if (i14 != 0) {
            i5 |= 100663296;
        } else if ((i2 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(function4)) {
                i15 = 67108864;
            } else {
                i15 = 33554432;
            }
            i5 |= i15;
        }
        i16 = i4 & 512;
        if (i16 != 0) {
            i5 |= C.ENCODING_PCM_32BIT;
        } else if ((i2 & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(function5)) {
                i17 = 536870912;
            } else {
                i17 = 268435456;
            }
            i5 |= i17;
        }
        i18 = i4 & 1024;
        if (i18 != 0) {
            i19 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i20 = 4;
            } else {
                i20 = 2;
            }
            i19 = i3 | i20;
        } else {
            i19 = i3;
        }
        i21 = i4 & 2048;
        if (i21 != 0) {
            i19 |= 48;
        } else if ((i3 & 112) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i22 = 32;
            } else {
                i22 = 16;
            }
            i19 |= i22;
        }
        if ((i3 & 896) != 0) {
            i19 |= ((i4 & 4096) == 0 || !composerStartRestartGroup.changed(keyboardOptions)) ? 128 : 256;
        }
        if ((i3 & 7168) != 0) {
            i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(keyboardActions)) ? 1024 : 2048;
        }
        i23 = i19;
        i24 = i4 & 16384;
        if (i24 != 0) {
            i23 |= 24576;
        } else if ((i3 & 57344) == 0) {
            i23 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
        }
        i25 = i4 & 32768;
        if (i25 != 0) {
            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & 458752) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i26 = 131072;
            } else {
                i26 = 65536;
            }
            i23 |= i26;
        }
        i27 = i4 & 65536;
        if (i27 != 0) {
            i23 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i28 = 1048576;
            } else {
                i28 = 524288;
            }
            i23 |= i28;
        }
        if ((i3 & 29360128) != 0) {
            if ((i4 & 131072) == 0) {
                i32 = 4194304;
            } else {
                i32 = 4194304;
            }
            i23 |= i32;
        }
        if ((i3 & 234881024) != 0) {
            if ((i4 & 262144) == 0) {
                i31 = 33554432;
            } else {
                i31 = 33554432;
            }
            i23 |= i31;
        }
        if ((i5 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle10 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localTextStyle10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume10;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i31114 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    textFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = textFieldShape;
                i5 = i31114;
            } else {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle11 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localTextStyle11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume11;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i31115 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    textFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = textFieldShape;
                i5 = i31115;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-833020145);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i31116 = (i23 >> 21) & 112;
            final boolean z1116 = z11;
            final boolean z1117 = z9;
            final VisualTransformation visualTransformation9 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
            final boolean z1118 = z7;
            final Function2<? super Composer, ? super Integer, Unit> function1112 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function1113 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function1114 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function10;
            final TextFieldColors textFieldColors8 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            final int i31117 = i5;
            final int i31118 = i23;
            int i31119 = i23 << 12;
            composer2 = composerStartRestartGroup;
            boolean z1119 = z11;
            Modifier modifier9 = modifier2;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i31116).getValue().m1641unboximpl(), shape2), z1116, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i31116).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function26, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function26, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        boolean z20 = z1116;
                        boolean z21 = z1117;
                        VisualTransformation visualTransformation10 = visualTransformation9;
                        MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource9;
                        boolean z22 = z1118;
                        Function2<Composer, Integer, Unit> function26 = function1112;
                        Function2<Composer, Integer, Unit> function27 = function1113;
                        Function2<Composer, Integer, Unit> function28 = function1114;
                        Function2<Composer, Integer, Unit> function29 = function25;
                        TextFieldColors textFieldColors9 = textFieldColors8;
                        int i42 = i31117;
                        int i43 = i31118;
                        textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation10, mutableInteractionSource10, z22, function26, function27, function28, function29, textFieldColors9, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i31119 & 3670016) | (KeyboardActions.$stable << 21) | (i31119 & 29360128) | (i31119 & 234881024) | (i31119 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            z12 = z10;
            function13 = function12;
            function14 = function11;
            function15 = function8;
            function16 = function10;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions4 = keyboardActions3;
            z13 = z9;
            mutableInteractionSource3 = mutableInteractionSource2;
            textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            shape3 = shape2;
            z14 = z7;
            textStyle4 = textStyle3;
            z15 = z1119;
            modifier3 = modifier9;
            i30 = i29;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle12 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localTextStyle12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume12;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i311110 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    textFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = textFieldShape;
                i5 = i311110;
            } else {
                if (i34 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if ((i4 & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle13 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localTextStyle13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyle2 = (TextStyle) objConsume13;
                    i5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function2;
                }
                if (i12 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if (i14 != 0) {
                    function8 = null;
                } else {
                    function8 = function4;
                }
                if (i16 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i18 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (i21 != 0) {
                    none = VisualTransformation.INSTANCE.getNone();
                } else {
                    none = visualTransformation;
                }
                if ((i4 & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    i23 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int i311111 = i5;
                if ((i4 & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    i23 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i24 != 0) {
                    z8 = false;
                } else {
                    z8 = z4;
                }
                if (i25 != 0) {
                    i29 = Integer.MAX_VALUE;
                } else {
                    i29 = i;
                }
                keyboardActions3 = keyboardActions2;
                if (i27 != 0) {
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
                if ((i4 & 131072) != 0) {
                    textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                    i23 = (-29360129) & i23;
                } else {
                    textFieldShape = shape;
                }
                if ((262144 & i4) != 0) {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1226textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                    i23 &= -234881025;
                } else {
                    textFieldColorsM1226textFieldColorsdx8h9Zs = textFieldColors;
                }
                function10 = function9;
                visualTransformation2 = none;
                function11 = function7;
                function12 = function6;
                z9 = z8;
                keyboardOptions3 = keyboardOptions2;
                z10 = z6;
                modifier2 = companion;
                z11 = z5;
                textStyle3 = textStyle2;
                shape2 = textFieldShape;
                i5 = i311111;
            }
            composerStartRestartGroup.endDefaults();
            composerStartRestartGroup.startReplaceableGroup(-833020145);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*315@16626L18");
            jM3505getColor0d7_KjU = textStyle3.m3505getColor0d7_KjU();
            if (jM3505getColor0d7_KjU == Color.INSTANCE.m1667getUnspecified0d7_KjU()) {
                jM3505getColor0d7_KjU = textFieldColorsM1226textFieldColorsdx8h9Zs.textColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | ((i23 >> 21) & 112)).getValue().m1641unboximpl();
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i311112 = (i23 >> 21) & 112;
            final boolean z11110 = z11;
            final boolean z11111 = z9;
            final VisualTransformation visualTransformation10 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
            final boolean z11112 = z7;
            final Function2<? super Composer, ? super Integer, Unit> function1115 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function1116 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function1117 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function10;
            final TextFieldColors textFieldColors9 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            final int i311113 = i5;
            final int i311114 = i23;
            int i311115 = i23 << 12;
            composer2 = composerStartRestartGroup;
            boolean z11113 = z11;
            Modifier modifier10 = modifier2;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m448defaultMinSizeVpY3zN4(TextFieldDefaults.INSTANCE.m1223indicatorLinegv0btCI(BackgroundKt.m175backgroundbw27NRU(modifier2, textFieldColorsM1226textFieldColorsdx8h9Zs.backgroundColor(z11, composerStartRestartGroup, ((i5 >> 9) & 14) | i311112).getValue().m1641unboximpl(), shape2), z11110, z7, mutableInteractionSource2, textFieldColorsM1226textFieldColorsdx8h9Zs, (48 & 16) != 0 ? TextFieldDefaults.FocusedBorderThickness : 0.0f, (48 & 32) != 0 ? TextFieldDefaults.UnfocusedBorderThickness : 0.0f), TextFieldDefaults.INSTANCE.m1221getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1220getMinHeightD9Ej5fM()), z11, z10, textStyle3.merge(new TextStyle(jM3505getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z9, i29, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, new SolidColor(textFieldColorsM1226textFieldColorsdx8h9Zs.cursorColor(z7, composerStartRestartGroup, (i23 & 14) | i311112).getValue().m1641unboximpl(), null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2078585677, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function27, Composer composer3, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function27, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer3, int i40) {
                    int i41;
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation(composer3, "C342@17765L543:TextField.kt#jmzs0o");
                    if ((i40 & 14) == 0) {
                        i41 = i40 | (composer3.changed(innerTextField) ? 4 : 2);
                    } else {
                        i41 = i40;
                    }
                    if ((i41 & 91) != 18 || !composer3.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        boolean z20 = z11110;
                        boolean z21 = z11111;
                        VisualTransformation visualTransformation11 = visualTransformation10;
                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource10;
                        boolean z22 = z11112;
                        Function2<Composer, Integer, Unit> function27 = function1115;
                        Function2<Composer, Integer, Unit> function28 = function1116;
                        Function2<Composer, Integer, Unit> function29 = function1117;
                        Function2<Composer, Integer, Unit> function210 = function26;
                        TextFieldColors textFieldColors10 = textFieldColors9;
                        int i42 = i311113;
                        int i43 = i311114;
                        textFieldDefaults.TextFieldDecorationBox(text, innerTextField, z20, z21, visualTransformation11, mutableInteractionSource11, z22, function27, function28, function29, function210, textFieldColors10, null, composer3, ((i43 >> 3) & 7168) | ((i41 << 3) & 112) | ((i42 >> 3) & 896) | ((i43 << 9) & 57344) | ((i43 >> 3) & 458752) | ((i43 << 18) & 3670016) | ((i42 << 3) & 29360128) | ((i42 << 3) & 234881024) | ((i42 << 3) & 1879048192), ((i42 >> 27) & 14) | 3072 | ((i43 >> 21) & 112), 4096);
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i5 & 64638) | (i311115 & 3670016) | (KeyboardActions.$stable << 21) | (i311115 & 29360128) | (i311115 & 234881024) | (i311115 & 1879048192), ((i23 >> 3) & 14) | 24576 | ((i23 >> 12) & 896), 2048);
            z12 = z10;
            function13 = function12;
            function14 = function11;
            function15 = function8;
            function16 = function10;
            visualTransformation3 = visualTransformation2;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions4 = keyboardActions3;
            z13 = z9;
            mutableInteractionSource3 = mutableInteractionSource2;
            textFieldColors2 = textFieldColorsM1226textFieldColorsdx8h9Zs;
            shape3 = shape2;
            z14 = z7;
            textStyle4 = textStyle3;
            z15 = z11113;
            modifier3 = modifier10;
            i30 = i29;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.6
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

            public final void invoke(Composer composer3, int i40) {
                TextFieldKt.TextField(value, onValueChange, modifier3, z15, z12, textStyle4, function13, function14, function15, function16, z14, visualTransformation3, keyboardOptions4, keyboardActions4, z13, i30, mutableInteractionSource3, shape3, textFieldColors2, composer3, i2 | 1, i3, i4);
            }
        });
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final boolean z, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112507061);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)376@18854L139,379@19041L7,380@19053L1853:TextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function4) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(function5) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) != 38347922 || !composerStartRestartGroup.getSkipping()) {
            Boolean boolValueOf = Boolean.valueOf(z);
            Float fValueOf = Float.valueOf(f);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(paddingValues);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) objConsume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl, textFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(642667778);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C422@20668L183:TextField.kt#jmzs0o");
            composerStartRestartGroup.startReplaceableGroup(254816194);
            ComposerKt.sourceInformation(composerStartRestartGroup, "384@19161L219");
            if (function4 != null) {
                Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density2 = (Density) objConsume5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume6;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) objConsume7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierThen);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl2 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl2, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl2, density2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl2, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl2, viewConfiguration2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf2.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(822730659);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C388@19353L9:TextField.kt#jmzs0o");
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 12) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(254816479);
            ComposerKt.sourceInformation(composerStartRestartGroup, "392@19447L221");
            if (function5 != null) {
                Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density3 = (Density) objConsume8;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection4 = (LayoutDirection) objConsume9;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) objConsume10;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierThen2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl3 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl3, density3, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl3, layoutDirection4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl3, viewConfiguration3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf3.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1007916070);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C396@19640L10:TextField.kt#jmzs0o");
                function5.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function4 != null) {
                i3 = 0;
                fCalculateStartPadding = Dp.m3843constructorimpl(RangesKt.coerceAtLeast(Dp.m3843constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m3843constructorimpl(0)));
            } else {
                i3 = 0;
            }
            float f2 = fCalculateStartPadding;
            if (function5 != null) {
                fCalculateEndPadding = Dp.m3843constructorimpl(RangesKt.coerceAtLeast(Dp.m3843constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m3843constructorimpl(i3)));
            }
            Modifier modifierM427paddingqDBjuR0$default = PaddingKt.m427paddingqDBjuR0$default(companion, f2, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(254817490);
            ComposerKt.sourceInformation(composerStartRestartGroup, "417@20461L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PlaceholderId).then(modifierM427paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(254817619);
            ComposerKt.sourceInformation(composerStartRestartGroup, "420@20584L57");
            if (function2 != null) {
                Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LabelId).then(modifierM427paddingqDBjuR0$default);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density4 = (Density) objConsume11;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection5 = (LayoutDirection) objConsume12;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localViewConfiguration4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) objConsume13;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierThen3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM1286constructorimpl4 = Updater.m1286constructorimpl(composerStartRestartGroup);
                Updater.m1293setimpl(composerM1286constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1293setimpl(composerM1286constructorimpl4, density4, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1293setimpl(composerM1286constructorimpl4, layoutDirection5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1293setimpl(composerM1286constructorimpl4, viewConfiguration4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                function3MaterializerOf4.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1319246300);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C420@20632L7:TextField.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen4 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TextFieldId).then(modifierM427paddingqDBjuR0$default);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume14 = composerStartRestartGroup.consume(localDensity5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density5 = (Density) objConsume14;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume15 = composerStartRestartGroup.consume(localLayoutDirection6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection6 = (LayoutDirection) objConsume15;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume16 = composerStartRestartGroup.consume(localViewConfiguration5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) objConsume16;
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierThen4);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1286constructorimpl5 = Updater.m1286constructorimpl(composerStartRestartGroup);
            Updater.m1293setimpl(composerM1286constructorimpl5, measurePolicyRememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1293setimpl(composerM1286constructorimpl5, density5, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1293setimpl(composerM1286constructorimpl5, layoutDirection6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1293setimpl(composerM1286constructorimpl5, viewConfiguration5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf5.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-2048931960);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C426@20826L11:TextField.kt#jmzs0o");
            textField.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextFieldLayout.2
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

            public final void invoke(Composer composer2, int i4) {
                TextFieldKt.TextFieldLayout(modifier, textField, function2, function3, function4, function5, z, f, paddingValues, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m1239calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m3801getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1238calculateHeightO3s9Psw(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        float f2 = TextFieldTopPadding * f;
        float top = paddingValues.getTop() * f;
        float bottom = paddingValues.getBottom() * f;
        int iMax = Math.max(i, i5);
        return Math.max(MathKt.roundToInt(z ? i2 + f2 + iMax + bottom : top + iMax + bottom), Math.max(Math.max(i3, i4), Constraints.m3800getMinHeightimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, float f, float f2) {
        int iRoundToInt;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            } else {
                iRoundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), iRoundToInt - MathKt.roundToInt((iRoundToInt - i3) * f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i2) : iRoundToInt, 0.0f, 4, null);
        if (placeable2 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), iRoundToInt, 0.0f, 4, null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        final float width = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt.drawIndicatorLine.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                drawWithContent.drawContent();
                if (Dp.m3848equalsimpl0(width, Dp.INSTANCE.m3861getHairlineD9Ej5fM())) {
                    return;
                }
                float density = width * drawWithContent.getDensity();
                float fM1461getHeightimpl = Size.m1461getHeightimpl(drawWithContent.mo2125getSizeNHjbRc()) - (density / 2);
                DrawScope.m2111drawLine1RTmtNc$default(drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, fM1461getHeightimpl), OffsetKt.Offset(Size.m1464getWidthimpl(drawWithContent.mo2125getSizeNHjbRc()), fM1461getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
